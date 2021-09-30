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
public class EmpleadoDistribucion extends Asalariado {

    private String region;

    public EmpleadoDistribucion(String nombre, String nif, int diasVacaciones, double salarioBase, String region) {
        super(nombre, nif, diasVacaciones, salarioBase);
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String nueva_region) {
        this.region = nueva_region;
    }

    public double getSalario() {
        return super.getSalario() * (1.10);
    }

}
