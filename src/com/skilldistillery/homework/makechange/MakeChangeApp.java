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

		System.out.println("Your change will be:");

		cashRegister(cost, payment);

		kb.close();

	}

	// If user gives exact change, end program. If user doesn't give enough change,
	// ask for more.
	public static void cashRegister(double cost, double payment) {
		if (cost == payment) {
			System.out.println("Thank for using the register, you paid the exact amount.");
		} else if (cost > payment) {
			System.out.println("That amount is not enough, please insert more money. $");
			double additionalPayment = kb.nextDouble();
			payment += additionalPayment;

		} else {
			double remainder = payment - cost;
			double billRemainder = remainder;
			billCalc(billRemainder);
			System.out.println();

			// double changeRemainder = remainder;
			// changeRemainder = remainder - billRemainder;
			// changeCalc(changeRemainder);
		}
	}

	public static void billCalc(double billRemainder) {
		String changeBills[] = { " one dollar bills", " five dollar bills", " ten dollar bills",
				" twenty dollar bills" };
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
			if (billRemainder > changeAmount[3]) {
				quarters = (int)(billRemainder / changeAmount[3]);
//				quarters = quarters * 100;
				billRemainder = (billRemainder - (changeAmount[3] * quarters));
			}
			if (billRemainder > changeAmount[2]) {
				dimes = (int)(billRemainder / amount[2]);
				billRemainder = billRemainder - (amount[2] * dimes);
			}
			if (billRemainder > changeAmount[1]) {
				nickels = (int)(billRemainder / amount[1]);
				billRemainder = billRemainder - (amount[1] * nickels);
			}
			if (billRemainder > changeAmount[0]) {
				pennies = (int)(billRemainder / amount[0]);
				billRemainder = billRemainder - (amount[0] * pennies);
			}

		} while (billRemainder > 0);
		System.out.println("testing");
		System.out.println(twenties + changeBills[3] + ", " + tens + changeBills[2] + ", " + fives + changeBills[1]
				+ ", " + ones + changeBills[0]);
		System.out.println(quarters + changeCoins[3] + ", " + dimes + changeCoins[2] + ", " + nickels + changeCoins[1]
				+ ", " + pennies + changeCoins[0]);

	}

	// public static void changeCalc(double changeRemainder) {
	// String changeCoins[] = { "pennies", "nickels", "dimes", "quarters" };
	// double amount [] = { 0.01, 0.05, 0.10, 0.25};
	// double pennies = 0.0, nickels = 0.0, dimes = 0.0, quarters = 0.0;
	// do {
	// if (changeRemainder > amount[3]) {
	// quarters = changeRemainder / amount[3];
	// changeRemainder = changeRemainder - (amount[3] * quarters);
	// }
	// else if (changeRemainder > amount[2]) {
	// quarters = changeRemainder / amount[2];
	// changeRemainder = changeRemainder - (amount[2] * quarters);
	// }
	// else if (changeRemainder > amount[1]) {
	// quarters = changeRemainder / amount[1];
	// changeRemainder = changeRemainder - (amount[1] * quarters);
	// }
	// else if (changeRemainder > amount[0]) {
	// quarters = changeRemainder / amount[0];
	// changeRemainder = changeRemainder - (amount[0] * quarters);
	// }
	//
	// } while (changeRemainder >= 0.01);
	// System.out.println(quarters + changeCoins[3] + ", " + dimes + changeCoins[2]
	// + ", " + nickels + changeCoins[1]
	// + ", " + pennies + changeCoins[0]);
	// }

}
