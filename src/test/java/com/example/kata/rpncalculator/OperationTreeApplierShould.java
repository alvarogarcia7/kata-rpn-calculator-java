package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static com.example.kata.rpncalculator.Operator.*;
import static com.example.kata.rpncalculator.tools.OperationTreeBuilderRepository.TREE_WITH_THREE_EXPRESSIONS;
import static com.example.kata.rpncalculator.tools.OperationTreeBuilderRepository.*;
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
		assertThat(sut.applyOn(aNew().withOperator(PLUS).withOperands(1, 0).build()), is(1));
	}

	@Test
	public void sum_another_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(PLUS).withOperands(0, 1).build()), is(1));
	}

	@Test
	public void subtract_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(MINUS).withOperands(1, 2).build()), is(-1));
	}

	@Test
	public void divide_two_numbers() {
		assertThat(sut.applyOn(aNew().withOperator(OBELUS).withOperands(2, 2).build()), is(1));
	}


	@Test
	public void apply_to_two_expressions() {
		assertThat(sut.applyOn(TREE_SUM_2_MINUS_1_3), is(0));
	}

	@Test
	public void apply_to_two_expressions_sum() {
		assertThat(sut.applyOn(TREE_WITH_TWO_EXPRESSIONS), is(6));
	}

	@Test
	public void apply_three_expressions() {
		assertThat(sut.applyOn(TREE_WITH_THREE_EXPRESSIONS), is(-9));
	}



}
