/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info0202_project.swing;

/**
 *
 * @author Clément
 */
public class HologramPostAction  {
    public void effectuerAction1() {
        System.out.println("Action : Carte de la salle des hologrammes");
    }
    
    public void malus(int time, TimerController timerController) {
        timerController.setTemps(time);
        System.out.println("Malus de "+time+" secondes !");
    }
    
    //à voir si utilisé ou non
    public void bonus() {
        System.out.println("bonne réponse !");
    }
}