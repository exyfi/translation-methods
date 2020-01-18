package org.exyfi.lab4.generator;

import org.exyfi.lab4.grammar.Argument;
import org.exyfi.lab4.grammar.Code;
import org.exyfi.lab4.grammar.NTerm;
import org.exyfi.lab4.grammar.NTermRule;
import org.exyfi.lab4.grammar.ParsedGrammar;
import org.exyfi.lab4.grammar.Production;
import org.exyfi.lab4.grammar.Term;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserGenerator extends ClassGenerator {

    public ParserGenerator(String dir, String name, ParsedGrammar grammar) {
        super(dir, name, name + "Parser.java", grammar);
    }

    void printImports() {
        printLine(0, "import org.exyfi.lab4.exception.ParseException;");
        out.write(EOLN);
    }

    void printClass() {
        printName();
        printFields();
        printMethodParse();
        printNTermMethods();
        printMethodConsume();
        printRulesClasses();
        printEnd();
    }

    private void printName() {
        printLine(0, "public class ", parserName, " {");
    }

    private void printEnd() {
        printLine(0, "}");
    }

    private void printFields() {
        printLine(1, "private ", lexerName, " lex;");
        out.write(EOLN);
    }

    private void printMethodParse() {
        String type = grammar.getNTermToType().get(grammar.getStartNT());
        printLine(1, "public ", type, " parse(String expr) throws ParseException {");
        printLine(2, "lex = new ", lexerName, "(expr);");
        printLine(2, "lex.nextToken();");
        printLine(2, (!type.equals("void") ? type + " p = " : ""), grammar.getStartNT(), "();");
        printLine(2, "if (lex.getCurToken() != ", tokenName, ".END) {");
        printLine(3, "throw new AssertionError(lex.getCurToken());");
        printLine(2, "}");

        if (!type.equals("void"))
            printLine(2, "return p;");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printNTermMethods() {
        List<NTermRule> rules = grammar.getNtermRules();
        for (NTermRule rule : rules) {
            beginNTermMethod(rule);
            if (firstCaseNTermMethod(rule))
                followCaseNTermMethod(rule);
            endNTermMethod();
        }
    }

    private void beginNTermMethod(NTermRule rule) {
        StringBuilder builder = new StringBuilder();
        builder.append(TAB).append("private ")
                .append(rule.getRetType())
                .append(' ')
                .append(rule.getName())
                .append('(');

        List<Argument> argList = rule.getArgList();
        if (argList != null) {
            for (int i = 0; i < argList.size(); i++) {
                builder.append(argList.get(i).getType())
                        .append(' ')
                        .append(argList.get(i).getName());
                if (i != argList.size() - 1)
                    builder.append(", ");
            }
        }

        builder.append(") throws ParseException {")
                .append(EOLN);
        out.write(builder.toString());
        if (!rule.getRetType().equals("void"))
            printLine(2, rule.getRetType(), " ret = new ", rule.getRetType(), "();");
        printLine(2, "switch (lex.getCurToken()) {");
    }

    private boolean firstCaseNTermMethod(NTermRule rule) {
        boolean isHaveEps = false;
        label:
        for (List<Production> prodList : rule.getRules()) {
            for (String s : grammar.getFirstProdList(prodList)) {
                if (s.equals("EPS")) {
                    isHaveEps = true;
                    continue label;
                } else {
                    printLine(3, "case ", s, ":");
                }
            }
            caseBody(rule, prodList);
        }
        return isHaveEps;
    }

    private String substitute(String code) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            builder.append(code.charAt(i) == '&' ? "ret." : code.charAt(i));
        }
        return builder.toString();
    }

    private void caseBody(NTermRule rule, List<Production> prodList) {
        Set<String> isHaveVar = new HashSet<>();
        printLine(3, "{");
        for (Production prod : prodList) {
            if (prod instanceof Code) {
                printLine(4, substitute(((Code) prod).getCode()));
            } else if (prod instanceof Term) {
                String name = ((Term) prod).getName();
                StringBuilder builder = new StringBuilder();

                if (!isHaveVar.contains(name)) {
                    isHaveVar.add(name);
                    builder.append("String ");
                }
                builder.append(name).append(" = consume(")
                        .append(tokenName)
                        .append('.')
                        .append(name)
                        .append(");");

                printLine(4, builder.toString());
            } else {
                String name = ((NTerm) prod).getName();
                StringBuilder builder = new StringBuilder();
                String type = grammar.getNTermToType().get(name);
                if (!type.equals("void")) {
                    if (!isHaveVar.contains(name)) {
                        isHaveVar.add(name);
                        builder.append(type)
                                .append(' ');
                    }
                    builder.append(name)
                            .append(" = ");
                }

                builder.append(name)
                        .append('(');
                List<String> parameters = ((NTerm) prod).getParameters();
                for (int i = 0; i < parameters.size(); i++) {
                    builder.append(parameters.get(i));
                    if (i != parameters.size() - 1)
                        builder.append(", ");

                }

                builder.append(");");
                printLine(4, builder.toString());
            }
        }
        printLine(4, "return", (!rule.getRetType().equals("void") ? " ret" : ""), ";");
        printLine(3, "}");
    }

    private void followCaseNTermMethod(NTermRule rule) {
        if (grammar.getFollow(rule.getName()).isEmpty()) return;
        for (String s : grammar.getFollow(rule.getName())) {
            printLine(3, "case ", s, ":");
        }
        for (List<Production> prodList : rule.getRules()) {
            boolean isHaveEps = false;
            for (String s : grammar.getFirstProdList(prodList)) {
                if (s.equals("EPS")) {
                    isHaveEps = true;
                    break;
                }
            }
            if (isHaveEps) {
                for (Production prod : prodList) {
                    if (prod instanceof Code) {
                        printLine(4, substitute(((Code) prod).getCode()));
                    }
                }
                printLine(4, "return", (!rule.getRetType().equals("void") ? " ret" : ""), ";");
            }
        }
    }

    private void endNTermMethod() {
        printLine(3, "default:");
        printLine(4, "throw new AssertionError(\"Not expected token\");");
        printLine(2, "}");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodConsume() {
        printLine(1, "private String consume(", tokenName, " token) throws ParseException {");
        printLine(2, "if (lex.getCurToken() != token) {");
        printLine(3, "throw new ParseException(String.format(\"Incorrect token at position: %s\", lex.getCurPos()));");
        printLine(2, "}");
        printLine(2, "String lexeme = lex.getLexeme();");
        printLine(2, "lex.nextToken();");
        printLine(2, "return lexeme;");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printRulesClasses() {
        for (NTermRule rule : grammar.getNtermRules()) {
            if (rule.getRetType() == null) continue;
            printLine(1, "class ", rule.getRetType(), " {");
            for (Argument ret : rule.getRetList()) {
                printLine(2, ret.getType(), " ", ret.getName(), ";");
            }
            printLine(1, "}");
            out.write(EOLN);
        }
    }
}
