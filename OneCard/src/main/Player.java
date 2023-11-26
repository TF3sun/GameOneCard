package main;

import java.util.ArrayList;
import java.util.Scanner;

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
//		카드를 낼 수 있는 조건
//		카드의 문양이 같거나, 숫자가 같은 경우 사용 가능
		if(Game.home_card.suit == card.suit || Game.home_card.rank == card.rank) {
			player_cards.remove(card);
			Game.used_cards.add(card);
			
			if(player_cards.size()==1) {
				inputOneCard();
			}
//		나와 있는 카드가 조커인 경우
		}else if(Game.home_card.rank == "Joker") {
//			컬러 조커인 경우, 다이아 혹은 하트 문양 카드만 낼 수 있음
			if(Game.home_card.suit == "Color") {
				if(card.suit == "D" || card.suit == "H") {
					player_cards.remove(card);
					Game.used_cards.add(card);
					
					if(player_cards.size()==1) {
						inputOneCard();
					}
				}else {
					System.out.println("낼 수 없는 카드입니다.");
					startTurn();
				}
//			흑백 조커인 경우, 아무카드나 낼 수 있음
			}else {
				player_cards.remove(card);
				Game.used_cards.add(card);
				
				if(player_cards.size()==1) {
					inputOneCard();
				}
			}
//			내려는 카드가 컬러 조커인 경우 무조건 낼 수 있음
		}else if(card.suit == "Color") {
			player_cards.remove(card);
			Game.used_cards.add(card);
			
			if(player_cards.size()==1) {
				inputOneCard();
			}
//			내려는 카드가 흑백 조커인 경우, 나와있는 카드가 스페이드 혹은 클로버야 낼 수 있음
		}else if(card.suit == "Black") {
			if(Game.home_card.suit == "S" || Game.home_card.suit == "C") {
				player_cards.remove(card);
				Game.used_cards.add(card);
				
				if(player_cards.size()==1) {
					inputOneCard();
				}
			}else {
				System.out.println("낼 수 없는 카드입니다.");
				startTurn();
			}
		}else {
			System.out.println("낼 수 없는 카드입니다.");
			startTurn();
		}
	}
	
//	플레이어에게 남아 있는 카드가 한장인 경우 2초 이내에 "원카드"를 입력하지 않으면 카드가 추가됨
	private void inputOneCard() {
	    System.out.print("[원카드] 를 입력하세요!");
	    Scanner scanner = new Scanner(System.in);
	    long startTime = System.currentTimeMillis();
	    while (true) {
	        if (scanner.hasNextLine()) {
	            String input = scanner.nextLine();
	            if (input.equals("원카드")) {
	                break;
	            }
	        }
	        if (System.currentTimeMillis() - startTime > 2000) {
	        	System.out.println("상대가 먼저 원카드를 말했습니다.");
	            drawCard();
	            break;
	        }
	    }
	}


	public void drawCard() {
//		System.out.println("exe drawCard");
//		System.out.println(this);
		Game.drawCardFromPlayer(this);
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