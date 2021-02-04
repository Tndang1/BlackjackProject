package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.common.cards.Card;

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
		dealer = new BlackjackDealer();
		Boolean run = true;
		while (run) {
			clearCards();
			play(kb);
			run = playAgain(kb);
		}
		System.out.println("Get outta here!");
		kb.close();
	}

	public void play(Scanner kb) {

		Card dealerFaceCard = dealer.draw();
		dealer.hit(dealerFaceCard);
		System.out.println("The dealer drew two cards and flipped a " + dealerFaceCard.toString());
		Card dealerFlipCard = dealer.draw();
		System.out.println("You were dealt a " + player.hit(dealer.draw()) + " and a " + player.hit(dealer.draw()));
		System.out.println();

		int playerScore = player.hand.getHandValue();
		int dealerScore = dealer.hand.getHandValue();

		int finalPlayerScore = playerTurn(kb, playerScore, dealerFaceCard);

		pickWinner(finalPlayerScore, dealerScore, dealerFlipCard);

	}

	public int playerTurn(Scanner kb, int playerScore, Card dealerFaceCard) {
		String choice = null;
		boolean stopRun = false;
		while (stopRun == false) {
			if (playerScore == 21) {
				stopRun = true;
			}
			boolean goodInt = false;
			while (goodInt == false) {
				System.out.println("You have a total of " + playerScore);
				System.out.println("The dealer is showing " + dealerFaceCard.getValue());
				System.out.println();
				System.out.println("Please make a selection.");
				System.out.println("1: Hit");
				System.out.println("2: Stay");
				try {
					choice = kb.next();
					goodInt = true;
				} catch (Exception e) {
					System.err.println("Please pick a valid option.");
					kb.next();
				}
			}
			switch (choice) {
			case "1":
			case "hit":
				System.out.println("You drew a " + player.hit(dealer.draw()));
				playerScore = player.hand.getHandValue();
				if (playerScore == 21) {
					System.out.println("That's 21!");
					stopRun = true;
					break;
				}
				if (player.hand.isBust(playerScore)) {
					System.out.println(player.hand.getHandValue());
					stopRun = true;
				}
				break;
			case "2":
			case "stay":
				stopRun = player.stay();
				break;
			default:
				System.out.println("You're trying to cheat? The police are on their way.");
			}
		}
		return playerScore;
	}

	public int dealerTurn(int dealerScore, Card dealerFlipCard) {
		System.out.print("The dealer flipped their card, it is a " + dealerFlipCard.toString());
		dealer.hit(dealerFlipCard);
		dealerScore = dealer.hand.getHandValue();
		System.out.println(", they have " + dealerScore);
		while (dealerScore < 17) {
			System.out.print("The dealer drew a " + dealer.hit(dealer.draw()));
			dealerScore = dealer.hand.getHandValue();
			System.out.println(", they have " + dealerScore);
		}
		return dealerScore;
	}

	public void pickWinner(int playerScore, int dealerScore, Card dealerFlipCard) {
		if (!player.hand.isBust(playerScore)) {
			dealerScore = dealerTurn(dealerScore, dealerFlipCard);
			if (!dealer.hand.isBust(dealerScore)) {
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

	public void clearCards() {
		dealer.hand.clear();
		player.hand.clear();
		dealer.newDeck();
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
				System.out.println("Please pick a valid option.");
				kb.next();
			}
			switch (choice) {
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
