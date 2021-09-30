/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplomismoeventodistintosobjetos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Estefania
 */
public class Ventana extends JFrame implements ActionListener {

    JButton boton1, boton2, boton3, boton4;

    public Ventana() {
        //Inicializo la ventana
        setVisible(true);
        setBounds(700, 300, 325, 300);
        setTitle("Mismo evento en distintos componentes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        boton1 = new JButton("1");
        boton1.setBounds(10, 100, 90, 30);
        add(boton1);
        boton1.addActionListener(this);
        boton2 = new JButton("2");
        boton2.setBounds(110, 100, 90, 30);
        add(boton2);
        boton2.addActionListener(this);
        boton3 = new JButton("3");
        boton3.setBounds(210, 100, 90, 30);
        add(boton3);
        boton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            setTitle("Botón 1");
        } else if (e.getSource() == boton2) {
            setTitle("Botón 2");
        } else if (e.getSource() == boton3) {
            setTitle("Botón 3");
        }
    }

}
