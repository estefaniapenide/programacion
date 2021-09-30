/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.comparadorobjetos;

/**
 *
 * @author Estefania
 */
public interface RelacionDimension {
    
    public boolean esMasGrande(Object b);
    
    public boolean esMasPequeno(Object b);
    
    public boolean esIgual(Object b);
    
}
