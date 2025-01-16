//Class MAin que l'on utlise pour ouvrir linterface en appuyant sur Run dans la methode main
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("saisieArticle.fxml"));
        Parent root = loader.load();
        
        
        primaryStage.setTitle("Saisie d'Article ");
        primaryStage.setScene(new Scene(root, 400, 600)); // Ajustez la taille selon vos besoins
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}