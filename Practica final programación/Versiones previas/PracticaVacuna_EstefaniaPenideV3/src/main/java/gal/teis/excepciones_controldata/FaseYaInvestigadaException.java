/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata;

/**
 *
 * @author Estefania
 */
public class FaseYaInvestigadaException extends Exception {
    
    public FaseYaInvestigadaException(int fase){
        
    super("ERROR. La fase "+fase+" de la vacuna ya ha sido investigada.\n"
            +"Una vez se ha emitido el resultado de la investigación de una fase, este no se puede modificar.\n\n");
    }
    
}
