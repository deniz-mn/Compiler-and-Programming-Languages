// Generated from c:/Users/lenovo/Downloads/UT/6/PLC/CA/Phase_1/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(simpleLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#topLevelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDeclaration(simpleLangParser.TopLevelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(simpleLangParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#structDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDecl(simpleLangParser.StructDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#moduleBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleBody(simpleLangParser.ModuleBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#structBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructBody(simpleLangParser.StructBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(simpleLangParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(simpleLangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(simpleLangParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(simpleLangParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(simpleLangParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(simpleLangParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(simpleLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(simpleLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(simpleLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(simpleLangParser.ArgsContext ctx);
}