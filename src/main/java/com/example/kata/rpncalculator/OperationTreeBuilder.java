package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeBuilder {
	private Operator operator;
	private OperationTree tree1;
	private OperationTree tree2;
	private Integer constant;

	public static OperationTreeBuilder aNew() {
		return new OperationTreeBuilder();
	}

	public OperationTreeBuilder withOperator(Operator operator) {
		this.operator = operator;
		return this;
	}

	public OperationTreeBuilder withOperands(int operand1, int operand2) {
		this.tree1 = new OperationTree(Expression.constant(operand1));
		this.tree2 = new OperationTree(Expression.constant(operand2));
		return this;
	}

	public OperationTree build() {
		if(null == constant) {
			return new OperationTree(operator, tree1, tree2);
		} else {
			return new OperationTree(new Expression(constant));
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
