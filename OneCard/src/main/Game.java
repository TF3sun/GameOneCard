package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	static ArrayList<Player> players = new ArrayList();
	static ArrayList<Card> cards = new ArrayList();

	public static void main(String[] args) {
		//System.out.println("program start");
		Game.setGame();
		
		Game.startGame();
	}

	private static void setGame() {
		//System.out.println("call game setter");
		GameSetter game_setter = new GameSetter();
	}

	private static void startGame() {
		//System.out.println("game start");
		GameHost host = new GameHost();
	}	
	
	public static void addPlayer(ArrayList<Player> player_list) {
		Game.players.addAll(player_list);
	}

	public static void addCard(ArrayList<Card> card_list) {
		Game.cards.addAll(card_list);
	}
	
	public static void removeCard(Card card) {
		cards.remove(card);
	}
}