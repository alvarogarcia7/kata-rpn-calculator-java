package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeBuilder {
	private Operator operator;
	private OperationTreeBuilder tree1;
	private OperationTreeBuilder tree2;
	private Integer constant;

	public static OperationTreeBuilder aNew() {
		return new OperationTreeBuilder();
	}

	public OperationTreeBuilder withOperator(Operator operator) {
		this.operator = operator;
		return this;
	}

	public OperationTreeBuilder withOperands(int operand1, int operand2) {
		this.tree1 = aNew().withExpression(operand1);
		this.tree2 = aNew().withExpression(operand2);
		return this;
	}

	public Computable build() {
		if(null == constant) {
			return new OperationTreeNode(operator, tree1.build(), tree2.build());
		} else {
			return Constant.from(constant);
		}

	}

	public OperationTreeBuilder withOperands(OperationTreeBuilder operand1, OperationTreeBuilder operand2) {
		this.tree1 = operand1;
		this.tree2 = operand2;
		return this;
	}

	public OperationTreeBuilder withExpression(int constant) {
		this.constant = constant;
		return this;
	}
}
