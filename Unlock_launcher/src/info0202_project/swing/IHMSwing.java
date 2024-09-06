package info0202_project.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import info0202_project.serialization.GameData;
import info0202_project.fx.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javafx.application.Platform;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;


/**
 *
 * 
 * @author Clément
 */
public class IHMSwing extends JFrame  implements Runnable {
    // Attributs
    private TimerController timerController;
    private HintController hintController;

    private JLabel label_temps;
    private JButton playButton;
    private JButton pauseButton;
    private JButton hintButton; 
    private JLabel hintLabel;
    
    //Attributs des actions 
    private final JPanel actionsPanel;
    public static JButton boutonAction1;
    public static JButton boutonAction2;
    public static JButton boutonAction3;
    public static JButton boutonAction4; 
    private JTextField numberField;
    public static JPanel boutonsPanel;
    
    //Attribut du délais de réactivation des boutons 
    private static final int delais = 1000;
    
    //Attributs pour la sérialization 
    private GameData gameData = new GameData(false);

    public IHMSwing() {
        // Initialisation du panneau principal
        JPanel panneau = new JPanel(new BorderLayout());

        // Gestion du timer 
        timerController = new TimerController(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempsRestant = timerController.getTemps();
                label_temps.setText(Integer.toString(tempsRestant));

                // vérifie si le temps est écoulé
                if (tempsRestant <= 0) {
                    // désactiver tous les boutons 
                    playButton.setEnabled(true);
                    pauseButton.setEnabled(false);
                    hintButton.setEnabled(false);
                    boutonAction1.setEnabled(false);
                    boutonAction2.setEnabled(false);
                    boutonAction3.setEnabled(false);
                    boutonAction4.setEnabled(false);
                    numberField.setEnabled(false);

                    // arret du timer
                    timerController.pauseTimer();

                    // affiche un message quand le temps est finit
                    JOptionPane.showMessageDialog(IHMSwing.this, "Game over ! ", "Fin", JOptionPane.INFORMATION_MESSAGE);
                    IHMSwing.this.dispose(); // ferme la fenêtre principale
                    Platform.exit(); // Ferme l'application JavaFX
                }
            }
        });
        
        hintController = new HintController();

        label_temps = new JLabel(Integer.toString(timerController.getTemps()));
        label_temps.setHorizontalAlignment(JLabel.CENTER); 
        JPanel buttonsPanel = new JPanel();

        // Bouton PLAY
        playButton = new JButton("PLAY");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // créer l'objet GameData pour marquer le début de la partie
                if(!gameData.isGameStarted()){
                    gameData.setGameStarted(true);
                    // sérialise l'objet dans un fichier
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("gameData.ser"))) {
                        oos.writeObject(gameData);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erreur de lancement... En attente", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }

                timerController.startTimer();
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                hintButton.setEnabled(true);
                boutonAction1.setEnabled(true);
                boutonAction2.setEnabled(true);
                boutonAction3.setEnabled(true);
                boutonAction4.setEnabled(true);
                numberField.setEnabled(true);
            }
        });

        // Bouton PAUSE
        pauseButton = new JButton("PAUSE");
        pauseButton.setEnabled(false);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerController.pauseTimer();
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                hintButton.setEnabled(false); 
                boutonAction1.setEnabled(false);
                boutonAction2.setEnabled(false);
                boutonAction3.setEnabled(false);
                boutonAction4.setEnabled(false);
                numberField.setEnabled(false);
            }
        });

        // Bouton INDICE
        hintButton = new JButton("INDICE");
        hintButton.setEnabled(false);
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hintController.hintverifier();
                hintLabel.setText("<html>" + hintController.getHint() + "</html>"); //fais en sorte de revenir à la ligne quand le text est trop grand
            }
        });

        //pannel des boutons play / pause / hint
        buttonsPanel.add(playButton);
        buttonsPanel.add(pauseButton);
        buttonsPanel.add(hintButton);

        //font des boutons
        hintLabel = new JLabel("L'indice apparaîtra ici"); 
        hintLabel.setPreferredSize(new Dimension(200, hintLabel.getPreferredSize().height)); 
        hintLabel.setHorizontalAlignment(JLabel.LEFT);
        hintLabel.setFont(new Font("Arial", Font.BOLD, 15)); 

        label_temps.setHorizontalAlignment(JLabel.CENTER);
        label_temps.setFont(new Font("Arial", Font.BOLD, 20)); 
        label_temps.setPreferredSize(new Dimension(200, 100)); 
        
        //placement des boutons
        panneau.add(label_temps, BorderLayout.NORTH);
        panneau.add(buttonsPanel, BorderLayout.SOUTH);

        // initialisation du panneau principal , action ect...
        JPanel boutonsActionsPanel = new JPanel(new GridLayout(4, 1));
        actionsPanel = new JPanel(new BorderLayout());
        
        //initialise les boutons
        boutonAction1 = new JButton("Levier 1");
        boutonAction2 = new JButton("Levier 2");
        boutonAction3 = new JButton("Levier 3");
        boutonAction4 = new JButton("Levier 4");
        
        //initialise le textefield
        numberField = new JTextField();
        numberField.setEnabled(false);
        numberField.setPreferredSize(new Dimension(130, 30));
        numberField.setText("Rentrer un numéro ici");
        
        // initialise le label d'erreur
        JLabel errorLabel = new JLabel("");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //pannel des boutons d'action
        boutonsPanel = new JPanel(new GridLayout(1, 4)); // gridLayout avec 1 ligne - 4 colonnes
        boutonsPanel.add(boutonAction1);
        boutonsPanel.add(boutonAction2);
        boutonsPanel.add(boutonAction3);
        boutonsPanel.add(boutonAction4);
        boutonsActionsPanel.add(boutonsPanel);
        boutonsPanel.setVisible(false);
        
        // ajout du number field sur la deuxième ligne
        boutonsActionsPanel.add(numberField);
        numberField.setHorizontalAlignment(JTextField.CENTER); // centrage horizontal du texte dans le JTextField
        
        // ajout du hint label sur la troisième ligne
        boutonsActionsPanel.add(hintLabel);
        hintLabel.setHorizontalAlignment(SwingConstants.CENTER); // centrage horizontal du label
        
        //ajout du label des erreurs sur la 5ème ligne 
        boutonsActionsPanel.add(errorLabel);

        
        //placement des boutons 
        actionsPanel.add(boutonsActionsPanel, BorderLayout.CENTER);
        
        //désactive les boutons au départ
        boutonAction1.setEnabled(false);
        boutonAction2.setEnabled(false);
        boutonAction3.setEnabled(false);
        boutonAction4.setEnabled(false);
        
        //boutonAction1 bouton de fin de partie
        boutonAction1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action à faire
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                hintButton.setEnabled(false);
                boutonAction1.setEnabled(false);
                boutonAction2.setEnabled(false);
                boutonAction3.setEnabled(false);
                boutonAction4.setEnabled(false);

                // arret du timer
                timerController.resetTimer();
                timerController.pauseTimer();

                // affiche un message quand la partie est finit
                JOptionPane.showMessageDialog(IHMSwing.this, "Bravo ! Partie gagné !", "Fin", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //bouton d'action 2 (bouton de malus)
        boutonAction2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action à faire
                HologramPostAction actionHologram2 = new HologramPostAction();
                if(timerController.getTemps()>30){
                    actionHologram2.malus(30, timerController);
                    errorLabel.setText("Mauvais levier - malus de 30 sec !");
                } else {
                    actionHologram2.malus(timerController.getTemps()-1, timerController);
                    errorLabel.setText("Mauvais levier - partie perdue !");
                }
                
                // Désactive le bouton temporairement pour que l'utilisateur ne spam pas 
                boutonAction2.setEnabled(false);
                Timer timer = new Timer(delais, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        boutonAction2.setEnabled(true); 
                    }
                });
                timer.setRepeats(false); 
                timer.start(); 
            }
        });
        
        //3ème bouton d'action (bouton de malus)
        boutonAction3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action à faire
                HologramPostAction actionHologram3 = new HologramPostAction();
                if(timerController.getTemps()>30){
                    actionHologram3.malus(30, timerController);
                    errorLabel.setText("Mauvais levier - malus de 30 sec !");
                } else {
                    actionHologram3.malus(timerController.getTemps()-1, timerController);
                    errorLabel.setText("Mauvais levier - partie perdue !");
                }
                
                // Désactive le bouton temporairement pour que l'utilisateur ne spam pas 
                boutonAction3.setEnabled(false);
                Timer timer = new Timer(delais, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        boutonAction3.setEnabled(true); 
                    }
                });
                timer.setRepeats(false); 
                timer.start(); 
            }
        });
        
        //4ème bouton d'action (bouton de malus)
        boutonAction4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // action à faire
                HologramPostAction actionHologram4 = new HologramPostAction();
                if(timerController.getTemps()>30){
                    actionHologram4.malus(30, timerController);
                    errorLabel.setText("Mauvais levier - malus de 30 sec !");
                } else {
                    actionHologram4.malus(timerController.getTemps()-1, timerController);
                    errorLabel.setText("Mauvais levier - partie perdue !");
                }
                
                // Désactive le bouton temporairement pour que l'utilisateur ne spam pas 
                boutonAction4.setEnabled(false);
                Timer timer = new Timer(delais, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        boutonAction4.setEnabled(true); 
                    }
                });
                timer.setRepeats(false); 
                timer.start(); 
            }
        });
        
        numberField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                // vérifie si entré est enfoncé
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    validateInput();
                }
            }
            
            //valide l'entré
            private void validateInput() {
                String text = numberField.getText();
                try {
                    int number = Integer.parseInt(text);
                    if (number < 1 || number > 100) {
                        // vérifie le numéro rentré
                        System.out.println("Numero faux");
                        errorLabel.setText("Numéro faux (doit être entre 1 et 100)");
                        numberField.setText("");
                    } else if(number == 16 && MyController.carte5.isVisible() && MyController.carte6.isVisible() && MyController.carte7.isVisible() && MyController.carte8.isVisible() && MyController.carte9.isVisible() && MyController.carte10.isVisible() && MyController.carte4.isVisible()) {
                        System.out.println("Numero bon");
                        errorLabel.setText("Numéro correct !");
                        MyController.carte11.setVisible(true);
                        MyController.carte12.setVisible(true);
                    } else if(number == 28 && MyController.carte14.isVisible() && MyController.carte15.isVisible() && MyController.carte16.isVisible()) {
                        System.out.println("Numero bon");
                        errorLabel.setText("Numéro correct !");
                        MyController.carte18.setVisible(true);
                    } else if(number == 49 && MyController.carte11.isVisible() && MyController.carte18.isVisible()) {
                        System.out.println("Numero bon");
                        errorLabel.setText("Numéro correct !");
                        MyController.carte19.setVisible(true);
                    } else if (number > 1 || number < 100) {
                        System.out.println("Numero faux");
                        errorLabel.setText("Mauvais numéro !");
                        HologramPostAction badNumber = new HologramPostAction();
                        if(timerController.getTemps()>30){
                            badNumber.malus(30, timerController);
                            errorLabel.setText("Mauvais numéro - malus de 30 sec !");
                        } else {
                            badNumber.malus(timerController.getTemps()-1, timerController);
                            errorLabel.setText("Mauvais numéro - partie perdue !");
                        }
                    }
                } catch (NumberFormatException ex) {
                    // efface si l'utilisateur rentre quelque chose d'erroné
                    System.out.println("pas un numero");
                    errorLabel.setText("erreur : doit un être un numéro entre 1 et 100");
                    numberField.setText("");
                }
            }
        });
        
        // ajout du panneau des actions au panneau principal
        panneau.add(actionsPanel, BorderLayout.CENTER);

        // ajout du panneau principal à la fenêtre
        getContentPane().add(panneau);

        // derniers paramètres de la fenêtre
        setTitle("Interface Swing Unlock");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //setteurs pour les couleurs
        
        //panneau principal
        panneau.setBackground(Color.BLACK);
        
        //panneau du temps
        buttonsPanel.setBackground(Color.BLACK);
        
        //panneau des actions
        boutonsActionsPanel.setBackground(Color.BLACK);
        boutonsActionsPanel.setForeground(Color.WHITE);
        
        //le number field
        numberField.setBackground(Color.BLACK);
        numberField.setForeground(Color.WHITE);

        // Label temps
        label_temps.setForeground(Color.WHITE);

        // Label hintLabel
        hintLabel.setOpaque(true);
        hintLabel.setBackground(Color.BLACK);
        hintLabel.setForeground(Color.WHITE);

        // Label errorLabel
        errorLabel.setOpaque(true);
        errorLabel.setBackground(Color.BLACK);
        errorLabel.setForeground(Color.WHITE);

        // Boutons
        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);

        pauseButton.setBackground(Color.BLACK);
        pauseButton.setForeground(Color.WHITE);

        hintButton.setBackground(Color.BLACK);
        hintButton.setForeground(Color.WHITE);

        boutonAction1.setBackground(Color.BLACK);
        boutonAction1.setForeground(Color.WHITE);

        boutonAction2.setBackground(Color.BLACK);
        boutonAction2.setForeground(Color.WHITE);

        boutonAction3.setBackground(Color.BLACK);
        boutonAction3.setForeground(Color.WHITE);

        boutonAction4.setBackground(Color.BLACK);
        boutonAction4.setForeground(Color.WHITE);
    } 

    @Override
    public void run() {
        // créer une instance de l'IHMSwing
        IHMSwing ihmswing = new IHMSwing();

        // rend la fenêtre visible
        ihmswing.setVisible(true);
    }
}

