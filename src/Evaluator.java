import javax.script.*;

public class Evaluator {
    ScriptEngineManager factory;
    ScriptEngine engine;

    private final String helperFuncs = "import sys\n\n" + "def DIV(a,b):\n" + "    " + "return a//b\n\ndef MOD(a,b):\n" +
            "    " + "return a%b\n\n" +
            "def INC(a):\n" + "    " + "a+=1\n" + "    " + "return a\n\n" + "def DEC(a):\n" + "    " +
            "a-=1\n" + "    " + "return a\n\n";

    Evaluator() throws ScriptException {
        factory = new ScriptEngineManager();
        engine = factory.getEngineByName("python");
        engine.eval(helperFuncs);
    }

    Object evaluate(String expression) throws ScriptException {
        System.out.println(expression);
        return engine.eval(expression.replaceAll("\\^", "**"));
    }






}
