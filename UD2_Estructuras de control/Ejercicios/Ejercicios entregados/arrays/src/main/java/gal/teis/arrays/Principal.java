/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static void mes_secreto() {
        //Defino las variables e inicializo las necesarias
        String[] mes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        //Asigno el String situado en la décima psoición del array (índice 9) a mesSecreto, siendo así este el mes que hay que adivinar
        String mesSecreto = mes[9];
        String intento;
        boolean correcto;

        Scanner miScanner = new Scanner(System.in);
        //Se pide el mes a adivinar por teclado
        System.out.println("Adivine el mes secreto. Introduzca el nombre del mes en minúsculas: ");
        do {
            //Este bucle se repitirá simpre que se den alguna de las condiciones para las cuales se ha indicado correcto=false. Es decir, se
            //repetirá cuando el valor introducido por teclado no sea un String,o cuando el valor introducido por teclado sea un String 'intento' que no es igual al String 'mesSecreto'
            correcto = true;
            try {
                intento = miScanner.nextLine();
                if (mesSecreto.equals(intento)) {
                    System.out.println("¡Ha acertado!");
                } else if (!(mesSecreto.equals(intento))) {
                    System.out.println("No ha acertado. Intente adivinarlo introduciendo otro mes: ");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("El carater introducido no es válido");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);

    }

    static void letra_DNI() {
        
        //Defino las variables e inicializo las necesarias
        //Cada char del siguiente array está colocado en el lugar en el que su índce es igual al número con el que se corresponde el resto que se busca
        //y con el que se asocia la letra al DNI
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int dni = 53191630;
        int resto;
        boolean correcto;

        Scanner miScanner = new Scanner(System.in);
        do {
            correcto = true;
            //Pido por teclado un DNI sin letra. Restrinjo esta entrada por medio de un try...catch que hará que se repita el bucle si la variable introdicida
            //no es un int. También pongo las condiciones de que la longitud de ese int no pueda ser distinta de 8 (si es así se repetirá el bucle ya que no se
            //tratará de un número válido de DNI) y también que no pueda ser un número negativo(si lo es el bucle también se repetirá).
            System.out.println("Introduce tu DNI sin letra: ");
            try {
                dni = miScanner.nextInt();
                if (Integer.toString(dni).length() != 8) {
                    System.out.println("No has introducido un número de DNI válido");
                    correcto = false;
                } else if (dni < 0) {
                    System.out.println("No has introducido un número de DNI válido");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Has introducido números/caracteres incompatibles");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);
        
        //Cada resto resultante de la divisón del DNI entre 23 tiene asociado una letra, que es la correspondiente a dicho DNI
        resto = dni % 23;
        
        //En el array del principio cada char está asociado al índice cuyo valor es igual al resto al que se asocia ala letra.
        //Con un bucle for se recorre el array y en el momento en el que se encuentra el índice que coincide con el resto, se devuelve
        //el char asociado a ese índice.
        for (int i = 0; i < letras.length; i++) {
            if (i == resto) {
                System.out.println("Letra: " + letras[i]);
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
                System.out.println("1. Mes_secreto");
                System.out.println("2. Letra_DNI()");
                System.out.println("0. Salir");

                try {
                    vbleControl = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("No has introducido un número válido");
                    input.next();
                    correcto = false;
                }
            } while (!correcto);

            switch (vbleControl) {

                case 1:
                    mes_secreto();
                    break;
                case 2:
                    letra_DNI();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("El número introducido no se corresponde con ninguna de las opciones.");

            }

        } while (vbleControl != 0);

        input.close();
    }

}
