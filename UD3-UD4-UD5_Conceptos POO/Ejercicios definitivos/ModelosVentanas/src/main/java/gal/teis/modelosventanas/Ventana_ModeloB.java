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
public class Ventana_ModeloB {
    
    //propiedades static y final de la clase
    public static final int ANCHO=50;
    public static final int LARGO=60;
    public static final int PRECIO= 70;
    
    
    //Inicialización de un array de STrings
    public static final String[] COLORES={"gris", "blanco"};
    
    private String color;
    
    public static int contador;
    public static int contadorgris;
    public static int contadorblanco;
    
    public static int contadorvendidas;
     
      //constructores
    public Ventana_ModeloB(){
    }
    
    public Ventana_ModeloB(String color){
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
