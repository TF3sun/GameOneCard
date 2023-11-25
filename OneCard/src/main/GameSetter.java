package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameSetter{	
	private int player_number;
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	
	public GameSetter() {
//		System.out.println("game setter start");
		// 게임을 플레이할 플레이어 수 입력
		player_number = inputPlayerNumber();
//		System.out.println("input player number : " + player_number);

		// 플레이어 수 만큼 Player 객체 생성
		players = createPlayers(player_number);
		Game.players.addAll(players);
		
		// 카드 생성
		cards = createCardSet();
		Game.cards.addAll(cards);
//		System.out.println(Game.players);
//		System.out.println("finish setting game");
	}
	
	private int inputPlayerNumber() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("플레이어 수를 입력하세요. : ");
			int player_num = scanner.nextInt();
			
			if(player_num < 2 || player_num > 4) {
				System.out.println("플레이어 수는 2~4명이어야합니다.");
			}else {
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
		if(player_number >= 2) {
			ComputerPlayer player1 = new ComputerPlayer("player1");
			players.add(player1);
//			System.out.println("create player1");
		}
		if(player_number >= 3) {
			ComputerPlayer player2 = new ComputerPlayer("player2");
			players.add(player2);
//			System.out.println("create player2");
		}
		if(player_number >= 4) {
			ComputerPlayer player3 = new ComputerPlayer("player3");
			players.add(player3);
//			System.out.println("create player3");
		}
		
		return players;
	}

	private ArrayList<Card> createCardSet() {
		ArrayList<Card> card_list = new ArrayList<Card>();
		ArrayList<String> suit = new ArrayList<String>(Arrays.asList("S","C","D","H"));
		ArrayList<String> rank = new ArrayList<String>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
	
		for(String s : suit) {
			for(String r : rank) {
				Card card = new Card(s,r);
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
}