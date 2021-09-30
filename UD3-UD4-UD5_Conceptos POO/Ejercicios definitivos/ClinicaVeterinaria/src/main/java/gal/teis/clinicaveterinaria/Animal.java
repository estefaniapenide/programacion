/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.clinicaveterinaria;

/**
 *
 * @author a20estefaniapc
 */
public class Animal {
    //atributos
    private String nombre;
    private int edad;
    private String origen;
    private Historial historialClinico = new Historial();

    
    //constructores
    public Animal() {
    }
    
    public Animal(String nombre) {
        this.nombre=nombre;
    }

    public Animal(String nombre, int edad, String origen) {
        this.nombre = nombre;
        this.edad = edad;
        this.origen = origen;
    }
    
    
    //getters y setters
    public String getNombre(){
    return nombre;
    }
   
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
    
    public int getEdad(){
    return edad;
    }
    
    public void setEdad(int edad){
    this.edad = edad;
    }
    
    public String getOrigen(){
    return origen;
    }
    
    public void setOrigen(String origen){
    this.origen = origen;
    }
    
    public Historial getHistorialClinico(){
    return historialClinico;
    }
    
    public void setHisorialClinico(Historial historialClinico){
    this.historialClinico= historialClinico;
    }
    
    @Override
    public String toString(){
   
        return "Nombre: "+getNombre()+"\n"+
               "Edad: "+getEdad()+"\n"+
               "Origen: "+getOrigen()+"\n"+
               "Historial clínico: "+getHistorialClinico()+"\n";
}

}
