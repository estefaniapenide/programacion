/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacuna_estefaniapenidev4;

import gal.teis.excepciones_y_controltipos.VacunaYaEvaluadaException;
import gal.teis.excepciones_y_controltipos.VacunasIgualesException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Estefania
 */
public class VacAlmacen {

    private static HashMap<String, Vacuna> almacen = new HashMap<String, Vacuna>();

    public static HashMap<String, Vacuna> listarVacunasAlmacen() {
        return almacen;
    }

    public static void agregarVacuna(String codigo, Vacuna vacuna) {
        almacen.put(codigo, vacuna);
    }

    public static void eliminarVacuna(String codigo) {
        almacen.remove(codigo);
    }

//métodos de busqueda según distintos criterios
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

//    public static ArrayList<Vacuna> buscarVacunaNombre(String nombre) {
//        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
//        for (int i = 0; i < almacen.size(); i++) {
//            if (nombre.equals(almacen.get(i).getNombre()) && !nombre.equals("")) {
//                resultadoBusqueda.add(almacen.get(i));
//            }
//        }
//        return resultadoBusqueda;
//    }
//
//    public static ArrayList<Vacuna> buscarVacunaPrincipioActivo(String principioActivo) {
//        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
//        for (int i = 0; i < almacen.size(); i++) {
//            if (principioActivo.equals(almacen.get(i).getPrincipioActivo()) && !principioActivo.equals("")) {
//                resultadoBusqueda.add(almacen.get(i));
//            }
//        }
//        return resultadoBusqueda;
//    }
//
//    public static ArrayList<Vacuna> buscarVacunaFarmaceutica(String farmaceutica) {
//        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
//        for (int i = 0; i < almacen.size(); i++) {
//            if (farmaceutica.equals(almacen.get(i).getPrincipioActivo()) && !farmaceutica.equals("")) {
//                resultadoBusqueda.add(almacen.get(i));
//            }
//        }
//        return resultadoBusqueda;
//    }
//
//    public static ArrayList<Vacuna> buscarVacunaPrecioRecomendado(double precioRecomendado) {
//        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
//        for (int i = 0; i < almacen.size(); i++) {
//            if (precioRecomendado == almacen.get(i).getPrecioRecomendado() && precioRecomendado != 0) {
//                resultadoBusqueda.add(almacen.get(i));
//            }
//        }
//        return resultadoBusqueda;
//    }
//métodos para mostrar por bloques las vacunas autorizadas, rechazas o pendientes de autorizar/rechazar.
    public static HashMap<String, Vacuna> verVacunasAutorizadas() {
        HashMap<String, Vacuna> vacunasAutorizadas = new HashMap<String, Vacuna>();

        for (String key : almacen.keySet()) {
            if (almacen.get(key).comprobacionVacunaAutorizada()) {
                vacunasAutorizadas.put(key, almacen.get(key));
            }
        }
        return vacunasAutorizadas;
    }

    public static HashMap<String, Vacuna> verVacunasRechazadas() {
        HashMap<String, Vacuna> vacunasRechazadas = new HashMap<String, Vacuna>();

        for (String key : almacen.keySet()) {
            if (almacen.get(key).comprobacionVacunaRechazada()) {
                vacunasRechazadas.put(key, almacen.get(key));
            }
        }
        return vacunasRechazadas;
    }

    public static HashMap<String, Vacuna> verVacunasPendientesAutorizarRechazar() {
        HashMap<String, Vacuna> vacunasPendientesAutorizarRechazar = new HashMap<String, Vacuna>();

        for (String key : almacen.keySet()) {
            if (!almacen.get(key).comprobacionVacunaRechazada() && !almacen.get(key).comprobacionVacunaAutorizada()) {
                vacunasPendientesAutorizarRechazar.put(key, almacen.get(key));
            }
        }
        return vacunasPendientesAutorizarRechazar;
    }

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
