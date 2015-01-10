package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class Expression {

	private final int number;

	public Expression(int number) {
		this.number = number;
	}

	public static Expression constant(int number) {
		return new Expression(number);
	}

	public Integer compute() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Expression)) return false;

		Expression that = (Expression) o;

		if (number != that.number) return false;

		return true;
	}

	@Override
	public String toString() {
		return "{" +
				number +
				'}';
	}

	@Override
	public int hashCode() {
		return number;
	}
}
