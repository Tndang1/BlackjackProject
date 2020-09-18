package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.*;

public class BlackjackDealer extends BlackjackPlayer {
	private Deck deck;
	private BlackjackHand dealerHand;
	
	public BlackjackDealer() {
		deck = new Deck();
		deck.shuffle();
		dealerHand = new BlackjackHand();
	}
	
	public Card draw() {
		return deck.dealCard();
	}
	
	public void deckSize() {
		System.out.println(deck.checkDeckSize());
	}


}
