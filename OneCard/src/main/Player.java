package main;

import java.util.ArrayList;

public class Player {
	String name;
    ArrayList<String> card_list;
    
    public Player(String name) {
    	this.name = name;
    }

    public void get_card(String card) {
        card_list.add(card);
    }
}
