package com.example.kata.rpncalculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringParserShould {

	private StringParser sut;

	@Test
	public void parse_two_numbers_and_an_operator() {

		assertThat(sut.parse("0 0 +"), is(new OperationTree(Expression.SUM, Expression.constant(0), Expression.constant(0))));
	}

}
