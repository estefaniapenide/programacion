/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.excepciones_controldata_cadenas.ErrorFormatoCodigoException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Atributos, constructores y métodos necesarios para la creación de objetos
 * Vacuna.
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

//constructores
    /**
     * Constructor Vacuna vacío.
     */
    public Vacuna() {
    }

    /**
     * Constructor Vacuna con todos los parámetros.
     *
     * @param codigo
     * @param nombre
     * @param principioActivo
     * @param farmaceutica
     * @param precioRecomendado
     */
    public Vacuna(String codigo, String nombre, String principioActivo, String farmaceutica, double precioRecomendado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.farmaceutica = farmaceutica;
        this.precioRecomendado = precioRecomendado;

    }

//setters y getters necesarios(Además de los de código, que se van a utilizar, añado los de precioRecomendado porque lo pide el enunciado
//aunque en este proyecto no han sido llamados. El resto no los he incluido porque no se han llegado a emplear, aunque se podrán añadir
//en caso de necesitarlos en un futuro).
    /**
     * Modifica el valor del código de la vacuna.
     *
     * @param codigo
     * @throws ErrorFormatoCodigoException
     */
    public void setCodigo(String codigo) throws ErrorFormatoCodigoException {
        //Si el código no se corresponde con el formato:
        //         'Comenzará por la letra V seguida de una vocal en mayúsculas.
        //          A continuación, tres o cuatro letras minúsculas.
        //          Finaliza, o con dos números del 4 al 7, o bien con el número 8.'
        //Salta una excepción que impide que se guarde.
        Pattern pat = Pattern.compile("^V[AEIOU]([a-z]{3,4})(([4-7]{2})|8)");
        Matcher mat = pat.matcher(codigo);
        if (!mat.matches()) {
            throw new ErrorFormatoCodigoException(codigo);
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Devuelve el valor del código de la vacuna.
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Devuelve el valor del nombre de la vacuna.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
     /**
     * Devuelve el valor del principio activo de la vacuna.
     *
     * @return principio activo
     */
    public String getPrincipioActivo() {
        return principioActivo;
    }
    
     /**
     * Devuelve el valor de la farmacéutica de la vacuna.
     *
     * @return farmaceutica
     */
    public String getFarmaceutica() {
        return farmaceutica;
    }

    /**
     * Modifica el valor del precio recomendado de la vacuna.
     *
     * @param precioRecomendado
     */
    public void setPrecioRecomendado(double precioRecomendado) {
        this.precioRecomendado = precioRecomendado;
    }

    /**
     * Devuelve el valor del precio recomendado de la vacuna.
     *
     * @return precioRecomendado
     */
    public double getPrecioRecomendado() {
        return precioRecomendado;
    }

//métodos sobreescritos:
    /**
     * Modificado para que devuelva los valores de todos los atributos de cada
     * vacuna, así como la fecha en la que fue autorizada o rechazada en caso de
     * haberse producido.
     */
    @Override
    public String toString() {

        String datos = "";

        if (idioma.equals("esp")) {

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

        } else if (idioma.equals("eng")) {

            if (super.comprobacionVacunaAutorizada()) {
                datos = "Vaccine data:\n"
                        + "\tVACCINE AUTHORIZED\n"
                        + "\tCode                    " + codigo + "\n"
                        + "\tName                    " + nombre + "\n"
                        + "\tActive substance        " + principioActivo + "\n"
                        + "\tPharmaceutical company  " + farmaceutica + "\n"
                        + "\tPrice                   " + precioRecomendado + " €\n"
                        + "\tResult date             " + super.getFechaResultado() + "\n";
            } else if (super.comprobacionVacunaRechazada()) {
                datos = "Vaccine data:\n"
                        + "\tVACCINE REJECTED\n"
                        + "\tCode                    " + codigo + "\n"
                        + "\tName                    " + nombre + "\n"
                        + "\tActive substance        " + principioActivo + "\n"
                        + "\tPharmaceutical company  " + farmaceutica + "\n"
                        + "\tPrice                   " + precioRecomendado + " €\n"
                        + "\tResult date             " + super.getFechaResultado() + "\n";
            } else {
                datos = "Vaccine data:\n"
                        + "\tVACCINE PENDING TO AUTHORIZE/REJECT\n"
                        + "\tCode                    " + codigo + "\n"
                        + "\tName                    " + nombre + "\n"
                        + "\tActive substance        " + principioActivo + "\n"
                        + "\tPharmaceutical company  " + farmaceutica + "\n"
                        + "\tPrice                   " + precioRecomendado + " €\n";
            }
        }
        return datos;
    }

    /**
     * Modificado para que considere que dos vacunas son iguales si tienen el
     * mismo código.
     */
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

    /**
     * Modificado para que el hashCode de una vacuna sea el hashCode modificado
     * de su código.
     */
    @Override
    public int hashCode() {
        int result;
        return result = 25 * ((codigo == null) ? 0 : codigo.hashCode());
    }
}
