/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.bucles_while_y_do_while;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static void cambio_for_a_while() {
//     Realiza un método que tenga el mismo resultado que el siguiente código:
//            for(int x=10; x<=100; x=x+10){
//            System.out.println(x);}
//   Este método nos dará vaolres de 10 en 10 entre 10 y 100, ya se inicializa en 10 y termina cuando se alcance el valor de 100.

        //Mientras x sea menor que 100 el bucle se repetirá.
        //Empezando con x=0, el primer valor que nos devuelve while será 10 ya que (x=0+10), y así segurirá hasta que esa cuenta 
        //de 100. Una vez lo haga el bucle no se repetirá ya que es condición que x sea menor que 100 y por lo tanto cuando llega ahí
        //no vuelve a entrar en el bucle.
        System.out.println("Valores de 10 a 100 de 10 en 10: ");
        int x = 0;
        while (x < 100) {
            x = x + 10;
            System.out.println(x);
        }

    }

    static void correcion_1() {
//        Corrige el siguiente código para que muestre los nº del 1 al 10.
//        int x = 1;
//        while (x >= 10) {
//            System.out.println(x);
//        }

        //Mientras x sea menor que 10 el bucle se repetirá.
        //Empezando con x=0, el primer valor que nos devuelve while será 1 ya que x++, y así segurirá hasta que esa cuenta 
        //de 10. Una vez lo haga el bucle no se repetirá ya que es condición que x sea menor que 10 y por lo tanto cuando llega ahí
        //no vuelve a entrar en el bucle.
        System.out.println("Valores del 1 al 10: ");
        int x = 0;
        while (x < 10) {
            x++;
            System.out.println(x);
        }

    }

    static void correcion_2() {
        /**
         * Corrige el siguiente código para que muestre los números de 10 a 1
         * int x = 10; while (x >= 0) { x--; System.out.println(x); }
         */

        //Mientras x sea mayor que 1 el bucle se repetirá.
        //Empezando con x=11, el primer valor que nos devuelve while será 10 ya que x=--x, y así segurirá hasta que esa cuenta 
        //de 1. Una vez lo haga el bucle no se repetirá ya que es condición que x sea mayor que 1 y por lo tanto cuando llega ahí
        //no vuelve a entrar en el bucle.
        System.out.println("Valores de 10 al 1: ");
        int x = 11;
        while (x > 1) {
            x = --x;
            System.out.println(x);
        }
    }

    static void factorial_sumatorio() {
        /**
         * Calcular el factorial y el sumatorio de un número que se pida por
         * pantalla (no mayor que 10) y mostrar al final los resultados.
         */
        //Definio las variables e inicializo las necesarias.
        String numero;
        int num = 1;
        int contador;
        int resultado;

        System.out.println("Cálculo de factorial y sumatorio de un número.");

        Scanner miScanner = new Scanner(System.in);

        //Pido el número del que calcular su factorial y sumatorio, para el factorial solo es posible calcularlo si el número
        //introducido está entre 0 (no existe el factorial de los negativos) y 33 (al definirlo como un int no cabe un resultado
        //de cálculo de factorial para un número mayor). Así mediante un do...while con un try...catch me aseguro de que el núemro
        //introducido sea un entero entre 0 y 33.
        //Cómo funciona esto ya se ha explicado varias veces en el ejercicio de bucles for.
        boolean correcto;
        do {
            correcto = true;
            //Pido un número
            System.out.println("Introduce un número entero entre 0 y 33: ");
            numero = miScanner.nextLine();
            try {
                num = Integer.valueOf(numero);
                //Si el número es mayor que 33, el bucle se repite
                if (num > 33) {
                    System.out.println("Es un número superior a 33. Este programa no puede calcular su factorial.");
                    correcto = false;
                    //Si el número es menor que 0, el bucle se repite
                } else if (num < 0) {
                    System.out.println("Es un número inferior a 0. El factorial es una operación que sólo se le aplica a los números naturales, esto es, enteros positivos.");
                    correcto = false;
                }
                //Si el número introducido no es un int, el catch pararía el programa, pero se le añade correcto=false
                //para que el bucle do...while se repita en ese caso.
            } catch (Exception e) {
                System.out.println("No has introducido un número/caracter válido.");
                correcto = false;
            }
        } while (!correcto);

        //Inicializo las variables para poder referirme a ellas fuera del bucle while y que no me de error.
        contador = 2;
        resultado = 1;
        //Bucle while para calcular el factorial. Mientras el contador sea menor o igual que el número, el bucle while se repetirá
        while (contador <= num) {
            resultado = resultado * contador;
            contador = contador + 1;
            //Cada resultado obtenido será el producto del resultado anterior por el contador correspondiente. Así por ejemplo, para el número 4:
            //resultado1=1*2; contador=3, contador<numero;
            //resultado2=(1*2)*3; contador=4, contador<=numero;
            //resultado3=(1*2*3)*4; contador=5, contador>numero, por lo que no vuelve a entrar en el bucle while.
        }
        //Devuelvo el último valor del bucle
        System.out.println(num + "!=" + resultado);

        //Inicializo las variables para poder referirme a ellas fuera del bucle while y que no me de error.
        contador = 1;
        resultado = 0;
        //Bucle while para calcular el sumatorio. Mientras el contador sea menor o igual que el número, el bucle while se repetirá
        while (contador <= num) {
            resultado = resultado + contador;
            contador = contador + 1;
            //Cada resultado obtenido será la suma del resultado anterior más el contador correspondiente. Así por ejemplo, para el número 4:
            //resultado1=0+1; contador=2, contador<numero;
            //resultado2=(0+1)+2; contador=3, contador<=numero;
            //resultado3=(0+1+2)+3; contador=4, contador<=numero; 
            //resultado2=(0+1+2+3)+4; contador=5, contador>numero, por lo que no vuelve a entrar en el bucle while.
        }
        //Devuelvo el último valor del bucle
        System.out.println("El sumatorio de " + num + " es igual a " + resultado);
    }

    static void adivina_numero() {
        /**
         * Implementa un programa para jugar a adivinar un número que se genera
         * de forma aleatoria entre 0 y 100. Después de cada intento, el
         * programa te dará pistas como “ demasiado alto ” o demasiado bajo ”.
         * Debes permitir solo 10 intentos.
         */

        //Definio las variables e inicializo las necesarias.
        int intento = 1;
        int aleatorio;
        //Se gerenera un número aleatorio entre 0 y 100
        Random miRandom = new Random();
        aleatorio = miRandom.nextInt(100);

        System.out.println("Tienes 10 intentos para adivinar un número entre 0 y 100");
        String numero;
        int num = 1;
        Scanner miScanner = new Scanner(System.in);
        boolean correcto;

        do {
            //Pido un número entero entre 0 y 100 y controlo mediante do...while y try...catch, como se explicó con antelación, que el número introducido cumpla esos
            //requisitos. Si nos los cumple, el bucle se repite hasta que el núrmero sea válido.
            do {
                correcto = true;
                System.out.println("Introduce un número entre 0 y 100: ");
                numero = miScanner.nextLine();

                try {
                    num = Integer.valueOf(numero);
                    if (num < 0 || num > 100) {
                        System.out.println("El número introducido tiene que estar entre 0 y 100");
                        correcto = false;
                    }
                } catch (Exception e) {
                    System.out.println("No has introducido un número/caracter válido.");
                    correcto = false;
                }
            } while (!correcto);

            //Cada número introducido, una vez pasa el corte anterior, pasa por lo siguiente:
            //Si el número es menor que el generado por el programa, se devuelve el mensaje de que es demasiado bajo y se indica el número de intento.
            if (num < aleatorio) {
                System.out.println("Intento " + intento);
                System.out.println("Demasiado bajo");
            } //Si el número es menor que el generado por el programa, se devuelve el mensaje de que es demasiado alto y se indica el número de intento.
            else if (num > aleatorio) {
                System.out.println("Intento " + intento);
                System.out.println("Demasiado alto");
            } //Si el número introducido es el generado por el programa, se devuelve un mensaje que confirma el acierto y el número de intento en el que se ha conseguido.
            //Además se romperá el bucle por ser una de las condiciones explicadas más abajo.
            else if (num == aleatorio) {
                System.out.println("¡Felicudades!¡Has acertado en el intento " + intento + "!");
            }

            //Los intentos se contabilizan aquí. Al tratarse de un bucle do...while, cada vez que se da una vuelta sumamos un intento más, habiendolo inicializado arriba con el 
            //la cantidad de intentos igual a cero.
            //El bucle anterior solo deja pasar los valores enteros entre 0 y 100, por lo que cada valor introducido que no cumpla esos requisitos, no es tenido en cuenta por
            //este bucle y no se contabiliza como intento. Los intentos se cuentan solo para los valores introducidos válidos.
            intento++;

            //En cada vuelta se comprueba si el número introducido es distinto del generado y la cantidad de intentos. Si el número introducido es distinto del generado y
            //el número de intentos es menor o igual que 10, se repite el bucle hasta que uno de los dos no se cumpla.
        } while ((num != aleatorio) && (intento <= 10));

        //CSi el bucle se rompe por haber superado el número de intentos, lo que también ocurre es que el último número con el que se ha intentado no es igual al generado.
        //Cunando se da esta condición, se devuelve el mensaje de haber perdido.
        if (num != aleatorio) {
            System.out.println("Lo siento. Has perdido. Te has quedado sin intentos.");
            System.out.println("El número que buscabas era " + aleatorio);
        }

    }

    static void tablas_multiplicar() {
        /**
         * Crea un programa que muestre las tablas de multiplicar del 2 al 9.
         */

        System.out.println("Las tablas de multiplicar del 2 al 9:");
        //Para obtener los número del 2 al 9, se define e inicializa la variable en 1.
        int num = 1;
        //Simepre que sea menor de 9 se repetirá el bucle while
        while (num < 9) {
            //Se va aumentando de uno en uno por cada vuelta. Cuando llegue a 9 ya no volverá a entrar en el bucle
            //y como se inicializó fuera con valor 1, su primer valor dentro del bucle será 2.
            num++;
            //Por cada uno de los valores del bucle anterior, queremos 10 valores asociados (del 1 al 10).
            //Por latanto se realiza otro bucle while dentro del anterior.
            //Para obtener los número del 1 al 10, se define e inicializa la variable en 0.
            int num2 = 0;
            //Simepre que sea menor de 10 se repetirá el bucle while
            while (num2 < 10) {
                //Se va aumentando de uno en uno por cada vuelta. Cuando llegue a 9 ya no volverá a entrar en el bucle
                //y como se inicializó fuera con valor 1, su primer valor dentro del bucle será 1.
                num2++;
                //Una vez tenemos todos los valores solo queda multiplicarlos entre ellos.
                int num3;
                num3 = num * num2;

                //Se muestran todos ellos en forma de tablas de multiplicar con sus correspondientes resultados.
                System.out.println(num + "*" + num2 + "=" + num3);
            }

        }
    }

    static void rectangulo() {
        /**
         * Crea un programa que pinte un rectángulo con * en función de la
         * altura y anchura que se pida por pantalla.
         */

        //Se definen las variables y se inicializan las necesarias.
        int Alt = 0;
        int Anch = 0;
        StringBuilder ver = new StringBuilder("**");
        String hor = "";
        int anch1 = 0;
        int anch2 = 0;
        int alt = 0;

        Scanner miScanner = new Scanner(System.in);
        //Se piden el número de * que se quieren de alto y de ancho.
        //Se require un int por lo que se hará el control de excepciones como ya se ha explicado con anterioridad y se repetirá la petición del número
        //hasta que se introduzcan valores válidos.
        boolean a, b;
        do {
            a = true;
            System.out.println("Introduce la altura del rectágulo:");
            try {
                Alt = miScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un valor válido");
                miScanner.next();
                a = false;
            }
        } while (!a);

        do {
            b = true;
            System.out.println("Introduce el ancho del rectángulo: ");
            try {
                Anch = miScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un valor válido");
                miScanner.next();
                b = false;
            }
        } while (!b);

        //Para las líenas horizontales se parte de una cadena vacía en la que se irán aumentando los * por medio de un bucle while
        while (anch1 < Anch) {
            //En cada vuelta se añade un * a la cadena
            //Cuando el contador alcance el valor del ancho pedido, deja de entrar en el bucle y para de aumentar la cadena.
            anch1++;
            hor = hor + "*";
        }
        //Para las lineas verticales de parte de una Cadena hecha a partir de StringBuilder ya que necesitaremos usar el método insert.
        //Esta inicialmente está formada por dos *
        while (anch2 < (Anch - 2)) {
            //En cada vuelta se añade un espacio entre los * a la Cadena
            //Cuando el contador alcance el valor del ancho pedido menos 2(ya que se quiere que las verticales queden debajo del principio y del final
            //de las líneas horizontales), deja de entrar en el bucle y para de aumentar la cadena.
            anch2++;
            ver = ver.insert(1, " ");
        }

        //Para dibujarlo se mustran los últimos valores obtenidos de las cadenas en los bucles.
        //Primero la cadena horizontal
        System.out.println(hor);
        //Después las cadenas verticales se repiten el número de veces que se pide el alto menos dos (ya que los elemnetos del principio y del final de las cadenas horizontales
        //se suman en el dibujo a las verticales). Para se emplea un bucle while que se repite hasta alcanzar el valor ya indicado
        while (alt < (Alt - 2)) {
            System.out.println(ver);
            alt++;
        }
        //Por último la cadena horizontal otra vez
        System.out.println(hor);

    }

    static void rectangulo_ascii() {
        /**
         * Realiza una mejora utilizando como carácter para el círculo un
         * carácter ASCII gráfico. Utiliza en este caso el código hexadecimal
         * para dar valor al carácter.
         */

        //Se ha hecho lo mismo que en el anterior ejercicio pero los * han sido reemplazados por @ usando el código ASCII donde el valor asignado es 64.
        // https://elcodigoascii.com.ar/codigos-ascii-extendidos/caracter-grafico-codigo-ascii-242.html
        //Como el ejercicio pide que se asignen los valores hexadecimales, 64 en hexadecimal es 40, por lo que:
        int c = 0x40;
        char d = (char) c;

        int Alt = 0;
        int Anch = 0;

        StringBuilder ver = new StringBuilder();
        String hor = "";

        Scanner miScanner = new Scanner(System.in);
        boolean a, b;
        ver.append(d);
        ver.insert(1, d);
        do {
            a = true;
            System.out.println("Introduce la altura del rectágulo:");
            try {
                Alt = miScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un valor válido");
                miScanner.next();
                a = false;
            }
        } while (!a);

        do {
            b = true;
            System.out.println("Introduce el ancho del rectángulo: ");
            try {
                Anch = miScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un valor válido");
                miScanner.next();
                b = false;
            }
        } while (!b);

        int anch1 = 0;
        int anch2 = 0;
        int alt = 0;

        while (anch1 < Anch) {
            anch1++;
            hor = hor + d;
        }
        while (anch2 < (Anch - 2)) {
            anch2++;
            ver = ver.insert(1, " ");
        }

        System.out.println(hor);
        while (alt < (Alt - 2)) {
            System.out.println(ver);
            alt++;
        }
        System.out.println(hor);
    }

    static void cajero_automatico() {
        /**
         * Realiza el programa que simule a un cajero automático. Debe pedir una
         * contraseña para poder realizar las operaciones. Debe mostrar un menú
         * con las operaciones: ingresar dinero, retirar dinero, ver saldo,
         * cambiar contraseña. Este menú debe utilizar do.. while El saldo
         * inicial se asigna desde el programa al inicio
         */

        //Se definen e nicializan las variables necesarias
        double saldo = 2000;
        int password = 1;
        int pin = 345;
        double ingreso = 0;
        double retirada = 0;

        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduce la tarjeta (el PIN correcto es " + pin + ". Te lo muestro para que no lo tengas que buscar en el código)");
        System.out.println("Dispondrás de 4 intentos para introducir el PIN.\nEn caso de agotarlos la tarjeta se bloqueará.");

        boolean correcto;
        int intento = 0;
        int salir;

        //Se pide el PIN que permita acceder al menú o no. Se permitirán 4 intentos, si en el cuarto no se introduce el valor correcto se finaliza el programa
        do {
            //Cada vez que se meta un int incorrecto para el PIN, siempre que los intentos sean inferiores a 4, el bucle volverá a empezar desde aquí
            do {
                correcto = true;
                //Se pide el PIN que tendrá que ser un int. Cada vez que se meta algo distinto,siempre que los intentos sean inferiores a 4, el bucle volverá a empezar desde aquí
                System.out.println("Introduce el pin");
                try {
                    password = miScanner.nextInt();
                    //Si el valor introducido no es un int,catch cogerá la excepción evitando que se pare el progroma y correcto=false indicará que se tiene que repetir el bucle
                } catch (InputMismatchException e) {
                    System.out.println("El PIN NO es correcto");
                    //Se cuentan los intentos. Aumenta en uno en cada vuelta al bucle
                    intento++;
                    miScanner.next();
                    correcto = false;
                }
            } while ((!correcto) && (intento < 4));

            //Una vez introducido el int se comprueba si es igual al valor pin definido e ninicialzado
            //Si no lo es, muestra el mensaje y se vuelve a repetir el bucle siempre que no se superen los 4 intentos
            if (pin != password) {
                System.out.println("El PIN NO es correcto");
                //Si lo es, muestra el mensaje y acaba el bucle
            } else if (pin == password) {
                System.out.println("El PIN es correcto");
            }
            //Se siguen contado los intentos. Aumenta en uno en cada vuelta al bucle
            intento++;
        } while ((pin != password) && (intento < 4));
        //El bucle habrá finalidado cuando el número de intentos se haya sobrepasado o cuando se introduzca el PIN correcto
        //Si el número de intentos es igual o superior a 4. Se muestra el mensaje y se acaba el programa
        if (intento >= 4) {
            System.out.println("Has sobrepasado el número de intentos. El PIN ha quedado bloqueado. Dirigite a una sucursal para cambiarlo o también puedes realizar el cambio online.");
        }

        //Si el valor del PIN es el correcto se accederá al menú
        if (pin == password) {

            int opcion = 1;

            do {
                boolean valido;
                do {
                    valido = true;
                    //Se muestran las opciones a elegir. Cada vez que se meta un valor incorrecto el bucle do while se repite desde aquí por lo que se volverán a mostrar
                    System.out.println("-------------------");
                    System.out.println("Elija que operación quiere realizar");
                    System.out.println("1. Ingresar dinero");
                    System.out.println("2. Retirar dinero");
                    System.out.println("3. Ver saldo");
                    System.out.println("4. Cambiar contraseña");
                    System.out.println("0. Salir");

                    try {
                        opcion = miScanner.nextInt();
                        //Si el valor introducido no es un int,catch cogerá la excepción evitando que se pare el progroma y donde valido=false indicará que se tiene que repetir el bucle
                    } catch (InputMismatchException e) {
                        System.out.println("El número/carater introducido no es válido");
                        miScanner.next();
                        valido = false;
                    }

                } while (!valido);

                //Aquí solo llegan los valores tipo int. El swicht ejecutará el caso que se corresponda al valor del int introducido
                switch (opcion) {
                    case 1:
                        //Cuando el valor introducido es 1
                        boolean a;
                        do {
                            a = true;
                            //Se pide la cantidad  ingresada que tendrá que ser un int. Cada vez que se meta un valor incorrecto el bucle do while se repite desde aquí por lo que se volverán a mostrar
                            System.out.println("Indique la cantidad ingresada: ");
                            try {
                                ingreso = miScanner.nextDouble();
                                //Si el valor introducido no es un int,catch cogerá la excepción evitando que se pare el programa y donde valido=false indicará que se tiene que repetir el bucle
                            } catch (InputMismatchException e) {
                                System.out.println("No ha introducido un valor válido");
                                miScanner.next();
                                a = false;
                            }
                        } while (!a);
                        //Se suma el valor introcudido, que pasó la criba anterior, al saldo
                        saldo = saldo + ingreso;
                        System.out.println("Su saldo actualizado es de " + saldo + "€");
                        break;
                    case 2:
                        //Cuando el valor introducido es 2
                        boolean b;
                        do {
                            b = true;
                            //Se pide la cantidad a retirar que tendrá que ser un int. Cada vez que se meta un valor incorrecto el bucle do while se repite desde aquí por lo que se volverán a mostrar
                            System.out.println("Indique la cantidad a retirar: ");
                            try {
                                retirada = miScanner.nextDouble();
                                //Si el valor introducido no es un int,catch cogerá la excepción evitando que se pare el programa y donde valido=false indicará que se tiene que repetir el bucle
                                //Si se trata de un int, no podrá ser superior al saldo
                                if (retirada > saldo) {
                                    System.out.println("Su saldo actual es de " + saldo + "€.No puede retirar la cantidad de " + retirada + "€");
                                    miScanner.next();
                                    b = false;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("No ha introducido un valor válido");
                                miScanner.next();
                                b = false;
                            }
                        } while (!b);
                        //Se resta el valor introcudido, que pasó la criba anterior, al saldo
                        saldo = saldo - retirada;
                        System.out.println("Su saldo actual tras la gestión es de " + saldo + "€");
                        break;
                    case 3:
                        //Cuando el valor introducido es 3
                        //Se muestra el valor del saldo
                        System.out.println("Su saldo actual es de " + saldo + "€");
                        break;
                    case 4:
                        //Cuando el valor introducido es 4
                        boolean c;
                        do {
                            c = true;
                            //Se pide el nuevo PIN que se restringe a int. Cada vez que se meta un valor incorrecto el bucle do while se repite desde aquí por lo que se volverán a mostrar
                            System.out.println("Escriba su nuevo PIN (tiene que estar formado por dígitos)");
                            try {
                                pin = miScanner.nextInt();
                                //Si el valor introducido no es un int,catch cogerá la excepción evitando que se pare el programa y donde valido=false indicará que se tiene que repetir el bucle
                            } catch (InputMismatchException e) {
                                System.out.println("No ha introducido un valor válido");
                                miScanner.next();
                                c = false;
                            }
                        } while (!c);
                        break;
                    case 0:
                        //Cuando el valor introducido es 0
                        System.out.println("Gracias por usar nuestra red de cajeros.");
                        break;
                    default:
                        //Cuando el valor introducido es cualquier otro int distinto a los ya mencionados
                        System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                }

            } while (opcion != 0);

        }

    }

    public static void main(String[] args) {

        int vbleControl = 6;

        Scanner input = new Scanner(System.in);

        do {
            boolean correcto;
            do {
                correcto = true;

                System.out.println("--------------------------------------------------");
                System.out.println("Escribe el número de la opción a elegir:");
                System.out.println("1. Cambio_for_a_while");
                System.out.println("2. Correcion_1");
                System.out.println("3. Correcion_2");
                System.out.println("4. Factorial_sumatorio");
                System.out.println("5. Adivina_numero");
                System.out.println("6. Tablas_multiplicar");
                System.out.println("7. Rectangulo");
                System.out.println("8. Rectangulo_ascii");
                System.out.println("9. Cajero_automatico");
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
                    cambio_for_a_while();
                    break;
                case 2:
                    correcion_1();
                    break;
                case 3:
                    correcion_2();
                    break;
                case 4:
                    factorial_sumatorio();
                    break;
                case 5:
                    adivina_numero();
                    break;
                case 6:
                    tablas_multiplicar();
                    break;
                case 7:
                    rectangulo();
                    break;
                case 8:
                    rectangulo_ascii();
                    break;
                case 9:
                    cajero_automatico();
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
}
