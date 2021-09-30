/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.orquesta;

/**
 *
 * @author Estefania
 */
public class Musica {

    /**
     * @param args the command line arguments
     */
    
    //No importa el tipo de Instrumento,
    //seguirá funcionando debido al Polimorfismo:
    static void afinar(Instrumento i) {
        System.out.println(i.afinar());
    }

    static void afinarTodo(Instrumento[] e) {
        for (int i = 0; i < e.length; i++) {
            afinar(e[i]);
        }
    }

    public static void main(String[] args) {
        Instrumento[] orquesta = new Instrumento[4];
        int i = 0;
        //Up-casting al asignarse el Arreglo
        orquesta[i++] = new Guitarra();
        orquesta[i++] = new Ukelele();
        orquesta[i++] = new Saxofon();
        orquesta[i++] = new Piano();
        afinarTodo(orquesta);
    }

}
