# ```Using Automatic Parser Generator ANTLR to calculate expressions``` 
## Description
Implement a parser which can parse arithmetic expressions using ANTLR to generate Lexer and Parser.
I've implemented visitor to calculate expressions. 
In addition, I added bit operations.

After each expression we have to use EOF Token (it can be ';' or ws)

Example: 
```
         Input:         
            a = 2;
            b = a + 2;
            c = a + b * (b - 3);
            a = 3;
            c = a + b * (b - 3);
         Output:
            a = 2
            b = 4
            c = 6
            a = 3
            c = 7
```
## Implementation
```Java 12```,  ```JUnit 4```, ```ANTLR 4.7```


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
