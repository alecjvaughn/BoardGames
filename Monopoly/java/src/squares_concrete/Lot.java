package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class Lot extends PropertySquare implements Serializable {
	
	private static final long serialVersionUID = 5092815962035614512L;
	
	private String color;
	private int improvementCost;
	private int improvementsMade;
	private int[] rent = new int[6];
	
	public Lot(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
		color = info[1];
		price = Integer.parseInt(info[2]);
		improvementCost = Integer.parseInt(info[3]);
		rent[0] = Integer.parseInt(info[4]);
		rent[1] = Integer.parseInt(info[5]);
		rent[2] = Integer.parseInt(info[6]);
		rent[3] = Integer.parseInt(info[7]);
		rent[4] = Integer.parseInt(info[8]);
		rent[5] = Integer.parseInt(info[9]);
	}

	public int getImprovementCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void improve() {
		// TODO Auto-generated method stub
		
	}

	public void unimprove() {
		// TODO Auto-generated method stub
		
	}

	public int getImprovementsMade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEquity() {
		return (mortgaged) ? mortgagedVal : price + (improvementsMade * improvementCost);
	}

	@Override
	public int getRent() {
		return rent[improvementsMade];
	}
	
	@Override
	public String toString() {
		return String.format(
				"%s\n"
				+ "Rent: $%d\n"
				+ "With 1 House: $%d\n"
				+ "With 2 Houses: $%d\n"
				+ "With 3 Houses: $%d\n"
				+ "With 4 Houses: $%d\n"
				+ "With Hotel: $%d\n"
				+ "Mortgage Value: $%d\n"
				+ "Houses cost: $%d each\n"
				+ "Hotels, $%d plus 4 houses\n"
				+ "If player owns all the lots of any color-group, "
				+ "the rent is doubled on unimproved lots in that group.\n",
				name, 
				rent[0], rent[1], rent[2], rent[3], rent[4], rent[5], 
				mortgagedVal, improvementCost, improvementCost);
	}
	
}
