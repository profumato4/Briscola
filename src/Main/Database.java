package Main;

import javax.swing.*;
import java.sql.*;

public class Database {

	private Crypt c = new Crypt();
	private static final String driver = "com.mysql.jdbc.Driver";
	private final String username;
	private final String password;
	private final String hostname;
	private final String port = "12661";
	private final String database = "defaultdb";
	private final String url;

	private final Connection conn;
	private final JFrame frame;
	private String nomeUtente;

	public Database(JFrame frame) throws Exception {
		this.frame = frame;

		this.password = c.decrypt("Ft61L1/hv+oVs/tRf3KUUZq8c8UYggsilRE3+HNqxTs=");
		this.hostname = c.decrypt("NifeemfRIuvbIyGb5nXEHKaQf15IZTTn8wn9ZD+11YYScFG78W2E1Cm4PTdy2ddB");
		this.username = c.decrypt("iE9Rh3KbaByAWipHE6Pb9w==");

		this.url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);

		Class.forName(Database.driver);
		conn = DriverManager.getConnection(this.url, this.username, this.password);
	}

	public void registerUser(String username, String password) throws SQLException {
		String sql = "INSERT INTO Giocatori(nomeUtente, password) VALUES (?, ?)";
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
		String sql = "SELECT * FROM Giocatori WHERE nomeUtente = ? AND password = ?";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			nomeUtente = username;
			return resultSet.next();
		}
	}

	public void vittoria() {
		String sqlSelect = "SELECT partiteVinte FROM Giocatori WHERE nomeUtente = ? ";
		String sqlUpdate = "UPDATE Giocatori SET partiteVinte = partiteVinte + 1 WHERE nomeUtente = ? ";

		partita(sqlSelect, sqlUpdate);
	}

	public void pareggio() {
		String sqlSelect = "SELECT partitePareggiate FROM Giocatori WHERE nomeUtente = ? ";
		String sqlUpdate = "UPDATE Giocatori SET partitePareggiate = partitePareggiate + 1 WHERE nomeUtente = ? ";

		partita(sqlSelect, sqlUpdate);
	}

	public void sconfitta() {
		String sqlSelect = "SELECT partiteVinte FROM Giocatori WHERE nomeUtente = ? ";
		String sqlUpdate = "UPDATE Giocatori SET partitePerse = partitePerse + 1 WHERE nomeUtente = ? ";

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
	
	public String getUsername() {
		return nomeUtente;
	}

}
