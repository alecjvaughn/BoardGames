package squares_abstract;

import models.Player;

public abstract class PropertySquare extends Square {
	
	private static final long serialVersionUID = -4339179760160194873L;
	
	protected int price;
	protected int mortgagedVal;
	protected boolean mortgaged;
	protected Player owner;

	public PropertySquare(int index, String name) {
		super(index, name);
	}
	
	@Override
	public void landedOnBy(Player p) {}
	
	public void attemptsPurchase(Player p) {
		p.reduceCash(price);
		owner = p;
	}
	
	public void auction() {}
	
	public void paysRent(Player p) {
		if(!mortgaged) {
			p.reduceCash(getRent());
			owner.addCash(getRent());
		}
	}
	
	public void setOwner(Player player) {
		owner = player;
	}
    
    public Player getOwner(Player player) {
    		return owner;
    }
    
    public boolean hasOwner() {
    		return owner != null ? true : false;
    }
    
    public int getPrice() {
    		return price;
    }
    
    public int getMortgageValue() {
		return mortgagedVal;
	}
    
    public void mortgage() {
		owner.addCash(price);
		mortgaged = true;
    }

	public void unmortgage() {
		owner.reduceCash((int) (1.1*price));
		mortgaged = false;
	}
	
	public boolean isMortgaged() {
		return mortgaged;
	}
	
    public int getEquity() {
    		return (mortgaged) ? mortgagedVal : price;
    }
    
    public abstract int getRent();

}
