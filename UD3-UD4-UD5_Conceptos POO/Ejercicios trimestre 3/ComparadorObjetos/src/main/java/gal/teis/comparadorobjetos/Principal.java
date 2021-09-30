/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.comparadorobjetos;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Linea l1 = new Linea(2, 3, 6, 7);
        Linea l2 = new Linea(2, 3, 3, 3);

        if (l1.esIgual(l2)) {
            System.out.println("Las dos líneas son iguales");
        } else {
            if (l1.esMasGrande(l2)) {
                System.out.println("La línea 1 es más grande que la línea 2");
            } else {
                System.out.println("La línea 1 es más pequeña que la línea 2");
            }
        }

        Rectangulo r1 = new Rectangulo(12, 3);
        Rectangulo r2 = new Rectangulo(4, 3);


        if (r1.esIgual(r2)) {
            System.out.println("Los dos rectángulos tienen el mismo perímetro");
        } else {
            if (r1.esMasGrande(r2)) {
                System.out.println("El rectángulo 1 tiene un perímetro mayor que el rectángulo 2");
            } else {
                System.out.println("El rectángulo 1 tiene un perímetro menor que el rectángulo 2");
            }
        }
        
        Rombo ro1 = new Rombo(3);
        Rombo ro2 = new Rombo(4);


        if (ro1.esIgual(ro2)) {
            System.out.println("Los dos rombos tienen el mismo perímetro");
        } else {
            if (ro1.esMasGrande(ro2)) {
                System.out.println("El rombo 1 tiene un perímetro mayor que el rombo 2");
            } else {
                System.out.println("El rombo 1 tiene un perímetro menor que el rombo 2");
            }
        }

    }

}
