package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static com.example.kata.rpncalculator.Expression.*;
import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

	@Test
	public void parse_two_numbers_and_the_sum() {
		assertThat(sut.parse("1 3 +"), equalTo(TREE_1_3.withOperator(SUM).build()));
	}

	@Test
	public void parse_two_numbers_and_the_minus() {
		assertThat(sut.parse("1 3 -"), equalTo(TREE_1_3.withOperator(MINUS).build()));
	}

	@Test
	public void parse_two_expressions() {

		assertThat(sut.parse("1 3 - 2 +"), equalTo(
				aNew().
						withOperator(SUM).
						withExpression(2).
						and(
								aNew().
										withOperator(MINUS).
										withOperands(1,3).
										build())
						.build()));
	}
}
