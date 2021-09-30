/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.pgr.ud3.polimorfismo_1;

/**
 *
 * @author Esther Ferreiro
 */
public class Asalariado {

    private String nombre;
    private String nif;
    private int diasVacaciones;
    private double salarioBase;

    public Asalariado(String nombre, String nif, int diasVacaciones, double salarioBase) {
        this.nombre = nombre;
        this.nif = nif;
        this.diasVacaciones = diasVacaciones;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }


    public int getDiasVacaciones() {
        return this.diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    public double getSalario() {
        return this.salarioBase;
    }

}
