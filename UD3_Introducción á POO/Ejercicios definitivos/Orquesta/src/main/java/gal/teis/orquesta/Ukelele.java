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
public class Ukelele extends Instrumento{
    
    @Override
    public String tipo(){
    return "Ukelele";
    }
    
    @Override
    public String tocar(){
        return "Tocar "+tipo();
    }
    
     
    @Override
    public String afinar(){
        return "Afinar "+tipo();
    }
    
}
