grammar Arithmetic;

@header {
package org.exyfi.gen;
}

start
  : line* EOF
  ;

line
  : declaration ASSIGN orOperation COMMA
  | orOperation COMMA
  ;


declaration
   : VAR
   ;

orOperation
:left=orOperation op=OR right=xorExpression
|xorExpression
;

xorExpression
 :left=xorExpression op=XOR right=andOperation
 |andOperation
 ;

andOperation
 : left =andOperation op=AND right=expression
 |expression
 ;

expression
   : left=expression  op=(PLUS | MINUS) right=multiplyingExpression
   | multiplyingExpression
   ;

multiplyingExpression
   : left=multiplyingExpression op=(MULTIPLY | DIV ) right=notExpression
   | notExpression
   ;
notExpression
   : left=notExpression op=NOT right=signedAtom
   |signedAtom
   ;

signedAtom
   : op=(PLUS | NOT | OR) signedAtom
   | op=(MINUS | NOT | OR) signedAtom
   | atom
   ;

atom
   : VAR | NOT VAR
   | (NOT INT) | INT
   | LPAREN expression RPAREN | NOT LPAREN expression RPAREN
   ;

PLUS   :  '+';
MINUS  :  '-';
MULTIPLY  :  '*';
DIV  :  '/';
AND  :  '&';
OR   :  '|';
XOR  :  '^';
NOT  :  '!';
LPAREN  :  '(';
RPAREN  :  ')';
ASSIGN  :  '=';
COMMA  :  ';';
INT    :  '0'..'9'+;
VAR    :   [a-z]+;
WS  : (' '|'\t'|'\r'|'\n')-> skip;
