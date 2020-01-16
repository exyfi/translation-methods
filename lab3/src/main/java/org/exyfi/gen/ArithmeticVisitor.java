// Generated from /Users/daniilbolotov/TranslationMethods/lab3/src/main/resources/Arithmetic.g4 by ANTLR 4.7.2

package org.exyfi.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ArithmeticParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(ArithmeticParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ArithmeticParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#orOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperation(ArithmeticParser.OrOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpression(ArithmeticParser.XorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#andOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperation(ArithmeticParser.AndOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ArithmeticParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyingExpression(ArithmeticParser.MultiplyingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ArithmeticParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#signedAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedAtom(ArithmeticParser.SignedAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ArithmeticParser.AtomContext ctx);
}