/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.codigospostales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author a20estefaniapc
 */
public class CodigoPostal {

    //Atributos
    private HashMap<String, String> codigosPostales = new HashMap<String, String>();
    //key(String)->Código Postal
    //value(String)->Provincia

    //Método para alamcenar códigos postales con sus correspondientes proviencias en el hashMap codigosPostales
    /**
     * Almacena los códigos postales como clave y las provincias como valor en
     * el hashMap codigosPostales
     */
    public void agregarCodigosPostalesGaliciaCastillaLeon() {

        //Pontevedra->36000-36980
        for (Integer i = 36000; i <= 36980; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Pontevedra");
        }

        //Ourense->32000-32930
        for (Integer i = 32000; i <= 32930; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Ourense");
        }

        //Lugo->27000-27891
        for (Integer i = 27000; i <= 27891; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Lugo");
        }

        //A Coruña->15000-15981
        for (Integer i = 15000; i <= 15981; i++) {
            String a = i.toString();
            codigosPostales.put(a, "A Coruña");
        }

        //León->24000-24996
        for (Integer i = 24000; i <= 24996; i++) {
            String a = i.toString();
            codigosPostales.put(a, "León");
        }

        //Palencia->34000 - 34889
        for (Integer i = 34000; i <= 34889; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Palencia");
        }

        //Burgos->09000 - 09693
        for (Integer i = 9000; i <= 9693; i++) {
            String b = "0" + i.toString();
            codigosPostales.put(b, "Burgos");
        }

        //Soria->42000 - 42368
        for (Integer i = 42000; i <= 42368; i++) {
            String b = i.toString();
            codigosPostales.put(b, "Soria");
        }

        //Valladolid->47000 - 47883
        for (Integer i = 47000; i <= 47883; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Valladolid");
        }

        //Zamora->49000 - 49882
        for (Integer i = 49000; i <= 49882; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Zamora");
        }

        //Salamanca->37000 - 37900
        for (Integer i = 37000; i <= 37900; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Salamanca");
        }

        //Ávila->05000 - 05697
        for (Integer i = 5000; i <= 5697; i++) {
            String a = "0" + i.toString();
            codigosPostales.put(a, "Ávila");
        }

        //Segovia->40000 - 40593
        for (Integer i = 40000; i <= 40593; i++) {
            String a = i.toString();
            codigosPostales.put(a, "Segovia");
        }

    }

    /**
     * Alamacena en el hashMap codigosPostales la provincia y el rago de códigos
     * postales que le pertenecen.
     *
     * @param provincia (String)
     * @param codigo_min (String)
     * @param codigo_max (String)
     * @throws ErrorFormatoCodigoPostalException
     */
    public void agregarCodigosPostalesProvincia(String provincia, String codigo_min, String codigo_max) throws ErrorFormatoCodigoPostalException {

        Pattern pat = Pattern.compile("[0-9]{5}");
        Matcher mat = pat.matcher(codigo_min);
        Matcher mat2 = pat.matcher(codigo_max);

        if (!mat.matches() && !mat2.matches()) {
            throw new ErrorFormatoCodigoPostalException();
        }

        if (codigo_min.charAt(0) == '0') {
            codigo_min = codigo_min.substring(1);
        }

        if (codigo_max.charAt(0) == '0') {
            codigo_max = codigo_max.substring(1);
        }

        Integer codigoMin = Integer.valueOf(codigo_min);
        Integer codigoMax = Integer.valueOf(codigo_max);

        for (Integer i = codigoMin; i < codigoMax; i++) {
            String a = i.toString();
            codigosPostales.put(a, provincia);
        }

    }

    public void agregarCodigosPostalesGalicia() {
        try {
            agregarCodigosPostalesProvincia("Pontevedra", "36000", "36980");
            agregarCodigosPostalesProvincia("Lugo", "27000", "27891");
            agregarCodigosPostalesProvincia("Ourense", "32000", "32930");
            agregarCodigosPostalesProvincia("A Coruña", "15000", "15981");
        } catch (ErrorFormatoCodigoPostalException e) {
        }
    }
    
    public void agregarCodigosPostalesCastillaLeon() {
        try {
            agregarCodigosPostalesProvincia("León", "24000", "24996");
            agregarCodigosPostalesProvincia("Palencia", "34000", "34889");
            agregarCodigosPostalesProvincia("Burgos", "09000", "09693");
            agregarCodigosPostalesProvincia("Soria", "42000", "42368");
            agregarCodigosPostalesProvincia("Valladolid", "47000", "47883");
            agregarCodigosPostalesProvincia("Zamora", "49000", "49882");
            agregarCodigosPostalesProvincia("Salamanca", "37000", "37900");
            agregarCodigosPostalesProvincia("Ávila", "05000", "05697");
            agregarCodigosPostalesProvincia("Segovia", "40000", "40593");
        } catch (ErrorFormatoCodigoPostalException e) {
        }
    }

    //Métodos para listar los Códigos Postales almacenados con sus provincias
    /**
     * Lista los códigos postales almacenados con sus provincias (empleando
     * entrySet())
     *
     * @return String codigoPostal, provincia
     */
    public String listarEntry() {

        String mensaje = "\n";
        if (codigosPostales.isEmpty()) {
            mensaje = "La lista está vacía.";
        } else {
            for (Map.Entry<String, String> entry : codigosPostales.entrySet()) {
                String codigo = entry.getKey();
                String provincia = entry.getValue();
                mensaje = mensaje + "Código Postal: " + codigo + " -> Provincia: " + provincia + "\n";
            }
        }
        return mensaje;
    }

    /**
     * Lista los códigos postales almacenados con sus provincias (empleando
     * keySet())
     *
     * @return codigoPostal, provincia (String)
     */
    public String listarKeySet() {

        String mensaje = "\n";
        if (codigosPostales.isEmpty()) {
            mensaje = "La lista está vacía.";
        } else {
            for (String codigo : codigosPostales.keySet()) {
                mensaje = mensaje + "Código Postal: " + codigo + " -> Provincia: " + codigosPostales.get(codigo) + "\n";
            }
        }
        return mensaje;

    }

    //Método para buscar a qué propvincia pertenece un código postal
    /**
     * Busca a qué propvincia pertenece un determinado código postal.
     *
     * @param codigo (String)
     * @return provincia (String)
     */
    public String buscarCodigo(String codigo) {

        String resultado;

        Iterator<String> it = codigosPostales.keySet().iterator();
        String encontrado = "";

        while (it.hasNext()) {
            String key = it.next();
            if (key.equals(codigo)) {
                encontrado = key;
            } else {
                encontrado = encontrado;
            }
        }

        String a = codigosPostales.get(encontrado);
        if (a == null) {
            resultado = "El código introducido no se corresponde con ninguna provincia almacenada.";
        } else {
            resultado = "Provincia :" + a;
        }

        return resultado;
    }

    //Métodos para eliminar las provincias indicadas y sus códigos del hashMap codigosPostales
    /**
     * Elimina del hashMap codigosPostales los códigos postales de Lugo, León y Valladolid
     */
    public void eliminarLugoLeonValladolid() {

        //León->24000-24996
        for (Integer i = 24000; i <= 24996; i++) {
            String a = i.toString();
            codigosPostales.remove(a);
        }

        //Valladolid->47000 - 47883
        for (Integer i = 47000; i <= 47883; i++) {
            String a = i.toString();
            codigosPostales.remove(a);
        }

        //Lugo->27000-27891
        for (Integer i = 27000; i <= 27891; i++) {
            String a = i.toString();
            codigosPostales.remove(a);
        }

    }

}


