/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.modelosventanas;

import java.util.Arrays;

/**
 *
 * @author a20estefaniapc
 */
public class Ventana_ModeloA {
    
    //propiedades static y final de la clase
    public static final int ANCHO=40;
    public static final int LARGO=50;
    public static final int PRECIO= 60;
   
    
    //Inicialización de un array de Strings
    public static final String[] COLORES={"rojo", "verde", "azul", "gris", "blanco"};
    
    private String color;
    
    public static int contador;
    
    public static int contadorrojo;
    public static int contadorverde;
    public static int contadorazul;
    public static int contadorgris;
    public static int contadorblanco;
    
    public static int contadorvendidas;
    
    
    
    //constructores
    public Ventana_ModeloA(){
    }
    
    public Ventana_ModeloA(String color){
        this.color=color;
    }
    
    public String getColor(){
    return color;
    }
    
    public void setColor(String color){
    this.color=color;
    }
    
    public static int getAncho(){
    return ANCHO;
    }
    
    public static int getLargo(){
    return LARGO;
    }
    
    public static String getColores(){
    return Arrays.toString(COLORES); //método para pasar un array a String
    }
    
    public static int getPrecio(){
    return PRECIO;
    }
    
}
