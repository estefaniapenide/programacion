/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.debugging;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String nombre = "AbcDCba";
        boolean iguales = true;
        int tamano = nombre.length();
        
        char[] elNombre1 = new char[tamano];
        char[] elNombre2 = new char[tamano];
        
        //Paso el string a un array de caracteres
        //de forma directa e inversa
        for (int i = 0; i < tamano; i++) {
            elNombre1[i] = nombre.toLowerCase().charAt(i);
            elNombre2[tamano - i-1] = nombre.toLowerCase().charAt(i);
        }
        //Para que el código funcione se ha añadido .toLowerCase despues de nombre para que interprete todas las letras como minúsculas y así eviatr
        //problemas cuando se metan mayúsculas. Además se ha cambiado elNombre2[tamano-i] por el Nombre2[tamano-i-1] para que coincidan bien las cuentas
        
        //Determino si el String es un palíndromo
        for (int i = 0; i < tamano; i++) {
            if (elNombre1[i] != elNombre2[i]) {
                iguales = false;
            }
        }

        if (iguales) {
            System.out.println("Es un palíndromo");
        } else {
            System.out.println("No es un palíndromo");
        }
//        int n = 10;
//        for (int i=0;i<n;i++) {
//            System.out.println("el valor de i es " + i);
//            System.out.println("el valor de n-i es " + (n - i));
//            for (int j=1;j<i;j++) {
//                System.out.println("El valor de j es " + j);
//            }
//        }
    }

}
