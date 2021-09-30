/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectocoche2;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String mensaje;

        //Crea una instancia de la clase Coche
        Coche coche1 = new Coche();
        Coche coche2 = new Coche();
        
        Coche coche3 = new Coche("Toyota", "Yaris");
        
        System.out.println(coche3.getMarca());
        System.out.println(coche3.getModelo());
        
        //sobrecarga
        Coche coche4 =new Coche("Yaris");
        
        System.out.println(coche4.getMarca());
        System.out.println(coche4.getModelo());
        
        coche1.setMarca("Citroen");
        coche2.setMarca("Opel");
        

        //Ejecuta un método a partir de la instancia
        mensaje = coche1.arrancar();
        System.out.println(mensaje);
        System.out.println(coche2.arrancar());

        //Modifica una propiedad a partir de la instancia
        coche1.setVel_max(200);
        System.out.println("El coche 1 puede alcanzar una velocidad de " + coche1.getVel_max());
        
        
        coche2.setVel_max(250);
        System.out.println("El coche 2 puede alcanzar una velocidad de " + coche2.getVel_max());
        
        //Muestra cuela es el coche que puede alcanzar una mayor velocidad
        if (coche1.getVel_max() > coche2.getVel_max()) {
            System.out.println("El primer coche es más veloz que el segundo");
        } else if (coche1.getVel_max() == coche2.getVel_max()) {
            System.out.println("Ambos coches tienen la misma velocidad máxima");
        } else {
            System.out.println("El segundo coche es más veloz que el primero");
        }
        
        //Muestra cuela es el coche que puede alcanzar una mayor velocidad
        //mensaje = coche1.vel_max > coche2.vel_max ? "coche 1":"coche 2";
        //System.out.println("El coche más rápido es el "+mensaje);
        
        //Por defecto los numeros son int, así que hay que hacer casting si queremos meter el short que pide el método
        System.out.println(coche1.girar_derecha((short)3));
        System.out.println(coche2.girar_derecha((short)23));
        
        coche1.setPosicion((byte)1);
        coche2.setPosicion((byte)2);
        
        System.out.println("Posición del coche 1 es "+coche1.getPosicion());
        System.out.println("Posición del coche 2 es "+coche2.getPosicion());
        
        System.out.println(coche1.adelantar(coche2));
        
        System.out.println("La nueva posición del coche 1 es "+coche1.getPosicion());
        System.out.println("La nueva posición del coche 2 es "+coche2.getPosicion());
        
        
    }
    //De forma automática, se elimina la instancia de memoria
    //cuando esta queda inaccesible
    }
    
