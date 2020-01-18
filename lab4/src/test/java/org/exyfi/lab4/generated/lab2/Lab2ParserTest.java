package org.exyfi.lab4.generated.lab2;


import org.exyfi.lab4.exception.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;


public class Lab2ParserTest {
    private final Lab2Parser parser = new Lab2Parser();

    @Test
    public void testSimpleExpression() {

        String[] tests = {
                "a&b",
                "a&a&a",
                "a&((b&c)&(a&b))&c",
                "a&c&d&(a&(a&b)&c)&(d&e)"
        };
        for (String test : tests)
            evaluateAndCheck(test, test);
    }

    @Test
    public void testParser() {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/daniilbolotov/TranslationMethods/lab4/src/test/resources/tests"))) {
            String givenExample;
            while ((givenExample = reader.readLine()) != null) {
                evaluateAndCheck(givenExample,givenExample);
            }
        } catch (Exception e) {
            System.out.println("Exception was occurred " + e);
        }
    }


    private void evaluateAndCheck(String expression, String expected) {
        try {
            parser.parse(expression);
            String result = parser.parse(expression).v;
            Assert.assertEquals(result, expected);
        } catch (ParseException e) {
            System.out.println(String.format("Exception occurred during parsing expression %s %s", expression, e));
        }
    }

}


