/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.tema2_ejemplos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author a20estefaniapc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static void estructura_secuencial_1() {
        //Estructura secuencial: Lee dos números por pantalla y muestra su suma
        int n1, n2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número entero: ");
        n1 = sc.nextInt(); //lee un entero por teclado
        System.out.println("Introduce otro número entero: ");
        n2 = sc.nextInt(); //lee un entero por teclado

        System.out.println("Ha introducido los números: " + n1 + " y " + n2);
    }

    static void estructura_secuencial_2() {
        //Muestra la hora y la fecha actual
        Date miDate = new Date();
        SimpleDateFormat miDF1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat miDF2 = new SimpleDateFormat("kk:mm:ss");

        System.out.println("La fecha actual es " + miDF1.format(miDate));
        System.out.println("La hora actual es " + miDF2.format(miDate));
    }

    static void estructura_alternativa_simple() {
        //Indica si estás en el primer tramo de IRPF
        Scanner miScanner = new Scanner(System.in);
        double ingresos;

        System.out.println("Introduce tus ingresos anuales");
        ingresos = miScanner.nextDouble();

        if (ingresos < 12450) {
            System.out.println("No tienes que pagar IRPF");
        }
    }

    static void estructura_alternativa_doble() {
        //Pregunta por la nota y si es >=5 entonces aprobado, sino suspenso
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la nota del examen: ");
        int nota = sc.nextInt();

        if (nota >= 5) {
            System.out.println("Enorabuena!! Has aprobado");
        } else {
            System.out.println("Lo siento, has suspendido");
        }
    }

    static void estructuras_control_condicionales_dobles() {
        //Uso de cuadros de diáologo de la librería swing
        //Calcula la nota media de 3 notas dadas e informa al usuario
        //Es necesario importar la clase javax.swing.JOptionPane;
        int notaM;
        int notaH;
        int notaI;
        double media;

        //Uso de cuadros de diálogo swing
        notaM = Integer.parseInt(JOptionPane.showInputDialog("Nota de matemáticas"));
        notaH = Integer.parseInt(JOptionPane.showInputDialog("Nota de historia"));
        notaI = Integer.parseInt(JOptionPane.showInputDialog("Nota de informática"));

        //Cálculo de la nota media
        media = (notaM + notaH + notaI) / 3;

        //Control de la nota media y us de ventanas de swing
        if (media >= 5) {
            JOptionPane.showMessageDialog(null, "¡Enorabuena! Tu media es " + media);
        } else {
            JOptionPane.showMessageDialog(null, "¡Recuperación! Tu media es " + media);
        }
    }

    static void estructura_if_anidada() {
        //Pregunta por el nombre, si es Ana pregunta por la edad
        //y le dice si es mayor de edad o no
        int edad;
        String nombre;

        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        nombre = miScanner.nextLine();
        System.out.println("Introduce tu edad: ");
        edad = miScanner.nextInt();

        if (nombre.equals("Ana")) {
            System.out.println("Hola Ana");
            if (edad >= 18) {
                System.out.println("Eres mayor de edad");
            } else {
                System.out.println("Aún no eres mayor de edad");
            }
        }
    }

    static void estructura_control_if_anidada() {
        //Genera un número que representa la temperatura
        //Muestra un mensaje según el rango del número
        int temp;
        String mensaje;

        //Crear un objeto aleatorio
        Random elRandom = new Random();
        //Genera un número entero entre 0 y 50
        temp = elRandom.nextInt(50);

        if (temp < 10) {
            mensaje = "Hace mucho frío.";
        } else {
            if (temp < 15) {
                mensaje = "Hace poco frío.";
            } else {
                if (temp < 25) {
                    mensaje = "Hace un atemperatura agardable.";
                } else {
                    if (temp < 30) {
                        mensaje = "Hace poco calor.";
                    } else {
                        mensaje = "Hace mucho calor.";
                    }
                }
            }
        }
        System.out.printf("La temperatura actual es de %d grados", temp);
        System.out.println("\n" + mensaje);
    }

    static void estructura_control_else_if() {
        //Muestra la clasificación de la nota en función de la
        //nota numérica
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Nota (0-10): ");
        double nota = miScanner.nextDouble();

        if (nota == 10) {
            System.out.println("Matricula de Honor");
        } else if ((nota >= 9) && (nota < 10)) {
            System.out.println("Sobresaliente");
        } else if (nota >= 7) {
            System.out.println("Notable");
        } else if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Suspenso");
        }

    }

    static void estructura_condicinal_switch() {
        //Pregunta por el tipo de coche. En función del valor introducido
        //muestra información

        String tipoVehiculo;

        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduce el tipo de código");
        tipoVehiculo = miScanner.nextLine();

        switch (tipoVehiculo) {
            case "coche":
                System.out.println("Puedes pasar de 00:00 a 08:00");
                break;
            case "camión":
                System.out.println("Puedes pasar de 08:00 a 16:00");
                break;
            case "moto":
                System.out.println("Puedes pasar de 16:00 a 24:00");
                break;
            default:
                System.out.println("No puedes pasar con" + tipoVehiculo);
        }
    }

    static void estructura_condicinal_switch_2() {
        //Pregunta por el tipo de coche
        //En función del valor introducido muestra información
        int dia;
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduce el día de la semana");
        dia = miScanner.nextInt();

        switch (dia) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Día laboral");
                break;
            case 1:
            case 7:
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("La semana solo tiene 7 días");
                break;

        }
        miScanner.close();
    }

//    static void for_basico(){
//    for (int i=1; 1<=10; i++){
//    System.out.println(i);
//    }
//    }
    static void mostrarPares() {
        //Muestra los nº pares entre 0 y un nº leído por teclado
        int num_maximo;
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduce el nº máximo de " + "valores pares a mostar");
        num_maximo = miScanner.nextInt();

        for (int i = 0; i <= num_maximo; i++) {
            System.out.println(i);
        }
    }

    static void mostrarRango() {
        //Muestra los valores entre un nº mayor y menor
        //introducidos por pantalla
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduce el número mayor");
        int mayor = miScanner.nextInt();

        System.out.println("Introduce el número menor");
        int menor = miScanner.nextInt();

        if (menor > mayor) {
            System.out.println("Datos incorrectos");
        } else {
            //Voy decrementando desde el número grande al pequeño
            for (int i = mayor; i >= menor; i--) {
                System.out.println("Estoy en el bucle");
                System.out.println(i);
            }
        }
        miScanner.close();
    }

//    static void bucle_infinito_1(){
//    //for valores de inicio, ni condición ni incremento
//    for( ; ; ){
//    System.out.println("Este es un ciclo infinito");
//    }
//    }
//    static void bucle_infinito_2() {
//        //for con codición de salida que nunca se cumple
//        for (int i = 0; i < 0; i++) {
//            System.out.println("Nunca se cumple la condición");
//        }
//    }

    static void for_anidados() {
        //Muestra la tabla de multiplicar de los números del 1 al 9
        for (int i = 1; i <= 9; i++) {
               //Para cada valor de i, se genera valores j de 1 a 9
               for (int j=1; i<=9; i++){
               System.out.println(i+"*"+j+"="+i*j);
               }
        }
    }

    public static void main(String[] args) {
        //estructura_secuencial_1();
        //estructura_secuencial_2();
        //estructura_alternativa_simple();
        //estructura_alternativa_doble();
        //estructuras_control_condicionales_dobles();
        //estructura_if_anidada();
        //estructura_control_if_anidada();
        //estructura_control_else_if();
        //estructura_condicinal_switch();
        //estructura_condicinal_switch_2();
        //for_basico();
        //mostrarPares();
        //mostrarRango();
        //bucle_infinito_1();
        //bucle_infinito_2();
        for_anidados();
    }

}
