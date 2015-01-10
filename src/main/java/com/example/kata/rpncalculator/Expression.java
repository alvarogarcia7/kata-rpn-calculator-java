package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class Expression {
	public static final Expression SUM = new Expression("SUM");
	private final int number;
	private final String operator;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Expression)) return false;

		Expression that = (Expression) o;

		if (number != that.number) return false;
		if (!operator.equals(that.operator)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = number;
		result = 31 * result + operator.hashCode();
		return result;
	}

	public Expression(int number) {
		this.number = number;
		this.operator = "NONE";

	}

	public Expression(String operator) {
		this.number = 0;
		this.operator = operator;
	}

	public static Expression constant(int number) {
		return new Expression(number);
	}


}