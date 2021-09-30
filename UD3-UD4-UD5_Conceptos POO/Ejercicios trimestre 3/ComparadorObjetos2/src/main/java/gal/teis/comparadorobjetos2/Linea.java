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
public class Linea implements IRelacionDimension{
    
    //Propiedades
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    //Constructor
    public Linea(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    //Métodos públicos
    public double getLongitud() {
        double longitud = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return longitud;
    }

    //Implementación de la interface
    @Override
    public boolean esMasGrande(Object b) {
        double aLong = this.getLongitud();
        //Casting de b que pertenece a Object
        //(Linea)b lo convierte en un objecto de la clase Linea
        double bLong = ((Linea) b).getLongitud();
        return (aLong > bLong);
    }

    @Override
    public boolean esMasPequeno(Object b) {
        double aLong = this.getLongitud();
        double bLong = ((Linea) b).getLongitud();
        return (aLong < bLong);
    }

    @Override
    public boolean esIgual(Object b) {
        double aLong = this.getLongitud();
        double bLong = ((Linea) b).getLongitud();
        return (aLong == bLong);
    }

    
}
