//Class Controllers pour gerer le fichier fxml de SCene builder 

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private TextField codeArticleField;
    @FXML
    private TextField libelleField;
    @FXML
    private TextField qteField;
    @FXML
    private TextField prixHTField;

    @FXML
    private void handleSubmit() {
        String codeArticle = codeArticleField.getText().trim();
        String libelle = libelleField.getText().trim();
        int qte;
        double prixHT;

        // assurer que les champs sont correctes
        if (codeArticle.isEmpty() || libelle.isEmpty() || qteField.getText().isEmpty() || prixHTField.getText().isEmpty()) {
            showAlert("Erreur", "Tous les champs doivent être remplis.");
            return;
        }

        try {
            qte = Integer.parseInt(qteField.getText());
            prixHT = Double.parseDouble(prixHTField.getText());

            // Creer un nouveau article 
           
            Article newArticle = new Article(codeArticle, libelle, qte, prixHT);
            
            // Ajouter larticle a ma base de donnee
            int result = ArticleDb.add(newArticle);
            if (result != -1) {
                showAlert("Succès", "Article ajouté avec succès, ID: " + result);
                System.out.println("Article ajouté avec succès, ID: " + result);
                
            } else {
                showAlert("Erreur", "Erreur lors de l'ajout de l'article.");
                System.out.println("Erreur lors de l'ajout de l'article.");
            }

            // supprimere les donnees ajoutee par lutilisatuer
            codeArticleField.clear();
            libelleField.clear();
            qteField.clear();
            prixHTField.clear();
        } catch (NumberFormatException ex) {
            showAlert("Erreur", "Veuillez entrer des valeurs valides pour la quantité qui est un entier et le prix. qui esr reel et uitliser le point pas le virgule");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

