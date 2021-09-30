/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.interfazcollectionset;

import java.util.Objects;

/**
 *
 * @author a20estefaniapc
 */
public class Persona implements Comparable{
    
    //atributos
    private String nombre;
    private String nif;
    
    //constructores
    public Persona(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
    }
    
    
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNif() {
        return nif;
    }
    
    public void setNif(String nif) {
        this.nif = nif;
    }
    
    
    
    //métodos hashCode y equals sobreescritos
    @Override
    public int hashCode(){
    final int prime=31;
    int result = 1;
    result= result*prime*((nombre==null)?0:nombre.hashCode());
    result= result*prime*((nif==null)?0:nif.hashCode());
    return result;
    }
    
    @Override
    public boolean equals (Object obj){
    if(this == obj) return true;
    if (Objects.isNull(obj)) return false;
    if (this.getClass() != obj.getClass()) return false;
    Persona other = (Persona) obj;
    if (nif != other.nif) return false;
    if (nombre != other.nombre) return false;
    return true;
    }
    
    //método compareTo sobreescrito (de la implementación de Comparable)
    @Override
    public int compareTo(Object o) {
        return nombre.compareTo(((Persona) o).getNombre());
    }
    
}
