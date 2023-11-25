package main;

import java.util.ArrayList;

public class Player {
	private String name;
	private int score;
	private ArrayList<Card> player_cards;

	public Player(String name) {
		player_cards = new ArrayList<Card>();
//		System.out.println(player_cards);
		
//		player_cards.add(new Card("1","1"));
//		System.out.println(player_cards);

		this.name = name;
		this.score = 0;
	}

	public void startTurn() {

	}

	public void useCard(Card card) {
		player_cards.remove(card);
		Game.used_cards.add(card);
	}

	public void drawCard() {

	}

	public void finishTurn() {

	}

	public void recieveCard(Card card) {
		player_cards.add(card);
//		System.out.println(player_cards);
//		System.out.println(player_cards.size());
//		System.out.println('!');
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Card> getPlayer_cards() {
		return player_cards;
	}
}