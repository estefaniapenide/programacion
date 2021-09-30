/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ciclofp;

import gal.teis.personas.Alumno;
import gal.teis.personas.Docente;
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

        //Creo un ArrayList de alumnos del módulo de programación (aunque no es necesarrio pues puedo ir añadiendolos
        //medienate el método matriculación). Este ArrayList sería necesario si quisiera emplear el constructor del módulo
        //donde se introduce también el ArrayList de alumnos.
        ArrayList<Alumno> alumnos_programacion = new ArrayList<Alumno>();
        alumnos_programacion.add(new Alumno("Estefanía", "Penide", "Casanova","23678934O"));
        alumnos_programacion.add (new Alumno("Nuria"));
        alumnos_programacion.add (new Alumno("Lourdes"));
        alumnos_programacion.add (new Alumno("Abel"));
        alumnos_programacion.add (new Alumno("Marcos"));
        alumnos_programacion.add (new Alumno("Will"));
        alumnos_programacion.add (new Alumno("Antonio","García","Gonzalez","34257890A"));

        //Añado los atributos de ArrayList de alumnos, horas semanalesn y docente al módulo creado
        mod1.setAlumnos(alumnos_programacion);
        mod1.setHorasSemanales(10);
        mod1.setDocente(new Docente("Esther","Ferreiro", "Fernández"));
        
        //Matriculo a otro alumno usando el método matriculación:
        mod1.matriculacion(new Alumno ("Juan"));
        
        //Doy de baja a un alumno dando su DNI:
        mod1.darBaja("34257890A");
        
        //Muestro por pantalla el docente del módulo empleando el método verProfesor:
        System.out.println("Empleando el método verProfesor:");
        System.out.println(mod1.verProfesor());
        
        //Imprimo por pantalla la lista de nombres de alumnos matriculados:
        System.out.println("Empleando el método listarAlumnado:");
        System.out.println(mod1.listarAlumnado());
        
        //Imprimo por pantalla todos los datos del módulo:
        System.out.println("Empleando el método verTodo:");
        System.out.println(mod1.verTodo());
       
    }

}
