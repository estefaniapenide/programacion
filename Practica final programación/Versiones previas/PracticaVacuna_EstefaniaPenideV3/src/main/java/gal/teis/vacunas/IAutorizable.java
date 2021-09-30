/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.excepciones_controldata.VacunaYaEvaluadaException;

/**
 * Para autorizar o no los objetos creados a partir de Vacuna.
 *
 * @author Estefania
 */
public interface IAutorizable {

    /**
     * Hace que una vacuna esté autorizada para su uso.
     *
     * @return boolean que indica si la operación ha sido realizada o no.
     * @throws VacunaYaEvaluadaException
     */
    public boolean autorizar() throws VacunaYaEvaluadaException;

    /**
     * Hace que una vacuna esté autorizada para su uso.
     *
     * @return boolean que indica si la operación ha sido realizada o no.
     * @throws VacunaYaEvaluadaException
     */
    public boolean rechazar() throws VacunaYaEvaluadaException;

}
