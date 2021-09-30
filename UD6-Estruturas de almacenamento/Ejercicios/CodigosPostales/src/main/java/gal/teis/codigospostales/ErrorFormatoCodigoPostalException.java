/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.codigospostales;

/**
 *
 * @author Estefania
 */
public class ErrorFormatoCodigoPostalException extends Exception{
    
    public ErrorFormatoCodigoPostalException(){
    super("No has introducido un código postal válido.\nFormato correcto: 5 dígitos");
    }
    
}
