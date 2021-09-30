/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacuna_estefaniapenidev3;

import gal.teis.excepciones_y_controltipos.VacunaYaEvaluadaException;
import gal.teis.excepciones_y_controltipos.VacunasIgualesException;
import java.util.ArrayList;

/**
 *
 * @author Estefania
 */
public class VacAlmacen {

    private static ArrayList<Vacuna> almacen = new ArrayList<Vacuna>();

    public static ArrayList<Vacuna> listarVacunasAlmacen() {
        return almacen;
    }

    public static void agregarVacuna(Vacuna vacuna) {
        almacen.add(vacuna);
    }
    
    public static void eliminarVacuna(Vacuna vacuna) {
        almacen.remove(vacuna);
    }

//métodos de busqueda según distintos criterios
    public static Vacuna buscarVacunaCodigo(String codigo) {
        Vacuna resultadoBusqueda = new Vacuna();
        for (int i = 0; i < almacen.size(); i++) {
            if (codigo.equals(almacen.get(i).getCodigo()) && !codigo.equals("")) {
                resultadoBusqueda = almacen.get(i);
            }
        }
        return resultadoBusqueda;
    }

    public static ArrayList<Vacuna> buscarVacunaNombre(String nombre) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (nombre.equals(almacen.get(i).getNombre()) && !nombre.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

    public static ArrayList<Vacuna> buscarVacunaPrincipioActivo(String principioActivo) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (principioActivo.equals(almacen.get(i).getPrincipioActivo()) && !principioActivo.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

    public static ArrayList<Vacuna> buscarVacunaFarmaceutica(String farmaceutica) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (farmaceutica.equals(almacen.get(i).getPrincipioActivo()) && !farmaceutica.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

    public static ArrayList<Vacuna> buscarVacunaPrecioRecomendado(double precioRecomendado) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (precioRecomendado == almacen.get(i).getPrecioRecomendado() && precioRecomendado != 0) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }

//métodos para mostrar por bloques las vacunas autorizadas, rechazas o pendientes de autorizar/rechazar.
    public static ArrayList<Vacuna> verVacunasAutorizadas() {
        ArrayList<Vacuna> vacunasAutorizadas = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).comprobacionVacunaAutorizada()) {
                vacunasAutorizadas.add(almacen.get(i));
            }
        }

        return vacunasAutorizadas;
    }

    public static ArrayList<Vacuna> verVacunasRechazadas() {
        ArrayList<Vacuna> vacunasRechazadas = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).comprobacionVacunaRechazada()) {
                vacunasRechazadas.add(almacen.get(i));
            }
        }
        return vacunasRechazadas;
    }

    public static ArrayList<Vacuna> verVacunasPendientesAutorizarRechazar() {
        ArrayList<Vacuna> vacunasPendientesAutorizarRechazar = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (!almacen.get(i).comprobacionVacunaRechazada() && !almacen.get(i).comprobacionVacunaAutorizada()) {
                vacunasPendientesAutorizarRechazar.add(almacen.get(i));
            }
        }
        return vacunasPendientesAutorizarRechazar;
    }

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
