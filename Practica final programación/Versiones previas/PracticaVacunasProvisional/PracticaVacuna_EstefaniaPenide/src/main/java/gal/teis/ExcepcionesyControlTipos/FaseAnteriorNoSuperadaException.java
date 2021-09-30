/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ExcepcionesyControlTipos;

/**
 *
 * @author Estefania
 */
public class FaseAnteriorNoSuperadaException extends Exception{
    
    public FaseAnteriorNoSuperadaException(int faseAnterior,int faseActual){
    super("ERROR. Para poder realizar la FASE "+faseActual+" debe PRIMERO SUPERAR la FASE "+faseAnterior);
    }
    
}
