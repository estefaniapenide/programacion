/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.ExcepcionesyControlTipos.VacunaYaEvaluadaException;
import gal.teis.ExcepcionesyControlTipos.FaseAnteriorNoSuperadaException;
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

    public void setFase2Superada(boolean fase2Superada)throws FaseAnteriorNoSuperadaException {
        //Arroja excepción si no se ha superado la fase1. No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
            if (!fase1Superada) {
                throw new FaseAnteriorNoSuperadaException(1, 2);
            }else{
            this.fase2Superada = fase2Superada;
            fasesCompletadas = 2;
        } 
    }

    public void setFase3Superada(boolean fase3Superada)throws FaseAnteriorNoSuperadaException{
        //Arroja excepción si no se han superado la fase 2
        //(la fase 1 ya está controlada en el anterior).No deja que
        //llegue a modificar ni this.fase3Superada, ni fasesCompletadas
            if (!fase2Superada) {
                throw new FaseAnteriorNoSuperadaException(2, 3);
            }else{
            this.fase3Superada = fase3Superada;
            fasesCompletadas = 3;
        } 
    }

    public String ultimaFaseImplementada() {
        String implementacion = "";
        switch (fasesCompletadas) {
            case 0:
                implementacion = "No se ha investigado ninguna fase";
                break;
            case 1:
                if (!fase1Superada) {
                    implementacion = "Última fase investigada = Fase 1\n"
                            + "Resultado: No superada";
                } else if (fase1Superada) {
                    implementacion = "Última fase investigada = Fase 1\n"
                            + "Resultado: Superada";
                }
                break;
            case 2:
                if (!fase2Superada) {
                    implementacion = "Última fase investigada = Fase 2\n"
                            + "Resultado: No superada";
                } else if (fase2Superada) {
                    implementacion = "Última fase investigada = Fase 2\n"
                            + "Resultado: Superada";
                }
                break;
            case 3:
                if (!fase3Superada) {
                    implementacion = "Última fase investigada = Fase 3\n"
                            + "Resultado: No superada";
                } else if (fase3Superada) {
                    implementacion = "Última fase investigada = Fase 3\n"
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
        return autorizada;
    }

    public boolean comprobacionVacunaRechazada() {
       return rechazada;
    }

//métodos que indican si una vez hechas las pruebas y llegados al final del testeo,han superado las fases o no.
    private boolean vacunaValida() {
        boolean valida = false;
        if (this.fase1Superada && this.fase2Superada && this.fase3Superada && fasesCompletadas == 3) {
            valida = true;
        }
        return valida;
    }

    //Este método se definió en caso de que el criterio para poder rechazar una vacuna fuera que esta hubiera llegado al final del testeo, es decir,
    //que para ser rechaza tuviera que ser válida (habiendo superado todas las fases), o no válida (no habiendo superado todas las fases pero considerando
    //que su investiagación había llegado a su fin por no superar alguna de las fases). 
    //No se ha implementado debido a los criterios definidos en clase.
    private boolean vacunaNoValida() {
        boolean noValida = false;
        if ((!this.fase1Superada && fasesCompletadas == 1) || (!this.fase2Superada && fasesCompletadas == 2) || (!this.fase3Superada && fasesCompletadas == 3)) {
            noValida = true;
        }
        return noValida;
    }

//implematación de los métodos de la interfaz IAutorizable
    @Override
    public boolean autorizar() throws VacunaYaEvaluadaException {

        if (comprobacionVacunaRechazada()) {
            //Arrojo una excepción en caso de que la vacuna ya fuera rechazada,
            //para evitar que se pueda autorizar.
            throw new VacunaYaEvaluadaException();
        } else if (vacunaValida()) {
            fechaResultado = LocalDate.now();
            autorizada = true;
        }
        return autorizada;
    }

    @Override
    public boolean rechazar() throws VacunaYaEvaluadaException {
        if (comprobacionVacunaAutorizada()) {
            //Arrojo una excepción en caso de que la vacuna ya fuera autorizada,
            //para evitar que se pueda rechazar.
            throw new VacunaYaEvaluadaException();
        } else {
            fechaResultado = LocalDate.now();
            rechazada = true;
        }
        return rechazada;
    }

}
