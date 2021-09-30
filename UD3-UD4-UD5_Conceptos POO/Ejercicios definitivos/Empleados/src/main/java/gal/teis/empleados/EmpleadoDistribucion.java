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
public class EmpleadoDistribucion extends Asalariado {

    private String region;
    

    public EmpleadoDistribucion(String nombre, String nif, int diasVacaciones, double salarioBase, String region){
        super(nombre,nif,diasVacaciones,salarioBase);
        this.region=region;
    }
    
    public String getRegion(){
    return region;
    }
    
    public void setRegion(String region){
    this.region = region;
    }
    
    @Override
    public double getSalario(){
    return super.getSalario()*(1.10);
    }
    
    
}
