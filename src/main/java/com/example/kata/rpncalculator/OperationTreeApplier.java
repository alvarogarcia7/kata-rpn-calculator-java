package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeApplier {
	public Integer applyOn(Computable operationTreeNode) {
		return operationTreeNode.compute();
	}
}
