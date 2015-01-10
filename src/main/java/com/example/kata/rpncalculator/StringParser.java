package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class StringParser {
	public OperationTree parse(String operationChain) {
		return new OperationTree(Expression.SUM, Expression.constant(0), Expression.constant(0));
	}
}
