// Generated from /home/nikita/IdeaProjects/MyExcel/src/SpreadsheetsGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpreadsheetsGrammarParser}.
 */
public interface SpreadsheetsGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code modDivExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModDivExp(SpreadsheetsGrammarParser.ModDivExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modDivExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModDivExp(SpreadsheetsGrammarParser.ModDivExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericAtomExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumericAtomExp(SpreadsheetsGrammarParser.NumericAtomExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericAtomExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumericAtomExp(SpreadsheetsGrammarParser.NumericAtomExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExp(SpreadsheetsGrammarParser.PowerExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExp(SpreadsheetsGrammarParser.PowerExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExp(SpreadsheetsGrammarParser.MulDivExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExp(SpreadsheetsGrammarParser.MulDivExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExp(SpreadsheetsGrammarParser.ParenthesisExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExp(SpreadsheetsGrammarParser.ParenthesisExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decIncExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecIncExp(SpreadsheetsGrammarParser.DecIncExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decIncExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecIncExp(SpreadsheetsGrammarParser.DecIncExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtomExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdAtomExp(SpreadsheetsGrammarParser.IdAtomExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtomExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdAtomExp(SpreadsheetsGrammarParser.IdAtomExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExp(SpreadsheetsGrammarParser.AddSubExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExp(SpreadsheetsGrammarParser.AddSubExpContext ctx);
}