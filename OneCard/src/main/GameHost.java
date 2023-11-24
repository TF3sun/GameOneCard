package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameHost {
	GameHost() {
		int first_turn = GameHost.establishFirstOder();
		
		GameHost.suffleCards();
		
		GameHost.giveCardsToAllPlayer(Game.players);
		
		GameHost.startTurn(first_turn);
	}

	private static int establishFirstOder() {
		Random random = new Random();
        int rand_num = random.nextInt(Game.players.size());
        System.out.println("첫번째 순서는 " + Game.players.get(rand_num).name + "입니다.");
		return rand_num;
	}
	
	private static void suffleCards() {
//		System.out.println("shuffle cards");
		Collections.shuffle(Game.cards);
	}
	
	private static void giveCardsToAllPlayer(ArrayList<Player> players) {
		for(int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			
			for(int j = 0; j < Game.cards.size(); j++) {
				Card card = Game.cards.get(j);
				GameHost.giveCardToPlayer(player, card);
			}
		}
	}
	
	private static void giveCardToPlayer(Player player, Card card) {
		player.getCard(card);
		Game.removeCard(card);
	}
	
	private static void startTurn(int turn_idx) {
		Game.players.get(turn_idx).startTurn();
	}
}