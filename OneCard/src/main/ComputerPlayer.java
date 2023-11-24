package main;

public class ComputerPlayer extends Player{
	public ComputerPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void startTurn(){
		System.out.println("플레이어의 턴입니다. 카드를 선택해주세요.");
		showCards();
	}
	
	private static void showCards() {
		System.out.print("0:카드 뽑기, ");
		for(int i = 0; i < cards.size(); i++) {
			System.out.print((i+1) + ":"+ cards.get(i).name+", ");
		}
	}
}