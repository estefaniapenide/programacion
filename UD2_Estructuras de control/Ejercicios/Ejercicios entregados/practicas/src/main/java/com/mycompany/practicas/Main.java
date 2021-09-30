/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vbleControl = 6;

        Scanner input = new Scanner(System.in);

        do {
            boolean correcto;
            do {
                correcto = true;

                System.out.println("--------------------------------------------------");
                System.out.println("Escribe el número de la opción a elegir:");
                System.out.println("1. Cifrado_cesar");
                System.out.println("2. Cifrado_cesar_sin_ñ");
                System.out.println("3. Tableta_chocolate");
                System.out.println("4. Fibonacci");
                System.out.println("0. Salir");

                try {
                    vbleControl = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("No has introducido un número válido");
                    input.next();
                    correcto = false;
                }
            } while (!correcto);

            switch (vbleControl) {

                case 1:
                    cifrado_cesar();
                    break;
                case 2:
                    cifrado_cesar_simple();
                    break;
                case 3:
                    tableta_chocolate();
                    break;
                case 4:
                    fibonacci();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("El número introducido no se corresponde con ninguna de las opciones.");

            }

        } while (vbleControl != 0);

        input.close();
    }

    static void cifrado_cesar() {
        /**
         * Escribe un programa que permita realizar el cifrado de César de un
         * texto Para realizar el cifrado César se necesita el texto a cifrar y
         * un número que indica el desplazamiento que se emplea de los
         * caracteres para cifrar Si el número es 2 la letra ‘ se sustituye por
         * la letra ‘ la ‘ por la ‘ etc Utiliza para el cifrado el alfabeto
         * español, que incluye la ñ
         */

        //Defino e inicialzo las varibales necesarias
        String texto1;
        char letra;
        char letra2;
        int num;
        int codigo = 4;
        boolean correcto;
        //Defino un array para las minúsculas y otro para las mayúsculas. Así cada letra tendrá un índice asociado en su propio array.
        char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] ABC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        System.out.println("El siguiente programa realiza un cifrado de César. Cifra las mayúsculas, minúsculas y la ñ. Sin embargo los números, vocales con tilde, espacios, puntos y resto de caracteres quedarán inmutables.");

        Scanner miScanner = new Scanner(System.in);

        System.out.println("Introduce el texto para cifrarlo: ");
        //Adimito cualquier número o caracter introducido por teclado. Simplemente si no se tarta de una mayúscula, minúscula o ñ no se cifrará.
        texto1 = miScanner.nextLine();
        //Para poder hacer cambios en el texto, más adelante, necesitaré emplear el método replace(), por lo que necesito que sea un StringBuilder.
        StringBuilder texto = new StringBuilder(texto1);
        //El control del desplazamiento para el cifrado se hace con un do...while y try...catch como ya se ha expliacado varias veces. Restrinjo la entrada
        //con try...catch de todo lo que no sean int y me aseguro además de que el desplazamiento sea entre 0 y 26 (ya que el abecedario tiene 27 letras).
        do {
            correcto = true;
            System.out.println("Introduce el número de desplazamiento(como máximo 26): ");
            try {
                codigo = miScanner.nextInt();
                if (codigo < 0) {
                    System.out.println("No es válido. Tienes que indicar un número entero positivo.");
                    correcto = false;
                } else if (codigo > 26) {
                    System.out.println("No es válido. El desplazamiento no puede ser mayor de 26.");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("No es válido. Tienes que indicar un número entero positivo.");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);

        //Bucle for que recorre el texto caracter a caracter por medio de un contador autoincrementado
        for (int i = 0; i < texto.length(); i++) {
            letra = texto.charAt(i);
            //Todos los caracteres que no cumplan las condiciones para entrar en el siguiente bucle quedarán invariantes.
            letra2 = letra;
            //Dos bucles for indpedinetes: uno para las minúsculas y otro para las mayúsculas.

            //Bucle for que recorre todos los términos del array.
            for (int j = 0; j < abc.length; j++) {
                //Cuando un caracter del texto coincide con un término del array...
                if (letra == abc[j]) {
                    //...si se trata de una 'a'(j=0) y el desplazamiento es 26, buscamos el término del array 'z'(j=26) y se identifica como el caracter de salida
                    if ((j == 0) && (j + codigo) == 26) {
                        j = j + codigo;
                        letra2 = abc[j];
                        break;
                        //...si el índice más el desplazamineto es menor de 26 (y no estamos en la posición 0), el término que buscamos estará la posición resultande
                        //de la suma de la posición de la letra más el desplazamiento. Por ejemplo, la m(j=12) con un desplazamiento de 6, se convertirá en una r(j=18).
                    } else if ((j + codigo) < 26) {
                        j = j + codigo;
                        letra2 = abc[j];
                        break;
                        //...si el índice más el desplazamiento suman 26 o más de 26(y no estamos en la posición 0), se está dando la vuelta al abecedario y hay que
                        //y hay que volver a empezar a contar, por lo que el término resultate estará en la posición resultado de la suma del índice inicial, más el 
                        //desplazamiento, menos 27(27 letras y por lo tanto 27 puestos). Por ejemplo, la m(j=12) con un desplazamiento de 15, se convertirá en una a(j=0).
                    } else if ((j + codigo) >= 26) {
                        j = j + codigo - 27;
                        letra2 = abc[j];
                        break;
                    }
                }
            }
            //La misma lógica es aplicada aquí pero con el array de mayúsculas
            for (int j = 0; j < ABC.length; j++) {
                if (letra == ABC[j]) {
                    if ((j == 0) && (j + codigo) == 26) {
                        j = j + codigo;
                        letra2 = ABC[j];
                        break;
                    } else if ((j + codigo) < 26) {
                        j = j + codigo;
                        letra2 = ABC[j];
                        break;
                    } else if ((j + codigo) >= 26) {
                        j = j + codigo - 27;
                        letra2 = ABC[j];
                        break;
                    }
                }
            }
            //La letra ya cifrada, aquí ha sido llamada letra2, hubo que definirla como un char ya que se estaban haciendo comparaciones y asignaciones con los
            //de los arrays que eran también char. Para poder usarla en el métetdo replace, hay que convertirla en String
            String letra3 = Character.toString(letra2);
            //En el texto se cambia cada letra por la letra nueva en la posición correpondiente, su posición se indica con el método .replace().
            texto = texto.replace(i, i + 1, letra3);
        }
        //Se devuelve el texto entero ya modificado
        System.out.println(texto);

    }

    static void cifrado_cesar_simple() {
        /**
         * Escribe un programa que permita realizar el cifrado de César de un
         * texto Para realizar el cifrado César se necesita el texto a cifrar y
         * un número que indica el desplazamiento que se emplea de los
         * caracteres para cifrar Si el número es 2 la letra ‘ se sustituye por
         * la letra ‘ la ‘ por la ‘ etc Utiliza para el cifrado el alfabeto
         * español, que incluye la ñ
         */

        //https://elcodigoascii.com.ar/
        //Inicialmente traté de hacerlo con el método que se enseña acontinuación incluyendo la ñ, pero como la ñ pertenece al ascii extendido(que en caso de funcionar me suponía meter muchas condiciones al
        //encontrarse el 164(ñ) fuera del intervalo del resto de las letras) al asigarle su valor correspondiente,java no devuelve el 'simbolo' de la ñ. Por
        //lo tanto las condiciones que había que incluir para tenerla en cuenta cada vez que se pasaba de la 'n' a la 'o' eran cada vez más numerosas teniendo en cuenta las vueltas al abecedario, 
        //lo mismo ocurría cada vez que se entregaba por teclado la ñ o tocaba por cifrado localizarla y ponerla,etc.
        //Me quedaba un código muy largo, donde tampoco pude hacer que funcionara del todo correctamente. Así que finalmente opte por hacerlo definiendo yo misma el abacedario(ejercicio anterior) y dejo aquí como era el
        //método que estaba empleando, pero en su versión sin ñ.
        //Se ha realizado todo siguiendo el mismo razonamiento que en el ejercicio anterior, con la diferencia de que el número de letras en este abecedario es 26.
        //Además al no emplear arrays, desaparece el problema del índice 0, por lo tanto hay una condición menos a la hora de calcular los desplazamientos.
        //En esta versión las letras ya tienen su número asociado en el código ascii, por lo que se compara con ese número en lugar de con los índices de los arrays.
        String texto1;
        char letra;
        char letra2;
        int num;
        int codigo = 4;
        boolean correcto;

        System.out.println("El siguiente programa realiza un cifrado de César. Cifra las mayúsculas, minúsculas pero no la ñ. Los números, vocales con tilde, espacios, puntos y resto de caracteres también quedarán inmutables.");

        Scanner miScanner = new Scanner(System.in);

        System.out.println("Introduce el texto para cifrarlo : ");
        //Adimito cualquier número o caracter introducido por teclado. Simplemente si no se tarta de una mayúscula, minúscula no se cifrará.
        texto1 = miScanner.nextLine();
        StringBuilder texto = new StringBuilder(texto1);
        do {
            correcto = true;
            System.out.println("Introduce el número de desplazamiento (como máximo 25): ");
            try {
                codigo = miScanner.nextInt();
                if (codigo < 0) {
                    System.out.println("No es válido. Tienes que indicar un número entero positivo.");
                    correcto = false;
                } else if (codigo > 25) {
                    System.out.println("No es válido. El desplazamiento no puede ser mayor de 25.");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("No es válido. Tienes que indicar un número entero positivo.");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);

        for (int i = 0; i < texto.length(); i++) {
            letra = texto.charAt(i);
            letra2 = letra;
            num = (int) letra;
            if (((num >= 97) && (num <= 122))) {
                if (num + codigo >= 123) {
                    num = num + codigo - 26;
                } else {
                    num = num + codigo;
                }
            } else if ((num >= 65) && (num <= 90)) {
            } else if ((num + codigo >= 91)) {
                num = num + codigo - 26;
            } else {
                num = num + codigo;
            }
            letra2 = (char) num;
            String letra3 = Character.toString(letra2);
            texto = texto.replace(i, i + 1, letra3);
        }
        System.out.println(texto);

    }

    static void tableta_chocolate() {
        /**
         * Escribe un programa que pida solicite al usuario una cantidad de
         * dinero en euros (puede tener decimales) para pagar una tableta de
         * chocolate que vale 4,65€ El programa debe devolver las monedas o
         * billetes según el dinero que entrega
         */

        //Defino e inicializo las variables necesrias
        double precio = 4.65;
        double paga = 0;
        double vuelta;
        //Contador billetes 500€
        int a = 0;
        //Contador billetes 200€
        int b = 0;
        //Contador billetes 100€
        int c = 0;
        //Contador billetes 50€
        int d = 0;
        //Contador billetes 20€
        int p = 0;
        //Contador billetes 10€
        int f = 0;
        //Contador billetes 5€
        int g = 0;
        //Contador monedas 2€
        int h = 0;
        //Contador monedas 1€
        int i = 0;
        //Contador monedas 0,50€
        int j = 0;
        //Contador monedas 0,20€
        int k = 0;
        //Contador monedas 0,10€
        int l = 0;
        //Contador monedas 0,05€
        int m = 0;
        //Contador monedas 0,02€
        int n = 0;
        //Contador monedas 0,01€
        int o = 0;

        //Escribo el programa de manera que se pueda adaptar a otras compras, por lo que la variable será fácilmente modificable
        System.out.println("Total compra: " + precio + " €");

        Scanner miScanner = new Scanner(System.in);
        boolean correcto;
        do {
            correcto = true;
            System.out.println("¿De cuánto necesita vuelta?");
            //Pido por teclado la cantidad que se va a dar para pagar. Empleo try..catch para asegurarmme de que si no se introduce un valor double, no
            //avance el programa y vuelva a pedir un valor válido otra vez. También aplico la restricción de que este bucle también se repita si la cantidad
            //introducida es menor de lo que se pide por la compra.
            try {
                paga = miScanner.nextDouble();
                if (paga < precio) {
                    System.out.println("El precio es de " + precio + " €. Dede introducir un valor superior");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor/caracter introducido no es válido");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);

        //Se opera para determinar cúal va a ser la vuelta a devolver
        vuelta = paga - precio;

        System.out.println("Su vuelta son " + vuelta + "€");

        //Una vez conocida la vuelta, aplico una serie de bucles while para determinar con qué y en qué candidad billetes/monedas se da la vuelta.
        //De mayor a menor, teniendo en cuenta todos los billetes y monedas en circulación:
        //Un bucle con un contador autoincrementado se ejecutará siempre que la vuelta sea igual o superior a 500€. Así si temnos una vuelta de por ejemplo
        //de por ejemplo 1300€, la vuelta entra en el bucle y se le restan 500€, el contador estará a 1. Ahora hay 800€, como sigue cumpliendo la condición,
        //vuelve a entrar en el bucle. Ahora se vuelven a restar 500€ y el contador está a 2. Estamos en 300€, por lo que no cumple la condición así que el bucle 
        //se rompe. Así sabemos que de momento se da un vuelta de 2 billetes de 500€ y tenemos aún que devolver 300€ que estrarán en el siguiente bucle para el cual 
        //su condición se cumpla.
        while (vuelta >= 500) {
            a++;
            vuelta = vuelta - 500;
        }
        if (a > 0) {
            System.out.println(a + " billete(s) de 500€");
        }

        while (vuelta >= 200) {
            b++;
            vuelta = vuelta - 200;
        }
        if (b > 0) {
            System.out.println(b + " billete(s) de 200€");
        }

        while (vuelta >= 100) {
            c++;
            vuelta = vuelta - 100;
        }
        if (c > 0) {
            System.out.println(c + " billete(s) de 100€");
        }

        while (vuelta >= 50) {
            d++;
            vuelta = vuelta - 50;
        }
        if (d > 0) {
            System.out.println(d + " billete(s) de 50€");
        }

        while (vuelta >= 20) {
            p++;
            vuelta = vuelta - 20;
        }
        if (p > 0) {
            System.out.println(p + " billete(s) de 20€");
        }

        while (vuelta >= 10) {
            f++;
            vuelta = vuelta - 10;
        }
        if (f > 0) {
            System.out.println(f + " billete(s) de 10€");
        }

        while (vuelta >= 5) {
            g++;
            vuelta = vuelta - 5;
        }
        if (g > 0) {
            System.out.println(g + " billete(s) de 5€");
        }

        while (vuelta >= 2) {
            h++;
            vuelta = vuelta - 2;
        }
        if (h > 0) {
            System.out.println(h + " moneda(s) de 2€");
        }

        while (vuelta >= 1) {
            i++;
            vuelta = vuelta - 1;
        }
        if (i > 0) {
            System.out.println(i + " moneda(s) de 1€");
        }

        while (vuelta >= 0.50) {
            j++;
            vuelta = vuelta - 0.50;
        }
        if (j > 0) {
            System.out.println(j + " moneda(s) de 0,50€");
        }

        while (vuelta >= 0.20) {
            k++;
            vuelta = vuelta - 0.20;
        }
        if (k > 0) {
            System.out.println(k + " moneda(s) de 0,20€");
        }

        while (vuelta >= 0.10) {
            l++;
            vuelta = vuelta - 0.10;
        }
        if (l > 0) {
            System.out.println(l + " moneda(s) de 0,10€");
        }

        while (vuelta >= 0.05) {
            m++;
            vuelta = vuelta - 0.05;
        }
        if (m > 0) {
            System.out.println(m + " moneda(s) de 0,05€");
        }

        while (vuelta >= 0.02) {
            n++;
            vuelta = vuelta - 0.02;
        }
        if (n > 0) {
            System.out.println(n + " moneda(s) de 0,02€");
        }

        while (vuelta >= 0.01) {
            o++;
            vuelta = vuelta - 0.01;
        }
        if (o > 0) {
            System.out.println(o + " moneda(s) de 0,01€");
        }

    }

    static void fibonacci() {
        /**
         * Se define la serie de Fibonacci como 1,1,2,3,5,8,13,21… donde los dos
         * primeros términos son 1 y cada término restante es la suma de los dos
         * anteriores. Formalmente, considerando el 0 como índice del primer
         * elemento, cada termino a(i) se calcula como: 1, (si i = 0, i = 1)
         * a(i-1)+ a(i-2), (si i>1) • Solicitar al usuario el término i-ésimo
         * que desea y mostrarlo por pantalla.
         */

        //Defino e inicializo las variables necesarias (empleo a para a(i), a0 para a(i-2) y a1 para a(a-1)).
        int cont;
        int ind = 0;
        int a = 0;
        int a0 = 1;
        int a1 = 1;

        Scanner miScanner = new Scanner(System.in);
        //Como el valor del índice que se pide es un int, se hará el control de errores con try y catch, repitiendo el bucle
        //do...while simpre que el valor intrtoducido no se corresponda con un int. Además también se controlará que el valor del índice
        //no supere 45(ya que en la serie Fibonacci, el término a(46) es edmasiado grande para caber en un int) y sea simepre nayor o igual
        //de cero(de otra manera no tiene sentido).
        boolean correcto;
        do {
            correcto = true;
            System.out.println("Introduce el índice i de la serie de Fibonacci del término a(i) que quieres conocer (este programa considera i=0 el primer índice y sólo calcula hasta el índice i=45): ");
            try {
                ind = miScanner.nextInt();
                if (ind < 0) {
                    System.out.println("El índice introducido no es válido. Los índices de la serie empiezan en cero.");
                    correcto = false;
                }
                if (ind > 45) {
                    System.out.println("El índice introducido no es válido. Este programa sólo calcula hasta el índice i=45");
                    correcto = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("El número/caracter introducido no es válido. Debes introducir un numero entero positivo(hasta 45) o cero.");
                miScanner.next();
                correcto = false;
            }
        } while (!correcto);

        //Para los índices i=0 y i=1, empleo la condición if ya que el modo de obtener los términos a(0) y a(1) es distinto del del resto de la serie
        if (ind == 0) {
            a = 1;
            System.out.println("El término a(" + ind + ") de la serie de Fibonacci es " + a);
        } else if (ind == 1) {
            a = 1;
            System.out.println("El término a(" + ind + ") de la serie de Fibonacci es " + a);
        } else {
            //Para los términos de a(2) hasta a(n) empleo el bucle for.
            //A partir del índice i=2 y hasta que el índice sea igual al índice n introducido, se repite el bucle aumenta el índice(por medio de un contador)de uno en uno
            for (cont = 2; cont <= ind; cont++) {
                //La serie de Fibonacci se obtiene
                a = a1 + a0;
                //Una vez obtenido el térnimo de a de la vuelta, se reasignan los valores necesarios para 
                //que la siguiente vuelta tenga sentido.
                //A a0 se le asigna siempre el valor actual de a1, convirtiéndose en el a(i-2) de la siguiente vuelta.
                a0 = a1;
                //A a1 se le asigna siempre el valor actual de a, conviertiendose en el a(i-1) de la siguiente vuelta.
                a1 = a;

            }
            //Se devuelve el resultado final.
            System.out.println("El término a(" + ind + ") de la serie de Fibonacci es " + a);
        }

    }

}
