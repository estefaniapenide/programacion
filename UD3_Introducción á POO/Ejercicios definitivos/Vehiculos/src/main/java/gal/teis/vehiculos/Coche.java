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
public class Coche extends Vehiculo {
    
     public Coche() {
        super();
    }

    public Coche(String marca) {
        super(marca);
    }
    
    @Override
    public String acelerar(){
        return "El coche de la marca "+getMarca()+" ha acelerado.";
    }
    
    @Override
    public String toString() {
        return "El coche es de la marca " + getMarca();
    }
    
}
