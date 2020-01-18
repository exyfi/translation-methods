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