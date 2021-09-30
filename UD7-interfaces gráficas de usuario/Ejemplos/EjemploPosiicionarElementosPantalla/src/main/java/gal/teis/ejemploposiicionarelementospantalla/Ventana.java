/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemploposiicionarelementospantalla;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Estefania
 */
public class Ventana extends JFrame {

    JButton boton;

    public Ventana() {
        setLayout(null);
        //Botón
        boton = new JButton("Estoy en mi posición");
        boton.setBounds(50, 150, 150, 30);
        add(boton);
        //JFrame
        setVisible(true);
        setBounds(700, 300, 300, 300);
        setTitle("Componentes y posición");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
