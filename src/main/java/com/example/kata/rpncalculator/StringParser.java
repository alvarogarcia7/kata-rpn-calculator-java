package com.example.kata.rpncalculator;

import java.util.Stack;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {

	public Computable parse(String operationChain) {
		return parseInAStack(operationChain);
	}

	private Computable parseInAStack(String operationChain) {

		String[] parts = operationChain.split(" +");
		Stack<Computable> operationStack = new Stack<>();
		for (String current : parts) {
			if (isOperator(current)) {
				Computable tmp = operationStack.pop();
				operationStack.push(new OperationTreeNode(operator(current),
						operationStack.pop(), tmp));
			} else {
				operationStack.push(constant(current));
			}
		}

		return operationStack.pop();
	}

	private Computable constant(String token) {
		return Constant.from(parseNumber(token));
	}

	private Operator operator(String token) {
		return Operator.from(getOperatorFrom(token));
	}

	private boolean isOperator(String token) {
		return Operator.isOne(token);
	}

	private char getOperatorFrom(String token) {
		return token.charAt(0);
	}


	private int parseNumber(String token) {
		return Integer.parseInt(token);
	}
}
