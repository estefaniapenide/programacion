/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         Scanner input = new Scanner(System.in);

        Vacuna prueba0 = new Vacuna();
        Vacuna prueba1 = new Vacuna();
        Vacuna prueba2 = new Vacuna();
        Vacuna prueba3 = new Vacuna();
        Vacuna prueba4 = new Vacuna();
        
        try{
        prueba0.setCodigo("VArft56");
        prueba1.setCodigo("VErft56");
        prueba2.setCodigo("VIrft56");
        prueba3.setCodigo("Vrft56");
        prueba4.setCodigo("VUrft56");
        }catch(ErrorFormatoCodigoException e){
        System.out.println(e.getMessage());
        }
        

        VacAlmacen.agregarVacuna(prueba0.getCodigo(),prueba0);
        VacAlmacen.agregarVacuna(prueba1.getCodigo(),prueba1);
        VacAlmacen.agregarVacuna(prueba2.getCodigo(),prueba2);
        VacAlmacen.agregarVacuna(prueba3.getCodigo(),prueba3);
        VacAlmacen.agregarVacuna(prueba4.getCodigo(),prueba4);
        System.out.println(VacAlmacen.listarVacunasAlmacen());
        
        prueba0.setNombre("cero");
        prueba0.setFase1Superada(true);
        prueba0.setFase2Superada(true);
        prueba0.setFase3Superada(true);
        prueba0.autorizar();
        System.out.println(prueba0);
        System.out.println("Autorizacion: "+prueba0.comprobacionVacunaAutorizada());
    }
}
