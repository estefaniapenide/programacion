/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.paises;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    /*Crear un menú que permita crear países y mostrar sus datos por pantalla Utilizar un array de Pais para esta operación*/
    public static void main(String[] args) {
        ArrayList<Pais> paises = new ArrayList<Pais>();
        int num_paises;
//        Pais[] paises = new Pais[num_paises];
        int j = 0;
        Pais pais1;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("------------------------------------------");
            System.out.println("Introduzca el número de la operación a realizar:");
            System.out.println("1. Añadir países (elimina la lista actual de países y crea una nueva).");
            System.out.println("2. Mostrar la lista de países.");
            System.out.println("0. Salir.");

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    String nombre;
                    String capital;
                    String gobierno = "";
                    char gob;
                    int habitantes;
                    String habt = "";

                    boolean cont;
                    do {
                        cont = true;
                        System.out.println("¿Cuántos países quiere añadir?");
                        num_paises = ControlData.leerInt(input);
                        if (num_paises <= 0) {
                            System.out.println("Debe introducir un número superior a 0.");
                            cont = false;
                        }
                    } while (!cont);

                    for (j = 0; j < num_paises; j++) {
//                        paises[j] = new Pais();
//                        paises.add(new Pais());

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

                            switch (vrble) {
                                case 1:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                   paises.add(new Pais(nombre));
                                    break;
                                case 2:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    System.out.println("Introduzca su capital: ");
                                    capital = ControlData.leerString(input);
                                    paises.add(new Pais(nombre, capital));
                                    break;
                                case 3:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    System.out.println("Introduzca su capital: ");
                                    capital = ControlData.leerString(input);
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
                                            System.out.println("No ha introducido una opción válida");
                                            conf = false;
                                        }
                                    } while (!conf);

                                    paises.add(new Pais(nombre, capital,gobierno));
                                    break;
                                case 4:
                                    System.out.println("Introduzca el nombre del país: ");
                                    nombre = ControlData.leerString(input);
                                    paises.get(j).setNombre(nombre);
                                    break;
                                case 5:
                                    System.out.println("Introduzca su capital: ");
                                    capital = ControlData.leerString(input);
                                    paises.get(j).setCapital(capital);
                                    break;
                                case 6:
                                    paises.get(j).setGobierno();
                                    break;
                                case 7:
                                    System.out.println("Introduzca el número de habitantes: ");
                                    habitantes = ControlData.leerInt(input);
                                    paises.get(j).setHabitantes(habitantes);
                                    habt = Integer.toString(paises.get(j).getHabitantes());
                                    break;
                                case 8:
                                    paises.get(j).setLengua();
                                    break;
                                case 9:
                                    String[] caracteristicas = {"País: " + paises.get(j).getNombre(), "Capital: " + paises.get(j).getCapital(), "Sistema de gobierno: " + paises.get(j).getGobierno(), "Número de habitantes: " + habt, "Lenguas oficilaes: " + paises.get(j).getLengua()};
                                    for (String elemento : caracteristicas) {
                                        System.out.println(elemento);
                                    }
//                            String[] caracteristicas ={"País: "+ pais1.getNombre(),"Capital: " + pais1.getCapital(), "Sistema de gobierno: " + mensaje, "Número de habitantes: " + habt, "Lenguas oficilaes: "+ array};
//                    System.out.println(Arrays.toString(caracteristicas));

//                    String[][] caracteristicas = {{"País", pais1.getNombre()},{"Capital", pais1.getCapital()},{"Sistema de gobierno", mensaje},{"Número de habitantes",habt},{"Lenguas oficilaes",array}};
//                    System.out.print(Arrays.deepToString(caracteristicas));
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
                    if (paises.size() == 0) {
                        System.out.println("No hay elementos en la lista de países.");
                    } else {
                        for (j = 0; j < paises.size(); j++) {
                            System.out.println("............................................");
                            System.out.println("PAÍS " + (j + 1));
                            System.out.println("Nombre: " + paises.get(j).getNombre());
                            System.out.println("Capital: " + paises.get(j).getCapital());
                            System.out.println("Tipo de gobierno: " + paises.get(j).getGobierno());
                            System.out.println("Número de habitantes: " + Integer.toString(paises.get(j).getHabitantes()));
                            System.out.println("Lenguas oficiales: " + paises.get(j).getLengua());
                            System.out.println("............................................");
                        }
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
