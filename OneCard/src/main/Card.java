package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Card{
	String suit;
	String rank;
	static ArrayList<String> card_list = new ArrayList<String>();
	
	Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public static void createCardSet() {
		System.out.println("create card start");
		
		ArrayList<String> suit = new ArrayList<String>(Arrays.asList("S","C","D","H"));
		ArrayList<String> rank = new ArrayList<String>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
		ArrayList<String> jocker = new ArrayList<String>(Arrays.asList("ColorJoker","BlackJoker"));
	
		for(String s : suit) {
			for(String r : rank) {
				Card.card_list.add(s+r);
			}
		}
		for(String j : jocker) {
			Card.card_list.add(j);
		}
		
		System.out.println(card_list);
		System.out.println("create card done");
	}
	
	static void giveCardToPlayer(Player player) {
		
	}
}