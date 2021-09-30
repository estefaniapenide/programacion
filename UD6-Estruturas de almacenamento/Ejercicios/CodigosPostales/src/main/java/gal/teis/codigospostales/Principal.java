/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.codigospostales;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        CodigoPostal codigosPostales = new CodigoPostal();

        //Menú principal
        int opcion;
        do {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Introduzca el número de la opción a relaizar:");
            System.out.println("1.Almacenar códigos postales de Galicia y Castilla-León.");
            System.out.println("2.Mostrar datos almacenados por pantalla.");
            System.out.println("3.Introducir código postal y obtener su provincia.");
            System.out.println("4.Eliminiar provincias de Lugo, León y Valladolid.");
            System.out.println("0.Salir");

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    /*Almacena en un HashMap los códigos postales de las provincias de Galicia y Castilla-Leon.*/
                    //codigosPostales.agregarCodigosPostalesGaliciaCastillaLeon();
                    codigosPostales.agregarCodigosPostalesGalicia();
                    System.out.println("Códigos postales almacenados.");
                    break;
                case 2:
                    /*Muestra por pantalla los datos introducidos*/
                    System.out.println(codigosPostales.listarKeySet());
                    //Otra opción:
                    //System.out.println(codigosPostales.listarEntry());
                    break;
                case 3:
                    /*Pide un código postal y muestra la provincia asociada si existe, sino avisa
                    al usuario*/
                    System.out.println("Introduzca un código postal: ");
                    String codigo = input.next();
                    System.out.println(codigosPostales.buscarCodigo(codigo));
                    break;
                case 4:
                    /*Elimina las provincias León, Lugo y Valladolid.*/
                    codigosPostales.eliminarLugoLeonValladolid();
//                    System.out.println("Introduzca una provincia a eliminar: ");
//                    String provincia = input.next();
//                    codigosPostales.eliminarProvincia(provincia);
                    System.out.println("Provincias eliminadas.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No ha introducido un valor que se corresponda con ninguna de las opciones.");
                    break;
            }
        } while (opcion != 0);

        input.close();

    }

}
