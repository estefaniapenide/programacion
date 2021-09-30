/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.lanzamientoexcepcionesobjetosclasescreadasporprogramador;

/**
 *
 * @author Estefania
 */
public class NumeroFueraRangoException extends Exception {

    public NumeroFueraRangoException(int i_rango, int f_rango) {
        super("Número fuera de rango, debe introducir un nº entre "
                + i_rango + " y " + f_rango);
    }

}
