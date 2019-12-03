import javax.script.ScriptException;

public class Main {
    public static void main(String args[]) throws ScriptException {
        ExcelFrame frame = new ExcelFrame();
        MyParser lol = new MyParser();
        //ExpressionHelper helper = new ExpressionHelper(frame.grid);

       // helper.checkNullReference("A1+(A2-A3)*MOD(1,2)");
    }
}
