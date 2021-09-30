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
public class Persona {

    //atributos
    private String nombre = "";
    private String apellido1 = "";
    private String apellido2 = "";
    private String dni = "";
    private String email = "";
    private String direccion = "";
    private int dia_fn;
    private int mes_fn;
    private int year_fn;
    private int telefono;
    
    //constructores
    public Persona(){
    }

    public Persona(String nombre) {
        this.nombre=nombre;
    }
    
    public Persona(String nombre, String apellido1, String apellido2) {
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
    }
    
    public Persona(String nombre, String apellido1, String apellido2, String dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;

    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;

    }

    public int getDiafn() {
        return dia_fn;
    }

    public int getMesfn() {
        return mes_fn;
    }

    public int getYearfn() {
        return year_fn;
    }

    public String getFechaNacimiento() {
        String cadena = dia_fn + "/" + mes_fn + "/" + year_fn;
        return cadena;
    }

    public void setFechaNacimiento(int dia_fn, int mes_fn, int year_fn) {
        this.dia_fn = dia_fn;
        this.mes_fn = mes_fn;
        this.year_fn = year_fn;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
