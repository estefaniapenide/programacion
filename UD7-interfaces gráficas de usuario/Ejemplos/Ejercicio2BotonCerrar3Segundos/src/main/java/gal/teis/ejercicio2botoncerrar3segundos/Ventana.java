/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejercicio2botoncerrar3segundos;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Estefania
 */
public class Ventana extends JFrame{
    
     public Ventana(){
        
    setVisible(true);
    setSize(500,300);
    setResizable(true);
    setLocation(300,200);
    setTitle("Mi ventana");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Cambiar el color de fondo de JFrame
    getContentPane().setBackground(Color.CYAN);
    
    //Instanciamos el panel
    LienzoPanel miPanel = new LienzoPanel();
    add(miPanel);
    
//    LinezoPanelImagen miOtroPanel = new LinezoPanelImagen();
//    add(miOtroPanel);
    
    
    
    }
    
}

