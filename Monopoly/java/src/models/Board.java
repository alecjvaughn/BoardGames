package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import squares_abstract.Square;
import squares_abstract.SquareFactory;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class Board implements Serializable {

	private static final long serialVersionUID = 7398668666224386524L;

	public static final int SIZE = 40;
    
    private SquareFactory factory;
    private List<Square> squares = new ArrayList<>(SIZE);
    
    public Board(SquareFactory factory) {
    	this.factory = factory;
        buildSquares();
        linkSquares();
    }
    
    public Square getSquare(Square start, int distance) {
        int endIndex = (start.getIndex() + distance) % SIZE;
        return (Square) squares.get(endIndex);
    }
    
    public Square getSomeSquare(int index) {
        return (Square) squares.get(index);
    }
    
    public Square getSomeSquare(String name) {
    	Square square = null;
    	Square[] squaresItr = squares.toArray(new Square[0]);
    	for(Square s : squaresItr) {
    		if(s.getName().equals(name)) {
    			square = s;
    		}
    	}
    	return square;
    }
    
    public Square getStartSquare() {
        return (Square) squares.get(0);
    }
    
    private void buildSquares() {
        for(int i = 0; i < SIZE; i++) {
            squares.add(factory.createSquare(i));
        }
    }
    
    private void linkSquares() {
        for(int i = 0; i < SIZE - 1; i++) {
            link(i);
        }
        Square first = squares.get(0);
        Square last = squares.get(SIZE - 1);
        last.setNextSquare(first);
    }
    
    private void link(int i) {
        Square current = squares.get(i);
        Square next = squares.get(i + 1);
        current.setNextSquare(next);
    }
}
