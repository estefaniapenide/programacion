/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.lanzamientoexcepcionesobjetosclasescreadasporprogramador;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            int x = 10;
            if (x < 20 || x > 100) {
                throw new NumeroFueraRangoException(20, 100);
            }
        } catch (NumeroFueraRangoException e) {
            System.out.println(e.getMessage());
        }
    }

}
