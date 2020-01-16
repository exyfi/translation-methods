# ```Automatic Parser Generator``` 
## Description
Implement a parser which parse arithmetic expressions using ANTLR to generate Lexer and Parser.
I've implemented visitor to calculate expressions. 
After each expression we have to use EOF Token (it can be ';' or ws)
Example: ```a=2+2;```
## Implementation
```Java 12```,  ```JUnit 4```


## Grammar
+ Original grammar
    ```
   start
     : line* EOF
     ;
   
   line
     : declaration ASSIGN expression COMMA
     | expression COMMA
     ;
   
   declaration
      : VAR
      ;
   
   expression
      : left=expression op=(PLUS | MINUS) right=multiplyingExpression
      | multiplyingExpression
      ;
   
   multiplyingExpression
      : left=multiplyingExpression op=(MULTIPLY | DIV) right=signedAtom
      | signedAtom
      ;
   
   signedAtom
      : op=PLUS signedAtom
      | op=MINUS signedAtom
      | atom
      ;
   
   atom
      : VAR
      | INT
      | LPAREN expression RPAREN
      ;
    ```

+ ```Visualization```
      

    to visualize tree use ANTLR plugin 