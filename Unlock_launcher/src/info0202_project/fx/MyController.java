package info0202_project.fx;

//MyController.java

import info0202_project.serialization.GameData;
import java.util.Vector;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import javafx.scene.layout.AnchorPane;
import info0202_project.swing.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Clément
 */
public class MyController {
    @FXML
    private SplitPane panneau;

    @FXML
    private AnchorPane zoneDeJeux;
    
    @FXML
    private AnchorPane zoneDeDepot;
    
    @FXML
    public static Carte carte1;
    public static Carte carte2;
    public static Carte carte3;
    public static Carte carte4;
    public static Carte carte5;
    public static Carte carte6;
    public static Carte carte7;
    public static Carte carte8;
    public static Carte carte9;
    public static Carte carte10;
    public static Carte carte11;
    public static Carte carte12;
    public static Carte carte13;
    public static Carte carte14;
    public static Carte carte15;
    public static Carte carte16;
    public static Carte carte17;
    public static Carte carte18;
    public static Carte carte19;
    
    @FXML
    private Vector<Carte> lstCarte = new Vector<Carte>();

    @FXML
    public void initialize() {
        //création de la carte 
        carte1 = new Carte(zoneDeJeux, 1, 21, 23, 35, 11);
        //event moove
        carte1.addEventHandler(MouseEvent.ANY, new Move());
        //ajout à la zone de jeux
        zoneDeJeux.getChildren().add(carte1);
        //ajout à la liste
        lstCarte.add(carte1);
        //initialise la carte en non visible (elle le devient que l'utilisateur fais play)
        carte1.setVisible(false);
        
        carte2 = new Carte(zoneDeJeux, 2, 1, 21, 23, 1);
        carte2.setCercle(2, 18, 178);
        carte2.setCercle(3, 214, 172);
        zoneDeJeux.getChildren().add(carte2);
        carte2.addEventHandler(MouseEvent.ANY, new Move());
        lstCarte.add(carte2);
        carte2.setVisible(false);
        
        carte3 = new Carte(zoneDeJeux, 3, 2, 21, 23, 2);
        carte3.addEventHandler(MouseEvent.ANY, new Move());
        carte3.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange2();
        });
        carte3.setVisible(false);
        carte3.setCercle(10, 146, 167);
        zoneDeJeux.getChildren().add(carte3);
        lstCarte.add(carte3);
        
        carte4 = new Carte(zoneDeJeux, 4, 10, 21, 23, 10);
        carte4.addEventHandler(MouseEvent.ANY, new Move());
        carte4.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange1();
        });
        carte4.setVisible(false); 
        zoneDeJeux.getChildren().add(carte4);
        lstCarte.add(carte4);
        
        carte5 = new Carte(zoneDeJeux, 5, 3, 21, 23, 3);
        carte5.setCercle(5, 27, 116);
        carte5.setCercle(6, 63, 133);
        carte5.setCercle(7, 177, 134);
        carte5.setCercle(8, 214, 115);
        carte5.setCercle(9, 121, 157);
        carte5.addEventHandler(MouseEvent.ANY, new Move());
        carte5.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange2();
        });
        carte5.setVisible(false);
        zoneDeJeux.getChildren().add(carte5);
        lstCarte.add(carte5);
        
        carte6 = new Carte(zoneDeJeux, 6, 5, 21 , 21, 5);
        carte6.addEventHandler(MouseEvent.ANY, new Move());
        carte6.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange8();
        });
        carte6.setVisible(false); 
        zoneDeJeux.getChildren().add(carte6);
        lstCarte.add(carte6);
        
        carte7 = new Carte(zoneDeJeux, 7, 6, 21, 21, 6);
        carte7.addEventHandler(MouseEvent.ANY, new Move());
        carte7.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange8();
        });
        carte7.setVisible(false); 
        zoneDeJeux.getChildren().add(carte7);
        lstCarte.add(carte7);
        
        carte8 = new Carte(zoneDeJeux, 8, 7, 21, 21, 7);
        carte8.addEventHandler(MouseEvent.ANY, new Move());
        carte8.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange8();
        });
        carte8.setVisible(false); 
        zoneDeJeux.getChildren().add(carte8);
        lstCarte.add(carte8);
        
        carte9 = new Carte(zoneDeJeux, 9, 8, 21, 21, 8);
        carte9.addEventHandler(MouseEvent.ANY, new Move());
        carte9.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange8();
        });
        carte9.setVisible(false); 
        zoneDeJeux.getChildren().add(carte9);
        lstCarte.add(carte9);
        
        carte10 = new Carte(zoneDeJeux, 10, 9, 21, 21, 9);
        carte10.addEventHandler(MouseEvent.ANY, new Move());
        carte10.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange8();
        });
        carte10.setVisible(false); 
        zoneDeJeux.getChildren().add(carte10);
        lstCarte.add(carte10);
        
        carte11 = new Carte(zoneDeJeux, 11, 21, 21, 21, 21);
        carte11.addEventHandler(MouseEvent.ANY, new Move());
        carte11.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange3();
        });
        carte11.setVisible(false); 
        zoneDeJeux.getChildren().add(carte11);
        lstCarte.add(carte11);
        
        carte12 = new Carte(zoneDeJeux, 12, 16, 21, 21, 16);
        carte12.setCercle(17, 33, 153);
        carte12.setCercle(12, 200, 151);
        carte12.addEventHandler(MouseEvent.ANY, new Move());
        carte12.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange2();
        });
        carte12.setVisible(false); 
        zoneDeJeux.getChildren().add(carte12);
        lstCarte.add(carte12);
        
        carte13 = new Carte(zoneDeJeux, 13, 12, 21, 21, 12);
        carte13.setCercle(13, 34, 168);
        carte13.setCercle(14, 181, 121);
        carte13.setCercle(15, 220, 124);
        carte13.addEventHandler(MouseEvent.ANY, new Move());
        carte13.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange4();
        });
        carte13.setVisible(false); 
        zoneDeJeux.getChildren().add(carte13);
        lstCarte.add(carte13);
        
        carte14 = new Carte(zoneDeJeux, 14, 13, 21, 21, 13);
        carte14.addEventHandler(MouseEvent.ANY, new Move());
        carte14.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange5();
        });
        carte14.setVisible(false); 
        zoneDeJeux.getChildren().add(carte14);
        lstCarte.add(carte14);
        
        carte15 = new Carte(zoneDeJeux, 15, 14, 21, 21, 14);
        carte15.addEventHandler(MouseEvent.ANY, new Move());
        carte15.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange5();
        });
        carte15.setVisible(false); 
        zoneDeJeux.getChildren().add(carte15);
        lstCarte.add(carte15);
        
        carte16 = new Carte(zoneDeJeux, 16, 15, 21, 21, 15);
        carte16.addEventHandler(MouseEvent.ANY, new Move());
        carte16.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange5();
        });
        carte16.setVisible(false); 
        zoneDeJeux.getChildren().add(carte16);
        lstCarte.add(carte16);
        
        carte17 = new Carte(zoneDeJeux, 17, 17, 21, 21, 17);
        carte17.addEventHandler(MouseEvent.ANY, new Move());
        carte17.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange4();
        });
        carte17.setVisible(false); 
        zoneDeJeux.getChildren().add(carte17);
        lstCarte.add(carte17);
        
        carte18 = new Carte(zoneDeJeux, 18, 28, 21, 21, 28);
        carte18.addEventHandler(MouseEvent.ANY, new Move());
        carte18.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange6();
        });
        carte18.setVisible(false); 
        zoneDeJeux.getChildren().add(carte18);
        lstCarte.add(carte18);
        
        carte19 = new Carte(zoneDeJeux, 19, 49, 21, 21, 49);
        carte19.addEventHandler(MouseEvent.ANY, new Move());
        carte19.visibleProperty().addListener((observable, oldValue, newValue) -> {
            handleVisibilityChange7();
        });
        carte19.setVisible(false); 
        zoneDeJeux.getChildren().add(carte19);
        lstCarte.add(carte19);
        
        // démarrer la surveillance périodique du fichier gameData.ser
        startFileWatcher();
    }
    
    private void startFileWatcher() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkGameDataFile();
            }
        }, 0, 1000); // vérifie toutes les secondes
    }
    
    private void checkGameDataFile() {
        Path filePath = Paths.get("gameData.ser");
        if (Files.exists(filePath)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("gameData.ser"))) {
                GameData savedGameData = (GameData) ois.readObject();
                if (savedGameData.isGameStarted()) {
                    // met à jour l'IHM pour rendre les cartes visibles
                    Platform.runLater(() -> {
                        carte1.setVisible(true);
                        carte2.setVisible(true);
                    });
                } else {
                    // met à jour l'IHM pour rendre les cartes non visibles
                    Platform.runLater(() -> {
                        carte1.setVisible(false);
                        carte2.setVisible(false);
                        //si il y a d'autres actions à faire
                    });
                }
            } catch (Exception ex) {
            }
        }
    }

    private void handleVisibilityChange1() {
        // verifiez si la cartes 4 est visibles
        if (carte4.isVisible()) {
            // déplace la carte 3 vers la zone de dépôt
            moveToDepot(carte3);
        }
    }
    
    private void handleVisibilityChange2() {
        // verifiez si la cartes 4 est visibles
        if (carte3.isVisible() && carte5.isVisible()) {
            // déplace la carte 3 vers la zone de dépôt
            moveToDepot(carte1);
            moveToDepot(carte2);
        }
    }
    
    private void handleVisibilityChange3() {
        Platform.runLater(() -> {
            // vérifiez si les cartes 11 et 12 sont visibles
            if (carte11.isVisible() && carte12.isVisible()) {
                // déplacez les cartes 4 à 10 vers la zone de dépôt
                moveToDepot(carte4);
                moveToDepot(carte6);
                moveToDepot(carte7);
                moveToDepot(carte8);
                moveToDepot(carte9);
                moveToDepot(carte10);
            }
        });
    }
    
    private void handleVisibilityChange4() {
        // verifiez si la cartes 13 et 17 est visibles
        if (carte13.isVisible() && carte17.isVisible()) {
            // déplace la carte 12 vers la zone de dépôt
            moveToDepot(carte12);
        }
    }
    
    private void handleVisibilityChange5() {
        // verifiez si la cartes 14 à 16 est visibles
        if (carte14.isVisible() && carte15.isVisible() && carte16.isVisible()) {
            // déplace la carte 13 vers la zone de dépôt
            moveToDepot(carte13);
        }
    }
    
    private void handleVisibilityChange6() {
        // verifiez si la cartes 18 est visibles
        Platform.runLater(() -> {
            if (carte18.isVisible()) {
                // déplace la carte 14 à 16 vers la zone de dépôt
                moveToDepot(carte14);
                moveToDepot(carte15);
                moveToDepot(carte16);
            }
        });
    }
    
    private void handleVisibilityChange7() {
        Platform.runLater(() -> {
            // verifiez si la cartes 19 est visibles
            if (carte19.isVisible()) {
                // déplace la carte 11,17,18 vers la zone de dépôt
                moveToDepot(carte11);
                moveToDepot(carte17);
                moveToDepot(carte18);
                IHMSwing.boutonsPanel.setVisible(true);
                IHMSwing.boutonAction1.setEnabled(true);
                IHMSwing.boutonAction2.setEnabled(true);
                IHMSwing.boutonAction3.setEnabled(true);
                IHMSwing.boutonAction4.setEnabled(true);
            }
        });
    }
    
    private void handleVisibilityChange8() {
        // verifiez si la cartes 14 à 16 est visibles
        if (carte6.isVisible() && carte7.isVisible() && carte8.isVisible() && carte9.isVisible() && carte10.isVisible()) {
            // déplace la carte 13 vers la zone de dépôt
            moveToDepot(carte5);
        }
    }
    
    public class Move implements EventHandler<MouseEvent> {
        private double dragX;
        private double dragY;
            
        @Override
        public void handle(MouseEvent t){
            Carte a = (Carte)(t.getSource());
            if(t.getButton() == MouseButton.PRIMARY){
                if(t.getEventType() == MOUSE_PRESSED){
                    dragX= t.getScreenX() - ((ImageView)t.getSource()).getTranslateX();
                    dragY= t.getScreenY() - ((ImageView)t.getSource()).getTranslateY();
                }
                else if(t.getEventType() == MOUSE_DRAGGED){
                    ((ImageView)t.getSource()).translateXProperty().set(t.getScreenX()-dragX);
                    ((ImageView)t.getSource()).translateYProperty().set(t.getScreenY()-dragY);
                }
                else if(t.getEventType() == MOUSE_CLICKED){ 
                    System.out.println(t.getX());
                    System.out.println(t.getY());
                    
                    for (CercleCliquable cercle : a.getCercles()) {
                        if (cercle.isInside(t.getX(), t.getY())) {
                            int numeroCarte = cercle.getNumero();
                            for(Carte c : lstCarte){
                                if(c.getNumeroCarte() == numeroCarte){
                                    c.setVisible(true);
                                    System.out.println("Carte " + numeroCarte + " apparue !");
                                }else {
                                    System.out.println("carte non conforme au numero");
                                }   
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void moveToDepot(Carte carte) {
        // Déplace la carte vers la zone de dépôt
        // Supprime la carte de la zone de jeux
        zoneDeJeux.getChildren().remove(carte);
        zoneDeDepot.getChildren().add(carte);
    }
}