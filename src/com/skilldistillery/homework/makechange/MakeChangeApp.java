package com.skilldistillery.homework.makechange;

import java.util.Scanner;

public class MakeChangeApp {
	static Scanner kb;

	public static void main(String[] args) {
		kb = new Scanner(System.in);
		
		System.out.print("What is the price of the product? $");
		double price = kb.nextDouble();
		
		System.out.print("\nHow much will you use to pay? $");
		double priceTendered = kb.nextDouble();

		kb.close();

	}
}
