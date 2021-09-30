/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.mediostransporte;

/**
 *
 * @author a20estefaniapc
 */
public class Auto extends Transporte{
    
    private String modelo;
    
    public Auto(){
        super();
    }
    
    public String getModelo(){
    return modelo;
    }
    
    public void setModelo(String modelo){
    this.modelo = modelo;
    }
    
    @Override
    public String acelerar(){
    return "El auto acelera";
    }
    
    @Override
    public String desacelerar(){
    return "El auto desacelera";
    }
    
}
