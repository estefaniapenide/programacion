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
        int opcion;
        int tiempo;
        int tipo;
        int indice;
        char codigo;
        String cod = "";

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("---------------------------------");
            System.out.println("Elija una de las opciones:");
            System.out.println("1. Crear facturas");
            System.out.println("2. Ver lista facturas");
            System.out.println("");
            System.out.println("Pulse 0 para salir.");

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:

                    do {

                        System.out.println("\nIntroduzca el tipo de vehículo: ");
                        System.out.println("1. Cliente");
                        System.out.println("2. Abonado");
                        System.out.println("");
                        System.out.println("Pulse 0 para volver al menú principal.");

                        tipo = ControlData.leerInt(input);

                        switch (tipo) {
                            case 1:
                                System.out.println("\nVEHICULO CLIENTE");
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
                                indice = vehiculos.size();
                                vehiculos.get(indice - 1).setTiempo(tiempo);
                                System.out.println("Importe de su factura: " + vehiculos.get(indice - 1).factura() + "€ \n");
                                break;
                            case 2:
                                System.out.println("\nVEHICULO ABONADO");
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
                                indice = vehiculos.size();
                                vehiculos.get(indice - 1).setTiempo(tiempo);
                                System.out.println("Importe de su factura: " + vehiculos.get(indice - 1).factura() + "€");
                                System.out.println("¿Tiene código de descuento? S/N");
                                boolean correcto1;
                                do {
                                    correcto1 = true;
                                    codigo = ControlData.leerChar(input);
                                    codigo=Character.toUpperCase(codigo);
                                    if (codigo == 'S' || codigo == 'N') {
                                    } else {
                                        correcto1 = false;
                                        System.out.println("Escriba 'S' si tiene código de descuento. Escriba 'N' si no tiene código.");
                                    }
                                } while (!correcto1);
                                if (codigo == 'S') {
                                    System.out.println("Introduzca el código:");
                                    //Acepto cualquier String como código de descuento en este ejercicio por no complicarlo. Cualquier String será un código válido..
                                    cod = ControlData.leerString(input);
                                    VehiculoAbonado veh = (VehiculoAbonado) vehiculos.get(indice - 1);
                                    veh.setCodigo(true);
                                    System.out.println("Importe de su factura con el código de descuento: " + veh.factura(cod) + "€ \n");
                                } else if (codigo == 'N') {
                                    VehiculoAbonado veh = (VehiculoAbonado) vehiculos.get(indice - 1);
                                    veh.setCodigo(false);
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal... \n");
                                break;
                            default:
                                System.out.println("No ha introducido un valor que se corresponda con ninguna de las opciones.");
                                break;
                        }
                    } while (tipo != 0);

                    break;
                case 2:
                    if (vehiculos.isEmpty()) {
                        System.out.println("NO HAY FACTURAS \n");
                    } else {
                        System.out.println("\nFACTURAS DE VEHICULO CLIENTE");
                        for (int i = 0; i < vehiculos.size(); i++) {
                            if (vehiculos.get(i) instanceof VehiculoCliente) {
                                System.out.println("\tNúmero identificador: " + i + "\n"
                                        + "\tFactura: " + vehiculos.get(i).factura() + "€\n");
                            }
                        }
                        System.out.println("\nFACTURAS DE VEHICULO ABONADO");
                        for (int i = 0; i < vehiculos.size(); i++) {
                            if (vehiculos.get(i) instanceof VehiculoAbonado) {
                                VehiculoAbonado vehAb = (VehiculoAbonado) vehiculos.get(i);
                                if (vehAb.getCodigo()) {
                                    System.out.println("\tNúmero identificador: " + i + "\n"
                                            + "\tTIENE DESCUENTO \n"
                                            + "\tFactura: " + vehiculos.get(i).factura() + "€\n"
                                            + "\tFactura con código de descuento: " + vehAb.factura(cod) + "€\n");
                                } else if (!vehAb.getCodigo()) {
                                    System.out.println("\tNúmero identificador: " + i + "\n"
                                            + "\tNO TIENE DESCUENTO \n"
                                            + "\tFactura: " + vehiculos.get(i).factura() + "€\n");
                                }
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("No ha introducido un valor que se corresponda con ninguna de las opciones.");
                    break;
            }

        } while (opcion != 0);

        input.close();
    }

}
