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
public class VacunaYaEvaluadaException extends Exception{
    
    public VacunaYaEvaluadaException(){
    super("ERROR. Esta vacuna ya ha sido evaluada. "
            + "\nNo está permitido cambiar sus parámetros autorizada/recahazada.");
    }
    
}
