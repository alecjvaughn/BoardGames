package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChestCards {
	
	private static ChestCards instance;
	private List<String> cards;
	
	private ChestCards() {
		cards = new ArrayList<>();
		try(
				Scanner scan = new Scanner(new File("/Users/ry5923un/git/Monopoly/misc/csvs/ChestCards.csv"));
				) 
		{
			while(scan.hasNextLine()) {
				cards.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ChestCards getInstance() {
		return (instance == null) ? instance = new ChestCards() : instance;
	}
	
	public List<String> getCards() {
		return cards;
	}
}
