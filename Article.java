//class article avec tous ses constructeurs getters et setters et ses methodes 
import java.sql.Date;
import java.util.List;

public class Article {
    private String codeArticle; // Code de l'article
    private String libelle;     // Libellé de l'article
    private int qte;           // Quantité commandée
    private double prixHT;     // Prix hors taxes

    // Constructeur
    public Article(String codeArticle, String libelle, int qte, double prixHT) {
        this.codeArticle = codeArticle;
        this.libelle = libelle;
        this.qte = qte;
        this.prixHT = prixHT;
    }

    // Méthode pour afficher les détails de l'article
    public void afficherDetailsArticle() {
        System.out.println("Libellé: " + libelle + ", Quantité: " + qte + ", Total HT: " + (qte * prixHT));
    }

    // Méthode pour afficher tous les articles commandés par un client à une date donnée
    public static void Affiche_Article(List<Commande> commandes, String codeClient, Date date, String codeArticle) {
        boolean found = false;
        System.out.println("Articles commandés par le client " + codeClient + " à la date " + date + " avec le code article " + codeArticle + ":");
        for (Commande cmd : commandes) {
            if (cmd.getDateCmd().equals(date) && cmd.getNumCmd().contains(codeClient)) { // Vérifiez si la commande correspond au client et à la date
                for (Article article : cmd.getArticles()) { // Utilisation de getArticles() pour récupérer les articles
                    if (article.getCodeArticle().equals(codeArticle)) {
                        article.afficherDetailsArticle();
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println(" Aucun article trouvé pour le client " + codeClient + " à la date " + date + " avec le code article " + codeArticle);
        }
    }

    // Getters
    public String getCodeArticle() {
        return codeArticle;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getQte() {
        return qte;
    }

    public double getPrixHT() {
        return prixHT;
    }
    // Setters
    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }
    

}