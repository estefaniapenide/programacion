/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.paises3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */

/*Crear una clase Pais que permita almacenar atributos para
 *Nombre, Número de habitantes, Capital, Lenguas oficiales del país, Sistema de gobierno república o monarquía
 *Para crear un objeto Pais se debe poder hacer solo aportando el nombre aportando el nombre y la capital aportando el nombre, la capital y el sistema de gobierno
 * A la hora de implementar los constructores utilizar el método this cuando sea posible
 *Implementar métodos getter y setter para todos los atributos
 * Utilizar el objetos this
 */
public class Pais {

    //atributos
    private String nombre = "";
    private int habitantes;
    private String capital = "";
    private ArrayList<String> lengua = new ArrayList<String>();
    private Boolean gobierno;
    //republica: gobierno=true; 
    //monarquia gobierno=false;
    private String habt;
    private String mensaje;

    //constructores
    public Pais() {
    }

    public Pais(String nombre) {
        this.nombre = nombre;

    }

    public Pais(String nombre, String capital) {
        this.nombre = nombre;
        this.capital = capital;

    }

    public Pais(String nombre, String capital, Boolean gobierno) {
        this.nombre = nombre;
        this.capital = capital;
        this.gobierno = gobierno;

    }

    //setters y getters
    public String getNombre() {
        return nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public String getCapital() {
        return capital;
    }

    public ArrayList<String> getLengua() {
        return lengua;
    }

    public Boolean getGobierno() {
        return gobierno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setLengua(ArrayList<String> lengua) {
        this.lengua = lengua;
    }

    public void setGobierno(Boolean gobierno) {
        this.gobierno = gobierno;
    }

    public String[] caracteristicas() {
        /*Muestra toda la información que tiene almacenada de un pais concreto. 
        En el caso de que no tenga datos en alguna propiedad, muestra el valor 
        por defecto de esa variable
        Esta situació podría modificarse aportando, en los constructores, valores por defecto  
        de las propiedades que no tienen información*/

        //Para poder incorporar el int de habitantes al array de Strings, lo convierto en String en caso
        //de que sea un valor distinto de 0; en caso de ser 0 considero que no se ha proporcionado ningún valor
        //por lo que devolverá un String en blanco.
        if (habitantes == 0) {
            habt = "";
        } else {
            habt = Integer.toString(habitantes);
        }
        
        //Para poder usar los elementos del ArrayList de lenguas, uso un StringBuilder con un for que cogerá cada uno de los elementos y los
        //irá almacenando en un String que podré añadir al array de Strings de características.
        StringBuilder sb = new StringBuilder();
        for (String s : lengua) {
            sb.append(s);
            sb.append("  ");
        }
        
        //Usé Boolean en lugar de boolean para el atributo gobierno para poder inicializarlo a null, así para los tres valores
        //que puede tener (null, true o false), añado el mensaje correspondiente al array de Strings de características.
        if (Objects.isNull(gobierno)) {
            mensaje = "";
        } else if (gobierno == true) {
            mensaje = "República";
        } else if (gobierno == false) {
            mensaje = "Monarquía";
        }

        String[] datos = {"País: " + nombre, "Capital: " + capital, "Sistema de gobierno: " + mensaje, "Número de habitantes: " + habt, "Lenguas oficilaes: " + sb.toString()};
        return datos;
    }
}
