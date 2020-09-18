package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;

public class BlackjackPlayer {
	protected BlackjackHand hand;
	
	public BlackjackPlayer() {
		hand = new BlackjackHand();
		
	}
	public String hit(Card card) {
		hand.addCard(card);
		return card.toString();
	}
	
	public boolean stay() {
		return true;
	}
	
	
}
