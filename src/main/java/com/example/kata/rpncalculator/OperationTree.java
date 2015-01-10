package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class OperationTree {
	private final Expression expression2;
	private final Expression expression1;
	private final Expression operator;

	public OperationTree(Expression operator, Expression expression1, Expression expression2) {
		this.operator = operator;
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OperationTree)) return false;

		OperationTree that = (OperationTree) o;

		if (!expression1.equals(that.expression1)) return false;
		if (!expression2.equals(that.expression2)) return false;
		if (!operator.equals(that.operator)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = expression2.hashCode();
		result = 31 * result + expression1.hashCode();
		result = 31 * result + operator.hashCode();
		return result;
	}

	public Integer compute() {
		if(operator == Expression.TIMES){
			return expression1.compute() * expression2.compute();
		}
		return expression1.compute() + expression2.compute();
	}
}
