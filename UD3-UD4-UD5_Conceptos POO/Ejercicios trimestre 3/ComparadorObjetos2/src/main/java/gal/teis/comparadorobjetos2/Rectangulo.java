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
 *El rectángulo tiene los lados iguales 2 a 2 y 4 ángulos iguales.
 */
public class Rectangulo extends Paralelogramo{
    
    public Rectangulo(double lados1, double lados2) {
        super(lados1,lados2);
        
    }
    
    @Override
    public double perimetro(){
     return (getLados1()+getLados2())*2;
    }
    
}
