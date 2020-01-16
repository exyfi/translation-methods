package org.exyfi.simpleparser;


import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    private LexicalAnalyzer lexer;

    private Tree S() throws ParseException {
        System.out.println("S");
        switch (lexer.getCurToken()) {
            case NOT:
            case VAR:
            case LPAREN:
                return new Tree("S", A(), SPrime());
            case END:
                return new Tree("S", new Tree("ε"));
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected ! , var, ( , ε  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }

    private Tree SPrime() throws ParseException {
        switch (lexer.getCurToken()) {
            case OR:
                lexer.nextToken();
                return new Tree("S'", new Tree("|"), A(), SPrime());
            case END:
            case RPAREN:
                return new Tree("S'", new Tree("ε"));
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected | , ) , ε  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }

    private Tree A() throws ParseException {
        switch (lexer.getCurToken()) {
            case NOT:
            case VAR:
            case LPAREN:
                return new Tree("A", B(), APrime());
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected ! , ( , var  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }

    private Tree APrime() throws ParseException {
        switch (lexer.getCurToken()) {
            case XOR:
                lexer.nextToken();
                return new Tree("A'", new Tree("^"), B(), APrime());
            case END:
            case RPAREN:
            case OR:
                return new Tree("A'", new Tree("ε"));
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected ^ , | , ) , ε  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }


    private Tree B() throws ParseException {
        switch (lexer.getCurToken()) {
            case NOT:
            case VAR:
            case LPAREN:
                return new Tree("B", C(), BPrime());
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected ! , ) , var  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }

    private Tree BPrime() throws ParseException {
        switch (lexer.getCurToken()) {
            case AND:
                lexer.nextToken();
                return new Tree("B'", new Tree("&"), C(), BPrime());
            case END:
            case RPAREN:
            case OR:
            case XOR:
                return new Tree("B'", new Tree("ε"));
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected & , ^ ,| , ) , ε  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }

    private Tree C() throws ParseException {
        switch (lexer.getCurToken()) {
            case NOT:
                lexer.nextToken();
                return new Tree("C", new Tree("!"), C());
            case VAR:
            case LPAREN:
                return new Tree("C", D());
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected ! , var , (  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }

    private Tree D() throws ParseException {
        switch (lexer.getCurToken()) {
            case VAR:
                char var = lexer.getVar();
                lexer.nextToken();
                return new Tree("D", new Tree(Character.toString(var)));
            case LPAREN:
                lexer.nextToken();
                Tree nextS = S();

                if (lexer.getCurToken() != Token.RPAREN) {
                    throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected )  at position: " + lexer.getCurPos(), lexer.getCurPos());
                }

                lexer.nextToken();
                Tree leftP = new Tree("(");
                Tree rightP = new Tree(")");
                return new Tree("D", leftP, nextS, rightP);
            default:
                throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected var, (  at position: " + lexer.getCurPos(), lexer.getCurPos());
        }
    }


    public Tree parse(InputStream stream) throws ParseException {
        lexer = new LexicalAnalyzer(stream);
        Tree ret = S();
        if (lexer.getCurToken() == Token.END) {
            return ret;
        }
        throw new ParseException("Incorrect token " + lexer.getCurToken() + ". Expected ε  at position: " + lexer.getCurPos(), lexer.getCurPos());
    }
}