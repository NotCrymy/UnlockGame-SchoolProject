/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info0202_project.fx;

/**
 *
 * @author Clément
 */
//CercleCliquable.java

public class CercleCliquable {
    
    private static final Integer RADIUS=18;
    
    private final int numero;
    private final double x_center_location;
    private final double y_center_location;
    
    public CercleCliquable(int numero, double x_center_location, double y_center_location) {
        this.numero=numero;
        this.x_center_location=x_center_location;
        this.y_center_location=y_center_location;
    }
    
    public Integer getNumero() {
        return numero;
    }
    
    public boolean isInside(double x,double y) { 
       return Math.sqrt(Math.pow((x-x_center_location), 2)+
                        Math.pow((y-y_center_location), 2))
                        <= RADIUS;
    }
}
