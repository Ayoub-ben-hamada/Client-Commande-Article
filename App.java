//cette classe vous donne un menu en lutilisant vous pouvez ajouter, voir , trouver ,supprimer et modifier les articles dans ma base de donnée
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Article");
            System.out.println("2. View All Articles");
            System.out.println("3. Find Article by Code");
            System.out.println("4. Update Article");
            System.out.println("5. Delete Article");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Article
                    System.out.print("Enter code article: ");
                    String codeArticle = scanner.nextLine();
                    System.out.print("Enter libelle: ");
                    String libelle = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int qte = scanner.nextInt();
                    System.out.print("Enter price HT: ");
                    double prixHT = scanner.nextDouble();
                    Article newArticle = new Article(codeArticle, libelle, qte, prixHT);
                    int addedId = ArticleDb.add(newArticle); // Call the static method directly
                    if (addedId != -1) {
                        System.out.println("Article added successfully with ID: " + addedId);
                    } else {
                        System.out.println("Failed to add article.");
                    }
                    break;

                case 2:
                    // View All Articles
                    List<Article> articles = ArticleDb.findAll(); // Call the static method directly
                    System.out.println("All Articles:");
                    for (Article article : articles) {
                        System.out.println("Code: " + article.getCodeArticle() + ", Libelle: " + article.getLibelle() +
                                ", Quantity: " + article.getQte() + ", Price HT: " + article.getPrixHT());
                    }
                    break;

                case 3:
                    // Find Article by Code
                    System.out.print("Enter code article to find: ");
                    String searchCode = scanner.nextLine();
                    Article foundArticle = ArticleDb.findById(searchCode); // Call the static method directly
                    if (foundArticle != null) {
                        System.out.println("Found Article: Code: " + foundArticle.getCodeArticle() +
                                ", Libelle: " + foundArticle.getLibelle() +
                                ", Quantity: " + foundArticle.getQte() +
                                ", Price HT: " + foundArticle.getPrixHT());
                    } else {
                        System.out.println("Article not found.");
                    }
                    break;

                case 4:
                    // Update Article
                    System.out.print("Enter code article to update: ");
                    String updateCode = scanner.nextLine();
                    Article articleToUpdate = ArticleDb.findById(updateCode); // Call the static method directly
                    if (articleToUpdate != null) {
                        System.out.print("Enter new libelle: ");
                        String newLibelle = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        int newQte = scanner.nextInt();
                        System.out.print("Enter new price HT: ");
                        double newPrixHT = scanner.nextDouble();
                        articleToUpdate.setLibelle(newLibelle);
                        articleToUpdate.setQte(newQte);
                        articleToUpdate.setPrixHT(newPrixHT);
                        int updatedRows = ArticleDb.update(articleToUpdate); // Call the static method directly
                        if (updatedRows > 0) {
                            System.out.println("Article updated successfully.");
                        } else {
                            System.out.println("Failed to update article.");
                        }
                    } else {
                        System.out.println("Article not found.");
                    }
                    break;

                case 5:
                    // Delete Article
                    System.out.print("Enter code article to delete: ");
                    String deleteCode = scanner.nextLine();
                    int deletedRows = ArticleDb.delete(deleteCode); // Call the static method directly
                    if (deletedRows > 0) {
                        System.out.println("Article deleted successfully.");
                    } else {
                        System.out.println("Failed to delete article.");
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
