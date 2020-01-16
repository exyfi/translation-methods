package org.exyfi.lab3.arithmetic;

import org.exyfi.gen.ArithmeticBaseVisitor;
import org.exyfi.gen.ArithmeticParser;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticVisitorImpl extends ArithmeticBaseVisitor<Integer> {
    private Map<String, Integer> variableNames = new HashMap<>();
    private String currentVariable;
    private StringBuilder sb = new StringBuilder();

    public String getResult() {
        return sb.toString();
    }

    @Override
    public Integer visitStart(ArithmeticParser.StartContext ctx) {
        return super.visitStart(ctx);
    }

    @Override
    public Integer visitLine(ArithmeticParser.LineContext ctx) {
        currentVariable = "";
        if (ctx.declaration() != null) {
            visitDeclaration(ctx.declaration());
        }
        Integer result = visitOrOperation(ctx.orOperation());
        if (currentVariable.isEmpty()) {
            sb.append(result).append("\n");
        } else {
            sb.append(currentVariable).append(" = ").append(result).append("\n");
            variableNames.put(currentVariable, result);
        }
        return result;
    }

    @Override
    public Integer visitDeclaration(ArithmeticParser.DeclarationContext ctx) {
        if (ctx == null) {
            throw new IllegalStateException("Variable mustn't be null");
        }
        currentVariable = ctx.getText();
        return super.visitDeclaration(ctx);
    }

    @Override
    public Integer visitOrOperation(ArithmeticParser.OrOperationContext ctx){
        if (ctx.op == null) {
            return super.visitOrOperation(ctx);
        } else {
            String operator = ctx.op.getText();
            switch (operator) {
                case "|":
                    return visit(ctx.left) | visit(ctx.right);

                default:
                    throw new UnsupportedOperationException("Interpreter does not support " + operator);
            }
        }
    }

    @Override
    public Integer visitXorExpression(ArithmeticParser.XorExpressionContext ctx){
        if (ctx.op == null) {
            return super.visitXorExpression(ctx);
        } else {
            String operator = ctx.op.getText();
            switch (operator) {
                case "^":
                    return visit(ctx.left) ^ visit(ctx.right);
                default:
                    throw new UnsupportedOperationException("Unsupported operation " + operator);
            }
        }

    }

    @Override
    public Integer visitAndOperation(ArithmeticParser.AndOperationContext ctx){
        if (ctx.op == null) {
            return super.visitAndOperation(ctx);
        } else {
            String operator = ctx.op.getText();
            switch (operator) {
                case "&":
                    return visit(ctx.left) & visit(ctx.right);
                default:
                    throw new UnsupportedOperationException("Unsupported operation " + operator);
            }
        }
    }

    @Override
    public Integer visitExpression(ArithmeticParser.ExpressionContext ctx) {
        if (ctx.op == null) {
            return super.visitExpression(ctx);
        } else {
            String operator = ctx.op.getText();
            switch (operator) {
                case "+":
                    return visit(ctx.left) + visit(ctx.right);
                case "-":
                    return visit(ctx.left) - visit(ctx.right);
                default:
                    throw new UnsupportedOperationException("Interpreter does not support " + operator);
            }
        }
    }

    @Override
    public Integer visitMultiplyingExpression(ArithmeticParser.MultiplyingExpressionContext ctx) {
        if (ctx.op == null) {
            return super.visitMultiplyingExpression(ctx);
        } else {
            String operator = ctx.op.getText();
            switch (operator) {
                case "*":
                    return visit(ctx.left) * visit(ctx.right);
                case "/":
                    Integer rightVisit = visit(ctx.right);
                    if (rightVisit == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return visit(ctx.left) / rightVisit;
                default:
                    throw new UnsupportedOperationException("Unsupported operation " + operator);
            }
        }
    }

    @Override
    public Integer visitSignedAtom(ArithmeticParser.SignedAtomContext ctx) {
        if (ctx.op == null) {
            return visitAtom(ctx.atom());
        } else {
            String operator = ctx.op.getText();
            switch (operator) {
                case "+":
                    return visit(ctx.signedAtom());
                case "-":
                    return -visit(ctx.signedAtom());
                case "!":
                    return ~visit(ctx.signedAtom());
                default:
                    throw new UnsupportedOperationException("Unsupported operation " + operator);
            }
        }
    }

    @Override
    public Integer visitAtom(ArithmeticParser.AtomContext ctx) {
        if (ctx.VAR() != null) {
            String varName = ctx.VAR().getText();
            if (variableNames.containsKey(varName)) {
                return variableNames.get(varName);
            } else {
                throw new IllegalStateException("Variable " + varName + " is not defined");
            }
        } else if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        } else {
            return visitExpression(ctx.expression());
        }
    }
}


