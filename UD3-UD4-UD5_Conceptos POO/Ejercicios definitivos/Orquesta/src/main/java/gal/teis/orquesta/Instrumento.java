/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.orquesta;

/**
 *
 * @author Estefania
 */
public class Instrumento {
    
    public String tipo(){
    return "Instrumento";
    }
    
    public String tocar(){
        return "Tocar "+tipo();
    }
    
     
    public String afinar(){
        return "Afinar "+tipo();
    }
    
}
