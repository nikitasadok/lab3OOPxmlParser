// Generated from /home/nikita/IdeaProjects/MyExcel/src/SpreadsheetsGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpreadsheetsGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ASTERISK=9, 
		SLASH=10, PLUS=11, MINUS=12, ID=13, NAME=14, NUMBER=15, WHITESPACE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "LETTER", 
			"DIGIT", "ASTERISK", "SLASH", "PLUS", "MINUS", "ID", "NAME", "NUMBER", 
			"WHITESPACE"
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


	public SpreadsheetsGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SpreadsheetsGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\6\20M\n\20\r\20\16\20N\3\20\6\20R\n\20\r\20"+
		"\16\20S\3\21\6\21W\n\21\r\21\16\21X\3\22\6\22\\\n\22\r\22\16\22]\3\22"+
		"\3\22\6\22b\n\22\r\22\16\22c\5\22f\n\22\3\23\3\23\3\23\3\23\2\2\24\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\13\31\f\33\r\35\16\37\17"+
		"!\20#\21%\22\3\2\4\4\2C\\c|\3\2\62;\2n\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2"+
		"\2\13\61\3\2\2\2\r\65\3\2\2\2\179\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25A"+
		"\3\2\2\2\27C\3\2\2\2\31E\3\2\2\2\33G\3\2\2\2\35I\3\2\2\2\37L\3\2\2\2!"+
		"V\3\2\2\2#[\3\2\2\2%g\3\2\2\2\'(\7*\2\2(\4\3\2\2\2)*\7+\2\2*\6\3\2\2\2"+
		"+,\7`\2\2,\b\3\2\2\2-.\7F\2\2./\7G\2\2/\60\7E\2\2\60\n\3\2\2\2\61\62\7"+
		"K\2\2\62\63\7P\2\2\63\64\7E\2\2\64\f\3\2\2\2\65\66\7O\2\2\66\67\7Q\2\2"+
		"\678\7F\2\28\16\3\2\2\29:\7F\2\2:;\7K\2\2;<\7X\2\2<\20\3\2\2\2=>\7.\2"+
		"\2>\22\3\2\2\2?@\t\2\2\2@\24\3\2\2\2AB\t\3\2\2B\26\3\2\2\2CD\7,\2\2D\30"+
		"\3\2\2\2EF\7\61\2\2F\32\3\2\2\2GH\7-\2\2H\34\3\2\2\2IJ\7/\2\2J\36\3\2"+
		"\2\2KM\5\23\n\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PR\5"+
		"\25\13\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T \3\2\2\2UW\5\23\n\2"+
		"VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\"\3\2\2\2Z\\\5\25\13\2[Z\3\2"+
		"\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^e\3\2\2\2_a\7\60\2\2`b\5\25\13\2a"+
		"`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2e_\3\2\2\2ef\3\2\2\2"+
		"f$\3\2\2\2gh\7\"\2\2hi\3\2\2\2ij\b\23\2\2j&\3\2\2\2\t\2NSX]ce\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}