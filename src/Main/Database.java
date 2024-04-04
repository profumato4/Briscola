package Main;

import javax.swing.*;
import java.sql.*;

public class Database {

    private static final String driver = "com.mysql.jdbc.Driver";
    private String username = "briscola_coatdecide";
    private String password = "0beb0a15c71792f79477d657570b96b79aaebc46";
    private String hostname = "z0d.h.filess.io";
    private String port = "3307";
    private String database = "briscola_coatdecide";
    private String url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);;

    private Connection conn;
    private JFrame frame;

    public Database(JFrame frame) throws SQLException, ClassNotFoundException {
        this.frame = frame;
        Class.forName(Database.driver);
        conn = DriverManager.getConnection(url, username, password);
    }

    public void registerUser(String username, String password){
        String sql = "INSERT INTO Giocatori(nomeUtente, password) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try{
                statement.executeUpdate();
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

}
