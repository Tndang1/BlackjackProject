package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private BlackjackDealer dealer;
	private BlackjackPlayer player;

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.launch();
	}

	public void launch() {
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();
		startingHands();
		play();
	}

	public void startingHands() {
		dealer.hit(dealer.draw());
		dealer.hit(dealer.draw());
		player.hit(dealer.draw());
		player.hit(dealer.draw());

	}

	public void play() {
		Scanner kb = new Scanner(System.in);
		int choice = 0;
		int playerScore = player.hand.getHandValue();
		int dealerScore = dealer.hand.getHandValue();
		
		boolean stopRun = false;
		 do {
			System.out.println("The dealer is showing " + dealer.hand.getCardValue());
			System.out.println("You have a total value of " + playerScore);
			System.out.println("Please make a selection.");
			System.out.println("1: Hit");
			System.out.println("2: Stay");
			try {
				choice = kb.nextInt();
			} catch (Exception e) {
				System.err.println("Pick a valid option. >:(");
			}
			switch (choice) {
			case 1:
				player.hit(dealer.draw());
				dealer.deckSize();
				System.out.println(player.hand.getHandValue());
				playerScore = player.hand.getHandValue();
				System.out.println("You have a total value of " + playerScore);
				stopRun = player.hand.isBust(playerScore);
				break;
			case 2:
				stopRun = player.stay();
				break;
			default:
				System.out.println("You're trying to cheat? Police are on their way.");
				stopRun = true;
			}
		} while (stopRun = false);
		 
		pickWinner(playerScore, dealerScore);
		
		kb.close();
	}
	
	public void pickWinner(int playerScore, int dealerScore) {
		if (player.hand.isBust(playerScore) == false) {
			dealerScore = dealerTurn(dealerScore);
			
			if (dealer.hand.isBust(dealerScore) == false) {
			evaluateScores(playerScore, dealerScore);
			} else {
				System.out.println("Dealer busted, you win!");
			}
		} else {
			System.out.println("You busted, dealer wins. Give up the money now please.");
		}
	}
	
	public void evaluateScores(int playerTotal, int dealerTotal) {
		if (playerTotal == dealerTotal) {
			System.out.println("It's a tie!");
		} else {
		String result = playerTotal > dealerTotal ? "You won!" : "You lost!";
		System.out.println(result);
		}
		
	}
	
	public int dealerTurn(int dealerScore) {
		System.out.println("The dealer flipped their card and has " + dealerScore);
		while (dealerScore < 17) {
			dealer.hit(dealer.draw());
			dealerScore = dealer.hand.getHandValue();
			System.out.println("The dealer drew and now has a " + dealerScore);
//			dealer.hand.isBust(dealerScore);
		}
		return dealerScore;
		
	}
	
	

}
