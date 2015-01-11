package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 11/01/15.
 */
public class OperationTreeLeaf implements Computable{
	protected final Computable tree1;

	public OperationTreeLeaf(Computable constant) {
		tree1 = constant;
	}

	@Override
	public Integer compute() {
		return tree1.compute();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OperationTreeLeaf)) return false;

		OperationTreeLeaf that = (OperationTreeLeaf) o;

		if (tree1 != null ? !tree1.equals(that.tree1) : that.tree1 != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return tree1 != null ? tree1.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "{" +
				tree1 +
				'}';
	}
}
