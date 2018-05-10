package store_I;

import java.io.IOException;
import java.sql.SQLException;

import controllers.MonopolyGameController;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public interface MonopolyDBStorageI {

	public void write() throws SQLException, IOException;
	
	public Object read() throws SQLException, IOException, ClassNotFoundException;
	
}
