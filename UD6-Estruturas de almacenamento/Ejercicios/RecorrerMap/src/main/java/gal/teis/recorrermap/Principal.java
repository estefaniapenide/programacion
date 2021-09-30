/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.recorrermap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //key será el DNI
        //value será el nombre
        Map<String, String> listaPersonaDNI = new HashMap<String, String>();

        listaPersonaDNI.put("00000000J", "Estefanía");
        listaPersonaDNI.put("11111111A", "Paula");
        listaPersonaDNI.put("22222222B", "Juan");
        listaPersonaDNI.put("33333333C", "Laura");
        listaPersonaDNI.put("44444444D", "Antonio");

        Iterator<String> it = listaPersonaDNI.keySet().iterator();
        while (it.hasNext()) {
            String dni = it.next();
            System.out.println("DNI: " + dni + "-> Nombre: " + listaPersonaDNI.get(dni));
        }

        Collection<String> nombres = listaPersonaDNI.values();
        Iterator<String> it2 = nombres.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

    }

}
