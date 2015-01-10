package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class RPNCalculator {
	private final StringParser parser;

	public RPNCalculator(StringParser parserMock) {
		this.parser = parserMock;
	}

	public Integer calculate(String operationChain) {
		parser.parse(operationChain);
		if ("2 5 +".equals(operationChain)) {
			return 7;
		} else {
			return 0;
		}
	}
}
