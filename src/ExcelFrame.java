// todo: адекватные пересчеты при создании новой таблицы (апдейт депендент селлс + ревалидейт табле),
// сохранение формулы, если она некорректна
import org.python.antlr.ast.Str;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.script.*;

public class ExcelFrame extends JFrame {
    String lastSelected = null;
    TreeMap<String, String> cellToFormula = new TreeMap<>();
    TreeMap<String, ArrayList<String>> cellToDependentCells = new TreeMap<>();
    TreeMap<String, Integer> cellNameToValue = new TreeMap<>();
    int lastSelectedRow, lastSelectedColumn;
    JTable grid;
    ExpressionHelper helper;
    JLabel currentCell;
    JTable rowNumberTable;
    JSplitPane mainSplitPane, bottomSplitPane, mainBottomSplitPane, buttonSplitPane, anotherSplitPane, removeSplitPane, labelAndTextFieldSplitPane;
    JButton addRow, addColumn, setValue, removeColumn, removeRow;
    JTextField formulaArea;
    DefaultTableModel model;
    JMenuBar menuBar;
    JMenu file;

    JMenuItem save, open, setVal;

    ExcelFrame() throws ScriptException {
        initializeFrame(100,100);
    }

    ExcelFrame(int colNum, int rowNum, LineNumberReader bufferedReader) throws ScriptException, IOException {
        initializeFrame(rowNum, colNum);
        String line;
        ArrayList<String> forLatterEval = new ArrayList<>();
        int linenum = 2;
        bufferedReader.setLineNumber(linenum);
        while(!(line = bufferedReader.readLine()).contains("----")){
            String[] temp = line.split("\\s++");
            cellToFormula.put(temp[0], temp[1]);
            linenum++;
        }
        bufferedReader.setLineNumber(linenum + 1);
        while((line = bufferedReader.readLine())!= null){
            String[] temp = line.split("\\s++");
            ArrayList<String> dependentCells = new ArrayList<>();
            cellToDependentCells.put(temp[0], dependentCells);
            for (int i = 1; i < temp.length; ++i){
                cellToDependentCells.get(temp[0]).add(temp[i]);
            }
        }

        System.out.println(cellToDependentCells.get("A1"));

        for (Map.Entry<String, String> entry : cellToFormula.entrySet()){
            String[] parts = entry.getKey().split("(?<=\\D)(?=\\d)");
            try{
               grid.setValueAt(helper.eval.evaluate(entry.getValue()), Integer.parseInt(parts[1]) - 1,
                       helper.getColumnNumber(parts[0]) - 1);
            }
            catch (Exception e){
                forLatterEval.add(entry.getKey());
                continue;
            }
        }

        for(String cell : forLatterEval){
            helper.updateDependentCells(grid, cell, cellToFormula, cellToDependentCells);
        }


    }

    public void storeTableModel(DefaultTableModel model) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("/home/nikita/excelstate"));
            oos.writeObject(model.getDataVector());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                }
        }
    }

    private void revalidateTable() throws ScriptException {
        helper.revalidateTable(grid, cellToFormula);

    }


    private void initializeFrame(int rowCount, int columnCount) throws ScriptException {
        model = new DefaultTableModel(rowCount, columnCount){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        for (int i = 0; i < model.getColumnCount(); ++i){
            for (int j = 0; j < model.getRowCount(); ++j){
                model.isCellEditable(i,j);
            }
        }
        grid = new JTable(model);
        menuBar = new JMenuBar();
        Evaluator evaluator = new Evaluator();
        helper = new ExpressionHelper(grid, cellNameToValue);
        rowNumberTable = new RowNumberTable(grid);
        TableColumnModel columnModel = grid.getColumnModel();


        for (int i = 0; i < grid.getColumnCount(); ++i) {
            columnModel.getColumn(i).setWidth(400);
        }
        grid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        grid.setRowSelectionAllowed(false);

        grid.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastSelected = grid.getColumnName(grid.getSelectedColumn()) +
                        (grid.getSelectedRow() + 1);
                lastSelectedColumn = grid.getSelectedColumn();
                lastSelectedRow = grid.getSelectedRow();
                currentCell.setText(lastSelected);
                formulaArea.setText(cellToFormula.get(lastSelected));
            }
        });

        grid.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setRowHeaderView(rowNumberTable);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
                rowNumberTable.getTableHeader());
        this.add(scrollPane, BorderLayout.NORTH);

        file = new JMenu("File");
        menuBar.add(file);

        save = new JMenuItem("Save");

        file.add(save);

        save.addActionListener(new MenuButtonListener(this, helper));

        open = new JMenuItem("Open");

        setVal = new JMenuItem("Set Value");

        file.add(setVal);

        file.add(open);

        open.addActionListener(new SaveFileListener(this,helper));
        open.addActionListener(new SaveFileListener(this,helper));

        this.setJMenuBar(menuBar);


        addRow = new JButton("Add row");
        addRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.addRow((Object[]) null);
            }
        });
        addColumn = new JButton("Add column");
        addColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.addColumn(null);
            }
        });

        removeRow = new JButton("Remove row");
        removeRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeRow(grid.getRowCount() - 1);
                helper.eraseDataFromRemovedRow(grid.getRowCount() + 1, cellToFormula, cellToDependentCells);
                try {
                    helper.revalidateTable(grid, cellToFormula);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }

        });
        removeColumn = new JButton("Remove column");

        removeColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setColumnCount(grid.getColumnCount() - 1);
                helper.eraseDataFromRemovedCol(model.getColumnName(grid.getColumnCount()), cellToFormula,
                        cellToDependentCells);
                try {
                    helper.revalidateTable(grid, cellToFormula);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }

            }
        });


        currentCell = new JLabel(lastSelected);
        currentCell.setFont(new Font("Verdana", Font.BOLD, 20));


        formulaArea = new JTextField();

        formulaArea.setFont(new Font("Verdana", Font.BOLD, 20));



        setValue = new JButton("Set Value");
        setValue.addActionListener(new FormulaFieldListener(this, grid, cellToFormula, formulaArea,
                cellToDependentCells, cellNameToValue));

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storeTableModel((DefaultTableModel) grid.getModel());
            }
        });

        setVal.addActionListener(new FormulaFieldListener(this, grid, cellToFormula, formulaArea,
                cellToDependentCells, cellNameToValue));

        buttonSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, setValue, addRow);
        buttonSplitPane.setResizeWeight(0.5);
        anotherSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, addColumn, removeRow);
        anotherSplitPane.setResizeWeight(0.5);
        removeSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, anotherSplitPane, removeColumn);
        removeSplitPane.setResizeWeight(2. / 3.);
        bottomSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonSplitPane, removeSplitPane);
        bottomSplitPane.setResizeWeight(0.4);
        labelAndTextFieldSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,currentCell, formulaArea);
        labelAndTextFieldSplitPane.setResizeWeight(0.2);
        mainBottomSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bottomSplitPane, labelAndTextFieldSplitPane);
        mainBottomSplitPane.setResizeWeight(0.8);
        mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, mainBottomSplitPane);
        mainSplitPane.setResizeWeight(0.8);
        this.add(mainSplitPane);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500, 500));
        this.setVisible(true);
    }
}