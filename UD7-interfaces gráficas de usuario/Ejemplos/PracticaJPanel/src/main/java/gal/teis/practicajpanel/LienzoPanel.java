/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicajpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Estefania
 */
public class LienzoPanel extends JPanel implements ActionListener{

    JButton boton = new JButton("Prueba evento-emitir sonido");
    
    public LienzoPanel() {
        add(boton);
        boton.addActionListener(this);
        //Hago el panel transparente
        this.setOpaque(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    //Runnable es una interfaz que permite ejecutar hilos
    final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
    if(runnable !=null){runnable.run();}
    }

    @Override
    public void paintComponent(Graphics g) {

//Invocar método de la clase padre
        super.paintComponent(g);

//Cambiar tipo de letra y tamaño
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.setColor(Color.red);
        g.drawString("Este es nuestro primer texto", 50, 50);
//Dibujar un rectángulo
        g.drawRect(25, 20, 270, 50);
        /*
Graphics2D que permite más operaciones:cb el grosor y el tipo de línea*/
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
//para dibujar un rectángulo no relleno----> g2. rectangulo
        g2.fill(rectangulo);//para dibujar el rectángulo relleno
    }

}
