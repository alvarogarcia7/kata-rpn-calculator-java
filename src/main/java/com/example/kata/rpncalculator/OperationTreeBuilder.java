package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeBuilder {
	private Operator operator;
	private Expression operand1;
	private Expression operand2;
	private OperationTree firstTree;

	public static OperationTreeBuilder aNew() {
		return new OperationTreeBuilder();
	}

	public OperationTreeBuilder withOperator(Operator operator) {
		this.operator = operator;
		return this;
	}

	public OperationTreeBuilder withOperands(int operand1, int operand2) {
		this.operand1 = Expression.constant(operand1);
		this.operand2 = Expression.constant(operand2);
		return this;
	}

	public OperationTree build() {
		if(null == firstTree) {
			return new OperationTree(operator, operand1, operand2);
		}
		return new OperationTree(operator, operand1, firstTree);
	}

	public OperationTreeBuilder withExpression(int constant) {
		this.operand1 = Expression.constant(constant);
		return this;
	}

	public OperationTreeBuilder and(OperationTree operationTree) {
		this.firstTree = operationTree;
		return this;
	}
}
