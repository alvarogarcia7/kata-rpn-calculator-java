package com.example.kata.rpncalculator;

import java.util.Optional;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTree {
	static final OperationTree EMPTY = null;
	private final Expression expression1;
	private final Optional<Operator> operator;
	private final OperationTree tree2;
	private final OperationTree tree1;

	public OperationTree(Operator operator, OperationTree tree1, OperationTree tree2) {
		this.tree1 = tree1;
		this.tree2 = tree2;
		this.operator = Optional.of(operator);
		expression1 = null;
	}

	public OperationTree(Expression constant) {
		tree1 = OperationTree.EMPTY;
		tree2 = OperationTree.EMPTY;
		expression1 = constant;
		operator = Optional.empty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OperationTree)) return false;

		OperationTree that = (OperationTree) o;

		if (expression1 != null ? !expression1.equals(that.expression1) : that.expression1 != null) return false;
		if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
		if (tree1 != null ? !tree1.equals(that.tree1) : that.tree1 != null) return false;
		if (tree2 != null ? !tree2.equals(that.tree2) : that.tree2 != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (expression1 != null ? expression1.hashCode() : 0);
		result = 31 * result + (operator != null ? operator.hashCode() : 0);
		result = 31 * result + (tree2 != null ? tree2.hashCode() : 0);
		result = 31 * result + (tree1 != null ? tree1.hashCode() : 0);
		return result;
	}

	public Integer compute() {
		Integer tree1Result;
		if (expression1 == null) {
			tree1Result = tree1.compute();
		} else {
			tree1Result = expression1.compute();
		}

		if (operator.isPresent()) {
			Integer tree2Result = tree2.compute();

			Operator operator = this.operator.get();
			if (operator == Operator.TIMES) {
				return tree1Result * tree2Result;
			} else if (operator == Operator.MINUS) {
				return tree1Result - tree2Result;
			} else if (operator == Operator.DIVISION) {
				return tree1Result / tree2Result;
			}
			return tree1Result + tree2Result;
		} else {
			return tree1Result;
		}

	}

	@Override
	public String toString() {
		return "OperationTree{" +
				 operator +
				", e1=" + expression1 +
				", t1=" + tree1 +
				", t2=" + tree2 +
				'}';
	}
}
