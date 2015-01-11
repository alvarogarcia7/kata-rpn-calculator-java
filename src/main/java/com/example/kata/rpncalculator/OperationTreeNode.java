package com.example.kata.rpncalculator;

import java.util.Optional;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTreeNode extends OperationTreeLeaf implements Computable{
	static final OperationTreeNode EMPTY = null;
	private final Optional<Operator> operator;
	private final Computable tree2;

	public OperationTreeNode(Operator operator, Computable tree1, Computable tree2) {
		super(tree1);
		this.tree2 = tree2;
		this.operator = Optional.of(operator);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OperationTreeNode)) return false;

		OperationTreeNode that = (OperationTreeNode) o;

		if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
		if (tree1 != null ? !tree1.equals(that.tree1) : that.tree1 != null) return false;
		if (tree2 != null ? !tree2.equals(that.tree2) : that.tree2 != null) return false;

		return true;
	}


	@Override
	public Constant compute() {
		int tree1Result = tree1.compute().value();

		int computedValue;
		if (operator.isPresent()) {
			int tree2Result = tree2.compute().value();

			Operator operator = this.operator.get();
			if (operator == Operator.TIMES) {
				computedValue = tree1Result * tree2Result;
			} else if (operator == Operator.MINUS) {
				computedValue = tree1Result - tree2Result;
			} else if (operator == Operator.DIVISION) {
				computedValue =  tree1Result / tree2Result;
			} else {
				computedValue = tree1Result + tree2Result;
			}
		} else {
			computedValue = tree1Result;
		}

		return Constant.from(computedValue);

	}

	@Override
	public int hashCode() {
		int result = operator != null ? operator.hashCode() : 0;
		result = 31 * result + (tree2 != null ? tree2.hashCode() : 0);
		result = 31 * result + (tree1 != null ? tree1.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
			return "{" +
					operator.get() +
					", t1=" + tree1 +
					", t2=" + tree2 +
					'}';
	}

}
