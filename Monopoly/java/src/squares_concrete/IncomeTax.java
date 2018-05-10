package squares_concrete;

import java.io.Serializable;

import models.*;
import squares_abstract.*;

public class IncomeTax extends TaxSquare implements Serializable {

	private static final long serialVersionUID = -439597926787741089L;
	
	public static int MIN_TAX = 200;
	public static double PERCENT_EQUITY = .10;
	private int taxAmount;

	public IncomeTax(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
		taxAmount = 0;
	}

	@Override
	public void landedOnBy(Player p) {
		calculateTax(p);
		p.reduceCash(taxAmount);
	}
	
	private void calculateTax(Player p) {
		// if 200 is less than 10% of player's total equity then pay later else pay former	
		taxAmount = (MIN_TAX < p.getCash() * PERCENT_EQUITY) ? 
				(int) (p.getCash() * PERCENT_EQUITY) : 
					MIN_TAX;
	}
	
	public int getTaxAmount() {
		return taxAmount;
	}
	
}
