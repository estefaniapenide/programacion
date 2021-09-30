/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.trycatch;

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

        int num = 10, denom = 0, cociente;
        Scanner sc = new Scanner(System.in);

        try {
            num = sc.nextInt();
            cociente = num / denom;
            System.out.println("Resultado: " + cociente);
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción.");
            System.out.println("El error es " + e.getMessage());
            //muestra la traza de errores que se han producido
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

}
