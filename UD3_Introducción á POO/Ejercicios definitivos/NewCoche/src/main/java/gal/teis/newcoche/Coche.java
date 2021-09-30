/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.newcoche;

/**
 *
 * @author a20estefaniapc
 */
public class Coche {
    private String marca;
    private String modelo;
    
    //variable estática
    private static int contador;
    
    //constructor sobrecargado
    public Coche(String marca, String modelo){
        this.marca=marca;
        this.modelo=modelo;
        //incremento de la propiedad estática de clase
        contador++;
    
    }
    
    public Coche(){
    this("yaris","toyota");
    //Incremento de la propiedad estática de clase
    contador++;
    }
    
    //método de clase: static
    public static int getContador(){
    return contador;
    }
    
    //métodos de instancia
    public String getMarca(){
    return marca;
    }
    
    public String getModelo(){
    return modelo;
    }
    
    public void setMarca(String marca){
    this.marca=marca;
    }
    
    public void setModelo(String modelo){
    this.modelo=modelo;
    }
}
