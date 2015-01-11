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
	public Integer compute() {
		return this.number;
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

}
