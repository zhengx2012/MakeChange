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
		String changeBills[] = { " twenty dollar bills", " ten dollar bills", " five dollar bills", " one dollar bills" };
		int amount[] = { 20, 10, 5, 1 };
		int extraBills = 0;
		for (int i = 0; i < amount.length; i++) {
			do {
				if (billRemainder > amount[0]) {
					extraBills %= billRemainder / amount[0];
					billRemainder = billRemainder /amount[0];
					System.out.println(billRemainder + changeBills[0]);
				} 
				if(billRemainder > amount[1]) {
					billRemainder = billRemainder / amount [1];
					System.out.println(billRemainder + changeBills[1]);
				}
				if(billRemainder > amount[2]) {
					billRemainder = billRemainder / amount [2];
					System.out.println(billRemainder + changeBills[2]);
				}
				if(billRemainder > amount[3]) {
					billRemainder = billRemainder / amount [3];
					System.out.println(billRemainder + changeBills[3]);
				}

			} while (billRemainder > 0);
		}

	}

	public static void changeCalc(double changeRemainder) {
		String changeCoins[] = { "quarters", "dimes", "nickels", "pennies" };
		for (int i = 0; i < changeCoins.length; i++) {
			do {
				if (changeRemainder > .25) {
					changeRemainder = changeRemainder / .25;
					System.out.println(changeRemainder + changeCoins[0]);
				}
				
			}while(changeRemainder >= 0.01);
		}

	}
}
