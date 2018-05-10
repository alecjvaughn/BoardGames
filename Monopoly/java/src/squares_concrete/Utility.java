package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class Utility extends PropertySquare implements Serializable {

	private static final long serialVersionUID = 2525917449941812817L;
	
	private int[] rent = new int[2];

	public Utility(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
		price = Integer.parseInt(info[1]);
		rent[0] = Integer.parseInt(info[2]);
		rent[1] = Integer.parseInt(info[3]);
		mortgagedVal = price/2;
	}

	@Override
	public int getRent() {
		return rent[0];
	}
	
	@Override
	public void paysRent(Player p) {
		p.reduceCash(getRent()*p.getRoll());
		owner.addCash(getRent()*p.getRoll());
	}
	
	@Override
	public String toString() {
		return String.format(
				"%s\n"
				+ "If one \"Utility\" is owned rent is %d times amount shown on dice\n"
				+ "If both \"Utilities\" are owned rent is %d times amount shown on dice\n"
				+ "Mortgage Value: $%d\n",
				name,
				rent[0], rent[1], 
				mortgagedVal);
	}
	
}
