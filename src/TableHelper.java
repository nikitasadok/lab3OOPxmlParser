import org.python.antlr.ast.Str;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;

public class TableHelper {
    JTable grid;
    TableHelper(JTable grid){
        this.grid = grid;
    }

    public void getDataFromFile(File file, JTable table){
        String[] colNames = new String[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount(); ++i){
            colNames[i] = table.getColumnName(i);
        }
        DefaultTableModel model = new DefaultTableModel(colNames, 0);


    }
}
