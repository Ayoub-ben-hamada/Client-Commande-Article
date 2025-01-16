//class client avec tous ses methodes et ses getteres et setters
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String codeClient;
    private String rs;
    private String adresse;
    private String telephone;
    private List<Commande> commandes; // Liste des commandes du client

    // Constructeur
    public Client(String codeClient, String rs, String adresse, String telephone) {
        this.codeClient = codeClient;
        this.rs = rs;
        this.adresse = adresse;
        this.telephone = telephone;
        this.commandes = new ArrayList<>(); // Initialisation de la liste des commandes

    }

    // Méthode pour ajouter une commande
    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    // Méthode pour afficher les commandes du client
    public void afficherCommandes() {
        for ( Commande cmd : commandes) {
            cmd.afficherDetailsCommande();
        }
    }

    // Getters
    public String getCodeClient() {
        return codeClient;
    }

    public String getRs() {
        return rs;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }
}