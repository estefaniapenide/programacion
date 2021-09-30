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
public class VehiculoCliente extends Vehiculo {

    public VehiculoCliente(String id) {
        super(id);
    }

    @Override
    public double factura() {
        return (tiempo / 24) * 12.0 + (tiempo % 24) * 0.6;
    }
    

}
