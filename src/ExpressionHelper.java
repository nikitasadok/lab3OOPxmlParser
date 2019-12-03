import jnr.ffi.annotations.In;
import org.antlr.runtime.tree.Tree;

import javax.print.DocFlavor;
import javax.script.ScriptException;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHelper {
    JTable grid;
    Evaluator eval;
    TreeMap<String,Integer> cellNameToValue;
    ExpressionHelper(JTable grid, TreeMap<String, Integer> cellNameToValue) throws ScriptException {
        this.grid = grid;
        this.cellNameToValue = cellNameToValue;
        eval = new Evaluator();
    }

    boolean emptyCellReferenceExists(String input){
        Matcher m = Pattern.compile("(?=(" + "^[A-Z]{1,3}[0-9]{1,7}" + "))").matcher(input);
        List<String> cellNames = new ArrayList<>();
        while(m.find()){
            cellNames.add(m.group(1));
        }

        for (String name : cellNames){
            if (getValueAt(name) == null){
                return true;
            }
        }
        return false;
    }

    boolean nullReferenceExists(String input, TreeMap<String, Integer> cellNameToValue){
        input = resolveCellNames(input, cellNameToValue);
        try {
            eval.evaluate(input);
            return false;
        } catch (ScriptException e) {
            e.printStackTrace();
            return true;
        }
       /* Matcher m = Pattern.compile("(?=(" + "^[a-zA-Z]+[0-9]+" + "))").matcher(input);
        List<String> cellNames  = new ArrayList<>();
        while (m.find()){
            cellNames.add(m.group(1));
        }

        for (String name : cellNames){
            try {
                getValueAt(name);
                return false;
            }
            catch (Exception e){
                return true;
            }
        }
        return false;*/
    }

    boolean errorCellReferenceExists(String input){
        Matcher m = Pattern.compile("(?=(" + "^[a-zA-Z]+[0-9]+" + "))").matcher(input);
        List<String> cellNames  = new ArrayList<>();
        while (m.find()) {
            cellNames.add(m.group(1));
        }
        for(String cellName : cellNames){
            if (getValueAt(cellName).equals("#Error!")) return true;
        }
        return false;

    }
    boolean cycleExists(String currentCell, String initialCell, TreeMap<String,String> cellToFormula){
        if (currentCell == null){
            return false;
        }
        Matcher m = Pattern.compile("(?=(" + "^[a-zA-Z]+[0-9]+" + "))").matcher(currentCell);
        List<String> cellNames  = new ArrayList<>();
        while (m.find()) {
            cellNames.add(m.group(1));
        }
        if (cellNames.contains(initialCell)){
            return true;
        }
        for(String cellName : cellNames){
            if (cycleExists(cellToFormula.get(cellName), initialCell,cellToFormula)){
                return true;
            };
        }
        return false;
    }

    String resolveCellNames(String input, TreeMap<String, Integer> cellNameToValue){
        String modifiedInput = input;
        for (Map.Entry<String, Integer> entry : cellNameToValue.entrySet()){
            modifiedInput = modifiedInput.replaceAll(entry.getKey(), entry.getValue().toString());
        }


       /* Matcher m = Pattern.compile("(?=(" + "^[a-zA-Z]+[0-9]+" + "))").matcher(input);
        List<String> cellNames  = new ArrayList<>();
        String modifiedInput = input;

        while (m.find()){
            System.out.println(m.group(1));
            cellNames.add(m.group(1));
        }

        for (String cellName : cellNames){
            modifiedInput = modifiedInput.replaceAll(cellName, getValueAt(cellName).toString());
        }
        */
        return modifiedInput;

    }

    Object getValueAt(String cellID){
        String[] parts = cellID.split("(?<=\\D)(?=\\d)");
        Object value = grid.getValueAt(Integer.parseInt(parts[1]) - 1,getColumnNumber(parts[0]) - 1);
        return value;
    }

    void updateDependentCells(JTable grid, String cellName, TreeMap<String, String> cellToFormula,
                              TreeMap<String,ArrayList<String>> cellToDependentCells) throws ScriptException {
        if(getValueAt(cellName).equals("#Error!")){
            System.out.println("we are here in #Error!");
            for (String cell : cellToDependentCells.get(cellName)){
                System.out.println(cell);
                String[] parts = cell.split("(?<=\\D)(?=\\d)");
                grid.setValueAt("#Error!",Integer.parseInt(parts[1]) - 1,
                        getColumnNumber(parts[0]) - 1);
            }
            return;
        }
        try{
        for (String cell : cellToDependentCells.get(cellName)) {
            String[] parts = cell.split("(?<=\\D)(?=\\d)");
            grid.setValueAt(eval.evaluate(resolveCellNames(cellToFormula.get(cell), cellNameToValue)), Integer.parseInt(parts[1]) - 1,
                    getColumnNumber(parts[0]) - 1);
            updateDependentCells(grid, cell, cellToFormula, cellToDependentCells);

        }
        }
        catch (NullPointerException exp){}
    }

        void eraseDataFromRemovedCol(String colName, TreeMap<String, String> cellToFormula,
                                     TreeMap <String, ArrayList<String>> cellToDependentCells) {
            String pattern = colName + "[0-9]+";
            System.out.println(colName);
            Pattern p = Pattern.compile(pattern);

            Iterator<Map.Entry<String,String>> it  = cellToFormula.entrySet().iterator();

            while(it.hasNext()){
                Map.Entry<String,String> entry = it.next();
                if (p.matcher(entry.getKey()).find()){
                    it.remove();
                }
            }

            Iterator<Map.Entry<String, ArrayList<String>>> iter = cellToDependentCells.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, ArrayList<String>> entry = iter.next();
                if (p.matcher(entry.getKey()).find()){
                    iter.remove();
                }
            }

            Iterator<Map.Entry<String, Integer>> i = cellNameToValue.entrySet().iterator();
            while(i.hasNext()){
                Map.Entry<String, Integer> entry = i.next();
                if (p.matcher(entry.getKey()).find()){
                    i.remove();
                }
            }
    }
    void eraseDataFromRemovedRow(int rowNum, TreeMap<String, String> cellToFormula,
                                 TreeMap<String, ArrayList<String>> cellToDependentCells){

        Iterator<Map.Entry<String,String>> it  = cellToFormula.entrySet().iterator();

        Integer wrappedRowNum = (Integer)rowNum;

        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String[] parts = entry.getKey().split("(?<=\\D)(?=\\d)");
            if (parts[1].equals(wrappedRowNum.toString())){
                it.remove();
            }
        }

        Iterator<Map.Entry<String,ArrayList<String>>> iter  = cellToDependentCells.entrySet().iterator();

        while (iter.hasNext()){
            Map.Entry<String, ArrayList<String>> entry = iter.next();
            String[] parts = entry.getKey().split("(?<=\\D)(?=\\d)");
            if (parts[1].equals(wrappedRowNum.toString())){
                it.remove();
            }
        }

        Iterator<Map.Entry<String, Integer>> i = cellNameToValue.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            String[] parts = entry.getKey().split("(?<=\\D)(?=\\d)");
            if (parts[1].equals((wrappedRowNum.toString()))){
                i.remove();
            }
        }
    }

    void revalidateTable(JTable grid,TreeMap<String, String> cellToFormula) throws ScriptException {
        for (Map.Entry<String, String> entry : cellToFormula.entrySet()){
            String[] parts = entry.getKey().split("(?<=\\D)(?=\\d)");
            if (nullReferenceExists(entry.getValue(), cellNameToValue)){
                grid.setValueAt("#Error!", Integer.parseInt(parts[1]) - 1, getColumnNumber(parts[0]) - 1);
            }
            try{
            grid.setValueAt(eval.evaluate(resolveCellNames(entry.getValue(), cellNameToValue)), Integer.parseInt(parts[1]) -1, getColumnNumber(parts[0]) - 1);
            }
            catch (ScriptException e){

            }
        }

    }

    void showInvalidInputMsg(){
        JOptionPane.showMessageDialog(null, "Invalid input! Please try again!");
    }

    void saveFile(ExcelFrame frame, TreeMap<String, String> cellToFormula,
                  TreeMap<String, ArrayList<String>> cellToDependentCells) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            FileWriter fw = new FileWriter(fileToSave.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(grid.getRowCount() + " " + grid.getColumnCount() + "\n");

            for (Map.Entry<String, String> entry : cellToFormula.entrySet()){
                bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            bw.write("---------------------------------------------------------------" + "\n");
            for (Map.Entry<String, ArrayList<String>> entry : cellToDependentCells.entrySet()){
                bw.write(entry.getKey() + " ");
                for (String cell : entry.getValue()){
                    bw.write(cell + " ");
                }
                bw.write("\n");
            }
            bw.close();
            fw.close();
        }
    }

    void openFile(ExcelFrame frame, LineNumberReader lineNumberReader) throws IOException, ScriptException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to open");

        int userSelection = fileChooser.showOpenDialog(frame);
        File fileToOpen = fileChooser.getSelectedFile();



        String[] size = new String[2];
        lineNumberReader = new LineNumberReader(new FileReader(fileToOpen.getAbsolutePath()));
        size = lineNumberReader.readLine().split("\\s++");
        ExcelFrame newFrame = new ExcelFrame(Integer.parseInt(size[1]), Integer.parseInt(size[0]), lineNumberReader);
    }



    int getColumnNumber(String colName){
        final int SUB = 64;
        final int BASE = 26;
        int sum = 0;
        for (int i = 0; i < colName.length(); ++i){
          int repres = colName.charAt(i);
          repres-=SUB;
          int val = (int) (repres * Math.pow(BASE, colName.length() - i - 1));
          sum+=val;
        }
        return sum;
    }
}
