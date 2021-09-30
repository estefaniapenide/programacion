/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ExcepcionesyControlTipos;

/**
 *
 * @author a20estefaniapc
 */
public class VacunasIgualesException extends Exception{
    
    public VacunasIgualesException(){
    super("ERROR. Ya existe esa vacuna en el almacén.");
    }
    
}
