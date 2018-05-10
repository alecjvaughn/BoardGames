package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChanceCards {

	private static ChanceCards instance;
	private List<String> cards;
	
	private ChanceCards() {
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
	
	public static synchronized ChanceCards getInstance() {
		return (instance == null) ? instance = new ChanceCards() : instance;
	}
	
	public List<String> getCards() {
		return cards;
	}
	
}
