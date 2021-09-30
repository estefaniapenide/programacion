/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ciclofp;

import gal.teis.alumnosydocentes.Alumno;
import gal.teis.alumnosydocentes.Docente;
import gal.teis.modulos.ModuloFormativo;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author a20estefaniapc
 */
public class Ciclo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creo un ArrayList donde ir añadiendo cada módulo creado
        ArrayList<ModuloFormativo> modulos = new ArrayList<ModuloFormativo>();

        //Creo un módulo y lo añado al ArrayList de módulos
        ModuloFormativo mod1 = new ModuloFormativo("Programación");
        modulos.add(mod1);

        //Creo un Array de alumnos del módulo de programación
        Alumno[] alumnos_programacion = new Alumno[20];
        alumnos_programacion[0] = new Alumno("Estefanía", "Penide", "Casanova");
        alumnos_programacion[1] = new Alumno("Nuria");
        alumnos_programacion[2] = new Alumno("Lourdes");
        alumnos_programacion[3] = new Alumno("Abel");
        alumnos_programacion[4] = new Alumno("Marcos");
        alumnos_programacion[5] = new Alumno("Will");

        
        mod1.setAlumnos(alumnos_programacion);
        mod1.setHorasSemanales(10);
        mod1.setDocente(new Docente("Esther", "Ferreiro", "Fernández"));

        System.out.println("Módulo: " + mod1.getNombre());
        System.out.println("Horas semanales: " + mod1.getHorasSemanales());
        System.out.println("Docente: " + mod1.getDocente().getNombre());
        System.out.println("Alumnos: ");
        for (Alumno elemento : mod1.getAlumnos()) {
            if (!Objects.isNull(elemento))
            System.out.println("\t" + elemento.getNombre());
        }
//        System.out.println("Alumnos: " + mod1.getAlumnos().toString());
    }

}
