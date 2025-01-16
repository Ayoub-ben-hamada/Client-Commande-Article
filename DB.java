import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect() {
        Connection connection = null; // Initialize connection variable
        try {
            // avoir les inforamtions didentification du connection de la class DatabaseConfiguration
            String jdbcUrl = DatabaseConfiguration.getDbUrl();
            String user = DatabaseConfiguration.getDbUsername();
            String password = DatabaseConfiguration.getDbPassword();
            // Ouvrir la connection
            connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection to the database established successfully!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return connection; // Retourner la connection
    }
}