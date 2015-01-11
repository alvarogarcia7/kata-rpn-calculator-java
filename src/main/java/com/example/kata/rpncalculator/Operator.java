package com.example.kata.rpncalculator;

/**
* Created by alvaro on 10/01/15.
*/
public enum Operator {
	PLUS('+'),
	MINUS('-'),
	OBELUS('/'),
	TIMES('*');

	private final char representation;


	Operator(char representation) {
		this.representation = representation;
	}

	public static Operator from(char operator) {
		for (Operator current : values()) {
			if(operator == current.representation){
				return current;
			}
		}
		return TIMES;
	}

	public static boolean isOne(String token) {
		for (Operator current : values()) {
			if(token.charAt(0) == current.representation){
				return true;
			}
		}
		return false;
	}
}
