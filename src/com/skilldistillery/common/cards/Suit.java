package com.skilldistillery.common.cards;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	
	Suit(String string) {
		name = string;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
	

	
}
