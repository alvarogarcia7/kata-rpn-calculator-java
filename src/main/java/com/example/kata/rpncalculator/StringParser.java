package com.example.kata.rpncalculator;

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

		String[] parts = operationChain.split(" +");
		for (String current : parts) {
			if (!isOperator(current)) {
				tokenStack.push(current);
			} else {
				final String argument2 = tokenStack.pop();
				return new OperationTree(operator(current),
						expression(tokenStack.pop()),
						expression(argument2)
				);
			}
		}

		return OperationTree.EMPTY;


	}

	private Expression expression(String current) {
		return getConstantFrom(current);
	}

	private Operator operator(String current) {
		return Operator.from(getOperatorFrom(current));
	}

	private void read(Stack<String> tokenStack, List<OperationTree> operationTrees, List<Expression> expressionList) {
		if(tokenStack.isEmpty()){
			return;

		}
		if(isOperator(tokenStack.peek())){
			Operator operator = Operator.from(getOperatorFrom(tokenStack.pop()));
			read(tokenStack, operationTrees, expressionList);
		} else {
			Expression operand = getConstantFrom(tokenStack.pop());
			expressionList.add(operand);
			read(tokenStack, operationTrees, expressionList);
		}

	}


	private OperationTree popFromList(List<OperationTree> operationTrees) {
		OperationTree tree1 = operationTrees.get(operationTrees.size() - 1);
		operationTrees.remove(operationTrees.size() - 1);
		return tree1;
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
