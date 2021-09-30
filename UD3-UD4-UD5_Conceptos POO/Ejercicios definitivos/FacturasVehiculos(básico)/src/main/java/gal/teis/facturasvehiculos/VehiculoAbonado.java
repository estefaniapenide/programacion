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
public class VehiculoAbonado extends Vehiculo {

    public VehiculoAbonado(String id) {
        super(id);
    }


    @Override
    public double factura() {
        return tiempo * 200.0;
    }
    
    
    public double factura(String codigo) {
        return factura() * (1 - 0.03);
    }

}
