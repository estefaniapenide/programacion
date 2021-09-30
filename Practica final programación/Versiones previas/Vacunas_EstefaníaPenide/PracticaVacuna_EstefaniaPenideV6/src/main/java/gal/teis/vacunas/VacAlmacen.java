/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Gestiona una colección de vacunas y tiene los métodos necesarios para
 * ejecutar las distintas operaciones del menú que se mustra en la clase
 * Aplicación.
 *
 * @author Estefania
 */
public class VacAlmacen {

//atributos
    private static HashMap<String, Vacuna> almacen = new HashMap<String, Vacuna>();

//métodos
    /**
     * Devuelve todas las vacunas almacenadas.
     *
     * @return almacen
     */
    public static HashMap<String, Vacuna> listarVacunasAlmacen() {
        return almacen;
    }

    /**
     * Añade vacunas a un HashMap, donde la clave es el código de la vacuna y el
     * valor es la propia vacuna.
     *
     * @param codigo (clave)
     * @param vacuna (valor)
     */
    public static void agregarVacuna(String codigo, Vacuna vacuna) {
        almacen.put(codigo, vacuna);
    }

    /**
     * Elimina vacunas de un HashMap por medio del código de la vacuna (que es
     * la clave).
     *
     * @param codigo (clave)
     */
    public static void eliminarVacuna(String codigo) {
        almacen.remove(codigo);
    }

    /**
     * Dado el código de una vacuna, busca la vacuna (si existe) alamecenada en
     * el HashMap, a través del mismo código que usa como clave. Si no existe,
     * devuelve una vacuna vacía.
     *
     * @param codigo (clave)
     * @return resultadoBusqueda
     */
    public static Vacuna buscarVacunaCodigo(String codigo) {
        Vacuna resultadoBusqueda = new Vacuna();

        Iterator<String> it = almacen.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals(codigo)) {
                resultadoBusqueda = almacen.get(key);
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado el nombre de una vacuna, busca y devuelve (si existen) un
     * HashMap<String,Vacuna> resultadoBusqueda de las vacunas alamecenadas en
     * el HashMap<String,Vacuna> almacen. Si no existe, devuelve un
     * HashMap<String,Vacuna>
     * vacío.
     *
     * @param nombre
     * @return resultadoBusqueda
     */
    public static HashMap<String, Vacuna> buscarVacunaNombre(String nombre) {
        HashMap<String, Vacuna> resultadoBusqueda = new HashMap<String, Vacuna>();
        for (Map.Entry<String, Vacuna> entry : almacen.entrySet()) {
            String codigo = entry.getKey();
            Vacuna vacuna = entry.getValue();
            if (vacuna.getNombre().equals(nombre)) {
                resultadoBusqueda.put(codigo, vacuna);
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado el principio activo de una vacuna, busca y devuelve (si existen) un
     * HashMap<String,Vacuna> resultadoBusqueda de las vacunas alamecenadas en
     * el HashMap<String,Vacuna> almacen. Si no existe, devuelve un
     * HashMap<String,Vacuna>
     * vacío.
     *
     * @param principioActivo
     * @return resultadoBusqueda
     */
    public static HashMap<String, Vacuna> buscarVacunaPrincipioActivo(String principioActivo) {
        HashMap<String, Vacuna> resultadoBusqueda = new HashMap<String, Vacuna>();
        for (Map.Entry<String, Vacuna> entry : almacen.entrySet()) {
            String codigo = entry.getKey();
            Vacuna vacuna = entry.getValue();
            if (vacuna.getPrincipioActivo().equals(principioActivo)) {
                resultadoBusqueda.put(codigo, vacuna);
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dada la farmaceutica de una vacuna, busca y devuelve (si existen) un
     * HashMap<String,Vacuna> resultadoBusqueda de las vacunas alamecenadas en
     * el HashMap<String,Vacuna> almacen. Si no existe, devuelve un
     * HashMap<String,Vacuna>
     * vacío.
     *
     * @param farmaceutica
     * @return resultadoBusqueda
     */
    public static HashMap<String, Vacuna> buscarVacunaFarmaceutica(String farmaceutica) {
        HashMap<String, Vacuna> resultadoBusqueda = new HashMap<String, Vacuna>();
        for (Map.Entry<String, Vacuna> entry : almacen.entrySet()) {
            String codigo = entry.getKey();
            Vacuna vacuna = entry.getValue();
            if (vacuna.getFarmaceutica().equals(farmaceutica)) {
                resultadoBusqueda.put(codigo, vacuna);
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado el precio recomendado de una vacuna, busca y devuelve (si existen)
     * un HashMap<String,Vacuna> resultadoBusqueda de las vacunas alamecenadas
     * en el HashMap<String,Vacuna> almacen. Si no existe, devuelve un
     * HashMap<String,Vacuna>
     * vacío.
     *
     * @param precioRecomendado
     * @return resultadoBusqueda
     */
    public static HashMap<String, Vacuna> buscarVacunaPrecioRecomendado(double precioRecomendado) {
        HashMap<String, Vacuna> resultadoBusqueda = new HashMap<String, Vacuna>();
        for (Map.Entry<String, Vacuna> entry : almacen.entrySet()) {
            String codigo = entry.getKey();
            Vacuna vacuna = entry.getValue();
            if (vacuna.getPrecioRecomendado() == precioRecomendado) {
                resultadoBusqueda.put(codigo, vacuna);
            }
        }
        return resultadoBusqueda;
    }

//métodos para mostrar por bloques las vacunas autorizadas, rechazas o pendientes de autorizar/rechazar.
    /**
     * Devuelve un HashMap de todas las vacunas almacenadas que han sido
     * autorizadas.
     *
     * @return vacunasAutorizadas
     */
    public static HashMap<String, Vacuna> verVacunasAutorizadas() {
        HashMap<String, Vacuna> vacunasAutorizadas = new HashMap<String, Vacuna>();

        for (String key : almacen.keySet()) {
            if (almacen.get(key).comprobacionVacunaAutorizada()) {
                vacunasAutorizadas.put(key, almacen.get(key));
            }
        }
        return vacunasAutorizadas;
    }

    /**
     * Devuelve un HashMap de todas las vacunas almacenadas que han sido
     * rechazadas.
     *
     * @return vacunasRechazadas
     */
    public static HashMap<String, Vacuna> verVacunasRechazadas() {
        HashMap<String, Vacuna> vacunasRechazadas = new HashMap<String, Vacuna>();

        for (String key : almacen.keySet()) {
            if (almacen.get(key).comprobacionVacunaRechazada()) {
                vacunasRechazadas.put(key, almacen.get(key));
            }
        }
        return vacunasRechazadas;
    }

    /**
     * Devuelve un HashMap de todas las vacunas almacenadas que no han sido ni
     * rechazadas ni autorizadas (están pendientes).
     *
     * @return vacunasPendientesAutorizarRechazar
     */
    public static HashMap<String, Vacuna> verVacunasPendientesAutorizarRechazar() {
        HashMap<String, Vacuna> vacunasPendientesAutorizarRechazar = new HashMap<String, Vacuna>();

        for (String key : almacen.keySet()) {
            if (!almacen.get(key).comprobacionVacunaRechazada() && !almacen.get(key).comprobacionVacunaAutorizada()) {
                vacunasPendientesAutorizarRechazar.put(key, almacen.get(key));
            }
        }
        return vacunasPendientesAutorizarRechazar;
    }

//método para ver la última fase implementada de cada vacuna
    /**
     * Devuelve un String convinación de Vacuna.toString() y
     * Vacuna.ultimaFaseimplementada() de cada una de las vacunas almacenadas en
     * el HashMap.
     *
     * @return ultimaFaseInvestigadaVacunas
     */
    public static String verUltimaFaseInvestigadaVacunas() {
        String ultimaFaseInvestigadaVacunas = "";
        for (String key : almacen.keySet()) {
            ultimaFaseInvestigadaVacunas = ultimaFaseInvestigadaVacunas + "\n"
                    + almacen.get(key).toString()
                    + almacen.get(key).ultimaFaseImplementada() + "\n";
        }
        return ultimaFaseInvestigadaVacunas;
    }

}
