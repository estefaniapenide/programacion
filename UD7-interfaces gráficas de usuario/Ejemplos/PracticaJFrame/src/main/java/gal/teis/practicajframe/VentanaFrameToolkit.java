/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicajframe;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Estefania
 */
public class VentanaFrameToolkit extends JFrame {
    
    public VentanaFrameToolkit(){
    setVisible(true);
    
    //Devuelve el sistema nativo de ventanas donde se está ejecutando el programa
    Toolkit elToolkit =Toolkit.getDefaultToolkit();
    
    //Devuelve un objeto con la resolucion de la pantalla
    Dimension laDimension=elToolkit.getScreenSize();
    
    //Crear una ventana que sea la mitad del ancho y del alto
    setSize(laDimension.width/2,laDimension.height/2);
    
    //Establece coordenadas X e Y. Dividido entre 4
    //La referencia siempre es contenedor
    setLocation(laDimension.width/4,laDimension.height/4);
    
    //Modifica el icono de la ventana
    //Se aconseja un tamaño de imagen 20x20
    Image miIcono=elToolkit.getImage("src/images/icono_calculadora.png");
    setIconImage(miIcono);
    }
    
}
