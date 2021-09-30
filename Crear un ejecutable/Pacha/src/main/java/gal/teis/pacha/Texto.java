/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.pacha;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTextPane;

/**
 *
 * @author Estefania
 */
public class Texto extends JTextPane {
    
         public Texto() {
            super();
            //setText("Hello World");
            setOpaque(false);
            
            // this is needed if using Nimbus L&F - see http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6687960
            //setBackground(new Color(0,0,0,0));
        }

        @Override
        protected void paintComponent(Graphics g) {
            // set background green - but can draw image here too
            //g.setColor(Color.GREEN);
            //g.fillRect(0, 0, getWidth(), getHeight());

            // uncomment the following to draw an image
             Image img = Toolkit.getDefaultToolkit().getImage("Images/pacha.jpg");
             g.drawImage(img,123,0, this);

            super.paintComponent(g);
        }
    
}
