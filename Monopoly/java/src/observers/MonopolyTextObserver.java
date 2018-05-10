package observers;

import java.util.Observable;
import java.util.Observer;

import controllers.MonopolyGUIController;
import controllers.MonopolyGameController;
import javafx.scene.text.Text;
import models.Player;
import squares_abstract.Square;
import store.*;
import store_I.MonopolyStorageAdapter;
import store_I.MonopolyStorageManager;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class MonopolyTextObserver implements Observer {
	
    public MonopolyTextObserver(MonopolyGUIController board) {
	    board.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MonopolyGUIController) {
			//((MonopolyGUIController) o).getLog().add(new Text(((MonopolyGUIController) o).getMessage()));
			if(arg instanceof Player) {
				Player p = (Player) arg;
				System.out.println(((MonopolyGUIController) o).getMessage());
			}
			if(arg instanceof Square) {
				Square s = (Square) arg;
				System.out.println(((MonopolyGUIController) o).getMessage());
			}
		}
	}
}
