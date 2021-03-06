package org.exyfi.lab4.generated.arithmetic;

import org.exyfi.lab4.exception.ParseException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticParserTest {
    private static final ArithmeticParser parser = new ArithmeticParser();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testExpression() {
        String expression = "2+2";
        int expected = 4;
        evaluateAndCheck(expression, expected);
    }

    @Test
    public void testShiftRightExpression(){
        String expression ="4 >> 2 >> 1 >> 2 >> 2";
        int expected =2;
        evaluateAndCheck(expression,expected);
    }

    @Test
    public void testShiftRightExpressionWithBrackets(){
        String expression ="(1 >> 2)";
        int expected =0;
        evaluateAndCheck(expression,expected);
    }

    @Test
    public void testShiftRightExpressionAgain(){
        String expression ="(4>>2)";
        int expected = 1;
        evaluateAndCheck(expression,expected);
    }

    @Test
    public void testMulAndDivOperation(){
        String expression = "(1+2)*(-3*(7-4)+2)";
        int expected = -21;
        evaluateAndCheck(expression,expected);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivByZero(){
        String expression ="4/0";
        evaluateAndCheck(expression,0);
    }

    @Test
    public void testExpressionWithBrackets(){
        String expression = "(1+2)";
        int expected = 3;
        evaluateAndCheck(expression,expected);
    }

    private void evaluateAndCheck(String expression, int expected) {
        try {
            parser.parse("2");
            int result = parser.parse(expression).v;
            Assert.assertEquals(result, expected);
        } catch (ParseException e) {
            System.out.println(String.format("Exception occurred during parsing expression %s %s", expression, e));
        }
    }
}
