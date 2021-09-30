/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.interfazcollectionset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Persona p1 = new Persona("1.Laura", "3453435");
        Persona p2 = new Persona("2.Ana", "3434375");
        Persona p3 = new Persona("3.Pedro", "3458635");

        // HashSet
        HashSet<Persona> almacenHashSet = new HashSet<Persona>();
        almacenHashSet.add(p1);
        almacenHashSet.add(p2);
        almacenHashSet.add(p3);
        //Este objeto no se almacena
        almacenHashSet.add(p3);

        System.out.println("Elementos almacenados con HashSet:");
        for (Persona aux : almacenHashSet) {
            System.out.println(aux.getNombre());
        }
        System.out.println("");

        //LinkedHashSet
        LinkedHashSet<Persona> almacenLinkedHashSet = new LinkedHashSet<Persona>();
        almacenLinkedHashSet.add(p1);
        almacenLinkedHashSet.add(p2);
        almacenLinkedHashSet.add(p3);
        //Este objeto no se almacena
        almacenLinkedHashSet.add(p3);

        System.out.println("Elementos almacenados con LinkedHashSet:");
        for (Persona aux : almacenLinkedHashSet) {
            System.out.println(aux.getNombre());
        }
        System.out.println("");

        //TreeSet
        TreeSet<Persona> almacenTreeSet = new TreeSet<Persona>();
        almacenTreeSet.add(p1);
        almacenTreeSet.add(p2);
        almacenTreeSet.add(p3);
        //Este objeto no se almacena
        almacenTreeSet.add(p3);

        System.out.println("Elementos almacenados con TreeSet:");
        for (Persona aux : almacenTreeSet) {
            System.out.println(aux.getNombre());
        }
        System.out.println("");
        
        

        //Algoritmo de análisis de rendimiento de las distintas colecciones tipo Set
        System.out.println("Análisis de rendimiento de las distintas colecciones tipo Set");
        
        //Tiempo utilizado con HashSet
        final Set hashSet = new HashSet(1000000);
        final Long startHashSetTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hashSet.add(i);
        }
        final Long endHashSetTime = System.currentTimeMillis();
        System.out.println("Time spent by HashSet: " + (endHashSetTime - startHashSetTime));
        
        
        //Tiempo utilizado con TreeSet
        final Set treeSet = new TreeSet();
        final Long startTreeSetTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            treeSet.add(i);
        }
        final Long endTreeSetTime = System.currentTimeMillis();
        System.out.println("Time spent by TreeSet: " + (endTreeSetTime - startTreeSetTime));
        
        
        //Tiempo utilizado con LinkedHashSet
        final Set linkedHashSet = new LinkedHashSet(1000000);
        final Long startLinkedHashSetTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedHashSet.add(i);
        }
        final Long endLinkedHashSetTime = System.currentTimeMillis();
        System.out.println("Time spent by LinkedHashSet: " + (endLinkedHashSetTime - startLinkedHashSetTime));
    }

}
