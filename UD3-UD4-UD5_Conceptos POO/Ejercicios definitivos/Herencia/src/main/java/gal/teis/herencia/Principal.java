/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.herencia;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deportista d1 = new Deportista();
        d1.setNombre("Manuel");
        d1.setDeporte("Balonmano");
        
       

        System.out.println(d1.getNombre());
        System.out.println(d1.getDeporte());
    }

}
