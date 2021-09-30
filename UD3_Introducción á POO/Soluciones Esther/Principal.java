/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.pgr.ud3.polimorfismo_1;

/**
 *
 * @author Esther Ferreiro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sin_polimorfismo();
        polimorfismo();

    }
    
    /*
    Sin polimorfismo, se crea un ojeto de cada clase. Solo se usan las propiedades 
    clásica de la herencia
    */
    public static void sin_polimorfismo() {
        
        //Objetos y llamadas a métodos sin usar polimorfismo
        Asalariado emplead1 = new Asalariado("Manuel Cortina", "12345678W", 28, 1200);
        EmpleadoProduccion emplead2 = new EmpleadoProduccion("Juan Mota", "55333222L", 30, 1200, "noche");
        EmpleadoDistribucion emplead3 = new EmpleadoDistribucion("Antonio Camino", "55333666P", 35, 1200, "Granada");
        
        System.out.println("El nombre	del	emplead1	es	"
                + emplead1.getNombre());
        System.out.println("El	sueldo	del	emplead1	es	"
                + emplead1.getSalario());
        System.out.println("El	nombre	del	emplead2	es	"
                + emplead2.getNombre());
        System.out.println("El	turno	del	emplead2	es	"
                + emplead2.getTurno());
        System.out.println("El	sueldo	del	emplead2	es	"
                + emplead2.getSalario());
        System.out.println("El	nombre	del	emplead3	es	"
                + emplead3.getNombre());
        System.out.println("La	region	del	emplead3	es	"
                + emplead3.getRegion());
        System.out.println("El	sueldo	del	emplead3	es	"
                + emplead3.getSalario());
    }

    /**
     * Uso de polimorfismo básico
     * Cada instancia llama métodos override propios y métodos heredados de Asalariado
     */
    public static void polimorfismo() {
        Asalariado emplead0 = new Asalariado("Manuel Cortina", "12345678W", 28, 1500);
        Asalariado emplead1 = new EmpleadoDistribucion("Manuel Cortina", "12345678W", 28, 1700, "norte");
        Asalariado emplead2 = new EmpleadoProduccion("Juan Mota", "55333222L", 30, 1800, "noche");

   
                
        
        /*Cada instancia llama a los métodos de Asalariado (superclase) y a los
        métodos de la subclase que son overriding
        */
        System.out.println("El nombre del empleado 1 es "
                + emplead1.getNombre());//getNombre() está definido en Asalariado (superclase)
        System.out.println("El sueldo del empleado 1 es "
                + emplead1.getSalario());//getSalario() está override en EmpleadoDistribucion (subclase)
        System.out.println("El nombre del empleado 2 es "
                + emplead2.getNombre());//getNombre() está definido en Asalariado (superclase)
        System.out.println("El sueldo del empleado 2 es "
                + emplead2.getSalario());//getSalario() está override en EmpleadoProduccion (subclase)
        
        //Indica por qué la siguiente instrucción es errónea
//        System.out.println("El turno del empleado 2 es " 
//                +emplead2.getTurno);
    }

   

      /**
     * Polimorfismo/Arrays. Si el tipo del array es una superclase, 
     * se pueden almacenar elementos de las clases derivadas aplicando el polimorfismo
     */
     public static void polimorfismo_Arrays() {
         
        }

        /*
        No se puede llamar a getRegion ni a getTurno() porque no está definido en Asalariado que
        es la superclase que determina los método que pueden ser llamados por polimorfismo
         */
        //System.out.println("La region	del emplead3 es"+ array_asal[2].getRegion() );
         //System.out.println("El turno del emplead3 es"+ array_asal[1].getTurno() );
    }

    /**
     * Polimorfismo en los parámetros de los métodos
     */
    public static void polimosfismo_Parametros() {
        

    }

    public static void mostrarSalario(Asalariado asl) {
        System.out.println("El	salario	del	trabajador	es	"
                + asl.getSalario());
        System.out.println("El resultado de aplicarle la retencion es "
                + asl.getSalario() * 0.15);

    }

}
