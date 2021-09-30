/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.empleados;

/**
 *
 * @author Estefania
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
    
    public String getNombre(){
    return nombre;
    }
    
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
    
    public String getNif(){
    return nif;
    }
    
    public void setNif(String nif){
    this.nif = nif;
    }
    
    public int getDiasVacaciones(){
    return diasVacaciones;
    }
    
    public void setDiasVacaciones(int diasVacaciones){
    this.diasVacaciones = diasVacaciones;
    }
    
    public double getSalario(){
    return salarioBase;
    }
    
    
    
    
    
}
