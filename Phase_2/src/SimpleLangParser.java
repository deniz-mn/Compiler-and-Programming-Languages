// Generated from src/main/grammar/SimpleLang.g4 by ANTLR 4.13.1

import main.ast.core.*;
import main.ast.declarations.*;
import main.ast.statements.*;
import main.ast.expressions.*;
import main.ast.expressions.literals.*;
import main.ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_MODULE=1, KW_STRUCT=2, KW_INCLUDES=3, KW_BEGIN=4, KW_END=5, KW_PUBLIC=6, 
		KW_PRIVATE=7, KW_INT=8, KW_FLOAT=9, KW_DOUBLE=10, KW_CHAR=11, KW_VOID=12, 
		KW_IF=13, KW_ELSE=14, KW_FOR=15, KW_WHILE=16, KW_DO=17, KW_RETURN=18, 
		KW_INPUT=19, KW_OUTPUT=20, KW_THIS=21, KW_NOT=22, KW_AND=23, KW_OR=24, 
		KW_MUT=25, KW_BREAK=26, KW_CONTINUE=27, KW_BOOL=28, CONSTBOOL=29, SEMI=30, 
		COMMA=31, LPAREN=32, RPAREN=33, LBRACK=34, RBRACK=35, ASSIGN=36, DOT=37, 
		ARROW=38, MINUS=39, PLUS=40, STAR=41, SLASH=42, AMPERSAND=43, LESS=44, 
		GREATER=45, LESS_EQ=46, GREATER_EQ=47, EQUAL=48, NOT_EQUAL=49, CONSTINT=50, 
		CONSTFLOAT=51, CONSTDOUBLE=52, CONSTCHAR=53, ID=54, WS=55, COMMENT=56, 
		MULTICOMMENT=57;
	public static final int
		RULE_program = 0, RULE_topLevelDecl = 1, RULE_module = 2, RULE_structDef = 3, 
		RULE_member = 4, RULE_accessModifier = 5, RULE_method_decl = 6, RULE_arguments = 7, 
		RULE_parameter = 8, RULE_type = 9, RULE_vardecl = 10, RULE_cons = 11, 
		RULE_block = 12, RULE_st = 13, RULE_jumpStmt = 14, RULE_ifStmt = 15, RULE_forStmt = 16, 
		RULE_whileStmt = 17, RULE_assignStmt = 18, RULE_returnStmt = 19, RULE_inputStmt = 20, 
		RULE_outputStmt = 21, RULE_loc = 22, RULE_methodcall = 23, RULE_callArgs = 24, 
		RULE_expr = 25, RULE_atom = 26, RULE_binOp = 27, RULE_initexpr = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "topLevelDecl", "module", "structDef", "member", "accessModifier", 
			"method_decl", "arguments", "parameter", "type", "vardecl", "cons", "block", 
			"st", "jumpStmt", "ifStmt", "forStmt", "whileStmt", "assignStmt", "returnStmt", 
			"inputStmt", "outputStmt", "loc", "methodcall", "callArgs", "expr", "atom", 
			"binOp", "initexpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'module'", "'struct'", "'includes'", "'begin'", "'end'", "'public'", 
			"'private'", "'int'", "'float'", "'double'", "'char'", "'void'", "'if'", 
			"'else'", "'for'", "'while'", "'do'", "'return'", "'input'", "'output'", 
			"'this'", "'not'", "'and'", "'or'", "'mut'", "'break'", "'continue'", 
			"'bool'", null, "';'", "','", "'('", "')'", "'['", "']'", "'='", "'.'", 
			"'->'", "'-'", "'+'", "'*'", "'/'", "'&'", "'<'", "'>'", "'<='", "'>='", 
			"'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_MODULE", "KW_STRUCT", "KW_INCLUDES", "KW_BEGIN", "KW_END", 
			"KW_PUBLIC", "KW_PRIVATE", "KW_INT", "KW_FLOAT", "KW_DOUBLE", "KW_CHAR", 
			"KW_VOID", "KW_IF", "KW_ELSE", "KW_FOR", "KW_WHILE", "KW_DO", "KW_RETURN", 
			"KW_INPUT", "KW_OUTPUT", "KW_THIS", "KW_NOT", "KW_AND", "KW_OR", "KW_MUT", 
			"KW_BREAK", "KW_CONTINUE", "KW_BOOL", "CONSTBOOL", "SEMI", "COMMA", "LPAREN", 
			"RPAREN", "LBRACK", "RBRACK", "ASSIGN", "DOT", "ARROW", "MINUS", "PLUS", 
			"STAR", "SLASH", "AMPERSAND", "LESS", "GREATER", "LESS_EQ", "GREATER_EQ", 
			"EQUAL", "NOT_EQUAL", "CONSTINT", "CONSTFLOAT", "CONSTDOUBLE", "CONSTCHAR", 
			"ID", "WS", "COMMENT", "MULTICOMMENT"
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
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public TopLevelDeclContext t;
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public List<TopLevelDeclContext> topLevelDecl() {
			return getRuleContexts(TopLevelDeclContext.class);
		}
		public TopLevelDeclContext topLevelDecl(int i) {
			return getRuleContext(TopLevelDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProgram(this);
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
			 ((ProgramContext)_localctx).programRet =  new Program(); 
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_MODULE || _la==KW_STRUCT) {
				{
				{
				setState(59);
				((ProgramContext)_localctx).t = topLevelDecl();
				 _localctx.programRet.addTopLevelDeclaration(((ProgramContext)_localctx).t.topLevelDeclRet); 
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
	public static class TopLevelDeclContext extends ParserRuleContext {
		public TopLevelDecl topLevelDeclRet;
		public ModuleContext m;
		public StructDefContext s;
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public TopLevelDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTopLevelDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTopLevelDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTopLevelDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((TopLevelDeclContext)_localctx).m = module();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet = ((TopLevelDeclContext)_localctx).m.moduleRet;

				         
				}
				break;
			case KW_STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((TopLevelDeclContext)_localctx).s = structDef();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet =  ((TopLevelDeclContext)_localctx).s.structRet;
				      
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
	public static class ModuleContext extends ParserRuleContext {
		public main.ast.declarations.Module moduleRet;
		public Token k;
		public Token i;
		public Token i1;
		public Token i2;
		public MemberContext m;
		public TerminalNode KW_BEGIN() { return getToken(SimpleLangParser.KW_BEGIN, 0); }
		public TerminalNode KW_END() { return getToken(SimpleLangParser.KW_END, 0); }
		public TerminalNode KW_MODULE() { return getToken(SimpleLangParser.KW_MODULE, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public TerminalNode KW_INCLUDES() { return getToken(SimpleLangParser.KW_INCLUDES, 0); }
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((ModuleContext)_localctx).k = match(KW_MODULE);
			setState(78);
			((ModuleContext)_localctx).i = match(ID);

			            ((ModuleContext)_localctx).moduleRet =  new main.ast.declarations.Module(new Identifier((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getText():null)));
			            _localctx.moduleRet.setLine((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getLine():0));
			        
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INCLUDES) {
				{
				setState(80);
				match(KW_INCLUDES);
				setState(81);
				((ModuleContext)_localctx).i1 = match(ID);
				 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i1!=null?((ModuleContext)_localctx).i1.getText():null))); 
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(83);
					match(COMMA);
					setState(84);
					((ModuleContext)_localctx).i2 = match(ID);
					 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i2!=null?((ModuleContext)_localctx).i2.getText():null))); 
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(93);
			match(KW_BEGIN);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(94);
				((ModuleContext)_localctx).m = member();
				 _localctx.moduleRet.addMember(((ModuleContext)_localctx).m.memberRet); 
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(KW_END);
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
	public static class StructDefContext extends ParserRuleContext {
		public Struct structRet;
		public Token k;
		public Token i;
		public MemberContext m;
		public TerminalNode KW_BEGIN() { return getToken(SimpleLangParser.KW_BEGIN, 0); }
		public TerminalNode KW_END() { return getToken(SimpleLangParser.KW_END, 0); }
		public TerminalNode KW_STRUCT() { return getToken(SimpleLangParser.KW_STRUCT, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public StructDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStructDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStructDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStructDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefContext structDef() throws RecognitionException {
		StructDefContext _localctx = new StructDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((StructDefContext)_localctx).k = match(KW_STRUCT);
			setState(105);
			((StructDefContext)_localctx).i = match(ID);

			            ((StructDefContext)_localctx).structRet =  new Struct(new Identifier((((StructDefContext)_localctx).i!=null?((StructDefContext)_localctx).i.getText():null)));
			            _localctx.structRet.setLine((((StructDefContext)_localctx).i!=null?((StructDefContext)_localctx).i.getLine():0));
			        
			setState(107);
			match(KW_BEGIN);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(108);
				((StructDefContext)_localctx).m = member();
				 _localctx.structRet.addMember(((StructDefContext)_localctx).m.memberRet); 
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(KW_END);
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
	public static class MemberContext extends ParserRuleContext {
		public Member memberRet;
		public AccessModifierContext am;
		public Method_declContext m;
		public VardeclContext v;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public Method_declContext method_decl() {
			return getRuleContext(Method_declContext.class,0);
		}
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 AccessModifier access = AccessModifier.PUBLIC; 
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
				{
				setState(119);
				((MemberContext)_localctx).am = accessModifier();
				 access = ((MemberContext)_localctx).am.accessModifierRet; 
				}
			}

			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(124);
				((MemberContext)_localctx).m = method_decl();

				                MethodDecl methodDecl = new MethodDecl();
				                methodDecl.setAccessModifier(access);
				                methodDecl.setMethod(((MemberContext)_localctx).m.methodRet);
				                methodDecl.setLine(((MemberContext)_localctx).m.methodRet.getLine());
				                ((MemberContext)_localctx).memberRet =  methodDecl;
				            
				}
				break;
			case 2:
				{
				setState(127);
				((MemberContext)_localctx).v = vardecl();
				setState(128);
				match(SEMI);

				                VarDecl varDecl = new VarDecl();
				                varDecl.setAccessModifier(access);
				                varDecl.setVar(((MemberContext)_localctx).v.varRet);
				                varDecl.setLine(((MemberContext)_localctx).v.varRet.getLine());
				                ((MemberContext)_localctx).memberRet =  varDecl;
				            
				}
				break;
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
	public static class AccessModifierContext extends ParserRuleContext {
		public AccessModifier accessModifierRet;
		public Token pr;
		public Token pu;
		public TerminalNode KW_PRIVATE() { return getToken(SimpleLangParser.KW_PRIVATE, 0); }
		public TerminalNode KW_PUBLIC() { return getToken(SimpleLangParser.KW_PUBLIC, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAccessModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAccessModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_accessModifier);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				((AccessModifierContext)_localctx).pr = match(KW_PRIVATE);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PRIVATE; 
				}
				break;
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				((AccessModifierContext)_localctx).pu = match(KW_PUBLIC);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PUBLIC; 
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
	public static class Method_declContext extends ParserRuleContext {
		public Method methodRet;
		public TypeContext t;
		public Token i;
		public ArgumentsContext a;
		public BlockContext b;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMethod_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			((Method_declContext)_localctx).t = type();
			setState(140);
			((Method_declContext)_localctx).i = match(ID);
			setState(141);
			match(LPAREN);
			setState(142);
			((Method_declContext)_localctx).a = arguments();
			setState(143);
			match(RPAREN);
			setState(144);
			((Method_declContext)_localctx).b = block();
			 ((Method_declContext)_localctx).methodRet =  new Method(((Method_declContext)_localctx).t.typeRet, new Identifier((((Method_declContext)_localctx).i!=null?((Method_declContext)_localctx).i.getText():null)), ((Method_declContext)_localctx).a.parametersRet, ((Method_declContext)_localctx).b.blockRet); 
			 _localctx.methodRet.setLine((((Method_declContext)_localctx).i!=null?((Method_declContext)_localctx).i.getLine():0)); 
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<Parameter> parametersRet;
		public ParameterContext p1;
		public ParameterContext p2;
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentsContext)_localctx).parametersRet =  new ArrayList<>(); 
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811479808L) != 0)) {
				{
				setState(149);
				((ArgumentsContext)_localctx).p1 = parameter();
				 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p1.parameterRet); 
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151);
					match(COMMA);
					setState(152);
					((ArgumentsContext)_localctx).p2 = parameter();
					 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p2.parameterRet); 
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
	public static class ParameterContext extends ParserRuleContext {
		public Parameter parameterRet;
		public TypeContext t;
		public Token i;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode KW_MUT() { return getToken(SimpleLangParser.KW_MUT, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(163);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(167);
			((ParameterContext)_localctx).t = type();
			setState(168);
			((ParameterContext)_localctx).i = match(ID);
			 ((ParameterContext)_localctx).parameterRet =  new Parameter(isMut, ((ParameterContext)_localctx).t.typeRet, new Identifier((((ParameterContext)_localctx).i!=null?((ParameterContext)_localctx).i.getText():null))); 
			 _localctx.parameterRet.setLine((((ParameterContext)_localctx).i!=null?((ParameterContext)_localctx).i.getLine():0)); 
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
		public Type typeRet;
		public Token i;
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode KW_INT() { return getToken(SimpleLangParser.KW_INT, 0); }
		public TerminalNode KW_FLOAT() { return getToken(SimpleLangParser.KW_FLOAT, 0); }
		public TerminalNode KW_DOUBLE() { return getToken(SimpleLangParser.KW_DOUBLE, 0); }
		public TerminalNode KW_CHAR() { return getToken(SimpleLangParser.KW_CHAR, 0); }
		public TerminalNode KW_VOID() { return getToken(SimpleLangParser.KW_VOID, 0); }
		public TerminalNode KW_BOOL() { return getToken(SimpleLangParser.KW_BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				((TypeContext)_localctx).i = match(ID);
				 ((TypeContext)_localctx).typeRet =  new UserDefinedType(new Identifier((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null))); 
				}
				break;
			case KW_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(KW_INT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("int"); 
				}
				break;
			case KW_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(KW_FLOAT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("float"); 
				}
				break;
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(KW_DOUBLE);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("double"); 
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				match(KW_CHAR);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("char"); 
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(182);
				match(KW_VOID);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("void"); 
				}
				break;
			case KW_BOOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
				match(KW_BOOL);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("bool"); 
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
	public static class VardeclContext extends ParserRuleContext {
		public Var varRet;
		public TypeContext t;
		public ConsContext c;
		public Token i;
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode KW_MUT() { return getToken(SimpleLangParser.KW_MUT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitVardecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(189);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(193);
				((VardeclContext)_localctx).t = type();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).t.typeRet); 
				}
				break;
			case 2:
				{
				setState(196);
				((VardeclContext)_localctx).c = cons();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).c.constructorCallRet); 
				}
				break;
			}
			setState(201);
			((VardeclContext)_localctx).i = match(ID);
			 _localctx.varRet.setName(new Identifier((((VardeclContext)_localctx).i!=null?((VardeclContext)_localctx).i.getText():null))); 
			 _localctx.varRet.setLine((((VardeclContext)_localctx).i!=null?((VardeclContext)_localctx).i.getLine():0)); 
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
	public static class ConsContext extends ParserRuleContext {
		public ConstructorCall constructorCallRet;
		public Token i;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ConsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cons; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCons(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConsContext cons() throws RecognitionException {
		ConsContext _localctx = new ConsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cons);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			((ConsContext)_localctx).i = match(ID);
			 ((ConsContext)_localctx).constructorCallRet =  new ConstructorCall(new Identifier((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getText():null))); 
			setState(207);
			match(LPAREN);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(208);
				((ConsContext)_localctx).e1 = expr();
				 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e1.expressionRet); 
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(210);
					match(COMMA);
					setState(211);
					((ConsContext)_localctx).e2 = expr();
					 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(221);
			match(RPAREN);
			 _localctx.constructorCallRet.setLine((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getLine():0)); 
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
	public static class BlockContext extends ParserRuleContext {
		public Block blockRet;
		public Token k;
		public StContext s;
		public TerminalNode KW_END() { return getToken(SimpleLangParser.KW_END, 0); }
		public TerminalNode KW_BEGIN() { return getToken(SimpleLangParser.KW_BEGIN, 0); }
		public List<StContext> st() {
			return getRuleContexts(StContext.class);
		}
		public StContext st(int i) {
			return getRuleContext(StContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((BlockContext)_localctx).blockRet =  new Block(); 
			setState(225);
			((BlockContext)_localctx).k = match(KW_BEGIN);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014399016845072L) != 0)) {
				{
				{
				setState(226);
				((BlockContext)_localctx).s = st();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.statementRet); 
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
			match(KW_END);
			 _localctx.blockRet.setLine((((BlockContext)_localctx).k!=null?((BlockContext)_localctx).k.getLine():0)); 
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
	public static class StContext extends ParserRuleContext {
		public Statement statementRet;
		public BlockContext b;
		public AssignStmtContext as;
		public MethodcallContext mc;
		public VardeclContext v;
		public ExprContext e;
		public VardeclContext vd;
		public IfStmtContext ifs;
		public ReturnStmtContext rs;
		public InputStmtContext is;
		public OutputStmtContext os;
		public JumpStmtContext js;
		public ForStmtContext fs;
		public WhileStmtContext ws;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public InputStmtContext inputStmt() {
			return getRuleContext(InputStmtContext.class,0);
		}
		public OutputStmtContext outputStmt() {
			return getRuleContext(OutputStmtContext.class,0);
		}
		public JumpStmtContext jumpStmt() {
			return getRuleContext(JumpStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StContext st() throws RecognitionException {
		StContext _localctx = new StContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_st);
		try {
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				((StContext)_localctx).b = block();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).b.blockRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).b.blockRet.getLine());
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				((StContext)_localctx).as = assignStmt();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).as.assignStmtRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).as.assignStmtRet.getLine());
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				((StContext)_localctx).mc = methodcall();
				setState(244);
				match(SEMI);

				            ((StContext)_localctx).statementRet =  new MethodCallStmt(((StContext)_localctx).mc.methodCallRet);
				            _localctx.statementRet.setLine(((StContext)_localctx).mc.methodCallRet.getLine());
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				((StContext)_localctx).v = vardecl();
				setState(248);
				match(ASSIGN);
				setState(249);
				((StContext)_localctx).e = expr();
				setState(250);
				match(SEMI);

				            VarDeclStmt stmt = new VarDeclStmt(((StContext)_localctx).v.varRet);
				            stmt.setInitial(((StContext)_localctx).e.expressionRet);
				            stmt.setLine(((StContext)_localctx).v.varRet.getLine());
				            ((StContext)_localctx).statementRet =  stmt;
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(253);
				((StContext)_localctx).vd = vardecl();
				setState(254);
				match(SEMI);

				            ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).vd.varRet);
				            _localctx.statementRet.setLine(((StContext)_localctx).vd.varRet.getLine());
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(257);
				((StContext)_localctx).ifs = ifStmt();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).ifs.ifStmtRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).ifs.ifStmtRet.getLine());
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				((StContext)_localctx).rs = returnStmt();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).rs.returnStmtRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).rs.returnStmtRet.getLine());
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(263);
				((StContext)_localctx).is = inputStmt();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).is.inputStmtRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).is.inputStmtRet.getLine());
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(266);
				((StContext)_localctx).os = outputStmt();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).os.outputStmtRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).os.outputStmtRet.getLine());
				        
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(269);
				((StContext)_localctx).js = jumpStmt();

				            ((StContext)_localctx).statementRet =  ((StContext)_localctx).js.jumpStmtRet;
				            _localctx.statementRet.setLine(((StContext)_localctx).js.jumpStmtRet.getLine());
				        
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(272);
				((StContext)_localctx).fs = forStmt();

				            ((StContext)_localctx).statementRet =  new Block();
				        
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(275);
				((StContext)_localctx).ws = whileStmt();

				            ((StContext)_localctx).statementRet =  new Block();
				        
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
	public static class JumpStmtContext extends ParserRuleContext {
		public JumpStmt jumpStmtRet;
		public Token kb;
		public Token kc;
		public TerminalNode KW_BREAK() { return getToken(SimpleLangParser.KW_BREAK, 0); }
		public TerminalNode KW_CONTINUE() { return getToken(SimpleLangParser.KW_CONTINUE, 0); }
		public JumpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterJumpStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitJumpStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitJumpStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStmtContext jumpStmt() throws RecognitionException {
		JumpStmtContext _localctx = new JumpStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jumpStmt);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				((JumpStmtContext)_localctx).kb = match(KW_BREAK);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new BreakJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kb!=null?((JumpStmtContext)_localctx).kb.getLine():0)); 
				}
				break;
			case KW_CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				((JumpStmtContext)_localctx).kc = match(KW_CONTINUE);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new ContinueJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kc!=null?((JumpStmtContext)_localctx).kc.getLine():0)); 
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
	public static class IfStmtContext extends ParserRuleContext {
		public IfStmt ifStmtRet;
		public Token k;
		public ExprContext e;
		public StContext s1;
		public StContext s2;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode KW_IF() { return getToken(SimpleLangParser.KW_IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StContext> st() {
			return getRuleContexts(StContext.class);
		}
		public StContext st(int i) {
			return getRuleContext(StContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(SimpleLangParser.KW_ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			((IfStmtContext)_localctx).k = match(KW_IF);
			setState(289);
			match(LPAREN);
			setState(290);
			((IfStmtContext)_localctx).e = expr();
			setState(291);
			match(RPAREN);
			setState(292);
			((IfStmtContext)_localctx).s1 = st();
			 ((IfStmtContext)_localctx).ifStmtRet =  new IfStmt(((IfStmtContext)_localctx).e.expressionRet, ((IfStmtContext)_localctx).s1.statementRet); 
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(294);
				match(KW_ELSE);
				setState(295);
				((IfStmtContext)_localctx).s2 = st();
				 _localctx.ifStmtRet.setElseBranch(((IfStmtContext)_localctx).s2.statementRet); 
				}
				break;
			}
			 _localctx.ifStmtRet.setLine((((IfStmtContext)_localctx).k!=null?((IfStmtContext)_localctx).k.getLine():0)); 
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
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode KW_FOR() { return getToken(SimpleLangParser.KW_FOR, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(SimpleLangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SimpleLangParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public StContext st() {
			return getRuleContext(StContext.class,0);
		}
		public List<InitexprContext> initexpr() {
			return getRuleContexts(InitexprContext.class);
		}
		public InitexprContext initexpr(int i) {
			return getRuleContext(InitexprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<LocContext> loc() {
			return getRuleContexts(LocContext.class);
		}
		public LocContext loc(int i) {
			return getRuleContext(LocContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLangParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(KW_FOR);
			setState(303);
			match(LPAREN);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398813576960L) != 0)) {
				{
				setState(304);
				initexpr();
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(305);
					match(COMMA);
					setState(306);
					initexpr();
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(314);
			match(SEMI);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(315);
				expr();
				}
			}

			setState(318);
			match(SEMI);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THIS || _la==ID) {
				{
				setState(319);
				loc();
				setState(320);
				match(ASSIGN);
				setState(321);
				expr();
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(322);
					match(COMMA);
					setState(323);
					loc();
					setState(324);
					match(ASSIGN);
					setState(325);
					expr();
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(334);
			match(RPAREN);
			setState(335);
			st();
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
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(SimpleLangParser.KW_WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public StContext st() {
			return getRuleContext(StContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(KW_WHILE);
			setState(338);
			match(LPAREN);
			setState(339);
			expr();
			setState(340);
			match(RPAREN);
			setState(341);
			st();
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
	public static class AssignStmtContext extends ParserRuleContext {
		public AssignStmt assignStmtRet;
		public LocContext l;
		public Token a;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			((AssignStmtContext)_localctx).l = loc();
			setState(344);
			((AssignStmtContext)_localctx).a = match(ASSIGN);
			setState(345);
			((AssignStmtContext)_localctx).e = expr();
			 ((AssignStmtContext)_localctx).assignStmtRet =  new AssignStmt(((AssignStmtContext)_localctx).l.locationRet, ((AssignStmtContext)_localctx).e.expressionRet); 
			setState(347);
			match(SEMI);
			 _localctx.assignStmtRet.setLine((((AssignStmtContext)_localctx).a!=null?((AssignStmtContext)_localctx).a.getLine():0)); 
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
	public static class ReturnStmtContext extends ParserRuleContext {
		public ReturnStmt returnStmtRet;
		public Token k;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode KW_RETURN() { return getToken(SimpleLangParser.KW_RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ReturnStmtContext)_localctx).returnStmtRet =  new ReturnStmt(); 
			setState(351);
			((ReturnStmtContext)_localctx).k = match(KW_RETURN);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(352);
				((ReturnStmtContext)_localctx).e = expr();
				 _localctx.returnStmtRet.setValue(((ReturnStmtContext)_localctx).e.expressionRet); 
				}
			}

			setState(357);
			match(SEMI);
			 _localctx.returnStmtRet.setLine((((ReturnStmtContext)_localctx).k!=null?((ReturnStmtContext)_localctx).k.getLine():0)); 
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
	public static class InputStmtContext extends ParserRuleContext {
		public InputStmt inputStmtRet;
		public Token k;
		public LocContext l;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode KW_INPUT() { return getToken(SimpleLangParser.KW_INPUT, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public InputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInputStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInputStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStmtContext inputStmt() throws RecognitionException {
		InputStmtContext _localctx = new InputStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			((InputStmtContext)_localctx).k = match(KW_INPUT);
			setState(361);
			((InputStmtContext)_localctx).l = loc();
			 ((InputStmtContext)_localctx).inputStmtRet =  new InputStmt(((InputStmtContext)_localctx).l.locationRet); 
			setState(363);
			match(SEMI);
			 _localctx.inputStmtRet.setLine((((InputStmtContext)_localctx).k!=null?((InputStmtContext)_localctx).k.getLine():0)); 
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
	public static class OutputStmtContext extends ParserRuleContext {
		public OutputStmt outputStmtRet;
		public Token k;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode KW_OUTPUT() { return getToken(SimpleLangParser.KW_OUTPUT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterOutputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitOutputStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOutputStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_outputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			((OutputStmtContext)_localctx).k = match(KW_OUTPUT);
			setState(367);
			((OutputStmtContext)_localctx).e = expr();
			 ((OutputStmtContext)_localctx).outputStmtRet =  new OutputStmt(((OutputStmtContext)_localctx).e.expressionRet); 
			setState(369);
			match(SEMI);
			 _localctx.outputStmtRet.setLine((((OutputStmtContext)_localctx).k!=null?((OutputStmtContext)_localctx).k.getLine():0)); 
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
	public static class LocContext extends ParserRuleContext {
		public Location locationRet;
		public Token k;
		public Token i;
		public Token j;
		public TerminalNode KW_THIS() { return getToken(SimpleLangParser.KW_THIS, 0); }
		public List<TerminalNode> DOT() { return getTokens(SimpleLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleLangParser.DOT, i);
		}
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public LocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitLoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocContext loc() throws RecognitionException {
		LocContext _localctx = new LocContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loc);
		int _la;
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_THIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				((LocContext)_localctx).k = match(KW_THIS);

				            ((LocContext)_localctx).locationRet =  new ThisLoc();
				            _localctx.locationRet.setLine((((LocContext)_localctx).k!=null?((LocContext)_localctx).k.getLine():0));
				        
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(374);
					match(DOT);
					setState(375);
					((LocContext)_localctx).i = match(ID);

					                ((LocContext)_localctx).locationRet =  new MemberLoc(
					                    new Identifier(_localctx.locationRet.toString()),
					                    new SimpleLoc(new Identifier((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getText():null)))
					                );
					                _localctx.locationRet.setLine((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getLine():0));
					            
					}
					}
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				((LocContext)_localctx).i = match(ID);

				            ((LocContext)_localctx).locationRet =  new SimpleLoc(new Identifier((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getText():null)));
				            _localctx.locationRet.setLine((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getLine():0));
				        
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(384);
					match(DOT);
					setState(385);
					((LocContext)_localctx).j = match(ID);

					                ((LocContext)_localctx).locationRet =  new MemberLoc(
					                    new Identifier(_localctx.locationRet.toString()),
					                    new SimpleLoc(new Identifier((((LocContext)_localctx).j!=null?((LocContext)_localctx).j.getText():null)))
					                );
					                _localctx.locationRet.setLine((((LocContext)_localctx).j!=null?((LocContext)_localctx).j.getLine():0));
					            
					}
					}
					setState(391);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class MethodcallContext extends ParserRuleContext {
		public MethodCall methodCallRet;
		public Token k;
		public Token i;
		public CallArgsContext args;
		public Token obj;
		public TerminalNode DOT() { return getToken(SimpleLangParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode KW_THIS() { return getToken(SimpleLangParser.KW_THIS, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public CallArgsContext callArgs() {
			return getRuleContext(CallArgsContext.class,0);
		}
		public MethodcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMethodcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMethodcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMethodcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodcallContext methodcall() throws RecognitionException {
		MethodcallContext _localctx = new MethodcallContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodcall);
		try {
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				((MethodcallContext)_localctx).k = match(KW_THIS);
				setState(395);
				match(DOT);
				setState(396);
				((MethodcallContext)_localctx).i = match(ID);

				            ThisLoc receiverLoc = new ThisLoc();
				            receiverLoc.setLine((((MethodcallContext)_localctx).k!=null?((MethodcallContext)_localctx).k.getLine():0));

				            ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(receiverLoc, new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null)));
				            _localctx.methodCallRet.setLine((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getLine():0));
				        
				setState(398);
				match(LPAREN);
				setState(399);
				((MethodcallContext)_localctx).args = callArgs();
				setState(400);
				match(RPAREN);

				            for (Expression e : ((MethodcallContext)_localctx).args.argsRet) {
				                _localctx.methodCallRet.addArgument(e);
				            }
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				((MethodcallContext)_localctx).obj = match(ID);
				setState(404);
				match(DOT);
				setState(405);
				((MethodcallContext)_localctx).i = match(ID);

				            SimpleLoc receiverLoc = new SimpleLoc(new Identifier((((MethodcallContext)_localctx).obj!=null?((MethodcallContext)_localctx).obj.getText():null)));
				            receiverLoc.setLine((((MethodcallContext)_localctx).obj!=null?((MethodcallContext)_localctx).obj.getLine():0));

				            ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(receiverLoc, new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null)));
				            _localctx.methodCallRet.setLine((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getLine():0));
				        
				setState(407);
				match(LPAREN);
				setState(408);
				((MethodcallContext)_localctx).args = callArgs();
				setState(409);
				match(RPAREN);

				            for (Expression e : ((MethodcallContext)_localctx).args.argsRet) {
				                _localctx.methodCallRet.addArgument(e);
				            }
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(412);
				((MethodcallContext)_localctx).i = match(ID);

				            ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null)));
				            _localctx.methodCallRet.setLine((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getLine():0));
				        
				setState(414);
				match(LPAREN);
				setState(415);
				((MethodcallContext)_localctx).args = callArgs();
				setState(416);
				match(RPAREN);

				            for (Expression e : ((MethodcallContext)_localctx).args.argsRet) {
				                _localctx.methodCallRet.addArgument(e);
				            }
				        
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
	public static class CallArgsContext extends ParserRuleContext {
		public List<Expression> argsRet;
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public CallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCallArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCallArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallArgsContext callArgs() throws RecognitionException {
		CallArgsContext _localctx = new CallArgsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_callArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((CallArgsContext)_localctx).argsRet =  new ArrayList<>(); 
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(422);
				((CallArgsContext)_localctx).e1 = expr();
				 _localctx.argsRet.add(((CallArgsContext)_localctx).e1.expressionRet); 
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(424);
					match(COMMA);
					setState(425);
					((CallArgsContext)_localctx).e2 = expr();
					 _localctx.argsRet.add(((CallArgsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
	public static class ExprContext extends ParserRuleContext {
		public Expression expressionRet;
		public AtomContext a;
		public BinOpContext op;
		public AtomContext b;
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<BinOpContext> binOp() {
			return getRuleContexts(BinOpContext.class);
		}
		public BinOpContext binOp(int i) {
			return getRuleContext(BinOpContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			((ExprContext)_localctx).a = atom();
			 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).a.expressionRet; 
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116554083172352L) != 0)) {
				{
				{
				setState(437);
				((ExprContext)_localctx).op = binOp();
				setState(438);
				((ExprContext)_localctx).b = atom();

				                ((ExprContext)_localctx).expressionRet =  null;
				            
				}
				}
				setState(445);
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
	public static class AtomContext extends ParserRuleContext {
		public Expression expressionRet;
		public MethodcallContext mc;
		public LocContext l;
		public ConsContext c;
		public ExprContext e;
		public AtomContext a;
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CONSTINT() { return getToken(SimpleLangParser.CONSTINT, 0); }
		public TerminalNode CONSTFLOAT() { return getToken(SimpleLangParser.CONSTFLOAT, 0); }
		public TerminalNode CONSTDOUBLE() { return getToken(SimpleLangParser.CONSTDOUBLE, 0); }
		public TerminalNode CONSTCHAR() { return getToken(SimpleLangParser.CONSTCHAR, 0); }
		public TerminalNode CONSTBOOL() { return getToken(SimpleLangParser.CONSTBOOL, 0); }
		public TerminalNode MINUS() { return getToken(SimpleLangParser.MINUS, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode KW_NOT() { return getToken(SimpleLangParser.KW_NOT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_atom);
		try {
			setState(478);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				((AtomContext)_localctx).mc = methodcall();
				 ((AtomContext)_localctx).expressionRet =  ((AtomContext)_localctx).mc.methodCallRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				((AtomContext)_localctx).l = loc();
				 ((AtomContext)_localctx).expressionRet =  ((AtomContext)_localctx).l.locationRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(452);
				((AtomContext)_localctx).c = cons();
				 ((AtomContext)_localctx).expressionRet =  ((AtomContext)_localctx).c.constructorCallRet; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(455);
				match(LPAREN);
				setState(456);
				((AtomContext)_localctx).e = expr();
				setState(457);
				match(RPAREN);
				 ((AtomContext)_localctx).expressionRet =  ((AtomContext)_localctx).e.expressionRet; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(460);
				match(CONSTINT);
				 ((AtomContext)_localctx).expressionRet =  null; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(462);
				match(CONSTFLOAT);
				 ((AtomContext)_localctx).expressionRet =  null; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(464);
				match(CONSTDOUBLE);
				 ((AtomContext)_localctx).expressionRet =  null; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(466);
				match(CONSTCHAR);
				 ((AtomContext)_localctx).expressionRet =  null; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(468);
				match(CONSTBOOL);
				 ((AtomContext)_localctx).expressionRet =  null; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(470);
				match(MINUS);
				setState(471);
				((AtomContext)_localctx).a = atom();
				 ((AtomContext)_localctx).expressionRet =  null; 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(474);
				match(KW_NOT);
				setState(475);
				((AtomContext)_localctx).a = atom();
				 ((AtomContext)_localctx).expressionRet =  null; 
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
	public static class BinOpContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SimpleLangParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(SimpleLangParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(SimpleLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SimpleLangParser.MINUS, 0); }
		public TerminalNode LESS() { return getToken(SimpleLangParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(SimpleLangParser.GREATER, 0); }
		public TerminalNode LESS_EQ() { return getToken(SimpleLangParser.LESS_EQ, 0); }
		public TerminalNode GREATER_EQ() { return getToken(SimpleLangParser.GREATER_EQ, 0); }
		public TerminalNode EQUAL() { return getToken(SimpleLangParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SimpleLangParser.NOT_EQUAL, 0); }
		public TerminalNode KW_AND() { return getToken(SimpleLangParser.KW_AND, 0); }
		public TerminalNode KW_OR() { return getToken(SimpleLangParser.KW_OR, 0); }
		public BinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBinOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBinOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBinOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinOpContext binOp() throws RecognitionException {
		BinOpContext _localctx = new BinOpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_binOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116554083172352L) != 0)) ) {
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
	public static class InitexprContext extends ParserRuleContext {
		public Statement initExprRet;
		public LocContext l;
		public ExprContext e;
		public VardeclContext v;
		public VardeclContext vd;
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public InitexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitexprContext initexpr() throws RecognitionException {
		InitexprContext _localctx = new InitexprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_initexpr);
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				((InitexprContext)_localctx).l = loc();
				setState(483);
				match(ASSIGN);
				setState(484);
				((InitexprContext)_localctx).e = expr();

				            ((InitexprContext)_localctx).initExprRet =  new AssignStmt(((InitexprContext)_localctx).l.locationRet, ((InitexprContext)_localctx).e.expressionRet);
				            _localctx.initExprRet.setLine(((InitexprContext)_localctx).l.locationRet.getLine());
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				((InitexprContext)_localctx).v = vardecl();
				setState(488);
				match(ASSIGN);
				setState(489);
				((InitexprContext)_localctx).e = expr();

				            VarDeclStmt stmt = new VarDeclStmt(((InitexprContext)_localctx).v.varRet);
				            stmt.setInitial(((InitexprContext)_localctx).e.expressionRet);
				            stmt.setLine(((InitexprContext)_localctx).v.varRet.getLine());
				            ((InitexprContext)_localctx).initExprRet =  stmt;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(492);
				((InitexprContext)_localctx).vd = vardecl();

				            ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).vd.varRet);
				            _localctx.initExprRet.setLine(((InitexprContext)_localctx).vd.varRet.getLine());
				        
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

	public static final String _serializedATN =
		"\u0004\u00019\u01f2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000?\b\u0000\n\u0000\f\u0000B\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001L\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"W\b\u0002\n\u0002\f\u0002Z\t\u0002\u0003\u0002\\\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002b\b\u0002\n\u0002\f\u0002e\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003p\b\u0003\n\u0003"+
		"\f\u0003s\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004{\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0084"+
		"\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u008a"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u009c"+
		"\b\u0007\n\u0007\f\u0007\u009f\t\u0007\u0003\u0007\u00a1\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00a6\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00bb\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00c0\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00c8\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00d7\b\u000b\n\u000b\f\u000b\u00da\t\u000b"+
		"\u0003\u000b\u00dc\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00e6\b\f\n\f\f\f\u00e9\t\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0117"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u011f\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u012b\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0134\b\u0010\n"+
		"\u0010\f\u0010\u0137\t\u0010\u0003\u0010\u0139\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u013d\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0148\b\u0010\n\u0010\f\u0010\u014b\t\u0010\u0003\u0010\u014d\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0164\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u017a\b\u0016\n\u0016\f\u0016\u017d\t\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u0184\b\u0016\n\u0016\f\u0016\u0187\t\u0016\u0003\u0016\u0189\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u01a4\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01ad\b\u0018"+
		"\n\u0018\f\u0018\u01b0\t\u0018\u0003\u0018\u01b2\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u01ba"+
		"\b\u0019\n\u0019\f\u0019\u01bd\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u01df\b\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01f0\b\u001c"+
		"\u0001\u001c\u0000\u0000\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0001\u0003"+
		"\u0000\u0017\u0018\'*,1\u0212\u0000:\u0001\u0000\u0000\u0000\u0002K\u0001"+
		"\u0000\u0000\u0000\u0004M\u0001\u0000\u0000\u0000\u0006h\u0001\u0000\u0000"+
		"\u0000\bv\u0001\u0000\u0000\u0000\n\u0089\u0001\u0000\u0000\u0000\f\u008b"+
		"\u0001\u0000\u0000\u0000\u000e\u0094\u0001\u0000\u0000\u0000\u0010\u00a2"+
		"\u0001\u0000\u0000\u0000\u0012\u00ba\u0001\u0000\u0000\u0000\u0014\u00bc"+
		"\u0001\u0000\u0000\u0000\u0016\u00cd\u0001\u0000\u0000\u0000\u0018\u00e0"+
		"\u0001\u0000\u0000\u0000\u001a\u0116\u0001\u0000\u0000\u0000\u001c\u011e"+
		"\u0001\u0000\u0000\u0000\u001e\u0120\u0001\u0000\u0000\u0000 \u012e\u0001"+
		"\u0000\u0000\u0000\"\u0151\u0001\u0000\u0000\u0000$\u0157\u0001\u0000"+
		"\u0000\u0000&\u015e\u0001\u0000\u0000\u0000(\u0168\u0001\u0000\u0000\u0000"+
		"*\u016e\u0001\u0000\u0000\u0000,\u0188\u0001\u0000\u0000\u0000.\u01a3"+
		"\u0001\u0000\u0000\u00000\u01a5\u0001\u0000\u0000\u00002\u01b3\u0001\u0000"+
		"\u0000\u00004\u01de\u0001\u0000\u0000\u00006\u01e0\u0001\u0000\u0000\u0000"+
		"8\u01ef\u0001\u0000\u0000\u0000:@\u0006\u0000\uffff\uffff\u0000;<\u0003"+
		"\u0002\u0001\u0000<=\u0006\u0000\uffff\uffff\u0000=?\u0001\u0000\u0000"+
		"\u0000>;\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000CD\u0005\u0000\u0000\u0001D\u0001\u0001\u0000\u0000"+
		"\u0000EF\u0003\u0004\u0002\u0000FG\u0006\u0001\uffff\uffff\u0000GL\u0001"+
		"\u0000\u0000\u0000HI\u0003\u0006\u0003\u0000IJ\u0006\u0001\uffff\uffff"+
		"\u0000JL\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000KH\u0001\u0000"+
		"\u0000\u0000L\u0003\u0001\u0000\u0000\u0000MN\u0005\u0001\u0000\u0000"+
		"NO\u00056\u0000\u0000O[\u0006\u0002\uffff\uffff\u0000PQ\u0005\u0003\u0000"+
		"\u0000QR\u00056\u0000\u0000RX\u0006\u0002\uffff\uffff\u0000ST\u0005\u001f"+
		"\u0000\u0000TU\u00056\u0000\u0000UW\u0006\u0002\uffff\uffff\u0000VS\u0001"+
		"\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[P\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]c\u0005\u0004\u0000\u0000^_\u0003\b\u0004\u0000_`\u0006\u0002"+
		"\uffff\uffff\u0000`b\u0001\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000"+
		"be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\u0005"+
		"\u0000\u0000g\u0005\u0001\u0000\u0000\u0000hi\u0005\u0002\u0000\u0000"+
		"ij\u00056\u0000\u0000jk\u0006\u0003\uffff\uffff\u0000kq\u0005\u0004\u0000"+
		"\u0000lm\u0003\b\u0004\u0000mn\u0006\u0003\uffff\uffff\u0000np\u0001\u0000"+
		"\u0000\u0000ol\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000tu\u0005\u0005\u0000\u0000u\u0007\u0001\u0000"+
		"\u0000\u0000vz\u0006\u0004\uffff\uffff\u0000wx\u0003\n\u0005\u0000xy\u0006"+
		"\u0004\uffff\uffff\u0000y{\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{\u0083\u0001\u0000\u0000\u0000|}\u0003"+
		"\f\u0006\u0000}~\u0006\u0004\uffff\uffff\u0000~\u0084\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0003\u0014\n\u0000\u0080\u0081\u0005\u001e\u0000\u0000"+
		"\u0081\u0082\u0006\u0004\uffff\uffff\u0000\u0082\u0084\u0001\u0000\u0000"+
		"\u0000\u0083|\u0001\u0000\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000"+
		"\u0084\t\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0007\u0000\u0000\u0086"+
		"\u008a\u0006\u0005\uffff\uffff\u0000\u0087\u0088\u0005\u0006\u0000\u0000"+
		"\u0088\u008a\u0006\u0005\uffff\uffff\u0000\u0089\u0085\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u000b\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0003\u0012\t\u0000\u008c\u008d\u00056\u0000\u0000"+
		"\u008d\u008e\u0005 \u0000\u0000\u008e\u008f\u0003\u000e\u0007\u0000\u008f"+
		"\u0090\u0005!\u0000\u0000\u0090\u0091\u0003\u0018\f\u0000\u0091\u0092"+
		"\u0006\u0006\uffff\uffff\u0000\u0092\u0093\u0006\u0006\uffff\uffff\u0000"+
		"\u0093\r\u0001\u0000\u0000\u0000\u0094\u00a0\u0006\u0007\uffff\uffff\u0000"+
		"\u0095\u0096\u0003\u0010\b\u0000\u0096\u009d\u0006\u0007\uffff\uffff\u0000"+
		"\u0097\u0098\u0005\u001f\u0000\u0000\u0098\u0099\u0003\u0010\b\u0000\u0099"+
		"\u009a\u0006\u0007\uffff\uffff\u0000\u009a\u009c\u0001\u0000\u0000\u0000"+
		"\u009b\u0097\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u00a0\u0095\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u000f\u0001\u0000\u0000\u0000\u00a2\u00a5\u0006\b\uffff\uffff\u0000"+
		"\u00a3\u00a4\u0005\u0019\u0000\u0000\u00a4\u00a6\u0006\b\uffff\uffff\u0000"+
		"\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0003\u0012\t\u0000\u00a8"+
		"\u00a9\u00056\u0000\u0000\u00a9\u00aa\u0006\b\uffff\uffff\u0000\u00aa"+
		"\u00ab\u0006\b\uffff\uffff\u0000\u00ab\u0011\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u00056\u0000\u0000\u00ad\u00bb\u0006\t\uffff\uffff\u0000\u00ae"+
		"\u00af\u0005\b\u0000\u0000\u00af\u00bb\u0006\t\uffff\uffff\u0000\u00b0"+
		"\u00b1\u0005\t\u0000\u0000\u00b1\u00bb\u0006\t\uffff\uffff\u0000\u00b2"+
		"\u00b3\u0005\n\u0000\u0000\u00b3\u00bb\u0006\t\uffff\uffff\u0000\u00b4"+
		"\u00b5\u0005\u000b\u0000\u0000\u00b5\u00bb\u0006\t\uffff\uffff\u0000\u00b6"+
		"\u00b7\u0005\f\u0000\u0000\u00b7\u00bb\u0006\t\uffff\uffff\u0000\u00b8"+
		"\u00b9\u0005\u001c\u0000\u0000\u00b9\u00bb\u0006\t\uffff\uffff\u0000\u00ba"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ba\u00ae\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b0\u0001\u0000\u0000\u0000\u00ba\u00b2\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b4\u0001\u0000\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b8\u0001\u0000\u0000\u0000\u00bb\u0013\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bf\u0006\n\uffff\uffff\u0000\u00bd\u00be\u0005\u0019\u0000\u0000\u00be"+
		"\u00c0\u0006\n\uffff\uffff\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c7\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0003\u0012\t\u0000\u00c2\u00c3\u0006\n\uffff\uffff\u0000\u00c3"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c4\u00c5\u0003\u0016\u000b\u0000\u00c5"+
		"\u00c6\u0006\n\uffff\uffff\u0000\u00c6\u00c8\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c7\u00c4\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u00056\u0000\u0000\u00ca\u00cb"+
		"\u0006\n\uffff\uffff\u0000\u00cb\u00cc\u0006\n\uffff\uffff\u0000\u00cc"+
		"\u0015\u0001\u0000\u0000\u0000\u00cd\u00ce\u00056\u0000\u0000\u00ce\u00cf"+
		"\u0006\u000b\uffff\uffff\u0000\u00cf\u00db\u0005 \u0000\u0000\u00d0\u00d1"+
		"\u00032\u0019\u0000\u00d1\u00d8\u0006\u000b\uffff\uffff\u0000\u00d2\u00d3"+
		"\u0005\u001f\u0000\u0000\u00d3\u00d4\u00032\u0019\u0000\u00d4\u00d5\u0006"+
		"\u000b\uffff\uffff\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00dc"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00d0"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0005!\u0000\u0000\u00de\u00df\u0006"+
		"\u000b\uffff\uffff\u0000\u00df\u0017\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0006\f\uffff\uffff\u0000\u00e1\u00e7\u0005\u0004\u0000\u0000\u00e2\u00e3"+
		"\u0003\u001a\r\u0000\u00e3\u00e4\u0006\f\uffff\uffff\u0000\u00e4\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000\u00e6\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e8\u00ea\u0001\u0000\u0000\u0000\u00e9\u00e7"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u0005\u0000\u0000\u00eb\u00ec"+
		"\u0006\f\uffff\uffff\u0000\u00ec\u0019\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0003\u0018\f\u0000\u00ee\u00ef\u0006\r\uffff\uffff\u0000\u00ef\u0117"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003$\u0012\u0000\u00f1\u00f2\u0006"+
		"\r\uffff\uffff\u0000\u00f2\u0117\u0001\u0000\u0000\u0000\u00f3\u00f4\u0003"+
		".\u0017\u0000\u00f4\u00f5\u0005\u001e\u0000\u0000\u00f5\u00f6\u0006\r"+
		"\uffff\uffff\u0000\u00f6\u0117\u0001\u0000\u0000\u0000\u00f7\u00f8\u0003"+
		"\u0014\n\u0000\u00f8\u00f9\u0005$\u0000\u0000\u00f9\u00fa\u00032\u0019"+
		"\u0000\u00fa\u00fb\u0005\u001e\u0000\u0000\u00fb\u00fc\u0006\r\uffff\uffff"+
		"\u0000\u00fc\u0117\u0001\u0000\u0000\u0000\u00fd\u00fe\u0003\u0014\n\u0000"+
		"\u00fe\u00ff\u0005\u001e\u0000\u0000\u00ff\u0100\u0006\r\uffff\uffff\u0000"+
		"\u0100\u0117\u0001\u0000\u0000\u0000\u0101\u0102\u0003\u001e\u000f\u0000"+
		"\u0102\u0103\u0006\r\uffff\uffff\u0000\u0103\u0117\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0003&\u0013\u0000\u0105\u0106\u0006\r\uffff\uffff\u0000"+
		"\u0106\u0117\u0001\u0000\u0000\u0000\u0107\u0108\u0003(\u0014\u0000\u0108"+
		"\u0109\u0006\r\uffff\uffff\u0000\u0109\u0117\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0003*\u0015\u0000\u010b\u010c\u0006\r\uffff\uffff\u0000\u010c"+
		"\u0117\u0001\u0000\u0000\u0000\u010d\u010e\u0003\u001c\u000e\u0000\u010e"+
		"\u010f\u0006\r\uffff\uffff\u0000\u010f\u0117\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0003 \u0010\u0000\u0111\u0112\u0006\r\uffff\uffff\u0000\u0112"+
		"\u0117\u0001\u0000\u0000\u0000\u0113\u0114\u0003\"\u0011\u0000\u0114\u0115"+
		"\u0006\r\uffff\uffff\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u00ed"+
		"\u0001\u0000\u0000\u0000\u0116\u00f0\u0001\u0000\u0000\u0000\u0116\u00f3"+
		"\u0001\u0000\u0000\u0000\u0116\u00f7\u0001\u0000\u0000\u0000\u0116\u00fd"+
		"\u0001\u0000\u0000\u0000\u0116\u0101\u0001\u0000\u0000\u0000\u0116\u0104"+
		"\u0001\u0000\u0000\u0000\u0116\u0107\u0001\u0000\u0000\u0000\u0116\u010a"+
		"\u0001\u0000\u0000\u0000\u0116\u010d\u0001\u0000\u0000\u0000\u0116\u0110"+
		"\u0001\u0000\u0000\u0000\u0116\u0113\u0001\u0000\u0000\u0000\u0117\u001b"+
		"\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u001a\u0000\u0000\u0119\u011a"+
		"\u0006\u000e\uffff\uffff\u0000\u011a\u011f\u0006\u000e\uffff\uffff\u0000"+
		"\u011b\u011c\u0005\u001b\u0000\u0000\u011c\u011d\u0006\u000e\uffff\uffff"+
		"\u0000\u011d\u011f\u0006\u000e\uffff\uffff\u0000\u011e\u0118\u0001\u0000"+
		"\u0000\u0000\u011e\u011b\u0001\u0000\u0000\u0000\u011f\u001d\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0005\r\u0000\u0000\u0121\u0122\u0005 \u0000"+
		"\u0000\u0122\u0123\u00032\u0019\u0000\u0123\u0124\u0005!\u0000\u0000\u0124"+
		"\u0125\u0003\u001a\r\u0000\u0125\u012a\u0006\u000f\uffff\uffff\u0000\u0126"+
		"\u0127\u0005\u000e\u0000\u0000\u0127\u0128\u0003\u001a\r\u0000\u0128\u0129"+
		"\u0006\u000f\uffff\uffff\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a"+
		"\u0126\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0006\u000f\uffff\uffff\u0000"+
		"\u012d\u001f\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u000f\u0000\u0000"+
		"\u012f\u0138\u0005 \u0000\u0000\u0130\u0135\u00038\u001c\u0000\u0131\u0132"+
		"\u0005\u001f\u0000\u0000\u0132\u0134\u00038\u001c\u0000\u0133\u0131\u0001"+
		"\u0000\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0139\u0001"+
		"\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0130\u0001"+
		"\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0001"+
		"\u0000\u0000\u0000\u013a\u013c\u0005\u001e\u0000\u0000\u013b\u013d\u0003"+
		"2\u0019\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000"+
		"\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u014c\u0005\u001e"+
		"\u0000\u0000\u013f\u0140\u0003,\u0016\u0000\u0140\u0141\u0005$\u0000\u0000"+
		"\u0141\u0149\u00032\u0019\u0000\u0142\u0143\u0005\u001f\u0000\u0000\u0143"+
		"\u0144\u0003,\u0016\u0000\u0144\u0145\u0005$\u0000\u0000\u0145\u0146\u0003"+
		"2\u0019\u0000\u0146\u0148\u0001\u0000\u0000\u0000\u0147\u0142\u0001\u0000"+
		"\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000"+
		"\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014d\u0001\u0000"+
		"\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u013f\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0005!\u0000\u0000\u014f\u0150\u0003\u001a\r"+
		"\u0000\u0150!\u0001\u0000\u0000\u0000\u0151\u0152\u0005\u0010\u0000\u0000"+
		"\u0152\u0153\u0005 \u0000\u0000\u0153\u0154\u00032\u0019\u0000\u0154\u0155"+
		"\u0005!\u0000\u0000\u0155\u0156\u0003\u001a\r\u0000\u0156#\u0001\u0000"+
		"\u0000\u0000\u0157\u0158\u0003,\u0016\u0000\u0158\u0159\u0005$\u0000\u0000"+
		"\u0159\u015a\u00032\u0019\u0000\u015a\u015b\u0006\u0012\uffff\uffff\u0000"+
		"\u015b\u015c\u0005\u001e\u0000\u0000\u015c\u015d\u0006\u0012\uffff\uffff"+
		"\u0000\u015d%\u0001\u0000\u0000\u0000\u015e\u015f\u0006\u0013\uffff\uffff"+
		"\u0000\u015f\u0163\u0005\u0012\u0000\u0000\u0160\u0161\u00032\u0019\u0000"+
		"\u0161\u0162\u0006\u0013\uffff\uffff\u0000\u0162\u0164\u0001\u0000\u0000"+
		"\u0000\u0163\u0160\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0005\u001e\u0000"+
		"\u0000\u0166\u0167\u0006\u0013\uffff\uffff\u0000\u0167\'\u0001\u0000\u0000"+
		"\u0000\u0168\u0169\u0005\u0013\u0000\u0000\u0169\u016a\u0003,\u0016\u0000"+
		"\u016a\u016b\u0006\u0014\uffff\uffff\u0000\u016b\u016c\u0005\u001e\u0000"+
		"\u0000\u016c\u016d\u0006\u0014\uffff\uffff\u0000\u016d)\u0001\u0000\u0000"+
		"\u0000\u016e\u016f\u0005\u0014\u0000\u0000\u016f\u0170\u00032\u0019\u0000"+
		"\u0170\u0171\u0006\u0015\uffff\uffff\u0000\u0171\u0172\u0005\u001e\u0000"+
		"\u0000\u0172\u0173\u0006\u0015\uffff\uffff\u0000\u0173+\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0005\u0015\u0000\u0000\u0175\u017b\u0006\u0016\uffff"+
		"\uffff\u0000\u0176\u0177\u0005%\u0000\u0000\u0177\u0178\u00056\u0000\u0000"+
		"\u0178\u017a\u0006\u0016\uffff\uffff\u0000\u0179\u0176\u0001\u0000\u0000"+
		"\u0000\u017a\u017d\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000"+
		"\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u0189\u0001\u0000\u0000"+
		"\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017e\u017f\u00056\u0000\u0000"+
		"\u017f\u0185\u0006\u0016\uffff\uffff\u0000\u0180\u0181\u0005%\u0000\u0000"+
		"\u0181\u0182\u00056\u0000\u0000\u0182\u0184\u0006\u0016\uffff\uffff\u0000"+
		"\u0183\u0180\u0001\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000"+
		"\u0185\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000"+
		"\u0186\u0189\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000"+
		"\u0188\u0174\u0001\u0000\u0000\u0000\u0188\u017e\u0001\u0000\u0000\u0000"+
		"\u0189-\u0001\u0000\u0000\u0000\u018a\u018b\u0005\u0015\u0000\u0000\u018b"+
		"\u018c\u0005%\u0000\u0000\u018c\u018d\u00056\u0000\u0000\u018d\u018e\u0006"+
		"\u0017\uffff\uffff\u0000\u018e\u018f\u0005 \u0000\u0000\u018f\u0190\u0003"+
		"0\u0018\u0000\u0190\u0191\u0005!\u0000\u0000\u0191\u0192\u0006\u0017\uffff"+
		"\uffff\u0000\u0192\u01a4\u0001\u0000\u0000\u0000\u0193\u0194\u00056\u0000"+
		"\u0000\u0194\u0195\u0005%\u0000\u0000\u0195\u0196\u00056\u0000\u0000\u0196"+
		"\u0197\u0006\u0017\uffff\uffff\u0000\u0197\u0198\u0005 \u0000\u0000\u0198"+
		"\u0199\u00030\u0018\u0000\u0199\u019a\u0005!\u0000\u0000\u019a\u019b\u0006"+
		"\u0017\uffff\uffff\u0000\u019b\u01a4\u0001\u0000\u0000\u0000\u019c\u019d"+
		"\u00056\u0000\u0000\u019d\u019e\u0006\u0017\uffff\uffff\u0000\u019e\u019f"+
		"\u0005 \u0000\u0000\u019f\u01a0\u00030\u0018\u0000\u01a0\u01a1\u0005!"+
		"\u0000\u0000\u01a1\u01a2\u0006\u0017\uffff\uffff\u0000\u01a2\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a3\u018a\u0001\u0000\u0000\u0000\u01a3\u0193\u0001"+
		"\u0000\u0000\u0000\u01a3\u019c\u0001\u0000\u0000\u0000\u01a4/\u0001\u0000"+
		"\u0000\u0000\u01a5\u01b1\u0006\u0018\uffff\uffff\u0000\u01a6\u01a7\u0003"+
		"2\u0019\u0000\u01a7\u01ae\u0006\u0018\uffff\uffff\u0000\u01a8\u01a9\u0005"+
		"\u001f\u0000\u0000\u01a9\u01aa\u00032\u0019\u0000\u01aa\u01ab\u0006\u0018"+
		"\uffff\uffff\u0000\u01ab\u01ad\u0001\u0000\u0000\u0000\u01ac\u01a8\u0001"+
		"\u0000\u0000\u0000\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001"+
		"\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b1\u01a6\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b21\u0001\u0000"+
		"\u0000\u0000\u01b3\u01b4\u00034\u001a\u0000\u01b4\u01bb\u0006\u0019\uffff"+
		"\uffff\u0000\u01b5\u01b6\u00036\u001b\u0000\u01b6\u01b7\u00034\u001a\u0000"+
		"\u01b7\u01b8\u0006\u0019\uffff\uffff\u0000\u01b8\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b9\u01b5\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000"+
		"\u0000\u01bc3\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000"+
		"\u01be\u01bf\u0003.\u0017\u0000\u01bf\u01c0\u0006\u001a\uffff\uffff\u0000"+
		"\u01c0\u01df\u0001\u0000\u0000\u0000\u01c1\u01c2\u0003,\u0016\u0000\u01c2"+
		"\u01c3\u0006\u001a\uffff\uffff\u0000\u01c3\u01df\u0001\u0000\u0000\u0000"+
		"\u01c4\u01c5\u0003\u0016\u000b\u0000\u01c5\u01c6\u0006\u001a\uffff\uffff"+
		"\u0000\u01c6\u01df\u0001\u0000\u0000\u0000\u01c7\u01c8\u0005 \u0000\u0000"+
		"\u01c8\u01c9\u00032\u0019\u0000\u01c9\u01ca\u0005!\u0000\u0000\u01ca\u01cb"+
		"\u0006\u001a\uffff\uffff\u0000\u01cb\u01df\u0001\u0000\u0000\u0000\u01cc"+
		"\u01cd\u00052\u0000\u0000\u01cd\u01df\u0006\u001a\uffff\uffff\u0000\u01ce"+
		"\u01cf\u00053\u0000\u0000\u01cf\u01df\u0006\u001a\uffff\uffff\u0000\u01d0"+
		"\u01d1\u00054\u0000\u0000\u01d1\u01df\u0006\u001a\uffff\uffff\u0000\u01d2"+
		"\u01d3\u00055\u0000\u0000\u01d3\u01df\u0006\u001a\uffff\uffff\u0000\u01d4"+
		"\u01d5\u0005\u001d\u0000\u0000\u01d5\u01df\u0006\u001a\uffff\uffff\u0000"+
		"\u01d6\u01d7\u0005\'\u0000\u0000\u01d7\u01d8\u00034\u001a\u0000\u01d8"+
		"\u01d9\u0006\u001a\uffff\uffff\u0000\u01d9\u01df\u0001\u0000\u0000\u0000"+
		"\u01da\u01db\u0005\u0016\u0000\u0000\u01db\u01dc\u00034\u001a\u0000\u01dc"+
		"\u01dd\u0006\u001a\uffff\uffff\u0000\u01dd\u01df\u0001\u0000\u0000\u0000"+
		"\u01de\u01be\u0001\u0000\u0000\u0000\u01de\u01c1\u0001\u0000\u0000\u0000"+
		"\u01de\u01c4\u0001\u0000\u0000\u0000\u01de\u01c7\u0001\u0000\u0000\u0000"+
		"\u01de\u01cc\u0001\u0000\u0000\u0000\u01de\u01ce\u0001\u0000\u0000\u0000"+
		"\u01de\u01d0\u0001\u0000\u0000\u0000\u01de\u01d2\u0001\u0000\u0000\u0000"+
		"\u01de\u01d4\u0001\u0000\u0000\u0000\u01de\u01d6\u0001\u0000\u0000\u0000"+
		"\u01de\u01da\u0001\u0000\u0000\u0000\u01df5\u0001\u0000\u0000\u0000\u01e0"+
		"\u01e1\u0007\u0000\u0000\u0000\u01e17\u0001\u0000\u0000\u0000\u01e2\u01e3"+
		"\u0003,\u0016\u0000\u01e3\u01e4\u0005$\u0000\u0000\u01e4\u01e5\u00032"+
		"\u0019\u0000\u01e5\u01e6\u0006\u001c\uffff\uffff\u0000\u01e6\u01f0\u0001"+
		"\u0000\u0000\u0000\u01e7\u01e8\u0003\u0014\n\u0000\u01e8\u01e9\u0005$"+
		"\u0000\u0000\u01e9\u01ea\u00032\u0019\u0000\u01ea\u01eb\u0006\u001c\uffff"+
		"\uffff\u0000\u01eb\u01f0\u0001\u0000\u0000\u0000\u01ec\u01ed\u0003\u0014"+
		"\n\u0000\u01ed\u01ee\u0006\u001c\uffff\uffff\u0000\u01ee\u01f0\u0001\u0000"+
		"\u0000\u0000\u01ef\u01e2\u0001\u0000\u0000\u0000\u01ef\u01e7\u0001\u0000"+
		"\u0000\u0000\u01ef\u01ec\u0001\u0000\u0000\u0000\u01f09\u0001\u0000\u0000"+
		"\u0000$@KX[cqz\u0083\u0089\u009d\u00a0\u00a5\u00ba\u00bf\u00c7\u00d8\u00db"+
		"\u00e7\u0116\u011e\u012a\u0135\u0138\u013c\u0149\u014c\u0163\u017b\u0185"+
		"\u0188\u01a3\u01ae\u01b1\u01bb\u01de\u01ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}