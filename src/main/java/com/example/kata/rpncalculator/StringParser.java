package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {

	public static final int TWO_EXPRESSIONS_LENGTH = 9;

	public OperationTree parse(String operationChain) {
		OperationTree parsedInStack = parseInAStack(operationChain);
		OperationTree operationTree;
		if(operationChain.length() < TWO_EXPRESSIONS_LENGTH) {
			operationTree = parseSubString(operationChain, 0);
		} else if(operationChain.length() == TWO_EXPRESSIONS_LENGTH){
			operationTree=new OperationTree(
					lastOperator(operationChain),
					Expression.constant(parseNumber(operationChain.charAt(6))),
					parseSubString(operationChain, 0));
		} else {
			OperationTree tree1 = parseSubString(operationChain, 0);
			OperationTree tree2 = parseSubString(operationChain, 6);
			operationTree = new OperationTree(lastOperator(operationChain), tree1, tree2);
		}

		if(operationTree.equals(parsedInStack)){
			return parsedInStack;
		}

		return operationTree;

	}

	private OperationTree parseInAStack(String operationChain) {
		return null;
	}

	private Operator lastOperator(String operationChain) {
		return Operator.from(operationChain.charAt(operationChain.length() - 1));
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
