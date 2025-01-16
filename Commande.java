//Class commande avec ses constructeurs et ses getters
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Commande implements Operation {
    private String numCmd;   // Numéro de commande
    private Date dateCmd;    // Date de la commande
    private double totalHT;   // Total hors taxes
    private double totalTTC;  // Total toutes taxes comprises
    private String codeClient; // Code du client qui a passé la commande
    private List<Article> articles; // Liste des articles dans la commande

    // Constructeur
    public Commande(String numCmd, Date dateCmd, double totalHT, double totalTTC, String codeClient) {
        this.numCmd = numCmd;
        this.dateCmd = dateCmd;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.codeClient = codeClient; // Assignation du code client
        this.articles = new ArrayList<>(); // Initialisation de la liste des articles
    }

    // Méthode pour ajouter un article à la commande
    public void ajouterArticle(Article article) {
        articles.add(article);
    }

    // Implémentation de la méthode Commander de l'interface Operation
    @Override
    public void Commander(Date dateCd, String codeArticle, int qte) {
        // Logique pour passer une commande
        System.out.println("Commande passée : " + qte + " unités de " + codeArticle + " à la date " + dateCd);
        // Vous pouvez également ajouter la logique pour ajouter l'article à la commande ici
    }

    // Implémentation de la méthode Prix_Commande de l'interface Operation
    @Override
    public void Prix_Commande(double prixTTC, String prixLettre) {
        // Logique pour afficher le prix de la commande
        System.out.println("Prix total TTC : " + prixTTC + " (" + prixLettre + ")");
    }

    // Méthode pour afficher les détails de la commande
    public void afficherDetailsCommande() {
        System.out.println("Numéro commande: " + numCmd + ", Date: " + dateCmd + ", Total TTC: " + totalTTC);
    }

    // Méthode pour afficher les commandes d'un client
    public static void Affiche_Commande(List<Commande> commandes, String codeClient) {
        System.out.println("Commandes pour le client : " + codeClient);
        boolean found = false;
        for (Commande cmd : commandes) {
            if (cmd.codeClient.equals(codeClient)) {
                cmd.afficherDetailsCommande();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucune commande trouvée pour le client : " + codeClient);
        }
    }

    // Getters
    public String getNumCmd() {
        return numCmd;
    }

    public Date getDateCmd() {
        return dateCmd;
    }

    public double getTotalTTC() {
        return totalTTC;
    }
    
    public double getTotalHT() {
        return totalHT;
    }

    public List<Article> getArticles() {
        return articles; // Ajout d'un getter pour récupérer la liste des articles
    }
}