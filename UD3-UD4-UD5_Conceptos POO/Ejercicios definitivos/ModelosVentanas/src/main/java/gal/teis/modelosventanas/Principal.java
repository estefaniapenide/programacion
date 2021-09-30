/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.modelosventanas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    /*
    *Ejercicio ventanas:
    *•En el método main debe haber un menú que permita:
    *•Simular la fabricación de los dos tipos de ventanas de forma diferenciada.
    *•Simular la venta de los dos tipos de ventanas de forma diferenciada.
    */
    public static void main(String[] args) {
        //Defino los ArrayList de objetos donde los almacenaré. Creando un ArrayList para las ventanas A fabricadas y 
        //otro para las ventanas B fabricadas.
        ArrayList<Ventana_ModeloA> fabA = new ArrayList<Ventana_ModeloA>();
        ArrayList<Ventana_ModeloB> fabB = new ArrayList<Ventana_ModeloB>();

        Scanner input = new Scanner(System.in);
        //Todos los controles de tipo de los valores pedidos por pantalla están hechos con los métodos de la clase ControlData
        //Cualquier otra restricción adicional a tener en cuenta (rango de valores, Strings concretos buscados, etc) se hace
        //en esta clase Principal.

        //Menú principal
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Introduzca el número de la operación a realizar:");
            System.out.println("1. Fabricar ventanas.");
            System.out.println("2. Vender ventanas.");
            System.out.println("3. Ver stock de ventanas fabricadas disponibles para la venta.");
            System.out.println("4. Ver total ventanas vendidas e ingresos.");
            System.out.println("0. Salir.");

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    //Menú de fabricación de ventanas
                    int opcion1;
                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("Introduzca el número de la operación a realizar:");
                        System.out.println("1. Fabricar ventanas de clase A.");
                        System.out.println("2. Fabricar ventanas de clase B.");
                        System.out.println("0. Volver al menú principal.");

                        opcion1 = ControlData.leerInt(input);

                        switch (opcion1) {
                            case 1:
                                String colorA = "";
                                //Pido el color de la ventana a fabricar y empleo el método getColores que muestra los elementos
                                //del variable stática String[] COLORES de la clase Ventana_ModeloA
                                boolean a;
                                do {
                                    a = true;
                                    System.out.println("Escoja un color de entre los del catálogo: ");
                                    System.out.println(Ventana_ModeloA.getColores());
                                    colorA = ControlData.leerString(input);
                                    //Solo acepto los valores de Strings que coincidan con alguno de los colores del array de COLORES
                                    if (colorA.equals("rojo") || colorA.equals("verde") || colorA.equals("azul") || colorA.equals("gris") || colorA.equals("blanco")) {
                                    } else {
                                        System.out.println("No ha introducido ningún color de los ofertados.");
                                        a = false;
                                    }
                                } while (!a);

                                //Pido el número de ventanas a fabricar del color indicado
                                int num_fabA;
                                boolean e;
                                do {
                                    e=false;
                                    System.out.println("¿Cuántas ventanas de color " + colorA + " quiere fabricar?");
                                    num_fabA = ControlData.leerInt(input);
                                    //Restrinjo que sólo acepte números positivos
                                    if (num_fabA < 0) {
                                        System.out.println("Debe introducir un número mayor que cero.");
                                    }
                                } while (e);

                                //El bucle for da tantas vueltas como número de ventanas a fabricar indicadas
                                for (int i = 0; i < num_fabA; i++) {
                                    //En cada vuelta se añade un objeto Ventana_ModeloA, empleando el contstructor con el color
                                    fabA.add(new Ventana_ModeloA(colorA));
                                    //Por cada ventana del modelo A creada se suma 1 al contador
                                    Ventana_ModeloA.contador++;
                                    //Por cada ventana del modelo A creada se suma 1 al contador correspondiente del color creado
                                    if (colorA.equals("rojo")) {
                                        Ventana_ModeloA.contadorrojo++;
                                    } else if (colorA.equals("verde")) {
                                        Ventana_ModeloA.contadorverde++;
                                    } else if (colorA.equals("azul")) {
                                        Ventana_ModeloA.contadorazul++;
                                    } else if (colorA.equals("gris")) {
                                        Ventana_ModeloA.contadorgris++;
                                    } else if (colorA.equals("blanco")) {
                                        Ventana_ModeloA.contadorblanco++;
                                    }
                                }

                                System.out.println("Ha creado " + Ventana_ModeloA.contador + " ventanas, modelo A, color " + colorA + ".");
                                break;
                            case 2:
                                String colorB = "";
                                //Pido el color de la ventana a fabricar y empleo el método getColores que muestra los elementos
                                //del variable stática String[] COLORES de la clase Ventana_ModeloB
                                boolean b;
                                do {
                                    b = true;
                                    System.out.println("Escoja un color de entre los del catálogo: ");
                                    System.out.println(Ventana_ModeloB.getColores());
                                    colorB = ControlData.leerString(input);
                                    //Solo acepto los valores de Strings que coincidan con alguno de los colores del array de COLORES
                                    if (colorB.equals("gris") || colorB.equals("blanco")) {
                                    } else {
                                        System.out.println("No ha introducido ningún color de los ofertados.");
                                        b = false;
                                    }
                                } while (!b);

                                //Pido el número de ventanas a fabricar del color indicado
                                int num_fabB;
                                boolean f;
                                do {
                                    f = true;
                                    System.out.println("¿Cuántas ventanas de color " + colorB + " quiere fabricar?");
                                    num_fabB = ControlData.leerInt(input);
                                    //Restrinjo que sólo acepte números positivos
                                    if (num_fabB > 0) {
                                    } else {
                                        System.out.println("Debe introducir un número mayor que cero.");
                                        f = false;
                                    }
                                } while (!f);

                                //El bucle for da tantas vueltas como número de ventanas a fabricar indicadas
                                for (int i = 0; i < num_fabB; i++) {
                                    //En cada vuelta se añade un objeto Ventana_ModeloB, empleando el contstructor con el color
                                    fabB.add(new Ventana_ModeloB(colorB));
                                    //Por cada ventana del modelo B creada se suma 1 al contador
                                    Ventana_ModeloB.contador++;

                                    System.out.println("Ventana creada. Modelo B, color " + colorB);
                                    //Por cada ventana del modelo B creada se suma 1 al contador correspondiente del color creado
                                    if (colorB.equals("gris")) {
                                        Ventana_ModeloB.contadorgris++;
                                    } else if (colorB.equals("blanco")) {
                                        Ventana_ModeloB.contadorblanco++;
                                    }
                                }

                                System.out.println("Ha creado " + Ventana_ModeloB.contador + " ventanas, modelo B, color " + colorB + ".");
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("No ha introducido un valor que se corresponda con alguna de las opciones.");
                                break;

                        }

                    } while (opcion1 != 0);
                    break;
                case 2:
                    //Menú de venta de ventanas
                    int opcion2;
                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("Introduzca el número de la operación a realizar:");
                        System.out.println("1. Vender ventanas de clase A.");
                        System.out.println("2. Vender ventanas de clase B.");
                        System.out.println("0. Volver al menú principal.");

                        opcion2 = ControlData.leerInt(input);

                        switch (opcion2) {
                            case 1:
                                String colorvA = "";
                                //Si el contador del modeloA es al menos 1, se procede a preguntar qué ventanas vender
                                if (Ventana_ModeloA.contador >= 1) {
                                    //Muestro el stock de ventanas para poder tenerlo en cuanta a la hora de hacer las ventas
                                    System.out.println("Stock de ventanas del modelo A: ");
                                    System.out.println("rojas: " + Ventana_ModeloA.contadorrojo + ", verdes: " + Ventana_ModeloA.contadorverde + ", azules: " + Ventana_ModeloA.contadorazul + ", grises: " + Ventana_ModeloA.contadorgris + ", blancas: " + Ventana_ModeloA.contadorblanco);
                                    System.out.println("");
                                    //Pregunto por el color de la ventana a vender y por el número que se quiere vender usando la misma estructura
                                    //que se usó cuando se preguntaba en la fabricación
                                    boolean c;
                                    do {
                                        c = true;
                                        System.out.println("¿De qué color quiere la ventana?");
                                        System.out.println(Ventana_ModeloA.getColores());
                                        colorvA = ControlData.leerString(input);
                                        if (colorvA.equals("rojo") || colorvA.equals("verde") || colorvA.equals("azul") || colorvA.equals("gris") || colorvA.equals("blanco")) {
                                        } else {
                                            System.out.println("No ha introducido ningún color de los ofertados.");
                                            c = false;
                                        }
                                    } while (!c);
                                    System.out.println("¿Cuántas ventanas de color " + colorvA + " quiere?");
                                    int num_venA = ControlData.leerInt(input);
                                    //Se entra en el if del color correspondiente y simpre que el contador de ventanas fabricadas sea menor o igual
                                    //que las ventanas solicitadas para vender, se procede a venderlas sumando al contador de vendidas el número introducido
                                    //y restando al contador de ventanas del modeloA el número de ventanas vendidas y también al contador del color correspondiente
                                    if (colorvA.equals("rojo")) {
                                        if (Ventana_ModeloA.contadorrojo >= num_venA) {
                                            Ventana_ModeloA.contadorvendidas += num_venA;
                                            System.out.println("Precio: " + Ventana_ModeloA.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venA + " unidades: " + (num_venA * Ventana_ModeloA.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloA.contador -= num_venA;
                                            Ventana_ModeloA.contadorrojo -= num_venA;
                                        } else {
                                            System.out.println("No quedan suficientes ventanas del modelo A de color rojo. Debe fabricarlas.");
                                        }
                                    } else if (colorvA.equals("verde")) {
                                        if (Ventana_ModeloA.contadorverde >= num_venA) {
                                            Ventana_ModeloA.contadorvendidas += num_venA;
                                            System.out.println("Precio: " + Ventana_ModeloA.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venA + " unidades: " + (num_venA * Ventana_ModeloA.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloA.contador -= num_venA;
                                            Ventana_ModeloA.contadorverde -= num_venA;
                                        } else {
                                            System.out.println("No quedan suficientes ventanas del modelo A de color verde. Debe fabricarlas.");
                                        }
                                    } else if (colorvA.equals("azul")) {
                                        if (Ventana_ModeloA.contadorazul >= num_venA) {
                                            Ventana_ModeloA.contadorvendidas += num_venA;
                                            System.out.println("Precio: " + Ventana_ModeloA.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venA + " unidades: " + (num_venA * Ventana_ModeloA.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloA.contador -= num_venA;
                                            Ventana_ModeloA.contadorazul -= num_venA;
                                        } else {
                                            System.out.println("No quedan suficientes ventanas del modelo A de color azul. Debe fabricarlas.");
                                        }
                                    } else if (colorvA.equals("gris")) {
                                        if (Ventana_ModeloA.contadorgris >= num_venA) {
                                            Ventana_ModeloA.contadorvendidas += num_venA;
                                            System.out.println("Precio: " + Ventana_ModeloA.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venA + " unidades: " + (num_venA * Ventana_ModeloA.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloA.contador -= num_venA;
                                            Ventana_ModeloA.contadorgris -= num_venA;
                                        } else {
                                            System.out.println("No quedan suficientes ventanas del modelo A de color gris. Debe fabricarlas.");
                                        }
                                    } else if (colorvA.equals("blanco")) {
                                        if (Ventana_ModeloA.contadorblanco >= num_venA) {
                                            Ventana_ModeloA.contadorvendidas += num_venA;
                                            System.out.println("Precio: " + Ventana_ModeloA.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venA + " unidades: " + (num_venA * Ventana_ModeloA.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloA.contador -= num_venA;
                                            Ventana_ModeloA.contadorblanco -= num_venA;
                                        } else {
                                            System.out.println("No quedan suficientes ventanas del modelo A de color blanco. Debe fabricarlas.");
                                        }
                                    }
                                } else {
                                    System.out.println("No quedan ventanas del modelo A. Debe fabricarlas.");
                                }
                                break;
                            case 2:
                                String colorvB = "";
                                //Si el contador del modeloB es al menos 1, se procede a preguntar qué ventanas vender
                                if (Ventana_ModeloB.contador >= 1) {
                                    //Muestro el stock de ventanas para poder tenerlo en cuanta a la hora de hacer las ventas
                                    System.out.println("Stock de ventanas del modelo B: ");
                                    System.out.println("grises: " + Ventana_ModeloB.contadorgris + ", blancas: " + Ventana_ModeloB.contadorblanco);
                                    System.out.println("");
                                    //Pregunto por el color de la ventana a vender y por el número que se quiere vender usando la misma estructura
                                    //que se usó cuando se preguntaba en la fabricación
                                    boolean d;
                                    do {
                                        d = true;
                                        System.out.println("¿De qué color quiere la ventana?");
                                        System.out.println(Ventana_ModeloB.getColores());
                                        colorvB = ControlData.leerString(input);
                                        if (colorvB.equals("gris") || colorvB.equals("blanco")) {
                                        } else {
                                            System.out.println("No ha introducido ningún color de los ofertados.");
                                            d = false;
                                        }
                                    } while (!d);
                                    System.out.println("¿Cuántas ventanas de color " + colorvB + " quiere?");
                                    int num_venB = ControlData.leerInt(input);
                                    //Se entra en el if del color correspondiente y simpre que el contador de ventanas fabricadas sea menor o igual
                                    //que las ventanas solicitadas para vender, se procede a venderlas sumando al contador de vendidas el número introducido
                                    //y restando al contador de ventanas del modeloB el número de ventanas vendidas y también al contador del color correspondiente
                                    if (colorvB.equals("gris")) {
                                        if (Ventana_ModeloB.contadorgris >= num_venB) {
                                            Ventana_ModeloB.contadorvendidas += num_venB;
                                            System.out.println("Precio: " + Ventana_ModeloB.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venB + " unidades: " + (num_venB * Ventana_ModeloB.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloB.contador -= num_venB;
                                            Ventana_ModeloB.contadorgris -= num_venB;
                                        } else {
                                            System.out.println("No quedan ventanas del modelo B de color gris. Debe fabricarlas.");
                                        }
                                    } else if (colorvB.equals("blanco")) {
                                        if (Ventana_ModeloB.contadorblanco >= num_venB) {
                                            Ventana_ModeloB.contadorvendidas += num_venB;
                                            System.out.println("Precio: " + Ventana_ModeloB.getPrecio() + "€/unidad");
                                            System.out.println("Total " + num_venB + " unidades: " + (num_venB * Ventana_ModeloB.getPrecio()) + "€");
                                            System.out.println("Venta realizada.");
                                            Ventana_ModeloB.contador -= num_venB;
                                            Ventana_ModeloB.contadorblanco -= num_venB;
                                        } else {
                                            System.out.println("No quedan ventanas del modelo B de color blanco. Debe fabricarlas.");
                                        }
                                    }
                                } else {
                                    System.out.println("No quedan ventanas del modelo B. Debe fabricarlas.");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("No ha introducido un valor que se corresponda con alguna de las opciones.");
                                break;
                        }

                    } while (opcion2 != 0);
                    break;
                case 3:
                    //Muestro por pantalla las ventanas fabricadas y que están aun sin vender empleando los contadores
                    System.out.println("");
                    System.out.println("Hay " + Ventana_ModeloA.contador + " ventana/s en stock del modelo A.");
                    System.out.println("rojas: " + Ventana_ModeloA.contadorrojo);
                    System.out.println("verdes: " + Ventana_ModeloA.contadorverde);
                    System.out.println("azules: " + Ventana_ModeloA.contadorazul);
                    System.out.println("grises: " + Ventana_ModeloA.contadorgris);
                    System.out.println("blancas: " + Ventana_ModeloA.contadorblanco);
                    System.out.println("");
                    System.out.println("Hay " + Ventana_ModeloB.contador + " ventana/s en stock del modelo B.");
                    System.out.println("grises: " + Ventana_ModeloB.contadorgris);
                    System.out.println("blancas: " + Ventana_ModeloB.contadorblanco);
                    break;
                case 4:
                    //Muestro por pantalla las ventanas vendidas empleando los contadores y la variables estáticas de precio de cada modelo
                    System.out.println("");
                    System.out.println("Ventanas vendidas:");
                    System.out.println("modelo A => " + Ventana_ModeloA.contadorvendidas + " ventanas.");
                    System.out.println("modelo B => " + Ventana_ModeloB.contadorvendidas + " ventanas.");
                    System.out.println("TOTAL = " + (Ventana_ModeloA.contadorvendidas + Ventana_ModeloB.contadorvendidas) + " ventanas.");
                    System.out.println("");
                    System.out.println("Ingresos:");
                    System.out.println("modelo A => " + (Ventana_ModeloA.contadorvendidas * Ventana_ModeloA.getPrecio()) + "€");
                    System.out.println("modelo B => " + (Ventana_ModeloB.contadorvendidas * Ventana_ModeloB.getPrecio()) + "€");
                    System.out.println("TOTAL = " + ((Ventana_ModeloA.contadorvendidas * Ventana_ModeloA.getPrecio()) + (Ventana_ModeloB.contadorvendidas * Ventana_ModeloB.getPrecio())) + "€");
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
