/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.ejemplo001;

/**
 *
 * @author tete
 */
public class Coche {
    // atributos:
    String marca;
    double vel_max;
    int potencia;
    String tipo_carburante;
    double velocidad;
    double aceleracion;
    
    // métodos:
    String arrancar() {
        // instrucciones para arrancar el coche
        return "Esta arrancando " + marca;
    }

    String frenar() {
        // instrucciones para frenar el coche
         return "Esta frenando " + marca;
    }

    String acelerar() {
        // instrucciones para acelerar el coche
         return "Esta acelerando " + marca;
    }

    String girar_derecha(short grados) {
        // instrucciones para girar a la derecha
         return "Esta girando a la derecha " + marca;
    }
}
