package gal.teis.automovil;

import gal.teis.componentes.Chasis;
import gal.teis.componentes.Llanta;
import gal.teis.componentes.Motor;

public class Vehiculo {
    private float precio;
    private String color;
    private String fabricante;
    private Llanta neumatico;
    private Chasis armazon;
    private Motor maquina;

    public Vehiculo() {
    }

    public Vehiculo(float precio, String color, String fabricante, Llanta neumatico, Chasis armazon, Motor maquina) {
        this.precio = precio;
        this.color = color;
        this.fabricante = fabricante;
        this.neumatico = neumatico;
        this.armazon = armazon;
        this.maquina = maquina;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public void encender(){
        System.out.println("Encendiendo auto......");
    }
    
    public void apagar(){
        System.out.println("Apagando auto..");
    }

    public Llanta getNeumatico() {
        return neumatico;
    }

    public void setNeumatico(Llanta neumatico) {
        this.neumatico = neumatico;
    }

    public Chasis getArmazon() {
        return armazon;
    }

    public void setArmazon(Chasis armazon) {
        this.armazon = armazon;
    }

    public Motor getMaquina() {
        return maquina;
    }

    public void setMaquina(Motor maquina) {
        this.maquina = maquina;
    }
    
}
