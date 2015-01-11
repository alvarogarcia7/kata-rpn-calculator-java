package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class Constant implements Computable{

	private final int number;

	private Constant(int number) {
		this.number = number;
	}

	public static Constant from(int number) {
		return new Constant(number);
	}

	@Override
	public Constant compute() {
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Constant)) return false;

		Constant that = (Constant) o;

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

	public int value() {
		return number;
	}

	public Constant applyOperator(Operator operator, Constant other) {
		int computedValue;
		int otherNumber = other.value();
		if (operator == Operator.TIMES) {
			computedValue = number * otherNumber;
		} else if (operator == Operator.MINUS) {
			computedValue = number - otherNumber;
		} else if (operator == Operator.OBELUS) {
			computedValue =  number / otherNumber;
		} else {
			computedValue = number + otherNumber;
		}
		return Constant.from(computedValue);
	}
}
