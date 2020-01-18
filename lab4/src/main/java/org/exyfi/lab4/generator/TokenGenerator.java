package org.exyfi.lab4.generator;

import org.exyfi.lab4.grammar.ParsedGrammar;
import org.exyfi.lab4.grammar.TermRule;

import java.util.List;

public class TokenGenerator extends ClassGenerator {

    public TokenGenerator(String dir, String name, ParsedGrammar grammar) {
        super(dir, name, name + "Token.java", grammar);
    }

    void printImports() {
    }

    void printClass() {
        printName();
        printTokens();
        printEnd();
    }

    private void printName() {
        printLine(0, "public enum ", tokenName, " {");
    }

    private void printEnd() {
        printLine(0, "}");
    }

    private void printTokens() {
        List<TermRule> termRules = grammar.getTermRules();
        for (TermRule rule : termRules) {
            printLine(1, rule.getName(), ",");
        }
        printLine(1, "END");
    }
}
