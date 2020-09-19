package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.*;

public class BlackjackDealer extends BlackjackPlayer {
	private Deck deck;
	
	public BlackjackDealer() {
		
	}
	
	public Card draw() {
		return deck.dealCard();
	}
	
	public void newDeck() {
		deck = new Deck();
		deck.shuffle();
	}

}
