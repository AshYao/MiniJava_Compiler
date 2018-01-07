grammar miniJavaRules;

goal:   mainClass classDeclaration* ;

mainClass:  'class' id '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' id ')' methodBody '}';

classDeclaration:   'class' id ( 'extends' id )? classBody;

classBody: '{' varDecl* methodDeclaration* '}';

methodDeclaration:  'public' type id '(' argList ')'  methodBody ;

methodBody: '{' varDecl* statement* ('return' expr ';')? '}';

varDecl: type id ';';

argList: (argv ( ',' argv )* )?;

argv:       type id;

type:       'int' '[' ']'
        |	'boolean'
        |	'int'
        |	id
        ;

statement:      '{' statement* '}'
            |	'if' '(' expr ')' statement 'else' statement
            |	'while' '(' expr ')' statement
            |	'System.out.println' '(' expr ')' ';'
            |	id '=' expr ';'
            |	id '[' expr ']' '=' expr ';'
            ;

expr:           expr ( '&&' | '<' | '+' | '-' | '*' ) expr
            |	expr '[' expr ']'
            |	expr '.' 'length'
            |	expr '.' id '(' ( expr ( ',' expr )* )? ')'
            |   id            
            |	INT
            |	BOOL
            |	'this'
            |	'new' 'int' '[' expr ']'
            |	'new' id '(' ')'
            |	'!' expr
            |	'(' expr ')'
            |       expr ')' {notifyErrorListeners("Too many parentheses.");}
            |   '(' expr     {notifyErrorListeners("Missing parentheses.");}
            ;

id:             ID
           |    IDWrong  {notifyErrorListeners("Wrong identifier name: Cannot start with a number.");}
           ;

ID            : [a-zA-Z_][a-zA-Z0-9_]*;
IDWrong       : [0-9][a-zA-Z_]+[a-zA-Z0-9_]*;
INT           : [0-9]+;
BOOL          : ('true'| 'false');
WS            : [ \t\r\n]+ -> skip ;
COMMENT       : '/*' .*? '*/' -> skip ;
LINE_COMMENT  : '//' .*? '\r'? '\n' -> skip;
