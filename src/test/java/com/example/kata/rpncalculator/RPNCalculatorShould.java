package com.example.kata.rpncalculator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RPNCalculatorShould {

	@Test
	public void add_two_numbers() {

		RPNCalculator sut = new RPNCalculator();

		assertThat(sut.calculate("0 0 +"), is(0));
	}

}
