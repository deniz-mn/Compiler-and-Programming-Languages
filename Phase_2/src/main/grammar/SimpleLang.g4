grammar SimpleLang;
@header {
import main.ast.core.*;
import main.ast.declarations.*;
import main.ast.statements.*;
import main.ast.expressions.*;
import main.ast.expressions.literals.*;
import main.ast.types.*;
}

program returns [Program programRet]
    :
        { $programRet = new Program(); }
        (t=topLevelDecl { $programRet.addTopLevelDeclaration($t.topLevelDeclRet); })*
        EOF
    ;

topLevelDecl returns [TopLevelDecl topLevelDeclRet]
    :
        m=module
        { $topLevelDeclRet =$m.moduleRet;

         }
    |
        s=structDef
        { $topLevelDeclRet = $s.structRet;
      }
    ;

module returns [main.ast.declarations.Module moduleRet]
    :
        k=KW_MODULE
        i=ID
        {
            $moduleRet = new main.ast.declarations.Module(new Identifier($i.text));
            $moduleRet.setLine($i.line);
        }
        (
            KW_INCLUDES i1=ID
            { $moduleRet.addInclude(new Identifier($i1.text)); }
            (
                COMMA i2=ID
                { $moduleRet.addInclude(new Identifier($i2.text)); }
            )*
        )?
        KW_BEGIN
        (
            m=member
            { $moduleRet.addMember($m.memberRet); }
        )*
        KW_END
    ;

structDef returns [Struct structRet]
    :
        k=KW_STRUCT
        i=ID
        {
            $structRet = new Struct(new Identifier($i.text));
            $structRet.setLine($i.line);
        }
        KW_BEGIN
        (m=member { $structRet.addMember($m.memberRet); })*
        KW_END

    ;

member returns [Member memberRet]
    :
        { AccessModifier access = AccessModifier.PUBLIC; }
        (am=accessModifier { access = $am.accessModifierRet; })?
        (
            m=method_decl
            {
                MethodDecl methodDecl = new MethodDecl();
                methodDecl.setAccessModifier(access);
                methodDecl.setMethod($m.methodRet);
                methodDecl.setLine($m.methodRet.getLine());
                $memberRet = methodDecl;
            }
        |
            v=vardecl
            SEMI
            {
                VarDecl varDecl = new VarDecl();
                varDecl.setAccessModifier(access);
                varDecl.setVar($v.varRet);
                varDecl.setLine($v.varRet.getLine());
                $memberRet = varDecl;
            }
        )
    ;

accessModifier returns [AccessModifier accessModifierRet]
    :
        pr=KW_PRIVATE
        { $accessModifierRet = AccessModifier.PRIVATE; }
    |
        pu=KW_PUBLIC
        { $accessModifierRet = AccessModifier.PUBLIC; }
    ;

method_decl returns [Method methodRet]
    :
        t=type
        i=ID
        LPAREN
        a=arguments
        RPAREN
        b=block
        { $methodRet = new Method($t.typeRet, new Identifier($i.text), $a.parametersRet, $b.blockRet); }
        { $methodRet.setLine($i.line); }
    ;


arguments returns [List<Parameter> parametersRet]
    :
        { $parametersRet = new ArrayList<>(); }
        (p1=parameter { $parametersRet.add($p1.parameterRet); } (COMMA p2=parameter { $parametersRet.add($p2.parameterRet); } )*)?
    ;

parameter returns [Parameter parameterRet]
    :
        { boolean isMut = false; }
        (KW_MUT { isMut = true; } )?
        t=type
        i=ID
        { $parameterRet = new Parameter(isMut, $t.typeRet, new Identifier($i.text)); }
        { $parameterRet.setLine($i.line); }
    ;

type returns [Type typeRet]
    :
        i=ID
        { $typeRet = new UserDefinedType(new Identifier($i.text)); }
    |
        KW_INT
        { $typeRet = new PrimitiveType("int"); }
    |
        KW_FLOAT
        { $typeRet = new PrimitiveType("float"); }
    |
        KW_DOUBLE
        { $typeRet = new PrimitiveType("double"); }
    |
        KW_CHAR
        { $typeRet = new PrimitiveType("char"); }
    |
        KW_VOID
        { $typeRet = new PrimitiveType("void"); }
    |
        KW_BOOL
        { $typeRet = new PrimitiveType("bool"); }
    ;

vardecl returns [Var varRet]
    :
        { boolean isMut = false; }
        (KW_MUT { isMut = true; } )?
        (t=type { $varRet = new Var(isMut, $t.typeRet); } | c=cons { $varRet = new Var(isMut, $c.constructorCallRet); } )
        i=ID
        { $varRet.setName(new Identifier($i.text)); }
        { $varRet.setLine($i.line); }
    ;

cons returns [ConstructorCall constructorCallRet]
    :
        i=ID
        { $constructorCallRet = new ConstructorCall(new Identifier($i.text)); }
        LPAREN
        (e1=expr { $constructorCallRet.addArgument($e1.expressionRet); } (COMMA e2=expr { $constructorCallRet.addArgument($e2.expressionRet); } )*)?
        RPAREN
        { $constructorCallRet.setLine($i.line); }
    ;

block returns [Block blockRet]
    :
        { $blockRet = new Block(); }
        k=KW_BEGIN
        (s=st { $blockRet.addStatement($s.statementRet); } )*
        KW_END
        { $blockRet.setLine($k.line); }
    ;

st returns [Statement statementRet]
    :
        b=block
        {
            $statementRet = $b.blockRet;
            $statementRet.setLine($b.blockRet.getLine());
        }
    |
        as=assignStmt
        {
            $statementRet = $as.assignStmtRet;
            $statementRet.setLine($as.assignStmtRet.getLine());
        }
    |
        mc=methodcall SEMI
        {
            $statementRet = new MethodCallStmt($mc.methodCallRet);
            $statementRet.setLine($mc.methodCallRet.getLine());
        }
    |
        v=vardecl ASSIGN e=expr SEMI
        {
            VarDeclStmt stmt = new VarDeclStmt($v.varRet);
            stmt.setInitial($e.expressionRet);
            stmt.setLine($v.varRet.getLine());
            $statementRet = stmt;
        }
    |
        vd=vardecl SEMI
        {
            $statementRet = new VarDeclStmt($vd.varRet);
            $statementRet.setLine($vd.varRet.getLine());
        }
    |
        ifs=ifStmt
        {
            $statementRet = $ifs.ifStmtRet;
            $statementRet.setLine($ifs.ifStmtRet.getLine());
        }
    |
        rs=returnStmt
        {
            $statementRet = $rs.returnStmtRet;
            $statementRet.setLine($rs.returnStmtRet.getLine());
        }
    |
        is=inputStmt
        {
            $statementRet = $is.inputStmtRet;
            $statementRet.setLine($is.inputStmtRet.getLine());
        }
    |
        os=outputStmt
        {
            $statementRet = $os.outputStmtRet;
            $statementRet.setLine($os.outputStmtRet.getLine());
        }
    |
        js=jumpStmt
        {
            $statementRet = $js.jumpStmtRet;
            $statementRet.setLine($js.jumpStmtRet.getLine());
        }
    |
        fs=forStmt
        {
            $statementRet = new Block();
        }
    |
        ws=whileStmt
        {
            $statementRet = new Block();
        }
    ;

jumpStmt returns [JumpStmt jumpStmtRet]
    :
        kb=KW_BREAK
        { $jumpStmtRet = new BreakJump(); }
        { $jumpStmtRet.setLine($kb.line); }
    |
        kc=KW_CONTINUE
        { $jumpStmtRet = new ContinueJump(); }
        { $jumpStmtRet.setLine($kc.line); }
    ;
ifStmt returns [IfStmt ifStmtRet]
    :
        k=KW_IF
        LPAREN
        e=expr
        RPAREN
        s1=st
        { $ifStmtRet = new IfStmt($e.expressionRet, $s1.statementRet); }
        (KW_ELSE s2=st { $ifStmtRet.setElseBranch($s2.statementRet); } )?
        { $ifStmtRet.setLine($k.line); }
    ;

forStmt
    :
        KW_FOR
        LPAREN
        (initexpr (COMMA initexpr)*)?
        SEMI
        (expr)?
        SEMI
        (loc ASSIGN expr (COMMA loc ASSIGN expr)*)?
        RPAREN
        st
    ;

whileStmt
    :
        KW_WHILE
        LPAREN
        expr
        RPAREN
        st
    ;
assignStmt returns [AssignStmt assignStmtRet]
    :
        l=loc
        a=ASSIGN
        e=expr
        { $assignStmtRet = new AssignStmt($l.locationRet, $e.expressionRet); }
        SEMI
        { $assignStmtRet.setLine($a.line); }
    ;

returnStmt returns [ReturnStmt returnStmtRet]
    :
        { $returnStmtRet = new ReturnStmt(); }
        k=KW_RETURN
        (e=expr { $returnStmtRet.setValue($e.expressionRet); } )?
        SEMI
        { $returnStmtRet.setLine($k.line); }
    ;

inputStmt returns [InputStmt inputStmtRet]
    :
        k=KW_INPUT
        l=loc
        { $inputStmtRet = new InputStmt($l.locationRet); }
        SEMI
        { $inputStmtRet.setLine($k.line); }
    ;

outputStmt returns [OutputStmt outputStmtRet]
    :
        k=KW_OUTPUT
        e=expr
        { $outputStmtRet = new OutputStmt($e.expressionRet); }
        SEMI
        { $outputStmtRet.setLine($k.line); }
    ;

loc returns [Location locationRet]
    :
        k=KW_THIS
        {
            $locationRet = new ThisLoc();
            $locationRet.setLine($k.line);
        }
        (
            DOT i=ID
            {
                $locationRet = new MemberLoc(
                    new Identifier($locationRet.toString()),
                    new SimpleLoc(new Identifier($i.text))
                );
                $locationRet.setLine($i.line);
            }
        )*
    |
        i=ID
        {
            $locationRet = new SimpleLoc(new Identifier($i.text));
            $locationRet.setLine($i.line);
        }
        (
            DOT j=ID
            {
                $locationRet = new MemberLoc(
                    new Identifier($locationRet.toString()),
                    new SimpleLoc(new Identifier($j.text))
                );
                $locationRet.setLine($j.line);
            }
        )*
    ;


methodcall returns [MethodCall methodCallRet]
    :
        k=KW_THIS DOT i=ID
        {
            ThisLoc receiverLoc = new ThisLoc();
            receiverLoc.setLine($k.line);

            $methodCallRet = new MethodCall(receiverLoc, new Identifier($i.text));
            $methodCallRet.setLine($i.line);
        }
        LPAREN args=callArgs RPAREN
        {
            for (Expression e : $args.argsRet) {
                $methodCallRet.addArgument(e);
            }
        }
    |
        obj=ID DOT i=ID
        {
            SimpleLoc receiverLoc = new SimpleLoc(new Identifier($obj.text));
            receiverLoc.setLine($obj.line);

            $methodCallRet = new MethodCall(receiverLoc, new Identifier($i.text));
            $methodCallRet.setLine($i.line);
        }
        LPAREN args=callArgs RPAREN
        {
            for (Expression e : $args.argsRet) {
                $methodCallRet.addArgument(e);
            }
        }
    |
        i=ID
        {
            $methodCallRet = new MethodCall(new Identifier($i.text));
            $methodCallRet.setLine($i.line);
        }
        LPAREN args=callArgs RPAREN
        {
            for (Expression e : $args.argsRet) {
                $methodCallRet.addArgument(e);
            }
        }
    ;

callArgs returns [List<Expression> argsRet]
    :
        { $argsRet = new ArrayList<>(); }
        (
            e1=expr
            { $argsRet.add($e1.expressionRet); }
            (
                COMMA e2=expr
                { $argsRet.add($e2.expressionRet); }
            )*
        )?
    ;


expr returns [Expression expressionRet]
    :
        a=atom
        { $expressionRet = $a.expressionRet; }
        (
            op=binOp
            b=atom
            {
                $expressionRet = null;
            }
        )*
    ;

atom returns [Expression expressionRet]
    :
        mc=methodcall
        { $expressionRet = $mc.methodCallRet; }
    |
        l=loc
        { $expressionRet = $l.locationRet; }
    |
        c=cons
        { $expressionRet = $c.constructorCallRet; }
    |
        LPAREN e=expr RPAREN
        { $expressionRet = $e.expressionRet; }
    |
        CONSTINT
        { $expressionRet = null; }
    |
        CONSTFLOAT
        { $expressionRet = null; }
    |
        CONSTDOUBLE
        { $expressionRet = null; }
    |
        CONSTCHAR
        { $expressionRet = null; }
    |
        CONSTBOOL
        { $expressionRet = null; }
    |
        MINUS a=atom
        { $expressionRet = null; }
    |
        KW_NOT a=atom
        { $expressionRet = null; }
    ;

binOp
    :
        STAR
    |
        SLASH
    |
        PLUS
    |
        MINUS
    |
        LESS
    |
        GREATER
    |
        LESS_EQ
    |
        GREATER_EQ
    |
        EQUAL
    |
        NOT_EQUAL
    |
        KW_AND
    |
        KW_OR
    ;

initexpr returns [Statement initExprRet]
    :
        l=loc ASSIGN e=expr
        {
            $initExprRet = new AssignStmt($l.locationRet, $e.expressionRet);
            $initExprRet.setLine($l.locationRet.getLine());
        }
    |
        v=vardecl ASSIGN e=expr
        {
            VarDeclStmt stmt = new VarDeclStmt($v.varRet);
            stmt.setInitial($e.expressionRet);
            stmt.setLine($v.varRet.getLine());
            $initExprRet = stmt;
        }
    |
        vd=vardecl
        {
            $initExprRet = new VarDeclStmt($vd.varRet);
            $initExprRet.setLine($vd.varRet.getLine());
        }
    ;

KW_MODULE   : 'module' ;
KW_STRUCT   : 'struct' ;
KW_INCLUDES : 'includes' ;
KW_BEGIN    : 'begin' ;
KW_END      : 'end' ;
KW_PUBLIC   : 'public' ;
KW_PRIVATE  : 'private' ;
KW_INT      : 'int' ;
KW_FLOAT    : 'float' ;
KW_DOUBLE   : 'double' ;
KW_CHAR     : 'char' ;
KW_VOID     : 'void' ;
KW_IF       : 'if' ;
KW_ELSE     : 'else' ;
KW_FOR      : 'for' ;
KW_WHILE    : 'while' ;
KW_DO       : 'do' ;
KW_RETURN   : 'return' ;
KW_INPUT    : 'input' ;
KW_OUTPUT   : 'output' ;
KW_THIS     : 'this' ;
KW_NOT      : 'not' ;
KW_AND      : 'and' ;
KW_OR       : 'or' ;
KW_MUT      : 'mut' ;
KW_BREAK    : 'break' ;
KW_CONTINUE : 'continue' ;
KW_BOOL     : 'bool' ;
CONSTBOOL   : 'true' | 'false' ;

SEMI        : ';' ;
COMMA       : ',' ;
LPAREN      : '(' ;
RPAREN      : ')' ;
LBRACK      : '[' ;
RBRACK      : ']' ;
ASSIGN      : '=' ;
DOT         : '.' ;
ARROW       : '->' ;
MINUS       : '-' ;
PLUS        : '+' ;
STAR        : '*' ;
SLASH       : '/' ;
AMPERSAND   : '&' ;
LESS        : '<' ;
GREATER     : '>' ;
LESS_EQ     : '<=' ;
GREATER_EQ  : '>=' ;
EQUAL       : '==' ;
NOT_EQUAL   : '!=' ;

CONSTINT    : DIGIT+ ;
CONSTFLOAT  : DIGIT+ DOT DIGIT+ ;
CONSTDOUBLE : DIGIT+ DOT DIGIT+ EXPONENT SIGN? DIGIT+ ;
CONSTCHAR   : '\'' . '\'' ;

ID          : LETTER (LETTER | DIGIT | '_')* ;

fragment LETTER   : [a-zA-Z] ;
fragment DIGIT    : [0-9] ;
fragment EXPONENT : [eE] ;
fragment SIGN     : [+\-] ;

WS          : [ \t\r\n]+ -> skip ;
COMMENT     : '%%' ~[\r\n]* -> skip ;
MULTICOMMENT: '%%%' .*? '%%%' -> skip ;



