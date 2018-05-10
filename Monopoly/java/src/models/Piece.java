package models;

import java.io.Serializable;

import squares_abstract.Square;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class Piece implements Serializable {
	
	private static final long serialVersionUID = -3961535441850768L;

	private Player player;
	private Square location;
    
    //constructor
    public Piece(Player player, Square location) {
    		this.player = player;
        this.location = location;
    }

    //getter and setter
    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
    
    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
    	this.location = location;
    	location.landedOnBy(this.getPlayer());
    	/*int shouldBeLoc = (this.location.getIndex() + this.getPlayer().getRoll()) % this.getPlayer().getBoard().SIZE;
    	if(shouldBeLoc == location.getIndex()) {
    		this.location = location;
    	}*/
    }
    
}
