package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class Go extends Square implements Serializable {
	
	private static final long serialVersionUID = 4963696807798470179L;
	
	public static int GO_MONEY = 200;

	public Go(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
	}

	@Override
	public void landedOnBy(Player p) {
		if(p.getLocation().getIndex() + p.getRoll() > game.getBoard().SIZE) {
			System.out.println("Passed GO! Collect $" + GO_MONEY + "!");
		} else {
			System.out.println("Landed on GO! Collect $" + GO_MONEY + "!");
		}
		p.addCash(GO_MONEY);
	}
	
}
