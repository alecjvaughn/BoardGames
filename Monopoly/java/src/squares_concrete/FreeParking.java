package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class FreeParking extends Square implements Serializable {
	
	private static final long serialVersionUID = -3414750626535032830L;

	public FreeParking(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
	}

	@Override
	public void landedOnBy(Player p) {
		// TODO Auto-generated method stub
		
	}

}
