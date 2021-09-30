/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.cuentabancaria;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author estherff
 */
public class Principal {
     static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
        boolean finalizar = false; //para controlar la salida del programa

        //Para trabajar on los datos de una cuenta
        String nCuenta;
        String titular;
        double saldo;
        CuentaBancaria nuevaCuenta = null;

        //Vbles e control de operaciones
        boolean realizado;

        try {
            do {
                switch (pintarMenu()) {

                    case 1://Crear cuenta bancaria con datos

                        System.out.println("\n***************************************************n"
                                + "SE CREA UNA CUENTA BANCARIA CON DATOS INICIALES\n");

                        //Pedir los datos para la creación de la cuenta
                        System.out.println("Introduce el titular de la cuenta");
                        titular = ControlData.lerString(sc);
                        System.out.println("Introduce el número de cuenta");
                        nCuenta = ControlData.lerString(sc);
                        System.out.println("Introduce el saldo inicial");
                        saldo = ControlData.lerDouble(sc);

                        //Se crea una nueva cuenta
                        nuevaCuenta = new CuentaBancaria(titular, nCuenta, saldo);

                        break;

                    case 2://Ingresar en una cuenta bancaria

                        System.out.println("\n***************************************************n"
                                + "SE VA A REALIZAR UN INGRESO EN UNA CUENTA BANCARIA\n");

                        boolean ingresoCorrecto = false;
                        do {
                            System.out.println("Introduce la cantidad de dinero a ingresar");
                            double aIngresar = ControlData.lerDouble(sc);
                            realizado = nuevaCuenta.hacerIngreso(aIngresar);
                            //Si el ingreso se ha realizado con éxito
                            if (realizado) {
                                System.out.println("El ingreso se ha realizado con éxito. "
                                        + "El saldo actual de la cuenta es "
                                        + nuevaCuenta.getSaldo());
                                ingresoCorrecto = true;
                            } else {//Si se ha introducido una cantidad negativa el ingreso no se realiza
                                System.out.println("No es un ingreso correcto, vuelva a realizar la operación");
                            }
                        } while (!ingresoCorrecto);

                        break;

                    case 3://Retirar dinero de una cuenta bancaria
                        System.out.println("\n***************************************************n"
                                + "SE VA A REALIZAR UN REINTEGRO EN UNA CUENTA BANCARIA\n");

                        boolean reintegroCorrecto = false;
                        do {
                            System.out.println("Introduce la cantidad de dinero a retirar");
                            double aRetirar = ControlData.lerDouble(sc);
                            realizado = nuevaCuenta.hacerReintegro(aRetirar);
                            //Si el ingreso se ha realizado con éxito
                            if (realizado) {
                                System.out.println("El reintegro se ha realizado con éxito. "
                                        + "El saldo actual de la cuenta es "
                                        + nuevaCuenta.getSaldo());
                                reintegroCorrecto = true;
                            } else {//Si se ha introducido una cantidad negativa el ingreso no se realiza
                                System.out.println("No es un reintegro correcto, no hay suficiente saldo");
                            }
                        } while (!reintegroCorrecto);

                        break;

                    case 4://Ver información de una cuenta bancaria
                        System.out.println("\n************************************\n"
                                + "INFORMACIÓN DE UNA CUENTA BANCARIA\n");

                        System.out.println("La información de la cuenta es "
                                + nuevaCuenta.cuentaComoString());

                        break;

                    case 5:

                        finalizar = true;
                }

            } while (!finalizar);
        } catch (Exception e) {
            System.out.println("Se ha producido un problema " + e.getMessage());
        } finally {
            sc.close();
        }

    }

    static byte pintarMenu() {
        byte opcion = 0;
        boolean correcta = false;
        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            ArrayList<String> misOpciones = new ArrayList<String>();
            misOpciones.add("Crear cuenta bancaria");
            misOpciones.add("Ingresar en una cuenta bancaria");
            misOpciones.add("Retirar dinero en una cuenta bancaria");
            misOpciones.add("Ver información de una cuenta bancaria");
            misOpciones.add("Finalizar");

            /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
            Menu miMenu = new Menu(misOpciones);
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            opcion = ControlData.lerByte(sc);
            correcta = miMenu.rango(opcion);

        } while (!correcta);

        return opcion;
    }

}
