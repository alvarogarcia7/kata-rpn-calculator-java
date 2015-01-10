package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {
	public OperationTree parse(String operationChain) {
		return new OperationTree(
				Expression.operatorFrom(operationChain.charAt(4)),
				Expression.constant(parseNumber(operationChain.charAt(0))),
				Expression.constant(parseNumber(operationChain.charAt(2))));
	}

	private int parseNumber(char character) {
		return character - '0';
	}
}
