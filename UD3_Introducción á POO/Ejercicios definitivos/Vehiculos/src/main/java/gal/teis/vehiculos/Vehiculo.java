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
public class Vehiculo {

    //atributos
    private String marca;

    //cosntructores
    public Vehiculo() {
    }

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    //getters y setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    //métodos
    public String pagarImpuesto() {
        return "El vehículo de la marca " + marca + " ha pagado el impuesto.";
    }

    protected String acelerar() {
        return "El vehículo de la marca " + marca + " ha acelerado.";
    }

    
    public String toString() {
        return "El vehículo es de la marca " + marca;
    }

    //método final que no se podrá sobreescribir
    public final void metodoFinal() {
        System.out.println("Este es un métdodo final.");
    }

}
