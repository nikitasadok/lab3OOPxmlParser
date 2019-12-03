// Generated from /home/nikita/IdeaProjects/MyExcel/src/SpreadsheetsGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpreadsheetsGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpreadsheetsGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code modDivExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModDivExp(SpreadsheetsGrammarParser.ModDivExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericAtomExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericAtomExp(SpreadsheetsGrammarParser.NumericAtomExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExp(SpreadsheetsGrammarParser.PowerExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExp(SpreadsheetsGrammarParser.MulDivExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExp(SpreadsheetsGrammarParser.ParenthesisExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decIncExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecIncExp(SpreadsheetsGrammarParser.DecIncExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtomExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtomExp(SpreadsheetsGrammarParser.IdAtomExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link SpreadsheetsGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExp(SpreadsheetsGrammarParser.AddSubExpContext ctx);
}