//Class AricleDb qui permet l ajout la modification la supression et vous permet aussi de voir les articles  et trouver la base de la base de donnee creer avec mysql server
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDb {

    // Method pour ajouter des articles
    public static int add(Article article) {
        String sql = "INSERT INTO articles (code_article, libelle, qte, prix_ht) VALUES (?, ?, ?, ?)";
        try (Connection connection = DB.connect()) {
            if (connection != null) {
                PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                // donner les valeurs
                pstmt.setString(1, article.getCodeArticle());
                pstmt.setString(2, article.getLibelle());
                pstmt.setInt(3, article.getQte());
                pstmt.setDouble(4, article.getPrixHT());

                // Executer le "inserted statement" et avoir lid donnée
                int insertedRow = pstmt.executeUpdate();
                if (insertedRow > 0) {
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            return rs.getInt(1); // retourner lid ajouter (ID)
                        }
                    }
                }
            } else {
                System.err.println("Connection is null. Cannot add article.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding article: " + e.getMessage());
        }
        return -1; //retourner -1 si id donne nest pas valide
    }

    // Methode pour voir tous les articles de la base de données
    public static List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM articles ORDER BY code_article";
        try (Connection connection = DB.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String codeArticle = rs.getString("code_article");
                String libelle = rs.getString("libelle");
                int qte = rs.getInt("qte");
                double prixHT = rs.getDouble("prix_ht");
                articles.add(new Article(codeArticle, libelle, qte, prixHT));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving articles: " + e.getMessage());
        }
        return articles;
    }

    // Methode pour trouver larticle 
    public static Article findById(String codeArticle) {
        String sql = "SELECT * FROM articles WHERE code_article = ?";
        try (Connection connection = DB.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, codeArticle);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Article(
                    rs.getString("code_article"),
                    rs.getString("libelle"),
                    rs.getInt("qte"),
                    rs.getDouble("prix_ht")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving article: " + e.getMessage());
        }
        return null; // retourner null si larticle nest pas trouve
    }

    // Methode pour modifer larticle
    public static int update(Article article) {
        String sql = "UPDATE articles SET libelle = ?, qte = ?, prix_ht = ? WHERE code_article = ?";
        int affectedRows = 0;
        try (Connection connection = DB.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, article.getLibelle());
            pstmt.setInt(2, article.getQte());
            pstmt.setDouble(3, article.getPrixHT());
            pstmt.setString(4, article.getCodeArticle());
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating article: " + e.getMessage());
        }
        return affectedRows; // retourner le nombre de lignes affectees
    }

    // Methode pour supprimer larticle
    public static int delete(String codeArticle) {
        String sql = "DELETE FROM articles WHERE code_article = ?";
        try (Connection connection = DB.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, codeArticle);
            return pstmt.executeUpdate(); // retourner le nombre de ligne supprimees
        } catch (SQLException e) {
            System.err.println("Error deleting article: " + e.getMessage());
        }
        return 0; // retounrer 0 si les articles ne sont pas trouvee
    }
}    