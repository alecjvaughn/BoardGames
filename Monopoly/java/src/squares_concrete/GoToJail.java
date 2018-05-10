package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class GoToJail extends Square implements Serializable {

	private static final long serialVersionUID = 8989508144249938439L;

	public GoToJail(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
	}
	
	@Override
	public void landedOnBy(Player p) {
		p.setInJail(true);
	}

}
