package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class LuxuryTax extends TaxSquare implements Serializable {

	private static final long serialVersionUID = 7658398457493728497L;
	
	public static int LUX_TAX = 75;
	private int taxAmount;
	
	public LuxuryTax(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
		taxAmount = LUX_TAX;
	}

	@Override
	public void landedOnBy(Player p) {
		p.reduceCash(LUX_TAX);
	}
	
	public int getTaxAmount() {
		return taxAmount;
	}

}
