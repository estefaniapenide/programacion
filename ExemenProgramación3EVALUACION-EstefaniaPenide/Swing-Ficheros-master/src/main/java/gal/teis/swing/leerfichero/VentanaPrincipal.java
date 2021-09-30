/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.swing.leerfichero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal() {
        setSize(550, 400);
        setLocationRelativeTo(null);
        setTitle("Trabajo con ficheros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /*Probando para que pregunte antes de cerrar*/
        
//        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                int option = JOptionPane.showConfirmDialog(
//                        VentanaPrincipal.this,
//                        "¿Estas seguro de que quieres cerrar la aplicación?",
//                        "Confirmación de cierre",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE);
//                if (option == JOptionPane.YES_OPTION) {
//                    System.exit(0);
//                }
//            }
//        });

        setBackground(Color.GRAY);
        
        add(new Contenido());
        
        setVisible(true);
    }
    
}
