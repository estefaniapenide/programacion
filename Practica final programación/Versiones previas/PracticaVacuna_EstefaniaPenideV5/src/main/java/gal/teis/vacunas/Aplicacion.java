/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.excepciones_controldata_cadenas.Cadenas;
import gal.teis.excepciones_controldata_cadenas.ControlData;
import gal.teis.excepciones_controldata_cadenas.ErrorFormatoCodigoException;
import gal.teis.excepciones_controldata_cadenas.FaseAnteriorNoSuperadaException;
import gal.teis.excepciones_controldata_cadenas.FaseYaInvestigadaException;
import gal.teis.excepciones_controldata_cadenas.VacunaYaEvaluadaException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Inicializo una vacuna vacía que servirá para comprarla con los resultados devueltos por métodos de VacAlmacen.
        Vacuna vacuna = new Vacuna();

        Scanner input = new Scanner(System.in);

        int idioma;
        do {
            //Imprime un menú para seleccionar el idioma de la aplicación
            System.out.println(Cadenas.menuIdioma());

            idioma = ControlData.leerInt(input);

            //Modifica las variables estáticas de las clases donde hay texto que se saca por pantalla.
            //Para sacar ese texto en inglés o en español segun se pida.
            switch (idioma) {
                case 1:
                    VacunaAutorizacion.idioma = "esp";
                    Cadenas.idioma = "esp";
                    ControlData.idioma = "esp";
                    break;
                case 2:
                    VacunaAutorizacion.idioma = "eng";
                    Cadenas.idioma = "eng";
                    ControlData.idioma = "eng";
                    break;
            }
        } while (idioma != 2 && idioma != 1);

        int opcion;
        do {
            //Imprime el método donde está guardado el menú principal
            System.out.println(Cadenas.menuGestionVacunas());

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    //Si el HashMap almacen está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.listarVacunasAlmacen().isEmpty()) {
                        System.out.println(Cadenas.noHayVacunasAlmacenadasEnLaLista());
                    } else {
                        //Mediante iterator se extrae cada una de las vacunas del HashMap almacen y se imprime.
                        Collection<Vacuna> collection = VacAlmacen.listarVacunasAlmacen().values();
                        Iterator<Vacuna> it = collection.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                    }
                    break;
                case 2:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    System.out.println(Cadenas.introduzcaElCodigoDeLaVacunaQueDeseaBuscar());
                    String codigoBusqueda = ControlData.leerString(input);

                    //Si 'codigoBusqueda' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoBusqueda);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoBusqueda).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no ha encontrado la vacuna.
                        System.out.println(Cadenas.vacunaNoEncontrada());
                    } else {
                        //En cualquier otro caso, devuelve la vacuna.
                        System.out.println(VacAlmacen.buscarVacunaCodigo(codigoBusqueda));
                    }
                    break;
                case 3:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    //Se crea una vacuna provisional a la que asignarle el código que se introduzca por pantalla.
                    Vacuna vacunaCodigo = new Vacuna();

                    String codigo = "";
                    do {
                        System.out.println(Cadenas.introduzcaElCodigoDeLaVacuna());
                        codigo = ControlData.leerString(input);
                        //Si el código no cumple los requistos de formato, salta la excepción, 
                        //quedándose vacunaCodigo con el String codigo como una cadena vacía.
                        try {
                            vacunaCodigo.setCodigo(codigo);
                        } catch (ErrorFormatoCodigoException e) {
                            System.out.println(e.getMessage());
                        }
                        //Mientras vacunaCodigo tenga codigo como una cadena vacía, 
                        //será igual a vacuna creada al principio del main y se repetirá el bucle.
                    } while (vacunaCodigo.equals(vacuna));

                    //Solo se saldrá del bucle cuando el código tenga un formato apropiado.
                    //Si el 'codigo' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigo);

                    //Si la vacuna que devuelve es igual a la nueva vacunaCodigo provisional, 
                    //se informa al ususrio y se pregunta si la querrá sustituir por esta nueva o conservar la antigua.
                    if (VacAlmacen.buscarVacunaCodigo(codigo).equals(vacunaCodigo)) {
                        System.out.println(Cadenas.yaHayUnaVacunaConElMismoCodigo());
                        char respuesta;
                        do {

                            System.out.println(Cadenas.deseaReemplazarla());

                            String a = ControlData.leerString(input);

                            a = a.toLowerCase();
                            respuesta = a.charAt(0);
                            switch (respuesta) {
                                case 'y':
                                    //En caso de querer reemplazarla pide el resto de datos
                                    System.out.println(Cadenas.introduzcaElNombreDeLaVacuna());
                                    String nombre = ControlData.leerString(input);
                                    System.out.println(Cadenas.introduzcaElPrincipioActivoDeLaVacuna());
                                    String principioActivo = ControlData.leerString(input);
                                    System.out.println(Cadenas.introduzcaLaFarmaceuticaDeLaVacuna());
                                    String farmaceutica = ControlData.leerString(input);
                                    System.out.println(Cadenas.introduzcaElPrecioRecomendadoDeLaVacuna());
                                    double precioRecomendado = ControlData.leerDouble(input);

                                    //Se crea la vacuna nueva con los datos introducidos, incluído el código.
                                    Vacuna nuevaVacuna = new Vacuna(codigo, nombre, principioActivo, farmaceutica, precioRecomendado);

                                    //Se añade la vacuna nueva al HashMap almacen, usando su codigo como clave y la propia vacuna como valor.
                                    //El HahsMap, ante dos claves iguales, almacena el elemento de la última añadida, por lo que se reemplaza.
                                    VacAlmacen.agregarVacuna(codigo, nuevaVacuna);

                                    //Imprime un mensaje indicando que se ha reemplazado la vacuna.
                                    System.out.println(Cadenas.vacunaReemplazada());
                                    break;
                                case 'n':
                                    //Si no se quiere reeemplazar, se lanza un mensaje y se sale del bucle y del case 3.
                                    System.out.println(Cadenas.noSeHanProdicidoModificacionesEnLaLista());
                                    break;
                                default:
                                    System.out.println(Cadenas.mensajeSwitchDefault());
                                    break;
                            }
                        } while (!(respuesta == 'y' || respuesta == 'n'));

                        //Si la vacuna que devuelve el buscador NO es igual a la nueva vacunaCodigo provisional, se piden el resto de datos.
                    } else {
                        System.out.println(Cadenas.introduzcaElNombreDeLaVacuna());
                        String nombre = ControlData.leerString(input);
                        System.out.println(Cadenas.introduzcaElPrincipioActivoDeLaVacuna());
                        String principioActivo = ControlData.leerString(input);
                        System.out.println(Cadenas.introduzcaLaFarmaceuticaDeLaVacuna());
                        String farmaceutica = ControlData.leerString(input);
                        System.out.println(Cadenas.introduzcaElPrecioRecomendadoDeLaVacuna());
                        double precioRecomendado = ControlData.leerDouble(input);

                        //Se crea la vacuna nueva con los datos introducidos, incluído el código.
                        Vacuna nuevaVacuna = new Vacuna(codigo, nombre, principioActivo, farmaceutica, precioRecomendado);

                        //Se añade la vacuna nueva al HashMap almacen, usando su codigo como clave y la propia vacuna como valor.
                        VacAlmacen.agregarVacuna(codigo, nuevaVacuna);
                    }
                    break;
                case 4:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    System.out.println(Cadenas.introduzcaElCodigoDeLaVacunaQueDeseaEliminar());
                    String codigoEliminar = ControlData.leerString(input);

                    //Si 'codigoEliminar' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoEliminar);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoEliminar).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no existe la vacuna en la lista.
                        System.out.println(Cadenas.laVacunaqueDeseaEliminarnoExiste());
                    } else {
                        //En cualquier otro caso, la vacuna está en la lista, por lo que se elimina y se imprime un mensaje indicándolo.
                        VacAlmacen.eliminarVacuna(codigoEliminar);
                        System.out.println(Cadenas.vacunaEliminada());
                    }
                    break;
                case 5:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    System.out.println(Cadenas.introduzcaElCodigoDeLaVacunaAModificar());
                    String codigoCambioFases = ControlData.leerString(input);

                    //Si 'codigoCambioFases' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoCambioFases);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoCambioFases).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no existe la vacuna en la lista.
                        System.out.println(Cadenas.laVacunaqueDeseaModificarnoExiste());
                    } else {
                        //En cualquier otro caso, la vacuna está en la lista y se le pueden aplicar cambios.
                        int b;
                        do {
                            //Imprime el menú para elegir qué fase modificar.
                            System.out.println(Cadenas.menuModificarFases(3));
                            b = ControlData.leerInt(input);
                            switch (b) {
                                case 1:
                                    //Imprime el menú para marcar si ha superado o no la fase correspondiente.
                                    System.out.println(Cadenas.menuSuperadaNoSuperada(1));

                                    int c = ControlData.leerInt(input);

                                    switch (c) {
                                        case 1:
                                            //Si ya se ha evaluado como superada o no superada, salta una excepción.
                                            try {
                                            //Marca la fase de la vacuna como superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase1Superada(true);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println(Cadenas.resultadoFase(1, true));
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        case 2:
                                            //Si ya se ha evaluado como superada o no superada, salta una excepción.
                                            try {
                                            //Marca la fase de la vacuna como no superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase1Superada(false);
                                            //Muestra un mensaje que confirma la acción realizada.
                                        System.out.println(Cadenas.resultadoFase(1, false));
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println(Cadenas.mensajeSwitchDefault());
                                            break;
                                    }
                                    break;
                                case 2:
                                    //Imprime el menú para marcar si ha superado o no la fase correspondiente.
                                    System.out.println(Cadenas.menuSuperadaNoSuperada(2));
                                    int d = ControlData.leerInt(input);
                                    switch (d) {
                                        case 1:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido investiagada, salta otra.
                                            try {
                                            //Marca la fase de la vacuna como superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(true);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println(Cadenas.resultadoFase(2, true));
                                        } catch (FaseAnteriorNoSuperadaException e) {
                                            System.out.println(e.getMessage());
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        case 2:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido investiagada, salta otra.
                                            try {
                                            //Marca la fase de la vacuna como no superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(false);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println(Cadenas.resultadoFase(2, false));
                                        } catch (FaseAnteriorNoSuperadaException e) {
                                            System.out.println(e.getMessage());
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println(Cadenas.mensajeSwitchDefault());
                                            break;
                                    }
                                    break;
                                case 3:
                                    //Imprime el menú para marcar si ha superado o no la fase correspondiente.
                                    System.out.println(Cadenas.menuSuperadaNoSuperada(3));
                                    int e = ControlData.leerInt(input);
                                    switch (e) {
                                        case 1:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido investiagada, salta otra.
                                            try {
                                            //Marca la fase de la vacuna como superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(true);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println(Cadenas.resultadoFase(3, true));
                                        } catch (FaseAnteriorNoSuperadaException ex) {
                                            System.out.println(ex.getMessage());
                                        } catch (FaseYaInvestigadaException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                        case 2:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido investiagada, salta otra.
                                            try {
                                            //Marca la fase de la vacuna como no superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(false);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println(Cadenas.resultadoFase(3, false));
                                        } catch (FaseAnteriorNoSuperadaException ex) {
                                            System.out.println(ex.getMessage());
                                        } catch (FaseYaInvestigadaException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println(Cadenas.mensajeSwitchDefault());
                                            break;
                                    }
                                    break;
                                case 0:
                                    System.out.println(Cadenas.volviendoAlMenuPrincipal());
                                    break;
                                default:
                                    System.out.println(Cadenas.mensajeSwitchDefault());
                                    break;
                            }
                        } while (b != 0);
                    }
                    break;
                case 6:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    System.out.println(Cadenas.introduzcaElCodigoDeLaVacunaAAutorizarORechazar());
                    String codigoAutotizarRechazar = ControlData.leerString(input);

                    //Si 'codigoAutotizarRechazar' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no existe la vacuna en la lista.
                        System.out.println(Cadenas.laVacunaqueDeseaAutorizarORechazarnoExiste());
                    } else {
                        //En cualquier otro caso la vacuna existe y se imprime el menú para autorizarla o rechazarla.
                        System.out.println(Cadenas.menuAutorizarRechazar());

                        int e = ControlData.leerInt(input);

                        switch (e) {
                            case 1:
                                //Si la vacuna ya ha sido autorizada o rechazada, salta una excepción.
                                try {
                                //Si no ha saltado la excepción y la vacuna ha susperado las tres fases, podrá ser autorizada.
                                VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).autorizar();
                                //Se comprueba que así ha sido.
                                if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).comprobacionVacunaAutorizada()) {
                                    //Muestra un mensaje confrimando que ha sido autorizada.
                                    System.out.println(Cadenas.vacunaAutorizada());
                                } else {
                                    //Si no ha sido así será por no tener las tres fases superadas y se imprime un mensaje advirtiendo que no fue
                                    //posible autorizarla.
                                    System.out.println(Cadenas.noEsPosibleAutorizarLaVacuna());
                                }
                            } catch (VacunaYaEvaluadaException i) {
                                System.out.println(i.getMessage());
                            }
                            break;
                            case 2:
                                //Si la vacuna ya ha sido autorizada o rechazada, salta una excepción.
                                try {
                                //Si no ha saltado la excepción, podrá ser rechazada.
                                VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).rechazar();
                                //Se comprueba que así ha sido.
                                if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).comprobacionVacunaRechazada()) {
                                    //Muestra un mensaje confrimando que ha sido rechazada.
                                    System.out.println(Cadenas.vacunaRechazada());
                                }
                            } catch (VacunaYaEvaluadaException i) {
                                System.out.println(i.getMessage());
                            }
                            break;
                            default:
                                System.out.println(Cadenas.mensajeSwitchDefault());
                                break;
                        }
                    }
                    break;
                case 7:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    //Si el HashMap vacunasAutorizadas está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verVacunasAutorizadas().isEmpty()) {
                        System.out.println(Cadenas.noHayVacunasAutorizadas());
                    } else {
                        //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
                        for (String key : VacAlmacen.verVacunasAutorizadas().keySet()) {
                            System.out.println(VacAlmacen.verVacunasAutorizadas().get(key));
                        }
                    }
                    break;
                case 8:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    //Si el HashMap vacunasRechazadas está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verVacunasRechazadas().isEmpty()) {
                        System.out.println(Cadenas.noHayVacunasRechazadas());
                    } else {
                        //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
                        for (String key : VacAlmacen.verVacunasRechazadas().keySet()) {
                            System.out.println(VacAlmacen.verVacunasRechazadas().get(key));
                        }
                    }
                    break;
                case 9:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    //Si el HashMap vacunasPendientesAutorizarRechazar está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verVacunasPendientesAutorizarRechazar().isEmpty()) {
                        System.out.println(Cadenas.noHayVacunasPendientesDeRechazarOAutorizar());
                    } else {
                        //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
                        for (String key : VacAlmacen.verVacunasPendientesAutorizarRechazar().keySet()) {
                            System.out.println(VacAlmacen.verVacunasPendientesAutorizarRechazar().get(key));
                        }
                    }
                    break;
                case 10:
                    //Imprime el título asociado a la opción correspondiente del menú
                    System.out.println(Cadenas.titulo(opcion));

                    //Si el String ultimaFaseInvestigadaVacuna está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verUltimaFaseInvestigadaVacunas().isEmpty()) {
                        System.out.println(Cadenas.noHayVacunasAlmacenadasEnLaLista());
                    } else {
                        //Si no lo está, lo imprime directamente porque ya está en un formato adecuado.
                        System.out.println(VacAlmacen.verUltimaFaseInvestigadaVacunas());
                    }
                    break;
                case 0:
                    System.out.println(Cadenas.programaFinalizado());
                    break;
                default:
                    System.out.println(Cadenas.mensajeSwitchDefault());
                    break;
            }
        } while (opcion != 0);

        input.close();
    }
}
