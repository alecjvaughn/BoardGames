package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class Railroad extends PropertySquare implements Serializable {

	private static final long serialVersionUID = -4669263160856906858L;
	
	private int[] rent = new int[4];

	public Railroad(int i, String s) {
		super(i, s);
		String info[] = s.split(",");
		name = info[0];
		price = Integer.parseInt(info[1]);
		rent[0] = Integer.parseInt(info[2]);
		rent[1] = Integer.parseInt(info[3]);
		rent[2] = Integer.parseInt(info[4]);
		rent[3] = Integer.parseInt(info[5]);
		mortgagedVal = price/2;
	}
	
	@Override
	public int getRent() {
		return rent[0];
	}
	
	@Override
	public String toString() {
		return String.format(
				"%s\n"
				+ "Rent: $%d\n"
				+ "If 2 R.R.'s are owned: $%d\n"
				+ "If 3 \"\" \"\" \"\": $%d\n"
				+ "If 4 \"\" \"\" \"\": $%d\n"
				+ "Mortgage Value: $%d\n",
				name, 
				rent[0], rent[1], rent[2], rent[3], 
				mortgagedVal);
	}

}
