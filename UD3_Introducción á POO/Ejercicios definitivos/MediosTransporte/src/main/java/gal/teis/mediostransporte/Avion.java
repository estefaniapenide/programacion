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
public class Avion extends Transporte {
    
    private double maxAlt;
    private int nroDeMotores;
    
    
    public Avion(){
        super();
    }
    
    public double getMaxAlt(){
    return maxAlt;
    }
    
    public void setMaxAlt(double maxAlt){
    this.maxAlt = maxAlt;
    }
    
    public int getNroDeMotores(){
    return nroDeMotores;
    }
    
    public void setNroDeMotores(int nroDeMotores){
    this.nroDeMotores = nroDeMotores;
    }
    
    @Override
    public String acelerar(){
    return "El avión acelera";
    }
    
    @Override
    public String desacelerar(){
    return "El avión desacelera";
    }
    
    public String descender(){
    return "El avión desciende";
    }
    
    public String ascender(){
    return "El avión asciende";
    }
    
}
