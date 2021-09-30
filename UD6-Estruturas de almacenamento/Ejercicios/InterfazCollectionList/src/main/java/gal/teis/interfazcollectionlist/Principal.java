/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.interfazcollectionlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Ejemplo ArrayList
        ArrayList a = new ArrayList();
        a.add("Hola");
        a.add("Adión");
        a.add("Hasta luego");
        //Se le puede indicar la posición con add además de añadirlo
        a.add(0, "Buenos días");
        for (Object o : a) {
            System.out.println(o);
        }
        System.out.println("");

        //ArrayList
        List<Persona> lp = new ArrayList<Persona>();

        Random r = new Random();

        Persona temp = null;

        int sumaaltura = 0;

        for (int i = 0; i < 10; i++) {
            lp.add(new Persona(i, "Persona " + i, r.nextInt(100) + 1));
        }

        for (Persona p : lp) {
            sumaaltura += p.getAltura();
        }

        System.out.println("La media de altura del conjunto de Personas es: " + sumaaltura / lp.size());

        //LinkedList
        List<Persona> listaarray = new ArrayList<Persona>();
        List<Persona> listalinked = new LinkedList<Persona>();
        long antes;
        
        for (int i = 0; i < 10000; i++) {
            listaarray.add(new Persona(i, "Persona " + i, i));
            listalinked.add(new Persona(i, "Persona " + i, i));
        }
        
        System.out.println("Tiempo invertido en insertar una persona en "+"listaarray (en nanosegundos):");
        
        antes=System.nanoTime();
        //Inserción en posición 0 de una persona
        listaarray.add(0,new Persona(10001,"Prueba",10001));
        System.out.println(System.nanoTime()-antes);
        
        
        System.out.println("Tiempo invertido en insertar una persona en "+"listalinked (en nanosegundos):");
        
        antes=System.nanoTime();
        //Inserción en posición 0 de una persona
        listalinked.add(0, new Persona(10001,"Prueba",10001));
        
        System.out.println(System.nanoTime()-antes);
        
        

    }

}
