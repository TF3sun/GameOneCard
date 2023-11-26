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
	static Card home_card;
	Scanner scanner = new Scanner(System.in);
//	public static Player player;
//	private static Host host;

	Game() {
		set();
		play();
	}

//	게임 시작 전 설정하는 메서드
	private void set() {
//		System.out.println("Start Set Game");
		int player_number;

		// 게임을 플레이할 플레이어 수 입력
		player_number = inputPlayerNumber();
//		System.out.println("input player number : " + player_number);

		// 플레이어 수 만큼 Player 객체 생성
		players.addAll(createPlayers(player_number));

		// 카드 생성
		cards.addAll(createCardSet());

//		카드 순서 섞음
		Collections.shuffle(cards);
//		System.out.println(Game.players);
//		System.out.println("finish setting game");
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < 7; j++) {
//				System.out.println(cards.size());
				players.get(i).recieveCard(cards.remove(0));
			}
//			System.out.println();
		}
//		used_cards.add(cards.remove(0));
	}

//	게임 실행
	private void play() {
//		카드를 한장 꺼내놓음
		used_cards.add(cards.remove(0));

//		시작한 순서를 랜덤 지정
		int turn = getRandNum();

//		사용자 턴 반복
		while (true) {
			home_card = used_cards.get(used_cards.size() - 1);

			if (players.get(turn).getPlayer_cards().size() == 0) {
				turn++;
			} else {
				players.get(turn).startTurn();
			}

			if (turn == players.size() - 1) {
				turn = turn - players.size() + 1;
			} else {
				turn++;
			}
			System.out.println("==============================================================================");
		}
	}

	private int inputPlayerNumber() {
		while (true) {
			System.out.print("플레이어 수를 입력하세요. : ");
			int player_num = scanner.nextInt();

			if (player_num < 2 || player_num > 4) {
				System.out.println("플레이어 수는 2~4명이어야합니다.");
			} else {
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
		int randnum = (int) (Math.random() * players.size() - 1);

		System.out.println("첫번째 순서는 " + players.get(randnum).getName() + "입니다.");
		System.out.println("==============================================================================");
		return randnum;
	}

	public static ArrayList<Card> getUsed_cards() {
		return used_cards;
	}

	public static void setUsed_cards(ArrayList<Card> used_cards) {
		Game.used_cards = used_cards;
	}

	public static ArrayList<Card> getCards() {
		return cards;
	}

	public static void setCards(ArrayList<Card> cards) {
		Game.cards = cards;
	}

	public static void drawCardFromPlayer(Player player) {
		// TODO Auto-generated method stub
		if (cards.size() == 0) {
			cards.addAll(getUsed_cards());

			for (int i = 0; i < used_cards.size() - 1; i++) {
				getUsed_cards().remove(0);
//				home_cardused_cards

//				player.getPlayer_cards().add(cards.remove(0));
//				System.out.println("남은 카드 수: " + cards.size());
//				cards.used_cards.remove(0);
			}
			
			Collections.shuffle(cards);
			player.getPlayer_cards().add(cards.remove(0));
//			System.out.println("남은 카드 수: " + cards.size());
			
		} else {
			player.getPlayer_cards().add(cards.remove(0));
//			System.out.println(player.getPlayer_cards().size());
//			System.out.println("남은 카드 수: " + cards.size());
		}
	}

	public static Card getHome_card() {
		return home_card;
	}

	public void setHome_card(Card home_card) {
		this.home_card = home_card;
	}
}