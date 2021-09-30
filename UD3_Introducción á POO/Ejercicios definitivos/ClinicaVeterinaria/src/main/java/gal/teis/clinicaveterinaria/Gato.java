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
public class Gato extends Animal{
    //atributos
     private boolean saleCalle;
    
    //constructores
     public Gato() {
         super();
    }
     
     public Gato(String nombre) {
        super(nombre);
    }

    public Gato(String nombre, int edad, String origen, boolean saleCalle) {
        super(nombre, edad, origen);
        this.saleCalle = saleCalle;
    }
    
    
    //getters y setters
    public boolean getSaleCalle(){
    return saleCalle;
    }
    
    public void setSaleCalle(boolean saleCalle){
    this.saleCalle= saleCalle;
    }
    
    @Override
    public String getNombre(){
    return "GT-"+super.getNombre();
    }
    
    @Override
    public String toString() {
        String calle;
        if (getSaleCalle()) {
            calle = "sí";
        } else {
            calle = "no";
        }
        String mensaje = super.toString();
        mensaje += "Sale a la calle: " + calle + "\n";
        return mensaje;
    }
    
}
