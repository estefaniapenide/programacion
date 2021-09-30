/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.paises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */

/*Crear una clase Pais que permita almacenar atributos para
 *Nombre, Número de habitantes, Capital, Lenguas oficiales del país, Sistema de gobierno república o monarquía
 *Para crear un objeto Pais se debe poder hacer solo aportando el nombre aportando el nombre y la capital aportando el nombre, la capital y el sistema de gobierno
 * A la hora de implementar los constructores utilizar el método this cuando sea posible
 *Implementar métodos getter y setter para todos los atributos
 * Utilizar el objetos this
 */
public class Pais {

    //atributos
    private String nombre;
    private int habitantes;
    private String capital;
    private String lengua;
    private String gobierno;
    //republica: gobierno=true; monarquia gobierno=false;

    int num_leng;
    ArrayList<String> lenguas = new ArrayList<String>();
    Scanner input = new Scanner(System.in);
    char gob;
    String mensaje;

    //constructores
    public Pais() {
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public Pais(String nombre, String capital) {
        this.nombre = nombre;
        this.capital = capital;
    }

    public Pais(String nombre, String capital, String gobierno) {
        this.nombre = nombre;
        this.capital = capital;
        this.gobierno = gobierno;
    }

    //setters y getters
    public String getNombre() {
        return nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public String getCapital() {
        return capital;
    }

    public String getLengua() {
        return lengua;
    }

    public String getGobierno() {
        return gobierno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    
    public void setLengua() {
        boolean control;
        do {
            control = true;
            System.out.println("NÚMERO de lenguas oficiales: ");
            num_leng = ControlData.leerInt(input);
            if (num_leng <= 0) {
                System.out.println("Debe introducir un número positivo superior a 0.");
                control = false;
            }
        } while (!control);
        for (int i = 0; i < num_leng; i++) {
            System.out.println("Añade UNA lengua oficial: ");
            String lenguage = ControlData.leerString(input);
            lenguas.add(lenguage);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : lenguas) {
            sb.append(s);
            sb.append("  ");
        }
        this.lengua = sb.toString();
    }

    public void setGobierno() {
        boolean conf;
        do {
            conf = true;
            System.out.println("Introduzca su sistema de gobierno (M para monarquía, R para república): ");
            gob = ControlData.leerChar(input);
            if (gob == 'R') {
                mensaje = "República";
            } else if (gob == 'M') {
                mensaje = "Monaquía";
            } else {
                System.out.println("No ha introducido una opción válida");
                conf = false;
            }
        } while (!conf);
        this.gobierno = mensaje;
    }

}
