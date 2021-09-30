/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemploeventosclaseanonima;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author a20estefaniapc
 */
public class Ventana extends JFrame {

    JButton boton1, boton2;

    public Ventana() {

        setVisible(true);
        setBounds(700, 300, 325, 300);
        setTitle("Eventos con clases anónimas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boton1 = new JButton("1");
        boton1.setBounds(10, 100, 90, 30);
        add(boton1);

        boton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle("boton 1");
            }
        });

        boton2 = new JButton("2");
        boton2.setBounds(110, 100, 90, 30);
        add(boton2);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
        setTitle("boton 2");
            }
        });

    }

}
