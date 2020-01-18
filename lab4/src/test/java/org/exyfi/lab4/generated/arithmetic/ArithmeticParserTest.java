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
        String expression ="4>>1>>2";
        int expected =64;
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
    public void testMulAndDivOperatiodfsdfdn(){
        String expression = "(1+2)";
        int expected = 3;
        evaluateAndCheck(expression,expected);
    }

    @Test
    public void checkWrongExpression() {
        String expression = "2+342\32";
        int expected = 4;
        evaluateAndCheck(expression, expected);
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
