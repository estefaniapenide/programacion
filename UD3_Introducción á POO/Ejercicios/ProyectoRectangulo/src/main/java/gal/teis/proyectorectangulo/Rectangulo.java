/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectorectangulo;

/**
 *
 * @author a20estefaniapc
 */
public class Rectangulo {

    int lado1;
    int lado2;

    public double area() {
        return lado1 * lado2;
    }

    public double perimetro() {
        return lado1 * 2 + lado2 * 2;
    }
}
