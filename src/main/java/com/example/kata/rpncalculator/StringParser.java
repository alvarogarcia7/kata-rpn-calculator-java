package com.example.kata.rpncalculator;

import java.util.Stack;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {

	public OperationTree parse(String operationChain) {
		return parseInAStack(operationChain);
	}

	private OperationTree parseInAStack(String operationChain) {

		String[] parts = operationChain.split(" +");
		Stack<OperationTree> operationStack = new Stack<>();
		for (String current : parts) {
			if (isOperator(current)) {
				OperationTree tmp = operationStack.pop();
				operationStack.push(new OperationTree(operator(current),
						operationStack.pop(), tmp));
			} else {
				operationStack.push(new OperationTree(expression(current)));
			}
		}

		return operationStack.pop();
	}

	private Expression expression(String current) {
		return getConstantFrom(current);
	}

	private Operator operator(String current) {
		return Operator.from(getOperatorFrom(current));
	}

	private boolean isOperator(String token) {
		return Operator.isOne(token);
	}

	private Expression getConstantFrom(String part) {
		return Expression.constant(parseNumber(part));
	}

	private char getOperatorFrom(String part) {
		return part.charAt(0);
	}


	private int parseNumber(String string) {
		return Integer.parseInt(string);
	}
}
