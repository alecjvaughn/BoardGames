package models;

import java.io.Serializable;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class Die implements Serializable {
    
	private static final long serialVersionUID = 4673866016814759795L;
	public static final int MAX = 6;
    private int faceValue;
    
    public Die(){
        roll();
    }
    
    public void roll(){
        faceValue = (int)((Math.random() * MAX ) + 1);
    }
    
    public int getFaceValue(){
        return faceValue;
    }
}
