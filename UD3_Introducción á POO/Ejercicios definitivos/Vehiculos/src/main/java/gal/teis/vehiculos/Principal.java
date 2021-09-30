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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.setMarca("adbc");
        System.out.println("La marca del vehículo es "+vehiculo1.getMarca());
        System.out.println(vehiculo1.acelerar());

        Coche coche1 = new Coche();
        coche1.setMarca("Ford");
        System.out.println("La marca del coche es "+coche1.getMarca());
        System.out.println(coche1.acelerar());

        Moto moto1 = new Moto();
        moto1.setMarca("Yamaha");
        System.out.println("La marca de la moto es "+moto1.getMarca());
        System.out.println(moto1.acelerar());

        Camion camion1 = new Camion();
        camion1.setMarca("Mercedes");
        System.out.println("La marca del camión  es "+camion1.getMarca());
        System.out.println(camion1.acelerar());
        
        vehiculo1.metodoFinal();
        coche1.metodoFinal();
        moto1.metodoFinal();
        camion1.metodoFinal();

    }

}
