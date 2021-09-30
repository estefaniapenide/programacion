/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.tema1_ejemplos;

import java.util.Scanner;

/**
 *
 * @author Estefanía
 */
public class tema1_ejemplos {

    /**
     * @param args the command line arguments
     */
    static void tipos_datos_0() {
        // Asignación de un tipo de caracter
        char a = 'L';
        //int es el tipo más utilizado
        //para valores numéricos
        int i = 89;
        //use byte y short para enteros
        //más pequeños
        byte b = 4;
        //esto dará error ya que nº
        //es mayor que el rango de bytes
        //byte b1=7888888955;
        short s = 56;
        //esto dará error ya que el nº es
        //más grande que el rango de short
        //short s1= 87878787878;

        //por defecto, el valor de la 
        //fraccion es doble en Java
        double d = 4.355453532;

        //para float use 'f' como sufijo
        //Si no pongo el sufijo dará error
        float f = 4.7333434f;

        System.out.println("char: " + a);
        System.out.println("int: " + i);
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("float: " + f);
        System.out.println("double: " + d);

    }

    static void tipos_datos() {
        //Censo de un país: China
        long censo = 1_395_380_000;
        //Nombre de un amigo/a
        String nombre = "Paula";
        //Código postal
        String codigo = "36211";
        //Si tiene carnet de conducir o no
        boolean carnet = true;
        //Diámetro de una superficie de una instalación de una ciudad
        double diametro = 267890000;
        //Peso de un contenedor de un puerto
        float peso = 3578E4f;
        //Edad de una persona
        byte edad = 40;
        //Inicial de un nombre
        char inicial = 'C';
        //Plantas de un edificio
        byte plantas = 7;
        //Número de alumnos/as de un centro escolar
        short alumnos = 1000;
        //Número de módulos de un ciclo de FP
        byte modulos = 12;
        System.out.println("Censo de un país: China: " + censo);
        System.out.println("Nombre de un amigo/a: " + nombre);
        System.out.println("Código postal: " + codigo);
        System.out.println("Si tiene carnet de conducir o no: " + carnet);
        System.out.println("Diámetro de una superficie de una instalación de una ciudad: " + diametro);
        System.out.println("Peso de un contenedor de un puerto: " + peso);
        System.out.println("Edad de una persona: " + edad);
        System.out.println("Inicial de un nombre: " + plantas);
        System.out.println("Número de alumnos/as de un centro escolar: " + alumnos);
        System.out.println("Número de módulos de un ciclo de FP: " + modulos);
    }

    static void overflow_tipos_primitivos() {
        byte a = 126;

        //byte tiene un vaor de 8 bits
        System.out.println(a);

        a++;
        System.out.println(a);

        //Se desborda aquí porque
        //el byte puede contener valores de -128 a 127
        a++;
        System.out.println(a);
        //rotación de rango
        a++;
        System.out.println(a);

        //Se produce una excepción
        //a = 300;
    }

    static void precision_float_double() {
        float b = 1f / 3f;
        System.out.println("El resultado es " + b);

        int i = 100;
        //conversión automática de tipo
        long l = i;

        //conversión automática de tipo
        float f = l;

        System.out.println("Valor int " + i);
        System.out.println("Valor long " + l);
        System.out.println("Valor float " + f);
    }

    static void casting_0() {
        float b = 1f / 3f;
        System.out.println("El resultado es " + b);

        int i = 100;
        //conversión automática de tipo
        long l = i;

        //conversión automática de tipo
        float f = l;

        System.out.println("Valor int " + i);
        System.out.println("Valor long " + l);
        System.out.println("Valor float " + f);
    }

    static void casting_1() {
        double c = 100.4;
        //casting de tipo
        long d = (long) c;

        //casting de tipo
        int e = (int) d;
        System.out.println("Valor Doble " + c);
        System.out.println("Valor Long " + d);
        System.out.println("Valor Int " + e);
    }

    static void casting_2() {
        byte j;
        int g = 257;
        double h = 323.142;
        System.out.println("Conversión int a byte,");
        j = (byte) g;
        System.out.println("int = " + g + " byte = " + j);
        System.out.println("\nConversión de double a byte.");
        j = (byte) g;
        System.out.println("double = " + h + " byte = " + j);
    }

    static void constantes() {
        //al declarar una constante se tiene que añadir la
        //palabra reservada final y el identificador que la
        //representa se suele escribir en mayúsculas
        final int N = 100;
        final char ULTIMA = 'Z';
        final double PI = 3.141592;
    }

    static void tipos_outputs_cadenas() {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un nombre (con next): ");
        String nombreNext = input.next();
        System.out.println("El nombre leído con next " + nombreNext);

        System.out.println("Introduce un nombre (con nextline): ");
        String nombreNextline = input.nextLine();
        System.out.println("El nombre leído con next " + nombreNextline);

        System.out.println("Introduce un caracter: ");
        char elcaracter = input.next().charAt(0);
        System.out.println("El caracter es " + elcaracter);
    }

    static void entrada_salida() {
        //Programa que pida un número entero y nos diga si es par o no

        int numero;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduzca un número entero: ");
        numero = input.nextInt();

        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar");
        }
    }

//    static void errores_compilacion(){
//    int suma=0;
//    String nombre;
//    suma=nombre; //error 1
//    
//    int valor=0;
//    short numero=0;
//    numero=valor; //error 2
//    
//    String valor=""; //error 3
//    
//    int mayor;
//    int menor;
//    if(true){
//    mayor=menor; //error 4
//    }
//    }
//    
    static void errores_ejecucion() {

        int sumaNotasExamenes = 60;
        int numeroExamenes = 0;
        try {
            int promedio = sumaNotasExamenes / numeroExamenes;
        } catch (Exception e) {
            System.out.println("Se ha prodicido la excepción " + e);
            System.out.println("Error .toString:" + e.toString());
            System.out.println("Error .getMessage:" + e.getMessage());
            System.out.println("Error .getLocalizedMessage:" + e.getLocalizedMessage());
        }
    }

    static void excepciones() {
        //Programa que pida un número entero y nos diga si es par o no
        //con control básico de excepciones
        int numero;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca un número: ");
        try {
            numero = input.nextInt();
            if (numero % 2 == 0) {
                System.out.println("El número " + numero + " es par.");
            } else {
                System.out.println("El número " + numero + " es impar.");
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error en la introducción de datos");
            System.out.println("Se ha prodicido la excepción " + e);
            System.out.println("Error .toString:" + e.toString());
            System.out.println("Error .getMessage:" + e.getMessage());
            System.out.println("Error .getLocalizedMessage:" + e.getLocalizedMessage());
        }
    }

    static void excepciones_2() {
        int[] array = new int[20];
        try {
            array[20] = 24;
            //Me va salir error de array porque lo hemos definido 
            //de tamaño 20, es decir, tiene valores asignados en los puestos
            //de 0 a 19 (20 en total).
            //Así que el mayor array[n], es con n=19.
            //Si lo cambiamos y le ponemos algo con sentido, el error que nos 
            //detecta es el siguiente: el de la operación en la que dividimos entre 0
            int b = 0;
            int a = 23 / b;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Error de índice de un array");
        } catch (ArithmeticException exception) {
            System.out.println("Error aritmético");
        }
    }

    static void operadores_1() {
        int i = 2, j, k;
        j = i * 3; //resultado: j=2*3=&
        i++;  //resultado: i=2+1=3
        System.out.println(i);
        j *= i; //es igual que poner j=j*i resultado: j=6*3=18
        k = j % i; //resultado: k=18%3=0
        i++; //resultado: i=3+1=4
        //j/=i; //resultado: j=18/3=4
        double x = 3.5, y, z;
        y = x + 4.2; //resultado: y=3.5+4.2=7.7
        x--; //resultado: x=3.5-1.0=2.5
    }

    static void postIncremento() {
        int a = 5;
        System.out.println("El valor de a es: " + a);

        //operador post incremental
        //el valor actual de "a" es usado y
        //mostrado por pantalla, luego
        //el valor incrementa una unidad
        System.out.println("El valor de a es: " + a++);

        //mostramos nuevamente el valor de "a", donde
        //podemos observar el incremento realizado
        System.out.println("El valor de a es: " + a);
    }

    static void preIncremento() {
        int a = 5;
        System.out.println("El valor de a es: " + a);

        //operador pre incremental
        //el valor actual de "a" es incrementado en una unidad y
        //luego es usado para ser mostrado en pantalla
        System.out.println("El valor de a es: " + ++a);

        //mostramos nuevamente el valor de "a", que
        //no ha variado
        System.out.println("El valor de a es: " + a);
    }

    static void incrementos() {
        int a = 3, b;
        b = --a;
        b = a--;
    }

    static void dividir_cero_1(){
    double x=5;
    double y=0;
    double z=x/y;
    System.out.println(z);
    }
    static void dividir_cero_2() {
        float x = 5.0f;
        float y = 0.0f;
        float z = x / y;
        System.out.println(z);
    }

    static void operadores_3() {
        int a = 20, b = 10, c, d, e = 10, f = 4, g = 9;

        //operador de asignación simple
        c = b;
        System.out.println("Valor de c = " + c);
        //Va a dar Valor de c = 10

        //operadores de asignaciones simples
        a = a + 1;
        b = b - 1;
        e = e * 2;
        f = f / 2;
        System.out.println("a,b,e,f = " + a + "," + b + "," + e + "," + f);
        //Va a dar a,b,e,f=21,9,20,2

        a = a - 1;
        b = b + 1;
        e = e / 2;
        f = f * 2;
        System.out.println("a,b,e,f = " + a + "," + b + "," + e + "," + f);
        //Va a dar a,b,e,f=20,10,10,4

        //operadores de asignación reducidos
        a += 1;
        b -= 1;
        e *= 2;
        f /= 2;
        System.out.println("a,b,e,f (usando operadores reducidos)= " + a + "," + b + "," + e + "," + f);
        //Va a dar a,b,e,f(usando operadores reducidos)=21,9,20,2
    }

    static void operaradores_aritmeticos_relacionales() {
        int a = 20, b = 10;
        String x = "Supercalifragilístico";
        String y = "Supercalifragilístico";

        boolean condicion = true;

        //varios operadores condicionales
        System.out.println("a==b: " + (a == b));
        System.out.println("a<b: " + (a < b));
        System.out.println("a<=b: " + (a <= b));
        System.out.println("a>b: " + (a > b));
        System.out.println("a>=b: " + (a >= b));
        System.out.println("a!=b: " + (a != b));

        if (x == y) {
            System.out.println("Las cadenas x e y son iguales");
        }
        System.out.println("condicion==true: " + (condicion == true));
    }

    static void operador_ternario() {
        int a = 3, c = 4;
        String b;
        b = a < c ? "que a es menor" : "que a es mayor";
        System.out.println("El resultado es " + b);
    }

    static void operador_ternario_0() {
        int a = 3, c = 4;
        boolean b;
        b = a < c ? true : false;
        System.out.println("El resultado es " + b);
    }

    static void operador_ternario_1() {
        int a = 18, b = 14, c = 22, maximo;
        maximo = a > b ? a : b;
        System.out.println(maximo);
        maximo = maximo > c ? maximo : c;
        System.out.println(maximo);
    }

    static void operador_ternario_2() {
        int a = 18, b = 14, c = 22;
        String s = "";
        s = (a > b && a > c) ? "máximo=" + a : s + "";
        s = (b > a && b > c) ? "máximo=" + b : s + "";
        s = (c > a && c > b) ? "máximo=" + c : s + "";
        System.out.println(s);
        //dudas
    }

    static void uso_parentesis() {
        int a1 = 5 * 3 + 2;
        int a2 = (5 * 3) + 2;
        int a3 = 5 * (3 + 2);
        System.out.println("a1=" + a1 + " a2=" + a2 + " a3=" + a3);
        //Solucion: a1=17 a2=17 a3=25

        int b1 = 36 / 2 * 5;
        int b2 = 36 / (2 * 5);
        System.out.println("b1=" + b1 + " b2=" + b2);
        //Solucion: b1=90 b2=3.6

        int c1 = 12 / 2 + 4;
        int c2 = 12 / (2 + 4);
        System.out.println("c1=" + c1 + " c2=" + c2);
        //Solucion: c1=10 c2=2

        int d1 = 2 + (2 * (5 + 5));
        int d2 = (2 + 2) * (5 + 5);
        int d3 = 2 + (2 * 5) + 5;
        System.out.println("d1=" + d1 + " d2=" + d2 + " d3=" + d3);
        //Solucion: d1=22 d2=40 d3=17
    }

//    uso_parentesis_2(){
//     A=5, B=3, C=-12
//    a) A > B    TRUE
//    b) B != C   TRUE
//    c) A == 3   FALSE
//    d) A * B == 5   FALSE
//    e) C / B != -10 TRUE
//    f) A * B == -30 FALSE
//    g) C / B < A    TRUE
//    h) A + B + C == 5   FALSE
//    i) (A + B == 8) && (A - B == 2) TRUE
//    j) (A + B == 8) || (A - B == 6) TRUE
//    k) A > 3 && B > 3 && C < 3  FALSE
//    l) A > 3 && B >= 3 && C < -3  TRUE
//    }
    static void pruebas() {
        String cadena1 = "Esperar";
        String cadena2 = "Esperar";
        String cadena3 = "";

        cadena3 = cadena2;

        //Esto va a funcionar, pero no siempre funciona porque los Strings funcionan como objetos
        //Ver la entrada del blog:
        //https://hoxejaveamos.blogspot.com/2020/11/java-comparacion-de-srings.html
        //https://hoxejaveamos.blogspot.com/
        if (cadena3 == cadena1) {
            System.out.println("Funciona");
        }

    }

    static void metodo_equals() {
        //Esto está explicado en el blog en el enlace del ejemplo anterior
        String cadena1 = "Esperar";
        String cadena2 = "Esperar";
        String cadena3 = new String("Esperar");

        if (cadena1.equals(cadena2)) {
            System.out.println("Cadena1 y cadena2 son iguales");
        } else {
            System.out.println("Cadena1 y cadena2 son distintas");
        }

        if (cadena1.equals(cadena3)) {
            System.out.println("Cadena1 y cadena3 son iguales");
        } else {
            System.out.println("Cadena1 y cadena3 son distintas");
        }
    }

    static void metodos() {
        String cadena = "No por mucho madrugar amanece más temprano";

        System.out.println(cadena.charAt(0));
//Devuelve el carácter indicado por parámetro.
//Tipo de parámetro de entrada: int
//Tipo de parámetro de salida: char
//Por lo tanto:
//Devuelve el primer elemento de la cadena, ya que se empieza a contar
// en el cero. En este caso será 'N'.

        System.out.println(cadena.charAt(9));
        //Devuelve el carácter indicado por parámetro.
        //Tipo de parámetro de entrada: int
        //Tipo de parámetro de salida: char
        //Por lo tanto:
        //Devuleve el octavo elemento de la cadena (porque empezamos en cero, por lo tanto
        //hay que restarle 1).En este caso será 'c'.

        System.out.println(cadena.endsWith("o"));
        //Indica si la cadena acaba con el String pasado por parámetro.
        //Tipo de parámetro de entrada: String
        //Tipo de parámetro de salida: boolean
        //Por lo tanto:
        //Devolverá 'true' o 'false' en función de si el último elemento de la cadena es el
        //especificado o no. Hay que tener en cuenta que hace diferencia entre mayúsculas
        //y minúsculas. En este caso será 'true'.

        System.out.println(cadena.startsWith("n"));
        //Indica si la cadena termina con el String pasado por parámetro.
        //Tipo de parámetro de entrada: String
        //Tipo de parámetro de salida: boolean
        //Por lo tanto:
        //Devolverá 'true' o 'false' en función de si el primer elemento de la cadena es el
        //especificado o no. En este caso será 'false' porque a pesar de ser la letra indicada
        // hace difrencia entre mayúsculas y minúsculas.

        System.out.println(cadena.equals("No por mucho madrugar amanece más temprano"));
        //Indica si una cadena es igual que otra.
        //Tipo de parámetro de entrada: String
        //Tipo de parámetro de salida: boolean
        //Por lo tanto:
        //Devolverá 'true' o 'false' en función de si la cadena es igual al nuevo String  indicado o no.
        //En este caso será 'true'.

        System.out.println(cadena.indexOf("mucho"));
        //Devuelve la posición, mediante un número entero, de una cadena o un carácter 
        //dentro de una cadena de texto nada. En el caso de que el 
        //carácter o la cadena no exista se devuelve un -1. 
        //Tipo de parámetro de entrada: String
        //Tipo de parámetro de salida: int
        //Por lo tanto:    
        //Delvolverá el la posición donde empieza cadena indicada. Hay que tener en cuenta
        // que a la primera posición se le asigna cero. En este caso 'mucho' la posicioón 
        //del primer caracter de mucho es 7.

        System.out.println(cadena.length());
        //	Devuelve la longitud de la cadena.
        //Tipo de parámetro de entrada: ninguno
        //Tipo de parámetro de salida: int
        //Por lo tanto:
        //Devolverá el número de caracteres que ocupa la cadena. En este caso será 42.

        System.out.println(cadena.replace('o', 'i'));
        //Devuelve un String cambiando los caracteres que nosotros le indiquemos.
        //Tipos de parámetros de entrada: char (carácter que existe en el String), char (por el que queremos cambiar)
        //Tipo de parámetro de salida: String
        //Por lo tanto:
        //Devolverá la misma cadena modificada. Todos los caracteres igual al primero indicado
        //ahora serán sustituidos por el segundo indicado. En este caso se reemplazarán todas las
        //'o' por 'i', así tendremos 'Ni pir muchi madrugar amanece más temprani'.

        System.out.println(cadena.toLowerCase());
        //Convierte el String a minúsculas.
        //Tipo de parámetro de entrada: ninguno
        //Tipo de parámetro de salida: String
        //Po lo tanto:
        //Devolverá todos los elementos de la cadena indica en minúsculas. En este caso
        //será 'no por mucho madrugar amanece más temprano'.

        System.out.println(cadena.toUpperCase());
        //Convierte el String a mayúsculas.
        //Tipo de parámetro de entrada: ninguno
        //Tipo de parámetro de salida: String
        //Po lo tanto:
        //Devolverá todos los elementos de la cadena indica en mayúsculas. En este caso
        //será 'NO POR MUCHO MADRUGAR AMANECE MÁS TEMPRANO'.

    }

    static void modificaciones_string_builder() {
        StringBuilder texto3 = new StringBuilder("Otra prueba");

        texto3.append(" más");
        System.out.println("Ttexto 3 es: " + texto3);

        texto3.insert(2, "W");
        System.out.println("Texto 3 es: " + texto3);

        texto3.reverse();
        System.out.println("Y ahora al revés " + texto3);

        System.out.print("En mayúsculas: " + texto3.toString().toUpperCase());

    }

    static void ejercicio_string_builder() {
        String texto = "HOLA";
        System.out.println(texto);
        texto = "ALOH";
        System.out.println(texto);

        StringBuilder texto2 = new StringBuilder(texto);
        texto2.reverse();
        System.out.println(texto2);
    }

    static void hacerInverso() {

        //Empezamos por String
        String texto1 = "HOLA";
        String texto2 = "";

        //Creamos una cadena en orden inverso a texto1
        //y la almacenamos en texto2
        char caracter = texto1.charAt(texto1.length() - 1);
        //caracter es la letra A, que está en el índice 3
        texto2 += caracter;
        caracter = texto1.charAt(texto1.length() - 2);
        texto2 += caracter;
        caracter = texto1.charAt(texto1.length() - 3);
        texto2 += caracter;
        caracter = texto1.charAt(texto1.length() - 4);
        texto2 += caracter;
        System.out.println("La cadena inversa a " + texto1 + " es " + texto2);
        System.out.println("Con String: " + texto2);

        //Ahora con StringBuilder.
        StringBuilder texto3 = new StringBuilder("HOLA");
        texto3.reverse();
        System.out.println("Con StringBuilder: " + texto3);

    }

//    static void wrapper() {
//        int edad_i = 30;
//        Integer edad_I = 40;
//        
//        long a=edad_I.longValue();
//
//        double altura_d = 1.70;
//        Double altura_D = 1.78;
//
//        // Se puede usar métodos para extraer el tipo primitivo de su wrapper
//        //o realizar conversiones
//        altura_d = altura_D.doubleValue();
//        edad_i = altura_D.intValue();
//
//        //Se oueden realizar asignaciones directas entre un tipo primitivo
//        //y su wrapper
//        edad_i = edad_I;
//        edad_I = edad_i;
//
//        altura_d = altura_D;
//        altura_D = altura_d;
//
//        //Los objetos wrapper no permiten conversiones implícitas
//        altura_d = edad_i; //correcto, son tipos primitivos
//        //altura_D = edad_i;//error, altura_D es un wrapper
////        Integer obj_Integer=8;
////        Double obj_Double=9.5;
////        int vble_int=9;
////        double vble_double=6.7;
////        //conversión implícita de un int a double
////        vble_double=vble_int;
////        vble_double=obj_Integer;
////        //Se permiten las asigaciones implicitas de objeto a tipo
////        obj_Double=
////        //No se permiten:
////        obj_Double=obj_Integer;
////        //Si que permite:
////        obj_Integer=obj_Double.intValue();
//    }
    static void tiposWrapper() {

//        System.out.println("Introduce un numero: ");
//        Scanner input=new Scanner(System.in);
//        input.nextInt();
//        
//        int numero;
//       
//        numero=input.nextInt();
//        
//        
//        System.out.println("Tu número por dos es igual a: "+numero*2);    
        System.out.println("Introduce un numero: ");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        String entrada;
        entrada = input.nextLine();
        int numero;
        numero = Integer.parseInt(entrada);
        System.out.println("u número por dos es igual a: " + numero * 2);
//  

    }

    static void wrapper_metodos() {
//Muestra el valor máximo del tipo int
        System.out.println("El valor máximo de Integer es " + Integer.MAX_VALUE);
//Muestra el valor mínimo del tipo int
        System.out.println("El valor mínimo de Integer es " + Integer.MIN_VALUE);

        Double valor_double = 1.67;

//Conversión de Double a String
        String edad_string = valor_double.toString();

//Conversión de String a tipo wrapper
        valor_double = Double.parseDouble("34.5");
        Float valor_float = Float.parseFloat("5.6");
        String valor_string = "3";
        Integer edad = Integer.parseInt(valor_string);

//Muestra el valor máximo del tipo int
        System.out.println("El valor máximo de integer es " + Integer.MAX_VALUE);
//Muestra el valor minimo del tipo int
        System.out.println("El valor minimo de Integer es " + Integer.MIN_VALUE);

    }

    static void ambitos() {
        int x = 20;
        {
            int y = 40;
            x += 4;
            System.out.println("x en el segundo ámbito es " + x);
            System.out.println("y en el segundo ámbito es " + y);
        }
        System.out.println("x en el primer ámbito es " + x);
        //Duda:¿¿El de y del primer ámbito da error de compilación porque 
        //no existe y en el primer ámbito???
        //System.out.println("y en el primer ámbito es "+y);
    }

    static void prueba() {
//        
//        int numero;
//        
//        Scanner input = new Scanner(System.in);
//        System.out.println("Introduce un número de horas: ");
//        numero = input.nextInt();
//        
//       
//        int horas=(numero%24);
//        int numero_dias=(numero/24);
//        int dias=(numero_dias%7);
//        int semanas=(numero_dias/7);
//        System.out.println(numero+" horas son "+semanas+" semana(s),"+dias+" día(s) y "+horas+" hora(s).");
//       
         
           
//        int a=(int)45L;
//        
//        boolean W=false, X=true, Y=true, Z=false;
//        boolean m=(!X && Y && (!Z || !X));
//        System.out.println(m);
    }
    
     static void prueba2() {
        
        double numero;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número de horas: ");
        numero = input.nextDouble();
        System.out.println(numero);
        
       
//        int horas=(int)(numero%24);
//        int numero_dias=(int)(numero/24);
//        int dias=(int)(numero_dias%7);
//        int semanas=(int)(numero_dias/7);
//        System.out.println(numero+" horas son "+semanas+" semana(s),"+dias+" día(s) y "+horas+" hora(s).");
    }


    public static void main(String[] args) {

        //tipos_datos_0();
        //tipos_datos();
        //overflow_tipos_primitivos();
        //precision_float_double();
        //casting_0();
        //casting_1();
        //casting_2();
        //tipos_outputs_cadenas();
        //cadenas();
        //entrada_salida();
        //errores_compilacion();
        //errores_ejecucion();
        //excepciones();
        //excepciones_2();
        //operadores_1();
        //postIncremento();
        //preIncremento();
        //incrementos();
        //dividir_cero_1();
        dividir_cero_2();
        //operadores_3();
        //operaradores_aritmeticos_relacionales();
        //operador_ternario();
        //operador_ternario_0();
        //operador_ternario_1();
        //operador_ternario_2();
        //uso_parentesis();
        //pruebas();
        //metodo_equals();
        //metodos();
        //modificaciones_string_builder();
        //ejercicio_string_builder();
        //hacerInverso();
        //wrapper();
        //tiposWrapper();
        //wrapper_metodos();
        //ambitos();
        //prueba();
    }
}
