package store;

import java.io.IOException;
import java.sql.SQLException;

import controllers.MonopolyGameController;
import store_I.MonopolyStorageAdapter;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class MonopolyDBStorageAdapter implements MonopolyStorageAdapter {

	private MonopolyGameController game = MonopolyGameController.getInstance();
	private MonopolyDBStorage db;
	
	public MonopolyDBStorageAdapter() {
		db = new MonopolyDBStorage(game);
	}
	
	@Override
	public MonopolyGameController load() {
		try {
			game = (MonopolyGameController) db.read();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return game;
	}

	@Override
	public void save(MonopolyGameController game) {
		try {
			db.write();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
