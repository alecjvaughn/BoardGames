package store;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

import controllers.MonopolyGameController;
import store_I.MonopolyDBStorageI;

/*
 * Author: Team Alpha Bravo Charlie
 * Course: CS471
 * Assignment: Monopoly Game
 * Description: Simulation of Monopoly 
 *  with save and load capabilities and created 
 *  using the Adapter, Factory, Observer, and Singleton design patters
 */
public class MonopolyDBStorage implements MonopolyDBStorageI {
	
	// JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost/monopoly_store";

    // Database credentials
    private static final String USER = "dummy";
    private static final String PASS = "123";
    
    // Queries
    private static final String INSERT_RND = "INSERT INTO games (round) VALUES (?)";
    private static final String INSERT_CNT = "INSERT INTO games (player_count) VALUES (?)";
    private static final String INSERT_P1L = "INSERT INTO games (p1_location) VALUES (?)";
    private static final String INSERT_P2L = "INSERT INTO games (p2_location) VALUES (?)";
    private static final String INSERT_BIN = "INSERT INTO games (save) VALUES (?)";
    private static final String SELECT = "SELECT save FROM games";
    
    // Misc
    private static final int PARAM = 1;
    private static final String SAVE_COL = "save";
    
    // Connection
    private Connection conn = null;
    
    // Statement
    private Statement stmt = null;
    
    // Game
    private MonopolyGameController game;
    
    public MonopolyDBStorage(MonopolyGameController game) {
    	try {
    		Class.forName(JDBC_DRIVER);
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		stmt = conn.createStatement();
    		this.game = game;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
    
    public void write() throws SQLException, IOException {
		PreparedStatement ps;
		ps = conn.prepareStatement(INSERT_RND);
	    ps.setInt(PARAM, game.getRound());
	    ps = conn.prepareStatement(INSERT_CNT);
	    ps.setInt(PARAM, game.getPlayers().size());
	    ps = conn.prepareStatement(INSERT_P1L);
	    ps.setInt(PARAM, game.getPlayers().get(0).getLocation().getIndex());
	    ps = conn.prepareStatement(INSERT_P2L);
	    ps.setInt(PARAM, game.getPlayers().get(1).getLocation().getIndex());
		ps = conn.prepareStatement(INSERT_BIN);
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oout = new ObjectOutputStream(baos);
	    oout.writeObject(game);
	    oout.close();
	    ps.setBytes(PARAM, baos.toByteArray());
	    ps.execute();
    }
    		  
    public Object read() throws SQLException, IOException, ClassNotFoundException {
    	ResultSet rs = stmt.executeQuery(SELECT);
    	rs.next();
	    byte[] buf = rs.getBytes(SAVE_COL);
	    if (buf != null) {
	    	ObjectInputStream objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
	    	return objectIn.readObject();
	    }
	    return null;
    }
	
}
