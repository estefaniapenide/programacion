/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.cajero;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 0;
        Cuenta cuenta1 = new Cuenta();
        double ingreso;
        double retiro;
        boolean ing;
        boolean ret;

        Scanner input = new Scanner(System.in);
        do {
            boolean correcto;
            do {
                correcto = true;
                System.out.println("------------------------------------------");
                System.out.println("Introduzca el número de la operación a realizar");
                System.out.println("1. Ingresar dinero");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Consultar saldo");
                System.out.println("0. Salir");

                try {
                    opcion = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("No has introducido un número válido");
                    input.next();
                    correcto = false;
                }
            } while (!correcto);

            switch (opcion) {
                case 1:
                    System.out.println("Ingresar dinero");

                    System.out.println("Indique la cantidad a ingresar: ");
                    ingreso = ControlData.leerDouble(input);

                    ing = cuenta1.hacerIngreso(ingreso);
                    if (ing == true) {
                        System.out.println("Ingreso realizado. Su saldo actual es " + cuenta1.getSaldo() + "€");
                    } else {
                        System.out.println("No es posible realizar el ingreso de una cantidad negativa. Para retirar dinero escoja la opción 2 del menú.");
                    }
                    break;
                case 2:
                    System.out.println("Retirar dinero");

                    System.out.println("Indique la cantidad a retirar: ");
                    retiro = ControlData.leerDouble(input);

                    ret = cuenta1.hacerReintegro(retiro);
                    if (ret == true) {
                        System.out.println("Operación realizada. Su saldo actual es " + cuenta1.getSaldo() + "€");;
                    } else {
                        System.out.println("No es posible retirar la cantidad indicada. Posiblemente saldo insuficiente o ha indicado una cantidad negativa.");
                    }
                      break;
                case 3:
                    System.out.println("Consultar saldo");
                    System.out.println("Su saldo actual es de " + cuenta1.getSaldo() + "€");
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros cajeros");
                    break;
                default:
                    System.out.println("No has introducido un valor que se corresponda con alguna de las opciones");
                    break;
            }

        } while (opcion != 0);

        input.close();
    }

}
