/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.estructuras_condicionales;

import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static void par_o_impar(){
        
       int numero;
    Scanner entero =new Scanner(System.in);
        System.out.println("Introduce un número entero: ");
        numero=entero.nextInt();
        
        if (numero%2==0 && numero!=0){
            System.out.println("El número "+ numero+ " es par.");
        }else if (numero%2!=0 && numero !=0){
             System.out.println("El número "+numero+" es impar");
        }else{ 
             System.out.println("El número introducido no es par ni impar, es cero");
         }
//        entero.close();
        }
    
         
        
    static void ano_bisiesto(){
    
        int year;
      Scanner fecha =new Scanner(System.in);
        System.out.println("Intruduce un año: ");
        year=fecha.nextInt();
        
        if ((year%4==0) && (year%100!=0) || (year%400==0)){
            System.out.println("El año "+ year+" es bisiesto");
        } else {
            System.out.println("El año "+year+" NO es bisiesto");
        }
//        fecha.close();
    }    
     
    static void usuario_contrasena(){
    
        String nombre = "paula_gonzalez";
        String contrasena = "fgh/T/ni89";
        
        String name;
        String password;
        
        Scanner dato =new Scanner(System.in);
       
        
        System.out.println("Introduce tu nombre de usuario: ");
        name=dato.nextLine();
        
        System.out.println("Introduce tu contraseña: ");
        password=dato.nextLine();
        
        if ((name.equals(nombre)) && (password.equals(contrasena))){
        System.out.println("Usuario y contraseña correctos");
        }else{
        System.out.println("Nombre de usuario o contraseña INCORRECTOS.");
        }   
//       dato.close(); 
    }
    
    static void tres_numeros(){
    
        int n1, n2, n3;
        
        Scanner numero= new Scanner(System.in);
        
        System.out.println("Introduce un número: ");
        n1=numero.nextInt(); 
        System.out.println("Introduce otro número: ");
        n2=numero.nextInt(); 
        System.out.println("Introduce otro número: ");
        n3=numero.nextInt();
        
        if ((n1<n2) && (n1<n3)){
            if (n2<n3){
            System.out.println("Tus números ordenados de menor a mayor: "+n1+"<"+n2+"<"+n3);
            }else{
            System.out.println("Tus números ordenados de menor a mayor: "+n1+"<"+n3+"<"+n2);
            }
        }else if ((n2<n1)&&(n2<n3)){
            if (n1<n3){
            System.out.println("Tus números ordenados de menor a mayor: "+n2+"<"+n1+"<"+n3);
            }else {
            System.out.println("Tus números ordenados de menor a mayor: "+n2+"<"+n3+"<"+n1);
            }
        }else if ((n3<n1)&&(n3<n2)){
            if (n1<n2){
            System.out.println("Tus números ordenados de menor a mayor: "+n3+"<"+n1+"<"+n2);
            }else{
            System.out.println("Tus números ordenados de menor a mayor: "+n3+"<"+n2+"<"+n1);
            }
        }
//        numero.close();        
    }
    
    static void cifras_numero(){
        int numero;
        int cifra;
        
        Scanner miNumero=new Scanner(System.in);
        System.out.println("Introduce un número entero entre 0 y 99999");
        numero=miNumero.nextInt();
        
        if ((numero>=0)&& (numero<10)) {
            System.out.println("El número "+numero+" tiene 1 cifra");
        }else if ((numero>=10)&&(numero<100)){
            System.out.println("El número "+numero+" tiene 2 cifras");
        }else if ((numero>=100)&&(numero<1000)){
            System.out.println("El número "+numero+" tiene 3 cifras");
        }else if ((numero>=1000)&&(numero<10_000)){
            System.out.println("El número "+numero+" tiene 4 cifras");
        }else if ((numero>=10_000)&&(numero<100_000)){
            System.out.println("El número "+numero+" tiene 5 cifras");
        }else{
          System.out.println("El número "+numero+" no pertenece al rango de enteros de 0 a 99999");
        } 
//        miNumero.close();
    }
    
    static void farmacia(){
    double compra;
    String tipoPago;
    double precioFinal;
    double descuento;
    double recargo;
    
    Scanner input=new Scanner(System.in);
    //El precio de la compra si es decimal deberá escribirse con comas, por ejemplo, 23,3 y nunca 23.3
    System.out.println("Introduce el precio total de la compra(€): ");
    compra=input.nextDouble();
    input.nextLine();
   
    System.out.println("Introduce el tipo de pago ('contado' o 'tarjeta'): ");
    tipoPago=input.nextLine();
    
    switch(tipoPago){
        case "contado":
            precioFinal=compra-(compra*0.05);
            descuento=-compra*0.05;
            System.out.println("Ha pagado al contado por lo que se aplica un descuento del 5%.");
            System.out.println("Compra(€): "+compra);
            System.out.println("Descuento(€):"+descuento);
            System.out.println("Total a pagar(€): "+precioFinal);
            break;
        case "tarjeta":
           precioFinal=compra+(compra*0.10);
            recargo=compra*0.10;
            System.out.println("Ha pagado con tarjeta por lo que se aplica un recargo del 10%.");
            System.out.println("Compra(€): "+compra);
            System.out.println("Descuento(€):"+recargo);
            System.out.println("Total a pagar(€): "+precioFinal); 
            break;
        default:
            System.out.println("Ha introducido mal el tipo de pago");
    }
//    input.close();
    }

    static void cajero_automatico(){
    double saldo=400;
    int operacion;
    double ingreso;
    double retirada;
    
    
    System.out.println("Elije el número de la operación: \n 1:Igresar \n 2:Retirar \n 3:Salir");
    Scanner input1=new Scanner (System.in);
    operacion=input1.nextInt();
    //Tanto el dinero a ingresar como el dinero a retirar deberán escribirse con coma en caso de ser 
    //decimal: 300,70 y no 300.70
    switch (operacion){
        case 1:
            System.out.println("Indique la cantidad a ingresar e ingrésela: ");
            ingreso=input1.nextDouble();
            input1.nextLine();
            saldo=saldo+ingreso;
            System.out.println("Tras su ingreso su saldo actual es de "+saldo+"€");
            break;
        case 2:
            System.out.println("Indique la cantidad a retirar: ");
            retirada=input1.nextDouble();
            input1.nextLine();
            if (retirada>saldo){
                System.out.println("Su saldo actual es de "+saldo+"€. \n La cantidad solicidad es superior al saldo disponible. \n No es posible realizar la operación");
            }else{
                saldo=saldo-retirada;
                System.out.println("Tras esta operación su saldo actual es de "+saldo+"€");
            }
            break;
        case 3:
            System.out.println("Gracias por usar nuestros servicios");
            break;
        default:
            System.out.println("Número de operación incorrecto");
            break;
    }
    
    }
    
    public static void main(String[] args) {
        //Para que no se ejecuten todas las instrucciones una 
        //a continuación de otra se pueden poner como comentario 
        //las que no interesa que se muestren.
        par_o_impar();
        ano_bisiesto();
        usuario_contrasena();
        tres_numeros();
        cifras_numero();
        farmacia();
        cajero_automatico();
   
    }
    
}
