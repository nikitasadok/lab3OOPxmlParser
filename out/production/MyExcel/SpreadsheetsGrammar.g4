grammar SpreadsheetsGrammar;
expression          : '(' expression ')'                        #parenthesisExp
                    | expression (ASTERISK|SLASH) expression    #mulDivExp
                    | expression (PLUS|MINUS) expression        #addSubExp
                    | <assoc=right>  expression '^' expression  #powerExp
                    | ('DEC'|'INC') '(' expression ')'          #decIncExp
                    | ('MOD'|'DIV') '(' expression ',' expression ')'  #modDivExp
                    | NUMBER                                    #numericAtomExp
                    | ID                                        #idAtomExp
                    ;
fragment LETTER     : [a-zA-Z] ;
fragment DIGIT      : [0-9] ;
ASTERISK            : '*' ;
SLASH               : '/' ;
PLUS                : '+' ;
MINUS               : '-' ;
ID                  : LETTER+ DIGIT+ ;
NAME                : LETTER+ ;
NUMBER              : DIGIT+ ('.' DIGIT+)? ;
WHITESPACE          : ' ' -> skip;
