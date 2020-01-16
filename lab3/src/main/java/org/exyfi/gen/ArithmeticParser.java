// Generated from /Users/daniilbolotov/TranslationMethods/lab3/src/main/resources/Arithmetic.g4 by ANTLR 4.7.2

package org.exyfi.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, MULTIPLY=3, DIV=4, AND=5, OR=6, XOR=7, NOT=8, LPAREN=9, 
		RPAREN=10, ASSIGN=11, COMMA=12, INT=13, VAR=14, WS=15;
	public static final int
		RULE_start = 0, RULE_line = 1, RULE_declaration = 2, RULE_orOperation = 3, 
		RULE_xorExpression = 4, RULE_andOperation = 5, RULE_expression = 6, RULE_multiplyingExpression = 7, 
		RULE_notExpression = 8, RULE_signedAtom = 9, RULE_atom = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "line", "declaration", "orOperation", "xorExpression", "andOperation", 
			"expression", "multiplyingExpression", "notExpression", "signedAtom", 
			"atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'!'", "'('", 
			"')'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "MULTIPLY", "DIV", "AND", "OR", "XOR", "NOT", 
			"LPAREN", "RPAREN", "ASSIGN", "COMMA", "INT", "VAR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArithmeticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ArithmeticParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR) | (1L << NOT) | (1L << LPAREN) | (1L << INT) | (1L << VAR))) != 0)) {
				{
				{
				setState(22);
				line();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ArithmeticParser.ASSIGN, 0); }
		public OrOperationContext orOperation() {
			return getRuleContext(OrOperationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ArithmeticParser.COMMA, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				declaration();
				setState(31);
				match(ASSIGN);
				{
				setState(32);
				orOperation(0);
				setState(33);
				match(COMMA);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				orOperation(0);
				setState(36);
				match(COMMA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ArithmeticParser.VAR, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrOperationContext extends ParserRuleContext {
		public OrOperationContext left;
		public Token op;
		public XorExpressionContext right;
		public XorExpressionContext xorExpression() {
			return getRuleContext(XorExpressionContext.class,0);
		}
		public OrOperationContext orOperation() {
			return getRuleContext(OrOperationContext.class,0);
		}
		public TerminalNode OR() { return getToken(ArithmeticParser.OR, 0); }
		public OrOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterOrOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitOrOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitOrOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrOperationContext orOperation() throws RecognitionException {
		return orOperation(0);
	}

	private OrOperationContext orOperation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrOperationContext _localctx = new OrOperationContext(_ctx, _parentState);
		OrOperationContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_orOperation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43);
			xorExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrOperationContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_orOperation);
					setState(45);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(46);
					((OrOperationContext)_localctx).op = match(OR);
					setState(47);
					((OrOperationContext)_localctx).right = xorExpression(0);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class XorExpressionContext extends ParserRuleContext {
		public XorExpressionContext left;
		public Token op;
		public AndOperationContext right;
		public AndOperationContext andOperation() {
			return getRuleContext(AndOperationContext.class,0);
		}
		public XorExpressionContext xorExpression() {
			return getRuleContext(XorExpressionContext.class,0);
		}
		public TerminalNode XOR() { return getToken(ArithmeticParser.XOR, 0); }
		public XorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitXorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitXorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorExpressionContext xorExpression() throws RecognitionException {
		return xorExpression(0);
	}

	private XorExpressionContext xorExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XorExpressionContext _localctx = new XorExpressionContext(_ctx, _parentState);
		XorExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_xorExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(54);
			andOperation(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new XorExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_xorExpression);
					setState(56);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(57);
					((XorExpressionContext)_localctx).op = match(XOR);
					setState(58);
					((XorExpressionContext)_localctx).right = andOperation(0);
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndOperationContext extends ParserRuleContext {
		public AndOperationContext left;
		public Token op;
		public ExpressionContext right;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AndOperationContext andOperation() {
			return getRuleContext(AndOperationContext.class,0);
		}
		public TerminalNode AND() { return getToken(ArithmeticParser.AND, 0); }
		public AndOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterAndOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitAndOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAndOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndOperationContext andOperation() throws RecognitionException {
		return andOperation(0);
	}

	private AndOperationContext andOperation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndOperationContext _localctx = new AndOperationContext(_ctx, _parentState);
		AndOperationContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_andOperation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(65);
			expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndOperationContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_andOperation);
					setState(67);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(68);
					((AndOperationContext)_localctx).op = match(AND);
					setState(69);
					((AndOperationContext)_localctx).right = expression(0);
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token op;
		public MultiplyingExpressionContext right;
		public MultiplyingExpressionContext multiplyingExpression() {
			return getRuleContext(MultiplyingExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ArithmeticParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ArithmeticParser.MINUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(76);
			multiplyingExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(78);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(79);
					((ExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(80);
					((ExpressionContext)_localctx).right = multiplyingExpression(0);
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplyingExpressionContext extends ParserRuleContext {
		public MultiplyingExpressionContext left;
		public Token op;
		public NotExpressionContext right;
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public MultiplyingExpressionContext multiplyingExpression() {
			return getRuleContext(MultiplyingExpressionContext.class,0);
		}
		public TerminalNode MULTIPLY() { return getToken(ArithmeticParser.MULTIPLY, 0); }
		public TerminalNode DIV() { return getToken(ArithmeticParser.DIV, 0); }
		public MultiplyingExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyingExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterMultiplyingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitMultiplyingExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitMultiplyingExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyingExpressionContext multiplyingExpression() throws RecognitionException {
		return multiplyingExpression(0);
	}

	private MultiplyingExpressionContext multiplyingExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplyingExpressionContext _localctx = new MultiplyingExpressionContext(_ctx, _parentState);
		MultiplyingExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_multiplyingExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(87);
			notExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplyingExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_multiplyingExpression);
					setState(89);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(90);
					((MultiplyingExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==MULTIPLY || _la==DIV) ) {
						((MultiplyingExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(91);
					((MultiplyingExpressionContext)_localctx).right = notExpression(0);
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NotExpressionContext extends ParserRuleContext {
		public NotExpressionContext left;
		public Token op;
		public SignedAtomContext right;
		public SignedAtomContext signedAtom() {
			return getRuleContext(SignedAtomContext.class,0);
		}
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ArithmeticParser.NOT, 0); }
		public NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		return notExpression(0);
	}

	private NotExpressionContext notExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, _parentState);
		NotExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_notExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(98);
			signedAtom();
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NotExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_notExpression);
					setState(100);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(101);
					((NotExpressionContext)_localctx).op = match(NOT);
					setState(102);
					((NotExpressionContext)_localctx).right = signedAtom();
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SignedAtomContext extends ParserRuleContext {
		public Token op;
		public SignedAtomContext signedAtom() {
			return getRuleContext(SignedAtomContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ArithmeticParser.PLUS, 0); }
		public TerminalNode NOT() { return getToken(ArithmeticParser.NOT, 0); }
		public TerminalNode OR() { return getToken(ArithmeticParser.OR, 0); }
		public TerminalNode MINUS() { return getToken(ArithmeticParser.MINUS, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SignedAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterSignedAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitSignedAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitSignedAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedAtomContext signedAtom() throws RecognitionException {
		SignedAtomContext _localctx = new SignedAtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_signedAtom);
		int _la;
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((SignedAtomContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << OR) | (1L << NOT))) != 0)) ) {
					((SignedAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(109);
				signedAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((SignedAtomContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << OR) | (1L << NOT))) != 0)) ) {
					((SignedAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(111);
				signedAtom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				atom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ArithmeticParser.VAR, 0); }
		public TerminalNode INT() { return getToken(ArithmeticParser.INT, 0); }
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(ArithmeticParser.NOT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmeticListener ) ((ArithmeticListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(VAR);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(INT);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(LPAREN);
				setState(118);
				expression(0);
				setState(119);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				match(NOT);
				setState(122);
				match(LPAREN);
				setState(123);
				expression(0);
				setState(124);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return orOperation_sempred((OrOperationContext)_localctx, predIndex);
		case 4:
			return xorExpression_sempred((XorExpressionContext)_localctx, predIndex);
		case 5:
			return andOperation_sempred((AndOperationContext)_localctx, predIndex);
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 7:
			return multiplyingExpression_sempred((MultiplyingExpressionContext)_localctx, predIndex);
		case 8:
			return notExpression_sempred((NotExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean orOperation_sempred(OrOperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xorExpression_sempred(XorExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andOperation_sempred(AndOperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplyingExpression_sempred(MultiplyingExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean notExpression_sempred(NotExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3)\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\63\n\5\f"+
		"\5\16\5\66\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6>\n\6\f\6\16\6A\13\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7I\n\7\f\7\16\7L\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b"+
		"T\n\b\f\b\16\bW\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t_\n\t\f\t\16\tb\13\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13t\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0081\n\f"+
		"\3\f\2\b\b\n\f\16\20\22\r\2\4\6\b\n\f\16\20\22\24\26\2\6\3\2\3\4\3\2\5"+
		"\6\5\2\3\3\b\b\n\n\5\2\4\4\b\b\n\n\2\u0084\2\33\3\2\2\2\4(\3\2\2\2\6*"+
		"\3\2\2\2\b,\3\2\2\2\n\67\3\2\2\2\fB\3\2\2\2\16M\3\2\2\2\20X\3\2\2\2\22"+
		"c\3\2\2\2\24s\3\2\2\2\26\u0080\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32"+
		"\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36"+
		"\37\7\2\2\3\37\3\3\2\2\2 !\5\6\4\2!\"\7\r\2\2\"#\5\b\5\2#$\7\16\2\2$)"+
		"\3\2\2\2%&\5\b\5\2&\'\7\16\2\2\')\3\2\2\2( \3\2\2\2(%\3\2\2\2)\5\3\2\2"+
		"\2*+\7\20\2\2+\7\3\2\2\2,-\b\5\1\2-.\5\n\6\2.\64\3\2\2\2/\60\f\4\2\2\60"+
		"\61\7\b\2\2\61\63\5\n\6\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65"+
		"\3\2\2\2\65\t\3\2\2\2\66\64\3\2\2\2\678\b\6\1\289\5\f\7\29?\3\2\2\2:;"+
		"\f\4\2\2;<\7\t\2\2<>\5\f\7\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@"+
		"\13\3\2\2\2A?\3\2\2\2BC\b\7\1\2CD\5\16\b\2DJ\3\2\2\2EF\f\4\2\2FG\7\7\2"+
		"\2GI\5\16\b\2HE\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\r\3\2\2\2LJ\3\2"+
		"\2\2MN\b\b\1\2NO\5\20\t\2OU\3\2\2\2PQ\f\4\2\2QR\t\2\2\2RT\5\20\t\2SP\3"+
		"\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\17\3\2\2\2WU\3\2\2\2XY\b\t\1\2Y"+
		"Z\5\22\n\2Z`\3\2\2\2[\\\f\4\2\2\\]\t\3\2\2]_\5\22\n\2^[\3\2\2\2_b\3\2"+
		"\2\2`^\3\2\2\2`a\3\2\2\2a\21\3\2\2\2b`\3\2\2\2cd\b\n\1\2de\5\24\13\2e"+
		"k\3\2\2\2fg\f\4\2\2gh\7\n\2\2hj\5\24\13\2if\3\2\2\2jm\3\2\2\2ki\3\2\2"+
		"\2kl\3\2\2\2l\23\3\2\2\2mk\3\2\2\2no\t\4\2\2ot\5\24\13\2pq\t\5\2\2qt\5"+
		"\24\13\2rt\5\26\f\2sn\3\2\2\2sp\3\2\2\2sr\3\2\2\2t\25\3\2\2\2u\u0081\7"+
		"\20\2\2v\u0081\7\17\2\2wx\7\13\2\2xy\5\16\b\2yz\7\f\2\2z\u0081\3\2\2\2"+
		"{|\7\n\2\2|}\7\13\2\2}~\5\16\b\2~\177\7\f\2\2\177\u0081\3\2\2\2\u0080"+
		"u\3\2\2\2\u0080v\3\2\2\2\u0080w\3\2\2\2\u0080{\3\2\2\2\u0081\27\3\2\2"+
		"\2\f\33(\64?JU`ks\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}