package com.skilldistillery.homework.makechange;

import java.util.Scanner;

public class MakeChangeApp {
	static Scanner kb;

	public static void main(String[] args) {
		kb = new Scanner(System.in);
		// Asks the user for the price of the product and payment, then give them change
		System.out.print("What is the price of the product? $");
		double cost = kb.nextDouble();

		System.out.print("How much will you use to pay? $");
		double payment = kb.nextDouble();

		cashRegister(cost, payment);

		kb.close();

	}

	// If user gives exact change, end program. If user doesn't give enough change,
	// ask for more.
	public static void cashRegister(double cost, double payment) {
		if (cost > payment) {
			do {
				System.out.println("That amount is not enough, please insert more money. $");
				double additionalPayment = kb.nextDouble();
				payment += additionalPayment;
			} while (payment <= cost);
		} else if (cost == payment) {
			System.out.println("Thank for using the register, you paid the exact amount.");

		}
		if (payment > cost) {
			double remainder = payment - cost;
			System.out.println("Your change will be:");
			double billRemainder = billCalc(remainder);
			changeCalc(billRemainder);
		}
	}

	public static double billCalc(double billRemainder) {
		String changeBills[] = { " one dollar bills ", " five dollar bills, ", " ten dollar bills, ",
				" twenty dollar bills, " };
		int amount[] = { 1, 5, 10, 20, };
		int ones = 0, fives = 0, tens = 0, twenties = 0;
		String changeCoins[] = { " pennies", " nickels", " dimes", " quarters" };
		double changeAmount[] = { 0.01, 0.05, 0.10, 0.25 };
		double pennies = 0.0, nickels = 0.0, dimes = 0.0, quarters = 0.0;
		do {
			if (billRemainder >= amount[3]) {
				twenties = (int) (billRemainder / amount[3]);
				billRemainder = billRemainder - (amount[3] * twenties);
			}
			if (billRemainder >= amount[2]) {
				tens = (int) (billRemainder / amount[2]);
				billRemainder = billRemainder - (amount[2] * tens);
			}
			if (billRemainder >= amount[1]) {
				fives = (int) (billRemainder / amount[1]);
				billRemainder = billRemainder - (amount[1] * fives);
			}
			if (billRemainder >= amount[0]) {
				ones = (int) (billRemainder / amount[0]);
				billRemainder = billRemainder - (amount[0] * ones);
			}

		} while (billRemainder >= 1);
		String cashierSays = "";
		if (twenties > 0) {
			cashierSays += twenties + changeBills[3];
		}
		if (tens > 0) {
			cashierSays += tens + changeBills[2];
		}
		if (fives > 0) {
			cashierSays += fives + changeBills[1];
		}
		if (ones > 0) {
			cashierSays += ones + changeBills[0];
		}
		System.out.println(cashierSays);

		return billRemainder;

	}

	public static void changeCalc(double billRemainder) {
		double billR = Math.round(billRemainder * 100);
		billRemainder = billR / 100;
		String changeCoins[] = { " pennies ", " nickels, ", " dimes, ", " quarters, " };
		double changeAmount[] = { .01, .05, .10, .25 };
		int pennies = 0, nickels = 0, dimes = 0, quarters = 0;
		do {

			if (billRemainder >= changeAmount[3]) {
				quarters = (int) (billRemainder / changeAmount[3]);
				billRemainder = (billRemainder - (changeAmount[3] * quarters));
			}
			if (billRemainder >= changeAmount[2]) {
				dimes = (int) (billRemainder / changeAmount[2]);
				billRemainder = billRemainder - (changeAmount[2] * dimes);
			}
			if (billRemainder >= changeAmount[1]) {
				nickels = (int) (billRemainder / changeAmount[1]);
				billRemainder = billRemainder - (changeAmount[1] * nickels);
			}
			if (billRemainder >= changeAmount[0]) {
				pennies = (int) (billRemainder / changeAmount[0]);
				billRemainder = billRemainder - (changeAmount[0] * pennies);
			}

		} while (billRemainder >= 0.01);
		String cashierSays = "";
		if (quarters > 0) {
			cashierSays += (int) quarters + changeCoins[3];
		}
		if (dimes > 0) {
			cashierSays += (int) dimes + changeCoins[2];
		}
		if (nickels > 0) {
			cashierSays += (int) nickels + changeCoins[1];
		}
		if (pennies > 0) {
			cashierSays += (int) pennies + changeCoins[0];
		}
		System.out.println(cashierSays);
	}

}
