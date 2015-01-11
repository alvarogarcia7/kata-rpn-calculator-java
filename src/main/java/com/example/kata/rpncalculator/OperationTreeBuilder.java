package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeBuilder {
	private Operator operator;
	private Computable tree1;
	private Computable tree2;
	private Integer constant;

	public static OperationTreeBuilder aNew() {
		return new OperationTreeBuilder();
	}

	public OperationTreeBuilder withOperator(Operator operator) {
		this.operator = operator;
		return this;
	}

	public OperationTreeBuilder withOperands(int operand1, int operand2) {
		this.tree1 = Expression.constant(operand1);
		this.tree2 = Expression.constant(operand2);
		return this;
	}

	public Computable build() {
		if(null == constant) {
			return new OperationTreeNode(operator, tree1, tree2);
		} else {
			return Expression.constant(constant);
		}

	}

	public OperationTreeBuilder withOperands(OperationTreeBuilder operand1, OperationTreeBuilder operand2) {
		this.tree1 = operand1.build();
		this.tree2 = operand2.build();
		return this;
	}

	public OperationTreeBuilder withExpression(int constant) {
		this.constant = constant;
		return this;
	}
}
