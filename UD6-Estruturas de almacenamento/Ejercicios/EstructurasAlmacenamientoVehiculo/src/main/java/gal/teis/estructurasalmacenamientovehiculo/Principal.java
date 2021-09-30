/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.estructurasalmacenamientovehiculo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Vehiculo> listaarraylist = new ArrayList<Vehiculo>();
        //Para poder usar addLast(), no puedo usar List a la izquierda
        LinkedList<Vehiculo> listalinkedlist = new LinkedList<Vehiculo>();

        int contadorCocheArray = 0;
        int contadorCamionArray = 0;
        int contadorFurgonetaArray = 0;
        int contadorMotoArray = 0;

        int contadorCocheLinked = 0;
        int contadorCamionLinked = 0;
        int contadorFurgonetaLinked = 0;
        int contadorMotoLinked = 0;

        Long inicioTiempoArray;
        Long finTiempoArray;

        Long inicioTiempoLinked;
        Long finTiempoLinked;

        Random r = new Random();

        for (int i = 0; i < 5000; i++) {
            String tipo = "";
            switch (r.nextInt(4)) {
                case 0:
                    tipo = "Coche";
                    break;
                case 1:
                    tipo = "Camión";
                    break;
                case 2:
                    tipo = "Furgoneta";
                    break;
                case 3:
                    tipo = "Moto";
                    break;
            }
            listaarraylist.add(new Vehiculo(i + 1, tipo));
            listalinkedlist.add(new Vehiculo(i + 1, tipo));
        }

//ARRAYLIST        
        System.out.println("ARRAYLIST\n");
        //Resumen de cuántos vehículos hay de cada tipo
        Iterator<Vehiculo> itArray = listaarraylist.iterator();

        while (itArray.hasNext()) {
            String s = itArray.next().getTipo();
            switch (s) {
                case "Coche":
                    contadorCocheArray++;
                    break;
                case "Camión":
                    contadorCamionArray++;
                    break;
                case "Furgoneta":
                    contadorFurgonetaArray++;
                    break;
                case "Moto":
                    contadorMotoArray++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Resumen de cuántos vehículos hay de cada tipo");
        System.out.println("Coche: " + contadorCocheArray
                + "\nCamión: " + contadorCamionArray
                + "\nFurgoneta: " + contadorFurgonetaArray
                + "\nMoto: " + contadorMotoArray + "\n");

        //Recorrerse la lista y eliminar todos los vehículos que no sean de tipo Coche
        inicioTiempoArray = System.nanoTime();//Empiezo a contar el tiempo
        
        
        Iterator<Vehiculo> itArray2 = listaarraylist.iterator(); //¿Por qué tengo que crear otro? Quizá porque el anterior me recorrió toda la lista y se quedó al final y no vuelve a empezar.
        while (itArray2.hasNext()) {
            String s = itArray2.next().getTipo();
            if (!s.equals("Coche")) {
                itArray2.remove();
            }
        }
        System.out.println("Al eliminar todos los vehículos que no son de tipo Coche quedan: " + listaarraylist.size() + "\n");

        //Añadir tantos vehículos tipo Coche como se hayan eliminado
        System.out.println("Se añaden tantos vehículos tipo Coche como el número de vehículos eliminados.\n");
        for (int i = contadorCocheArray; i < 5000; i++) {
            listaarraylist.add(new Vehiculo(i + 1, "Coche"));
        }

        finTiempoArray = System.nanoTime();//Paro de contar el tiempo

        contadorCocheArray = 0;
        contadorCamionArray = 0;
        contadorFurgonetaArray = 0;
        contadorMotoArray = 0;

        //Mostrar de nuevo el resumen de vehículos de cada tipo
        itArray=listaarraylist.iterator();//En lugar de crear uno nuevo como hice antes, al volver a llamarlo vuelve a la posición de inicio
        //Iterator<Vehiculo> itArray3 = listaarraylist.iterator();

        while (itArray.hasNext()) {
            String s = itArray.next().getTipo();
            switch (s) {
                case "Coche":
                    contadorCocheArray++;
                    break;
                case "Camión":
                    contadorCamionArray++;
                    break;
                case "Furgoneta":
                    contadorFurgonetaArray++;
                    break;
                case "Moto":
                    contadorMotoArray++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Nuevo resumen de cuántos vehículos hay de cada tipo");
        System.out.println("Coche: " + contadorCocheArray
                + "\nCamión: " + contadorCamionArray
                + "\nFurgoneta: " + contadorFurgonetaArray
                + "\nMoto: " + contadorMotoArray + "\n");

        //Tiempo empleado desde que comenzó la eliminación de elementos hasta
        //que terminó la inserción de elementos
        Long a = finTiempoArray - inicioTiempoArray;
        System.out.println("Tiempo empleado por el ArrayList: " + a + "\n");

//LINKEDLIST       
        System.out.println("LINKEDLIST\n");
        //Resumen de cuántos vehículos hay de cada tipo
        Iterator<Vehiculo> itLinked = listalinkedlist.iterator();

        while (itLinked.hasNext()) {
            String s = itLinked.next().getTipo();
            switch (s) {
                case "Coche":
                    contadorCocheLinked++;
                    break;
                case "Camión":
                    contadorCamionLinked++;
                    break;
                case "Furgoneta":
                    contadorFurgonetaLinked++;
                    break;
                case "Moto":
                    contadorMotoLinked++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Resumen de cuántos vehículos hay de cada tipo");
        System.out.println("Coche: " + contadorCocheLinked
                + "\nCamión: " + contadorCamionLinked
                + "\nFurgoneta: " + contadorFurgonetaLinked
                + "\nMoto: " + contadorMotoLinked + "\n");

        //Recorrerse la lista y eliminar todos los vehículos que no sean de tipo Coche
        inicioTiempoLinked = System.nanoTime();//Empiezo a contar el tiempo

        Iterator<Vehiculo> itLinked2 = listalinkedlist.iterator(); //¿Por qué tengo que crear otro? Quizá porque el anterior me recorrió toda la lista y se quedó al final y no vuelve a empezar.
        while (itLinked2.hasNext()) {
            String s = itLinked2.next().getTipo();
            if (!s.equals("Coche")) {
                itLinked2.remove();
            }
        }
        System.out.println("Al eliminar todos los vehículos que no son de tipo Coche quedan: " + listalinkedlist.size() + "\n");

        //Añadir tantos vehículos tipo Coche como se hayan eliminado
        System.out.println("Se añaden tantos vehículos tipo Coche como el número de vehículos eliminados.\n");
        for (int i = contadorCocheLinked; i < 5000; i++) {
            listalinkedlist.addLast(new Vehiculo(i + 1, "Coche"));         
        }

        finTiempoLinked = System.nanoTime();//Paro de contar el tiempo

        contadorCocheLinked = 0;
        contadorCamionLinked = 0;
        contadorFurgonetaLinked = 0;
        contadorMotoLinked = 0;

        //Mostrar de nuevo el resumen de vehículos de cada tipo
        Iterator<Vehiculo> itLinked3 = listalinkedlist.iterator();

        while (itLinked3.hasNext()) {
            String s = itLinked3.next().getTipo();
            switch (s) {
                case "Coche":
                    contadorCocheLinked++;
                    break;
                case "Camión":
                    contadorCamionLinked++;
                    break;
                case "Furgoneta":
                    contadorFurgonetaLinked++;
                    break;
                case "Moto":
                    contadorMotoLinked++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Nuevo resumen de cuántos vehículos hay de cada tipo");
        System.out.println("Coche: " + contadorCocheLinked
                + "\nCamión: " + contadorCamionLinked
                + "\nFurgoneta: " + contadorFurgonetaLinked
                + "\nMoto: " + contadorMotoLinked + "\n");

        //Tiempo empleado desde que comenzó la eliminación de elementos hasta
        //que terminó la inserción de elementos
        Long b = finTiempoLinked - inicioTiempoLinked;
        System.out.println("Tiempo empleado por el LinkedList: " + b + "\n");

        //Comparación de ArrayList vs LinkedList
        System.out.println("ARRAYLIST VS LINKEDLIST"
                + "\n¿Cuál es más rapido en este caso?");
        System.out.println("ArrayList: " + a);
        System.out.println("LinkedList: " + b + "\n");

        if (a < b) {
            System.out.println("ARRAYLIST es más rapido.");
        } else if (a > b) {
            System.out.println("LINKEDLIST es más rapido.");
        } else {
            System.out.println("AMBAS emplean el mismo tiempo.");
        }
    }

}
