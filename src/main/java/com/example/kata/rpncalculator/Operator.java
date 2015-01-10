package com.example.kata.rpncalculator;

/**
* Created by alvaro on 10/01/15.
*/
public class Operator {
	private final String stringRepresentation;
	public static final com.example.kata.rpncalculator.Operator SUM = new com.example.kata.rpncalculator.Operator("SUM");
	public static final com.example.kata.rpncalculator.Operator MINUS = new com.example.kata.rpncalculator.Operator("MINUS");
	public static final com.example.kata.rpncalculator.Operator TIMES = new com.example.kata.rpncalculator.Operator("TIMES");
	public static final com.example.kata.rpncalculator.Operator DIVISION = new com.example.kata.rpncalculator.Operator("DIVISION");

	private Operator(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	public static com.example.kata.rpncalculator.Operator from(char operator) {
		if (operator == '+') {
			return com.example.kata.rpncalculator.Operator.SUM;
		} else if (operator == '-') {
			return com.example.kata.rpncalculator.Operator.MINUS;
		} else if (operator == '/') {
			return com.example.kata.rpncalculator.Operator.DIVISION;
		} else {
			return com.example.kata.rpncalculator.Operator.TIMES;
		}
	}

}
