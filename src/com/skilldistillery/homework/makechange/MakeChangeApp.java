package com.skilldistillery.homework.makechange;

import java.util.Scanner;

public class MakeChangeApp {
	static Scanner kb;

	public static void main(String[] args) {
		kb = new Scanner(System.in);

		System.out.print("What is the price of the product? $");
		double price = kb.nextDouble();

		System.out.print("How much will you use to pay? $");
		double priceTendered = kb.nextDouble();

		System.out.println("Your change will be:");

		cashRegister(price, priceTendered);

		kb.close();

	}

	public static void cashRegister(double price, double priceTendered) {
		if (price == priceTendered) {
			System.out.println("Thank for using the register, you paid the exact amount.");
		} else if (price > priceTendered) {
			System.out.println("That amount is not enough, please insert more money. $");
			double additionalTendered = kb.nextDouble();
			priceTendered += additionalTendered;

		} else {
			double remainder = priceTendered - price;
			int billRemainder = (int) remainder;
			billCalc(billRemainder);
			System.out.println();

			double changeRemainder = remainder;
			changeRemainder %= changeRemainder;
			changeCalc(changeRemainder);
		}
	}

	/**
	 * 
	 * @param bill
	 */
	public static void billCalc(int billRemainder) {
		String changeBills[] = { " one dollar bills", " five dollar bills", " ten dollar bills",
				" twenty dollar bills" };
		int amount[] = { 1, 5, 10, 20 };
		int twenties = 0, tens = 0, fives = 0, ones = 0;
		do {
			if (billRemainder >= amount[3]) {
				// extraBills %= billRemainder / amount[3];
				twenties = billRemainder / amount[3];
				billRemainder = billRemainder - (amount[3] * twenties);
			}
			if (billRemainder >= amount[2]) {
				tens = billRemainder / amount[2];
				billRemainder = billRemainder - (amount[2] * tens);
			}
			if (billRemainder >= amount[1]) {
				fives = billRemainder / amount[1];
				billRemainder = billRemainder - (amount[1] * fives);
			}
			if (billRemainder >= amount[0]) {
				ones = billRemainder / amount[0];
				
				billRemainder = billRemainder - (amount[0] * ones);
			}

		} while (billRemainder > 0);
		System.out.println("testing");
		System.out.println(twenties + changeBills[3] + ", " + tens + changeBills[2] + ", " + fives + changeBills[1]
				+ ", " + ones + changeBills[0]);

	}

	public static void changeCalc(double changeRemainder) {
		String changeCoins[] = { "quarters", "dimes", "nickels", "pennies" };
		for (int i = 0; i < changeCoins.length; i++) {
			do {
				if (changeRemainder > .25) {
					changeRemainder = changeRemainder / .25;
					System.out.println(changeRemainder + changeCoins[0]);
				}

			} while (changeRemainder >= 0.01);
		}

	}
}
