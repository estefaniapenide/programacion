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
//Poniendo la clase moto como final, ninguna otra podrá heredar de ella.
public final class Moto extends Vehiculo{
    
     public Moto() {
        super();
    }

    public Moto(String marca) {
        super(marca);
    }
    
    @Override
    public String acelerar(){
        return "La moto de la marca "+getMarca()+" ha acelerado.";
    }
    
    @Override
    public String toString() {
        return "La moto es de la marca " + getMarca();
    }
    
}
