### Blackjack Project

## Overview

# This was created for week 4 of the Skill Distillery program. The requirement was to create a blackjack game using object oriented class structure. This project only required the basic rules of blackjack, with the player trying to get as close as possible to 21 without going over, and the dealer following the house rules (hit on 16, stay on 17). It does not take into account hard and soft aces.

## Topics

## Lessons Learned

# Creating a UML and plan of what each class should know about and how it needs to behave is clearly going to become critical as the programs continue to grow in size.
# Creating a blackjack table class would have been a better solution, the app class is crowded.
# It is important to not long stuck on one issue. In time I spent trying to get a working hard and soft ace I could have implemented several other features.

## How to Run

# On launch the starting cards are dealt.
# User is prompted to enter a 1 to "Hit" and be dealt another card, or 2 to "Stay". Note that the value of an ace is a hard 11.
# If the user score goes above 21 the game will end in a dealer win.
# When the user has selected to stay the dealer will take their turn.
# The dealer will continue to draw until their score is above 16. If the dealer goes above 21 the player will win.
# If neither the dealer nor the player scores go above 21, the higher score wins the game.
# At the end of each round the user is prompted to enter "Yes" to play again or "No" to exit.
