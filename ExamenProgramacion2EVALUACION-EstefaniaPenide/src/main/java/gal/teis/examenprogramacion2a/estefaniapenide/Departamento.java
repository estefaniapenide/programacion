/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.examenprogramacion2a.estefaniapenide;

import java.util.ArrayList;

/**
 *
 * @author a20estefaniapc
 */
public class Departamento {

    //atributos
    private String nombreDepartamento;
    private Directivo jefeDepartamento;
    private ArrayList<Trabajador> trabajadoresDepartamento = new ArrayList<Trabajador>();

    //constructores
    public Departamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Departamento(String nombreDepartamento, Directivo jefeDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.jefeDepartamento = jefeDepartamento;
    }

    public Departamento(String nombreDepartamento, Directivo jefeDepartamento, ArrayList<Trabajador> trabajadores) {
        this.nombreDepartamento = nombreDepartamento;
        this.jefeDepartamento = jefeDepartamento;
        this.trabajadoresDepartamento = trabajadores;
    }

    //getters y setters
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;

    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setJefeDepartamento(Directivo jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;

    }

    public Directivo getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setTrabajadoresDepartamento(ArrayList<Trabajador> trabajadoresDepartamento) {
        this.trabajadoresDepartamento = trabajadoresDepartamento;

    }

    public ArrayList<Trabajador> getTrabajadoresDepartamento() {
        return trabajadoresDepartamento;
    }

    @Override
    public String toString() {
        return "Nombre deparatmento: " + getNombreDepartamento() + "\n"
                + "Jefe deparatmento: " + getJefeDepartamento() + "\n"
                + "Tarbajadores deparatmento: " + getTrabajadoresDepartamento() + "\n";

    }

}
