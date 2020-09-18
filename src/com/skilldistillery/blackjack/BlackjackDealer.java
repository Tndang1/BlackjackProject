package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.*;

public class BlackjackDealer extends BlackjackPlayer {
	private Deck deck;
	
	public BlackjackDealer() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public Card draw() {
		return deck.dealCard();
	}

}
