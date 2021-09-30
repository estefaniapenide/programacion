/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.bucle_for;

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
    static void factorial() {
        //Defino las varibales y aquellas que van a ser usadas dentro de los bucles ya las 
        //inicializo aquí para que que no de problemas de inicialización de variable al
        //llamarlas al final fuera de los bucles.
        String num;
        int numero = 1;
        int resultado = 1;

        Scanner miScanner = new Scanner(System.in);

        boolean correcto;
        //Mientras el boolean correcto sea true, el bucle no se repetirá y aceptará el valor de entrada. Pero si pasa por alguno de los supuestos
        //donde el boolean sea falso, el bucle se repetirá ya que se habrá metido una variable no válida y pedirá otra.
        do {
            correcto = true;
            //Al estar trabajando con int se puede pedir el factorial hasta el número 33, pero para el 34 el resultado ya será demasido grande.
            System.out.println("Introduce un número entero entre 0 y 33 para calcular su factorial: ");
            //Los datos de entrada se tomarán como un String para poder despues redefinirlos como convenga para poder
            //tener en cuenta las excepciones que no interesa que se introduzcan y poder controlarlas.
            num = miScanner.nextLine();
            try {
                //Queremos que la variable introducida sea un int pero que pertenezca al intervalo (0,33).
                numero = Integer.valueOf(num);
                //Si el número introducido es un int pero es menor que cero o mayor que 33, volverá a repetir el bucle pidiendo de nuevo una veriable de entrada nueva y válida.
                if (numero < 0 || numero > 33) {
                    System.out.println(numero + " no es un número entre 0 y 33. Este programa no puede calcular su factorial.");
                    correcto = false;
                }
                //Cogerá la excepción cuando el número introducido no sea un int y volverá a repetir el bucle pidiendo de nuevo una veriable de entrada nueva y válida.
            } catch (Exception e) {
                System.out.println("No has introducido un número/caracter válido.");
                correcto = false;
            }

        } while (!correcto);
        //Empezando con el contador en 2 y aumentandolo de uno en uno hasta llegar al valor del número introducido.
        for (int contador = 2; contador <= numero; contador++) {
            //Cada resultado obtenido será el producto del resultado anterior por el contador correspondiente. Así por ejemplo, para el número 4:
            //resultado1=1*2; contador=3, contador<numero;
            //resultado2=(1*2)*3; contador=4, contador<=numero;
            //resultado3=(1*2*3)*4; contador=5, contador>numero, por lo que termina el bucle for.
            resultado = resultado * contador;
        }
        //Se da por pantalla el último valor del resultado obtenido.
        System.out.println(numero + "!=" + resultado);

    }

    static void sumatorio() {
        //Defino las varibales y aquellas que van a ser usadas dentro de los bucles ya las 
        //inicializo aquí para que que no de problemas de inicialización de variable al
        //llamarlas al final fuera de los bucles.
        String num;
        int numero = 1;
        int resultado = 0;

        Scanner miScanner = new Scanner(System.in);

        boolean correcto;
        //Mientras el boolean correcto sea true, el bucle no se repetirá y aceptará el valor de entrada. Pero si pasa por alguno de los supuestos
        //donde el boolean sea falso, el bucle se repetirá ya que se habrá metido una variable no válida y pedirá otra.
        do {
            correcto = true;
            //Queremos que la variable introducida sea un int pero que no se trate de un número negativo, ya que no estamos realizando los sumatorios en valor absoluto.
            System.out.println("Introduce un número entero positivo para relaizar su sumatorio: ");
              //Los datos de entrada se tomarán como un String para poder despues redefinirlos como convenga para poder
            //tener en cuenta las excepciones que no interesa que se introduzcan y poder controlarlas.
            num = miScanner.nextLine();
            try {
                //Si el caracter introducido se puede convertir a int, lo hacemos así.
                numero = Integer.valueOf(num);
                //En caso de ser un int pero no cumplir la condición de positivo, volverá a repetir el bucle pidiendo de nuevo una veriable de entrada nueva y válida.
                if (numero < 0) {
                    System.out.println(numero + " es menor que cero. Este programa calcula sumatorios de números positivos");
                    correcto = false;
                }
                //Cogerá la excepción cuando el número introducido no sea un int y volverá a repetir el bucle pidiendo de nuevo una veriable de entrada nueva y válida.
            } catch (Exception e) {
                System.out.println("No has introducido un número/caracter válido.");
                correcto = false;
            }
        } while (!correcto);
         //Empezando con el contador en 0 y aumentandolo de uno en uno hasta llegar al valor del número introducido.
        for (int contador = 0; contador <= numero; contador++) {
            //Cada resultado obtenido será la suma del resultado anterior más el contador correspondiente. Así por ejemplo, para el número 4:
            //resultado1=1+0; contador=2, contador<numero;
            //resultado2=(1+0)+2; contador=3, contador<=numero;
            //resultado3=(0+1+2)+3; contador=4, contador<=numero;
            //resultado4=(0+1+2+3)+4; contador=5, contador>numero, por lo que termina el bucle for.
            resultado = resultado + contador;
        }
        //Se da por pantalla el último valor del resultado obtenido.
        System.out.println("El sumatorio de " + numero + " es igual a " + resultado);

    }

//        
    static void divisores() {
        //Defino las varibales y aquellas que van a ser usadas dentro de los bucles ya las 
        //inicializo aquí para que que no de problemas de inicialización de variable al
        //llamarlas al final fuera de los bucles.
        String num;
        int numero = 1;
        int resultado;

        Scanner miScanner = new Scanner(System.in);

        boolean correcto;
        //El fucionamiento es el mismo que el visto en los programas anteriores. Aquí nos interesa que la variable
        //introducida sea un int y que sea mayor que cero, así que se procede igual que en los casos anteriores
        //teniendo en cuenta esas`particularidades.
        do {
            correcto = true;
            System.out.println("Intruduce un número entero mayor que cero para calcular sus divisores: ");
            num = miScanner.nextLine();
            try {
                numero = Integer.valueOf(num);
                if (numero <= 0) {
                    System.out.println("Este programa no calcula los divisores de números negativos ni del cero.");
                    correcto = false;
                }
            } catch (Exception e) {
                System.out.println("No has introducido un número/caracter válido.");
                correcto = false;
            }
        } while (!correcto);
        System.out.println("Los divisores de " + numero + " son:");
        //Empezando con el primer divisor de prueba igual a 1 y aumentandolo de uno en uno hasta llegar al valor del número introducido.
        for (int divisor = 1; divisor <= numero; divisor++) {
            //Si el número al ser divido entre el divisor de prueba da resto 0, significa que ese sí que será un divisor.
            //Si no ocurre así, ese divisor de prueba no se tendrá en cuenta
            if (numero % divisor == 0) {
                resultado = divisor;
                //Todos los divisores de prueba que pasan el corte ya explicado serán divisores el número, por lo que todos ellos
                //se muestran por pantalla.
                System.out.println(resultado);
            }
        }

    }

    static void media() {
        //Defino las varibales y aquellas que van a ser usadas dentro de los bucles ya las 
        //inicializo aquí para que que no de problemas de inicialización de variable al
        //llamarlas al final fuera de los bucles.
        int contador;
        int contneg=0;
        int contceros=0;
        double num = 0;
        double suma = 0;
        double media = 0;
        boolean correcto;

        Scanner miScanner = new Scanner(System.in);

        System.out.println("A continuación te van a ir pidiendo hasta 10 números de uno en uno para calcular su media (el punto de los números decimales debe escribirse con coma).");
        //Ponemos un for para que se repita 10 veces el mensaje para pedir 10 variables de entrada.
        for (contador = 1; contador <= 10; contador++) {
            //Control de las variables de entrada empleando el método ya conocido. La única restricción que pondermos para dar la variable
            //como válida que es pueda ser definida como double.
            do {
                correcto = true;
                System.out.println("Introduce un número: ");
                try {
                    num = miScanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("No has introducido un número/caracter válido.");
                    miScanner.next();
                    correcto = false;
                }
            } while (!correcto);
           
           //Para contar los valores introducidos negativos. Sumarlos según los vamos acumulando y calcular su media.
            if(num<0){
            contneg++;
            suma=suma+num;
           
            media = suma / contneg;
            //Para contar los valores introducidos igual a cero
            }else if (num==0){
            contceros++;
            }
            
            
        }
        //Devolvemos por pantalla el último valor del bucle ya que es el acumulado entre 10 que buscábamos.
        System.out.println("La media de los numeros negativos es " + media);
        System.out.println("Has introducido "+contceros+" cero(s).");

    }

    static void primo() {
         //Defino las varibales y aquellas que van a ser usadas dentro de los bucles ya las 
        //inicializo aquí para que que no de problemas de inicialización de variable al
        //llamarlas al final fuera de los bucles.
        String num;
        int numero = 0;
        int resultado = 0;
        int suma = 0;
        boolean correcto;

        Scanner miScanner = new Scanner(System.in);
        //Control de las variables de entrada empleando el método ya conocido. Las restricción que pondremos para dar la variable
        //como válida que es se trate de un int mayor que cero.
        do{
        correcto=true;
        System.out.println("Introduce un número entero positivo: ");
        num=miScanner.nextLine();
        try{
        numero = Integer.valueOf(num);
        if(numero<=0){
        System.out.println("El número no es válido. Debes introducir un número entero mayor que cero.");
        correcto=false;
        }
        }catch(Exception e){
        System.out.println("El número no es válido. Debes introducir un número entero mayor que cero.");
        correcto=false;
                }
        }while(!correcto);
        //Mediante el bucle for se calculan los divisores de la misma manera que se hizo un par de ejercicios antes
        for (int divisor = 1; divisor <= numero; divisor++) {
            resultado = numero % divisor;
            if (numero % divisor == 0) {
                resultado = divisor;
                //Una vez conocidos los divisores hay que distinguir si estos son solo el propio número y el 1 (lo que significaría
                //que el número introducido es primo) o tiene también otros (el número no sería primo).
                //Para ello se ha usado la lógica de que si un número es primo, la suma de sus divisores será igual al propio número
                //más uno, y si no lo es, la suma será mayor.
                suma = suma + resultado;
            }
        }
        //Así delvemos por pantalla según si cumple esta condición o no una de las dos posibilidades.
            //Por ejemplo, los divisores de 12 son 12, 6, 4, 3, 2 y 1. La suma de todos ellos es mayor que 12+1, por lo tanto no es primo
            if (suma > numero + 1) {
                System.out.println(numero + " NO es primo");
            //Por otro lado, los divisores de 11 son 11 y 1. La suma de ambos es 12, al igual que la de los de 7 sería 8 o que la de los de 
            //27 sería 28.
            } else if (suma == numero + 1) {
                System.out.println(numero + " es primo");
            }
        
    }

    static void escalera() {
        //Aquí simplemente he empleado el bucle for de manera que la variable que se inicializa vaya aumentando en valor de uno
        //en uno hasta el valor requerido para formar cada peldaño de la escalera. Como el bucle nos devuelve todos los valores
        //que va tomando a lo largo de su realización, pues se muestrarán todos ellos por pantalla en el orden adecuado para formar la escalera.
        
        for (int a = 1; a <= 1; a++) {
            System.out.print(a);
        }
        System.out.println("");
        for (int b = 1; b <= 2; b++) {
            System.out.print(b);
        }
        System.out.println("");
        for (int c = 1; c <= 3; c++) {
            System.out.print(c);
        }
        System.out.println("");
        for (int d = 1; d <= 4; d++) {
            System.out.print(d);
        }
        System.out.println("");
        for (int e = 1; e <= 5; e++) {
            System.out.print(e);
        }
        System.out.println("");
        for (int f = 1; f <= 6; f++) {
            System.out.print(f);
        }
        System.out.println("");
        for (int g = 1; g <= 7; g++) {
            System.out.print(g);
        }
        System.out.println("");
        for (int h = 1; h <= 8; h++) {
            System.out.print(h);
        }
        System.out.println("");
        for (int i = 1; i <= 9; i++) {
            System.out.print(i);
        }
        System.out.println("");
        for (int j = 1; j <= 10; j++) {
            System.out.print(j);
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
                System.out.println("1. Ejercicio 1_Factorial");
                System.out.println("2. Ejercicio 2_Sumatorio");
                System.out.println("3. Ejercicio 3_Divisores");
                System.out.println("4. Ejercicio 4_Media");
                System.out.println("5. Ejercicio 5_Primo");
                System.out.println("6. Ejercicio 6_Escalera");
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
                    factorial();
                    break;
                case 2:
                    sumatorio();
                    break;
                case 3:
                    divisores();
                    break;
                case 4:
                    media();
                    break;
                case 5:
                    primo();
                    break;
                case 6:
                    escalera();
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
