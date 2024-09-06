/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info0202_project.fx;

/**
 *
 * @author Clément
 */

import java.io.File;
import java.util.Vector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Carte extends ImageView{
        
    private Pane panel;
    private double dragX, dragY;
    private final String IMAGE_DIRECTORY = "images";
    private final String IMAGE_SUFFIX    = ".png";
    private static final char   SEPARATOR_CHAR  = File.separatorChar;
    private Vector<CercleCliquable> cercles = new Vector<CercleCliquable>();
    private int numeroCarte;
        
    public Carte(Pane p, int n, int numCercle, int x, int y, int numeroCarte){
        String path=IMAGE_DIRECTORY;
        path+=SEPARATOR_CHAR;
        path+=n;
        path+=IMAGE_SUFFIX;

        File img = new File(path);
        Image image = new Image(img.toURI().toString());
        setImage(image);
        
        this.cercles.add(new CercleCliquable(numCercle, x, y));
        setFitWidth(image.getWidth() / 1.5); //peut être non utile - à voir si besoin de redimensionner
        setFitHeight(image.getHeight() / 1.5); //peut être non utile - à voir si besoin de redimensionner
        panel=p;
        this.numeroCarte = numeroCarte; 
        setSmooth(true);
        setPreserveRatio(true);
    }

    public double getDragX(){return dragX;}
    public double getDragY(){return dragY;}
    public Vector<CercleCliquable> getCercles(){return cercles;}
    public void setDragX(double x){dragX=x;}
    public void setDragY(double y){dragY=y;}
    
    public void setCercle(int num, int x, int y){this.cercles.add(new CercleCliquable(num, x, y));}
    public int getNumeroCarte(){return this.numeroCarte;}
}

