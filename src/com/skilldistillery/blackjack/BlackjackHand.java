package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;

public class BlackjackHand extends Hand {
	
	int handValue = 0;
	
	public BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		handValue = 0;
		for (Card card : hand) {
			handValue = handValue + card.getValue();
		}
		return handValue;
	}
	
	public int getCardValue() {
		return hand.get(0).getValue();
	}
	
	public boolean isBust(int total) {
		if (total < 21) {
			return false;
		} else {
			return true;
		}
		
	}


}
