package squares_concrete;

import java.io.Serializable;
import java.util.Random;

import models.*;
import squares_abstract.*;

public class CommunityChest extends CardSquare implements Serializable {

	private static final long serialVersionUID = 8283711846439423804L;
	
	private ChestCards cards;
	private int cardsDrawn;
	private String lastCard;

	public CommunityChest(int i, String s) {
		super(i, s);
		String[] info = s.split(",");
		name = info[0];
		cards = ChestCards.getInstance();
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
