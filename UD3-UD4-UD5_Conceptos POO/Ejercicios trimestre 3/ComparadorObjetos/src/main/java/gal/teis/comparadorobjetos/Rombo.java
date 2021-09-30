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
public class Rombo implements RelacionDimension{
    
    //Propiedades
    private double lados;
    
    //Cosntructor
    public Rombo(double lados) {
        this.lados=lados;
    }
    
    //getters y setters
    public double getLados() {
        return lados;
    }

    public void setLados(double lados) {
        this.lados = lados;
    }
    
    //métodos
    public double perimetro(){
        return 4*getLados();
    }
    
     //Implementación de la interface
    @Override
    public boolean esMasGrande(Object b) {
        double aPer = this.perimetro();
        //Casting de b que pertenece a Object
        //(Linea)b lo convierte en un objecto de la clase Linea
        double bPer = ((Rombo) b).perimetro();
        return (aPer > bPer);
    }

    @Override
    public boolean esMasPequeno(Object b) {
        double aPer = this.perimetro();
        double bPer = ((Rombo) b).perimetro();
        return (aPer< bPer);
    }

    @Override
    public boolean esIgual(Object b) {
        double aPer = this.perimetro();
        double bPer = ((Rombo) b).perimetro();
        return (aPer == bPer);
    }
    
}
