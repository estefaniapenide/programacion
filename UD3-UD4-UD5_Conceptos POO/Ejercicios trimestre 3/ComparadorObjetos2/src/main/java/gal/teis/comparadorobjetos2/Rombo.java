/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.comparadorobjetos2;

/**
 *
 * @author Estefania
 */

/**
 *El rombo tiene 4 lados iguales y los ángulos iguales 2 a 2.
 */
public class Rombo extends Paralelogramo {

    public Rombo(double lados) {
        super(lados);
    }

    @Override
    public double perimetro() {
        return getLados1() * 4;
    }

}
