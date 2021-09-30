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
public class Guacamayo extends Pajaro {
    
    //constructores
    public Guacamayo(){
    super();
    }
     
    public Guacamayo(String nombre) {
        super(nombre);
    }
    
    public Guacamayo(String nombre, int edad, String origen, String alimentacion) {
        super(nombre, edad, origen,alimentacion);
    }
}
