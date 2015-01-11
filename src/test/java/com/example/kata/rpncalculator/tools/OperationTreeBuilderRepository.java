package com.example.kata.rpncalculator.tools;

import com.example.kata.rpncalculator.OperationTree;

import static com.example.kata.rpncalculator.OperationTreeBuilder.aNew;
import static com.example.kata.rpncalculator.Operator.MINUS;
import static com.example.kata.rpncalculator.Operator.SUM;
import static com.example.kata.rpncalculator.Operator.TIMES;

/**
 * Created by alvaro on 11/01/15.
 */
public class OperationTreeBuilderRepository {

	public static OperationTree TREE_WITH_THREE_EXPRESSIONS =
			aNew().
					withOperator(MINUS).
					withOperands(
							aNew().withOperator(SUM).withOperands(1,2),
							aNew().withOperator(TIMES).withOperands(3,4)
					).build();

	public static OperationTree TREE_WITH_TWO_EXPRESSIONS = aNew().
			withOperator(SUM).
			withOperands(
					aNew().withExpression(2),
					aNew().
							withOperator(SUM).
							withOperands(1, 3))
			.build();

	public static OperationTree TREE_SUM_MINUS_1_3_2 = aNew().
			withOperator(SUM).
			withOperands(
					aNew().
							withOperator(MINUS).
							withOperands(1, 3),
					aNew().withExpression(2))
			.build();

	public static OperationTree TREE_SUM_2_MINUS_1_3 = aNew().
			withOperator(SUM).
			withOperands(
					aNew().withExpression(2),
					aNew().
							withOperator(MINUS).
							withOperands(1, 3))
			.build();
}
