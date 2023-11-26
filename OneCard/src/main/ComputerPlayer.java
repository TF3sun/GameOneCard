package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerPlayer extends Player {
	public ComputerPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void startTurn() {
//		System.out.println("홈 카드 : " + Game.home_card.name);
		System.out.println(this.getName() + "의 턴입니다.");
//		showCards();
		selectCard();
	}

//	private void showCards() {
////		System.out.print("0:카드 뽑기, ");
//
//		ArrayList<Card> cards = getPlayer_cards();
//		for (int i = 0; i < cards.size(); i++) {
//			System.out.print((i + 1) + ":" + cards.get(i).name + ", ");
//		}
//		System.out.println();
//	}

	private void selectCard() {
		int rand_idx = (int) (Math.random() * getPlayer_cards().size() - 1);

		// Do not close the Scanner here
		if (rand_idx == 0) {
			System.out.println("카드를 뽑았습니다.");
			drawCard();
		} else {
			useCard(getPlayer_cards().get(rand_idx));
		}

	}

}