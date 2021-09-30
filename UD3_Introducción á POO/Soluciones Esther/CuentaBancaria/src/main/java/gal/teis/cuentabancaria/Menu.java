/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.cuentabancaria;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Esther Ferreiro Imprime en pantalla un menú a partir dun ArrayList de
 * String que conten as opcións do menú. Permite facer un control de rango da
 * opción del menú que se introduce
 */
public class Menu {

    private ArrayList<String> opciones = new ArrayList<String>();
    private int numOpciones;

    public Menu(ArrayList opciones) {
        this.opciones = opciones;
        this.numOpciones = opciones.size();
    }

    /**
     * Imprime o menú na pantalla
     */
    public void printMenu() {
        for (int i = 1; i <= opciones.size(); i++) {
            System.out.println(i + ".- " + opciones.get(i - 1));
        }
    }

    /**
     * Comproba que o parámetro está dentro do rango de opcións coas que se 
     * creou o menú
     *
     * @param op int - valor a analizar como pertencente ou non ao rango de
     * opcións do menú
     * @return boolean - true se está no rango e false en caso contrario
     */
    public boolean rango(byte op) {
        boolean enrango = true;
        if (op < 1 || op > numOpciones) {
            enrango = false;
            System.out.println("\tERRO: debe introducir un valor dentro do rango de números posibles. "
                    + "\n\t\tVolva a introducir un número: \n");
        }
        return enrango;
    }
    /**
     * Lee un n´º por teclado ata que se introduce un nº correcto para o
     * rango establecido polas opcións do menú
     * @param sc Scanner - Instancia de Scanner para ler 
     */
    public void rango(Scanner sc) {
        boolean enrango = true;
        byte op = ControlData.lerByte(sc);
        do {
            if (op < 1 || op > numOpciones) {
                enrango = false;
                System.out.println("\tERRO: debe introducir un valor dentro do rango de números posibles. "
                        + "\n\t\tVolva a introducir un número: \n");
            }
        } while (!enrango);
    }
}
