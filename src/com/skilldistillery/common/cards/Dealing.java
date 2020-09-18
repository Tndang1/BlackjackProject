package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Scanner kb = new Scanner(System.in);
		deck.shuffle();
		int cardValueTotal = 0;
		int amount = 0;

		boolean badInt = true;

		System.out.println("How many cards would you like?");
		try {
			amount = kb.nextInt();
			if (amount <= 52) {
				for (int i = 0; i < amount; i++) {
					Card dealt = deck.dealCard();
					System.out.println(dealt.toString());
					cardValueTotal += dealt.getValue();
				}
			} else {
				System.out.println("There are only 52 cards in a deck.");
			}

		} catch (Exception e) {
			System.err.println("That was not a proper amount. Naughty naughty.");

		}

		System.out.println(cardValueTotal);

		kb.close();
	}

}
