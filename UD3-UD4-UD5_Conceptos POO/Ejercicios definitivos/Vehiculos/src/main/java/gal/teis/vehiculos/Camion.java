/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vehiculos;

/**
 *
 * @author Estefania
 */
public class Camion extends Vehiculo {
    
    public Camion(){
    super();
    }
    
    public Camion(String marca){
    super(marca);
    }
    
    @Override
    public String acelerar(){
        return "El camnion de la marca "+getMarca()+" ha acelerado.";
    }
    
    @Override
    public String toString() {
        return "El camión es de la marca " + getMarca();
    }
    
}
