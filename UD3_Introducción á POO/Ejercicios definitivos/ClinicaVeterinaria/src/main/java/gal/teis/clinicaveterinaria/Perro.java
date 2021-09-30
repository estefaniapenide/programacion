/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.clinicaveterinaria;

/**
 *
 * @author a20estefaniapc
 */
public class Perro extends Animal {

    //atributos
    private boolean pedigri;

    //constructores
    public Perro() {
        super();
    }

    public Perro(String nombre) {
        super(nombre);
    }

    public Perro(String nombre, int edad, String origen, boolean pedigri) {
        super(nombre, edad, origen);
        this.pedigri = pedigri;
    }

    //getters y setters
    public boolean getPedigri() {
        return pedigri;
    }

    public void setPedigri(boolean pedigri) {
        this.pedigri = pedigri;
    }

    @Override
    public String getNombre() {
        return "PR-" + super.getNombre();
    }

    @Override
    public String toString() {
        String pedigri;
        if (getPedigri()) {
            pedigri = "tiene";
        } else {
            pedigri = "no tiene";
        }
        String mensaje = super.toString();
        mensaje += "Pedigrí: " + pedigri + "\n";
        return mensaje;
    }
}
