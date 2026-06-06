// Generated from c:/Users/lenovo/Downloads/UT/6/PLC/CA/Phase_1/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class simpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MODULE=2, STRUCT=3, BEGIN=4, END=5, INCLUDES=6, PUBLIC=7, PRIVATE=8, 
		MUT=9, RETURN=10, OUTPUT=11, THIS=12, INT=13, FLOAT=14, DOUBLE=15, CHAR=16, 
		BOOL=17, VOID=18, IF=19, ELIF=20, ELSE=21, WHILE=22, FOR=23, BREAK=24, 
		CONTINUE=25, TRUE=26, FALSE=27, SEMI=28, ASSIGN=29, PLUS=30, MINUS=31, 
		MULT=32, DIV=33, MOD=34, DOT=35, LPAR=36, RPAR=37, GT=38, LT=39, GTE=40, 
		LTE=41, EQ=42, NEQ=43, ID=44, INT_VAL=45, WHITE_SPACE=46, LINE_COMMENT=47, 
		BLOCK_COMMENT=48;
	public static final int
		RULE_program = 0, RULE_topLevelDeclaration = 1, RULE_moduleDecl = 2, RULE_structDecl = 3, 
		RULE_moduleBody = 4, RULE_structBody = 5, RULE_fieldDecl = 6, RULE_varDecl = 7, 
		RULE_methodDecl = 8, RULE_paramList = 9, RULE_param = 10, RULE_accessModifier = 11, 
		RULE_type = 12, RULE_statement = 13, RULE_expr = 14, RULE_args = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "topLevelDeclaration", "moduleDecl", "structDecl", "moduleBody", 
			"structBody", "fieldDecl", "varDecl", "methodDecl", "paramList", "param", 
			"accessModifier", "type", "statement", "expr", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'module'", "'struct'", "'begin'", "'end'", "'includes'", 
			"'public'", "'private'", "'mut'", "'return'", "'output'", "'this'", "'int'", 
			"'float'", "'double'", "'char'", "'bool'", "'void'", "'if'", "'elif'", 
			"'else'", "'while'", "'for'", "'break'", "'continue'", "'true'", "'false'", 
			"';'", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "'('", "')'", 
			"'>'", "'<'", "'>='", "'<='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "MODULE", "STRUCT", "BEGIN", "END", "INCLUDES", "PUBLIC", 
			"PRIVATE", "MUT", "RETURN", "OUTPUT", "THIS", "INT", "FLOAT", "DOUBLE", 
			"CHAR", "BOOL", "VOID", "IF", "ELIF", "ELSE", "WHILE", "FOR", "BREAK", 
			"CONTINUE", "TRUE", "FALSE", "SEMI", "ASSIGN", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "DOT", "LPAR", "RPAR", "GT", "LT", "GTE", "LTE", "EQ", 
			"NEQ", "ID", "INT_VAL", "WHITE_SPACE", "LINE_COMMENT", "BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "simpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public simpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(simpleLangParser.EOF, 0); }
		public List<TopLevelDeclarationContext> topLevelDeclaration() {
			return getRuleContexts(TopLevelDeclarationContext.class);
		}
		public TopLevelDeclarationContext topLevelDeclaration(int i) {
			return getRuleContext(TopLevelDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MODULE || _la==STRUCT) {
				{
				{
				setState(32);
				topLevelDeclaration();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelDeclarationContext extends ParserRuleContext {
		public ModuleDeclContext moduleDecl() {
			return getRuleContext(ModuleDeclContext.class,0);
		}
		public StructDeclContext structDecl() {
			return getRuleContext(StructDeclContext.class,0);
		}
		public TopLevelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterTopLevelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitTopLevelDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitTopLevelDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDeclarationContext topLevelDeclaration() throws RecognitionException {
		TopLevelDeclarationContext _localctx = new TopLevelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDeclaration);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				moduleDecl();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				structDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleDeclContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(simpleLangParser.MODULE, 0); }
		public List<TerminalNode> ID() { return getTokens(simpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(simpleLangParser.ID, i);
		}
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public ModuleBodyContext moduleBody() {
			return getRuleContext(ModuleBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public TerminalNode INCLUDES() { return getToken(simpleLangParser.INCLUDES, 0); }
		public ModuleDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterModuleDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitModuleDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitModuleDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleDeclContext moduleDecl() throws RecognitionException {
		ModuleDeclContext _localctx = new ModuleDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_moduleDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(MODULE);
			setState(45);
			match(ID);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INCLUDES) {
				{
				setState(46);
				match(INCLUDES);
				setState(47);
				match(ID);
				}
			}

			setState(50);
			match(BEGIN);
			setState(51);
			moduleBody();
			setState(52);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(simpleLangParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterStructDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitStructDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitStructDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(STRUCT);
			setState(55);
			match(ID);
			setState(56);
			match(BEGIN);
			setState(57);
			structBody();
			setState(58);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleBodyContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public ModuleBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterModuleBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitModuleBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitModuleBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleBodyContext moduleBody() throws RecognitionException {
		ModuleBodyContext _localctx = new ModuleBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186561408L) != 0)) {
				{
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(60);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(61);
					fieldDecl();
					}
					break;
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructBodyContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public StructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructBodyContext structBody() throws RecognitionException {
		StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186561408L) != 0)) {
				{
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(67);
					methodDecl();
					}
					break;
				case 2:
					{
					setState(68);
					fieldDecl();
					}
					break;
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(74);
				accessModifier();
				}
			}

			setState(77);
			varDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public TerminalNode MUT() { return getToken(simpleLangParser.MUT, 0); }
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode ASSIGN() { return getToken(simpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(79);
				match(MUT);
				}
			}

			setState(82);
			type();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(83);
				match(LPAR);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845277614080L) != 0)) {
					{
					setState(84);
					args();
					}
				}

				setState(87);
				match(RPAR);
				}
			}

			setState(90);
			match(ID);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(91);
				match(ASSIGN);
				setState(92);
				expr(0);
				}
			}

			setState(95);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(97);
				accessModifier();
				}
			}

			setState(100);
			type();
			setState(101);
			match(ID);
			setState(102);
			match(LPAR);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186561024L) != 0)) {
				{
				setState(103);
				paramList();
				}
			}

			setState(106);
			match(RPAR);
			setState(107);
			match(BEGIN);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845341572608L) != 0)) {
				{
				{
				setState(108);
				statement();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			param();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(117);
				match(T__0);
				setState(118);
				param();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode MUT() { return getToken(simpleLangParser.MUT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(124);
				match(MUT);
				}
			}

			setState(127);
			type();
			setState(128);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(simpleLangParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(simpleLangParser.PRIVATE, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitAccessModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitAccessModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==PUBLIC || _la==PRIVATE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(simpleLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(simpleLangParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(simpleLangParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(simpleLangParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(simpleLangParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(simpleLangParser.VOID, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186560512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(simpleLangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(simpleLangParser.SEMI, i);
		}
		public TerminalNode RETURN() { return getToken(simpleLangParser.RETURN, 0); }
		public TerminalNode OUTPUT() { return getToken(simpleLangParser.OUTPUT, 0); }
		public TerminalNode IF() { return getToken(simpleLangParser.IF, 0); }
		public List<TerminalNode> LPAR() { return getTokens(simpleLangParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(simpleLangParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(simpleLangParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(simpleLangParser.RPAR, i);
		}
		public List<TerminalNode> BEGIN() { return getTokens(simpleLangParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(simpleLangParser.BEGIN, i);
		}
		public List<TerminalNode> END() { return getTokens(simpleLangParser.END); }
		public TerminalNode END(int i) {
			return getToken(simpleLangParser.END, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(simpleLangParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(simpleLangParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(simpleLangParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(simpleLangParser.WHILE, 0); }
		public TerminalNode FOR() { return getToken(simpleLangParser.FOR, 0); }
		public TerminalNode BREAK() { return getToken(simpleLangParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(simpleLangParser.CONTINUE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				expr(0);
				setState(136);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				match(RETURN);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845277614080L) != 0)) {
					{
					setState(139);
					expr(0);
					}
				}

				setState(142);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(OUTPUT);
				setState(144);
				expr(0);
				setState(145);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				match(IF);
				setState(148);
				match(LPAR);
				setState(149);
				expr(0);
				setState(150);
				match(RPAR);
				setState(151);
				match(BEGIN);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845341572608L) != 0)) {
					{
					{
					setState(152);
					statement();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158);
				match(END);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELIF) {
					{
					{
					setState(159);
					match(ELIF);
					setState(160);
					match(LPAR);
					setState(161);
					expr(0);
					setState(162);
					match(RPAR);
					setState(163);
					match(BEGIN);
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845341572608L) != 0)) {
						{
						{
						setState(164);
						statement();
						}
						}
						setState(169);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(170);
					match(END);
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(177);
					match(ELSE);
					setState(178);
					match(BEGIN);
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845341572608L) != 0)) {
						{
						{
						setState(179);
						statement();
						}
						}
						setState(184);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(185);
					match(END);
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				match(WHILE);
				setState(189);
				match(LPAR);
				setState(190);
				expr(0);
				setState(191);
				match(RPAR);
				setState(192);
				match(BEGIN);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845341572608L) != 0)) {
					{
					{
					setState(193);
					statement();
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(199);
				match(END);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(201);
				match(FOR);
				setState(202);
				match(LPAR);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845277614080L) != 0)) {
					{
					setState(203);
					expr(0);
					}
				}

				setState(206);
				match(SEMI);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845277614080L) != 0)) {
					{
					setState(207);
					expr(0);
					}
				}

				setState(210);
				match(SEMI);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845277614080L) != 0)) {
					{
					setState(211);
					expr(0);
					}
				}

				setState(214);
				match(RPAR);
				setState(215);
				match(BEGIN);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845341572608L) != 0)) {
					{
					{
					setState(216);
					statement();
					}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(222);
				match(END);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(223);
				match(BREAK);
				setState(224);
				match(SEMI);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(225);
				match(CONTINUE);
				setState(226);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode INT_VAL() { return getToken(simpleLangParser.INT_VAL, 0); }
		public TerminalNode THIS() { return getToken(simpleLangParser.THIS, 0); }
		public TerminalNode MULT() { return getToken(simpleLangParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(simpleLangParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(simpleLangParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(simpleLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(simpleLangParser.MINUS, 0); }
		public TerminalNode GT() { return getToken(simpleLangParser.GT, 0); }
		public TerminalNode LT() { return getToken(simpleLangParser.LT, 0); }
		public TerminalNode GTE() { return getToken(simpleLangParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(simpleLangParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(simpleLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(simpleLangParser.NEQ, 0); }
		public TerminalNode ASSIGN() { return getToken(simpleLangParser.ASSIGN, 0); }
		public TerminalNode DOT() { return getToken(simpleLangParser.DOT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(230);
				match(LPAR);
				setState(231);
				expr(0);
				setState(232);
				match(RPAR);
				}
				break;
			case ID:
				{
				setState(234);
				match(ID);
				}
				break;
			case INT_VAL:
				{
				setState(235);
				match(INT_VAL);
				}
				break;
			case THIS:
				{
				setState(236);
				match(THIS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(260);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(240);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(243);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(246);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17317308137472L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(249);
						match(ASSIGN);
						setState(250);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(252);
						match(DOT);
						setState(253);
						match(ID);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(255);
						match(LPAR);
						setState(257);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 52845277614080L) != 0)) {
							{
							setState(256);
							args();
							}
						}

						setState(259);
						match(RPAR);
						}
						break;
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			expr(0);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(266);
				match(T__0);
				setState(267);
				expr(0);
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u0112\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00021\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004"+
		"?\b\u0004\n\u0004\f\u0004B\t\u0004\u0001\u0005\u0001\u0005\u0005\u0005"+
		"F\b\u0005\n\u0005\f\u0005I\t\u0005\u0001\u0006\u0003\u0006L\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0003\u0007Q\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007V\b\u0007\u0001\u0007\u0003\u0007Y\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007^\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0003\bc\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\bi\b\b\u0001\b\u0001\b\u0001\b\u0005\bn\b\b\n\b\f\bq\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0005\tx\b\t\n\t\f\t{\t\t\u0001\n\u0003\n~"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u008d\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u009a\b\r\n\r\f\r\u009d\t\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0005\r\u00a6\b\r\n\r\f\r\u00a9\t\r\u0001\r\u0001"+
		"\r\u0005\r\u00ad\b\r\n\r\f\r\u00b0\t\r\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u00b5\b\r\n\r\f\r\u00b8\t\r\u0001\r\u0003\r\u00bb\b\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c3\b\r\n\r\f\r\u00c6\t\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00cd\b\r\u0001\r\u0001\r\u0003"+
		"\r\u00d1\b\r\u0001\r\u0001\r\u0003\r\u00d5\b\r\u0001\r\u0001\r\u0001\r"+
		"\u0005\r\u00da\b\r\n\r\f\r\u00dd\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00e4\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ee\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0102\b\u000e\u0001\u000e\u0005\u000e\u0105\b\u000e\n\u000e\f\u000e"+
		"\u0108\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u010d\b"+
		"\u000f\n\u000f\f\u000f\u0110\t\u000f\u0001\u000f\u0000\u0001\u001c\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\u0005\u0001\u0000\u0007\b\u0002\u0000\r\u0012,,\u0001"+
		"\u0000 \"\u0001\u0000\u001e\u001f\u0001\u0000&+\u0130\u0000#\u0001\u0000"+
		"\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000"+
		"\u00066\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nG\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eP\u0001\u0000\u0000\u0000"+
		"\u0010b\u0001\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014}"+
		"\u0001\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018\u0084"+
		"\u0001\u0000\u0000\u0000\u001a\u00e3\u0001\u0000\u0000\u0000\u001c\u00ed"+
		"\u0001\u0000\u0000\u0000\u001e\u0109\u0001\u0000\u0000\u0000 \"\u0003"+
		"\u0002\u0001\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000&\'\u0005\u0000\u0000\u0001\'\u0001\u0001"+
		"\u0000\u0000\u0000(+\u0003\u0004\u0002\u0000)+\u0003\u0006\u0003\u0000"+
		"*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0003\u0001\u0000"+
		"\u0000\u0000,-\u0005\u0002\u0000\u0000-0\u0005,\u0000\u0000./\u0005\u0006"+
		"\u0000\u0000/1\u0005,\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u000023\u0005\u0004\u0000\u000034\u0003"+
		"\b\u0004\u000045\u0005\u0005\u0000\u00005\u0005\u0001\u0000\u0000\u0000"+
		"67\u0005\u0003\u0000\u000078\u0005,\u0000\u000089\u0005\u0004\u0000\u0000"+
		"9:\u0003\n\u0005\u0000:;\u0005\u0005\u0000\u0000;\u0007\u0001\u0000\u0000"+
		"\u0000<?\u0003\u0010\b\u0000=?\u0003\f\u0006\u0000><\u0001\u0000\u0000"+
		"\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000A\t\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000CF\u0003\u0010\b\u0000DF\u0003\f\u0006\u0000EC\u0001"+
		"\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u000b\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JL\u0003\u0016\u000b\u0000KJ\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0003\u000e\u0007\u0000N\r\u0001\u0000\u0000\u0000OQ\u0005\t\u0000"+
		"\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RX\u0003\u0018\f\u0000SU\u0005$\u0000\u0000TV\u0003\u001e"+
		"\u000f\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WY\u0005%\u0000\u0000XS\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z]\u0005,\u0000\u0000[\\\u0005"+
		"\u001d\u0000\u0000\\^\u0003\u001c\u000e\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u001c\u0000"+
		"\u0000`\u000f\u0001\u0000\u0000\u0000ac\u0003\u0016\u000b\u0000ba\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"de\u0003\u0018\f\u0000ef\u0005,\u0000\u0000fh\u0005$\u0000\u0000gi\u0003"+
		"\u0012\t\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jk\u0005%\u0000\u0000ko\u0005\u0004\u0000\u0000ln\u0003"+
		"\u001a\r\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000rs\u0005\u0005\u0000\u0000s\u0011\u0001\u0000"+
		"\u0000\u0000ty\u0003\u0014\n\u0000uv\u0005\u0001\u0000\u0000vx\u0003\u0014"+
		"\n\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z\u0013\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000|~\u0005\t\u0000\u0000}|\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0003\u0018\f\u0000\u0080\u0081\u0005,\u0000\u0000\u0081\u0015\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0007\u0000\u0000\u0000\u0083\u0017\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0007\u0001\u0000\u0000\u0085\u0019\u0001"+
		"\u0000\u0000\u0000\u0086\u00e4\u0003\u000e\u0007\u0000\u0087\u0088\u0003"+
		"\u001c\u000e\u0000\u0088\u0089\u0005\u001c\u0000\u0000\u0089\u00e4\u0001"+
		"\u0000\u0000\u0000\u008a\u008c\u0005\n\u0000\u0000\u008b\u008d\u0003\u001c"+
		"\u000e\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u00e4\u0005\u001c"+
		"\u0000\u0000\u008f\u0090\u0005\u000b\u0000\u0000\u0090\u0091\u0003\u001c"+
		"\u000e\u0000\u0091\u0092\u0005\u001c\u0000\u0000\u0092\u00e4\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0005\u0013\u0000\u0000\u0094\u0095\u0005$\u0000"+
		"\u0000\u0095\u0096\u0003\u001c\u000e\u0000\u0096\u0097\u0005%\u0000\u0000"+
		"\u0097\u009b\u0005\u0004\u0000\u0000\u0098\u009a\u0003\u001a\r\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009e\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e"+
		"\u00ae\u0005\u0005\u0000\u0000\u009f\u00a0\u0005\u0014\u0000\u0000\u00a0"+
		"\u00a1\u0005$\u0000\u0000\u00a1\u00a2\u0003\u001c\u000e\u0000\u00a2\u00a3"+
		"\u0005%\u0000\u0000\u00a3\u00a7\u0005\u0004\u0000\u0000\u00a4\u00a6\u0003"+
		"\u001a\r\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005\u0005\u0000\u0000\u00ab\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ac\u009f\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00ba\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\u0015\u0000\u0000\u00b2\u00b6\u0005\u0004"+
		"\u0000\u0000\u00b3\u00b5\u0003\u001a\r\u0000\u00b4\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u0005\u0005\u0000"+
		"\u0000\u00ba\u00b1\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00e4\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u0016\u0000"+
		"\u0000\u00bd\u00be\u0005$\u0000\u0000\u00be\u00bf\u0003\u001c\u000e\u0000"+
		"\u00bf\u00c0\u0005%\u0000\u0000\u00c0\u00c4\u0005\u0004\u0000\u0000\u00c1"+
		"\u00c3\u0003\u001a\r\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u0005\u0000\u0000\u00c8\u00e4"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u0017\u0000\u0000\u00ca\u00cc"+
		"\u0005$\u0000\u0000\u00cb\u00cd\u0003\u001c\u000e\u0000\u00cc\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00d0\u0005\u001c\u0000\u0000\u00cf\u00d1\u0003"+
		"\u001c\u000e\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005"+
		"\u001c\u0000\u0000\u00d3\u00d5\u0003\u001c\u000e\u0000\u00d4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0005%\u0000\u0000\u00d7\u00db\u0005\u0004"+
		"\u0000\u0000\u00d8\u00da\u0003\u001a\r\u0000\u00d9\u00d8\u0001\u0000\u0000"+
		"\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00de\u0001\u0000\u0000"+
		"\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00e4\u0005\u0005\u0000"+
		"\u0000\u00df\u00e0\u0005\u0018\u0000\u0000\u00e0\u00e4\u0005\u001c\u0000"+
		"\u0000\u00e1\u00e2\u0005\u0019\u0000\u0000\u00e2\u00e4\u0005\u001c\u0000"+
		"\u0000\u00e3\u0086\u0001\u0000\u0000\u0000\u00e3\u0087\u0001\u0000\u0000"+
		"\u0000\u00e3\u008a\u0001\u0000\u0000\u0000\u00e3\u008f\u0001\u0000\u0000"+
		"\u0000\u00e3\u0093\u0001\u0000\u0000\u0000\u00e3\u00bc\u0001\u0000\u0000"+
		"\u0000\u00e3\u00c9\u0001\u0000\u0000\u0000\u00e3\u00df\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u001b\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0006\u000e\uffff\uffff\u0000\u00e6\u00e7\u0005$\u0000"+
		"\u0000\u00e7\u00e8\u0003\u001c\u000e\u0000\u00e8\u00e9\u0005%\u0000\u0000"+
		"\u00e9\u00ee\u0001\u0000\u0000\u0000\u00ea\u00ee\u0005,\u0000\u0000\u00eb"+
		"\u00ee\u0005-\u0000\u0000\u00ec\u00ee\u0005\f\u0000\u0000\u00ed\u00e5"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000\u00ed\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee\u0106"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f0\n\u0007\u0000\u0000\u00f0\u00f1\u0007"+
		"\u0002\u0000\u0000\u00f1\u0105\u0003\u001c\u000e\b\u00f2\u00f3\n\u0006"+
		"\u0000\u0000\u00f3\u00f4\u0007\u0003\u0000\u0000\u00f4\u0105\u0003\u001c"+
		"\u000e\u0007\u00f5\u00f6\n\u0005\u0000\u0000\u00f6\u00f7\u0007\u0004\u0000"+
		"\u0000\u00f7\u0105\u0003\u001c\u000e\u0006\u00f8\u00f9\n\u0004\u0000\u0000"+
		"\u00f9\u00fa\u0005\u001d\u0000\u0000\u00fa\u0105\u0003\u001c\u000e\u0004"+
		"\u00fb\u00fc\n\t\u0000\u0000\u00fc\u00fd\u0005#\u0000\u0000\u00fd\u0105"+
		"\u0005,\u0000\u0000\u00fe\u00ff\n\b\u0000\u0000\u00ff\u0101\u0005$\u0000"+
		"\u0000\u0100\u0102\u0003\u001e\u000f\u0000\u0101\u0100\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000"+
		"\u0000\u0103\u0105\u0005%\u0000\u0000\u0104\u00ef\u0001\u0000\u0000\u0000"+
		"\u0104\u00f2\u0001\u0000\u0000\u0000\u0104\u00f5\u0001\u0000\u0000\u0000"+
		"\u0104\u00f8\u0001\u0000\u0000\u0000\u0104\u00fb\u0001\u0000\u0000\u0000"+
		"\u0104\u00fe\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000"+
		"\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000"+
		"\u0107\u001d\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000"+
		"\u0109\u010e\u0003\u001c\u000e\u0000\u010a\u010b\u0005\u0001\u0000\u0000"+
		"\u010b\u010d\u0003\u001c\u000e\u0000\u010c\u010a\u0001\u0000\u0000\u0000"+
		"\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u001f\u0001\u0000\u0000\u0000"+
		"\u0110\u010e\u0001\u0000\u0000\u0000\"#*0>@EGKPUX]bhoy}\u008c\u009b\u00a7"+
		"\u00ae\u00b6\u00ba\u00c4\u00cc\u00d0\u00d4\u00db\u00e3\u00ed\u0101\u0104"+
		"\u0106\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}