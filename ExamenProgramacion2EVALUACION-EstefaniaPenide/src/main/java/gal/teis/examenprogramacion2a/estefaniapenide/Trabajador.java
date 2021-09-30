/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.examenprogramacion2a.estefaniapenide;

/**
 *
 * @author a20estefaniapc
 */
public class Trabajador {

    //atributos
    private String nombre;
    private int edad;
    private int antiguedad;

    static int sueldoBase = 1200;

    public static final int ANT_NOVATO = 0;
    public static final int ANT_MADURO = 1;
    public static final int ANT_EXPERTO = 2;

    //constructor
    public Trabajador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Trabajador(String nombre, int edad, int antiguedad) {
        this.nombre = nombre;
        this.edad = edad;
        if (antiguedad == ANT_NOVATO) {
            this.antiguedad = antiguedad;
        } else if (antiguedad == ANT_MADURO) {
            this.antiguedad = antiguedad;
        } else if (antiguedad == ANT_EXPERTO) {
            this.antiguedad = antiguedad;
        }
    }

    //getters y setters
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;

    }

    public int getEdad() {
        return edad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;

    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public double calcularSueldo() {

        double sueldo = 0;

        if (antiguedad == ANT_NOVATO) {
            sueldo = sueldoBase + 150;
        } else if (antiguedad == ANT_MADURO) {
            sueldo = sueldoBase + 300;
        } else if (antiguedad == ANT_EXPERTO) {
            sueldo = sueldoBase + 600;
        }

        return sueldo;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n"
                + "Edad: " + getEdad() + "\n"
                + "Antigüedad: " + getAntiguedad() + "\n"
                + "Sueldo: " + calcularSueldo() + "\n";
    }

}
