/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata;

/**
 * Excepción para cuando se intenatan almacenar dos vacunas iguales.
 *
 * @author Estefania
 */
public class VacunasIgualesException extends Exception {

    public VacunasIgualesException() {
        super("ERROR. YA EXISTE ESA VACUNA EN EL ALAMACÉN.\n"
                + "No puede haber dos vacunas con el mismo código.\n"
                + "Si desea substituirla debe eliminar primero la que ya está almacenada.");
    }

}
