/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_y_controltipos;

/**
 *
 * @author Estefania
 */
public class VacunasIgualesException extends Exception{
    
    public VacunasIgualesException(){
    super("ERROR. Ya existe esa vacuna en el almacén.\n"+
            "No puede haber dos vacunas con el mismo código.");
    }
    
}
