//Class pour pouvoir connecter a ma base de donner notez bien que les donnes et les propieretes de la base de donnee sont ecrit dans une fichier Db.properties 
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfiguration {
    private static final Properties properties = new Properties();
    static {
        try (InputStream input = DatabaseConfiguration.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Error: db.properties file not found");
                System.exit(1);
            }
            // Load the properties file
            properties.load(input);
            System.out.println("Properties loaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}