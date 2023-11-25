package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerPlayer extends Player{
	public ComputerPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void startTurn() {
		System.out.println("com 턴입니다. 카드를 선택해주세요.");
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
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("숫자 입력 >> ");

	    int input_idx = scanner.nextInt();

	    return getPlayer_cards().get(input_idx);
	}

}