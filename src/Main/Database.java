package Main;

import javax.swing.*;
import java.sql.*;

public class Database {

    private static final String driver = "com.mysql.jdbc.Driver";
    private String username = "avnadmin";
    private String password = "AVNS_V0tyRfXgvYWgLcsCShd";
    private String hostname = "mysql-3da9912-briscola.a.aivencloud.com";
    private String port = "12661";
    private String database = "defaultdb";
    private String url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);;

    private Connection conn;
    private JFrame frame;

    public Database(JFrame frame) throws SQLException, ClassNotFoundException {
        this.frame = frame;
        Class.forName(Database.driver);
        conn = DriverManager.getConnection(url, username, password);
    }

    public void registerUser(String username, String password) throws SQLException {
        String sql = "INSERT INTO Giocatori(nomeUtente, password) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try{
                statement.executeUpdate();
                JOptionPane.showMessageDialog(frame ,"Utente registrato con successo", "Register",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Utente registrato con successo.");
            }catch (SQLIntegrityConstraintViolationException e){
                JOptionPane.showMessageDialog(frame ,"Utente già registrato", "Register",
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
            return resultSet.next();
        }
    }

    public void disconnect() throws SQLException {
        conn.close();
    }

}
