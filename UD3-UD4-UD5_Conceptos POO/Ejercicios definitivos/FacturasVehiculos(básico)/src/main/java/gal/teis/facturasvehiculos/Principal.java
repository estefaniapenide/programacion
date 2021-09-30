/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.facturasvehiculos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        int tiempo;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduzca el tipo de vehículo: ");
        System.out.println("1. Cliente");
        System.out.println("2. Abonado");
        int tipo;
        boolean correcto;
        do {
            correcto = true;
            tipo = ControlData.leerInt(input);
            if (tipo < 1 || tipo > 2) {
                correcto = false;
                System.out.println("ERROR. No ha introducido un número válido.Introduzca otro número:");
            }
        } while (!correcto);
        switch (tipo) {
            case 1:
                System.out.println("VEHICULO CLIENTE");
                Vehiculo a = new VehiculoCliente("aaa");
                vehiculos.add(a);
                System.out.println("Introduzca el tiempo en horas: ");
                boolean correctoa;
                do {
                    correctoa = true;
                    tiempo = ControlData.leerInt(input);
                    if (tiempo < 0) {
                        correctoa = false;
                        System.out.println("ERROR. Debe introducir una cantidad de tiempo positiva.");
                    }
                } while (!correctoa);
                vehiculos.get(0).setTiempo(tiempo);
                System.out.println("Importe de su factura: " + vehiculos.get(0).factura() + "€");
                vehiculos.remove(a);
                break;
            case 2:
                System.out.println("VEHICULO ABONADO");
                Vehiculo b = new VehiculoAbonado("bbb");
                vehiculos.add(b);
                System.out.println("Introduzca el tiempo en horas: ");
                boolean correctob;
                do {
                    correctob = true;
                    tiempo = ControlData.leerInt(input);
                    if (tiempo < 0) {
                        correctob = false;
                        System.out.println("ERROR. Debe introducir una cantidad de tiempo positiva.");
                    }
                } while (!correctob);
                vehiculos.get(0).setTiempo(tiempo);
                System.out.println("Importe de su factura: " + vehiculos.get(0).factura() + "€");
                VehiculoAbonado veh = (VehiculoAbonado) vehiculos.get(0);
                System.out.println("Importe de su factura con el código de descuento: " + veh.factura("codigo") + "€");
                vehiculos.remove(b);
                break;
            default:
                System.out.println("No ha introducido un valor que se corresponda con ninguna de las opciones.");
                break;
        }
    }

}
