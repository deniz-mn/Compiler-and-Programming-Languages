package main.visitor;

import main.ast.core.Program;
import main.ast.declarations.Method;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Module;
import main.ast.declarations.ModuleDecl;
import main.ast.declarations.Parameter;
import main.ast.declarations.Struct;
import main.ast.declarations.StructDecl;
import main.ast.declarations.Var;
import main.ast.declarations.VarDecl;
import main.ast.expressions.BinaryExpression;
import main.ast.expressions.ConstructorCall;
import main.ast.expressions.Location;
import main.ast.expressions.MemberLoc;
import main.ast.expressions.MethodCall;
import main.ast.expressions.SimpleLoc;
import main.ast.expressions.ThisExpr;
import main.ast.expressions.ThisLoc;
import main.ast.expressions.UnaryExpression;
import main.ast.expressions.literals.BoolLiteral;
import main.ast.expressions.literals.CharLiteral;
import main.ast.expressions.literals.DoubleLiteral;
import main.ast.expressions.literals.FloatLiteral;
import main.ast.expressions.literals.IntLiteral;
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.BreakJump;
import main.ast.statements.ContinueJump;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.MethodCallStmt;
import main.ast.statements.OutputStmt;
import main.ast.statements.ReturnStmt;
import main.ast.statements.VarDeclStmt;
import main.ast.types.Identifier;
import main.ast.types.PrimitiveType;
import main.ast.types.UserDefinedType;

public interface IVisitor<T> {
    T visit(Program program);

    T visit(Module module);

    T visit(ModuleDecl moduleDecl);

    T visit(Struct struct);

    T visit(StructDecl structDecl);

    T visit(Method method);
    T visit(MethodDecl methodDecl);
    T visit(Parameter parameter);
    T visit(Var var);
    T visit(VarDecl varDecl);

    T visit(AssignStmt assignStmt);
    T visit(Block block);
    T visit(BreakJump breakJump);
    T visit(ContinueJump continueJump);
    T visit(IfStmt ifStmt);
    T visit(InputStmt inputStmt);
    T visit(MethodCallStmt methodCallStmt);
    T visit(OutputStmt outputStmt);
    T visit(ReturnStmt returnStmt);
    T visit(VarDeclStmt varDeclStmt);


    T visit(Identifier identifier);
    T visit(PrimitiveType primitiveType);
    T visit(UserDefinedType userDefinedType);

    T visit(Location location);
    T visit(MethodCall methodCall);
    T visit(ConstructorCall constructorCall);


    T visit(BinaryExpression binaryExpression);
    T visit(UnaryExpression unaryExpression);
    T visit(ThisExpr thisExpr);
    T visit(ThisLoc thisLoc);
    T visit(SimpleLoc simpleLoc);
    T visit(MemberLoc memberLoc);

    T visit(IntLiteral intLiteral);
    T visit(FloatLiteral floatLiteral);
    T visit(DoubleLiteral doubleLiteral);
    T visit(BoolLiteral boolLiteral);
    T visit(CharLiteral charLiteral);

}