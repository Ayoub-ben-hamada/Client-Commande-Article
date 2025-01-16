//interface operation 
import java.sql.Date;

public interface Operation {
    // Méthode pour passer une commande
    void Commander(Date dateCd, String codeArticle, int qte);

    // Méthode pour obtenir le prix de la commande
    void Prix_Commande(double prixTTC, String prixLettre);
}