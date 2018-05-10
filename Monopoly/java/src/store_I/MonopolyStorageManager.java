package store_I;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public interface MonopolyStorageManager {

	public void setStorageAdapter(MonopolyStorageAdapter store);
	
}
