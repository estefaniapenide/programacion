/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.ejemplohashmap;

import java.util.Random;

/**
 *
 * @author a20estefaniapc
 */
public class Alumno {

    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
    
//    @Override
//    public int hashCode(){
//        Random num = new Random(10);
           //mirar el casting y probar
//        int num2 = (int)num;
//    return num;
//    }
    
    
    @Override
    public String toString(){
      return nombre+" "+nota+" "+"hashCode:"+hashCode();
    }

}
