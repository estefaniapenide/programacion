/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.clinicaveterinaria;

/**
 *
 * @author a20estefaniapc
 */
public final class Historial {

    //atributos
    private String fecha;
    private String sintomas;
    private String diagnostico;
    private String receta;

    //cosntructores
    public Historial() {
    }

    public Historial(String fecha, String sintomas, String diagnostico, String receta) {
        this.fecha = fecha;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    //getetrs y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
    
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
    
    @Override
    public String toString(){
    return "\n\t Fecha: "+fecha+"\n"+
            "\t Síntomas: "+sintomas+"\n"+
            "\t Diagnóstico: "+diagnostico+"\n"+
            "\t Receta: "+receta;
    }

}
