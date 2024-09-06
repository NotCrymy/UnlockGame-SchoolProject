package info0202_project.fx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Clément
 */

public class IHMFx extends Application {

    /** name of the FXML file */
    private final String FXML_FILE="mon_interface_FX.fxml";
    /** directory where the FXML file(s) is(are)*/
    private final String FXML_DIR="fxml";

    /** Default constructor on for avoiding documentation warning */
    public IHMFx() {}

    /**
     * Procedure which is automatically called when a FX IHM is launched.
     * 
     * @param primaryStage Stage already initialised by the FX ecosystem
     * @throws Exception Every exceptions that can occur
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Supprimer le fichier gameData.ser au démarrage de l'application
        Path filePath = Paths.get("gameData.ser");
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("unlock.fxml"));
        primaryStage.setTitle("Interface Fx Unlock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        primaryStage.setMinWidth(600); // Définit la largeur minimale à 1300 pixels
        primaryStage.setMinHeight(800); // Définit la hauteur minimale à 1000 pixels
    }
}
