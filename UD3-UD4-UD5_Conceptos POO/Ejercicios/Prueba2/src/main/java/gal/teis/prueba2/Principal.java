/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.prueba2;

import java.util.Arrays;
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

        ejer5_MediasVarias();
    }

    static void ejer1_Factorial() {
        int num = 3;
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        System.out.println("El factorial de " + num + " es " + fact);
    }

    static void ejer2_Sumatorio() {
        int num = 3;
        int sumatorio = 0;
        for (int i = 1; i <= num; i++) {
            sumatorio *= i;
        }
        System.out.println("El sumatorio de " + num + " es " + sumatorio);
    }

    static void ejer3_Divisores() {
        int num = 10;
        System.out.println("Los divisores de " + num + "son:");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }

    static void ejer5_MediasVarias() {

        int cantidad_negativos = 0, cantidad_ceros = 0, suma_negativos = 0;
        double media_negativos = 0;

        double[] num = new double[10];
        Scanner miScanner = new Scanner(System.in);

        for (int i = 0; i <num.length; i++) {
            System.out.println("Introduce el número:");
            num[i] = miScanner.nextInt();

            if (num[i] < 0) {
                cantidad_negativos += 1;
                suma_negativos += num[i];
                media_negativos = suma_negativos / cantidad_negativos;
            } else if (num[i] == 0) {
                cantidad_ceros += 1;
            }
        }
//        System.out.println(Arrays.toString(num));
        System.out.println(media_negativos);
        System.out.println(cantidad_ceros);
    }

    static void ejer5_Primos() {
        int num = 10;
        boolean primo = true;
        //Se optimizará usando while
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                primo = false;
            }
        }
    }

    static void ejer6_Escalera() {
        int tope = 10;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}

