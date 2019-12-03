import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuButtonListener implements ActionListener {
    ExcelFrame frame;
    ExpressionHelper helper;

    MenuButtonListener(ExcelFrame frame, ExpressionHelper helper){
        this.frame = frame;
        this.helper = helper;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            helper.saveFile(frame, frame.cellToFormula, frame.cellToDependentCells);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
