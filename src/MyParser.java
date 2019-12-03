
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MyParser {

    public static boolean matches(String input){
        try{
            SpreadsheetsGrammarLexer lexer = new SpreadsheetsGrammarLexer(CharStreams.fromString(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
            SpreadsheetsGrammarParser parser = new SpreadsheetsGrammarParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
            var expressionTree = parser.expression();
            return true;
        }
        catch (Exception e){
            System.out.println("we have a problem with matching");
            return false;
        }
    }
}
