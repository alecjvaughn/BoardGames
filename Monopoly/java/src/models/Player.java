package models;

import java.io.Serializable;
import java.util.List;

import controllers.MonopolyGameController;
import squares_abstract.PropertySquare;
import squares_abstract.Square;
import squares_concrete.Go;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class Player implements Serializable {
    
	private static final long serialVersionUID = 2545861443959642608L;
	
	private MonopolyGameController game = MonopolyGameController.getInstance();
	
	private int id;
	private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;
    
    private int cash;
    private int equity;
    private List<PropertySquare> properties;
    
    private int roll;
    private boolean rolled;
    private boolean rolledDoubles;
    private int rolledDoublesCount;
    private boolean inJail;
    private int nightsInJail;

    public Player() {
    		id = game.getPlayers().size() + 1;
    		int index = (int) (Math.random() * game.getPieces().size());
    		name = game.getPieces().remove(index);
    		dice = game.getDice();
    		board = game.getBoard();
    		piece = new Piece(this, board.getStartSquare());
    		cash = game.START_CASH;
        equity = cash;
    }
    
    public Player(String name, Die[] dice, Board board) {
    		id = game.getPlayers().size() + 1;
        this.name = name;
        this.dice = dice;
        this.board = board;
        piece = new Piece(this, board.getStartSquare());
        cash = game.START_CASH;
        equity = cash;
    }
    
    public void rollDice() {
    		roll = 0;
    		rolled = false;
	    for(Die die: dice) {
	        die.roll();
	        roll += die.getFaceValue();
	    }
	    rolled = true;
	    if(dice[0].getFaceValue() == dice[1].getFaceValue()) {
	    		incrementRolledDoubles();
	    } else {
	    		resetRolledDoubles();
	    }
	    move();
	    rolled = false;
    }
    
    private void move() {
        if(rolledDoubles) {
	        if(rolledDoublesCount == 3) { // third consecutive time rolling doubles, go directly to jail for speeding
		        	piece.setLocation(board.getSomeSquare("Jail")); // do not pass Go, do not collect Go salary
		        	inJail = true;
		        	resetRolledDoubles();
	        } else { // if not third consecutive time rolling doubles move normally, and go again 
	        	movePieceNormally();
	        }	
        } else if(inJail) {
	        	if(rolledDoubles) { // escape jail and move normally
	        		getOutOfJail();
	        	} else if(nightsInJail == 3) { // post bail move normally
	        		reduceCash(game.BAIL);
	        		getOutOfJail();
	        	} else { // spend another night in jail
	        		System.out.println("Spend another night in Jail!");
	        		nightsInJail++;
	        	}
        } else {
	        movePieceNormally();
        }
    }
    
    public boolean hasRolled() {
    		return rolled;
    }
    
    private void resetRolledDoubles() {
	    	rolledDoubles = false;
	    	rolledDoublesCount = 0;
    }
    
    private void incrementRolledDoubles() {
	    	rolledDoubles = true;
	    	rolledDoublesCount++;
    }
	
	private void getOutOfJail() {
		movePieceNormally();
		inJail = false;
		nightsInJail = 0;
	}
	
	private boolean hasPassedGo() {
		if(getLocation().getIndex() + roll > board.SIZE) {
			return true;
		}
		return false;
	}
	
	private void movePieceNormally() {
		Square newLoc = board.getSquare(piece.getLocation(), roll);
		if(hasPassedGo()) {
			if(board.getStartSquare() instanceof Go) {
				board.getStartSquare().landedOnBy(this);
			}
		}
        piece.setLocation(newLoc);
        if(isInJail()) {
        		piece.setLocation(board.getSomeSquare("Jail"));
        }
	}
    
	public int getId() {
        return id;
    }
	
    public String getName() {
        return name;
    }
    
    public Die[] getDice() {
    		return dice;
    }
    
    public int getRoll() {
    		return roll;
    }
    
    public void resetRoll() {
    		roll = 0;
    }
    
    public Square getLocation() {
        return piece.getLocation();
    }
    
    public int getCash() {
    		return cash;
    }
    
    public int getValueOfAssets() {
    		return getEquity() - cash;
    }
    
    public int getEquity() {
    		equity = cash;
    		for(PropertySquare s : properties) {
    			equity -= s.getEquity();
    		}
    		return equity;
    }
    
    public void addCash(int amount) {
		cash += amount;
	}
	
	public void reduceCash(int amount) {
		cash -= amount;
	}
    
    public Piece getPiece() {
		return piece;
	}
    
    public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	public void postBail() {
		reduceCash(game.BAIL);
		setInJail(false);
	}
	
	public boolean hasRolledDoubles() {
		return rolledDoubles ? true : false;
	}
	
	public List<PropertySquare> getProperties() {
		return properties;
	}
    
	@Override
    public String toString() {
    		return this.getName();
    }
    
}
