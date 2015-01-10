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

		final OperationTree operationTree = sut.parse("1 0 +");
		final OperationTree expected = new OperationTree(Expression.SUM, Expression.constant(1), Expression.constant(0));
		assertThat(operationTree, equalTo(expected));
	}

}