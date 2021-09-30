/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacuna_estefaniapenidev3;

import gal.teis.excepciones_y_controltipos.ErrorFormatoCodigoException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Estefania
 */
public class Vacuna extends VacunaAutorizacion {

    //atributos
    private String codigo = "";
    private String nombre = "";
    private String principioActivo = "";
    private String farmaceutica = "";
    private double precioRecomendado;

    //constructores(ver cuales le pongo)
    public Vacuna() {
    }
    
        public Vacuna(String codigo, String nombre, String principioActivo, String farmaceutica, double precioRecomendado){
        this.codigo=codigo;
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.farmaceutica = farmaceutica;
        this.precioRecomendado = precioRecomendado;

    }


    //setters y getters
    public void setCodigo(String codigo) throws ErrorFormatoCodigoException {

        Pattern pat = Pattern.compile("^V[AEIOU]([a-z]{3,4})(([4-7]{2})|8)");
        Matcher mat = pat.matcher(codigo);
        if (!mat.matches()) {
            throw new ErrorFormatoCodigoException(codigo);
        } else {
            this.codigo = codigo;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setFarmacutica(String farmaceutica) {
        this.farmaceutica = farmaceutica;
    }

    public String getFarmaceutica() {
        return farmaceutica;
    }

    public void setPrecioRecomendado(double precioRecomendado) {
        this.precioRecomendado = precioRecomendado;
    }

    public double getPrecioRecomendado() {
        return precioRecomendado;
    }

    //métodos sobreescritos:
    @Override
    public String toString() {
        String datos;
        if (super.comprobacionVacunaAutorizada()) {
            datos = "Datos de la vacuna:\n"
                    + "\tVACUNA AUTORIZADA\n"
                    + "\tCódigo            " + codigo + "\n"
                    + "\tNombre            " + nombre + "\n"
                    + "\tP. Activo         " + principioActivo + "\n"
                    + "\tFarmaceutica      " + farmaceutica + "\n"
                    + "\tPrecio            " + precioRecomendado + " €\n"
                    + "\tFecha resultado   " + super.getFechaResultado() + "\n";
        } else if (super.comprobacionVacunaRechazada()) {
            datos = "Datos de la vacuna:\n"
                    + "\tVACUNA RECHAZADA\n"
                    + "\tCódigo            " + codigo + "\n"
                    + "\tNombre            " + nombre + "\n"
                    + "\tP. Activo         " + principioActivo + "\n"
                    + "\tFarmaceutica      " + farmaceutica + "\n"
                    + "\tPrecio            " + precioRecomendado + " €\n"
                    + "\tFecha resultado   " + super.getFechaResultado() + "\n";
        } else {
            datos = "Datos de la vacuna:\n"
                    + "\tVACUNA PENDIENTE DE AUTORIZAR/RECHAZAR\n"
                    + "\tCódigo            " + codigo + "\n"
                    + "\tNombre            " + nombre + "\n"
                    + "\tP. Activo         " + principioActivo + "\n"
                    + "\tFarmaceutica      " + farmaceutica + "\n"
                    + "\tPrecio            " + precioRecomendado + " €\n";
        }
        return datos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Objects.isNull(obj)) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Vacuna other = (Vacuna) obj;
        if (!codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        return result = 25 * ((codigo == null) ? 0 : codigo.hashCode());
    }
}
