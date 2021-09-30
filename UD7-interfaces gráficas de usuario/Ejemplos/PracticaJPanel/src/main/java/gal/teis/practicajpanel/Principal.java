/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicajpanel;

import java.awt.GraphicsEnvironment;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaFrame miVentana = new VentanaFrame();
        
        //Para conocer las fueentes instaladas
        conocerFuentes();
        
        //documentacion de interés
        //https://docs.oracle.com/javase/8/docs/api/
    }
    
    public static void conocerFuentes(){
    String[] fuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    
    for(String fuente: fuentes){
    System.out.println(fuente);
    }
    
    
    }
    
}
