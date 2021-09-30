/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.examenprogramacion2a.estefaniapenide;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();

        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Introduzca el número de la operación a realizar:");
            System.out.println("1. Crear Empleados.");
            System.out.println("2. Crear Directivos.");
            System.out.println("3. Ver número de trabajadores total que se han creado.");
            System.out.println("4. Ver datos personales de los empleados(nombre, edad, antiguedad).");
            System.out.println("5. Listar el salrio líquido y la parte del salario retenido por el IRPF de todos los empleados.");
            System.out.println("0. Salir.");

            opcion = ControlData.leerInt(input);

            switch (opcion) {

                case 1:
                    System.out.println("Indique el nombre del empleado:");
                    String nombre = ControlData.leerString(input);
                    System.out.println("Indique la edad del empleado:");
                    int edad = ControlData.leerInt(input);
                    System.out.println("Indique la antiguedad del empleado:");
                    System.out.println("0. Novato");
                    System.out.println("1. Maduro");
                    System.out.println("2. Experto");
                    int antiguedad = 0;
                    boolean correcto;
                    do {
                        correcto = true;
                        antiguedad = ControlData.leerInt(input);
                        if (antiguedad == 0 || antiguedad == 1 || antiguedad == 2) {
                            System.out.println("Antiguedad seleccionada.");
                        } else {
                            System.out.println("ERROR. No ha introducido un valor válido");
                            correcto = false;
                        }
                    } while (!correcto);
                    System.out.println("Indique el % de IRPF del empleado:");
                    double irpf = ControlData.leerDouble(input);

                    Empleado empleado = new Empleado(nombre, edad, antiguedad, irpf);
                    trabajadores.add(empleado);
                    break;
                case 2:
                    //No he tenido tiempo de solucionar el problema que me da la creación de directivos.
                    System.out.println("Indique el nombre del directivo:");
                    String nombredir = ControlData.leerString(input);
                    System.out.println("Indique la edad del directivo:");
                    int edaddir = ControlData.leerInt(input);
                    System.out.println("Indique la antiguedad del directivo:");
                    System.out.println("0. Novato");
                    System.out.println("1. Maduro");
                    System.out.println("2. Experto");
                    int antiguedaddir = 0;
                    boolean correctodir;
                    do {
                        correctodir = true;
                        antiguedaddir = ControlData.leerInt(input);
                        if (antiguedaddir == 0 || antiguedaddir == 1 || antiguedaddir == 2) {
                            System.out.println("Antiguedad seleccionada.");
                        } else {
                            System.out.println("ERROR. No ha introducido un valor válido");
                            correctodir = false;
                        }
                    } while (!correctodir);
                    System.out.println("Indique el % de IRPF del directivo:");
                    double irpfdir = ControlData.leerDouble(input);

                    Directivo directivo = new Directivo(nombredir, edaddir, antiguedaddir, irpfdir);
                    trabajadores.add(directivo);
                    break;
                case 3:
                    //El contontador se ve afectado por culpa de los directivos por eso pongo el desglose de los
                    //datos de empleados y directivos.
                    int trabajadoresCreados = Empleado.getContadorEmpleado() + Directivo.getContadorDirectivo();
                    System.out.println("Se ha creado un total de " + trabajadoresCreados + " trabajadores.");
                    System.out.println("Empleados: " + Empleado.getContadorEmpleado());
                    System.out.println("Directivos: " + Directivo.getContadorDirectivo());
                    break;
                case 4:
                    if (trabajadores.isEmpty()) {
                        System.out.println("No ha creado ningún trabajador.");
                    } else {
                        for (int i = 0; i < trabajadores.size(); i++) {
                            //Como me interesan sólo los empleados y no todos los trabajadores, escojo con instanceof 
                            //sólo los que son empleados.
                            if (trabajadores.get(i) instanceof Empleado) {
                                System.out.println("Nombre :" + trabajadores.get(i).getNombre());
                                System.out.println("Edad: " + trabajadores.get(i).getEdad());
                                if (trabajadores.get(i).getAntiguedad() == 0) {
                                    System.out.println("Antigüedad: Novato");
                                } else if (trabajadores.get(i).getAntiguedad() == 1) {
                                    System.out.println("Antigüedad: Maduro");
                                } else if (trabajadores.get(i).getAntiguedad() == 2) {
                                    System.out.println("Antigüedad: Experto");
                                }
                            }
                            System.out.println("");
                        }
                    }
                    break;
                case 5:
                    if (trabajadores.isEmpty()) {
                        System.out.println("No ha creado ningún trabajador.");
                    } else {
                        for (int i = 0; i < trabajadores.size(); i++) {
                            //Como me interesan sólo los empleados y no todos los trabajadores, escojo con instanceof 
                            //sólo los que son empleados. Y además hago un casting a empleados para poder acceder a 
                            //los métodos que antes no podía debido al polimorfismo.
                            if (trabajadores.get(i) instanceof Empleado) {
                                Empleado emp = (Empleado) trabajadores.get(i);
                                System.out.println("Nombre :" + emp.getNombre());
                                System.out.println("Salario líquido: " + emp.mostrarSlarioLiquido());
                                System.out.println("Parte del salario retenida por el IRPF: " + emp.mostrarRetencion());
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("No ha introducido un valor que se corresponda con ninguna de las opciones.");
                    break;
            }

        } while (opcion != 0);

        input.close();

    }
}
