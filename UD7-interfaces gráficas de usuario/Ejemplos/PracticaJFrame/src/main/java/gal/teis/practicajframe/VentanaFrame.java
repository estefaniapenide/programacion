/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicajframe;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Estefania
 */
public class VentanaFrame extends JFrame{
    
    public VentanaFrame(){
    //Dar el tamaño al marco teniendo en cuenta la resolución del monitor
    setSize(400,300);
    //Determinar si se quiere redimensionar la ventana (true) o no (false)
    setResizable(true);
    //Indica la posición de la ventana
    setLocation(300,200);
    //setLocationTo(null);//Centra la ventana
    
    //Texto en la ventana
    setTitle("Mi ventana");
    //Cambiar el color de fondo de JFrame
    getContentPane().setBackground(Color.CYAN);
    //Indica que se abra a pantalla completa
    setExtendedState(Frame.MAXIMIZED_BOTH);
    
    }
    
}
