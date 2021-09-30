/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

/**
 *
 * @author Estefania
 */
public class FaseAnteriorNoSuperadaException extends Exception{
    
    public FaseAnteriorNoSuperadaException(int faseAnterior,int faseActual){
    super("Para poder realizar la fase "+faseActual+" debe primero superar la fase "+faseAnterior);
    }
    
}
