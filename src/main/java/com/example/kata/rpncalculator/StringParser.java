package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {
	public OperationTree parse(String operationChain) {
		if(operationChain.length() < 8) {
			return parseSubString(operationChain);
		} else {
			return new OperationTree(
					Expression.operatorFrom(operationChain.charAt(8)),
					Expression.constant(parseNumber(operationChain.charAt(6))),
					parseSubString(operationChain));
		}
	}

	private int parseNumber(char character) {
		return parseNumber(String.valueOf(character));
	}

	private OperationTree parseSubString(String operationChain) {
		String[] parts = operationChain.split(" +");

		return new OperationTree(
				Expression.operatorFrom(parts[2].charAt(0)),
				Expression.constant(parseNumber(parts[0])),
				Expression.constant(parseNumber(parts[1])));
	}


	private int parseNumber(String string) {
		return Integer.parseInt(string);
	}
}
