/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.clinicaveterinaria;

import java.util.ArrayList;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ¿De qué tipo tendría que ser un ArrayList que permitiese almacenar cualquier animal?
        //Indíca qué propiedades y métodos serán visibles desde un elemento del ArrayList
        //Respuesta:
        //ArrayList<Animal> animales = new ArrayList<Animal>();
        //Serán visibles el historial clínico y los getters y setters de Animal salvo getNombre que será el sobreescrito en perro,
        //gato o pájaro según corresponda. Para poder acceder a métodos propios de cada subclase hay que hacer un casting.
        
        //¿De qué tipo tendría que ser un ArrayList que permitiese almacenar solamente cualquier perro?
        //Indica a qué propiedades y métodos serían visibles desde un elemento ArrayList
        //Respuesta:
        //ArrayList<Perro> perros = new ArrayList<Perro>();
        //Serían visibles el historial clínico y los getters y setters de Animal salvo el 
        //getNombre que será el sobreescrito en la clase perro, además de los métdos getPedigri y setPedigri.
        
        
        
        //Creo todos los animales
        Animal animal = new Animal("animal", 2, "Vigo");
        Perro perro = new Perro("perro", 3, "Pontevedra", true);
        Gato gato = new Gato("gato", 1, "A coruña", true);
        Pajaro pajaro = new Pajaro("pájaro", 2, "Cangas", "dfgd");
        PastorAleman pastorAleman = new PastorAleman("Pastor alemán", 3, "Vigo", false);
        Dalmata dalmata = new Dalmata("Dalmata", 4, "Ponteareas", true);
        Persa persa = new Persa("Persa", 12, "Pontevedra", false);
        Siames siames = new Siames("Siames", 5, "Bueu", true);
        Loro loro = new Loro("Loro", 4, "Ponferrada", "ssfd");
        Guacamayo guacamayo = new Guacamayo("Guacamayo", 1, "Vigo", "sdsfdg");
        
        Historial historialGuacamayo = new Historial("24/07/2020","AAA","BBB","CCC");
        guacamayo.setHisorialClinico(historialGuacamayo);
        
        //System.out.println(guacamayo.getHistorialClinico().toString());
        //System.out.println(guacamayo.getHistorialClinico());
        System.out.println(animal.toString());
        System.out.println(pastorAleman.toString());
        System.out.println(siames.toString());
        System.out.println(guacamayo.toString());

        ArrayList<Animal> animales = new ArrayList<Animal>();
        animales.add(animal);
        animales.add(perro);
        animales.add(gato);
        animales.add(pajaro);
        animales.add(pastorAleman);
        animales.add(dalmata);
        animales.add(persa);
        animales.add(siames);
        animales.add(loro);
        animales.add(guacamayo);

        for (int i = 0; i < animales.size(); i++) {
            System.out.println("Nombre: " + animales.get(i).getNombre() + "\n"
                    + "Edad: " + animales.get(i).getEdad() + "\n"
                    + "Origen: " + animales.get(i).getOrigen());
            if (animales.get(i) instanceof Perro) {
                Perro perroP = (Perro) animales.get(i);
                System.out.println("Pedrigrí: " + perroP.getPedigri());
            } else if (animales.get(i) instanceof Gato) {
                Gato gatoG = (Gato) animales.get(i);
                System.out.println("Sale a la calle: " + gatoG.getSaleCalle());
            } else if (animales.get(i) instanceof Pajaro) {
                Pajaro pajaroP = (Pajaro) animales.get(i);
                System.out.println("Alimentación: " + pajaroP.getAlimentacion());
            }
            System.out.println("Historial clínico: " + animales.get(i).getHistorialClinico());
            System.out.println("");
            System.out.println(animales.get(i).toString());

        }

    }

}
