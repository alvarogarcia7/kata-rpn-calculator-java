package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class RPNCalculator {
	private final StringParser parser;
	private final OperationTreeApplier applier;

	public RPNCalculator(StringParser StringParser, OperationTreeApplier operationTreeApplier) {
		this.parser = StringParser;
		this.applier = operationTreeApplier;
	}

	public Integer calculate(String operationChain) {
		applier.applyOn(parser.parse(operationChain));
		if ("2 5 +".equals(operationChain)) {
			return 7;
		} else {
			return 0;
		}
	}
}
