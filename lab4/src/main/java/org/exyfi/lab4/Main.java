package org.exyfi.lab4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.exyfi.lab4.antlr.GrammarLexer;
import org.exyfi.lab4.antlr.GrammarParser;
import org.exyfi.lab4.generator.ClassGenerator;
import org.exyfi.lab4.generator.LexerGenerator;
import org.exyfi.lab4.generator.ParserGenerator;
import org.exyfi.lab4.generator.TokenGenerator;
import org.exyfi.lab4.grammar.ParsedGrammar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static org.exyfi.lab4.utils.TranslatorUtils.*;

/**
 * Automatic translator generator
 * <p>
 * Generates parser for LL(1) grammar class. Supports synthesized and inherited attributes
 * To generate parser for your grammar please provide path to your grammar file.
 *
 * @author daniilbolotov
 */
public class Main {

    private static final Logger log = Logger.getGlobal();

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            generateTranslatorForGivenGrammar(ARITHMETIC_GRAMMAR_PATH, ARITHMETIC_GEN_DIR);
            generateTranslatorForGivenGrammar(LAB2_GRAMMAR_PATH, LAB_2_GEN_DIR);
        } else {
            generateTranslatorForGivenGrammar(args[0], args[1]);
        }
    }

    private static void generateTranslatorForGivenGrammar(String grammarPath, String grammarGenDir) {
        try {
            Path pathToGrammarFile = Paths.get(grammarPath);

            File theDir = new File(COMMON_GEN_PATH, grammarGenDir);
            if (!theDir.exists()) {
                System.out.println("creating directory: " + theDir.getName());
                boolean result = false;

                try {
                    theDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
                if (result) {
                    log.info("Dir created");
                    System.out.println("DIR created");
                }

                String pathOut = theDir.getAbsolutePath();
                GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(pathToGrammarFile.toString()));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                GrammarParser parser = new GrammarParser(tokens);

                ParsedGrammar grammar = parser.start().v;

                if (grammar.buildFirstFollow()) {

                    ClassGenerator tokenGenerator = new TokenGenerator(pathOut, grammarGenDir, grammar);
                    tokenGenerator.printFile();

                    ClassGenerator lexerGenerator = new LexerGenerator(pathOut, grammarGenDir, grammar);
                    lexerGenerator.printFile();

                    ClassGenerator parserGenerator = new ParserGenerator(pathOut, grammarGenDir, grammar);
                    parserGenerator.printFile();
                } else {
                    log.warning("GIVEN GRAMMAR IS NOT RELATED TO LL(1) GRAMMAR CLASS");
                    return;
                }
                log.info("Parser was created");
            }
        } catch (IOException e) {
            log.info("Exception was occurred during IO operations " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printUsage() {
        System.out.println("To generate parser for your LL(1) grammar use \"java Main.class <grammarPath> <parserGenDir>.\n" +
                "Execution test grammars");
    }
}



