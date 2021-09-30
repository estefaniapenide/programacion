/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicajframe;

import java.awt.event.WindowAdapter;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1º Crear el objeto del tipo de la clase en la que está
        VentanaFrame ventanaP = new VentanaFrame();
        //2º Determinar la visibilidad
        //La ventana aparecerá posicionada en la coorenada 0,0 de la ventana
        //(arriba a la izquierda)
        //Podría haber introducido este método en el constructor
        ventanaP.setVisible(true);
        ventanaP.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        ventanaP.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Se pide una confirmación antes de finalizar el programa
                int option = JOptionPane.showConfirmDialog(
                        ventanaP,
                        "¿Estás seguro de que quieres cerrar la aplicación?",
                        "Confirmación de cierre",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    //Si se responde YES el programa el programa se cierra
                    System.exit(0);
                }
            }

        });
        //3º Acción ante el evento de cerrar la ventana -->que cierre la vetana
        //Ocultar al cerrar (JFrame.HIDE_ON_CLOSE)--> se revierte con setVisible(true)
//        ventanaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        
//        VentanaFrameToolkit ventanaT = new VentanaFrameToolkit();
//        ventanaT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
