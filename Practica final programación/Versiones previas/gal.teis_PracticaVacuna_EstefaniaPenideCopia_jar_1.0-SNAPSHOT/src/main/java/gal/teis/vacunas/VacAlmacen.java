/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Estefania
 */
public class VacAlmacen {

    private static HashMap<String,Vacuna> almacen = new HashMap<String,Vacuna>();
 

    public static HashMap<String,Vacuna> listarVacunasAlmacen() {
        return almacen;
    }

    public static void agregarVacuna(String codigo,Vacuna vacuna) {
        almacen.put(codigo,vacuna);
    }

    public static void eliminarVacuna(String codigo,Vacuna vacuna) {
        almacen.remove(codigo,vacuna);
    }

    //métodos de busqueda según distintos criterios
    public static ArrayList<Vacuna> buscarVacunaCodigo(String codigo) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (codigo.equals(almacen.get(i).getCodigo())&& !codigo.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }
    
    public static ArrayList<Vacuna> buscarVacunaNombre(String nombre) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (nombre.equals(almacen.get(i).getNombre())&& !nombre.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }
    
    public static ArrayList<Vacuna> buscarVacunaPrincipioActivo(String principioActivo) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (principioActivo.equals(almacen.get(i).getPrincipioActivo())&& !principioActivo.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }
    
    public static ArrayList<Vacuna> buscarVacunaFarmaceutica(String farmaceutica) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (farmaceutica.equals(almacen.get(i).getPrincipioActivo())&& !farmaceutica.equals("")) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }
    
    public static ArrayList<Vacuna> buscarVacunaPrecioRecomendado(double precioRecomendado) {
        ArrayList<Vacuna> resultadoBusqueda = new ArrayList<Vacuna>();
        for (int i = 0; i < almacen.size(); i++) {
            if (precioRecomendado == almacen.get(i).getPrecioRecomendado()&& precioRecomendado!=0) {
                resultadoBusqueda.add(almacen.get(i));
            }
        }
        return resultadoBusqueda;
    }
    
   

}
