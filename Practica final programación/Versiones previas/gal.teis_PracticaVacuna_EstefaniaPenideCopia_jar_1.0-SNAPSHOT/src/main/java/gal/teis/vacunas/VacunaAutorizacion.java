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
    private boolean fase1Superada;
    private boolean fase2Superada;
    private boolean fase3Superada;

    private byte fasesCompletadas;

    private LocalDate fechaResultado;

    private boolean autorizada;
    private boolean rechazada;
    

    public void setFase1Superada(boolean fase1Superada) {
        this.fase1Superada = fase1Superada;
        //Pongo el número concreto que le corresponde en lugar de ++ ya que eso 
        //generaría números erroneos si se mete primero false y luego se volviera a 
        //probar y se metiera true (ya estaríamos en 2, en lugar de 1)
        fasesCompletadas = 1;
    }

    public void setFase2Superada(boolean fase2Superada) {
        //Arroja excepción si no se ha superado la fase1. No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
        try {
            if (!fase1Superada) {
                throw new FaseAnteriorNoSuperadaException(1, 2);
            }
            this.fase2Superada = fase2Superada;
            fasesCompletadas = 2;
        } catch (FaseAnteriorNoSuperadaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setFase3Superada(boolean fase3Superada) {
        //Arroja excepción si no se han superado la fase 2
        //(la fase 1 ya está controlada en el anterior).No deja que
        //llegue a modificar ni this.fase3Superada, ni fasesCompletadas
        try {
            if (!fase2Superada) {
                throw new FaseAnteriorNoSuperadaException(2, 3);
            }
            this.fase3Superada = fase3Superada;
            fasesCompletadas = 3;
        } catch (FaseAnteriorNoSuperadaException e) {
            System.out.println(e.getMessage());
        }
    }

    //borrar los métodos getFaseSuperada, solo los he usado para comprobar cosas
    public boolean getFase1Superada() {
        return fase1Superada;
    }

    public boolean getFase2Superada() {
        return fase2Superada;
    }

    public boolean getFase3Superada() {
        return fase3Superada;
    }

    public String ultimaFaseImplementada() {
        String implementacion = "";
        switch (fasesCompletadas) {
            case 0:
                implementacion = "No se ha implementado ninguna fase";
                break;
            case 1:
                if (!fase1Superada) {
                    implementacion = "Última fase implenetada = Fase 1\n"
                            + "Resultado: No superada";
                } else if (fase1Superada) {
                    implementacion = "Última fase implenetada = Fase 1\n"
                            + "Resultado: Superada";
                }
                break;
            case 2:
                if (!fase2Superada) {
                    implementacion = "Última fase implenetada = Fase 2\n"
                            + "Resultado: No superada";
                } else if (fase2Superada) {
                    implementacion = "Última fase implenetada = Fase 2\n"
                            + "Resultado: Superada";
                }
                break;
            case 3:
                if (!fase3Superada) {
                    implementacion = "Última fase implenetada = Fase 3\n"
                            + "Resultado: No superada";
                } else if (fase3Superada) {
                    implementacion = "Última fase implenetada = Fase 3\n"
                            + "Resultado: Superada";
                }
                break;
            default:
                break;
        }
        return implementacion;
    }

    public LocalDate getFechaResultado() {
        return fechaResultado;
    }

    //métodos para ver si una vacuna ha sido autorizada o no
    public boolean comprobacionVacunaAutorizada() {
        boolean mensaje;
        if (autorizada) {
            mensaje = true;
        } else {
            mensaje = false;
        }
        return mensaje;
    }

    public boolean comprobacionVacunaRechazada() {
        boolean mensaje;
        if (rechazada) {
            mensaje = true;
        } else {
            mensaje = false;
        }
        return mensaje;
    }

    //métodos que indican si una vez hechas las pruebas y llegados al final del testeo,,han superado las fases o no.
    private boolean vacunaValida() {
        boolean valida = false;
        if (this.fase1Superada && this.fase2Superada && this.fase3Superada && fasesCompletadas == 3) {
            valida = true;
        }
        return valida;
    }

    private boolean vacunaNoValida() {
        boolean noValida = false;
        if ((!this.fase1Superada && fasesCompletadas == 1) || (!this.fase2Superada && fasesCompletadas == 2) || (!this.fase3Superada && fasesCompletadas == 3)) {
            noValida = true;
        }
        return noValida;
    }

//implematación de los métodos de la interfaz IAutorizable

    @Override
    public boolean autorizar() {
        if (vacunaValida()) {
            fechaResultado = LocalDate.now();
            autorizada = true;
            //Añado la modificación del atributo rechazada aquí para que en caso de cambiar de crietrio
            //se pueda poner como rechaza una vacuna que previamente fue autorizada sin que suponga mucho lio en la
            //aplicacion de los métodos
            rechazada = false;
        }
        return autorizada;
    }


    @Override
    public boolean rechazar() {

        fechaResultado = LocalDate.now();
        rechazada = true;
        //Añado la modificación del atributo autorizada aquí para que en caso de cambiar de crietrio
        //se pueda poner como autorizada una vacuna que previamente fue rechazada sin que suponga mucho lio en la
        //aplicacion de los métodos
        autorizada = false;

        return rechazada;
    }

}
