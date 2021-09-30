/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplohashmap;

import java.util.HashMap;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Alumno a1 = new Alumno("Ana", 7.0);
        Alumno a2 = new Alumno("Mateo", 8.5);
        Alumno a3 = new Alumno("Andera", 7.2);
        Alumno a4 = new Alumno("Sofía", 8.0);
        Alumno a5 = new Alumno("Tomás", 7.0);
        Alumno a6 = new Alumno("Gonzalo", 8.0);

        HashMap<Integer, Alumno> lista = new HashMap<Integer, Alumno>();

        lista.put(1, a1);
        lista.put(2, a2);
        lista.put(3, a3);
        lista.put(4, a4);
        lista.put(5, a5);
        lista.put(6, a6);

        System.out.println(lista.get(4));

        lista.remove(4);

        System.out.println(lista);

    }

}
