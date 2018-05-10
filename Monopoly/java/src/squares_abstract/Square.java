package squares_abstract;

import java.io.Serializable;

import controllers.MonopolyGameController;
import models.Player;

public abstract class Square implements Serializable {
	
	private static final long serialVersionUID = -2704498972556625115L;
	
	protected static MonopolyGameController game = MonopolyGameController.getInstance();
	protected String name;
	protected int index;
    protected Square nextSquare;
    
    public Square(int index, String name) {
    		this.index = index;
    		this.name = name;
	}

	//getters and setters
    public void setNextSquare(Square nextSquare) {
        this.nextSquare = nextSquare;
    }

    public Square getNextSquare() {
        return nextSquare;
    }
    
    public int getIndex() {
        return index;
    }

    public void setName(String name) {
    		this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void landedOnBy(Player p);

    @Override
    public String toString() {
    		return name;
    }
    
}
