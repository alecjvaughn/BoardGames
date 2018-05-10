package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import models.*;
import squares_abstract.SquareFactory;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class MonopolyGameController extends Observable implements Serializable {

	private static final long serialVersionUID = -2254022427888344604L;

	private static final int ROUNDS_TOTAL = 20;
    
    private static MonopolyGameController instance;
    
    private List<Player> players;
    private Player currentPlayer;
    private int nextPlayerIndex;
    private Die[] dice;
    private Board board;
    private ArrayList<String> pieces = new ArrayList<String>(Arrays.asList(
		"Horse", "Bag", "Car", "Thimble", "Shoe", "Hat", "Iron", "Cannon", "Ship", "Wheelbarrow", "Dog", "Cat"));
    private int round;
    
    public static int START_CASH = 1500;
	public static int BAIL = 50;
    
    private MonopolyGameController() {
	    	players = new ArrayList<>();
	    	dice = new Die[] {new Die(), new Die()};
	    	board = new Board(new SquareFactory());
	    	round = 1;
	    	nextPlayerIndex = 0;
    }
    
    public static synchronized MonopolyGameController getInstance() {
    		return (instance == null) ? instance = new MonopolyGameController() : instance;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(List<Player> players) {
    		this.players = players;
    }
    
    public Iterator<Player> getPlayerIterator() {
        return players.iterator();
    }
    
    public Player getCurrentPlayer() {
    		return currentPlayer;
    }
    
    public void setCurrentPlayer() {
		currentPlayer = players.get(nextPlayerIndex);
		nextPlayerIndex++;
		nextPlayerIndex %= players.size();
    }
    
    public Die[] getDice() {
    		return dice;
    }
    
    public Board getBoard() {
    		return board;	
    }
    
    public ArrayList<String> getPieces() {
		return pieces;
    }
    
    public int getRound() {
    		return round;
    }
    
    public void setRound(int round) {
    		this.round = round;
    }
    
    public void loadGame(MonopolyGameController game) {
	    	round = game.getRound();
	    	players = game.getPlayers();
	    	board = game.getBoard();
	    	for(Player p: players) {
	    		p.getPiece().setLocation(board.getSomeSquare(p.getLocation().getIndex()));
	    	}
    }
    
    public boolean playGame() {
	    	if(round <= ROUNDS_TOTAL) {
	    		newRoundUpdate();
	    		for(Player p : players) {
	    			whoseTurnUpdate(p.getName());
	    			p.resetRoll();
	    			playerStatusUpdate(p);
	    			do {
		            p.rollDice();
		            playerStatusUpdate(p);
	            } while(p.hasRolledDoubles());
	    		}
	    		if(round == ROUNDS_TOTAL) {
	    			return false;
	    		}
		        round++;
		        return playGame();
	    	} else {
	    		return false;
	    	}
    }
    
    public void newRoundUpdate() {
	    	setChanged();
	    	notifyObservers(round);
	    	clearChanged();
    }
    
    public void whoseTurnUpdate(String name) {
	    	setChanged();
	    	notifyObservers(name);
	    	clearChanged();
    }
    
    public void playerStatusUpdate(Player p) {
	    	setChanged();
	    	notifyObservers(p);
	    	clearChanged();
    }
    
}
