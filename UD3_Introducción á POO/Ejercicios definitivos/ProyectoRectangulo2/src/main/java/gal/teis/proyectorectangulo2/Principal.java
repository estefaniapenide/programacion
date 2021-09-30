/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectorectangulo2;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //Creo dos objetos tipo rectángulo
        Rectangulo rectangulo1 = new Rectangulo();
        Rectangulo rectangulo2 = new Rectangulo();

        //Asigno valores a las propiedades
        rectangulo1.setLado1(23);
        rectangulo1.setLado2(14);

        rectangulo2.setLado1(2);
        rectangulo2.setLado2(10);

        //Imprimo por pantalla el resultado de área y el perímetro de cada uno de los objetos
        System.out.println("Perímetro del rectángulo 1: " + rectangulo1.perimetro());
        System.out.println("Área del rectángulo 1: " + rectangulo1.area());

        System.out.println("Perímetro del rectángulo 2: " + rectangulo2.perimetro());
        System.out.println("Área del rectángulo 2: " + rectangulo2.area());

    }
    
}
