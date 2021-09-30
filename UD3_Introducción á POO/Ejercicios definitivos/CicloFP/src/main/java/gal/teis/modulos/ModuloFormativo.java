/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.modulos;

import gal.teis.alumnosydocentes.Alumno;
import gal.teis.alumnosydocentes.Docente;

/**
 *
 * @author a20estefaniapc
 */
public class ModuloFormativo {

    private String nombre;
    private int horasSemanales;
    private Alumno[] alumnos;
    private Docente docente;

    public ModuloFormativo() {
    }

    public ModuloFormativo(String nombre) {
        this.nombre = nombre;
    }

    public ModuloFormativo(String nombre, int horasSemanales, Alumno[] alumnos, Docente docente) {
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.alumnos = alumnos;
        this.docente = docente;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

}
