package squares_abstract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import squares_concrete.*;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class SquareFactory implements Serializable {

	private static final long serialVersionUID = -7708243580169758935L;

	private Scanner squares;
	
	// default constructor
	public SquareFactory() {
		try {
			squares = new Scanner(new File("/Users/ry5923un/git/Monopoly/misc/csvs/Squares.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Square createSquare(int loc) {
		Square square = null;
		switch(loc) {
		// Unique Squares
		//////////////////
		case 0:  // GO
			square = new Go(loc, squares.nextLine()); 
			break;
		case 10: // Jail
			square = new JustVisiting(loc, squares.nextLine()); 
			break;
		case 20: // Free Parking
			square = new FreeParking(loc, squares.nextLine()); 
			break;
		case 30: // Go to Jail
			square = new GoToJail(loc, squares.nextLine()); 
			break;
		// Card Squares
		//////////////////
			// Community Chest
		case 2:
		case 17:
		case 33:
			square = new CommunityChest(loc, squares.nextLine()); 
			break;
			// Chance
		case 7:
		case 22:
		case 36:
			square = new Chance(loc, squares.nextLine()); 
			break;
		// Taxes
		//////////////////
		case 4:  // Income Tax
			square = new IncomeTax(loc, squares.nextLine()); 
			break;
		case 38: // Luxury Tax
			square = new LuxuryTax(loc, squares.nextLine()); 
			break;
		// Utilities
		//////////////////
		case 12: // Electric Company
		case 28: // Water Works
			square = new Utility(loc, squares.nextLine()); 
			break;
		// Railroads
		//////////////////
		case 5:  // Reading Railroad
		case 15: // Pennsylvania Railroad
		case 25: // B & O Railroad
		case 35: // Short Line Railroad
			square = new Railroad(loc, squares.nextLine()); 
			break;
		// Properties
		//////////////////
		case 1:  // Brown 1 - Mediteranean Avenue
		case 3:  // Brown 2 - Baltic Avenue
		case 6:  // Cyan 1 - Oriental Avenue
		case 8:  // Cyan 2 - Vermont Avenue
		case 9:  // Cyan 3 - Connecticut Avenue
		case 11: // Pink 1 - St. Charles Place
		case 13: // Pink 2 - States Avenue
		case 14: // Pink 3 - Virginia Avenue
		case 16: // Orange 1 - St. James Avenue
		case 18: // Orange 2 - Tennessee Avenue
		case 19: // Orange 3 - New York Avenue
		case 21: // Red 1 - Kentucky Avenue
		case 23: // Red 2 - Indiana Avenue
		case 24: // Red 3 - Illinois Avenue
		case 26: // Yellow 1 - Atlantic Avenue
		case 27: // Yellow 2 - Ventor Avenue
		case 29: // Yellow 3 - Marvin Gardens
		case 31: // Green 1 - Pacific Avenue
		case 32: // Green 2 - North Carolina Avenue
		case 34: // Green 3 - Pennsylvania Avenue
		case 37: // Blue 1 - Park Place
		case 39: // Blue 2 - Boardwalk
			square = new Lot(loc, squares.nextLine());
			break;
		}
		return square;
	}
	
}
