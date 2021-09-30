/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.III;

import gal.teis.II.Operario;

/**
 *
 * @author Estefania
 */
public class Oficial extends Operario {

    public Oficial() {
        super();
    }

    public Oficial(String nombre) {
        super(nombre);
    }

    public String toString() {
        return "El nombre del oficial es " + getNombre();
    }

}
