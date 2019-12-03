import jnr.ffi.annotations.In;
import org.antlr.runtime.tree.Tree;

import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaFieldListener implements ActionListener {
    JTextField formulaArea;
    JTable grid;
    ExcelFrame frame;
    TreeMap<String, String> cellToFormula;
    TreeMap<String, ArrayList<String>> cellToDependentCells;
    TreeMap<String, Integer> cellNameToValue;
    Pattern pattern = Pattern.compile("(?=(" + "^[A-Z]{1,3}[0-9]{1,7}" + "))");
    Evaluator evaluator = new Evaluator();
    ExpressionHelper helper;


    public FormulaFieldListener(ExcelFrame frame, JTable grid, TreeMap<String, String> cellToFormula, JTextField formulaArea,
                                TreeMap<String, ArrayList<String>> cellToDependentCells,
                                TreeMap<String, Integer> cellNameToValue) throws ScriptException {
        this.frame = frame;
        this.grid = grid;
        this.cellToFormula = cellToFormula;
        this.formulaArea = formulaArea;
        this.cellToDependentCells = cellToDependentCells;
        this.cellNameToValue = cellNameToValue;
        helper = new ExpressionHelper(grid, cellNameToValue);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (helper.nullReferenceExists(formulaArea.getText(), cellNameToValue)) {
            grid.setValueAt("#Error!", frame.lastSelectedRow, frame.lastSelectedColumn);
            try {
                helper.updateDependentCells(grid, frame.lastSelected, cellToFormula, cellToDependentCells);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            finally {
                cellToFormula.put(frame.lastSelected, formulaArea.getText());
            }
            return;
        }
        if (helper.emptyCellReferenceExists(formulaArea.getText()) || helper.errorCellReferenceExists(formulaArea.getText())){
            grid.setValueAt("#Error!", frame.lastSelectedRow, frame.lastSelectedColumn);
            helper.showInvalidInputMsg();
            cellToFormula.put(frame.lastSelected, formulaArea.getText());
            return;
        }

        if (helper.cycleExists(formulaArea.getText(), frame.lastSelected, cellToFormula)) {
            helper.grid.setValueAt("#Error!", frame.lastSelectedRow, frame.lastSelectedColumn);
            helper.showInvalidInputMsg();
            return;
        }

        if(!MyParser.matches(formulaArea.getText())){
            grid.setValueAt("#Error!", frame.lastSelectedRow, frame.lastSelectedColumn);
            try {
                helper.updateDependentCells(grid, frame.lastSelected, cellToFormula, cellToDependentCells);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            helper.showInvalidInputMsg();
            cellToFormula.put(frame.lastSelected, formulaArea.getText());
            return;
        }

        if (!helper.nullReferenceExists(formulaArea.getText(), cellNameToValue) &&
                MyParser.matches(formulaArea.getText())) {
            try {
                Matcher m = pattern.matcher(formulaArea.getText());
                ArrayList<String> cellNames = new ArrayList<>();
                ArrayList<String> dependentCells = new ArrayList<>();
                while(m.find()){
                    cellNames.add(m.group(1));
                }
                for (String cellName : cellNames) {
                    try{
                        cellToDependentCells.get(cellName).add(frame.lastSelected);
                    }
                    catch (Exception e){
                        cellToDependentCells.put(cellName, new ArrayList<>());
                        cellToDependentCells.get(cellName).add(frame.lastSelected);
                    }
                }
                cellToFormula.put(frame.lastSelected, formulaArea.getText());
                helper.grid.setValueAt(evaluator.evaluate(helper.resolveCellNames(formulaArea.getText(), cellNameToValue)), frame.lastSelectedRow,
                        frame.lastSelectedColumn);
                cellNameToValue.put(frame.lastSelected, Integer.parseInt(evaluator.evaluate(helper.resolveCellNames(formulaArea.getText(), cellNameToValue)).toString()));
                helper.updateDependentCells(grid, frame.lastSelected, cellToFormula, cellToDependentCells);
            } catch (ScriptException e) {
                e.printStackTrace();
                helper.showInvalidInputMsg();
                grid.setValueAt("#Error!", frame.lastSelectedRow, frame.lastSelectedColumn);
            }
        }

    }
}
