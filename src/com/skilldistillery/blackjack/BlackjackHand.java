package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;
import com.skilldistillery.common.cards.Rank;

public class BlackjackHand extends Hand {
	
	private int handValue = 0;
	
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
	
	public boolean hasSoftAce() {
		for (Card card : hand) {
			if(card.getValue() == 11) {
				toSoftAce();
				return false;
			}
		}
		return true;
	}
	
	private void toSoftAce() {
		for (Card card : hand) {
			if(card.getValue() == 11) {
				Card softCard = new Card(card.getSuit(), Rank.SOFT_ACE);
				hand.add(softCard);
				hand.remove(card);
				break;
		}}
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
