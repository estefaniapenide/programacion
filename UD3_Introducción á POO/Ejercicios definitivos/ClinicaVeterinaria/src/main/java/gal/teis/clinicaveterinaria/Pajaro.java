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
public class Pajaro extends Animal {
    //atributos
     private String alimentacion;
    
    //contructores
     public Pajaro() {
         super();
    }
     
    public Pajaro(String nombre) {
        super(nombre);
    }

    public Pajaro(String nombre, int edad, String origen, String alimentacion) {
        super(nombre, edad, origen);
        this.alimentacion = alimentacion;
    }
    
    
    //getters y setters
    public String getAlimentacion(){
    return alimentacion;
    }
    
    public void setAlimentacion(String alimentacion){
    this.alimentacion= alimentacion;
    }
    
    @Override
    public String getNombre(){
    return "PJ-"+super.getNombre();
    }
    
    @Override
    public String toString() {
 
        String mensaje = super.toString();
        mensaje += "Alimentación: " + getAlimentacion() + "\n";
        return mensaje;
    }
    
}
