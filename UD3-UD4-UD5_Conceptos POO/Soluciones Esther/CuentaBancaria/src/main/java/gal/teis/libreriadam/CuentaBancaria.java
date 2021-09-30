/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.libreriadam;

/**
 *
 * @author Esther Ferreiro
 * Clase para la gestión de cuentas bancarias
 * Uso de propiedad estática/variale de clase
 * Solo hay getTotalCuentas() no hay setTotalCuentas()
 */
public class CuentaBancaria {

    // Atributos o variables miembro
    private String titular;
    private String nCuenta;
    private double tipoInteres;
    private double saldo;
    private double comision;

    
    /**
     * Crea una instancia de la clase incrementando a la vez el total de cuentas
     * creadas a partir de esta clase
     **/
    public CuentaBancaria() {//Acceso de constructor a propiedad estática

    }

    /**
     * Crea una instancia de la clase incrementando a la vez el total de cuentas
     * creadas a partir de esta clase
     **/
    public CuentaBancaria(String nombre, String nCuenta, double saldo){//Acceso de constructor a propiedad estática
        this.titular = nombre;
        this.nCuenta = nCuenta;
        this.saldo = saldo;
      
    }


       public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Para el nivel = 1 permite modidificar el nº de cuenta
     * 
     * @param nCuenta String Número de cuenta
     * @param nivel Byte nivel de acceso
    **/
    public void setNumeroCuenta(String nCuenta, Byte nivel) {
        if (nivel == 1) {
            this.nCuenta = nCuenta;
        }
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    public void setComision(double comision) {
        this.comision = comision;
    }
    /*No existe setTotalCuentas porque no quiero que ese
    valor se pueda modificar por medio de un método. 
    Solo se modifica en los constructores*/

    public String getTitular() {
        return titular;
    }

    public String getNCuenta() {
        return nCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getComision() {
        return comision;
    }

    
    
    
    /**
     * Permite ingresar dinero en la cuenta
     * @param dineroIngresar double cantidad a incrementar el saldo
     * @return boolean indica si se ha podido realizar el ingreso
     * */
    public boolean hacerIngreso(double dineroIngresar) {
        boolean ingresoCorrecto = true;
        if (dineroIngresar < 0) {
            ingresoCorrecto = false;
        } else {
            saldo = saldo + dineroIngresar;
        }
        return ingresoCorrecto;
    }

    /**
     * Permite sacar dinero de la cuenta
     * @param dineroReintegro double cantidad a retirar del saldo
     * @return boolean indica si se ha podido realizar el reintegro
     * */
    public boolean hacerReintegro(double dineroReintegro) {
        boolean reintegroCorrecto = true;
        if (dineroReintegro < 0) {
            reintegroCorrecto = false;
        } else if (saldo >= dineroReintegro) {
            saldo -= dineroReintegro;
        } else {
            reintegroCorrecto = false;
        }
        return reintegroCorrecto;
    }
    /**
    * Muestra los datos de un objeto como un String
    * @return String Cadena con los datos del objeto
    **/
    public String cuentaComoString(){
        return "La titular de la cuenta es " + getTitular()+
                "\nEl número de la cuenta es " + getNCuenta()+
                "\nEl saldo es "+getSaldo();
    }
}
