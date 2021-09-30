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
Clase Docente con los constructores de docentes y getters y setters de sus atributos.
*/
public class Docente extends Persona{

    //atributos
    private int nss;
    private float salario;

    //constructores
    public Docente() {
        super();
    }
    
    public Docente(String nombre) {
        super(nombre);
    }

    public Docente(String nombre, String apellido1, String apellido2) {
        super(nombre, apellido1, apellido2);

    }
    
    public Docente(String nombre, String apellido1, String apellido2, int salario) {
        super(nombre, apellido1, apellido2);
        this.salario=salario;

    }

    //getters y setters
    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    //Métodos
    public String verDocente(){
        String cadena="El alumnos se llama "+super.getNombre();//se puede poner sin el super pero ahora que
        //estamos aprendiend recomienda hacerlo. Y si se tratara de un un método de esta misma clase, pondremos this.
    return cadena;
    }

}
