/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.excepciones_controldata.FaseAnteriorNoSuperadaException;
import gal.teis.excepciones_controldata.FaseYaInvestigadaException;
import gal.teis.excepciones_controldata.VacunaYaEvaluadaException;
import java.time.LocalDate;

/**
 * Para evaluar las fases de las vacunas y gestionar la posiblidad de autorizar
 * o rechazar cada una de ellas.
 *
 * @author Estefania
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
    

//getter FechaReultado
    /**
     * Recoge la fecha en que la vacuna ha sido rechazada o autorizada.
     *
     * @return fechaResultado
     */
    public LocalDate getFechaResultado() {
        return fechaResultado;
    }

//setters las fases
    /**
     * Modifica el valor de fase1Superada e iguala fasesCompletadas a 1.
     *
     * @param fase1Superada
     */
    public void setFase1Superada(boolean fase1Superada) throws FaseYaInvestigadaException {
        //Arroja excepción siempre que ya haya sido investigada.No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
        if (fasesCompletadas > 0) {
            throw new FaseYaInvestigadaException(1);
        }
        this.fase1Superada = fase1Superada;
        fasesCompletadas++;
    }

    /**
     * Modifica el valor de fase2Superada e iguala fasesCompletadas a 2.
     *
     * @param fase2Superada
     * @throws FaseAnteriorNoSuperadaException (cuando no ha superado la fase 1
     * no es posible modificar la 2).
     */
    public void setFase2Superada(boolean fase2Superada) throws FaseAnteriorNoSuperadaException, FaseYaInvestigadaException {
        //Arroja excepción si no se ha superado la fase1. No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
        if (!fase1Superada) {
            throw new FaseAnteriorNoSuperadaException(1, 2);
        //Arroja excepción siempre que ya haya sido investigada. No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
        } else if (fasesCompletadas > 1) {
            throw new FaseYaInvestigadaException(2);
        } else {
            this.fase2Superada = fase2Superada;
            fasesCompletadas++;
        }
    }

    /**
     * Modifica el valor de fase3Superada e iguala fasesCompletadas a 3.
     *
     * @param fase3Superada
     * @throws FaseAnteriorNoSuperadaException (cuando no ha superado la fase 2
     * no es posible modificar la 3).
     */
    public void setFase3Superada(boolean fase3Superada) throws FaseAnteriorNoSuperadaException, FaseYaInvestigadaException {
        //Arroja excepción si no se han superado la fase 2
        //(la fase 1 ya está controlada en el anterior).No deja que
        //llegue a modificar ni this.fase3Superada, ni fasesCompletadas
        if (!fase2Superada) {
            throw new FaseAnteriorNoSuperadaException(2, 3);
        //Arroja excepción siempre que ya haya sido investigada. No deja que
        //llegue a modificar ni this.fase2Superada, ni fasesCompletadas
        } else if (fasesCompletadas > 2) {
            throw new FaseYaInvestigadaException(3);
        } else {
            this.fase3Superada = fase3Superada;
            fasesCompletadas++;
        }

    }
    
    /**
     * Devuelva el resultado de la investigación de la útima fase que se ha
     * implementado con la vacuna.
     *
     * @return ultima fase implementada y su resultado
     */
    public String ultimaFaseImplementada() {
        String implementacion = "";
        //La última fase implementada es la que es igual a fasesCompletadas, por lo que una vez conocida esta, solo hay que comprobar
        //el estado de la fase correspondiente a ese valor.
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

//métodos para ver si una vacuna ha sido autorizada o no
    /**
     * Método para ver si una vacuna ha sido autorizada o no.
     *
     * @return autorizada (Si autorizada=true, ha sido autorizada).
     */
    public boolean comprobacionVacunaAutorizada() {
        return autorizada;
    }
    
    /**
     * Método para ver si una vacuna ha sido rechazada o no.
     *
     * @return rechazada (Si rechazada=true, ha sido rechazada).
     */
    public boolean comprobacionVacunaRechazada() {
        return rechazada;
    }

//métodos que indican si una vez hechas las pruebas y llegados al final del testeo,han superado las fases o no.
    /**
     * Para saber si una vacuna ha pasado por todas las fases y las ha superado.
     *
     * @return valida(Si valida=true, la vacuna ha sido evaluada y ha superado
     * todas las pruebas).
     */
    private boolean vacunaValida() {
        boolean valida = false;
        if (this.fase1Superada && this.fase2Superada && this.fase3Superada && fasesCompletadas == 3) {
            valida = true;
        }
        return valida;
    }

    /**
     * Para saber si una vacuna ha pasado por alguna fase que no ha superado.
     *
     * @return noValida(Si noValida=true, la vacuna ha sido evaluada y no ha
     * superado alguna prueba).
     */
    private boolean vacunaNoValida() {
        //Este método se definió en caso de que el criterio para poder rechazar una vacuna fuera que esta hubiera llegado al final del testeo, es decir,
        //que para ser rechaza tuviera que ser válida (habiendo superado todas las fases), o no válida (no habiendo superado todas las fases pero considerando
        //que su investiagación había llegado a su fin por no superar alguna de las fases). 
        //No se ha implementado debido a los criterios definidos en clase.
        boolean noValida = false;
        if ((!this.fase1Superada && fasesCompletadas == 1) || (!this.fase2Superada && fasesCompletadas == 2) || (!this.fase3Superada && fasesCompletadas == 3)) {
            noValida = true;
        }
        return noValida;
    }

//métodos sobreescritos de la interfaz IAutorizable
    /**
     * Hace que una vacuna esté autorizada para su uso.
     *
     * @return boolean que indica si la operación ha sido realizada o no.
     * @throws VacunaYaEvaluadaException
     */
    @Override
    public boolean autorizar() throws VacunaYaEvaluadaException {

        if (rechazada) {
            //Arrojo una excepción en caso de que la vacuna ya fuera rechazada,
            //para evitar que se pueda autorizar.
            throw new VacunaYaEvaluadaException();
        } else if (vacunaValida()) {
            fechaResultado = LocalDate.now();
            autorizada = true;
        }
        return autorizada;
    }
    
    /**
     * Hace que una vacuna esté autorizada para su uso.
     *
     * @return boolean que indica si la operación ha sido realizada o no.
     * @throws VacunaYaEvaluadaException
     */
    @Override
    public boolean rechazar() throws VacunaYaEvaluadaException {
//Se sigue el criterio por el cual toda vacuna (fases evaluadas o no) es susceptible de ser rechazada.
        if (autorizada) {
            //Arrojo una excepción en caso de que la vacuna ya fuera autorizada,
            //para evitar que se pueda rechazar.
            throw new VacunaYaEvaluadaException();
            //En caso de querer aplicar el criterio para rechazar vacunas explicado con aterioridad (explicación en método vacunaNoValida())
            //se sustituiría el siguiente 'else' por 'else if(vacunaValida() || vacunaNoValida())'.
        } else {
            fechaResultado = LocalDate.now();
            rechazada = true;
        }
        return rechazada;
    }

}
