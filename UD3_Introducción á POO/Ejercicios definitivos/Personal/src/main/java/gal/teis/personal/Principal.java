/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.personal;

import gal.teis.III.Tecnico;
import gal.teis.III.Oficial;
import gal.teis.II.Directivo;
import gal.teis.II.Operario;
import gal.teis.I.Empleado;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("Juan");
        System.out.println(empleado1.toString());
        
        Directivo directivo1 = new Directivo("Laura");
        System.out.println(directivo1.toString());
        
        Operario operario1 = new Operario("Pablo");
        System.out.println(operario1.toString()); 
        
        Oficial oficial1 = new Oficial("Marta");
        System.out.println(oficial1.toString());
        
        Tecnico tecnico1 = new Tecnico("Lucía");
        System.out.println(tecnico1.toString());
    }
    
}
