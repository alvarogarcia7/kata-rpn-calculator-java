package com.example.kata.rpncalculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RPNCalculatorShould {

	public static final String UNUSED_OPERATION_CHAIN = "";
	private RPNCalculator sut;
	private StringParser parserMock;
	private OperationTreeApplier applierMock;

	@Before
	public void setUp() {
		parserMock = mock(StringParser.class);
		applierMock = mock(OperationTreeApplier.class);
		sut = new RPNCalculator(parserMock, applierMock);
	}

	@Test
	public void add_two_numbers() {
		assertThat(sut.calculate("0 0 +"), is(0));
	}

	@Test
	public void call_the_string_parser() {
		sut.calculate(UNUSED_OPERATION_CHAIN);

		verify(parserMock).parse(UNUSED_OPERATION_CHAIN);
	}

	@Test
	public void call_the_operation_applier() {
		final OperationTree operationTree = new OperationTree();
		doReturn(operationTree).when(parserMock).parse(anyString());

		sut.calculate(UNUSED_OPERATION_CHAIN);

		verify(applierMock).applyOn(operationTree);
	}

}
