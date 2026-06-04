// Generated from c:/Users/lenovo/Downloads/UT/6/PLC/CA/2/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.1

    import java.util.*;

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
		RULE_outputStmt = 21, RULE_loc = 22, RULE_receiver = 23, RULE_methodcall = 24, 
		RULE_expr = 25, RULE_initexpr = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "topLevelDecl", "module", "structDef", "member", "accessModifier", 
			"method_decl", "arguments", "parameter", "type", "vardecl", "cons", "block", 
			"st", "jumpStmt", "ifStmt", "forStmt", "whileStmt", "assignStmt", "returnStmt", 
			"inputStmt", "outputStmt", "loc", "receiver", "methodcall", "expr", "initexpr"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).programRet =  new Program(); 
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_MODULE || _la==KW_STRUCT) {
				{
				{
				setState(55);
				((ProgramContext)_localctx).t = topLevelDecl();
				 _localctx.programRet.addTopLevelDeclaration(((ProgramContext)_localctx).t.topLevelDeclRet); 
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((TopLevelDeclContext)_localctx).m = module();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet = ((TopLevelDeclContext)_localctx).m.moduleRet;

				         
				}
				break;
			case KW_STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
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
		public Module moduleRet;
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
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((ModuleContext)_localctx).k = match(KW_MODULE);
			setState(74);
			((ModuleContext)_localctx).i = match(ID);
			 ((ModuleContext)_localctx).moduleRet =  new Module(new Identifier((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getText():null)));
			        _localctx.moduleRet.setLine((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getLine():0)); 
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INCLUDES) {
				{
				setState(76);
				match(KW_INCLUDES);
				setState(77);
				((ModuleContext)_localctx).i1 = match(ID);
				 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i1!=null?((ModuleContext)_localctx).i1.getText():null))); 
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(79);
					match(COMMA);
					setState(80);
					((ModuleContext)_localctx).i2 = match(ID);
					 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i2!=null?((ModuleContext)_localctx).i2.getText():null))); 
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(89);
			match(KW_BEGIN);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(90);
				((ModuleContext)_localctx).m = member();
				 _localctx.moduleRet.addMember(((ModuleContext)_localctx).m.memberRet); 
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
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
	}

	public final StructDefContext structDef() throws RecognitionException {
		StructDefContext _localctx = new StructDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			((StructDefContext)_localctx).k = match(KW_STRUCT);
			setState(101);
			((StructDefContext)_localctx).i = match(ID);

			            ((StructDefContext)_localctx).structRet =  new Struct(new Identifier((((StructDefContext)_localctx).i!=null?((StructDefContext)_localctx).i.getText():null)));
			            _localctx.structRet.setLine((((StructDefContext)_localctx).i!=null?((StructDefContext)_localctx).i.getLine():0));
			        
			setState(103);
			match(KW_BEGIN);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(104);
				((StructDefContext)_localctx).m = member();
				 _localctx.structRet.addMember(((StructDefContext)_localctx).m.memberRet); 
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
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
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 AccessModifier access = AccessModifier.PUBLIC; 
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
				{
				setState(115);
				((MemberContext)_localctx).am = accessModifier();
				 access = ((MemberContext)_localctx).am.accessModifierRet; 
				}
			}

			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(120);
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
				setState(123);
				((MemberContext)_localctx).v = vardecl();
				setState(124);
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
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_accessModifier);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				((AccessModifierContext)_localctx).pr = match(KW_PRIVATE);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PRIVATE; 
				}
				break;
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
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
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			((Method_declContext)_localctx).t = type();
			setState(136);
			((Method_declContext)_localctx).i = match(ID);
			setState(137);
			match(LPAREN);
			setState(138);
			((Method_declContext)_localctx).a = arguments();
			setState(139);
			match(RPAREN);
			setState(140);
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
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentsContext)_localctx).parametersRet =  new ArrayList<>(); 
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811479808L) != 0)) {
				{
				setState(145);
				((ArgumentsContext)_localctx).p1 = parameter();
				 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p1.parameterRet); 
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147);
					match(COMMA);
					setState(148);
					((ArgumentsContext)_localctx).p2 = parameter();
					 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p2.parameterRet); 
					}
					}
					setState(155);
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
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(159);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(163);
			((ParameterContext)_localctx).t = type();
			setState(164);
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				((TypeContext)_localctx).i = match(ID);
				 ((TypeContext)_localctx).typeRet =  new UserDefinedType(new Identifier((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null))); 
				}
				break;
			case KW_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(KW_INT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("int"); 
				}
				break;
			case KW_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(KW_FLOAT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("float"); 
				}
				break;
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				match(KW_DOUBLE);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("double"); 
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				match(KW_CHAR);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("char"); 
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(178);
				match(KW_VOID);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType("void"); 
				}
				break;
			case KW_BOOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(180);
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
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(185);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(189);
				((VardeclContext)_localctx).t = type();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).t.typeRet); 
				}
				break;
			case 2:
				{
				setState(192);
				((VardeclContext)_localctx).c = cons();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).c.constructorCallRet); 
				}
				break;
			}
			setState(197);
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
	}

	public final ConsContext cons() throws RecognitionException {
		ConsContext _localctx = new ConsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cons);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((ConsContext)_localctx).i = match(ID);
			 ((ConsContext)_localctx).constructorCallRet =  new ConstructorCall(new Identifier((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getText():null))); 
			setState(203);
			match(LPAREN);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(204);
				((ConsContext)_localctx).e1 = expr(0);
				 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e1.expressionRet); 
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(206);
					match(COMMA);
					setState(207);
					((ConsContext)_localctx).e2 = expr(0);
					 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(217);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((BlockContext)_localctx).blockRet =  new Block(); 
			setState(221);
			((BlockContext)_localctx).k = match(KW_BEGIN);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014399016845072L) != 0)) {
				{
				{
				setState(222);
				((BlockContext)_localctx).s = st();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.statementRet); 
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
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
		public VardeclContext vd;
		public VardeclContext v;
		public ExprContext e;
		public MethodcallContext mc;
		public IfStmtContext ifs;
		public ForStmtContext fs;
		public WhileStmtContext ws;
		public AssignStmtContext as;
		public ReturnStmtContext rs;
		public InputStmtContext is;
		public OutputStmtContext os;
		public JumpStmtContext js;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
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
		public StContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st; }
	}

	public final StContext st() throws RecognitionException {
		StContext _localctx = new StContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_st);
		try {
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				((StContext)_localctx).b = block();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).b.blockRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).b.blockRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				((StContext)_localctx).vd = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).vd.varRet); 
				setState(239);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).vd.varRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				((StContext)_localctx).v = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).v.varRet); 
				setState(244);
				match(ASSIGN);
				setState(245);
				((StContext)_localctx).e = expr(0);
				 ((VarDeclStmt)_localctx.statementRet).setInitial(((StContext)_localctx).e.expressionRet); 
				setState(247);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).v.varRet.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				((StContext)_localctx).mc = methodcall();
				 ((StContext)_localctx).statementRet =  new MethodCallStmt(((StContext)_localctx).mc.methodCallRet); 
				setState(252);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).mc.methodCallRet.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				((StContext)_localctx).ifs = ifStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).ifs.ifStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).ifs.ifStmtRet.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				((StContext)_localctx).fs = forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				((StContext)_localctx).ws = whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				((StContext)_localctx).as = assignStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).as.assignStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).as.assignStmtRet.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(265);
				((StContext)_localctx).rs = returnStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).rs.returnStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).rs.returnStmtRet.getLine()); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(269);
				((StContext)_localctx).is = inputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).is.inputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).is.inputStmtRet.getLine()); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(273);
				((StContext)_localctx).os = outputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).os.outputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).os.outputStmtRet.getLine()); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(277);
				((StContext)_localctx).js = jumpStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).js.jumpStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).js.jumpStmtRet.getLine()); 
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
	}

	public final JumpStmtContext jumpStmt() throws RecognitionException {
		JumpStmtContext _localctx = new JumpStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jumpStmt);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				((JumpStmtContext)_localctx).kb = match(KW_BREAK);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new BreakJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kb!=null?((JumpStmtContext)_localctx).kb.getLine():0)); 
				}
				break;
			case KW_CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
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
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			((IfStmtContext)_localctx).k = match(KW_IF);
			setState(292);
			match(LPAREN);
			setState(293);
			((IfStmtContext)_localctx).e = expr(0);
			setState(294);
			match(RPAREN);
			setState(295);
			((IfStmtContext)_localctx).s1 = st();
			 ((IfStmtContext)_localctx).ifStmtRet =  new IfStmt(((IfStmtContext)_localctx).e.expressionRet, ((IfStmtContext)_localctx).s1.statementRet); 
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(297);
				match(KW_ELSE);
				setState(298);
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
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(KW_FOR);
			setState(306);
			match(LPAREN);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398813576960L) != 0)) {
				{
				setState(307);
				initexpr();
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(308);
					match(COMMA);
					setState(309);
					initexpr();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(317);
			match(SEMI);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(318);
				expr(0);
				}
			}

			setState(321);
			match(SEMI);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THIS || _la==ID) {
				{
				setState(322);
				loc();
				setState(323);
				match(ASSIGN);
				setState(324);
				expr(0);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(325);
					match(COMMA);
					setState(326);
					loc();
					setState(327);
					match(ASSIGN);
					setState(328);
					expr(0);
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(337);
			match(RPAREN);
			setState(338);
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
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(KW_WHILE);
			setState(341);
			match(LPAREN);
			setState(342);
			expr(0);
			setState(343);
			match(RPAREN);
			setState(344);
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
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			((AssignStmtContext)_localctx).l = loc();
			setState(347);
			((AssignStmtContext)_localctx).a = match(ASSIGN);
			setState(348);
			((AssignStmtContext)_localctx).e = expr(0);
			 ((AssignStmtContext)_localctx).assignStmtRet =  new AssignStmt(((AssignStmtContext)_localctx).l.locationRet, ((AssignStmtContext)_localctx).e.expressionRet); 
			setState(350);
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
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ReturnStmtContext)_localctx).returnStmtRet =  new ReturnStmt(); 
			setState(354);
			((ReturnStmtContext)_localctx).k = match(KW_RETURN);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(355);
				((ReturnStmtContext)_localctx).e = expr(0);
				 _localctx.returnStmtRet.setValue(((ReturnStmtContext)_localctx).e.expressionRet); 
				}
			}

			setState(360);
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
	}

	public final InputStmtContext inputStmt() throws RecognitionException {
		InputStmtContext _localctx = new InputStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			((InputStmtContext)_localctx).k = match(KW_INPUT);
			setState(364);
			((InputStmtContext)_localctx).l = loc();
			 ((InputStmtContext)_localctx).inputStmtRet =  new InputStmt(((InputStmtContext)_localctx).l.locationRet); 
			setState(366);
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
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_outputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			((OutputStmtContext)_localctx).k = match(KW_OUTPUT);
			setState(370);
			((OutputStmtContext)_localctx).e = expr(0);
			 ((OutputStmtContext)_localctx).outputStmtRet =  new OutputStmt(((OutputStmtContext)_localctx).e.expressionRet); 
			setState(372);
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
	}

	public final LocContext loc() throws RecognitionException {
		LocContext _localctx = new LocContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loc);
		try {
			int _alt;
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_THIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				((LocContext)_localctx).k = match(KW_THIS);

				            ((LocContext)_localctx).locationRet =  new ThisLoc();
				            _localctx.locationRet.setLine((((LocContext)_localctx).k!=null?((LocContext)_localctx).k.getLine():0));
				        
				setState(382);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(377);
						match(DOT);
						setState(378);
						((LocContext)_localctx).i = match(ID);

						                ((LocContext)_localctx).locationRet =  new Location(_localctx.locationRet, new Identifier((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getText():null)));
						                _localctx.locationRet.setLine((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getLine():0));
						            
						}
						} 
					}
					setState(384);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				((LocContext)_localctx).i = match(ID);

				            ((LocContext)_localctx).locationRet =  new Location(new Identifier((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getText():null)));
				            _localctx.locationRet.setLine((((LocContext)_localctx).i!=null?((LocContext)_localctx).i.getLine():0));
				        
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(387);
						match(DOT);
						setState(388);
						((LocContext)_localctx).j = match(ID);

						                ((LocContext)_localctx).locationRet =  new Location(_localctx.locationRet, new Identifier((((LocContext)_localctx).j!=null?((LocContext)_localctx).j.getText():null)));
						                _localctx.locationRet.setLine((((LocContext)_localctx).j!=null?((LocContext)_localctx).j.getLine():0));
						            
						}
						} 
					}
					setState(394);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
	public static class ReceiverContext extends ParserRuleContext {
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
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_receiver);
		try {
			int _alt;
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_THIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				((ReceiverContext)_localctx).k = match(KW_THIS);

				            ((ReceiverContext)_localctx).locationRet =  new ThisLoc();
				            _localctx.locationRet.setLine((((ReceiverContext)_localctx).k!=null?((ReceiverContext)_localctx).k.getLine():0));
				        
				setState(404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(399);
						match(DOT);
						setState(400);
						((ReceiverContext)_localctx).i = match(ID);

						                ((ReceiverContext)_localctx).locationRet =  new Location(_localctx.locationRet, new Identifier((((ReceiverContext)_localctx).i!=null?((ReceiverContext)_localctx).i.getText():null)));
						                _localctx.locationRet.setLine((((ReceiverContext)_localctx).i!=null?((ReceiverContext)_localctx).i.getLine():0));
						            
						}
						} 
					}
					setState(406);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				((ReceiverContext)_localctx).i = match(ID);

				            ((ReceiverContext)_localctx).locationRet =  new Location(new Identifier((((ReceiverContext)_localctx).i!=null?((ReceiverContext)_localctx).i.getText():null)));
				            _localctx.locationRet.setLine((((ReceiverContext)_localctx).i!=null?((ReceiverContext)_localctx).i.getLine():0));
				        
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(409);
						match(DOT);
						setState(410);
						((ReceiverContext)_localctx).j = match(ID);

						                ((ReceiverContext)_localctx).locationRet =  new Location(_localctx.locationRet, new Identifier((((ReceiverContext)_localctx).j!=null?((ReceiverContext)_localctx).j.getText():null)));
						                _localctx.locationRet.setLine((((ReceiverContext)_localctx).j!=null?((ReceiverContext)_localctx).j.getLine():0));
						            
						}
						} 
					}
					setState(416);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public ReceiverContext r;
		public Token i;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode DOT() { return getToken(SimpleLangParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
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
		public MethodcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodcall; }
	}

	public final MethodcallContext methodcall() throws RecognitionException {
		MethodcallContext _localctx = new MethodcallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_methodcall);
		int _la;
		try {
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				((MethodcallContext)_localctx).r = receiver();
				setState(420);
				match(DOT);
				setState(421);
				((MethodcallContext)_localctx).i = match(ID);
				 ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(((MethodcallContext)_localctx).r.locationRet, new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null))); 
				setState(423);
				match(LPAREN);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
					{
					setState(424);
					((MethodcallContext)_localctx).e1 = expr(0);
					 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e1.expressionRet); 
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(426);
						match(COMMA);
						setState(427);
						((MethodcallContext)_localctx).e2 = expr(0);
						 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e2.expressionRet); 
						}
						}
						setState(434);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(437);
				match(RPAREN);
				 _localctx.methodCallRet.setLine((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getLine():0)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				((MethodcallContext)_localctx).i = match(ID);
				 ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null))); 
				setState(442);
				match(LPAREN);
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
					{
					setState(443);
					((MethodcallContext)_localctx).e1 = expr(0);
					 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e1.expressionRet); 
					setState(451);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(445);
						match(COMMA);
						setState(446);
						((MethodcallContext)_localctx).e2 = expr(0);
						 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e2.expressionRet); 
						}
						}
						setState(453);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(456);
				match(RPAREN);
				 _localctx.methodCallRet.setLine((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getLine():0)); 
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
		public Expression expressionRet;
		public LocContext l;
		public Token k;
		public MethodcallContext mc;
		public ConsContext c;
		public ExprContext e;
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public TerminalNode KW_THIS() { return getToken(SimpleLangParser.KW_THIS, 0); }
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONSTINT() { return getToken(SimpleLangParser.CONSTINT, 0); }
		public TerminalNode CONSTFLOAT() { return getToken(SimpleLangParser.CONSTFLOAT, 0); }
		public TerminalNode CONSTDOUBLE() { return getToken(SimpleLangParser.CONSTDOUBLE, 0); }
		public TerminalNode CONSTCHAR() { return getToken(SimpleLangParser.CONSTCHAR, 0); }
		public TerminalNode CONSTBOOL() { return getToken(SimpleLangParser.CONSTBOOL, 0); }
		public TerminalNode MINUS() { return getToken(SimpleLangParser.MINUS, 0); }
		public TerminalNode KW_NOT() { return getToken(SimpleLangParser.KW_NOT, 0); }
		public TerminalNode STAR() { return getToken(SimpleLangParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(SimpleLangParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(SimpleLangParser.PLUS, 0); }
		public TerminalNode LESS() { return getToken(SimpleLangParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(SimpleLangParser.GREATER, 0); }
		public TerminalNode LESS_EQ() { return getToken(SimpleLangParser.LESS_EQ, 0); }
		public TerminalNode GREATER_EQ() { return getToken(SimpleLangParser.GREATER_EQ, 0); }
		public TerminalNode EQUAL() { return getToken(SimpleLangParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SimpleLangParser.NOT_EQUAL, 0); }
		public TerminalNode KW_AND() { return getToken(SimpleLangParser.KW_AND, 0); }
		public TerminalNode KW_OR() { return getToken(SimpleLangParser.KW_OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(461);
				((ExprContext)_localctx).l = loc();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).l.locationRet; 
				}
				break;
			case 2:
				{
				setState(464);
				((ExprContext)_localctx).k = match(KW_THIS);

				            ((ExprContext)_localctx).expressionRet =  new ThisLoc();
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).k!=null?((ExprContext)_localctx).k.getLine():0));
				        
				}
				break;
			case 3:
				{
				setState(466);
				((ExprContext)_localctx).mc = methodcall();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).mc.methodCallRet; 
				}
				break;
			case 4:
				{
				setState(469);
				((ExprContext)_localctx).c = cons();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).c.constructorCallRet; 
				}
				break;
			case 5:
				{
				setState(472);
				match(LPAREN);
				setState(473);
				((ExprContext)_localctx).e = expr(0);
				setState(474);
				match(RPAREN);
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).e.expressionRet; 
				}
				break;
			case 6:
				{
				setState(477);
				match(CONSTINT);
				 ((ExprContext)_localctx).expressionRet =  null; 
				}
				break;
			case 7:
				{
				setState(479);
				match(CONSTFLOAT);
				 ((ExprContext)_localctx).expressionRet =  null; 
				}
				break;
			case 8:
				{
				setState(481);
				match(CONSTDOUBLE);
				 ((ExprContext)_localctx).expressionRet =  null; 
				}
				break;
			case 9:
				{
				setState(483);
				match(CONSTCHAR);
				 ((ExprContext)_localctx).expressionRet =  null; 
				}
				break;
			case 10:
				{
				setState(485);
				match(CONSTBOOL);
				 ((ExprContext)_localctx).expressionRet =  null; 
				}
				break;
			case 11:
				{
				setState(487);
				_la = _input.LA(1);
				if ( !(_la==KW_NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(488);
				expr(7);
				 ((ExprContext)_localctx).expressionRet =  null; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(525);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(523);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(493);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(494);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(495);
						expr(7);
						 ((ExprContext)_localctx).expressionRet =  null; 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(498);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(499);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(500);
						expr(6);
						 ((ExprContext)_localctx).expressionRet =  null; 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(503);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(504);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 263882790666240L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(505);
						expr(5);
						 ((ExprContext)_localctx).expressionRet =  null; 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(508);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(509);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(510);
						expr(4);
						 ((ExprContext)_localctx).expressionRet =  null; 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(513);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(514);
						match(KW_AND);
						setState(515);
						expr(3);
						 ((ExprContext)_localctx).expressionRet =  null; 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(518);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(519);
						match(KW_OR);
						setState(520);
						expr(2);
						 ((ExprContext)_localctx).expressionRet =  null; 
						}
						break;
					}
					} 
				}
				setState(527);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
	public static class InitexprContext extends ParserRuleContext {
		public Statement initExprRet;
		public VardeclContext v1;
		public LocContext l1;
		public ExprContext e1;
		public VardeclContext v2;
		public ExprContext e2;
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InitexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initexpr; }
	}

	public final InitexprContext initexpr() throws RecognitionException {
		InitexprContext _localctx = new InitexprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_initexpr);
		try {
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				((InitexprContext)_localctx).v1 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v1.varRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v1.varRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(532);
				((InitexprContext)_localctx).l1 = loc();
				setState(533);
				match(ASSIGN);
				setState(534);
				((InitexprContext)_localctx).e1 = expr(0);
				 ((InitexprContext)_localctx).initExprRet =  new AssignStmt(((InitexprContext)_localctx).l1.locationRet, ((InitexprContext)_localctx).e1.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).l1.locationRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(538);
				((InitexprContext)_localctx).v2 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v2.varRet); 
				setState(540);
				match(ASSIGN);
				setState(541);
				((InitexprContext)_localctx).e2 = expr(0);
				 ((VarDeclStmt)_localctx.initExprRet).setInitial(((InitexprContext)_localctx).e2.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v2.varRet.getLine()); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u0224\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000;\b\u0000\n\u0000\f\u0000>\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001H\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002S\b\u0002\n\u0002\f\u0002V\t\u0002\u0003\u0002"+
		"X\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"^\b\u0002\n\u0002\f\u0002a\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003l\b\u0003\n\u0003\f\u0003o\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004w\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0080\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0086\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u0098\b\u0007\n\u0007\f\u0007\u009b\t\u0007\u0003"+
		"\u0007\u009d\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00a2\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00b7\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u00bc\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c4\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d3"+
		"\b\u000b\n\u000b\f\u000b\u00d6\t\u000b\u0003\u000b\u00d8\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00e2\b\f\n\f\f\f\u00e5\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u011a\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0122\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u012e\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0137\b\u0010\n\u0010\f\u0010\u013a\t\u0010\u0003\u0010\u013c\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0140\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u014b\b\u0010\n\u0010\f\u0010\u014e\t\u0010"+
		"\u0003\u0010\u0150\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0167\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u017d\b\u0016\n\u0016"+
		"\f\u0016\u0180\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u0187\b\u0016\n\u0016\f\u0016\u018a\t\u0016\u0003"+
		"\u0016\u018c\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0193\b\u0017\n\u0017\f\u0017\u0196\t\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u019d\b\u0017"+
		"\n\u0017\f\u0017\u01a0\t\u0017\u0003\u0017\u01a2\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01af\b\u0018\n"+
		"\u0018\f\u0018\u01b2\t\u0018\u0003\u0018\u01b4\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01c2"+
		"\b\u0018\n\u0018\f\u0018\u01c5\t\u0018\u0003\u0018\u01c7\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u01cb\b\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01ec"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u020c\b\u0019\n\u0019\f\u0019\u020f\t\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0222\b\u001a"+
		"\u0001\u001a\u0000\u00012\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0005\u0002"+
		"\u0000\u0016\u0016\'\'\u0001\u0000)*\u0001\u0000\'(\u0001\u0000,/\u0001"+
		"\u000001\u024f\u00006\u0001\u0000\u0000\u0000\u0002G\u0001\u0000\u0000"+
		"\u0000\u0004I\u0001\u0000\u0000\u0000\u0006d\u0001\u0000\u0000\u0000\b"+
		"r\u0001\u0000\u0000\u0000\n\u0085\u0001\u0000\u0000\u0000\f\u0087\u0001"+
		"\u0000\u0000\u0000\u000e\u0090\u0001\u0000\u0000\u0000\u0010\u009e\u0001"+
		"\u0000\u0000\u0000\u0012\u00b6\u0001\u0000\u0000\u0000\u0014\u00b8\u0001"+
		"\u0000\u0000\u0000\u0016\u00c9\u0001\u0000\u0000\u0000\u0018\u00dc\u0001"+
		"\u0000\u0000\u0000\u001a\u0119\u0001\u0000\u0000\u0000\u001c\u0121\u0001"+
		"\u0000\u0000\u0000\u001e\u0123\u0001\u0000\u0000\u0000 \u0131\u0001\u0000"+
		"\u0000\u0000\"\u0154\u0001\u0000\u0000\u0000$\u015a\u0001\u0000\u0000"+
		"\u0000&\u0161\u0001\u0000\u0000\u0000(\u016b\u0001\u0000\u0000\u0000*"+
		"\u0171\u0001\u0000\u0000\u0000,\u018b\u0001\u0000\u0000\u0000.\u01a1\u0001"+
		"\u0000\u0000\u00000\u01ca\u0001\u0000\u0000\u00002\u01eb\u0001\u0000\u0000"+
		"\u00004\u0221\u0001\u0000\u0000\u00006<\u0006\u0000\uffff\uffff\u0000"+
		"78\u0003\u0002\u0001\u000089\u0006\u0000\uffff\uffff\u00009;\u0001\u0000"+
		"\u0000\u0000:7\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000"+
		"><\u0001\u0000\u0000\u0000?@\u0005\u0000\u0000\u0001@\u0001\u0001\u0000"+
		"\u0000\u0000AB\u0003\u0004\u0002\u0000BC\u0006\u0001\uffff\uffff\u0000"+
		"CH\u0001\u0000\u0000\u0000DE\u0003\u0006\u0003\u0000EF\u0006\u0001\uffff"+
		"\uffff\u0000FH\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GD\u0001"+
		"\u0000\u0000\u0000H\u0003\u0001\u0000\u0000\u0000IJ\u0005\u0001\u0000"+
		"\u0000JK\u00056\u0000\u0000KW\u0006\u0002\uffff\uffff\u0000LM\u0005\u0003"+
		"\u0000\u0000MN\u00056\u0000\u0000NT\u0006\u0002\uffff\uffff\u0000OP\u0005"+
		"\u001f\u0000\u0000PQ\u00056\u0000\u0000QS\u0006\u0002\uffff\uffff\u0000"+
		"RO\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000WL\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y_\u0005\u0004\u0000\u0000Z[\u0003\b\u0004\u0000[\\"+
		"\u0006\u0002\uffff\uffff\u0000\\^\u0001\u0000\u0000\u0000]Z\u0001\u0000"+
		"\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"bc\u0005\u0005\u0000\u0000c\u0005\u0001\u0000\u0000\u0000de\u0005\u0002"+
		"\u0000\u0000ef\u00056\u0000\u0000fg\u0006\u0003\uffff\uffff\u0000gm\u0005"+
		"\u0004\u0000\u0000hi\u0003\b\u0004\u0000ij\u0006\u0003\uffff\uffff\u0000"+
		"jl\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005\u0005\u0000\u0000q\u0007"+
		"\u0001\u0000\u0000\u0000rv\u0006\u0004\uffff\uffff\u0000st\u0003\n\u0005"+
		"\u0000tu\u0006\u0004\uffff\uffff\u0000uw\u0001\u0000\u0000\u0000vs\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\u007f\u0001\u0000\u0000"+
		"\u0000xy\u0003\f\u0006\u0000yz\u0006\u0004\uffff\uffff\u0000z\u0080\u0001"+
		"\u0000\u0000\u0000{|\u0003\u0014\n\u0000|}\u0005\u001e\u0000\u0000}~\u0006"+
		"\u0004\uffff\uffff\u0000~\u0080\u0001\u0000\u0000\u0000\u007fx\u0001\u0000"+
		"\u0000\u0000\u007f{\u0001\u0000\u0000\u0000\u0080\t\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005\u0007\u0000\u0000\u0082\u0086\u0006\u0005\uffff"+
		"\uffff\u0000\u0083\u0084\u0005\u0006\u0000\u0000\u0084\u0086\u0006\u0005"+
		"\uffff\uffff\u0000\u0085\u0081\u0001\u0000\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0086\u000b\u0001\u0000\u0000\u0000\u0087\u0088\u0003"+
		"\u0012\t\u0000\u0088\u0089\u00056\u0000\u0000\u0089\u008a\u0005 \u0000"+
		"\u0000\u008a\u008b\u0003\u000e\u0007\u0000\u008b\u008c\u0005!\u0000\u0000"+
		"\u008c\u008d\u0003\u0018\f\u0000\u008d\u008e\u0006\u0006\uffff\uffff\u0000"+
		"\u008e\u008f\u0006\u0006\uffff\uffff\u0000\u008f\r\u0001\u0000\u0000\u0000"+
		"\u0090\u009c\u0006\u0007\uffff\uffff\u0000\u0091\u0092\u0003\u0010\b\u0000"+
		"\u0092\u0099\u0006\u0007\uffff\uffff\u0000\u0093\u0094\u0005\u001f\u0000"+
		"\u0000\u0094\u0095\u0003\u0010\b\u0000\u0095\u0096\u0006\u0007\uffff\uffff"+
		"\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0093\u0001\u0000\u0000"+
		"\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u0091\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u000f\u0001\u0000\u0000"+
		"\u0000\u009e\u00a1\u0006\b\uffff\uffff\u0000\u009f\u00a0\u0005\u0019\u0000"+
		"\u0000\u00a0\u00a2\u0006\b\uffff\uffff\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0003\u0012\t\u0000\u00a4\u00a5\u00056\u0000\u0000"+
		"\u00a5\u00a6\u0006\b\uffff\uffff\u0000\u00a6\u00a7\u0006\b\uffff\uffff"+
		"\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00a9\u00056\u0000\u0000"+
		"\u00a9\u00b7\u0006\t\uffff\uffff\u0000\u00aa\u00ab\u0005\b\u0000\u0000"+
		"\u00ab\u00b7\u0006\t\uffff\uffff\u0000\u00ac\u00ad\u0005\t\u0000\u0000"+
		"\u00ad\u00b7\u0006\t\uffff\uffff\u0000\u00ae\u00af\u0005\n\u0000\u0000"+
		"\u00af\u00b7\u0006\t\uffff\uffff\u0000\u00b0\u00b1\u0005\u000b\u0000\u0000"+
		"\u00b1\u00b7\u0006\t\uffff\uffff\u0000\u00b2\u00b3\u0005\f\u0000\u0000"+
		"\u00b3\u00b7\u0006\t\uffff\uffff\u0000\u00b4\u00b5\u0005\u001c\u0000\u0000"+
		"\u00b5\u00b7\u0006\t\uffff\uffff\u0000\u00b6\u00a8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00aa\u0001\u0000\u0000\u0000\u00b6\u00ac\u0001\u0000\u0000\u0000"+
		"\u00b6\u00ae\u0001\u0000\u0000\u0000\u00b6\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b2\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b7\u0013\u0001\u0000\u0000\u0000\u00b8\u00bb\u0006\n\uffff\uffff\u0000"+
		"\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bc\u0006\n\uffff\uffff\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00c3\u0001\u0000\u0000\u0000\u00bd\u00be\u0003\u0012\t\u0000\u00be"+
		"\u00bf\u0006\n\uffff\uffff\u0000\u00bf\u00c4\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0003\u0016\u000b\u0000\u00c1\u00c2\u0006\n\uffff\uffff\u0000\u00c2"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c3\u00bd\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u00056\u0000\u0000\u00c6\u00c7\u0006\n\uffff\uffff\u0000\u00c7"+
		"\u00c8\u0006\n\uffff\uffff\u0000\u00c8\u0015\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u00056\u0000\u0000\u00ca\u00cb\u0006\u000b\uffff\uffff\u0000\u00cb"+
		"\u00d7\u0005 \u0000\u0000\u00cc\u00cd\u00032\u0019\u0000\u00cd\u00d4\u0006"+
		"\u000b\uffff\uffff\u0000\u00ce\u00cf\u0005\u001f\u0000\u0000\u00cf\u00d0"+
		"\u00032\u0019\u0000\u00d0\u00d1\u0006\u000b\uffff\uffff\u0000\u00d1\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d3\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d7\u00cc\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005!\u0000\u0000\u00da\u00db\u0006\u000b\uffff\uffff\u0000\u00db\u0017"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0006\f\uffff\uffff\u0000\u00dd\u00e3"+
		"\u0005\u0004\u0000\u0000\u00de\u00df\u0003\u001a\r\u0000\u00df\u00e0\u0006"+
		"\f\uffff\uffff\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00de\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"\u0005\u0000\u0000\u00e7\u00e8\u0006\f\uffff\uffff\u0000\u00e8\u0019\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0003\u0018\f\u0000\u00ea\u00eb\u0006\r"+
		"\uffff\uffff\u0000\u00eb\u00ec\u0006\r\uffff\uffff\u0000\u00ec\u011a\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0003\u0014\n\u0000\u00ee\u00ef\u0006\r"+
		"\uffff\uffff\u0000\u00ef\u00f0\u0005\u001e\u0000\u0000\u00f0\u00f1\u0006"+
		"\r\uffff\uffff\u0000\u00f1\u011a\u0001\u0000\u0000\u0000\u00f2\u00f3\u0003"+
		"\u0014\n\u0000\u00f3\u00f4\u0006\r\uffff\uffff\u0000\u00f4\u00f5\u0005"+
		"$\u0000\u0000\u00f5\u00f6\u00032\u0019\u0000\u00f6\u00f7\u0006\r\uffff"+
		"\uffff\u0000\u00f7\u00f8\u0005\u001e\u0000\u0000\u00f8\u00f9\u0006\r\uffff"+
		"\uffff\u0000\u00f9\u011a\u0001\u0000\u0000\u0000\u00fa\u00fb\u00030\u0018"+
		"\u0000\u00fb\u00fc\u0006\r\uffff\uffff\u0000\u00fc\u00fd\u0005\u001e\u0000"+
		"\u0000\u00fd\u00fe\u0006\r\uffff\uffff\u0000\u00fe\u011a\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0003\u001e\u000f\u0000\u0100\u0101\u0006\r\uffff\uffff"+
		"\u0000\u0101\u0102\u0006\r\uffff\uffff\u0000\u0102\u011a\u0001\u0000\u0000"+
		"\u0000\u0103\u011a\u0003 \u0010\u0000\u0104\u011a\u0003\"\u0011\u0000"+
		"\u0105\u0106\u0003$\u0012\u0000\u0106\u0107\u0006\r\uffff\uffff\u0000"+
		"\u0107\u0108\u0006\r\uffff\uffff\u0000\u0108\u011a\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0003&\u0013\u0000\u010a\u010b\u0006\r\uffff\uffff\u0000"+
		"\u010b\u010c\u0006\r\uffff\uffff\u0000\u010c\u011a\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0003(\u0014\u0000\u010e\u010f\u0006\r\uffff\uffff\u0000"+
		"\u010f\u0110\u0006\r\uffff\uffff\u0000\u0110\u011a\u0001\u0000\u0000\u0000"+
		"\u0111\u0112\u0003*\u0015\u0000\u0112\u0113\u0006\r\uffff\uffff\u0000"+
		"\u0113\u0114\u0006\r\uffff\uffff\u0000\u0114\u011a\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0003\u001c\u000e\u0000\u0116\u0117\u0006\r\uffff\uffff\u0000"+
		"\u0117\u0118\u0006\r\uffff\uffff\u0000\u0118\u011a\u0001\u0000\u0000\u0000"+
		"\u0119\u00e9\u0001\u0000\u0000\u0000\u0119\u00ed\u0001\u0000\u0000\u0000"+
		"\u0119\u00f2\u0001\u0000\u0000\u0000\u0119\u00fa\u0001\u0000\u0000\u0000"+
		"\u0119\u00ff\u0001\u0000\u0000\u0000\u0119\u0103\u0001\u0000\u0000\u0000"+
		"\u0119\u0104\u0001\u0000\u0000\u0000\u0119\u0105\u0001\u0000\u0000\u0000"+
		"\u0119\u0109\u0001\u0000\u0000\u0000\u0119\u010d\u0001\u0000\u0000\u0000"+
		"\u0119\u0111\u0001\u0000\u0000\u0000\u0119\u0115\u0001\u0000\u0000\u0000"+
		"\u011a\u001b\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u001a\u0000\u0000"+
		"\u011c\u011d\u0006\u000e\uffff\uffff\u0000\u011d\u0122\u0006\u000e\uffff"+
		"\uffff\u0000\u011e\u011f\u0005\u001b\u0000\u0000\u011f\u0120\u0006\u000e"+
		"\uffff\uffff\u0000\u0120\u0122\u0006\u000e\uffff\uffff\u0000\u0121\u011b"+
		"\u0001\u0000\u0000\u0000\u0121\u011e\u0001\u0000\u0000\u0000\u0122\u001d"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0005\r\u0000\u0000\u0124\u0125\u0005"+
		" \u0000\u0000\u0125\u0126\u00032\u0019\u0000\u0126\u0127\u0005!\u0000"+
		"\u0000\u0127\u0128\u0003\u001a\r\u0000\u0128\u012d\u0006\u000f\uffff\uffff"+
		"\u0000\u0129\u012a\u0005\u000e\u0000\u0000\u012a\u012b\u0003\u001a\r\u0000"+
		"\u012b\u012c\u0006\u000f\uffff\uffff\u0000\u012c\u012e\u0001\u0000\u0000"+
		"\u0000\u012d\u0129\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0006\u000f\uffff"+
		"\uffff\u0000\u0130\u001f\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u000f"+
		"\u0000\u0000\u0132\u013b\u0005 \u0000\u0000\u0133\u0138\u00034\u001a\u0000"+
		"\u0134\u0135\u0005\u001f\u0000\u0000\u0135\u0137\u00034\u001a\u0000\u0136"+
		"\u0134\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138"+
		"\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139"+
		"\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b"+
		"\u0133\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c"+
		"\u013d\u0001\u0000\u0000\u0000\u013d\u013f\u0005\u001e\u0000\u0000\u013e"+
		"\u0140\u00032\u0019\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u014f"+
		"\u0005\u001e\u0000\u0000\u0142\u0143\u0003,\u0016\u0000\u0143\u0144\u0005"+
		"$\u0000\u0000\u0144\u014c\u00032\u0019\u0000\u0145\u0146\u0005\u001f\u0000"+
		"\u0000\u0146\u0147\u0003,\u0016\u0000\u0147\u0148\u0005$\u0000\u0000\u0148"+
		"\u0149\u00032\u0019\u0000\u0149\u014b\u0001\u0000\u0000\u0000\u014a\u0145"+
		"\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000\u0000\u014c\u014a"+
		"\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u0150"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014f\u0142"+
		"\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0001\u0000\u0000\u0000\u0151\u0152\u0005!\u0000\u0000\u0152\u0153\u0003"+
		"\u001a\r\u0000\u0153!\u0001\u0000\u0000\u0000\u0154\u0155\u0005\u0010"+
		"\u0000\u0000\u0155\u0156\u0005 \u0000\u0000\u0156\u0157\u00032\u0019\u0000"+
		"\u0157\u0158\u0005!\u0000\u0000\u0158\u0159\u0003\u001a\r\u0000\u0159"+
		"#\u0001\u0000\u0000\u0000\u015a\u015b\u0003,\u0016\u0000\u015b\u015c\u0005"+
		"$\u0000\u0000\u015c\u015d\u00032\u0019\u0000\u015d\u015e\u0006\u0012\uffff"+
		"\uffff\u0000\u015e\u015f\u0005\u001e\u0000\u0000\u015f\u0160\u0006\u0012"+
		"\uffff\uffff\u0000\u0160%\u0001\u0000\u0000\u0000\u0161\u0162\u0006\u0013"+
		"\uffff\uffff\u0000\u0162\u0166\u0005\u0012\u0000\u0000\u0163\u0164\u0003"+
		"2\u0019\u0000\u0164\u0165\u0006\u0013\uffff\uffff\u0000\u0165\u0167\u0001"+
		"\u0000\u0000\u0000\u0166\u0163\u0001\u0000\u0000\u0000\u0166\u0167\u0001"+
		"\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0169\u0005"+
		"\u001e\u0000\u0000\u0169\u016a\u0006\u0013\uffff\uffff\u0000\u016a\'\u0001"+
		"\u0000\u0000\u0000\u016b\u016c\u0005\u0013\u0000\u0000\u016c\u016d\u0003"+
		",\u0016\u0000\u016d\u016e\u0006\u0014\uffff\uffff\u0000\u016e\u016f\u0005"+
		"\u001e\u0000\u0000\u016f\u0170\u0006\u0014\uffff\uffff\u0000\u0170)\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0005\u0014\u0000\u0000\u0172\u0173\u0003"+
		"2\u0019\u0000\u0173\u0174\u0006\u0015\uffff\uffff\u0000\u0174\u0175\u0005"+
		"\u001e\u0000\u0000\u0175\u0176\u0006\u0015\uffff\uffff\u0000\u0176+\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0005\u0015\u0000\u0000\u0178\u017e\u0006"+
		"\u0016\uffff\uffff\u0000\u0179\u017a\u0005%\u0000\u0000\u017a\u017b\u0005"+
		"6\u0000\u0000\u017b\u017d\u0006\u0016\uffff\uffff\u0000\u017c\u0179\u0001"+
		"\u0000\u0000\u0000\u017d\u0180\u0001\u0000\u0000\u0000\u017e\u017c\u0001"+
		"\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u018c\u0001"+
		"\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0181\u0182\u0005"+
		"6\u0000\u0000\u0182\u0188\u0006\u0016\uffff\uffff\u0000\u0183\u0184\u0005"+
		"%\u0000\u0000\u0184\u0185\u00056\u0000\u0000\u0185\u0187\u0006\u0016\uffff"+
		"\uffff\u0000\u0186\u0183\u0001\u0000\u0000\u0000\u0187\u018a\u0001\u0000"+
		"\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000"+
		"\u0000\u0000\u0189\u018c\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000"+
		"\u0000\u0000\u018b\u0177\u0001\u0000\u0000\u0000\u018b\u0181\u0001\u0000"+
		"\u0000\u0000\u018c-\u0001\u0000\u0000\u0000\u018d\u018e\u0005\u0015\u0000"+
		"\u0000\u018e\u0194\u0006\u0017\uffff\uffff\u0000\u018f\u0190\u0005%\u0000"+
		"\u0000\u0190\u0191\u00056\u0000\u0000\u0191\u0193\u0006\u0017\uffff\uffff"+
		"\u0000\u0192\u018f\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000"+
		"\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000"+
		"\u0000\u0195\u01a2\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000"+
		"\u0000\u0197\u0198\u00056\u0000\u0000\u0198\u019e\u0006\u0017\uffff\uffff"+
		"\u0000\u0199\u019a\u0005%\u0000\u0000\u019a\u019b\u00056\u0000\u0000\u019b"+
		"\u019d\u0006\u0017\uffff\uffff\u0000\u019c\u0199\u0001\u0000\u0000\u0000"+
		"\u019d\u01a0\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000"+
		"\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a2\u0001\u0000\u0000\u0000"+
		"\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1\u018d\u0001\u0000\u0000\u0000"+
		"\u01a1\u0197\u0001\u0000\u0000\u0000\u01a2/\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a4\u0003.\u0017\u0000\u01a4\u01a5\u0005%\u0000\u0000\u01a5\u01a6\u0005"+
		"6\u0000\u0000\u01a6\u01a7\u0006\u0018\uffff\uffff\u0000\u01a7\u01b3\u0005"+
		" \u0000\u0000\u01a8\u01a9\u00032\u0019\u0000\u01a9\u01b0\u0006\u0018\uffff"+
		"\uffff\u0000\u01aa\u01ab\u0005\u001f\u0000\u0000\u01ab\u01ac\u00032\u0019"+
		"\u0000\u01ac\u01ad\u0006\u0018\uffff\uffff\u0000\u01ad\u01af\u0001\u0000"+
		"\u0000\u0000\u01ae\u01aa\u0001\u0000\u0000\u0000\u01af\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000"+
		"\u0000\u0000\u01b3\u01a8\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5\u01b6\u0005!\u0000"+
		"\u0000\u01b6\u01b7\u0006\u0018\uffff\uffff\u0000\u01b7\u01cb\u0001\u0000"+
		"\u0000\u0000\u01b8\u01b9\u00056\u0000\u0000\u01b9\u01ba\u0006\u0018\uffff"+
		"\uffff\u0000\u01ba\u01c6\u0005 \u0000\u0000\u01bb\u01bc\u00032\u0019\u0000"+
		"\u01bc\u01c3\u0006\u0018\uffff\uffff\u0000\u01bd\u01be\u0005\u001f\u0000"+
		"\u0000\u01be\u01bf\u00032\u0019\u0000\u01bf\u01c0\u0006\u0018\uffff\uffff"+
		"\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01bd\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c7\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c6\u01bb\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c9\u0005!\u0000\u0000\u01c9\u01cb\u0006\u0018\uffff\uffff"+
		"\u0000\u01ca\u01a3\u0001\u0000\u0000\u0000\u01ca\u01b8\u0001\u0000\u0000"+
		"\u0000\u01cb1\u0001\u0000\u0000\u0000\u01cc\u01cd\u0006\u0019\uffff\uffff"+
		"\u0000\u01cd\u01ce\u0003,\u0016\u0000\u01ce\u01cf\u0006\u0019\uffff\uffff"+
		"\u0000\u01cf\u01ec\u0001\u0000\u0000\u0000\u01d0\u01d1\u0005\u0015\u0000"+
		"\u0000\u01d1\u01ec\u0006\u0019\uffff\uffff\u0000\u01d2\u01d3\u00030\u0018"+
		"\u0000\u01d3\u01d4\u0006\u0019\uffff\uffff\u0000\u01d4\u01ec\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d6\u0003\u0016\u000b\u0000\u01d6\u01d7\u0006\u0019"+
		"\uffff\uffff\u0000\u01d7\u01ec\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005"+
		" \u0000\u0000\u01d9\u01da\u00032\u0019\u0000\u01da\u01db\u0005!\u0000"+
		"\u0000\u01db\u01dc\u0006\u0019\uffff\uffff\u0000\u01dc\u01ec\u0001\u0000"+
		"\u0000\u0000\u01dd\u01de\u00052\u0000\u0000\u01de\u01ec\u0006\u0019\uffff"+
		"\uffff\u0000\u01df\u01e0\u00053\u0000\u0000\u01e0\u01ec\u0006\u0019\uffff"+
		"\uffff\u0000\u01e1\u01e2\u00054\u0000\u0000\u01e2\u01ec\u0006\u0019\uffff"+
		"\uffff\u0000\u01e3\u01e4\u00055\u0000\u0000\u01e4\u01ec\u0006\u0019\uffff"+
		"\uffff\u0000\u01e5\u01e6\u0005\u001d\u0000\u0000\u01e6\u01ec\u0006\u0019"+
		"\uffff\uffff\u0000\u01e7\u01e8\u0007\u0000\u0000\u0000\u01e8\u01e9\u0003"+
		"2\u0019\u0007\u01e9\u01ea\u0006\u0019\uffff\uffff\u0000\u01ea\u01ec\u0001"+
		"\u0000\u0000\u0000\u01eb\u01cc\u0001\u0000\u0000\u0000\u01eb\u01d0\u0001"+
		"\u0000\u0000\u0000\u01eb\u01d2\u0001\u0000\u0000\u0000\u01eb\u01d5\u0001"+
		"\u0000\u0000\u0000\u01eb\u01d8\u0001\u0000\u0000\u0000\u01eb\u01dd\u0001"+
		"\u0000\u0000\u0000\u01eb\u01df\u0001\u0000\u0000\u0000\u01eb\u01e1\u0001"+
		"\u0000\u0000\u0000\u01eb\u01e3\u0001\u0000\u0000\u0000\u01eb\u01e5\u0001"+
		"\u0000\u0000\u0000\u01eb\u01e7\u0001\u0000\u0000\u0000\u01ec\u020d\u0001"+
		"\u0000\u0000\u0000\u01ed\u01ee\n\u0006\u0000\u0000\u01ee\u01ef\u0007\u0001"+
		"\u0000\u0000\u01ef\u01f0\u00032\u0019\u0007\u01f0\u01f1\u0006\u0019\uffff"+
		"\uffff\u0000\u01f1\u020c\u0001\u0000\u0000\u0000\u01f2\u01f3\n\u0005\u0000"+
		"\u0000\u01f3\u01f4\u0007\u0002\u0000\u0000\u01f4\u01f5\u00032\u0019\u0006"+
		"\u01f5\u01f6\u0006\u0019\uffff\uffff\u0000\u01f6\u020c\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f8\n\u0004\u0000\u0000\u01f8\u01f9\u0007\u0003\u0000\u0000"+
		"\u01f9\u01fa\u00032\u0019\u0005\u01fa\u01fb\u0006\u0019\uffff\uffff\u0000"+
		"\u01fb\u020c\u0001\u0000\u0000\u0000\u01fc\u01fd\n\u0003\u0000\u0000\u01fd"+
		"\u01fe\u0007\u0004\u0000\u0000\u01fe\u01ff\u00032\u0019\u0004\u01ff\u0200"+
		"\u0006\u0019\uffff\uffff\u0000\u0200\u020c\u0001\u0000\u0000\u0000\u0201"+
		"\u0202\n\u0002\u0000\u0000\u0202\u0203\u0005\u0017\u0000\u0000\u0203\u0204"+
		"\u00032\u0019\u0003\u0204\u0205\u0006\u0019\uffff\uffff\u0000\u0205\u020c"+
		"\u0001\u0000\u0000\u0000\u0206\u0207\n\u0001\u0000\u0000\u0207\u0208\u0005"+
		"\u0018\u0000\u0000\u0208\u0209\u00032\u0019\u0002\u0209\u020a\u0006\u0019"+
		"\uffff\uffff\u0000\u020a\u020c\u0001\u0000\u0000\u0000\u020b\u01ed\u0001"+
		"\u0000\u0000\u0000\u020b\u01f2\u0001\u0000\u0000\u0000\u020b\u01f7\u0001"+
		"\u0000\u0000\u0000\u020b\u01fc\u0001\u0000\u0000\u0000\u020b\u0201\u0001"+
		"\u0000\u0000\u0000\u020b\u0206\u0001\u0000\u0000\u0000\u020c\u020f\u0001"+
		"\u0000\u0000\u0000\u020d\u020b\u0001\u0000\u0000\u0000\u020d\u020e\u0001"+
		"\u0000\u0000\u0000\u020e3\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000"+
		"\u0000\u0000\u0210\u0211\u0003\u0014\n\u0000\u0211\u0212\u0006\u001a\uffff"+
		"\uffff\u0000\u0212\u0213\u0006\u001a\uffff\uffff\u0000\u0213\u0222\u0001"+
		"\u0000\u0000\u0000\u0214\u0215\u0003,\u0016\u0000\u0215\u0216\u0005$\u0000"+
		"\u0000\u0216\u0217\u00032\u0019\u0000\u0217\u0218\u0006\u001a\uffff\uffff"+
		"\u0000\u0218\u0219\u0006\u001a\uffff\uffff\u0000\u0219\u0222\u0001\u0000"+
		"\u0000\u0000\u021a\u021b\u0003\u0014\n\u0000\u021b\u021c\u0006\u001a\uffff"+
		"\uffff\u0000\u021c\u021d\u0005$\u0000\u0000\u021d\u021e\u00032\u0019\u0000"+
		"\u021e\u021f\u0006\u001a\uffff\uffff\u0000\u021f\u0220\u0006\u001a\uffff"+
		"\uffff\u0000\u0220\u0222\u0001\u0000\u0000\u0000\u0221\u0210\u0001\u0000"+
		"\u0000\u0000\u0221\u0214\u0001\u0000\u0000\u0000\u0221\u021a\u0001\u0000"+
		"\u0000\u0000\u02225\u0001\u0000\u0000\u0000*<GTW_mv\u007f\u0085\u0099"+
		"\u009c\u00a1\u00b6\u00bb\u00c3\u00d4\u00d7\u00e3\u0119\u0121\u012d\u0138"+
		"\u013b\u013f\u014c\u014f\u0166\u017e\u0188\u018b\u0194\u019e\u01a1\u01b0"+
		"\u01b3\u01c3\u01c6\u01ca\u01eb\u020b\u020d\u0221";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}