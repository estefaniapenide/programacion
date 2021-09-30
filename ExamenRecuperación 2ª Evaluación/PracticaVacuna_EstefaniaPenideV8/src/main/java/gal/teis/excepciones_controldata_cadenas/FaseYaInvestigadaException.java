/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata_cadenas;

/**
 * Excepción para cuando se intenta modificar una fase que ya ha sido evaluada.
 *
 * @author Estefania
 */
public class FaseYaInvestigadaException extends Exception {

    public FaseYaInvestigadaException(int fase) {
        super("ERROR. La fase " + fase + " de la vacuna ya ha sido investigada.\n"
                + "Una vez se ha emitido el resultado de la investigación de una fase, este no se puede modificar.\n\n"
                + "ERROR. Phase " + fase + " of the vaccine has already been evaluated.\n"
                + "Once the result of a phase has been issued, it cannot be modified.");
    }

}
