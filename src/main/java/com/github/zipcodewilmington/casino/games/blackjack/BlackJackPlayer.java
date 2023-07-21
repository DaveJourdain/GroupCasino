package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;

public class BlackJackPlayer extends GamblingPlayer {

    Deck playerHand = new Deck();

    Card currentCard;
    ArrayList<Card> playerHandValue = new ArrayList<>();

    public BlackJackPlayer(CasinoAccount acct) {
        super(acct);
        this.playerHand.emptyDeck();
    }

    public ArrayList<Card> addPlayerHand(ArrayList<Card> cards){
         playerHand.addCards(cards);
        return cards;
    }

    public Card getTopCard(){

        return currentCard = playerHand.removeTopCard();
    }

    public Integer handTotal(){
        int total = 0;
        for (Card c: playerHand.getCards()){
            if (c.getValue() > 10) {
                total += 10;
            } else {
                total += c.getValue();
            }
        }
        return total;
    }
}
