/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.interfazcollectioniterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Al usar un iterador sin tipo, se debe utilizzar casting para extraer el objeto
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Buenos días");
        lista.add("Buenas tardes");
        lista.add("Buenas noches");
        
        Iterator it = lista.iterator();

        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }

        //Al usar un iterador de tipo String, No se necesita hacer casting para extraer el objeto
        //y evitamos posibles problemas
        ArrayList<String> coleccionString = new ArrayList<String>();

        Iterator<String> itString = coleccionString.iterator();

        while (itString.hasNext()) {
            String c = itString.next();
            System.out.println(c);
        }
    }

}
