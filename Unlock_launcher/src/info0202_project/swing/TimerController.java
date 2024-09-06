/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info0202_project.swing;

/**
 *
 * @author Clément
 */
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerController {
    private Timer timer;
    private int temps;
    private final int temps_max = 600; //temps de la partie 

    private ActionListener actionListener;

    public TimerController(ActionListener actionListener) {
        this.actionListener = actionListener;
        this.temps = temps_max; 
    }

    public void startTimer() {
        if (temps <= 0) {
            temps = temps_max; 
        }

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temps--;
                if (temps >= 0) {
                    actionListener.actionPerformed(e); 
                } else if (temps <= 0) {
                    temps = 0;
                    timer.stop();
                    System.out.println("Game over !"); //pour faire des test 
                }
            }
        });
        timer.start();
    }

    public void pauseTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    public void resetTimer() {
        temps = temps_max;
    }

    public int getTemps() {
        return this.temps;
    }
    
    public void setTemps(int temps) {
        if(this.temps>temps){
            this.temps -= temps;
        } else {
            this.temps = 0;
        }
    }
}