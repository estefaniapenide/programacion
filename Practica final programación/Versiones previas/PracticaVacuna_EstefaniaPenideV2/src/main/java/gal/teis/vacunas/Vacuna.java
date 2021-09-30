/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.Objects;

/**
 *
 * @author a20estefaniapc
 */
public class Vacuna extends VacunaAutorizacion {

    //atributos
    private String codigo;
    private String nombre;
    private String principioActivo;
    private String farmaceutica;
    private double precioRecomendado;

    //constructores(ver cuales le pongo)
    public Vacuna() {
    }

    public Vacuna(String codigo, String nombre, String principioActivo, String farmaceutica, double precioRecomendado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.farmaceutica = farmaceutica;
        this.precioRecomendado = precioRecomendado;
    }
    
    public Vacuna(String codigo, String nombre, String farmaceutica) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.farmaceutica=farmaceutica;
    }

    public Vacuna(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //setters y getters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        if(super.autorizar()){
        datos="Datos de la vacuna:\n"
                + "\tCódigo " + codigo
                + "\tNombre " + nombre
                + "\tP. Activo " + principioActivo
                + "\tFarmaceutica " + farmaceutica
                + "\tPrecio " + precioRecomendado + " €";
        }else if(super.rechazar()){
        datos="Datos de la vacuna:\n"
                + "\tVACUNA RECHAZADA"
                + "\tCódigo " + codigo
                + "\tNombre " + nombre
                + "\tFarmaceutica " + farmaceutica;
               
        }else{
        datos="Datos de la vacuna:\n"
                + "\tVACUNA PENDIENTE DE AUTORIZAR/RECHAZAR"
                + "\tCódigo " + codigo
                + "\tNombre " + nombre
                + "\tFarmaceutica " + farmaceutica;
        }
        return datos;
    }
    
    @Override
    public boolean equals(Object obj){
    if(this == obj) return true;
    if(Objects.isNull(obj)) return false;
    if(this.getClass() !=obj.getClass()) return false;
    Vacuna other =(Vacuna) obj;
    if(codigo != other.codigo) return false;
    return true;
    }
    
    @Override
    public int hashCode() {
        int result = 12;
        return result = 25 * ((codigo == null) ? 0 : codigo.hashCode());
    }
}
