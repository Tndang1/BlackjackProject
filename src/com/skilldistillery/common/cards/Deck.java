package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>(52);
		Suit[] suits = Suit.values();
		for (Suit suit : suits) {
			Rank[] ranks = Rank.values();
			for (Rank rank : ranks) {
				if (rank.getValue() == 1) {
					continue;
				}
				Card toAdd = new Card(suit, rank);
				deck.add(toAdd);
			}
		}
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
