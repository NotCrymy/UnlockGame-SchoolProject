/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info0202_project.swing;

import info0202_project.swing.*;
import info0202_project.fx.*;

/**
 *
 * @author Clément
 */
public class HintController {
    private String hint;
    
    String hint1 = "Les indices apparaissent ici ";
    
    public HintController() {
        this.hint = hint1;
    }    
    
    public String getHint() {
        return this.hint;
    }

    public void setHint(String hint){
        this.hint = hint;
    }
    
    public void hintverifier(){
        if(!MyController.carte3.isVisible()){
            setHint("Clicker sur un cercle pour dévérouiller une salle.");
        }
        else if(!MyController.carte4.isVisible()){
            setHint("Regarder sur le bureau.");
        }
        else if(!MyController.carte5.isVisible()){
            setHint("Clicker sur un cercle pour dévérouiller une salle.");
        }
        else if(!MyController.carte6.isVisible() || !MyController.carte7.isVisible() || !MyController.carte8.isVisible() || !MyController.carte9.isVisible()){
            setHint("Clicker sur les cercles pour se rapprocher des pistons.");
        }
        else if(!MyController.carte10.isVisible()){
            setHint("Clicker sur le cercle pour vous rapprocher de la porte.");
        }
        else if(!MyController.carte11.isVisible()){
            setHint("Il y a sûrment un levier à réactiver... Relisez la note du capitaine et quand vous aurez trouver, rentrez le code sur l'application.");
        }
        else if(!MyController.carte13.isVisible()){
            setHint("Clicker sur un cercle pour dévérouiller une salle.");
        }
        else if(!MyController.carte14.isVisible() || !MyController.carte15.isVisible() || !MyController.carte16.isVisible()){
            setHint("Clicker sur les cercles se rapprocher des objets.");
        }
        else if(!MyController.carte18.isVisible()){
            setHint("Ces objets semblent avoir un lien... En regardant les bocaux de plus près, vous voyez que l'un d'eux pourrais agiter son contenu.");
        }
        else if(!MyController.carte17.isVisible()){
            setHint("Clicker sur un cercle pour dévérouiller une salle.");
        }
        else if(!MyController.carte19.isVisible()){
            setHint("Ces artefacts doivent avoir un lien... Quand vous aurez trouvé, rentrez le code sur l'application.");
        }
        else if(MyController.carte19.isVisible()){
            setHint("Un de ces visages sur ces photos vous semble familier... ");
        }
    }
}

