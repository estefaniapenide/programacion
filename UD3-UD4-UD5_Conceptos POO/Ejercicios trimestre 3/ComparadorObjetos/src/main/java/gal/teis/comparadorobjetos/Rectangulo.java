/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.comparadorobjetos;

/**
 *
 * @author Estefania
 */
public class Rectangulo implements RelacionDimension {
    
    //Propiedades
    private double lados1;
    private double lados2;
    
    //Constructor
    public Rectangulo(double lados1, double lados2) {
        this.lados1=lados1;
        this.lados2=lados2;
        
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
    public double perimetro(){
        return 2*(getLados2()+getLados1());
    }
    
     //Implementación de la interface
    @Override
    public boolean esMasGrande(Object b) {
        double aPer = this.perimetro();
        //Casting de b que pertenece a Object
        //(Linea)b lo convierte en un objecto de la clase Linea
        double bPer = ((Rectangulo) b).perimetro();
        return (aPer > bPer);
    }

    @Override
    public boolean esMasPequeno(Object b) {
        double aPer = this.perimetro();
        double bPer = ((Rectangulo) b).perimetro();
        return (aPer< bPer);
    }

    @Override
    public boolean esIgual(Object b) {
        double aPer = this.perimetro();
        double bPer = ((Rectangulo) b).perimetro();
        return (aPer == bPer);
    }
}
