package com.example.kata.rpncalculator.acceptance;

import com.example.kata.rpncalculator.OperationTreeApplier;
import com.example.kata.rpncalculator.RPNCalculator;
import com.example.kata.rpncalculator.StringParser;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alvaro on 10/01/15.
 */
public class RPNCalculatorAcceptanceTestShould {

	private RPNCalculator getRPNCalculator() {
		return new RPNCalculator(new StringParser(), new OperationTreeApplier());
	}

	@Test
	public void add_two_numbers() {
		assertThat(getRPNCalculator().calculate("2 5 +"), is(7));
	}

	@Test
	@Ignore
	public void calculate_a_multiple_operations() {

		assertThat(getRPNCalculator().calculate("12 3 + 2 * 1 / 3 - 9 /  33 *"), is(99));
	}
}
