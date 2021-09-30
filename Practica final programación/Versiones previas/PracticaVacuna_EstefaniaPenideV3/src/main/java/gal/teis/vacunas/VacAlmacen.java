/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.ArrayList;

/**
 * Gestiona una colección de vacunas y tiene los métodos necesarios para
 * ejecutar las distintas operaciones del menú que se mustra en la clase
 * Aplicación.
 *
 * @author Estefania
 */
public class VacAlmacen {

//atributos
    private static ArrayList<Vacuna> almacen = new ArrayList<Vacuna>();

//métodos
    /**
     * Devuelve todas las vacunas almacenadas.
     *
     * @return almacen
     */
    public static ArrayList<Vacuna> listarVacunasAlmacen() {
        return almacen;
    }

    /**
     * Añade vacunas a un ArrayList<Vacuna>.
     *
     * @param vacuna
     */
    public static void agregarVacuna(Vacuna vacuna) {
        almacen.add(vacuna);
    }

    /**
     * Elimina vacunas de un ArrayList<Vacuna>.
     *
     * @param vacuna
     */
    public static void eliminarVacuna(Vacuna vacuna) {
        almacen.remove(vacuna);
    }

//métodos de busqueda según distintos criterios
    /**
     * Dado el código de una vacuna, busca y devuelve (si existe) la vacuna
     * alamecenada en el ArrayList<Vacuna>. Si no existe, devuelve una vacuna
     * vacía.
     *
     * @param codigo
     * @return resultadoBusqueda
     */
    public static Vacuna buscarVacunaCodigo(String codigo) {
        Vacuna resultadoBusqueda = new Vacuna();
        for (int i = 0; i < almacen.size(); i++) {
            if (codigo.equals(almacen.get(i).getCodigo())) {
                resultadoBusqueda = almacen.get(i);
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado el nombre de una vacuna, busca y devuelve (si existen) un
     * ArrayList<Vacuna> resultadoBusqueda de las vacunas alamecenadas en el
     * ArrayList<Vacuna> almacen. Si no existe, devuelve un ArrayList<Vacuna>
     * vacío.
     *
     * @param nombre
     * @return resultadoBusqueda
     */
    public static ArrayList<Vacuna> buscarVacunaNombre(String nombre) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (nombre.equals(almacen.get(i).getNombre())) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado el principio activo de una vacuna, busca y devuelve (si existen) un
     * ArrayList<Vacuna> resultadoBusqueda de las vacunas alamecenadas en el
     * ArrayList<Vacuna> almacen. Si no existe, devuelve un ArrayList<Vacuna>
     * vacío.
     *
     * @param principioActivo
     * @return resultadoBusqueda
     */
    public static ArrayList<Vacuna> buscarVacunaPrincipioActivo(String principioActivo) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (principioActivo.equals(almacen.get(i).getPrincipioActivo())) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado la farmacéutica de una vacuna, busca y devuelve (si existen) un
     * ArrayList<Vacuna> resultadoBusqueda de las vacunas alamecenadas en el
     * ArrayList<Vacuna> almacen. Si no existe, devuelve un ArrayList<Vacuna>
     * vacío.
     *
     * @param farmaceutica
     * @return resultadoBusqueda
     */
    public static ArrayList<Vacuna> buscarVacunaFarmaceutica(String farmaceutica) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (farmaceutica.equals(almacen.get(i).getFarmaceutica())) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

    /**
     * Dado el precio recomendado de una vacuna, busca y devuelve (si existen)
     * un ArrayList<Vacuna> resultadoBusqueda de las vacunas alamecenadas en el
     * ArrayList<Vacuna> almacen. Si no existe, devuelve un ArrayList<Vacuna>
     * vacío.
     *
     * @param precioRecomendado
     * @return resultadoBusqueda
     */
    public static ArrayList<Vacuna> buscarVacunaPrecioRecomendado(double precioRecomendado) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (precioRecomendado == almacen.get(i).getPrecioRecomendado()) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

//métodos para mostrar por bloques las vacunas autorizadas, rechazas o pendientes de autorizar/rechazar.
    /**
     * Devuelve un ArrayList<Vacuna> de todas las vacunas almacenadas que han sido
     * autorizadas.
     *
     * @return vacunasAutorizadas
     */
    public static ArrayList<Vacuna> verVacunasAutorizadas() {
        ArrayList<Vacuna> vacunasAutorizadas = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).comprobacionVacunaAutorizada()) {
                vacunasAutorizadas.add(almacen.get(i));
            }
        }

        return vacunasAutorizadas;
    }
    
    /**
     * Devuelve un ArrayList<Vacuna> de todas las vacunas almacenadas que han sido
     * rechazadas.
     *
     * @return vacunasRechazadas
     */
    public static ArrayList<Vacuna> verVacunasRechazadas() {
        ArrayList<Vacuna> vacunasRechazadas = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).comprobacionVacunaRechazada()) {
                vacunasRechazadas.add(almacen.get(i));
            }
        }
        return vacunasRechazadas;
    }
    
    /**
     * Devuelve un ArrayList<Vacuna> de todas las vacunas almacenadas que no han sido ni
     * rechazadas ni autorizadas (están pendientes).
     *
     * @return vacunasPendientesAutorizarRechazar
     */
    public static ArrayList<Vacuna> verVacunasPendientesAutorizarRechazar() {
        ArrayList<Vacuna> vacunasPendientesAutorizarRechazar = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (!almacen.get(i).comprobacionVacunaRechazada() && !almacen.get(i).comprobacionVacunaAutorizada()) {
                vacunasPendientesAutorizarRechazar.add(almacen.get(i));
            }
        }
        return vacunasPendientesAutorizarRechazar;
    }
    
//método para ver la última fase implementada de cada vacuna
    /**
     * Devuelve un String convinación de Vacuna.toString() y
     * Vacuna.ultimaFaseimplementada() de cada una de las vacunas almacenadas en
     * el ArrayList<Vacuna>.
     *
     * @return ultimaFaseInvestigadaVacunas
     */
    public static String verUltimaFaseInvestigadaVacunas() {
        String ultimaFaseInvestigadaVacunas = "";
        for (int i = 0; i < almacen.size(); i++) {
            ultimaFaseInvestigadaVacunas = ultimaFaseInvestigadaVacunas + "\n"
                    + almacen.get(i).toString()
                    + almacen.get(i).ultimaFaseImplementada() + "\n";
        }
        return ultimaFaseInvestigadaVacunas;
    }

}
