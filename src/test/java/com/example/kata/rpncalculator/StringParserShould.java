package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.example.kata.rpncalculator.Expression.*;

public class StringParserShould {

	private StringParser sut;

	@Before
	public void setUp() {
		sut = new StringParser();
	}

	@Test
	public void parse_two_numbers_and_an_operator() {
		assertThat(sut.parse("1 3 -"), equalTo(aNew().withOperator(MINUS).withOperands(1, 3).build()));
	}

}
