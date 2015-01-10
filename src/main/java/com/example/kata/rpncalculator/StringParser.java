package com.example.kata.rpncalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {

	public static final int TWO_EXPRESSIONS_LENGTH = 9;

	public OperationTree parse(String operationChain) {
		OperationTree parsedInStack = parseInAStack(operationChain);
		OperationTree operationTree;
		if(operationChain.length() < TWO_EXPRESSIONS_LENGTH) {
			return parsedInStack;
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

		return operationTree;

	}

	private OperationTree parseInAStack(String operationChain) {
		Stack<String> tokenStack = getTokens(operationChain);
		List<OperationTree> operationTrees = new LinkedList<>();
		while (!tokenStack.isEmpty()){
			parseSubString(tokenStack, operationTrees);
		}
		return operationTrees.get(0);
	}

	private void parseSubString(Stack<String> tokenStack, List<OperationTree> operationTrees) {
		String current = tokenStack.pop();
		if(isOperator(current)){
			String operand1 = tokenStack.pop();
			String operand2 = tokenStack.pop();
			try {
				operationTrees.add(
						new OperationTree(Operator.from(current.charAt(0)),
							Expression.constant(parseNumber(operand2)),
							Expression.constant(parseNumber(operand1))));
			}catch (NumberFormatException e){
				operationTrees.add(OperationTree.EMPTY);
			}
		}
	}

	private Stack<String> getTokens(String operationChain) {
		String[] parts = operationChain.split(" +");
		Stack<String> tokenStack = new Stack<>();
		for (String current : parts) {
			tokenStack.push(current);
		}
		return tokenStack;
	}

	private boolean isOperator(String token) {
		return Operator.isOne(token);
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
