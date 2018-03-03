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
			System.out.println(remainder);
		}
		
		kb.close();

	}
//	public void priceCalculator(double remainder) {
//		double remainder = priceTendered - price;
//	}
}
