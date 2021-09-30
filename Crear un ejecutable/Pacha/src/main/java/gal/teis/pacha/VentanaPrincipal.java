/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.pacha;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Estefania
 */
public class VentanaPrincipal extends JFrame  {
    
     public VentanaPrincipal() {
        Toolkit elToolkit = Toolkit.getDefaultToolkit();
        Dimension laDimension=elToolkit.getScreenSize();
        setSize(laDimension.width, laDimension.height);


        setLocationRelativeTo(null);
        setTitle("Queen Pacha, first of her name, text editor");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /*Probando para que pregunte antes de cerrar*/
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        VentanaPrincipal.this,
                        "pero, ¿estas seguro de que quieres abandonar a Pacha?",
                        "Pacha permite que marches",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        Image miIcono= elToolkit.getImage("Images/pacha2.jpg");
        setIconImage(miIcono);
        

        add(new Contenido());
        
        setVisible(true);
    }
    
}
