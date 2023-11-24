package main;

import java.util.ArrayList;

public class Player {
	String name;
    static ArrayList<Card> cards = new ArrayList();
    int score = 0;
    
    public Player(String name) {
    	this.name = name;
    	this.cards = cards;
    }

    public void getCard(Card card) {
        this.cards.add(card);
    }
    
    public void startTurn() {
    	
    }
}