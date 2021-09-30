/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.ExcepcionesyControlTipos.VacunaYaEvaluadaException;
import gal.teis.ExcepcionesyControlTipos.VacunasIgualesException;
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

//    public static void agregarVacuna(Vacuna vacuna) {
//        if (almacen.isEmpty()) {
//            almacen.add(vacuna);
//        }else {
//            for (int i = 0; i < almacen.size(); i++) {
//                if (!vacuna.equals(almacen.get(i))) {
//                    almacen.add(vacuna);
//                } 
//            }
//        }
//    }
    public static void agregarVacuna(Vacuna vacuna) {
        almacen.add(vacuna);
    }

    public static void eliminarVacuna(Vacuna vacuna) {
        almacen.remove(vacuna);
    }

//métodos de busqueda según distintos criterios
    public static ArrayList<Vacuna> buscarVacunaCodigo(String codigo) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (codigo.equals(almacen.get(i).getCodigo()) && !codigo.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
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

    
     public static boolean autorizarVacuna(String codigoVacuna) throws VacunaYaEvaluadaException {
         boolean resultado=false;
        for (int i = 0; i < almacen.size(); i++) {
            {
                if (almacen.get(i).getCodigo().equals(codigoVacuna)) {
                    almacen.get(i).autorizar();
                    if(almacen.get(i).autorizar()){
                    resultado=true;
                    }
                }
            }

        }
        return resultado;
    }

    
     public static boolean rechazarVacuna(String codigoVacuna) throws VacunaYaEvaluadaException {
         boolean resultado=false;
        for (int i = 0; i < almacen.size(); i++) {
            {
                if (almacen.get(i).getCodigo().equals(codigoVacuna)) {
                    almacen.get(i).rechazar();
                    if(almacen.get(i).rechazar()){
                    resultado=true;
                    }
                }
            }

        }
        return resultado;
    }

}
