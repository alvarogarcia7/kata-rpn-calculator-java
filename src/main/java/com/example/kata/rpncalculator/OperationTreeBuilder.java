package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeBuilder {
	private Expression operator;
	private Expression operand1;
	private Expression operand2;

	public static OperationTreeBuilder aNew() {
		return new OperationTreeBuilder();
	}

	public OperationTreeBuilder withOperator(Expression operator) {
		this.operator = operator;
		return this;
	}

	public OperationTreeBuilder withOperands(int operand1, int operand2) {
		this.operand1 = Expression.constant(operand1);
		this.operand2 = Expression.constant(operand2);
		return this;
	}

	public OperationTree build() {
		return new OperationTree(operator, operand1, operand2);
	}
}
