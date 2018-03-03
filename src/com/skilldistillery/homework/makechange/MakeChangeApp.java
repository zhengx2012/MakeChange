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
		
		if (price == priceTendered) {
			System.out.println("Thank for using the register, you paid the exact amount.");
		}
		else if (price > priceTendered) {
			System.out.println("That amount is not enough, please insert more money. $");
			double additionalTendered = kb.nextDouble();
			priceTendered += additionalTendered;
			
		} else {
			double remainder = priceTendered - price;
			int billRemainder =  (int) remainder;
			billCalc(remainder);
			System.out.println();
			
			double changeRemainder = remainder; 
			changeRemainder %= changeRemainder;
			changeCalc(changeRemainder);
		}
		
		kb.close();

	}
	public static void billCalc(double bill) {
		String changeBills [] = {"20 dollar bills", "10 dollar bills", "5 dollar bills", "1 dollar bills"};
		for (int i = 0; i < changeBills.length; i++) {
			System.out.println(changeBills[i]);
//			if (changeBills[i]) {
//				
//			}
//			
		}
		
		
	}
	public static void changeCalc(double change) {
		String changeCoins [] = {"Quarters", "Dimes", "Nickels", "Pennys"};
		for (int i = 0; i < changeCoins.length; i++) {
			System.out.println(changeCoins[i]);
		}
		
	}
}
