package briscola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class handles database operations for user registration, login, and game statistics.
 */

public class Database {

	private Crypt c = new Crypt();
	
	private String[] str = c.getStr();
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private final String username;
	private final String password;
	private final String hostname;
	private final String port = str[0];
	private final String database = str[1];
	private final String url;
	
	
	private final Connection conn;
	private final JFrame frame;
	private String nomeUtente;
	private String userPassword;

	/**
	 * Constructor for the Database class.
	 * Initializes the database connection.
	 *
	 * @param frame The JFrame used for displaying dialog messages
	 * @throws Exception If an error occurs while connecting to the database
	 */

	public Database(JFrame frame) throws Exception {
		this.frame = frame;
		
		
		this.password = c.decrypt(str[2]);
		this.hostname = c.decrypt(str[3]);
		this.username = c.decrypt(str[4]);

		this.url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);

		Class.forName(Database.driver);
		conn = DriverManager.getConnection(this.url, this.username, this.password);
	}

	/**
	 * Registers a new user in the database.
	 *
	 * @param username The username of the user
	 * @param password The password of the user
	 * @throws SQLException If an error occurs during database operation
	 */

	public void registerUser(String username, String password) throws SQLException {
		String sql = "";
		
		try {
			sql = c.decrypt(str[5]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setString(2, password);
			try {
				statement.executeUpdate();
				JOptionPane.showMessageDialog(frame, "Utente registrato con successo", "Register",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(frame, "Utente già registrato", "Register",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Logs in a user with the specified username and password.
	 *
	 * @param username The username of the user
	 * @param password The password of the user
	 * @return True if login is successful, false otherwise
	 * @throws SQLException If an error occurs during database operation
	 */

	public boolean loginUser(String username, String password) throws SQLException {
		String sql = "";
		
		try {
			sql = c.decrypt(str[6]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			nomeUtente = username;
			userPassword = password;
			return resultSet.next();
		}
	}

	/**
	 * Updates user statistics for a won game.
	 */

	public void vittoria() {
		
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt(str[7]);
			sqlUpdate = c.decrypt(str[8]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		updateGameStatistics(sqlSelect, sqlUpdate);
	}

	/**
	 * Updates user statistics for a drawn game.
	 */

	public void pareggio() {
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt(str[9]);
			sqlUpdate = c.decrypt(str[10]);
		} catch (Exception e) {
			e.printStackTrace();
		}


		updateGameStatistics(sqlSelect, sqlUpdate);
	}

	/**
	 * Updates user statistics for a lost game.
	 */

	public void sconfitta() {
		
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt(str[11]);
			sqlUpdate = c.decrypt(str[12]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		updateGameStatistics(sqlSelect, sqlUpdate);
	}

	/**
	 * Updates user statistics for a game based on the provided SQL queries.
	 *
	 * @param sqlSelect The SQL query for selecting user statistics
	 * @param sqlUpdate The SQL query for updating user statistics
	 */
	private void updateGameStatistics(String sqlSelect, String sqlUpdate) {
		try (PreparedStatement selectStatement = conn.prepareStatement(sqlSelect);
			 PreparedStatement updateStatement = conn.prepareStatement(sqlUpdate)) {

			// Set the username parameter for the select statement
			selectStatement.setString(1, nomeUtente);

			// Execute the select statement to retrieve user statistics
			ResultSet resultSet = selectStatement.executeQuery();

			// If the user statistics exist
			if (resultSet.next()) {
				// Update the user statistics with the username parameter
				updateStatement.setString(1, nomeUtente);
				updateStatement.executeUpdate();
				System.out.println("User's game statistics updated for " + nomeUtente);
			} else {
				// If no user statistics found for the provided username
				System.out.println("No user found with the specified credentials");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Retrieves statistics for top players from the database.
	 *
	 * @return A HashMap containing player usernames and their respective statistics
	 */

	public HashMap<String, PlayerStats> topPlayers() {
	    HashMap<String, PlayerStats> playerStats = new HashMap<>();
	    String sql = "";
	    try {
	        sql = c.decrypt(str[13]);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    PreparedStatement statement;
	    try {
	        statement = conn.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String username = resultSet.getString("nomeUtente");
	            if (!username.equals("admin")) {
	                int gamesWon = resultSet.getInt("partiteVinte");
	                int gamesLost = resultSet.getInt("partitePerse");
	                playerStats.put(username, new PlayerStats(gamesWon, gamesLost));
	            }
	        }

	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    return playerStats;
	}

	/**
	 * Retrieves the username of the currently logged-in user.
	 *
	 * @return The username of the logged-in user
	 */
	
	public String getUsername() {
		return nomeUtente;
	}

	/**
	 * Retrieves the password of the currently logged-in user.
	 *
	 * @return The password of the logged-in user
	 */

	public String getPassword(){
		return userPassword;
	}

}
