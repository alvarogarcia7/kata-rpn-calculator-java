package com.example.kata.rpncalculator;

import java.util.Optional;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTree {
	static final OperationTree EMPTY = null;
	private final Expression expression2;
	private final Expression expression1;
	private final Optional<Operator> operator;
	private final OperationTree tree2;
	private final OperationTree tree1;

	public OperationTree(Operator operator, Expression expression1, Expression expression2) {
		this.operator = Optional.of(operator);
		this.expression1 = expression1;
		this.expression2 = expression2;
		this.tree2 = OperationTree.EMPTY;
		this.tree1 = OperationTree.EMPTY;
	}

	public OperationTree(Operator operator, Expression operand1, OperationTree firstTree) {
		this.operator = Optional.of(operator);
		this.expression1 = operand1;
		this.expression2 = null;
		this.tree2 = firstTree;
		this.tree1 = OperationTree.EMPTY;
	}

	public OperationTree(Operator operator, OperationTree tree1, OperationTree tree2) {
		this.tree1 = tree1;
		this.tree2 = tree2;
		this.operator = Optional.of(operator);
		expression1 = null;
		expression2 = null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OperationTree)) return false;

		OperationTree that = (OperationTree) o;

		if (expression1 != null ? !expression1.equals(that.expression1) : that.expression1 != null) return false;
		if (expression2 != null ? !expression2.equals(that.expression2) : that.expression2 != null) return false;
		if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
		if (tree1 != null ? !tree1.equals(that.tree1) : that.tree1 != null) return false;
		if (tree2 != null ? !tree2.equals(that.tree2) : that.tree2 != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = expression2 != null ? expression2.hashCode() : 0;
		result = 31 * result + (expression1 != null ? expression1.hashCode() : 0);
		result = 31 * result + (operator != null ? operator.hashCode() : 0);
		result = 31 * result + (tree2 != null ? tree2.hashCode() : 0);
		result = 31 * result + (tree1 != null ? tree1.hashCode() : 0);
		return result;
	}

	public Integer compute() {

		Integer tree2Result;
		if(tree2 == null) {
			tree2Result = expression2.compute();
		} else {
			tree2Result = tree2.compute();
		}

		if(operator.isPresent()) {
			Operator operator = this.operator.get();
			if (operator == Operator.TIMES) {
				return expression1.compute() * tree2Result;
			} else if (operator == Operator.MINUS) {
				return expression1.compute() - tree2Result;
			} else if (operator == Operator.DIVISION) {
				return expression1.compute() / tree2Result;
			}

			return expression1.compute() + tree2Result;
		} else {
			return tree1.compute();
		}

	}

	@Override
	public String toString() {
		return "OperationTree{" +
				 operator +
				", e1=" + expression1 +
				", e2=" + expression2 +
				", t1=" + tree1 +
				", t2=" + tree2 +
				'}';
	}
}
