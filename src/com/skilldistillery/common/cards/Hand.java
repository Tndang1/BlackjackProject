package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand = new ArrayList<Card>();
	}
	
	public abstract int getHandValue();
	
	public abstract int getCardValue();
	
}
