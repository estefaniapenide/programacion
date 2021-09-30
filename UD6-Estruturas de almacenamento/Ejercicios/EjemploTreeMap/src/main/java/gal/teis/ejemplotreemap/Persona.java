/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplotreemap;

import java.util.TreeMap;

/**
 *
 * @author a20estefaniapc
 */
public class Persona implements Comparable {

    private int idPersona;
    private String nombre;
    private int altura;

    private TreeMap<String, String> agendatel;

    public Persona(int idPersona, String nombre, int altura) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.altura = altura;
        //inicialmente está vacío
        this.agendatel = new TreeMap<String, String>();
    }

    public TreeMap<String, String> getAgendatel() {
        return agendatel;
    }

    @Override
    public String toString() {
        return "Persona-> ID: " + idPersona + " Nombre: " + nombre + " Altura: " + altura + " \nAgenda: \n" + agendatel.toString().replace(",", "\n");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idPersona;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
    if(obj==null) return false;
    if(getClass()!=obj.getClass()) return false;
    final Persona other=(Persona)obj;
    if(this.idPersona!=other.idPersona)return false;
    return true;
    }

    @Override
    public int compareTo(Object o) {
        Persona p = (Persona) o;
        //Ascendente
        int resultado = this.nombre.compareTo(p.nombre);
        if (resultado == 0) {
            //Descendente
            resultado = Double.compare(p.altura, this.altura);
        }
        return resultado;
    }

}
