/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.II;

import gal.teis.I.Empleado;

/**
 *
 * @author Estefania
 */
public class Directivo extends Empleado {

    public Directivo() {
        super();
    }

    public Directivo(String nombre) {
        super(nombre);
    }

    public String toString() {
        return "El nombre del directivo es " + getNombre();
    }

}
