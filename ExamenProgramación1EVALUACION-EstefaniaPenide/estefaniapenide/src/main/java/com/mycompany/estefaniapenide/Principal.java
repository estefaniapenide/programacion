/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estefaniapenide;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dominator
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    /**
     * Calculadora: Programa que pida 2 número reales y un carácter de operación
     * aritmética(+,-,*,/,%). Realiza la operación indicada entre ambos números.
     */
    static void opcion1() {
        //Defino e inicializo las variables necesarias
        double num1 = 0;
        double num2 = 0;
        String signo = "+";
        double resultado;
        boolean correcto;

        System.out.println("Calculadora");

        Scanner miScanner = new Scanner(System.in);
        //Pido por teclado los números restringiendo que sean reales y la operación aritmética que será un String solo válido
        //para las opciones +,-,*,/,%
        do {
            correcto = true;
            System.out.println("Introduce un número real (los decimales se indican con coma): ");
            try {
                num1 = miScanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un carácter válido. Debe ser un número real.");
                miScanner.nextLine();
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            System.out.println("Introduce otro número (los decimales se indican con coma): ");
            try {
                num2 = miScanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un carácter válido. Debe ser un número real.");
                miScanner.nextLine();
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            System.out.println("Introduce la operación aritmética que quieres realizar(+,-,*,/,%): ");
            try {
                signo = miScanner.next();
                if (signo.equals("+") || signo.equals("-") || signo.equals("*") || signo.equals("/") || signo.equals("%")) {
                } else {
                    System.out.println("No has introducido un carácter válido.Debes intrtroducir una de las opciones indicadas.");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un carácter válido. Debes intrtroducir una de las opciones indicadas.");
                miScanner.nextLine();
                correcto = false;
            }
        } while (!correcto);

        //En función del String de operación indicado y admitido relaizo la operación pertinenete y devuelvo el resultado por pantalla
        if (signo.equals("+")) {
            resultado = num1 + num2;
            System.out.println(num1 + "+" + num2 + "=" + resultado);
        } else if (signo.equals("-")) {
            resultado = num1 - num2;
            System.out.println(num1 + "-" + num2 + "=" + resultado);
        } else if (signo.equals("*")) {
            resultado = num1 * num2;
            System.out.println(num1 + "*" + num2 + "=" + resultado);
        } else if (signo.equals("/")) {
            resultado = num1 / num2;
            System.out.println(num1 + "/" + num2 + "=" + resultado);
        } else if (signo.equals("%")) {
            resultado = num1 % num2;
            System.out.println(num1 + "%" + num2 + "=" + resultado);
        }

    }

    /**
     * Capicúa: Adivina si el número introducido es capicúa o no.
     */
    static void opcion2() {
        //Introduzco la variables e inicilizo las necesarias
        String num;
        int num1 = 1;
        boolean correcto;

        System.out.println("Capicúa");

        Scanner miScanner = new Scanner(System.in);

        //Controlo que el número que se introduzca por teclado sea un entero
        do {
            correcto = true;
            System.out.println("Introduce un número entero positivo para comprobar si es capicúa o no: ");
            try {
                num1 = miScanner.nextInt();
                if (num1 < 0) {
                    System.out.println("Los números negativos no se analizarán en este programa. El signo menos ya los invalida para ser capicúa.");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un número entero positivo.");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);

        //Para poder analizar ese número necesitaré convertirlo en un String
        num = Integer.toString(num1);

        //Para darle la vuelta necesito el método reverse() que se le aplica a StringBuilder, por lo que lo convierto en eso.
        StringBuilder numero1 = new StringBuilder(num);
        //Para compararlo más alante necesitaré el método equals(), por lo que almaceno el primer número como un String otra vez.
        String numero3 = numero1.toString();

        //Le doy la vulata al número y lo almaceno como un String
        StringBuilder numero2 = new StringBuilder(numero1.reverse());
        String numero4 = numero2.toString();

        //Comparo los dos Strings almacenados: el introducido y el que está al revés y devuelvo el mensaje correspondiente
        if (numero3.equals(numero4)) {
            System.out.println("Es capicúa");
        } else {
            System.out.println("NO es capicúa");
        }

    }

//    static void opcion3() {
//      int[] tablero = new int[21];
//        int dado = 0;
//        int i = 0;
//        int p;
//
//        System.out.println("El gran juego del salto");
//
//        Random miRandom = new Random();
//
//        for (i = 0; i < tablero.length; i = i + dado) {
//
//            dado = miRandom.nextInt(6);
//            p = i + dado;
//            System.out.println("Te ha salido un " + dado);
//            if (p <= 20) {
//                System.out.println("LLegas hasta la casilla " + p);
//            }else{
//            System.out.println("Fin del juego");
//            }
//
//        }
//
//    }
    static void opcion3() {
        int[] tablero = new int[21];
        String t;
        int dado;
        int i;
        int p=0;

        Random miRandom = new Random();

        Scanner miScanner = new Scanner(System.in);

        for (i = 0; i < tablero.length; i = i + dado) {
            System.out.println("Para tirar el dado escribe una tecla cualquiera y pulsa enter");
            t = miScanner.nextLine();

            dado = miRandom.nextInt(6);
            System.out.println("Te ha salido un " + dado);
            p = i + dado;
            if(p<=20){
            System.out.println("LLegas hasta la casilla " + p);
            }else if(p>20){
            System.out.println("Vuelves a la casilla de salida");
            }

        }
    }

    public static void main(String[] args) {
        int vbleControl = 6;

        Scanner input = new Scanner(System.in);

        do {
            boolean correcto;
            do {
                correcto = true;

                System.out.println("--------------------------------------------------");
                System.out.println("Escribe el número de la opción a elegir:");
                System.out.println("1. Opción1");
                System.out.println("2. Opción2");
                System.out.println("3. Opción3");
                System.out.println("0. Salir");

                try {
                    vbleControl = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("No has introducido un número válido. Debes elegir entre las opciones del menú.");
                    input.next();
                    correcto = false;
                }
            } while (!correcto);

            switch (vbleControl) {

                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
                    break;
                case 3:
                    opcion3();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("El número introducido no se corresponde con ninguna de las opciones del menú.");

            }

        } while (vbleControl != 0);

        input.close();
    }

}
