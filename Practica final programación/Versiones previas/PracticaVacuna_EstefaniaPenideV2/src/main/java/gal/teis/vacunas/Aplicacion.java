/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.time.LocalDate;

/**
 *
 * @author a20estefaniapc
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vacuna prueba1 = new Vacuna("av45","una");
        
        
       
        prueba1.setFase1Superada(true);
        prueba1.setFase2Superada(true);
        prueba1.setFase3Superada(true);
        
        
       System.out.println(prueba1.verAutorizacion());
       System.out.println(prueba1.verRechazada());

        
        System.out.println("Fase1: "+prueba1.getFase1Superada());
        System.out.println("Fase2: "+prueba1.getFase2Superada());
        System.out.println("Fase3: "+prueba1.getFase3Superada());
        
        Vacuna prueba2 = new Vacuna("av45","dos");
        Vacuna prueba3 = new Vacuna("56yu","tres");
        
        System.out.println(prueba3.getCodigo());
        
    
        
        
        System.out.println("Autorizada: "+prueba1.autorizar());
        System.out.println("Rechazada: "+prueba1.rechazar());

    }
    
}
