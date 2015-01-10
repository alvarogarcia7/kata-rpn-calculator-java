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
		for (Operator current : values()) {
			if(operator == current.representation){
				return current;
			}
		}
		return TIMES;
	}

}
