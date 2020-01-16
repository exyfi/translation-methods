import jdk.jfr.Description;
import org.apache.commons.io.IOUtils;
import org.exyfi.simpleparser.LexicalAnalyzer;
import org.exyfi.simpleparser.Parser;
import org.exyfi.simpleparser.Token;
import org.exyfi.simpleparser.Tree;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void testLexer() {
        try {
            String s = "a&b&c&d|c|c|c";
            Token[] expectedTokens = {Token.VAR, Token.AND, Token.VAR, Token.AND, Token.VAR, Token.AND, Token.VAR, Token.OR, Token.VAR, Token.OR, Token.VAR, Token.OR, Token.VAR};
            List<Token> actualTokens = new ArrayList<>();

            InputStream inputStream = IOUtils.toInputStream(s, "UTF-8");
            LexicalAnalyzer lexer = new LexicalAnalyzer(inputStream);

            while (lexer.getCurToken() != Token.END) {
                actualTokens.add(lexer.getCurToken());
                lexer.nextToken();
            }

            assertArrayEquals(expectedTokens, actualTokens.toArray());
        } catch (IOException | ParseException e) {
            System.out.println("Exception was occurred " + e);
        }
    }

    @Test
    public void testParser() {
        try (BufferedReader reader = IOUtils.toBufferedReader(new FileReader("/Users/daniilbolotov/TranslationMethods/lab2/src/test/resources/tests"))) {
            String givenExample;
            while ((givenExample = reader.readLine()) != null) {
                Parser parser = new Parser();
                Tree parseResultTree = parser.parse(IOUtils.toInputStream(givenExample, "UTF-8"));
                String actual = convertTreeToString(parseResultTree);
                assertEquals(givenExample, actual);
            }

        } catch (Exception e) {
            System.out.println("Exception was occurred " + e);
        }
    }

    @Test(expected = ParseException.class)
    @Ignore("To start this test please change your rule C -> !C to C -> !D. It's a test for my modification, which involves that we avoid n>=2 sequence of NOT tokens")
    @Description("Избавиться от нескольких отрицаний подряд. Такой пример не должен парситься: !!!(a&b)" +
            "Правило C -> !C делаем как C -> !D")
    public void testModification() throws ParseException {
        try {
            String expression = "!!(a)";
            Parser parser = new Parser();
            parser.parse(IOUtils.toInputStream(expression, "UTF-8"));
        } catch (IOException e) {
            System.out.println("Exception was occurred " + e);
        }
    }

    private String convertTreeToString(Tree parseResultTree) {
        StringBuilder result = new StringBuilder();
        dfs(parseResultTree, result);

        return result.toString();
    }

    private static void dfs(Tree v, StringBuilder sb) {
        if (v.getChildren() == null) {
            if (!v.getNode().equals("ε")) {
                sb.append(v.getNode());
            }
        } else {
            for (Tree ch : v.getChildren()) {
                dfs(ch, sb);
            }
        }
    }
}
