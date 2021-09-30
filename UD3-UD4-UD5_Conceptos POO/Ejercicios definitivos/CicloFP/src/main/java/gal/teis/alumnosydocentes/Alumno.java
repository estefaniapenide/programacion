/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.alumnosydocentes;

/**
 *
 * @author a20estefaniapc
 */
public class Alumno {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private String direccion;
    private int dia_fn;
    private int mes_fn;
    private int year_fn;
    private int telefono;
    private int num_expediente;

    public Alumno() {
    }
    
    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    
    public Alumno(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Alumno(String nombre, String apellido1, String apellido2, String dni, int num_expediente) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.num_expediente = num_expediente;

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

    public void setDireaccion(String direccion) {
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

    public int getNumExpediente() {
        return num_expediente;
    }

    public void setNumExpediente(int num_expediente) {
        this.num_expediente = num_expediente;
    }

}
