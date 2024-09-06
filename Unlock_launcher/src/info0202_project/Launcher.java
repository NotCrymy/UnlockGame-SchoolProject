package info0202_project;

import info0202_project.fx.IHMFx;
import info0202_project.swing.IHMSwing;
import javafx.application.Application;

/**
 * 
 *
 * @author Clément
 */
public class Launcher {
    private Launcher() {}

    /**
     * Main method 
     *
     *@param args command line arguments (2)
     */
    public static void main(String[] args) {
        
        Thread swing_thread = new Thread(new IHMSwing());
        swing_thread.start();
        Application.launch(IHMFx.class,new String[1]);
    }
}
