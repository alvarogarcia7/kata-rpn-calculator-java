package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.example.kata.rpncalculator.Expression.*;

public class StringParserShould {

	private static final OperationTreeBuilder TREE_1_3 = aNew().withOperands(1, 3);
	private StringParser sut;

	@Before
	public void setUp() {
		sut = new StringParser();
	}



	@Test
	public void parse_two_numbers_and_the_division() {
		assertThat(sut.parse("1 3 /"), equalTo(TREE_1_3.withOperator(DIVISION).build()));
	}

	@Test
	public void parse_two_numbers_and_the_multiplication() {
		assertThat(sut.parse("1 3 *"), equalTo(TREE_1_3.withOperator(TIMES).build()));
	}
}
