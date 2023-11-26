package main;

import java.util.ArrayList;
import java.util.Scanner;

class HumanPlayer extends Player {
	public HumanPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void startTurn() {
		System.out.println("홈 카드 : " + Game.home_card.name);
		System.out.println(this.getName() + "의 턴입니다. 카드를 선택해주세요.");
		showCards();
		selectCard();
	}

	private void showCards() {
		System.out.print("0:카드 뽑기, ");
		
		ArrayList<Card> cards = getPlayer_cards();
		for (int i = 0; i < cards.size() ; i++) {
			System.out.print((i + 1) + ":" + cards.get(i).name + ", ");
		}
		System.out.println();
	}

	private void selectCard() {
	    System.out.print("숫자 입력 >> ");
	    Scanner scanner = new Scanner(System.in);
	    int input_idx = scanner.nextInt();
	    
	    // Do not close the Scanner here
	    if(input_idx == 0) {
	    	System.out.println("0번 선택");
	    	drawCard();
	    }else {
	    	useCard(getPlayer_cards().get(input_idx-1));
	    }
	}

}