/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.empleados;

/**
 *
 * @author Estefania
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //polimorfismo();
        //sin_polimorfismo();
        polimorfismo_Arrays();
        //polimorfismo_Parametros();
    }


    /* 1. polimorfismo()
        Utilizando variables de instancia tipo Asalariado, crear un
        objeto de cada clase hija y mostrar sus datos por pantalla
     */
    public static void polimorfismo() {

        System.out.println("1. polimorfismo");

        Asalariado emp1 = new EmpleadoProduccion("pedro", "111", 35, 1000, "noche");
        Asalariado emp2 = new EmpleadoDistribucion("juan", "222", 30, 1000, "Pontevedra");

        System.out.println("Empleado producción");
        System.out.println("Nombre: " + emp1.getNombre());
        System.out.println("Nif: " + emp1.getNif());
        System.out.println("Días de vacaciones: " + emp1.getDiasVacaciones());
        System.out.println("Salario: " + emp1.getSalario());
        System.out.println("");
        System.out.println("Empleado distribusción");
        System.out.println("Nombre: " + emp2.getNombre());
        System.out.println("Nif: " + emp2.getNif());
        System.out.println("Días de vacaciones: " + emp2.getDiasVacaciones());
        System.out.println("Salario: " + emp2.getSalario());
        System.out.println("");

        //No puedo acceder a los métodos getTurno ni getRegion por haber creado los objetos hijos desde Asalariado
        //y estos son métdodos de las clases hijas exclusivamente. Por otro lado, accede a los metodos getSalario (con los valores de las clases hijas) 
        //de las clases hijas, porque este estaba en Asalariado y está reescrito en cada una de las clases hija.
    }

    /*2.sin_polimorfismo():
        Crear un objeto de cada clase (la clase de la parte estática y de
        la parte dinámina deben ser el mismo) y mostrar sus datos por pantalla.
     */
    public static void sin_polimorfismo() {

        System.out.println("2.sin_polimorfismo");

        Asalariado emp00 = new Asalariado("antonio", "000", 29, 1000);
        EmpleadoProduccion emp11 = new EmpleadoProduccion("pedro", "111", 35, 1000, "noche");
        EmpleadoDistribucion emp22 = new EmpleadoDistribucion("juan", "222", 30, 1000, "Pontevedra");

        System.out.println("Asalariado");
        System.out.println("Nombre: " + emp00.getNombre());
        System.out.println("Nif: " + emp00.getNif());
        System.out.println("Días de vacaciones: " + emp00.getDiasVacaciones());
        System.out.println("Salario: " + emp00.getSalario());
        System.out.println("");
        System.out.println("Empleado producción");
        System.out.println("Nombre: " + emp11.getNombre());
        System.out.println("Nif: " + emp11.getNif());
        System.out.println("Días de vacaciones: " + emp11.getDiasVacaciones());
        System.out.println("Salario: " + emp11.getSalario());
        System.out.println("Turno: " + emp11.getTurno());
        System.out.println("");
        System.out.println("Empleado distribusción");
        System.out.println("Nombre: " + emp22.getNombre());
        System.out.println("Nif: " + emp22.getNif());
        System.out.println("Días de vacaciones: " + emp22.getDiasVacaciones());
        System.out.println("Salario: " + emp22.getSalario());
        System.out.println("Región: " + emp22.getRegion());
        System.out.println("");

        //Todos lo métodos son accesibles y el método getSalario está sobreescrito
    }

    /* 3. polimorfismo_Arrays()
        Crear un objeto de cada clase
        Crear un array de la superclase
        Almacenar los objetos creados del array
        Recorrer el array y mostrar la información alamcenada en cada objeto
     */
    public static void polimorfismo_Arrays() {

        System.out.println("3. polimorfismo_Arrays");

        Asalariado emp000 = new Asalariado("antonio", "000", 29, 1000);
        EmpleadoProduccion emp111 = new EmpleadoProduccion("pedro", "111", 35, 1000, "noche");
        EmpleadoDistribucion emp222 = new EmpleadoDistribucion("juan", "222", 30, 1000, "Pontevedra");

        //Implemento el polimorfismo el array al crear un array Asalariado donde meteré objetos de su subclases
        Asalariado[] emp = {emp000, emp111, emp222};
        for (int i = 0; i < emp.length; i++) {
            System.out.println("Nombre: " + emp[i].getNombre());
            System.out.println("Nif: " + emp[i].getNif());
            System.out.println("Días de vacaciones: " + emp[i].getDiasVacaciones());
            System.out.println("Salario: " + emp[i].getSalario());
            if (emp[i] instanceof EmpleadoProduccion) {
                EmpleadoProduccion empP = (EmpleadoProduccion) emp[i];
                System.out.println("Turno: " + empP.getTurno());
            } else if (emp[i] instanceof EmpleadoDistribucion) {
                EmpleadoDistribucion empD = (EmpleadoDistribucion) emp[i];
                System.out.println("Región: " + empD.getRegion());
            }
            System.out.println("");
        }

        //Como los métodos getRegion y getTurno no tienen implementación
        //no se pueden meter en el array*. Y el método getSalario devuelve
        //los valores sobreescritos en los objetos emp111 y emp222
        //*Para poder acceder a estos métodos hay que hacer un castingcon con instanceof.
    }

    /* 4. polimorfismo_Parametros()
        Crear un objeto de cada clase sin usar polimorfismo
        Utilizar cada uno de los objetos creados como parámetro en un método llamado
        mostrarSalario() que muestre el salario de cada trabajador. La firma del métdodo es
        public static void mostrarSalario(Asalariado asl)
     */
    public static void polimorfismo_Parametros() {

        System.out.println("4. polimorfismo_Parámetros");

        Asalariado emp0000 = new Asalariado("antonio", "000", 29, 1000);
        EmpleadoProduccion emp1111 = new EmpleadoProduccion("pedro", "111", 35, 1000, "noche");
        EmpleadoDistribucion emp2222 = new EmpleadoDistribucion("juan", "222", 30, 1000, "Pontevedra");

        mostrarSalario(emp0000);
        mostrarSalario(emp1111);
        mostrarSalario(emp2222);
        //Emplea los métodos getSalario sobreescritos en emp1111 y emp2222.
    }

    public static void mostrarSalario(Asalariado asl) {
        System.out.println("El salario de " + asl.getNombre() + " es " + asl.getSalario());
    }

}
