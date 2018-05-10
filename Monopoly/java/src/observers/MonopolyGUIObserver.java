package observers;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import controllers.*;
import models.*;
import squares_abstract.*;

public class MonopolyGUIObserver implements Observer {

	public MonopolyGUIObserver(MonopolyGUIController board) {
		board.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MonopolyGUIController) {
			if(arg instanceof Player) {
				Alert alert = new Alert(AlertType.INFORMATION, ((MonopolyGUIController) o).getMessage(), ButtonType.OK);
		    		alert.showAndWait();
		    		if(alert.getResult() == ButtonType.OK) {
		    		    alert.close();
		    		}
			}
			if(arg instanceof Square) {
				if(arg instanceof PropertySquare) {
					PropertySquare s = (PropertySquare) arg;
					if(s.hasOwner()) {
						Alert pay = new Alert(AlertType.INFORMATION, ((MonopolyGUIController) o).getMessage(), ButtonType.OK);
			        		pay.showAndWait();
			        		if(pay.getResult() == ButtonType.OK) {
			        			((MonopolyGUIController) o).setPaysRent(true);
			        			pay.close();
			        		}
		        		} else if(!s.hasOwner()) {
		        			purchaseDialog((MonopolyGUIController) o, s);
					} 
				} else if(arg instanceof CardSquare) {
					
				} else if(arg instanceof TaxSquare) {
					
				}
			}
		}
	}
	
	private void purchaseDialog(MonopolyGUIController o, PropertySquare s) {
		ButtonType more = new ButtonType("Property Info");
		Alert buy = new Alert(AlertType.CONFIRMATION, ((MonopolyGUIController) o).getMessage(), ButtonType.YES, more, ButtonType.NO);
		buy.showAndWait();
		if(buy.getResult() == ButtonType.YES) {
			((MonopolyGUIController) o).setPurchases(true);
		    buy.close();
		} else if(buy.getResult() == more){
			Alert info = new Alert(AlertType.INFORMATION, s.toString(), ButtonType.OK);
			info.showAndWait();
			if(info.getResult() == ButtonType.OK) {
    				info.close();
    				purchaseDialog(o, s);
    			}
		} else {
			((MonopolyGUIController) o).setForAcution(true);
			buy.close();
		}
	}

}
