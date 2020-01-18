package org.exyfi.lab4.generator;

import org.exyfi.lab4.grammar.ParsedGrammar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ClassGenerator {

    String packageName;
    String tokenName;
    String lexerName;
    String parserName;
    ParsedGrammar grammar;
    PrintWriter out;

    final static String EOLN = System.lineSeparator();
    final static String TAB = "    ";

    public ClassGenerator(String dir, String grammarName, String fileName, ParsedGrammar grammar) {
        String updatedFileName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);

        try {
            out = new PrintWriter(new File(dir, updatedFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.packageName = "org.exyfi.lab4.generated." + grammarName;
        String updatedGrammarName = grammarName.substring(0, 1).toUpperCase() + grammarName.substring(1);
        this.tokenName = updatedGrammarName + "Token";
        this.lexerName = updatedGrammarName + "Lexer";
        this.parserName = updatedGrammarName + "Parser";
        this.grammar = grammar;
    }

    public void printFile() {
        printPackage();
        printImports();
        printClass();
        out.close();
    }

    void printPackage() {
        printLine(0, "package ", packageName, ";");
        out.write(EOLN);
    }

    abstract void printImports();

    abstract void printClass();

    void printLine(int tabCount, String... strings) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tabCount; i++) {
            builder.append(TAB);
        }
        for (String str : strings) {
            builder.append(str);
        }
        builder.append(EOLN);
        out.write(builder.toString());
    }
}
