package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Card{
	String suit;
	String rank;
	String name;
	static ArrayList<String> card_list = new ArrayList<String>();
	
	Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
		this.name = suit+rank;
	}
}