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
		Scanner kb = new Scanner(System.in);
		player = new BlackjackPlayer();
		Boolean run = true;
		while (run) {
		dealer = new BlackjackDealer();
		startingHands();
		play(kb);
		run = playAgain(kb);
		}
		System.out.println("Get outta here!");
		kb.close();
	}

	public void startingHands() {
		System.out.println("The dealer drew two cards and flipped a " + dealer.hit(dealer.draw()));
		System.out.println("You were dealt a " + player.hit(dealer.draw()) + " and a " + player.hit(dealer.draw()));
		System.out.println();
	}

	public void play(Scanner kb) {
		int choice = 0;
		int playerScore = player.hand.getHandValue();
		int dealerScore = dealer.hand.getHandValue();

		boolean stopRun = false;
		while (stopRun == false) {
			boolean goodInt = false;
			while (goodInt == false) {
				System.out.println("You have a total of " + playerScore);
				System.out.println("The dealer is showing " + dealer.hand.getCardValue());
				System.out.println();
				System.out.println("Please make a selection.");
				System.out.println("1: Hit");
				System.out.println("2: Stay");
				try {
					choice = kb.nextInt();
					goodInt = true;
				} catch (Exception e) {
					System.err.println("Pick a valid option. >:(");
					kb.next();
				}
			}
			switch (choice) {
			case 1:

				System.out.println("You drew a " + player.hit(dealer.draw()));
				System.out.println(player.hand.getHandValue());
				playerScore = player.hand.getHandValue();
				stopRun = player.hand.isBust(playerScore);
				break;
			case 2:
				stopRun = player.stay();
				break;
			default:
				System.out.println("You're trying to cheat? The police are on their way.");
			}
		}

		pickWinner(playerScore, dealerScore);
		clearHands();
		
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
		System.out.print("The dealer flipped their card, it is a " + dealer.hit(dealer.draw()));
		dealerScore = dealer.hand.getHandValue();
		System.out.println(", they have " + dealerScore);
		while (dealerScore < 17) {
			System.out.print("The dealer drew a " + dealer.hit(dealer.draw()));
			dealerScore = dealer.hand.getHandValue();
			System.out.println(", they have " + dealerScore);
		}
		return dealerScore;

	}
	
	public void clearHands() {
		dealer.hand.clear();
		player.hand.clear();
	}
	
	public boolean playAgain(Scanner kb) {
		boolean valid = false;
		while (valid == false) {
		System.out.println("Play again?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		String choice = null;
		try {
			choice = kb.next().toLowerCase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("I have no idea what you did to get here.");
			kb.next();
		}
		switch(choice) {
		case "y":
		case "yes":
		case "1":
			return true;
		case "n":
		case "no":
		case "2":
			return false;
			default:
				System.out.println("Make a valid selection.");
		}
			
		
		}
		return false;
	}

}
