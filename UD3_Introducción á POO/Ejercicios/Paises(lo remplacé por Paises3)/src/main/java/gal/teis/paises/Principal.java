/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.paises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    /*
    
    /*Crear un menú que permita crear países y mostrar sus datos por pantalla. Utilizar un array de Pais para esta operación*/
    public static void main(String[] args) {
        
        //Todo el control de tipos se hace por medio de la clase ControlData. En los casos en los que es necesario un control extra, ya que 
        //se acotan los valores permitidos dentro de un mismo tipo, el control está hecho aquí tras la aplicación del métdodo correspondiente
        //de ControlData.

        //Creo el array de paises y también creo e inicializo el resto de variables necesarias.
        int num_paises = 250;
        Pais[] paises = new Pais[num_paises];
        String nombre;
        String capital;
        String gobierno = "";
        char gob;
        int habitantes;
        String habt = "";

        
        Scanner input = new Scanner(System.in);
        
        //Creo un primer menú donde se podrá elegir crear los paises o visualizar por pantalla los ya creados.
        int opcion = 0;
        do {

            System.out.println("------------------------------------------");
            System.out.println("Introduzca el número de la operación a realizar");
            System.out.println("1. Añadir lista de países (elimina la lista actual de países y crea una nueva).");
            System.out.println("2. Mostrar la lista de países.");
            System.out.println("0. Salir.");

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    //Para crear la lista de países primero pido el número de países que se van ha introducir en la lista.
                    //Como he empleado un array tengo que darle un tamaño determinado, por lo que lo he limitado al número de
                    //estados existentes (que el código ISO tiene como nombres de estados registrados).
                    boolean cont;
                    do {
                        cont = true;
                        System.out.println("¿Cuántos países quiere añadir? (como máximo puede añadir 250)");
                        num_paises = ControlData.leerInt(input);
                        if (num_paises > 250) {
                            System.out.println("Ha introducido un número demasiado grande.");
                            cont = false;
                        } else if (num_paises <= 0) {
                            System.out.println("Debe introducir un número superior a 0.");
                            cont = false;
                        }
                    } while (!cont);
                    
                    //Aparece un menú en que el elegir qué datos introducir de cada país. Tras introducir undato, se volverá automáticamente al mismo
                    //para seguir introduciendo o cambiando los datos que se deseen de ese país, hasta que se marque la opción 0. 
                    //En ese caso, el menú nuevo que aparece será el mismo pero para introducir los datos del siguiente país en caso de que lo haya o se
                    //volverá al menú anterior.
                    //Cada vez que nos encontramos en este menú podemos visualizar los datos del país del que estamos introduciendo los datos mediante
                    //la opción 9. Para visualizar los datos introducidos de todos los países en conjunto habrá que hacerlo en la opción 2 del menú anterior.
                    for (int j = 0; j < num_paises; j++) {
                        paises[j] = new Pais();

                        int vrble = 0;
                        do {
                            System.out.println("------------------------------------------");
                            System.out.println("DATOS DEL PAÍS " + (j + 1) + " de " + num_paises);
                            System.out.println("Introduzca el número de la operación a realizar:");
                            System.out.println("1. Crear el país dando sólo el nombre.");
                            System.out.println("2. Crear el país dando el nombre y su capital.");
                            System.out.println("3. Crear el país dando el nombre, su capital y su sistema de gobierno.");
                            System.out.println("4. Añadir/cambiar el nombre del país.");
                            System.out.println("5. Añadir/cambiar la capital del país.");
                            System.out.println("6. Añadir/cambiar el sistema de gobierno.");
                            System.out.println("7. Añadir el número de habitantes (si no introduce un número por defecto saldrá 0).");
                            System.out.println("8. Añadir las lenguas oficiales.");
                            System.out.println("9. Mostrar los datos del país introducidos.");
                            System.out.println("0. Volver al menú principal o pasar al menú de creación del siguiente país.");

                            vrble = ControlData.leerInt(input);
                            
                            //Los casos del 1 al 3 utilizan los constructores de la clase Pais. Por lo tanto, al usarlos eliminamos todos los
                            //valores previos que podríamos haber añadido con los siguientes cases. Una vez creamos un país usando uno de esos
                            //constructores, el resto de los valores se pueden añadir usando los setters de la clase Pais mediante los cases del 4 al 8. 
                            //Tambíen se puede crear un país sin emplear los constructores y empleando simplemente alguno o todos los setters de los 
                            //cases del 4 al 8 ya que al principio del bucle for se empleó uno de los constructores.
                            switch (vrble) {
                                case 1:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    paises[j] = new Pais(nombre);
                                    break;
                                case 2:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    System.out.println("Introduzca su capital: ");
                                    capital = ControlData.leerString(input);
                                    paises[j] = new Pais(nombre, capital);
                                    break;
                                case 3:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    System.out.println("Introduzca su capital: ");
                                    capital = ControlData.leerString(input);
                                    //El enunciado pide que solo se acepten dos tipos de sistemas de gobierno. Para ello controlo la entrada admitiendo solo 2 chars distintos.
                                    //Uno lo asocio al String "Monraquía" y el otro al String "República".
                                    boolean conf;
                                    do {
                                        conf = true;
                                        System.out.println("Introduzca su sistema de gobierno (M para monarquía, R para república): ");
                                        gob = ControlData.leerChar(input);
                                        if (gob == 'R') {
                                            gobierno = "República";
                                        } else if (gob == 'M') {
                                            gobierno = "Monarquía";
                                        } else {
                                            System.out.println("No ha introducido una opción válida.");
                                            conf = false;
                                        }
                                    } while (!conf);

                                    paises[j] = new Pais(nombre, capital, gobierno);
                                    break;
                                case 4:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    paises[j].setNombre(nombre);
                                    break;
                                case 5:
                                    System.out.println("Introduzca su capital: ");
                                    capital = ControlData.leerString(input);
                                    paises[j].setCapital(capital);
                                    break;
                                case 6:
                                    paises[j].setGobierno();
                                    break;
                                case 7:
                                    boolean cntr;
                                    do {
                                        cntr = true;
                                        System.out.println("Introduzca el número de habitantes: ");
                                        habitantes = ControlData.leerInt(input);
                                        if (habitantes < 0) {
                                            System.out.println("Ha introducido un número negativo de habitantes. No es válido.");
                                            cntr = false;
                                        }
                                    } while (!cntr);
                                    paises[j].setHabitantes(habitantes);
                                    habt = Integer.toString(paises[j].getHabitantes());
                                    break;
                                case 8:
                                    paises[j].setLengua();
                                    break;
                                case 9:
                                    //Creo esta opción para poder ir comprobando cuales son los valores que se han ido introduciendo en cada
                                    //país a medida que se crean. Para mostrar esos creo un array de características en el que se llamarán a los getters
                                    //de la clase Pais.
                                    String[] caracteristicas = {"País: " + paises[j].getNombre(), "Capital: " + paises[j].getCapital(), "Sistema de gobierno: " + paises[j].getGobierno(), "Número de habitantes: " + habt, "Lenguas oficilaes: " + paises[j].getLengua()};
                                    //Empleo un bucle for para poder mostrar de forma más clara los distintos elementos del array, dividiendolos en varios Strings.
                                    for (String elemento : caracteristicas) {
                                        System.out.println(elemento);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menú principal o al menú de creación del siguiente país.");
                                    break;
                                default:
                                    System.out.println("No ha introducido un valor que se corresponda con alguna de las opciones.");
                                    break;
                            }

                        } while (vrble != 0);
                    }
                    break;
                case 2:
                    try {
                    for (int j = 0; j < num_paises; j++) {
                        //Llamo a los getters de la clase Pais para cada país del array paises creado y muestro de forma ordenada
                        //todos los datos introducidos ordenados por países.
                        System.out.println("............................................");
                        System.out.println("PAÍS " + (j + 1));
                        System.out.println("Nombre: " + paises[j].getNombre());
                        System.out.println("Capital: " + paises[j].getCapital());
                        System.out.println("Sistema de gobierno: " + paises[j].getGobierno());
                        System.out.println("Número de habitantes: " + Integer.toString(paises[j].getHabitantes()));
                        System.out.println("Lenguas oficiales: " + paises[j].getLengua());
                        System.out.println("............................................");
                    }
                } catch (Exception e) {
                    System.out.println("No hay elementos en la lista de países. Añada su lista.");
                }
                break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("No ha introducido un valor que se corresponda con alguna de las opciones.");
                    break;
            }

        } while (opcion != 0);

        input.close();

    }
}
