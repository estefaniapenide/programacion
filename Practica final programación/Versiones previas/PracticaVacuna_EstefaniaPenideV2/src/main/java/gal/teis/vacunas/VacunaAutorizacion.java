/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.time.LocalDate;

/**
 *
 * @author a20estefaniapc
 */
public abstract class VacunaAutorizacion implements IAutorizable {

    //atributos
    private boolean[] faseSuperada = {false, false, false};
    private boolean fase1Superada;
    private boolean fase2Superada;
    private boolean fase3Superada;

    private byte fasesCompletadas;

    private LocalDate fechaResultado;

    private boolean autorizada;
    private boolean rechazada;

    public void setFase1Superada(boolean fase1Superada) {
        this.faseSuperada[0] = fase1Superada;
        //Pongo el número concreto que le corresponde en lugar de ++ ya que eso generaría números erroneos si se mete primero false y luego se volviera a probar y se metiera true (ya estaríamos en 2, en lugar de 1)
        fasesCompletadas = 1;
    }

    public void setFase2Superada(boolean fase2Superada) {
        //Arroja excepción si no se ha superado la fase1. No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
        try {
            if (!faseSuperada[0]) {
                throw new FaseAnteriorNoSuperadaException(1, 2);
            }
            this.faseSuperada[1] = fase2Superada;
            fasesCompletadas = 2;
        } catch (FaseAnteriorNoSuperadaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setFase3Superada(boolean fase3Superada) {
        //Arroja excepción si no se han superado la fase 2(la fase 1 ya está controlada en el anterior).No deja que
        //llegue a modificar ni this.fase3Superada, ni fasesCompletadas
        try {
            if (!faseSuperada[1]) {
                throw new FaseAnteriorNoSuperadaException(2, 3);
            }
            this.faseSuperada[2] = fase3Superada;
            fasesCompletadas = 3;
        } catch (FaseAnteriorNoSuperadaException e) {
            System.out.println(e.getMessage());
        }
    }

    //borras los métodos getFaseSuperada, solo los he usado para comprobar cosas
    public boolean getFase1Superada() {
        return faseSuperada[0];
    }

    public boolean getFase2Superada() {
        return faseSuperada[1];
    }

    public boolean getFase3Superada() {
        return faseSuperada[2];
    }

    public LocalDate getFechaResultado() {
        return fechaResultado;
    }

    private void setFechaResultado(LocalDate fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    public String ultimaFaseImplementada() {
        String implementacion = "";
        for(int i=0; i<faseSuperada.length; i++){
        if(faseSuperada[i])
        }

        return implementacion;
    }

    //métodos para ver si una vacuna ha sido autorizada o no
    public String verAutorizacion() {
        this.autorizar();
        String mensaje;
        if (autorizada) {
            mensaje = "AUTORIZADA";
        } else {
            mensaje = "NO AUTORIZADA";
        }
        return mensaje;
    }

    public String verRechazada() {
        this.rechazar();
        String mensaje;
        if (rechazada) {
            mensaje = "RECHAZADA";
        } else {
            mensaje = "NO RECHAZADA";
        }
        return mensaje;
    }

//implematación de los métodos de la interfaz IAutorizable
    
//    @Override
//public boolean autorizar(boolean autorizada){
//        if(this.faseSuperada[0] && this.faseSuperada[1] && this.faseSuperada[3] && fasesCompletadas==3){
//        autorizada=true;
//        setFechaResultado(LocalDate.now());
//        this.autorizada=autorizada;
//        }
//        return this.autorizada;
//    }
//
//@Override
//    public boolean rechazar(boolean rechazada) {
//        if ((!this.faseSuperada[0] && fasesCompletadas == 1) || (!this.faseSuperada[1] && fasesCompletadas == 2) || (!this.faseSuperada[2] && fasesCompletadas == 3)) {
//            rechazada = true;
//            setFechaResultado(LocalDate.now());
//            this.rechazada=rechazada;
//        }
//        return this.rechazada;
//    }
    
    @Override
    public boolean autorizar() {
        if (this.faseSuperada[0] && this.faseSuperada[1] && this.faseSuperada[2] && fasesCompletadas == 3) {
            setFechaResultado(LocalDate.now());
            autorizada = true;
        }
        return autorizada;
    }

    @Override
    public boolean rechazar() {
        if ((!this.faseSuperada[0] && fasesCompletadas == 1) || (!this.faseSuperada[1] && fasesCompletadas == 2) || (!this.faseSuperada[2] && fasesCompletadas == 3)) {
            setFechaResultado(LocalDate.now());
            rechazada = true;
        }
        return rechazada;
    }

}
