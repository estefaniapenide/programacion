/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.ExcepcionesyControlTipos.VacunaYaEvaluadaException;

/**
 *
 * @author a20estefaniapc
 */
public interface IAutorizable {
    
    //public boolean autorizar(boolean autorizada);
    public boolean autorizar() throws VacunaYaEvaluadaException;
    public boolean rechazar() throws VacunaYaEvaluadaException;
    
}
