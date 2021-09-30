/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplousofilereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
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
    public static void main(String[] args) {
        
        String texto="Otra prueba más"
                + "tahora.";
        
        System.out.println(contarPalabras2(texto));

        Scanner input = new Scanner(System.in);
        int option;
        do {

            System.out.println("------------------------");
            System.out.println("1. Leer archivo.");
            System.out.println("2. Editar archivo(añadir respuesta).");
            System.out.println("3. Sobreescribir el archivo.");
            System.out.println("4. Copiar archivo.");
            System.out.println("5. Contar número de palabras del archivo.");
            System.out.println("0. Salir.");

            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("LEER ARCHIVO");
                    System.out.println("Introduzca el nombre del fichero:");
                    String nombreFichero1=ControlData.leerString(input);
                    try {
                        leeTodosLosCaracteres(nombreFichero1);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("EDITAR ARCHIVO");
                    System.out.println("Introduzca el nombre del fichero:");
                    String nombreFichero2=ControlData.leerString(input);
                    System.out.println("Escriba el texto que desea añadir:");
                    String texto1=ControlData.leerString(input);
                    try {
                    escribeCaracteres(nombreFichero2,texto1);
                    System.out.println("ARCHIVO EDITADO");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 3:
                    System.out.println("SOBREESCRIBIR ARCHIVO");
                    System.out.println("Introduzca el nombre del fichero:");
                    String nombreFichero3=ControlData.leerString(input);
                    System.out.println("Escriba el nuevo contenido del archivo:");
                    String texto2=ControlData.leerString(input);
                    try {
                    sobreescribeCaracteres(nombreFichero3,texto2);
                    System.out.println("ARCHIVO SREESCRITO");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 4:
                    System.out.println("COPIAR ARCHIVO");
                    System.out.println("Introduzca el nombre del fichero:");
                    String nombreFichero4=ControlData.leerString(input);
                    lecturaEscrituraBufferFlujoTexto_Texto(nombreFichero4);
                    System.out.println("ARCHIVO COPIADO");
                    break;
                case 5:
                    System.out.println("Introduzca el nombre del fichero:");
                    String nombreFichero=ControlData.leerString(input);
                    System.out.println("Número de palabras en "+nombreFichero+":");
                    try {
                    System.out.println(contarPalabras(nombreFichero));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("No se ha escogido ninguna de las opciones");
                    break;
            }

        } while (option != 0);

        input.close();
    }

    static void leeTodosLosCaracteres(String nombreFichero) throws IOException {
        //Objeto File con fichero de texto
        File miFile = new File(nombreFichero);
        //Objeto para almacenar los caracteres leídos del fichero
        StringBuilder miSB = new StringBuilder();
        //Objeto Reader para leer el fichero de texto en UTF-8
        Reader miFileReader = new FileReader(miFile, Charset.forName("UTF-8"));
        //buffer de char para ir leyendo del fichero
        char[] buffer = new char[1024];
        //Leo buffer a buffer hasta el final del fichero
        while (miFileReader.read(buffer) != -1) {
            //Agrego a la cadena los caracteres leídos
            miSB.append(buffer);
        }
        //Cierro el fichero
        miFileReader.close();
        //Muestro por pantalla la cedena, resultado de leer el fichero
        System.out.println(miSB.toString());
    }

    static int contarPalabras(String nombreFichero) throws IOException {
        int num = 0;
        File archivo = new File(nombreFichero);
        Reader lector = new FileReader(archivo, Charset.forName("UTF-8"));

        StringBuilder cadena = new StringBuilder();
        char[] buffer = new char[1024];

        while (lector.read(buffer) != -1) {
            cadena.append(buffer);
        }

        String texto = cadena.toString();
        String[] partes = texto.split(" ");
        //System.out.println(Arrays.asList(partes));
        num = partes.length;

        return num;
    }

    static void escribeCaracteres(String nombreFichero, String texto) throws IOException {
        //Creo un objeto FileWriter a partir de un fichero existente
        //para añadir texto al final(true)
        Writer miFW = null;
        try {
            miFW = new FileWriter(new File(nombreFichero), true);
            //Determino el texto a añadir
            String cadena = "\n"+texto;
            //Agrego la cadena al final del fichero
            miFW.write(cadena);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            miFW.close();
        }
    }

    static void sobreescribeCaracteres(String nombreFichero, String texto) throws IOException {
        //Creo un objeto FileWriter a partir de un fichero existente
        //para sobreescribir el fichero (false)
        Writer miFW = null;
        try {
            miFW = new FileWriter(new File(nombreFichero), false);
            //Determino el texto a añadir
            String cadena = texto;
            //Agrego la cadena al final del fichero
            miFW.write(cadena);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            miFW.close();
        }
    }

    static void lecturaEscrituraBufferFlujoTexto_Texto(String nombreFichero) {
        int dato;
        File miFilesOrigen = new File(nombreFichero);
        File miFilesDestino = new File("Copia"+nombreFichero);
        //Objeto Reader para leer el fichero de texto UTF-8
        try ( BufferedReader mBR = new BufferedReader(
                new FileReader(miFilesOrigen, Charset.forName("UTF-8")));  BufferedWriter mBW = new BufferedWriter(
                new FileWriter(miFilesDestino, Charset.forName("UTF-8")))) {
            //Leo dato a dato del buffer hasta el final de fichero
            while ((dato = mBR.read()) != -1) {
                mBW.write(dato);//Escribo el búfer de salida
            }
        } catch (FileNotFoundException e) {
            //Tratar la excepcion
        } catch (IOException e) {
            //Tratar la excepcion
        }
    }
    
 public static int contarPalabras2(String texto){
        int num = 0; 
        String[] partes = texto.split(" ");
        System.out.println(Arrays.asList(partes));
        num = partes.length ;

        return num;
    }

}
