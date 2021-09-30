/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicajpanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Estefania
 */
public class LinezoPanelImagen extends JPanel {

    private Image imagen;

    public LinezoPanelImagen() {
        //Hago el panel transparente
        this.setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        //Mostrar una imagen en el panel
        try {
            imagen = ImageIO.read(new File("src/images/icono_calculadora.png"));
        } catch (IOException ex) {
            System.out.println("La imagen no se encuentra");
        }
        //Dibuja la imagen en el panel
        g.drawImage(imagen, 20, 20, null);
    }

}
