/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.examenprogramacion2a.estefaniapenide;

/**
 *
 * @author a20estefaniapc
 */
public class Empleado extends Trabajador {

    //atributos
    private double porcentajeIrpf;
    private static int contadorEmpleado;

    //constructores
    public Empleado(String nombre, int edad) {
        super(nombre, edad);
        contadorEmpleado++;
    }

    public Empleado(String nombre, int edad, int antiguedad) {
        super(nombre, edad, antiguedad);
        contadorEmpleado++;
    }

    public Empleado(String nombre, int edad, int antiguedad, double porcentajeIrpf) {
        super(nombre, edad, antiguedad);
        this.porcentajeIrpf = porcentajeIrpf;
        contadorEmpleado++;
    }

    //getters y setters
    public void setPorcentajeIrpf(double porcentajeIrpf) {
        this.porcentajeIrpf = porcentajeIrpf;

    }

    public double getPorcentajeIrpf() {
        return porcentajeIrpf;
    }

    public static int getContadorEmpleado() {
        return contadorEmpleado;
    }

    //métodos
    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + 350;
    }

    public double mostrarRetencion() {
        return this.calcularSueldo() * getPorcentajeIrpf() / 100;
    }

    public double mostrarSlarioLiquido() {
        return this.calcularSueldo() - mostrarRetencion();
    }

    @Override
    public String toString() {
        return super.toString()
                + "Retención: " + mostrarRetencion() + "\n"
                + "Salario Líquido: " + mostrarSlarioLiquido() + "\n";
    }

}
