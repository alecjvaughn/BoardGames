package controllers;

import java.util.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import controllers.*;
import models.*;
import observers.*;
import squares_abstract.*;
import squares_concrete.*;

public class MonopolyGUIController extends Observable {

    @FXML private AnchorPane scene;
    @FXML private ImageView boardImage;
    @FXML private GridPane board;
    @FXML private Label red1Owner;
    @FXML private Label red2Owner;
    @FXML private Label red3Owner;
    @FXML private Label rr3Owner;
    @FXML private Label yellow1Owner;
    @FXML private Label yellow2Owner;
    @FXML private Label yellow3Owner;
    @FXML private Label blue2Properties;
    @FXML private Label blue1Properties;
    @FXML private Label blue2Owner;
    @FXML private Label green3Properties;
    @FXML private Label green2Properties;
    @FXML private Label green1Properties;
    @FXML private Label cyan3Owner;
    @FXML private Label cyan2Owner;
    @FXML private Label brown2Owner;
    @FXML private Label cyan3Properties;
    @FXML private Label cyan2Properties;
    @FXML private Label cyan1Properties;
    @FXML private Label brown2Properties;
    @FXML private Label brown1Properties;
    @FXML private Label orange3Properties;
    @FXML private Label orange2Properties;
    @FXML private Label orange1Properties;
    @FXML private Label pink3Properties;
    @FXML private Label pink2Properties;
    @FXML private Label pink1Properties;
    @FXML private Label orange3Owner;
    @FXML private Label orange2Owner;
    @FXML private Label orange1Owner;
    @FXML private Label pink3Owner;
    @FXML private Label pink2Owner;
    @FXML private Label pink1Owner;
    @FXML private Label red1Properites;
    @FXML private Label red2Properties;
    @FXML private Label red3Properties;
    @FXML private Label yellow1Properties;
    @FXML private Label yellow2Properties;
    @FXML private Label yellow3Properties;
    @FXML private Label rr2Owner;
    @FXML private Label utility1Owner;
    @FXML private Label utility2Owner;
    @FXML private Label green1Owner;
    @FXML private Label green2Owner;
    @FXML private Label green3Owner;
    @FXML private Label rr4Owner;
    @FXML private Label blue1Owner;
    @FXML private Label cyan1Owner;
    @FXML private Label rr1Owner;
    @FXML private Label brown1Owner;
    @FXML private VBox space0;
    @FXML private Label player1MoveToken;
    @FXML private Label player2MoveToken;
    @FXML private VBox space1;
    @FXML private VBox space2;
    @FXML private VBox space3;
    @FXML private VBox space4;
    @FXML private VBox space5;
    @FXML private VBox space6;
    @FXML private VBox space7;
    @FXML private VBox space8;
    @FXML private VBox space9;
    @FXML private VBox space10;
    @FXML private VBox space11;
    @FXML private VBox space12;
    @FXML private VBox space13;
    @FXML private VBox space14;
    @FXML private VBox space15;
    @FXML private VBox space16;
    @FXML private VBox space17;
    @FXML private VBox space18;
    @FXML private VBox space19;
    @FXML private VBox space20;
    @FXML private VBox space21;
    @FXML private VBox space22;
    @FXML private VBox space23;
    @FXML private VBox space24;
    @FXML private VBox space25;
    @FXML private VBox space26;
    @FXML private VBox space27;
    @FXML private VBox space28;
    @FXML private VBox space29;
    @FXML private VBox space30;
    @FXML private VBox space31;
    @FXML private VBox space32;
    @FXML private VBox space33;
    @FXML private VBox space34;
    @FXML private VBox space35;
    @FXML private VBox space36;
    @FXML private VBox space37;
    @FXML private VBox space38;
    @FXML private VBox space39;
    @FXML private Button rollButton;
    @FXML private Button tradeButton;
    @FXML private Button manageButton;
    @FXML private Button doneButton;
    @FXML private Label player1Header;
    @FXML private Label player1PieceName;
    @FXML private Label player1Money;
    @FXML private Label player2Header;
    @FXML private Label player2PieceName;
    @FXML private Label player2Money;
    @FXML private Button startButton;
    @FXML private Label currentPlayerLabel;
    @FXML private TextFlow textFlow;
    
    private MonopolyGameController game = MonopolyGameController.getInstance();
    private MonopolyGUIObserver alerter = new MonopolyGUIObserver(this);
	private MonopolyTextObserver debugger = new MonopolyTextObserver(this);
    private String message;
    private boolean paysRent;
    private boolean purchases;
    private boolean forAuction;
    
    public ObservableList<Node> getLog() {
    		return textFlow.getChildren();
    }
    
    public Player getCurrentPlayer() {
    		return game.getCurrentPlayer();
    }
    
    public String getMessage() {
    		return message;
    }
    
    public void setPaysRent(boolean b) {
    		paysRent = b;
    }
    
    public void setPurchases(boolean b) {
		purchases = b;
    }
    
    public void setForAcution(boolean b) {
		forAuction = b;
    }
    
    @FXML
    void startGame(ActionEvent event) {
    	
    		game.getPlayers().add(new Player());
    		game.getPlayers().add(new Player());
    		
    		Player p1 = game.getPlayers().get(0);
    		Player p2 = game.getPlayers().get(1);
    		
    		player1PieceName.setText(p1.getName());
    		player1MoveToken.setText(p1.getName());
    		player1Money.setText("$"+p1.getCash());
    		player2PieceName.setText(p2.getName());
    		player2MoveToken.setText(p2.getName());
    		player2Money.setText("$"+p2.getCash());
    		
    		game.setCurrentPlayer();
    		
    		Player p = game.getCurrentPlayer();
    		
    		currentPlayerLabel.setText(p.getName());
    		
    		message = p.getName() + " goes first!";  		
    		updateObservers(p);
    		
    		rollButton.setDisable(false);
    		startButton.setDisable(true);
    		startButton.setVisible(false);
    }

    @FXML
    void playerRoll(ActionEvent event) {
    	
    		Player p = game.getCurrentPlayer();
    		Square sInitial = p.getLocation();
    		
    		p.rollDice();
    		message = p.getName() + " rolls " + p.getRoll() + (p.hasRolledDoubles() ? ". DOUBLES!" : "");
    		updateObservers(p);
    		
    		Square sFinal = p.getLocation();
    		setOnSquare(p,sFinal,sInitial);
    		
    		message = p.getName() + " lands on " + sFinal.getName();
    		updateObservers(p);
    		
    		setLandedOnDialog(p,sFinal);
    		
    		if(!p.hasRolledDoubles()) {
    			rollButton.setDisable(true);
    			doneButton.setDisable(false);
    		}
    		
    }
    
    @FXML
    void playerTradeProperties(ActionEvent event) {

    }
    
    @FXML
    void playerManageProperties(ActionEvent event) {

    }
    
    @FXML
    void playerDone(ActionEvent event) {
    		updateCashLabel(game.getCurrentPlayer());
    		game.setCurrentPlayer();
    		currentPlayerLabel.setText(game.getCurrentPlayer().getName());
    		message = game.getCurrentPlayer().getName() + "'s turn!";
    		updateObservers(game.getCurrentPlayer());
    		rollButton.setDisable(false);
    		doneButton.setDisable(true);
    }
    
    private void setLandedOnDialog(Player p, Square s) {
    		if(s instanceof PropertySquare) {
    			if(((PropertySquare) s).hasOwner()) {
    				message = (((PropertySquare) s).isMortgaged()) ?  "Pay $" + ((PropertySquare) s).getRent() + " for rent" : "Mortaged. Do not collect rent!";
    				updateObservers(s);
    				if(paysRent) {
    					p.reduceCash(((PropertySquare) s).getRent());
    					message = p.getName() + " pays $" + ((PropertySquare) s).getRent();
    					updateCashLabel(p);
        				updateObservers(s);
    					paysRent = false;
    				}
    			} else if(!((PropertySquare) s).hasOwner()) { 
    				message = "Purchase " + s.getName() + " for $" + ((PropertySquare) s).getPrice() + "?";
    				updateObservers(s);
    				if(purchases) {
    					((PropertySquare) s).attemptsPurchase(p);
    					message = p.getName() + " purchases " + s.getName() + " for $" + ((PropertySquare) s).getPrice();
    					updateObservers(s);
    					updateOwnerTag(p,s);
    					updateCashLabel(p);
    					purchases = false;
    				} else if(forAuction) {
    					forAuction = false;
    				}
    			}
    		} else if(s instanceof TaxSquare) {
    			message = "Pay $" + ((TaxSquare) s);
    		} else if(s instanceof CardSquare) {
    			
    		} 
    }
    
    private void setOnSquare(Player p, Square sFinal, Square sInitial) {
		Label token = null;
		ObservableList<Node> gridNodes = board.getChildren();
		VBox space = (VBox) gridNodes.get(sInitial.getIndex());
		ObservableList<Node> spaceNodes = space.getChildren();
		for(int i=0;;spaceNodes.iterator()) {
			Node label = spaceNodes.iterator().next();
			if(label instanceof Label) {
				Label test = (Label) label;
				if(test.getText().equals(p.getName())) {
					token = test;
					spaceNodes.remove(i);
					break;
				}
			}
			i++;
		}
		space = (VBox) gridNodes.get(sFinal.getIndex());
		space.getChildren().add(token);
    }
    
    private void updateOwnerTag(Player p, Square s) {
		ObservableList<Node> gridNodes = board.getChildren();
		Label tag = (Label) gridNodes.get(s.getIndex()+40);
		tag.setText(p.getName());
    }
    
    private void updateCashLabel(Player p) {
    		if(p.getId() == 1) {
			player1Money.setText("$" + p.getCash());
		} else if(p.getId() == 2) {
			player2Money.setText("$" + p.getCash());
		}
    }
    
    private void updateObservers(Player p) {
    		setChanged();
    		notifyObservers(p);
    		clearChanged();
    }
    
    private void updateObservers(Square s) {
		setChanged();
		notifyObservers(s);
		clearChanged();
    }

}
