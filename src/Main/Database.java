package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
		String sql = "";
		try {
			sql = c.decrypt("+dHZdZi3wTfu5JkSZBcDXSZtTgyRahoSCjYD9sOZKNXSnuYBWeVE6+RWaSj8jZYEBtTTj8aSwlGlvPkFuD3I1A==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			sql = c.decrypt("V/oqa+p2HWbJ0/H/K9zFl9GL8lGLIEgBQ9fiAiYz1jUmJ8fjMMJ45T95n42Bh/Rjk/n52GI0wXbUTPUi2OnRYQ==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			sqlSelect = c.decrypt("XYiNfUid34RXhoBal0waxryHHlV6sRxTcvmzKs1ETMqNjLJWeh/Kfr/DIkhdyI3CJgZA22Bj+wki2iEJ1/kj0g==");
			sqlUpdate = c.decrypt("vj7LBgmyhCZau2N8VcyVeN7lmbuva/9+nVI9MmDEaBTXyKryyRGfOApYAOtu1plBb83foWOORytGSdBu340s69l61npsrUQwedzOW5wN1ak=");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		partita(sqlSelect, sqlUpdate);
	}

	public void pareggio() {
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt("lVv2O/FhVbfQnHmebdmxh3XdTlrLwmeIV2Ms6+UlFibRi/JRiyBIAUPX4gImM9Y1R3KFt0mJ7jAqaY9qLqIUqw==");
			sqlUpdate = c.decrypt("vj7LBgmyhCZau2N8VcyVeGvDeaSNsF1j492acoaLkx3viRrLREdTYJ7ofvaeKDOwuuyUThq1+tDcD2cKa7KhWejXOUykrBxlSlpLwpb7oZVMWGpDDH+fjDEV+8I1exOs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		partita(sqlSelect, sqlUpdate);
	}

	public void sconfitta() {
		
		String sqlSelect = "";
		String sqlUpdate = "";
		try {
			sqlSelect = c.decrypt("XYiNfUid34RXhoBal0waxryHHlV6sRxTcvmzKs1ETMqNjLJWeh/Kfr/DIkhdyI3CJgZA22Bj+wki2iEJ1/kj0g==");
			sqlUpdate = c.decrypt("vj7LBgmyhCZau2N8VcyVeHaH3DnnIN6hpjHWY/zLekhtQqXS4eYc3pepAd8uvnvQb83foWOORytGSdBu340s69l61npsrUQwedzOW5wN1ak=");
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
	
	public ArrayList<String> topPlayers(){
		ArrayList<String> nomi = new ArrayList<>();
		String sql = "";
		try {
			sql = c.decrypt("CcLMli8Bzlglq3TWLC8/ptzrG33nmJMTw4VDmehZRdUVDCzncDQ7g3d9rKoQa6e46Nc5TKSsHGVKWkvClvuhlQMiCgFUCwEwaUg5G5eFwdUEeK5BMk8nVapCJNatKzpWWTBCSlmcH/2vztPZ1f7MZg==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String username = resultSet.getString("nomeUtente");
				nomi.add(username);
				int gamesWon = resultSet.getInt("partiteVinte");
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nomi;
	}
	
	public String getUsername() {
		return nomeUtente;
	}
	
}
