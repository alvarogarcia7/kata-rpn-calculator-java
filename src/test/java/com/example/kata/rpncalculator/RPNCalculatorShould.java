package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RPNCalculatorShould {

	private RPNCalculator sut;
	private StringParser parserMock;

	@Before
	public void setUp() {
		parserMock = mock(StringParser.class);
		sut = new RPNCalculator(parserMock);
	}

	@Test
	public void add_two_numbers() {
		assertThat(sut.calculate("0 0 +"), is(0));
	}

	@Test
	public void call_the_string_parser() {
		sut.calculate("");

		verify(parserMock).parse("");
	}

}
