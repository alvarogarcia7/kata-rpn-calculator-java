package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeBuilder {
	private Operator operator;
	private OperationTree tree1;
	private OperationTree tree2;

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
			return new OperationTree(operator, tree1, tree2);

	}

	public OperationTreeBuilder withExpression(int constant) {
		this.tree2 = new OperationTree(Expression.constant(constant));
		return this;
	}

	public OperationTreeBuilder and(OperationTree operationTree) {
		this.tree1 = operationTree;
		return this;
	}

	public OperationTreeBuilder withOperands(OperationTree operand1, OperationTree operand2) {
		this.tree1 = operand1;
		this.tree2 = operand2;
		return this;
	}
}
