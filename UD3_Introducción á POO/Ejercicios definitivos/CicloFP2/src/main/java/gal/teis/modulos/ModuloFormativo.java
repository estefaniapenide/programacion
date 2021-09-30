/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.modulos;

import gal.teis.alumnosydocentes.Alumno;
import gal.teis.alumnosydocentes.Docente;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author a20estefaniapc
 */

/*
Clase ModuloFormativo con los constructores de módulos, getters y setters de sus atributos y los métodos verProfesor, 
matriculacion, darBaja, listarAlumnado y verTodo.
*/
public class ModuloFormativo {

    //atributos
    public static final int MAT_MAX = 32;

    private String nombre = "";
    private int horasSemanales;
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    private Docente docente = new Docente();
    
    //constructores
    public ModuloFormativo() {
    }

    public ModuloFormativo(String nombre) {
        this.nombre = nombre;
    }

    public ModuloFormativo(String nombre, int horasSemanales, ArrayList<Alumno> alumnos, Docente docente) {
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.alumnos = alumnos;
        this.docente = docente;

    }

    //getters y setters
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

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    /*
    Método matriculación: añade alumnos al ArrayList<Alumno> alumnos.
    */
    public boolean matriculacion(Alumno alumno) {
        boolean matriculado = false;
        //Tener en cuenta los alumnos ya matriculados
        //y el tope de alumnos
        if (alumnos.size() < MAT_MAX) {
            //Si es menor del tope de matriculados, puedo matricular
            alumnos.add(alumno);
            matriculado = true;
        }
        return matriculado;
    }

    /*
    Método darBaja: elimina un alumno del ArrayList<Alumno> alumnos, mediante su DNI.
    */
    public boolean darBaja(String dni) {
        boolean baja = false;
        //Recorro el ArrayList de alumnos
        for (int i = 0; i < alumnos.size(); i++) {
            //Añado esta condición por si hay algún objeto(alumno) vacío en la lista.
            if (!Objects.isNull(alumnos.get(i))) {
                //Si el DNI introducido es igual al DNI del objeto Alumno por el que está pasando el for,
                //se elimina el objeto Alumno del ArrayList
                if (dni.equals(alumnos.get(i).getDni())) {
                    alumnos.remove(alumnos.get(i));
                    baja = true;
                }
            }
        }
        return baja;
    }

    /*
    Método verProfesor: devuelve el nombre del objeto Docente asociado al módulo.
    */
    public String verProfesor() {
        return docente.getNombre();
    }

    /*
    Método listarAlumnado: devuelve los nombres y apellidos de los alumnos del módulo
    */
    public StringBuilder listarAlumnado() {
        //Creo un StringBuilder al que ir añadiendo los datos de los alumnos
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de alumnos: \n");
        //Empleo un bucle for donde objeto a objeto del ArrayList me devuelve los atributos que pido de cada
        //uno de los objetos(alumno).
        for (Alumno alumno : alumnos) {
            sb.append(alumno.getNombre());
            sb.append(" ");
            sb.append(alumno.getApellido1());
            sb.append(" ");
            sb.append(alumno.getApellido2());
            sb.append("\n");
        }
        return sb;
    }

    /*
    Método verTodo: devuelve el nombre del módulo, el nombre y apellidos de su docente, las horas semanales
    del módulo y la lista de alumnos del módulo con nombres y apellidos.
    */
    public StringBuilder verTodo() {
        //Empleo el mismo sistema que he empleado en listarAlumnos pero esta vez
        //añadiendo el resto de los atributos del módulo.
        StringBuilder sb = new StringBuilder();
        sb.append("Módulo: ");
        sb.append(nombre);
        sb.append("\n");
        sb.append("Docente: ");
        sb.append(docente.getNombre());
        sb.append(" ");
        sb.append(docente.getApellido1());
        sb.append(" ");
        sb.append(docente.getApellido2());
        sb.append("\n");
        sb.append("Horas semanales: ");
        sb.append(horasSemanales);
        sb.append("\n");
        sb.append("Lista de alumnos: \n");
        for (Alumno alumno : alumnos) {
            sb.append("\t");
            sb.append(alumno.getNombre());
            sb.append(" ");
            sb.append(alumno.getApellido1());
            sb.append(" ");
            sb.append(alumno.getApellido2());
            sb.append("\n");
        }
        return sb;
    }

}
