/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.libreriadam;

/**
 *
 * @author Estefania
 */
public class ControlData {
    
 /**
     * @param args the command line arguments
     */
    

    /**
     * Devuelve el factorial del número introducido.
     *
     * @author estefania
     * @param num Tipo int; número del que se quiere calcular el factorial
     * @return tipo int; devuelve el factorila del parámetro num
     */
    public static int ejer1_Factorial(int num) {
        
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
//        System.out.println("El factorial de " + num + " es " + fact);
    }

    /**
     * Devuelve el sumatorio del número introducido.
     *
     * @author estefania
     * @param num Tipo int; número del que se quiere calcular el sumatorio
     * @return tipo int; devuelve el sumatorio del parámetro num
     */
    public static int ejer2_Sumatorio(int num) {
        
        int sumatorio = 0;
        for (int i = 1; i <= num; i++) {
            sumatorio *= i;
        }
        return sumatorio;
    }

    /**
     * Devuelve los divisores del número introducido.
     *
     * @author estefania
     * @param num Tipo int; número del que se quieren calcular sus divisores
     * @return tipo StringBuilder; devuelve los divisores del parámetro num
     */
    public static StringBuilder ejer3_Divisores(int num) {

        StringBuilder divisores = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisores.append(i).append(" ");
            }
        }
        return divisores;
    }

    /**
     * Calcula la media de los números negativos y cuenta los ceros
     * de un grupo de números introducidos en un array de doubles.
     *
     * @author estefania
     * @param num array tipo double; número del que se quiere calcular el factorial
     * @return array tipo double; devuelve la media de los números negativos y la cantidad de ceros
     */
      public static double[] ejer5_MediasVarias(double[] num) {

        int cantidad_negativos = 0, cantidad_ceros = 0, suma_negativos = 0;
        double media_negativos = 0;

       

        for (int i = 0; i < num.length; i++) {

            if (num[i] < 0) {
                cantidad_negativos += 1;
                suma_negativos += num[i];
                
            } else if (num[i] == 0) {
                cantidad_ceros += 1;
            }
            
        }
        media_negativos = suma_negativos / cantidad_negativos;
        double[] solucion={media_negativos,cantidad_ceros};
        return solucion;
    }
      
    /**
     * Calcula si un número es primo o no.
     *
     * @author estefania
     * @param num Tipo int; número que se evalúa para saber si es primo.
     * @return tipo boolean; devuelve si el numrero introducido es primo o no
     */
    public static boolean ejer5_Primos(int num) {
        
        boolean primo = true;
        //Se optimizará usando while
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                primo = false;
            }
        }
        return primo;
    }

    /**
     * Devuelve una escalera de filas de números donde el primer escalón va del
     * 1 al numero introducido, cada escalón va disminuyendo en un número.
     *
     * @author estefania
     * @param num Tipo int; número de escalones
     * @return tipo StringBuilder; devuelve la escalera con base de longitud
     * igual al numero introducido.
     */
    public static StringBuilder ejer6_Escalera(int num) {

        StringBuilder escalon = new StringBuilder();
        for (int i = 1; i < (num + 2); i++) {
            for (int j = 1; j < i; j++) {
                escalon.append(j);
            }
            escalon.append("\n");
        }
        return escalon;
    }

}

