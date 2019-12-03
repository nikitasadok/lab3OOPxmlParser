import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FormulaAreaKeyListener implements KeyListener {
    ExpressionHelper helper;
    JTextField jTextField;
    ExcelFrame excelFrame;
    FormulaAreaKeyListener(ExpressionHelper helper, JTextField jTextField, ExcelFrame excelFrame){
        this.helper = helper;
        this.jTextField = jTextField;
        this.excelFrame = excelFrame;
    }
    /*@Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            System.err.println("key pressed");
            if (!helper.cycleExists(jTextField.getText(), excelFrame.lastSelected, ) &&
                    !helper.nullReferenceExists(jTextField.getText())) {
                helper.grid.setValueAt(jTextField.getText(), 0,
                        0);
            }
        }
    */

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == keyEvent.VK_ENTER){

        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
