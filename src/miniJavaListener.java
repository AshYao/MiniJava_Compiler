// Generated from miniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link miniJavaParser}.
 */
public interface miniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(miniJavaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(miniJavaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(miniJavaParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(miniJavaParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(miniJavaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(miniJavaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(miniJavaParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(miniJavaParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#argv}.
	 * @param ctx the parse tree
	 */
	void enterArgv(miniJavaParser.ArgvContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#argv}.
	 * @param ctx the parse tree
	 */
	void exitArgv(miniJavaParser.ArgvContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(miniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(miniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(miniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(miniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(miniJavaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(miniJavaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(miniJavaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(miniJavaParser.IdContext ctx);
}