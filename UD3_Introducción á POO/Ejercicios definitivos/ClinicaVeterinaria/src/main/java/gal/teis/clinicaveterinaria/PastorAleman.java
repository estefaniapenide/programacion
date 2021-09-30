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
public class PastorAleman extends Perro{
    
    //constructores
    public PastorAleman(){
    super();
    }
    
    public PastorAleman(String nombre) {
        super(nombre);
    }

    public PastorAleman(String nombre, int edad, String origen, boolean pedigri) {
        super(nombre, edad, origen, pedigri);
    }
}
