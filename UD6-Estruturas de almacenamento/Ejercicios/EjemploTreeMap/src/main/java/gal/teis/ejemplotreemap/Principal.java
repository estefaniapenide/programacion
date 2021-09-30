/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplotreemap;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persona p = new Persona(1,"María",167);
        
        p.getAgendatel().put("Trabajo", "986444444");
        p.getAgendatel().put("Oficina", "986555555");
        p.getAgendatel().put("Móvil", "686666666");
        p.getAgendatel().put("Casa", "986777777");
        
        System.out.println("Información de María\n "+p);
    }
    
}
