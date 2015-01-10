package com.example.kata.rpncalculator;

/**
* Created by alvaro on 10/01/15.
*/
public enum  Operator {
	SUM('+'),
	MINUS('-'),
	DIVISION('/'),
	TIMES('*');

	private final char representation;


	Operator(char representation) {
		this.representation = representation;
	}

	public static com.example.kata.rpncalculator.Operator from(char operator) {
		if (operator == SUM.representation) {
			return com.example.kata.rpncalculator.Operator.SUM;
		} else if (operator == MINUS.representation) {
			return com.example.kata.rpncalculator.Operator.MINUS;
		} else if (operator == DIVISION.representation) {
			return com.example.kata.rpncalculator.Operator.DIVISION;
		} else {
			return com.example.kata.rpncalculator.Operator.TIMES;
		}
	}

}
