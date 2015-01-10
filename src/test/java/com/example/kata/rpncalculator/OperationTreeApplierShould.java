package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static com.example.kata.rpncalculator.Operator.*;
import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OperationTreeApplierShould {

	private OperationTreeApplier sut;

	@Before
	public void setUp() {
		sut = new OperationTreeApplier();
	}

	@Test
	public void multiply_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(TIMES).withOperands(1, 2).build()), is(2));
	}

	@Test
	public void sum_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(SUM).withOperands(1, 0).build()), is(1));
	}

	@Test
	public void sum_another_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(SUM).withOperands(0, 1).build()), is(1));
	}

	@Test
	public void subtract_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(MINUS).withOperands(1, 2).build()), is(-1));
	}

	@Test
	public void divide_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(DIVISION).withOperands(2, 2).build()), is(1));
	}


	@Test
	public void apply_to_two_expressions() {

		OperationTree TREE_WITH_TWO_EXPRESSIONS = aNew().
				withOperator(SUM).
				withExpression(2).
				and(
						aNew().
								withOperator(MINUS).
								withOperands(1,3).
								build())
				.build();
		assertThat(sut.applyOn(TREE_WITH_TWO_EXPRESSIONS), is(0));
	}

	@Test
	public void apply_to_two_expressions_sum() {

		OperationTree TREE_WITH_TWO_EXPRESSIONS = aNew().
				withOperator(SUM).
				withExpression(2).
				and(
						aNew().
								withOperator(SUM).
								withOperands(1,3).
								build())
				.build();
		assertThat(sut.applyOn(TREE_WITH_TWO_EXPRESSIONS), is(6));
	}



}
