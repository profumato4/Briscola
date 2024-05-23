package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

	public Database(JFrame frame) throws Exception {
		this.frame = frame;
		
		
		this.password = c.decrypt(str[2]);
		this.hostname = c.decrypt(str[3]);
		this.username = c.decrypt(str[4]);

		this.url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);

		Class.forName(Database.driver);
		conn = DriverManager.getConnection(this.url, this.username, this.password);
	}

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
				System.out.println("Utente registrato con successo.");
			} catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(frame, "Utente già registrato", "Register",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

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
			return resultSet.next();
		}
	}

	public void vittoria() {
		
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt(str[7]);
			sqlUpdate = c.decrypt(str[8]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		partita(sqlSelect, sqlUpdate);
	}

	public void pareggio() {
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt(str[9]);
			sqlUpdate = c.decrypt(str[10]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		partita(sqlSelect, sqlUpdate);
	}

	public void sconfitta() {
		
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt(str[11]);
			sqlUpdate = c.decrypt(str[12]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		partita(sqlSelect, sqlUpdate);
	}
	
	private void partita(String sqlSelect, String sqlUpdate) {
		try (PreparedStatement selectStatement = conn.prepareStatement(sqlSelect);
				PreparedStatement updateStatement = conn.prepareStatement(sqlUpdate)) {

			selectStatement.setString(1, nomeUtente);
			ResultSet resultSet = selectStatement.executeQuery();

			if (resultSet.next()) {
				updateStatement.setString(1, nomeUtente);
				updateStatement.executeUpdate();
				System.out.println("Partita vinta aggiornata per l'utente " + nomeUtente);
			} else {
				System.out.println("Nessun utente trovato con le credenziali specificate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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


	
	public String getUsername() {
		return nomeUtente;
	}
	
}
