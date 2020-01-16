// Generated from /Users/daniilbolotov/TranslationMethods/lab3/src/main/resources/Arithmetic.g4 by ANTLR 4.7.2

package org.exyfi.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticParser}.
 */
public interface ArithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ArithmeticParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ArithmeticParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ArithmeticParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ArithmeticParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ArithmeticParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ArithmeticParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#orOperation}.
	 * @param ctx the parse tree
	 */
	void enterOrOperation(ArithmeticParser.OrOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#orOperation}.
	 * @param ctx the parse tree
	 */
	void exitOrOperation(ArithmeticParser.OrOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#xorExpression}.
	 * @param ctx the parse tree
	 */
	void enterXorExpression(ArithmeticParser.XorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#xorExpression}.
	 * @param ctx the parse tree
	 */
	void exitXorExpression(ArithmeticParser.XorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#andOperation}.
	 * @param ctx the parse tree
	 */
	void enterAndOperation(ArithmeticParser.AndOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#andOperation}.
	 * @param ctx the parse tree
	 */
	void exitAndOperation(ArithmeticParser.AndOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ArithmeticParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ArithmeticParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(ArithmeticParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(ArithmeticParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(ArithmeticParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(ArithmeticParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(ArithmeticParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(ArithmeticParser.SignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ArithmeticParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ArithmeticParser.AtomContext ctx);
}