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
public class EmpleadoProduccion extends Asalariado {
    
private String turno;

    public EmpleadoProduccion(String nombre, String nif, int diasVacaciones, double salarioBase, String turno){
        super(nombre,nif,diasVacaciones,salarioBase);
        this.turno=turno;
    }
    
    public String getTurno(){
    return turno;
    }
    
    public void setTurno(String turno){
    this.turno = turno;
    }
    
    @Override
    public double getSalario(){
    return super.getSalario()*(1.15);
    }
  
}
