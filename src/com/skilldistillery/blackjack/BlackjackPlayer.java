package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;

public class BlackjackPlayer {
	protected BlackjackHand hand;
	
	public BlackjackPlayer() {
		hand = new BlackjackHand();
		
	}
	public void hit(Card card) {
		hand.addCard(card);
	}
	
	public boolean stay() {
		return true;
	}
	
	
}
