// Generated from c:/Users/lenovo/Downloads/UT/6/PLC/CA/Phase_1/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleLangParser}.
 */
public interface simpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#topLevelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDeclaration(simpleLangParser.TopLevelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#topLevelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDeclaration(simpleLangParser.TopLevelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(simpleLangParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(simpleLangParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void enterStructDecl(simpleLangParser.StructDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void exitStructDecl(simpleLangParser.StructDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#moduleBody}.
	 * @param ctx the parse tree
	 */
	void enterModuleBody(simpleLangParser.ModuleBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#moduleBody}.
	 * @param ctx the parse tree
	 */
	void exitModuleBody(simpleLangParser.ModuleBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#structBody}.
	 * @param ctx the parse tree
	 */
	void enterStructBody(simpleLangParser.StructBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#structBody}.
	 * @param ctx the parse tree
	 */
	void exitStructBody(simpleLangParser.StructBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(simpleLangParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(simpleLangParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(simpleLangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(simpleLangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(simpleLangParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(simpleLangParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(simpleLangParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(simpleLangParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(simpleLangParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(simpleLangParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(simpleLangParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(simpleLangParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(simpleLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(simpleLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(simpleLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(simpleLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(simpleLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(simpleLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(simpleLangParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(simpleLangParser.ArgsContext ctx);
}