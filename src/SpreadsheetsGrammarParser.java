// Generated from /home/nikita/IdeaProjects/MyExcel/src/SpreadsheetsGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpreadsheetsGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ASTERISK=9, 
		SLASH=10, PLUS=11, MINUS=12, ID=13, NAME=14, NUMBER=15, WHITESPACE=16;
	public static final int
		RULE_expression = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'^'", "'DEC'", "'INC'", "'MOD'", "'DIV'", "','", 
			"'*'", "'/'", "'+'", "'-'", null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "ASTERISK", "SLASH", 
			"PLUS", "MINUS", "ID", "NAME", "NUMBER", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SpreadsheetsGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpreadsheetsGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ModDivExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModDivExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterModDivExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitModDivExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitModDivExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericAtomExpContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(SpreadsheetsGrammarParser.NUMBER, 0); }
		public NumericAtomExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterNumericAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitNumericAtomExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitNumericAtomExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowerExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterPowerExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitPowerExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitPowerExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(SpreadsheetsGrammarParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SpreadsheetsGrammarParser.SLASH, 0); }
		public MulDivExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterMulDivExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitMulDivExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitMulDivExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterParenthesisExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitParenthesisExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitParenthesisExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecIncExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DecIncExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterDecIncExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitDecIncExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitDecIncExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdAtomExpContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(SpreadsheetsGrammarParser.ID, 0); }
		public IdAtomExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterIdAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitIdAtomExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitIdAtomExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(SpreadsheetsGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SpreadsheetsGrammarParser.MINUS, 0); }
		public AddSubExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).enterAddSubExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadsheetsGrammarListener ) ((SpreadsheetsGrammarListener)listener).exitAddSubExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadsheetsGrammarVisitor ) return ((SpreadsheetsGrammarVisitor<? extends T>)visitor).visitAddSubExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new ParenthesisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(T__0);
				setState(4);
				expression(0);
				setState(5);
				match(T__1);
				}
				break;
			case T__3:
			case T__4:
				{
				_localctx = new DecIncExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(8);
				match(T__0);
				setState(9);
				expression(0);
				setState(10);
				match(T__1);
				}
				break;
			case T__5:
			case T__6:
				{
				_localctx = new ModDivExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(13);
				match(T__0);
				setState(14);
				expression(0);
				setState(15);
				match(T__7);
				setState(16);
				expression(0);
				setState(17);
				match(T__1);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumericAtomExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(NUMBER);
				}
				break;
			case ID:
				{
				_localctx = new IdAtomExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(32);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(23);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(24);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==SLASH) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(25);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(26);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(27);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(28);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new PowerExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(29);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(30);
						match(T__2);
						setState(31);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22(\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\30\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2#\n\2\f\2\16\2&\13"+
		"\2\3\2\2\3\2\3\2\2\6\3\2\6\7\3\2\b\t\3\2\13\f\3\2\r\16\2-\2\27\3\2\2\2"+
		"\4\5\b\2\1\2\5\6\7\3\2\2\6\7\5\2\2\2\7\b\7\4\2\2\b\30\3\2\2\2\t\n\t\2"+
		"\2\2\n\13\7\3\2\2\13\f\5\2\2\2\f\r\7\4\2\2\r\30\3\2\2\2\16\17\t\3\2\2"+
		"\17\20\7\3\2\2\20\21\5\2\2\2\21\22\7\n\2\2\22\23\5\2\2\2\23\24\7\4\2\2"+
		"\24\30\3\2\2\2\25\30\7\21\2\2\26\30\7\17\2\2\27\4\3\2\2\2\27\t\3\2\2\2"+
		"\27\16\3\2\2\2\27\25\3\2\2\2\27\26\3\2\2\2\30$\3\2\2\2\31\32\f\t\2\2\32"+
		"\33\t\4\2\2\33#\5\2\2\n\34\35\f\b\2\2\35\36\t\5\2\2\36#\5\2\2\t\37 \f"+
		"\7\2\2 !\7\5\2\2!#\5\2\2\7\"\31\3\2\2\2\"\34\3\2\2\2\"\37\3\2\2\2#&\3"+
		"\2\2\2$\"\3\2\2\2$%\3\2\2\2%\3\3\2\2\2&$\3\2\2\2\5\27\"$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}