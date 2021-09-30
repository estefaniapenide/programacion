/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplomismoeventodistintosobjetos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Esther Ferreiro
 */
public class VentanaFrame extends JFrame implements ActionListener {

    JButton botonCopiar;
    JTextField campoValor, resultado;

    public VentanaFrame() {
        setLayout(new FlowLayout());
        add(new JLabel("Valor "));
        campoValor = new JTextField(5);
        add(campoValor);
        botonCopiar = new JButton("Copiar");
        add(botonCopiar);
        botonCopiar.addActionListener(this);
        add(new JLabel(" Copia "));
        resultado = new JTextField(6);
        add(resultado);
        //Inicializo la ventana
        setVisible(true);
        //Tamaño y coordenadas a la vez
        //setBounds(WIDTH, WIDTH, WIDTH, HEIGHT)
        setBounds(700, 300, 500, 300);
        setTitle("Componentes y posición");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String valor = campoValor.getText();
        resultado.setText(valor);
    }
}
