grammar miniJava;

goal:   mainClass classDeclaration* ;

mainClass:		'class' id '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' id ')' '{' 
varDecl* statement* '}' '}'
; 

classDeclaration:		'class' id ( 'extends' id )? '{' varDecl* methodDeclaration* '}'
; 

methodDeclaration:		'public' type id '(' (argv ( ',' argv )* )? ')' '{' 
                        varDecl* statement* 'return' expr ';' 
                        '}'
;
						
varDecl:		type id ';'
			{$id.ltype = $type.text;}
;   

argv:       type id
			{$id.atype = $type.text;}
;         

type:       'int' '[' ']'     
        |   'boolean'         
        |   'int'             
        |   id                
        ;

statement:      '{' statement* '}'                          
            |   'if' '(' expr ')' statement 'else' statement
            |   'while' '(' expr ')' statement              
            |   'System.out.println' '(' expr ')' ';'       
            |   id '=' expr ';'
			{
				if ($id.ltype != $expr.ltype)
				{
					notifyErrorListeners("Unmatched identifier type.");
				}
			}			
            |   id '[' expr ']' '=' expr ';'         
			{
				if ($id.atype != $expr.ltype)
				{
					notifyErrorListeners("Unmatched identifier type.");
				}
			}					
;

expr
locals
[
	String ltype;
	String atype
]
:			a = expr ('<' | '+' | '-' | '*' ) b = expr
		   {
			   if (a.ltype != b.ltype)
			   {
				   notifyErrorListeners("Unmatched identifier type.");
			   }
			   else
			   {
				   $ctx.ltype = a.ltype;
			   }
		   }
	        |a = expr '&&' b = expr
			{
				$ctx.ltype = a.ltype;
			}
            |   a = expr '[' b = expr ']' 
			{
				$ctx.ltype = b.atype;
			}			
            |   expr '.' 'length'
		   {
			   $ctx.ltype = "int";
			}			
            |   expr '.' id '(' ( expr ( ',' expr )* )? ')' 
			{
			   $ctx.ltype = id.ltype;
			}			
            |   id     
			{
				$ctx.ltype = id.ltype;
			}			
            |   INT
			{
				$ctx.ltype = "int";
			}					
            |   BOOL     
			{
				$ctx.ltype = "boolean";
			}					
            |   'this'                                      
            |   'new' 'int' '[' expr ']'  
			{
				$ctx.atype = "int";
			}					
            |   'new' id '(' ')'
			{
				$ctx.ltype = "id.ltype";
			}			
            |   '!' a = expr
			{
				$ctx.ltype = "a.ltype";
			}					
            |   '(' a = expr ')'
			{
				$ctx.ltype = "a.ltype";
			}
;			
			
id
locals
[
	String ltype;
	String atype
]
:			ID
           |    IDWrong  {notifyErrorListeners("Wrong identifier name: Cannot start with a number.");}
;

ID        : [a-zA-Z_][a-zA-Z0-9_]*;
IDWrong       : [0-9][a-zA-Z_]+[a-zA-Z0-9_]*;
INT       : [0-9]+;
BOOL      : ('true'| 'false');
WS        : [ \t\r\n]+ -> skip ;
COMMENT   : '/*' .*? '*/' -> skip ;
LINE_COMMENT  
          : '//' .*? '\r'? '\n' -> skip;
