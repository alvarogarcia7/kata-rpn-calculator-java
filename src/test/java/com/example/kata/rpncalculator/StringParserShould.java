package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringParserShould {

	private StringParser sut;

	@Before
	public void setUp() {
		sut = new StringParser();
	}

	@Test
	public void parse_two_numbers_and_an_operator() {
		assertThat(sut.parse("1 3 -"), equalTo(new OperationTree(Expression.MINUS, Expression.constant(1), Expression.constant(3))));
	}

}
