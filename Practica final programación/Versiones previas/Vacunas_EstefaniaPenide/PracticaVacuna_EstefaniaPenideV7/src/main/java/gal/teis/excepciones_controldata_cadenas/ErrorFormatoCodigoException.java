/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata_cadenas;

/**
 * Excepción para emplear cuando un código no atiende al formato especificado.
 *
 * @author Estefania
 */
public class ErrorFormatoCodigoException extends Exception {

    public ErrorFormatoCodigoException(String codigo) {

        super("No se admite el código '" + codigo + "'.\nFormato correcto: \n"
                + "\tComenzará por la letra V seguida de una vocal en mayúsculas.\n"
                + "\tA continuación, tres o cuatro letras minúsculas.\n"
                + "\tFinaliza, o con dos números del 4 al 7, o bien con el número 8.\n\n"
                + "Code '" + codigo + "' is not supported.\nCorrect format: \n"
                + "\tStart with the letter V followed by an uppercase vowel.\n"
                + "\tThen three or four lowercase letters.\n"
                + "\tEnd, either with two numbers from 4 to 7, or with the number 8.\n");

    }

}
