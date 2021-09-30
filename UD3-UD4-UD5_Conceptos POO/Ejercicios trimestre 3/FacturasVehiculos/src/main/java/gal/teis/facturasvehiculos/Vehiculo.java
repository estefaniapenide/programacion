/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.facturasvehiculos;

/**
 *
 * @author Estefania
 */
public abstract class Vehiculo {

    protected String id;
    protected int tiempo;

    public Vehiculo(String id) {
        this.id = id;
        tiempo = 0;
    }

    public int getTiempo() {
        return tiempo;
    }

    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    
    abstract public double factura();

    

}
