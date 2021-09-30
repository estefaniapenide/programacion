/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.robots;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author a20estefaniapc
 */
public class Robot {

    private String fecha;
    private String nombre;
    private int id;
    private String origen;

    public Robot(String nombre, int id, String origen) {
        setFecha();
        this.nombre = nombre;
        this.id=id;
        this.origen=origen;
    }

    private void setFecha() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        fecha = date.format(formatter);
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Robot con id " + id + ", creado el " + fecha + ", responde por " + nombre + ".";
    }

    @Override
    public int hashCode() {
        return nombre.hashCode()+id;
    }

    @Override
    public boolean equals(Object obj) {
        Robot r = (Robot) obj;
        return r.nombre.equals(this.nombre) && r.id == this.id;
    }

}
