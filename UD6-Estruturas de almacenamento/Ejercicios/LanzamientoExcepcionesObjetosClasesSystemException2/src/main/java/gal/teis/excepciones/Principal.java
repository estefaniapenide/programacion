/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 1; i < 4; i++) {
            try {
                DemoException.miMetodo(i);
            } catch (Exception ex) {
                System.out.println("Excepción capturada " + ex.getMessage());
            }
        }
    }

}
