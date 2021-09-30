/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.interfazcollectionlist;

/**
 *
 * @author Estefania
 */
public class Persona {
    
    //atributos
    private int idPersona;
    private String nombre;
    private int altura;
    
    //constructores
    public Persona(int idPersona, String nombre, int altura) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.altura = altura;
    }
    
    public int getAltura(){
    return altura;
    }
    
    @Override
    public String toString(){
    return "Persona ->ID:"+idPersona+"\nNombre: "+nombre+"\nAltura: "+altura+"\n";
    }

}
