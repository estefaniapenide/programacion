/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectorectangulo2;

/**
 *
 * @author a20estefaniapc
 */
public class Rectangulo {
    //atributos
    private int lado1;
    private int lado2;
    
   //Métodos get que permitane la consulta de los atributos 
    public int getLado1(){
    return lado1;
    }
    
    public int getLado2(){
    return lado2;
    }
    
    //Métodos set que permiten la modificación del valor de los atributos
    public void setLado1(int lado1){
    this.lado1=lado1;
    }
    
    public void setLado2(int lado2){
    this.lado2=lado2;
    }

    //Métodos para calcular el área y el perímetro del rectángulo
    public double area() {
        return lado1 * lado2;
    }

    public double perimetro() {
        return lado1 * 2 + lado2 * 2;
    }
}
