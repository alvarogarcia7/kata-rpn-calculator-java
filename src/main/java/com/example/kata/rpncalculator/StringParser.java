package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {
	public OperationTree parse(String operationChain) {
		if(operationChain.length() < 8) {
			return parseSubString(operationChain, 0);
		} else if(operationChain.length() == 9){
			return new OperationTree(
					Operator.from(operationChain.charAt(8)),
					Expression.constant(parseNumber(operationChain.charAt(6))),
					parseSubString(operationChain, 0));
		} else {
			OperationTree tree1 = parseSubString(operationChain, 0);
			OperationTree tree2 = parseSubString(operationChain, 6);
			return new OperationTree(Operator.MINUS, tree1, tree2);
		}

	}

	private int parseNumber(char character) {
		return parseNumber(String.valueOf(character));
	}

	private OperationTree parseSubString(String operationChain, int begin) {
		String[] parts = operationChain.substring(begin).split(" +");

		return new OperationTree(
				Operator.from(getOperatorFrom(parts[2])),
				getConstantFrom(parts[0]),
				getConstantFrom(parts[1]));
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
