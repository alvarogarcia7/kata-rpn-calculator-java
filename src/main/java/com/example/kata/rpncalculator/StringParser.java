package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {
	public OperationTree parse(String operationChain) {
		if(operationChain.length() == 5) {
			return new OperationTree(
					Expression.operatorFrom(operationChain.charAt(4)),
					Expression.constant(parseNumber(operationChain.charAt(0))),
					Expression.constant(parseNumber(operationChain.charAt(2))));
		} else {
			return new OperationTree(
					Expression.operatorFrom(operationChain.charAt(8)),
					Expression.constant(parseNumber(operationChain.charAt(6))),
					parseSubString(operationChain, 0, 4));
		}
	}

	private OperationTree parseSubString(String operationChain, int begin, int end) {
		return new OperationTree(
				Expression.operatorFrom(operationChain.charAt(begin + 4)),
				Expression.constant(parseNumber(operationChain.charAt(begin + 0))),
				Expression.constant(parseNumber(operationChain.charAt(begin + 2))));
	}

	private int parseNumber(char character) {
		return character - '0';
	}
}
