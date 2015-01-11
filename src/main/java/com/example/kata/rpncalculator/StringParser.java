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
				operationStack.push(expression(current));
			}
		}

		return operationStack.pop();
	}

	private Computable expression(String current) {
		return getConstantFrom(current);
	}

	private Operator operator(String current) {
		return Operator.from(getOperatorFrom(current));
	}

	private boolean isOperator(String token) {
		return Operator.isOne(token);
	}

	private Computable getConstantFrom(String part) {
		return Constant.from(parseNumber(part));
	}

	private char getOperatorFrom(String part) {
		return part.charAt(0);
	}


	private int parseNumber(String string) {
		return Integer.parseInt(string);
	}
}
