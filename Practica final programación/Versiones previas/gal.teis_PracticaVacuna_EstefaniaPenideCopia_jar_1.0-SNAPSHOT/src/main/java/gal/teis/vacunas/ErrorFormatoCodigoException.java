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
public class ErrorFormatoCodigoException extends Exception {

    public ErrorFormatoCodigoException(String codigo) {
        super("No se admite el código '" + codigo + "'.\nFormato correcto: \n"
                + "\tComenzará por la letra V seguida de una vocal en mayúsculas.\n"
                + "\tA continuación, tres o cuatro letras minúsculas.\n"
                + "\tFinaliza, o con dos números del 4 al 7, o bien con el número 8.\n");
    }

}
