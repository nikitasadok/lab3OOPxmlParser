import javax.accessibility.Accessible;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class SaveFileListener implements ActionListener {
    ExcelFrame frame;
    ExpressionHelper helper;
    LineNumberReader bufferedReader;

    SaveFileListener(ExcelFrame frame, ExpressionHelper helper){
        this.frame = frame;
        this.helper = helper;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            helper.openFile(frame, bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
