/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.estructurasalmacenamientovehiculo;

/**
 *
 * @author Estefania
 */
public class Vehiculo {

    //atributos
    private int idVehiculo;
    private String tipo;

    //constructor
    public Vehiculo(int idVehiculo, String tipo) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
    }

    //setters y getters
    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }
    
    public String getTipo() {
        return tipo;
    }

}
