/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.mediostransporte;

/**
 *
 * @author a20estefaniapc
 */
public class Transporte {
    
    private int maxNroDePasajeros;
    private int maxFuel;
    private double velocidad;
    
    
    
    public Transporte(){
    }
    
    
    
    public int getMaxNroDePasajeros(){
    return maxNroDePasajeros;
    }
    
    public void setMaxNroDePasajeros(int maxNroDePasajeros){
    this.maxNroDePasajeros = maxNroDePasajeros;
    }
    
     public int getMaxFuel(){
    return maxFuel;
    }
    
    public void setMaxFuel(int maxFuel){
    this.maxFuel = maxFuel;
    }
    
     public double getvelocidad(){
    return velocidad;
    }
    
    public void setvelocidad(double velocidad){
    this.velocidad = velocidad;
    }
    
    public String acelerar(){
    return "El transporte acelera";
    }
    
    public String desacelerar(){
    return "El transporte desacelera";
    }
    
}
