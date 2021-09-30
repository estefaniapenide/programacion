/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.personas;

/**
 *
 * @author a20estefaniapc
 */

/*
Clase Alumno con los constructores de alumnos y getters y setters de sus atributos.
*/
public class Alumno extends Persona {
    
    //Atributos
    private int num_expediente;

    //constructores
    public Alumno() {
        super();//se puede omitir el super en este caso de contsructor "vacío", pero mejor ponerlo.
    }
    
    public Alumno(String nombre) {
        super(nombre);
    }
    
    public Alumno(String nombre, String apellido1, String apellido2) {
        super(nombre, apellido1, apellido2);
    }

    public Alumno(String nombre, String apellido1, String apellido2, String dni) {
        super(nombre, apellido1, apellido2, dni);   
    }
    
    public Alumno(String nombre, String apellido1, String apellido2, int num_expediente) {
        super(nombre, apellido1, apellido2);
        this.num_expediente=num_expediente;
    }

    //getters y setters    
    public int getNumExpediente() {
        return num_expediente;
    }

    public void setNumExpediente(int num_expediente) {
        this.num_expediente = num_expediente;
    }
    
    //métodos
    public String verAlumno(){
        String cadena="El alumno se llama "+getNombre();
    return cadena;
    }

}
