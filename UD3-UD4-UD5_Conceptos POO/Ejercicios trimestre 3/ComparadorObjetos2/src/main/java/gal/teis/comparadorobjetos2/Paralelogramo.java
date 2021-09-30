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
 *Los paralelogramos tienen los ángulos y los lados iguales 2 a 2.
 */
public abstract class Paralelogramo implements IRelacionDimension {
    
    //Propiedades
    private double lados1;
    private double lados2;
    

    //Constructor
    public Paralelogramo(double lados1, double lados2) {
        this.lados1 = lados1;
        this.lados2 = lados2;
    }
    
    public Paralelogramo(double lados) {
        this.lados1 = lados;    
    }


    //getters y setters
    public double getLados1() {
        return lados1;
    }

    public void setLados1(double lados1) {
        this.lados1 = lados1;
    }
    
    public double getLados2() {
        return lados2;
    }

    public void setLados2(double lados2) {
        this.lados2 = lados2;
    }

    
    //métodos
    public abstract double perimetro();
    
    
     //Implementación de la interface
    @Override
    public boolean esMasGrande(Object b) {
        double aPer = this.perimetro();
        //Casting de b que pertenece a Object
        //(Paralelogramo)b lo convierte en un objecto de la clase Paralelogramo
        double bPer = ((Paralelogramo) b).perimetro();
        return (aPer > bPer);
    }

    @Override
    public boolean esMasPequeno(Object b) {
//        double aPer = this.perimetro();
//        double bPer = ((Paralelogramo) b).perimetro();
//        return (aPer< bPer);
          return this.perimetro() < ((Paralelogramo) b).perimetro();
    }

    @Override
    public boolean esIgual(Object b) {
        double aPer = this.perimetro();
        double bPer = ((Paralelogramo) b).perimetro();
        return (aPer == bPer);
    }
}
