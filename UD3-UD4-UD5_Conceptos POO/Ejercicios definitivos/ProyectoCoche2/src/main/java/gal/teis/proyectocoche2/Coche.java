/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectocoche2;

/**
 *
 * @author a20estefaniapc
 */
public class Coche {

    private String marca;
    private String modelo;
    private double vel_max;
    private int potencia;
    private String tipo_carburante;
    private double velocidad;
    private double aceleracion;
    private byte posicion;

    public Coche() {
    }

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public Coche(String modelo) {
        this.modelo = modelo;
    }


//Metodos get que permiten la consulta del valor de los atributos
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getVel_max() {
        return vel_max;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getTipo_carburante() {
        return tipo_carburante;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public byte getPosicion() {
        return posicion;
    }

    //Métodos set que permiten la modificación del valor de los atributos
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setVel_max(double vel_max) {
        this.vel_max = vel_max;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setTipo_carburante(String tipo_carburante) {
        this.tipo_carburante = tipo_carburante;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setPosicion(byte posicion) {
        this.posicion = posicion;
    }

    //métodos
    String arrancar() {
        //instruccciones para arrancar el coche
        return "Está arrancando un " + marca;
    }

    String frenar() {
        //instrucciones para frenar el coche
        return "Está frenando un " + marca;
    }

    String acelerar() {
        //instrucciones para acelerar el coche
        return "Está acelerando un " + marca;
    }

    String girar_derecha(short grados) {
        //instruccion paar girar a la derecha
        return "Está girando a la derecha " + grados + " gardos un " + marca;
    }

    String adelantar(Coche coche) {
        byte a = getPosicion();
        byte b = coche.getPosicion();
        String mensaje;

        if (a > b) {
            byte aux = a;
            setPosicion(b);
            coche.setPosicion(aux);
            mensaje = "Se ha producido un adelantamiento";
        } else {
            mensaje = "No se ha producido ningún adelantamiento";
        }

        return mensaje;

    }

}
