package squares_concrete;

import java.io.Serializable;
import java.util.Random;

import models.*;
import squares_abstract.*;

public class Chance extends CardSquare implements Serializable {

	private static final long serialVersionUID = -375890971251500529L;
	
	private ChanceCards cards;
	private int cardsDrawn;
	private String lastCard;

	public Chance(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
		cards = ChanceCards.getInstance();
		cardsDrawn = 0;
	}

	@Override
	public void landedOnBy(Player p) {
		drawCard();
	}
	
	private String drawCard() {
		String card = cards.getCards().get(new Random().nextInt(cards.getCards().size() - cardsDrawn));
		cardsDrawn++;
		lastCard = card;
		cards.getCards().remove(card);
		cards.getCards().add(card);
		return card;
	}
	
	private String getLastCard() {
		return lastCard;
	}
	
	@Override
	public String toString() {
		return lastCard;
	}
	
}
