/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacuna_estefaniapenidev3;

import gal.teis.excepciones_y_controltipos.VacunaYaEvaluadaException;

/**
 *
 * @author Estefania
 */
public interface IAutorizable {
    
    //public boolean autorizar(boolean autorizada);
    public boolean autorizar() throws VacunaYaEvaluadaException;
    public boolean rechazar() throws VacunaYaEvaluadaException;
    
}
