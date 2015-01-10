package com.example.kata.rpncalculator;

/**
 * Created by alvaro on 10/01/15.
 */
public class Expression {
	public static class Operator extends Expression {
		private final String stringRepresentation;
		public static final Operator SUM = new Operator("SUM");
		public static final Operator MINUS = new Operator("MINUS");
		public static final Operator TIMES = new Operator("TIMES");
		public static final Operator DIVISION = new Operator("DIVISION");

		public Operator(String stringRepresentation) {
			super(0);
			this.stringRepresentation = stringRepresentation;
		}

		public static Operator from(char operator) {
			if (operator == '+') {
				return Operator.SUM;
			} else if (operator == '-') {
				return Operator.MINUS;
			} else if (operator == '/') {
				return Operator.DIVISION;
			} else {
				return Operator.TIMES;
			}
		}

	}

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

	public static Expression constant(int number) {
		return new Expression(number);
	}




	public Integer compute() {
		return this.number;
	}

	@Override
	public String toString() {
		return "{" +
				number +
				(operator.equals("NONE")?"" : ", '" + operator + '\'') +
				'}';
	}
}
