grammar simpleLang;


program
    : topLevelDeclaration* EOF
    ;

topLevelDeclaration
    : moduleDecl
    | structDecl
    ;

moduleDecl
    : MODULE ID (INCLUDES ID)? BEGIN moduleBody END
    ;

structDecl
    : STRUCT ID BEGIN structBody END
    ;

moduleBody
    : (methodDecl | fieldDecl)*
    ;

structBody
    : (methodDecl | fieldDecl)* 
    ;

fieldDecl
    : accessModifier? varDecl
    ;

varDecl
    : MUT? type (LPAR args? RPAR)? ID (ASSIGN expr)? SEMI
    ;

methodDecl
    : accessModifier? type ID LPAR paramList? RPAR BEGIN statement* END
    ;

paramList
    : param (',' param)*
    ;

param
    : MUT? type ID
    ;

accessModifier
    : PUBLIC | PRIVATE
    ;

type
    : INT | FLOAT | DOUBLE | CHAR | BOOL | VOID | ID
    ;

statement
    : varDecl
    | expr SEMI
    | RETURN expr? SEMI
    | OUTPUT expr SEMI
    | IF LPAR expr RPAR BEGIN statement* END (ELIF LPAR expr RPAR BEGIN statement* END)* (ELSE BEGIN statement* END)?
    | WHILE LPAR expr RPAR BEGIN statement* END
    | FOR LPAR expr? SEMI expr? SEMI expr? RPAR BEGIN statement* END
    | BREAK SEMI
    | CONTINUE SEMI
    ;

expr
    : LPAR expr RPAR                   
    | expr DOT ID                     
    | expr LPAR args? RPAR              
    | expr (MULT | DIV | MOD) expr       
    | expr (PLUS | MINUS) expr          
    | expr (GT | LT | GTE | LTE | EQ | NEQ) expr 
    | <assoc=right> expr ASSIGN expr    
    | ID                                  
    | INT_VAL                            
    | THIS                               
    ;

args
    : expr (',' expr)*
    ;


MODULE   : 'module';
STRUCT   : 'struct';
BEGIN    : 'begin';
END      : 'end';
INCLUDES : 'includes';
PUBLIC   : 'public';
PRIVATE  : 'private';
MUT      : 'mut';
RETURN   : 'return';
OUTPUT   : 'output';
THIS     : 'this';

INT      : 'int';
FLOAT    : 'float';
DOUBLE   : 'double';
CHAR     : 'char';
BOOL     : 'bool';
VOID     : 'void';

IF       : 'if';
ELIF     : 'elif';
ELSE     : 'else';
WHILE    : 'while';
FOR      : 'for';
BREAK    : 'break';
CONTINUE : 'continue';
TRUE     : 'true';
FALSE    : 'false';

SEMI     : ';';
ASSIGN   : '=';
PLUS     : '+';
MINUS    : '-';
MULT     : '*';
DIV      : '/';
MOD      : '%';
DOT      : '.';
LPAR     : '(';
RPAR     : ')';
GT       : '>';
LT       : '<';
GTE      : '>=';
LTE      : '<=';
EQ       : '==';
NEQ      : '!=';

ID       : [a-zA-Z_][a-zA-Z0-9_]*;
INT_VAL  : [0-9]+;

WHITE_SPACE   : [ \t\r\n]+ -> skip;
LINE_COMMENT  : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;