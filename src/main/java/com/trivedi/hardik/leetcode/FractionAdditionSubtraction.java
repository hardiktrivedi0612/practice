/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class FractionAdditionSubtraction {
	public String fractionAddition(String expression) {
		if (expression == null || expression.equalsIgnoreCase("")) {
			return expression;
		}
		expression = reformatFractionInput(expression);
		String[] fractions = expression.split("\\+");
		if (fractions.length == 1) {
			return expression;
		}
		String resultFraction = addFraction(fractions[0], fractions[1]);
		for (int i = 2; i < fractions.length; i++) {
			resultFraction = addFraction(resultFraction, fractions[i]);
		}
		return resultFraction;
	}

	private String reformatFractionInput(String expression) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (i != 0 && expression.charAt(i) == '-') {
				sb.append("+-");
			} else {
				sb.append(expression.charAt(i));
			}
		}
		return sb.toString();
	}

	public String addFraction(String fraction1, String fraction2) {
		String[] fraction1Split = fraction1.split("/");
		String[] fraction2Split = fraction2.split("/");

		int num1 = Integer.parseInt(fraction1Split[0]);
		int den1 = Integer.parseInt(fraction1Split[1]);

		int num2 = Integer.parseInt(fraction2Split[0]);
		int den2 = Integer.parseInt(fraction2Split[1]);

		int den3 = (den1 * den2) / calculateGCD(den1, den2);

		int num3 = num1 * (den3 / den1) + num2 * (den3 / den2);

		int fractionGCD = calculateGCD(num3, den3);

		num3 = (num3 / fractionGCD);
		den3 = (den3 / fractionGCD);

		if (num3 < 0 && den3 < 0) {
			num3 = Math.abs(num3);
			den3 = Math.abs(den3);
		} else if (den3 < 0) {
			num3 *= -1;
			den3 = Math.abs(den3);
		}
		return num3 + "/" + den3;
	}

	int calculateGCD(int num1, int num2) {
		if (num1 == 0) {
			return num2;
		}
		return calculateGCD(num2 % num1, num1);
	}
}
