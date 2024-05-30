package briscola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger logger = LoggerFactory.getLogger(Database.class);

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

	public Database(JFrame frame) {
		this.frame = frame;

		LogbackConfigurator.configure("logs/logback.xml");


        try {

			logger.info("Decrypting database credentials...");

            this.password = c.decrypt(str[2]);
			this.hostname = c.decrypt(str[3]);
			this.username = c.decrypt(str[4]);
			this.url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);

			try {
				logger.info("Loading database driver...");
				Class.forName(Database.driver);
				logger.info("Database driver loaded successfully.");
			} catch (ClassNotFoundException e) {
				logger.error("Database driver not found", e);
				throw new RuntimeException("Database driver not found", e);
			}

			logger.info("Establishing database connection...");

			conn = DriverManager.getConnection(this.url, this.username, this.password);

			logger.info("Database connection established successfully.");

        } catch (Exception e) {
			logger.error("Error decrypting the host, password and username", e);
			throw new RuntimeException("Error initializing database connection", e);
        }

	}

	/**
	 * Registers a new user in the database.
	 *
	 * @param username The username of the user
	 * @param password The password of the user
	 * @throws SQLException If an error occurs during database operation
	 */

	public void registerUser(String username, String password) {
		String sql = "";
		
		try {
			sql = c.decrypt(str[5]);
		} catch (Exception e) {
			logger.error("Error decrypting the sql query", e);
		}
		
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setString(2, password);
			try {
				statement.executeUpdate();
				JOptionPane.showMessageDialog(frame, "Utente registrato con successo", "Register",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("User {} registered successfully", username);
			} catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(frame, "Utente già registrato", "Register",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Already registered user: {}", username);
			}
		} catch (SQLException e) {
			logger.error("SQL error during user registration for user: {}", username, e);
			JOptionPane.showMessageDialog(frame, "Errore durante la registrazione. Riprova più tardi.", "Errore",
					JOptionPane.ERROR_MESSAGE);
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

	public boolean loginUser(String username, String password) {
		String sql = "";
		
		try {
			sql = c.decrypt(str[6]);
		} catch (Exception e) {
			logger.error("Error decrypting the sql query", e);
		}
		
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			nomeUtente = username;
			userPassword = password;
			boolean loggedIn = resultSet.next();
			if (loggedIn) {
				logger.info("User {} logged in successfully", username);
			} else {
				logger.info("Failed login attempt for user {}", username);
			}
			return loggedIn;
		} catch (SQLException e) {
			logger.error("SQL error during login for user: {}", username, e);
		}
		return false;
	}

	/**
	 * Updates user statistics for a won game.
	 */

	public void vittoria() {

		updateGameStatistics(str[7], str[8], "victory");
	}

	/**
	 * Updates user statistics for a drawn game.
	 */

	public void pareggio() {

		updateGameStatistics(str[9], str[10], "draw");
	}

	/**
	 * Updates user statistics for a lost game.
	 */

	public void sconfitta() {

		updateGameStatistics(str[11], str[12], "defeat");
	}


	/**
	 * Updates user statistics for a game based on the provided SQL queries.
	 *
	 * @param sqlSelect The SQL query for selecting user statistics
	 * @param sqlUpdate The SQL query for updating user statistics
	 * @param gameResult The result of the game ("victory", "draw", or "defeat")
	 */
	private void updateGameStatistics(String sqlSelect, String sqlUpdate, String gameResult) {
		try {
			logger.info("Decrypting SQL queries for {}", gameResult);
			sqlSelect = c.decrypt(sqlSelect);
			sqlUpdate = c.decrypt(sqlUpdate);

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
					logger.info("User's game statistics updated for {} after {}", nomeUtente, gameResult);
				} else {
					// If no user statistics found for the provided username
					logger.warn("No user found with the specified credentials for {}", nomeUtente);
				}
			}
		} catch (Exception e) {
			logger.error("Error updating game statistics for user: {}", nomeUtente, e);
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
			logger.info("Decrypting SQL query for retrieving top players");
	        sql = c.decrypt(str[13]);
	    } catch (Exception e) {
			logger.error("Error decrypting the SQL query for top players", e);
	    }

		try (PreparedStatement statement = conn.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String username = resultSet.getString("nomeUtente");
				if (!username.equals("admin")) {
					int gamesWon = resultSet.getInt("partiteVinte");
					int gamesLost = resultSet.getInt("partitePerse");
					playerStats.put(username, new PlayerStats(gamesWon, gamesLost));
					logger.info("Retrieved stats for player: {}", username);
				}
			}
        } catch (SQLException e) {
			logger.error("SQL error while retrieving top players", e);
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
