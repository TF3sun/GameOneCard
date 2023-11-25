package main;

import java.util.ArrayList;
import java.util.Scanner;

class HumanPlayer extends Player {
	public HumanPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void startTurn() {
		System.out.println("플레이어의 턴입니다. 카드를 선택해주세요.");
		showCards();
		
		useCard(selectCard());
	}

	private void showCards() {
		System.out.print("0:카드 뽑기, ");
		
		ArrayList<Card> cards = getPlayer_cards();
		for (int i = 0; i < cards.size() ; i++) {
			System.out.print((i + 1) + ":" + cards.get(i).name + ", ");
		}
		System.out.println();
	}

	private Card selectCard() {
		System.out.println("숫자 입력 >> ");
		
		Scanner scanner = new Scanner(System.in);
	    int input_idx = scanner.nextInt();
	    
	    scanner.close();
	    return getPlayer_cards().get(input_idx);
	}
}