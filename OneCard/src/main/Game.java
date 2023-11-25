package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	public static ArrayList<Player> players = new ArrayList();
	public static ArrayList<Card> cards = new ArrayList();
	
	public static void main(String[] args) {
		GameSetter game_setter = new GameSetter();
		
		GameHost game_host = new GameHost();
	}

	public static void start(int first_player_idx) {
		Game.players.get(first_player_idx).startTurn();
	}	
}