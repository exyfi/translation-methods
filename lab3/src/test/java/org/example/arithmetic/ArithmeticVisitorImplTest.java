package org.example.arithmetic;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.exyfi.gen.ArithmeticLexer;
import org.exyfi.gen.ArithmeticParser;
import org.exyfi.lab3.arithmetic.ArithmeticVisitorImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class ArithmeticVisitorImplTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void validateBasicExpression() {
        String expression = "a = 2;\n" +
                "b = a + 2;\n" +
                "c = a + b * (b - 3);\n" +
                "a = 3;\n" +
                "c = a + b * (b - 3);";

        String expected = "a = 2\n" +
                "b = 4\n" +
                "c = 6\n" +
                "a = 3\n" +
                "c = 7\n";
        String actual = evaluate(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void checkThrowingDivisionByZeroExceptionException() {
        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("Division by zero");

        String expression = "4/0;";
        evaluate(expression);
    }

    int a = 2&4;
    @Test
    public void checkBitOperationAnd(){
        String expression ="a=2&4;";
        String actual =evaluate(expression);
        String expected = "a = 0;";
        assertEquals(expected,actual);
    }

    @Test
    public void checkBitOperationOr(){
        String expression ="a=2|3;";
        String actual =evaluate(expression);
        String expected = "a = 3\n";
        assertEquals(expected,actual);
    }

    @Test
    public void checkBitOperationNot(){
        String expression = "a=!2&!2;";
        String actual =evaluate(expression);
        String expected = "a = -3\n";
        assertEquals(expected,actual);
    }

    @Test
    public void checkStrangeBitOperation(){
        String expression ="a=2+2&2^2;";
        String actual=evaluate(expression);
        String expected="a = 2\n";
        assertEquals(expected,actual);
    }

    @Test
    public void checkPlus(){
        String expression ="a=2;\n" +
                "a=+2";
        String actual =evaluate(expression);
        String expected = "a = 4\n";
        assertEquals(expected,actual);
    }

    @Test
    public void checkThrowingUnsupportedOperationException() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("Variable a is not defined");

        String expression = "4-a;";
        evaluate(expression);
    }

    @Test
    public void checkThatOrderIsCorrect() {
        String expression = "100 - (100+10)*10/10 +1;";
        String expected = "-9\n";

        String actual = evaluate(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void simpleTest(){
        evaluate("2+2;");


    }

    @Test
    public void checkCorrectness() {
        String expression = "a=(-2);\n" +
                "b=2+a;\n" +
                "-12;\n" +
                "c=a+b;\n";
        String expected = "a = -2\n" +
                "b = 0\n" +
                "-12\n" +
                "c = -2\n";
        String actual = evaluate(expression);

        assertEquals(expected, actual);
    }

    private String evaluate(String input) {
        CharStream stream = CharStreams.fromString(input);
        ArithmeticLexer lexer = new ArithmeticLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArithmeticParser parser = new ArithmeticParser(tokens);
        ParseTree tree = parser.start();

        ArithmeticVisitorImpl visitor = new ArithmeticVisitorImpl();
        visitor.visit(tree);

        return visitor.getResult();
    }
}
