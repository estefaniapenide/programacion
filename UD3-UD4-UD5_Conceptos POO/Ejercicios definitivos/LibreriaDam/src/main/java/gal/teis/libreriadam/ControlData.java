/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.libreriadam;

import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class ControlData {
    
/**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetros
     *
     * @param sc Tipo Scanner
     * @return Tipo byte - valor de tipo byte introducido por teclado
     */
    public static byte lerByte(Scanner sc) {
        byte valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextByte()) {
                valor = sc.nextByte();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: \n");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return valor Tipo short - valor de tipo short introducido por teclado
     */
    public static short lerShort(Scanner sc) {
        short valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextShort()) {
                valor = sc.nextShort();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo int - valor de tipo int introducido por teclado
     */
    public static int lerInt(Scanner sc) {
        int valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo long - valor de tipo long introducido por teclado
     */
    public static long lerLong(Scanner sc) {
        long valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextLong()) {
                valor = sc.nextLong();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor numérico. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo float - valor de tipo float introducido por teclado
     */
    public static float lerFloat(Scanner sc) {
        float valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextFloat()) {
                valor = sc.nextFloat();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor decimal. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo double - valor de tipo double introducido por teclado
     */
    public static double lerDouble(Scanner sc) {
        double valor = 0;
        boolean repetir = true;

        do {
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor decimal. "
                        + "\n\t\tVolva a introducir un número: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo boolean - valor de tipo boolean introducido por teclado
     */
    public static boolean lerBoolean(Scanner sc) {
        boolean valor = false;
        boolean repetir = true;

        do {
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                repetir = false;
            } else {
                System.out.print("\tERRO: debe introducir un valor booleano. "
                        + "\n\t\tVolva a introducir un booleano: ");
            }
            sc.nextLine();
        } while (repetir);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo String - valor de tipo String introducido por teclado
     */
    public static String lerString(Scanner sc) {
        String resultado = null;

        do {
            resultado = sc.nextLine();
        } while (resultado.isEmpty());

        return resultado;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo char - valor de tipo char introducido por teclado
     */
    public static char lerChar(Scanner sc) {
        String resultado = null;

        do {
            resultado = sc.nextLine();
        } while (resultado.isEmpty());

        return resultado.charAt(0);
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo char - valor de la pimera letra que se introduce por teclado
     */
    public static char lerLetra(Scanner sc) {
        char caracter = '\0';

        do {
            caracter = (sc.nextLine()).charAt(0);
        } while (!Character.isLetter(caracter));

        return caracter;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo String - valor de tipo String introducido por teclado
     */
    public static String lerNome(Scanner sc) {
        String nome = null;
        boolean repetir = true;

        do {
            nome = sc.nextLine();
            if (nome.isEmpty() || !nome.toUpperCase().matches("[A-ZÁÉÍÓÚÜÑ\\-\\s]*")) {
                System.out.print("\tERRO: debe introducir algún nome válido "
                        + "\n\t\tVolva a introducir: ");
            } else {
                repetir = false;
            }
        } while (repetir);

        return nome;
    }
}
