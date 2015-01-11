package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static com.example.kata.rpncalculator.Operator.*;
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
	public void parse_two_long_numbers_and_the_sum() {
		assertThat(sut.parse("11 3 +"), equalTo(aNew().withOperands(11,3).withOperator(SUM).build()));
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
						withOperands(
								aNew().withOperator(MINUS).withOperands(1, 3),
								aNew().withExpression(2))
						.build()));
	}

	@Test
	public void parse_two_expressions_2() {

		assertThat(sut.parse("2 1 3 - +"), equalTo(
				aNew().
						withOperator(SUM).
						withOperands(
								aNew().withExpression(2),
								aNew().withOperator(MINUS).withOperands(1, 3))
						.build()));
	}

	@Test
	public void parse_three_operators_and_two_expressions() {

		assertThat(sut.parse("1 2 + 3 4 * -"), equalTo(
				aNew().
						withOperator(MINUS).
						withOperands(
								aNew().withOperator(SUM).withOperands(1,2),
								aNew().withOperator(TIMES).withOperands(3,4)
						).build()
		));
	}
}
