/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Estefania
 */
public class GestionFichero {
        public static void guardar_Fichero(String nombreFichero, String texto) throws IOException {
        //Se usa try con recursos para no tener que cerrar los recursos
        try ( BufferedWriter salida = new BufferedWriter(new FileWriter(new File(nombreFichero), Charset.forName("UTF-8"), false))) {
            //Escribe el texto en el fichero de salida
            salida.write(texto);
            //Para garantizar que el buffer vacía todo en el fichero
            salida.flush();
        }
    }

    public static String leer_Fichero(String nombreFichero) throws IOException {
        int dato;
        StringBuilder contenidoFichero = new StringBuilder();
        //Creo un FileReader a partir de un fichero de texto y codifico cada carazter con UTF-8
        try ( BufferedReader mBR = new BufferedReader(new FileReader(new File(nombreFichero), Charset.forName("UTF-8")))) {
            //Voy leyendo el flujo de entrada de datos y guardo cada lectura en bufI
            String linea = mBR.readLine();
            while (linea != null) {
                contenidoFichero.append(linea + "\n");
                linea = mBR.readLine();
            }
        }
        return contenidoFichero.toString();
    }

    public static int contarPalabras(String texto) {

        int num = 0;
        StringBuilder filasSeguidasStringBuilder = new StringBuilder();
        String filasSeguidas = "";
        ArrayList<String> palabras = new ArrayList<String>();

        //Se guarda cada fila del texto como un elemento de un array
        String[] arrayFilas = texto.split("\n");
        //String[] arrayFilas = texto.split("\r");

        //Se recorre todo el arrya de filasSeguidas
        for (int i = 0; i < arrayFilas.length; i++) {
            //Siempre que no se trate de filasSeguidas en blanco, se añadarirán a un StringBuilder todas seguidas.
            //Se le añade un espacio en blanco entre filasSeguidas para que dos palabas distintas que estaban en distintas filasSeguidas, no pasen 
            //a juntarse y ser una al meterlas en el StringBuilder
            if (!arrayFilas[i].isBlank()) {
                filasSeguidasStringBuilder.append(arrayFilas[i] + " ");
            }
        }

        //Se pasa ese StringBuilder a String
        filasSeguidas = filasSeguidasStringBuilder.toString();

        //Se guarda cada elemento separado por espacios del String como un elemento de un array
        String[] partes = filasSeguidas.split(" ");

        //Siempre que un elemento del array partes no sea un espacio en blanco, se añadirá a un ArrayList
        for (int i = 0; i < partes.length; i++) {
            if (!partes[i].isBlank()) {
                palabras.add(partes[i]);
            }
        }
        //Cada elemento del ArrayList resultante será una palabra. Por lo tanto, su tamaño será el número de palabras que había en el texto
        num = palabras.size();

        return num;
    }

    public static int contarCaracteres(String texto) {

        //Se eliminan todos los espacios, saltos de linea y retrocesos de carro del texto
        texto = texto.replaceAll(" ", "");
        texto = texto.replaceAll("\n", "");
        texto = texto.replaceAll("\r", "");

        //El texto resultante sólo está compuesto de los caracteres que se desean contar. 
        //La longitud del texto será igual a su número de caracteres.
        int numCaracteres = texto.length();

        return numCaracteres;
    }

    public static int contarVocales(String texto) {

        int contadorVocales = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u'
                    || texto.charAt(i) == 'á' || texto.charAt(i) == 'é' || texto.charAt(i) == 'í' || texto.charAt(i) == 'ó' || texto.charAt(i) == 'ú') {
                contadorVocales++;
            }
        }
        return contadorVocales;
    }

    public static int contarLineas(String texto) {

        int numLineas = 0;
        StringBuilder filasSeguidasStringBuilder = new StringBuilder();
        String filasSeguidas = "";

        if (texto.isBlank()) {
            numLineas = 0;
        } else {
            //Se guarda cada fila del texto como un elemento de un array
            String[] arrayFilas = texto.split("\n");
            numLineas = arrayFilas.length;
        }

//        //En caso de no querer  contar las líneas en blanco, se añadarirán a un ArrayList para contarlas.
//        //Se recorre todo el arrya de filasSeguidas. El número de filas totales sería filas.size();
//       ArrayList<String> filas = new ArrayList<String>();
//        for (int i = 0; i < arrayFilas.length; i++) {     
//            if (!arrayFilas[i].isBlank()) {
//                filas.add(arrayFilas[i]);
//            }
//        }
        return numLineas;
    }

    public static int contarPachas(String texto) {

        int contadorPachas = 0;
        texto=texto.toLowerCase();
        StringTokenizer s = new StringTokenizer(texto);
        boolean encontro = false;
        while (s.hasMoreTokens() && !encontro) {
            String t = (String) s.nextToken();
            if (t.toLowerCase().equals("pacha")) {
                contadorPachas++;
            }
        }
        return contadorPachas;
    }

    public static String queenPacha(String texto) {
        
        String textoFinal = "";

        StringBuilder textoInicial = new StringBuilder(texto);
        StringBuilder textoBuilder = new StringBuilder();
        
        if(texto.startsWith("pacha")){
        textoInicial.replace(0, 5, "QUEEN PACHA");
        }
        if(texto.startsWith("Pacha")){
        textoInicial.replace(0, 5, "QUEEN PACHA");
        }
        
        texto=textoInicial.toString();
        
        String[] arrayPacha = texto.split("pacha");
        for(String aux:arrayPacha){
        System.out.println(aux);}
        for(int i=0; i<arrayPacha.length; i++){
        textoBuilder.append(arrayPacha[i]+" QUEEN PACHA ");
        }
//        for (int i = 0; i < textoBuilder.length(); i++) {
//            if (i == textoBuilder.indexOf("pacha")) {
//                textoBuilder.insert(i, "QUEEN ");
//            }
//        }
        int tamano=textoBuilder.length();
        textoBuilder.delete(tamano-13, tamano);
        textoFinal = textoBuilder.toString();
        return textoFinal;
    }

    public static String verLineas(String texto) {

        int numLineas = 0;

        StringBuilder textoLineas = new StringBuilder();
        String textoFinal = "";

        StringBuilder filasSeguidasStringBuilder = new StringBuilder();
        String filasSeguidas = "";
        //Se guarda cada fila del texto como un elemento de un array
        String[] arrayFilas = texto.split("\n");
        for (int i = 0; i < arrayFilas.length; i++) {
            textoLineas.append((i + 1) + ". " + arrayFilas[i] + "\n");

        }
        textoFinal = textoLineas.toString();
        return textoFinal;

    }

    public static String ocultarLineas(String texto) {

        String Lineas;
        StringBuilder textoLineas = new StringBuilder();
        String textoFinal = "";

        //Se guarda cada fila del texto como un elemento de un array
        String[] arrayFilas = texto.split("\n");
        for (int i = 0; i < arrayFilas.length; i++) {
            Lineas = arrayFilas[i].replaceFirst("[1-9]{1,6}. ", "");
            textoLineas.append(Lineas + "\n");
        }
        textoFinal = textoLineas.toString();
        return textoFinal;
    }


    /*Métodos alternativos para usar con los botones que están comentados en la clase Contenido. Son exactamente igual pero leen un fichero en lugar
    del texto del JTextPane directamente*/
    public static int contarPalabras2(String nombreFichero) throws IOException {

        int num = 0;
        String texto = "";

        texto = leer_Fichero(nombreFichero);

        String[] arrayFilas = texto.split("\n");
        //String[] arrayFilas = texto.split("\r");
        StringBuilder filasStringBuilder = new StringBuilder();
        String filas = "";

        for (int i = 0; i < arrayFilas.length; i++) {
            if (!arrayFilas[i].isBlank()) {
                filasStringBuilder.append(arrayFilas[i] + " ");
            }
        }

        filas = filasStringBuilder.toString();
        String[] partes = filas.split(" ");
        ArrayList<String> palabras = new ArrayList<String>();

        for (int i = 0; i < partes.length; i++) {
            if (!partes[i].isBlank()) {
                palabras.add(partes[i]);
            }
        }
        num = palabras.size();

        return num;
    }

    public static int contarCaracteres2(String nombreFichero) throws IOException {

        String texto = "";
        int numCaracteres = 0;

        texto = leer_Fichero(nombreFichero);

        texto = texto.replaceAll(" ", "");
        texto = texto.replaceAll("\n", "");
        texto = texto.replaceAll("\r", "");

        numCaracteres = texto.length();

        return numCaracteres;
    }

    public static int contarVocales2(String nombreFichero) throws IOException {

        int contadorVocales = 0;
        String texto = "";

        texto = leer_Fichero(nombreFichero);

        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u'
                    || texto.charAt(i) == 'á' || texto.charAt(i) == 'é' || texto.charAt(i) == 'í' || texto.charAt(i) == 'ó' || texto.charAt(i) == 'ú') {
                contadorVocales++;
            }
        }
        return contadorVocales;
    }

    public static String verLineas2(String nombreFichero) throws IOException {
        int numLineas = 0;
        String texto = "";
        StringBuilder textoLineas = new StringBuilder();
        String textoFinal = "";
        texto = leer_Fichero(nombreFichero);

        StringBuilder filasSeguidasStringBuilder = new StringBuilder();
        String filasSeguidas = "";
        //Se guarda cada fila del texto como un elemento de un array
        String[] arrayFilas = texto.split("\n");
        for (int i = 0; i < arrayFilas.length; i++) {
            textoLineas.append((i + 1) + ". " + arrayFilas[i] + "\n");

        }
        textoFinal = textoLineas.toString();
        return textoFinal;

    }

    public static String ocultarLineas2(String nombreFichero) throws IOException {

        String texto = "";

        String Lineas;
        StringBuilder textoLineas = new StringBuilder();
        String textoFinal = "";

        texto = leer_Fichero(nombreFichero);

        //Se guarda cada fila del texto como un elemento de un array
        String[] arrayFilas = texto.split("\n");
        for (int i = 0; i < arrayFilas.length; i++) {
            Lineas = arrayFilas[i].replaceFirst("[1-9]{1,6}. ", "");
            textoLineas.append(Lineas + "\n");
        }
        textoFinal = textoLineas.toString();
        return textoFinal;
    }
    
    
}
