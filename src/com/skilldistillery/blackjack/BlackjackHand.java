package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;

public class BlackjackHand extends Hand {
	
	private int handValue = 0;
	
	public BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
			if(handValue > 21) {
				for(Card cardB: hand) {
					if(cardB.getValue() == 11) {
						cardB.setValue(1);
						handValue -= 10;
					}
				}
			}
		}
		return handValue;
	}
	
	public int getCardValue() {
		return hand.get(0).getValue();
	}
	
	public boolean isBust(int total) {
		if (total <= 21) {
			return false;
		} else {
			return true;
		}
		
	}


}
