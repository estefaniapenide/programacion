/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.ejemplo001;

/**
 *
 * @author Esther Ferreiro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String mensaje;

        //Crea una instancia de la clase Coche
        Coche miCoche1 = new Coche();
        Coche miCoche2 = new Coche();
        
        miCoche1.marca="Ferrari";
        miCoche2.marca="Mercedes";

        //Ejecuta un método a partir de la instancia
        System.out.println(miCoche1.arrancar());
        System.out.println(miCoche2.arrancar());
        
        //Modifica una propiedad a partir de la instancia
        miCoche1.vel_max = 200;
        System.out.println("Coche1 puede alcanzar una velocidad de " + miCoche1.vel_max);

        
        miCoche2.vel_max = 250;
        System.out.println("Coche2 puede alcanzar una velocidad de " + miCoche2.vel_max);
        
        //Muestra cual es el coche que puede alcanzar una mayor velocidad
        mensaje = miCoche1.vel_max > miCoche2.vel_max ? "coche 1" : "coche 2";
        
        System.out.println("El coche más rápido es el" + mensaje);
    }
    //De forma automática, se elimina la instancia de memoria cuando 
    //ésta queda inacesible 
}
