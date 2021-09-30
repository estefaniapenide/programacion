/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.swing.componentes;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Esther Ferreiro
 */
public class VentanaFrame extends JFrame {

    private JPanel contentPane;
    private JTextField txtCajaDeTexto;
    static Principal frame;
    private JPasswordField passwordField;

    public VentanaFrame() {
        setTitle("Componentes de Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        //Agrego el panel
        LienzoPanel miPanel = new LienzoPanel();
        miPanel.setBackground(Color.LIGHT_GRAY);
        add(miPanel);
        
        

        
    }
}
