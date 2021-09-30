/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.derivartratamientoexcepciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static void leerFicherosBytes() throws FileNotFoundException, IOException {
        InputStream miFIS = new FileInputStream("texto.txt");
        int valor = miFIS.read();
        while (valor != 1) {
            System.out.println((char) valor);
            valor = miFIS.read();
            double a = 0.89;
        }
    }

    public static void main(String[] args) {

        try {
            leerFicherosBytes();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero");
        } catch (IOException ex) {
            System.out.println("Se ha producido la excepción " + ex.getMessage());
        }
    }

}
