package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	public static ArrayList<Player> players = new ArrayList();
	public static ArrayList<Card> cards = new ArrayList();
	public static ArrayList<Card> used_cards = new ArrayList();
//	public static Player player;
//	private static Host host;

	Game() {
		set();

		start();
	}

	private void set() {
		System.out.println("Start Set Game");
		int player_number;

		// 게임을 플레이할 플레이어 수 입력
		player_number = inputPlayerNumber();
//		System.out.println("input player number : " + player_number);

		// 플레이어 수 만큼 Player 객체 생성
		players.addAll(createPlayers(player_number));
		
		// 카드 생성
		cards.addAll(createCardSet());
		
		Collections.shuffle(cards);
//		System.out.println(Game.players);
//		System.out.println("finish setting game");
		for(int i=0; i<players.size(); i++) {			
			for(int j = 0;  j<7; j++) {
//				System.out.println(cards.size());
				players.get(i).recieveCard(cards.remove(0));
			}
//			System.out.println();
		}
		used_cards.add(cards.remove(0));
		
		int rand_turn = getRandNum();
		players.get(rand_turn).startTurn();
	}

	private void start() {

	}

	private int inputPlayerNumber() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("플레이어 수를 입력하세요. : ");
			int player_num = scanner.nextInt();

			if (player_num < 2 || player_num > 4) {
				System.out.println("플레이어 수는 2~4명이어야합니다.");
			} else {
				scanner.close();
				return player_num;
			}
		}
	}

	private ArrayList<Player> createPlayers(int player_number) {
		ArrayList<Player> players = new ArrayList();

		HumanPlayer player0 = new HumanPlayer("mainPlayer");
		players.add(player0);
//		System.out.println("create player0");
		if (player_number >= 2) {
			ComputerPlayer player1 = new ComputerPlayer("player1");
			players.add(player1);
//			System.out.println("create player1");
		}
		if (player_number >= 3) {
			ComputerPlayer player2 = new ComputerPlayer("player2");
			players.add(player2);
//			System.out.println("create player2");
		}
		if (player_number >= 4) {
			ComputerPlayer player3 = new ComputerPlayer("player3");
			players.add(player3);
//			System.out.println("create player3");
		}

		return players;
	}

	private ArrayList<Card> createCardSet() {
		ArrayList<Card> card_list = new ArrayList<Card>();
		ArrayList<String> suit = new ArrayList<String>(Arrays.asList("S", "C", "D", "H"));
		ArrayList<String> rank = new ArrayList<String>(
				Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));

		for (String s : suit) {
			for (String r : rank) {
				Card card = new Card(s, r);
				card_list.add(card);
			}
		}

		Card color_joker = new Card("Color", "Joker");
		Card black_jocker = new Card("Black", "Joker");

		card_list.add(black_jocker);
		card_list.add(color_joker);

		return card_list;
//		System.out.println(card_list);

//		System.out.println("finish create card");
	}
	
	private int getRandNum() {
		int randnum = (int) (Math.random() * players.size());
		
	    System.out.println("첫번째 순서는 " + players.get(randnum).getName() + "입니다.");
	    return randnum;
	}
}