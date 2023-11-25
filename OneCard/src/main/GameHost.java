package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameHost {
	private static int first_turn;
	
	public static void Main() {
		first_turn = establishFirstOder();
		
		suffleCards();
		
		giveCardsToAllPlayer();
		
		startTurn(first_turn);
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
	
	private static void giveCardsToAllPlayer() {
		for(int i = 0; i < Game.players.size(); i++) {
			Player player = Game.players.get(i);
			
			for(int j = 0; j < Game.cards.size(); j++) {
				Card card = Game.cards.get(j);
				giveCardToPlayer(player, card);
			}
		}
	}
	
	private static void giveCardToPlayer(Player player, Card card) {
		player.cards.add(card);
		Game.cards.remove(card);
	}
	
	private static void startTurn(int turn_idx) {
		Game.start(turn_idx);
	}
}