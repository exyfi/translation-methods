###AUTOMATIC Translator Generator

```$xslt
Automatic translator generator
 
  Generates parser for LL(1) grammar class. Supports synthesized and inherited attributes
  To generate parser for your grammar please provide path to your grammar file.
 
 
```

+ Implementation 
  * ANTLR (to generate Parser for my custom grammar)
  * Gradle 
  * Java 12
  * jUnit 4

```$xslt
Rule for Terminals:

<Term> = "<строка>";
<Term> : "<regexp";
WS -> "[\n]+";

Rule for NTerminals: 

<NTerm>(args) [returns args] =  
 <NTerm> | <Term> | <Code>
    ('|' <NTerm> | <Term> | <Code>)*;

```  

* Example - Calculator grammar

```$xslt
shiftRight


shiftRight [returns v : int]
            = addOrSub shiftRightPrime({addOrSub.v}) {&v = shiftRightPrime.v;}
            ;

shiftRightPrime(left : int) [returns v : int]
            = SHIFTRIGHT shiftRight {&v = (int) left >> shiftRight.v;}
            | {&v = left;}
            ;

addOrSub [returns v : int, isZero : boolean]
            = mulOrDiv addOrSubPrime({mulOrDiv.v})
              {&v = addOrSubPrime.v;}
              {&isZero = &v == 0;}
            ;

addOrSubPrime(left : int) [returns v : int]
            = ADD mulOrDiv    {int next = left + mulOrDiv.v;}
              addOrSubPrime(next) {&v = addOrSubPrime.v;}
            | SUB mulOrDiv    {int next = left - mulOrDiv.v;}
              addOrSubPrime(next) {&v = addOrSubPrime.v;}
            | {&v = left;}
            ;

mulOrDiv [returns v : int] = unary mulOrDivPrime({unary.v}) {&v = mulOrDivPrime.v;};

mulOrDivPrime(left : int) [returns v : int]
            = MUL unary mulOrDivPrime({left * unary.v}) {&v = mulOrDivPrime.v;}
            | DIV unary mulOrDivPrime({left / unary.v}) {&v = mulOrDivPrime.v;}
            | {&v = left;}
            ;

unary [returns v : int]
            = OP shiftRight CP {&v = shiftRight.v;}
            | NUM          {&v = Integer.valueOf(NUM);}
            | SUB NUM {&v = -Integer.valueOf(NUM);}
            ;

ADD = "+";
SUB = "-";
MUL = "*";
DIV = "/";
POW = "^";
OP = "(";
CP = ")";
SHIFTRIGHT = ">>";
NUM : "([1-9][0-9]*)|(0)";
WS -> "[ \n\r\t]+";
```