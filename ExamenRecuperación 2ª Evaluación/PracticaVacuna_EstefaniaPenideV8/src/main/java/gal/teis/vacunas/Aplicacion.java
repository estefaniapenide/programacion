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
import gal.teis.excepciones_controldata_cadenas.Manual;
import gal.teis.excepciones_controldata_cadenas.VacunaYaEvaluadaException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Gestiona y ejecuta todos los métodos de VacAlmacen y demás acciones que se
 * puden llevar a cabo con las vacunas.
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

        //Antes de mostrar el menú principal de la aplicación le solicito al usuario que escoja un idioma.
        gestionIdioma(input);

        //Menú principal
        int opcion;
        do {
            //Imprime los Strings del menú principal
            System.out.println(Cadenas.menuGestionVacunas());

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    //Imprime el título asociado a la opción correspondiente del menú: Listar Vacunas
                    System.out.println(Cadenas.titulo(opcion));

                    //Devuelve la lista de vacunas del almacén
                    imprimirListaVacunas();

                    break;
                case 2:
                    //En este punto del menú doy la opción de escoger el criterio de búsqueda.
                    int op;

                    do {
                        //Menú para elegir el criterio de búsqueda
                        System.out.println(Cadenas.menuBusquedaVacunas());

                        op = ControlData.leerInt(input);

                        switch (op) {
                            case 1:
                                //Imprime el título asociado a la opción correspondiente del menú: Búsqueda por código
                                System.out.println(Cadenas.tituloBusqueda(op));

                                //Pide por pantalla el código de la vacuna a buscar
                                System.out.println(Cadenas.introduzcaElCodigoDeLaVacunaQueDeseaBuscar());
                                String codigoBusqueda = ControlData.leerString(input);

                                //Imprime por pantalla el resultado obtenido
                                imprimirBusquedaCodigo(codigoBusqueda, vacuna);

                                break;
                            case 2:
                                //Imprime el título asociado a la opción correspondiente del menú: Búsqueda por nombre
                                System.out.println(Cadenas.tituloBusqueda(op));

                                //Pide por pantalla el nombre de la vacuna a buscar
                                System.out.println(Cadenas.introduzcaElNombreDeLaVacuna());
                                String nombre = ControlData.leerString(input);

                                //Imprime por pantalla el resultado o resultados obtenidos
                                imprimirBusquedaNombre(nombre);

                                break;
                            case 3:
                                //Imprime el título asociado a la opción correspondiente del menú: Búsqueda por principio activo
                                System.out.println(Cadenas.tituloBusqueda(op));

                                //Pide por pantalla el principio activo de la vacuna a buscar
                                System.out.println(Cadenas.introduzcaElPrincipioActivoDeLaVacuna());
                                String principioActivo = ControlData.leerString(input);

                                //Imprime por pantalla el resultado o resultados obtenidos
                                imprimirBusquedaPrincipioActivo(principioActivo);

                                break;
                            case 4:
                                //Imprime el título asociado a la opción correspondiente del menú: Búsqueda por farmacéutica
                                System.out.println(Cadenas.tituloBusqueda(op));

                                //Pide por pantalla la farméutica de la vacuna a buscar
                                System.out.println(Cadenas.introduzcaLaFarmaceuticaDeLaVacuna());
                                String farmaceutica = ControlData.leerString(input);

                                //Imprime por pantalla el resultado o resultados obtenidos
                                imprimirBusquedaFarmaceutica(farmaceutica);

                                break;
                            case 5:
                                //Imprime el título asociado a la opción correspondiente del menú: Búsqueda por precio recomendado
                                System.out.println(Cadenas.tituloBusqueda(op));

                                //Pide por pantalla el precio recomendado de la vacuna a buscar
                                System.out.println(Cadenas.introduzcaElPrecioRecomendadoDeLaVacuna());
                                double precioRecomendado = ControlData.leerDouble(input);

                                //Imprime por pantalla el resultado o resultados obtenidos
                                imprimirBusquedaPrecioRecomendado(precioRecomendado);

                                break;
                            case 0:
                                System.out.println(Cadenas.volviendoAlMenuPrincipal());
                                break;
                            default:
                                System.out.println(Cadenas.mensajeSwitchDefault());
                                break;

                        }
                    } while (op != 0);
                    break;
                case 3:
                    //Imprime el título asociado a la opción correspondiente del menú: Agregar vacuna
                    System.out.println(Cadenas.titulo(opcion));

                    //Pide los datos de la vacuna a añadir a la lista y la añade si es posible
                    gestionAgregarVacunaConControlFormato(input, vacuna);

                    break;
                case 4:
                    //Imprime el título asociado a la opción correspondiente del menú: Eliminar vacuna
                    System.out.println(Cadenas.titulo(opcion));

                    //Pide el código de la vacuna a eliminar
                    System.out.println(Cadenas.introduzcaElCodigoDeLaVacunaQueDeseaEliminar());
                    String codigoEliminar = ControlData.leerString(input);

                    //La elimina si es era parte de la lista
                    gestionEliminarVacuna(codigoEliminar, vacuna);

                    break;
                case 5:
                    //Imprime el título asociado a la opción correspondiente del menú: Resultado de las fases
                    System.out.println(Cadenas.titulo(opcion));

                    //Pide por pantalla el código de la vacuna cuyas fases se quieren modificar
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
                        gestionFases(input, codigoCambioFases, vacuna);
                    }
                    break;
                case 6:
                    //Imprime el título asociado a la opción correspondiente del menú: Autorizar o Rechazar 
                    System.out.println(Cadenas.titulo(opcion));

                    //Pide por pantalla el código de la vacuna que se desea autorizar o rechazar
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
                                //Se autoriza la vacuna si es posible
                                autorizarVacuna(codigoAutotizarRechazar);
                                break;
                            case 2:
                                //Se rechaza la vacuna si es posible
                                rechazarVacuna(codigoAutotizarRechazar);
                                break;
                            default:
                                System.out.println(Cadenas.mensajeSwitchDefault());
                                break;
                        }
                    }
                    break;
                case 7:
                    //Imprime el título asociado a la opción correspondiente del menú: Vacunas autorizadas
                    System.out.println(Cadenas.titulo(opcion));

                    //Muestra por pantalla todas las vacunas que están autorizadas
                    imprimirVacunasAutorizadas();

                    break;
                case 8:
                    //Imprime el título asociado a la opción correspondiente del menú: Vacunas rechazadas
                    System.out.println(Cadenas.titulo(opcion));

                    //Muestra por pantalla todas las vacunas que están rechazadas
                    imprimirVacunasRechazdas();

                    break;
                case 9:
                    //Imprime el título asociado a la opción correspondiente del menú: Vacunas pendientes de autorizar/rechazar
                    System.out.println(Cadenas.titulo(opcion));

                    //Muestra por pantalla todas las vacunas que aun no han sido ni autorizadas ni rechazadas
                    imprimirVacunasPendientesRechazarAutorizar();

                    break;
                case 10:
                    //Imprime el título asociado a la opción correspondiente del menú: Última fase superada
                    System.out.println(Cadenas.titulo(opcion));

                    //Muestra por pantalla todas las vacunas almacenadas junto con el estado de su última fase investigada
                    ultimaFaseSuperada();

                    break;
                case 11:
                    System.out.println(Cadenas.titulo(opcion));

                    System.out.println("Introduzca el código de la vacuna a asignar:");
                    String codigo = ControlData.leerString(input);

                    //Si 'codigoBusqueda' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigo);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigo).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no ha encontrado la vacuna.
                        System.out.println(Cadenas.vacunaNoEncontrada());
                    } else if (VacAlmacen.buscarVacunaCodigo(codigo).comprobacionVacunaAutorizada()) {
                        //En cualquier otro caso, si la vacuna ha sido autorizada  
                        Vacuna vacunaValida = VacAlmacen.buscarVacunaCodigo(codigo);

                        System.out.println("Introduzca el nombre del país:");
                        String pais = ControlData.leerString(input);

                        AsignaVacuna nuevaAsignacion = new AsignaVacuna(vacunaValida, pais);

                        if (VacAlmacen.existeVacunasAsignadas(nuevaAsignacion)) {
                            System.out.println("La asignación que desea realizar ya existe.");
                            System.out.println(VacAlmacen.buscarVacunaAsignada(nuevaAsignacion));

                            char respuesta;
                            do {

                                System.out.println("¿Desea cambiar el número de dosis asignadas?y/n");

                                String a = ControlData.leerString(input);
                                a = a.toLowerCase();
                                respuesta = a.charAt(0);

                                switch (respuesta) {
                                    case 'y':
                                        System.out.println("Introduzca el total de dosis asignadas:");
                                        long asignadas = ControlData.leerLong(input);

                                        nuevaAsignacion.asignar(asignadas);

                                        System.out.println("Operación realizada.");
                                        System.out.println(nuevaAsignacion);

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
                        } else {
                            VacAlmacen.agregarVacunasAsignadas(nuevaAsignacion);

                            System.out.println("Introduzca el número de dosis a asignar:");
                            long asignadas = ControlData.leerLong(input);

                            nuevaAsignacion.asignar(asignadas);

                            System.out.println("Operación realizada.");
                            System.out.println(nuevaAsignacion);
                        }

                    } else {
                        System.out.println("La vacuna que desea asignar todavía no ha sido autorizada. No es posible asignarsela a ningún país.");
                    }
                    break;
                case 12:
                    System.out.println(Cadenas.titulo(opcion));

                    System.out.println("Introduzaca el nombre del país: ");
                    String pais = ControlData.leerString(input);

                    VacAlmacen.verVacunasAsignadasPorPais(pais);

                    if (VacAlmacen.verVacunasAsignadasPorPais(pais).isEmpty()) {
                        System.out.println("No hay vacunas asigandas a " + pais);
                    } else {
                        for (AsignaVacuna aux : VacAlmacen.verVacunasAsignadasPorPais(pais)) {
                            System.out.println("\n"+aux);

                        }
                    }

                    break;
                case 13:
                    //Muestra por pantalla el manual de usuario del programa
                    System.out.println(Manual.Idioma());
                    System.out.println(Manual.listarVacunas());
                    System.out.println(Manual.buscarVacunas());
                    System.out.println(Manual.agregarVacunas());
                    System.out.println(Manual.eliminarVacunas());
                    System.out.println(Manual.resultadoFases());
                    System.out.println(Manual.autorizarRechazar());
                    System.out.println(Manual.verAutorizadas());
                    System.out.println(Manual.verRechazadas());
                    System.out.println(Manual.verPendientesRechazarAutorizar());
                    System.out.println(Manual.verUltimaFaseInvestigada());
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

    /**
     * Imprime el menú de idiomas y tiene el switch para elegir la lengua.
     *
     * @param input (int) idioma a escoger del menú. Lectura del Scanner.
     */
    public static void gestionIdioma(Scanner input) {

        //Imprime un menú para seleccionar el idioma de la aplicación
        System.out.println(Cadenas.menuIdioma());

        int idioma = controlIdioma(input);

        //Modifica las variables estáticas de las clases donde hay texto que se saca por pantalla.
        //Para sacar ese texto en inglés o en español segun se pida. Si no se escoje ningun idioma, por defecto sserá español.
        switch (idioma) {
            case 1:
                espanol();
                break;
            case 2:
                english();
                break;
            default:
                System.out.println("Español");
                break;
        }
    }

    /**
     * Asignan español a las variables estáticas de idioma de todas las clases.
     */
    public static void espanol() {
        VacunaAutorizacion.idioma = "esp";
        Cadenas.idioma = "esp";
        ControlData.idioma = "esp";
        Manual.idioma = "esp";
        System.out.println("Español");
    }

    /**
     * Asignan inglés a las variables estáticas de idioma de todas las clases.
     */
    public static void english() {
        VacunaAutorizacion.idioma = "eng";
        Cadenas.idioma = "eng";
        ControlData.idioma = "eng";
        Manual.idioma = "eng";
        System.out.println("English");
    }

    /**
     * Se encarga del controlar el tipo int del menú de idiomas, se ha creado a
     * parte para que devuelva el mensaje de error en los dos idiomas de forma
     * simultánea, porque en este punto áun no se ha escogido el idioma.
     *
     * @param input (int) idioma a escoger del menú. Lectura del scanner.
     * @return (int) idioma a escoger del menú
     */
    public static int controlIdioma(Scanner input) {

        //Hago el control del menú del idioma por aquí en lugar de usar ControlData para que los mensajes
        //salgan en ambos idiomas. 
        int idioma = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                idioma = input.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca un número.");
                System.out.println("ERROR. You have not entered a valid value. Please enter a number.");

                input.next();
                correcto = false;
            }
        } while (!correcto);
        return idioma;
    }

    /**
     * Muestra por pantalla las vacunas del HashMap de
     * VacAlmacen.listarAlmacen() y si este está vacío muestra un mensaje
     * indicándolo.
     */
    public static void imprimirListaVacunas() {

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

    }

    /**
     * Si VacAlmacen.buscarVacunaCodigo(String codigo) ha devuelto una vacuna
     * vacía, devuelve un mensaje indicando que la vacuna no está en la lista,
     * de lo contrario, muestra la vacuna.
     *
     * @param codigoBusqueda (String) código de la vacuna que se desea buscar.
     * @param vacuna (Vacuna) vacuna vacía para comprar con los resultados de
     * VacAlmacen.buscarVacunaCodigo(String codigo).
     */
    public static void imprimirBusquedaCodigo(String codigoBusqueda, Vacuna vacuna) {

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

    }

    /**
     * Devuelve un mensaje si el HashMap de VacAlmacen.buscarVacunaNombre(String
     * codigo) está vacío o, si hay vacunas coincidentes con ese nombre, imprime
     * cada una de ellas.
     *
     * @param nombre (String) nombre de la vacuna que se desea buscar
     */
    public static void imprimirBusquedaNombre(String nombre) {

        //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.buscarVacunaNombre(nombre).isEmpty()) {
            System.out.println(Cadenas.laVacunaNoSeEncuentraEnLaLista());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.buscarVacunaNombre(nombre).keySet()) {
                System.out.println(VacAlmacen.buscarVacunaNombre(nombre).get(key));
            }
        }

    }

    /**
     * Devuelve un mensaje si el HashMap de
     * VacAlmacen.buscarVacunaPrincipioActivo(String principioActivo) está vacío
     * o, si hay vacunas coincidentes con ese principio activo, imprime cada una
     * de ellas.
     *
     * @param principioActivo (String) principio activo de la vacuna que se
     * desea buscar
     */
    public static void imprimirBusquedaPrincipioActivo(String principioActivo) {

        //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.buscarVacunaPrincipioActivo(principioActivo).isEmpty()) {
            System.out.println(Cadenas.laVacunaNoSeEncuentraEnLaLista());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.buscarVacunaPrincipioActivo(principioActivo).keySet()) {
                System.out.println(VacAlmacen.buscarVacunaPrincipioActivo(principioActivo).get(key));
            }
        }

    }

    /**
     * Devuelve un mensaje si el HashMap de
     * VacAlmacen.buscarVacunaFarmaceutica(String farmaceutica) está vacío o, si
     * hay vacunas coincidentes con esa farmacéutica, imprime cada una de ellas.
     *
     * @param farmaceutica (String) farmacéutica de la vacuna que se desea
     * buscar
     */
    public static void imprimirBusquedaFarmaceutica(String farmaceutica) {

        //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.buscarVacunaFarmaceutica(farmaceutica).isEmpty()) {
            System.out.println(Cadenas.laVacunaNoSeEncuentraEnLaLista());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.buscarVacunaFarmaceutica(farmaceutica).keySet()) {
                System.out.println(VacAlmacen.buscarVacunaFarmaceutica(farmaceutica).get(key));
            }
        }

    }

    /**
     * Devuelve un mensaje si el HashMap de
     * VacAlmacen.buscarVacunaPrecioRecomendado(double precioRecomendado) está
     * vacío o, si hay vacunas coincidentes con ese precio, imprime cada una de
     * ellas.
     *
     * @param precioRecomendado (double) precio recomendado de la vacuna que se
     * desea buscar
     */
    public static void imprimirBusquedaPrecioRecomendado(double precioRecomendado) {

        //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado).isEmpty()) {
            System.out.println(Cadenas.laVacunaNoSeEncuentraEnLaLista());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado).keySet()) {
                System.out.println(VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado).get(key));
            }
        }

    }

    /**
     * Recoge el código pedido por pantalla a tarvés del parámetro 'Scanner
     * input' y controla que este tenga el formato adecuado. De ser así busca
     * por medio de esta clave si la vacuna ya está almacenada en la lista.
     *
     * @param input (Scanner) lectura del Scanner.
     * @param vacuna (Vacuna) vacuna vacía para comprar con los resultados de
     * VacAlmacen.buscarVacunaCodigo(String codigo).
     */
    public static void gestionAgregarVacunaConControlFormato(Scanner input, Vacuna vacuna) {
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

        agregarOReemplazarVacuna(input, codigo, vacunaCodigo);

    }

    /**
     * Se ejecuta a continuación dentro de
     * Aplicacion.gestionAgregarVacunaConControlFormato(Scanner input, Vacuna
     * vacuna). En caso de que la vacuna esté almacenada ya en la lista,
     * pregunta si se desea reemplazar o no. Si se desea reemplazar, se piden
     * los datos de la nueva vacuna y la reemplaza. Si no se desea reemplazar se
     * vuelve al menú principal. Si la vacuna aún no estaba almacenada, se piden
     * el resto de datos de la vacuna y se añade a la lista.
     *
     * @param input (Scanner) lectura del Scanner.
     * @param codigo (String) código de la vacuna que se desea añadir
     * @param vacunaCodigo (Vacuna) vacuna con el código de la vacuna que se
     * desea añadir
     */
    public static void agregarOReemplazarVacuna(Scanner input, String codigo, Vacuna vacunaCodigo) {

        //Si la vacuna que devuelve es igual a la nueva vacunaCodigo provisional, 
        //se informa al usuario y se pregunta si la querrá sustituir por esta nueva o conservar la antigua.
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
                        vacunaNueva(input, codigo);
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

        } else {
            //Si la vacuna que devuelve el buscador NO es igual a la nueva vacunaCodigo provisional, se piden el resto de datos.
            vacunaNueva(input, codigo);
        }

    }

    /**
     * Método encargo de pedir los datos de la vacuna que se va a añadir a la
     * lista/reemplazar otra vacuna y añadirla.
     *
     * @param input (Scanner) lectura del scanner
     * @param codigo (String) código de la vacuna que se desea crear
     */
    public static void vacunaNueva(Scanner input, String codigo) {

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

    }

    /**
     * Si VacAlmacen.buscarVacunaCodigo(String codigo) ha devuelto una vacuna
     * vacía, devuelve un mensaje indicando que la vacuna no está en la lista,
     * de lo contrario, elimina la vacuna.
     *
     * @param codigoEliminar (String) código de la vacuna que se desea eliminar
     * @param vacuna (Vacuna) vacuna vacía para comprar con los resultados de
     * VacAlmacen.buscarVacunaCodigo(String codigo).
     */
    public static void gestionEliminarVacuna(String codigoEliminar, Vacuna vacuna) {

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

    }

    /**
     * Busca si la vacuna que se deasea modificar está en la lista, si no lo
     * está devuelve un mensaje, si lo está ejecuta
     * Aplicacion.menuModificarFases(input, codigoCambioFases).
     *
     * @param input (Scanner) lectura del scanner
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     * @param vacuna (Vacuna) vacuna vacía para comprar con los resultados de
     * VacAlmacen.buscarVacunaCodigo(String codigo).
     */
    public static void gestionFases(Scanner input, String codigoCambioFases, Vacuna vacuna) {
        //Si 'codigoCambioFases' es igual a alguno de los del HashMap almacen, devuelve esa vacuna, 
        //si no lo es, devuelve una vacuna vacía.
        VacAlmacen.buscarVacunaCodigo(codigoCambioFases);

        //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
        if (VacAlmacen.buscarVacunaCodigo(codigoCambioFases).equals(vacuna)) {
            //En este caso devuelve un mensaje diciendo que no existe la vacuna en la lista.
            System.out.println(Cadenas.laVacunaqueDeseaModificarnoExiste());
        } else {
            //En cualquier otro caso, la vacuna está en la lista y se le pueden aplicar cambios.
            menuModificarFases(input, codigoCambioFases);

        }
    }

    /**
     * Muestra y gestiona el menú con el que se accede a la modificación de la
     * fase escogida.
     *
     * @param input (Scanner) lectura del scanner
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     */
    public static void menuModificarFases(Scanner input, String codigoCambioFases) {

        int b;
        do {
            //Imprime el menú para elegir qué fase modificar.
            System.out.println(Cadenas.menuModificarFases(3));

            b = ControlData.leerInt(input);
            switch (b) {
                case 1:
                    //Imprime el menú para marcar si ha superado o no la fase 1.
                    System.out.println(Cadenas.menuSuperadaNoSuperada(1));

                    menuModificarFase1(input, codigoCambioFases);

                    break;
                case 2:
                    //Imprime el menú para marcar si ha superado o no la fase 2.
                    System.out.println(Cadenas.menuSuperadaNoSuperada(2));

                    menuModificarFase2(input, codigoCambioFases);

                    break;
                case 3:
                    //Imprime el menú para marcar si ha superado o no la fase 3.
                    System.out.println(Cadenas.menuSuperadaNoSuperada(3));

                    menuModificarFase3(input, codigoCambioFases);

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

    /**
     * Gestiona el menú donde se escoge si se ha superado o no la fase 1.
     *
     * @param input (Scanner) lectura del scanner
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     */
    public static void menuModificarFase1(Scanner input, String codigoCambioFases) {

        int c = ControlData.leerInt(input);

        switch (c) {
            case 1:
                modificarFase1(codigoCambioFases, true);
                break;
            case 2:
                modificarFase1(codigoCambioFases, false);
                break;
            default:
                System.out.println(Cadenas.mensajeSwitchDefault());
                break;
        }

    }

    /**
     * Accede a los métodos VacunaAutorizacion.setFase1Superada(boolean
     * fase1Superada) y lo modifica acorde a la opción escogida en el menú.
     * Devuelven un mensaje confirmando la acción una vez ha sido realizada.
     *
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     * @param estado (boolean) fase superada o no superada
     */
    public static void modificarFase1(String codigoCambioFases, boolean estado) {
        //Si ya se ha evaluado como superada o no superada, salta una excepción.
        try {
            //Marca la fase de la vacuna como superada.
            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase1Superada(estado);
            //Muestra un mensaje que confirma la acción realizada.
            System.out.println(Cadenas.resultadoFase(1, estado));
        } catch (FaseYaInvestigadaException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Gestiona el menú donde se escoge si se ha superado o no la fase 2.
     *
     * @param input (Scanner) lectura del scanner
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     */
    public static void menuModificarFase2(Scanner input, String codigoCambioFases) {

        int d = ControlData.leerInt(input);
        switch (d) {
            case 1:
                modificarFase2(codigoCambioFases, true);
                break;
            case 2:
                modificarFase2(codigoCambioFases, false);
                break;
            default:
                System.out.println(Cadenas.mensajeSwitchDefault());
                break;
        }
    }

    /**
     * Accede a los métodos VacunaAutorizacion.setFase2Superada(boolean
     * fase2Superada) y lo modifica acorde a la opción escogida en el menú.
     * Devuelven un mensaje confirmando la acción una vez ha sido realizada.
     *
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     * @param estado (boolean) fase superada o no superada
     */
    public static void modificarFase2(String codigoCambioFases, boolean estado) {

        //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido investiagada, salta otra.
        try {
            //Marca la fase de la vacuna como superada.
            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(estado);
            //Muestra un mensaje que confirma la acción realizada.
            System.out.println(Cadenas.resultadoFase(2, estado));
        } catch (FaseAnteriorNoSuperadaException e) {
            System.out.println(e.getMessage());
        } catch (FaseYaInvestigadaException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Gestiona el menú donde se escoge si se ha superado o no la fase 3.
     *
     * @param input (Scanner) lectura del scanner
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     */
    public static void menuModificarFase3(Scanner input, String codigoCambioFases) {

        int e = ControlData.leerInt(input);
        switch (e) {
            case 1:
                modificarFase3(codigoCambioFases, true);
                break;
            case 2:
                modificarFase3(codigoCambioFases, false);
                break;
            default:
                System.out.println(Cadenas.mensajeSwitchDefault());
                break;
        }

    }

    /**
     * Accede a los métodos VacunaAutorizacion.setFase3Superada(boolean
     * fase3Superada) y lo modifica acorde a la opción escogida en el menú.
     * Devuelven un mensaje confirmando la acción una vez ha sido realizada.
     *
     * @param codigoCambioFases (String) código de la vacuna cuyas fases se
     * desean modificar
     * @param estado (boolean) fase superada o no superada
     */
    public static void modificarFase3(String codigoCambioFases, boolean estado) {

        //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido investiagada, salta otra.
        try {
            //Marca la fase de la vacuna como superada.
            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(estado);
            //Muestra un mensaje que confirma la acción realizada.
            System.out.println(Cadenas.resultadoFase(3, estado));
        } catch (FaseAnteriorNoSuperadaException ex) {
            System.out.println(ex.getMessage());
        } catch (FaseYaInvestigadaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Ejecuta el método VacunaAutorizacion.autorizar(), si la vacuna ya hubiera
     * sido autorizada o rechazada, saltaría una excepción y si la vacuna no
     * hubiera superado las tres fases tampoco se autorizaría y saldría un
     * mensaje indicandolo. En caso contrario también se imprime un mensaje
     * confirmando que la vacuna ha sido autorizada.
     *
     * @param codigoAutotizarRechazar (String) código de la vacuna que se desea
     * autorizar o rechazar
     */
    public static void autorizarVacuna(String codigoAutotizarRechazar) {

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

    }

    /**
     * Ejecuta el método VacunaAutorizacion.rechazar(), si la vacuna ya hubiera
     * sido autorizada o rechazada, saltaría una excepción. En caso contrario
     * también se imprime un mensaje confirmando que la vacuna ha sido
     * rechazada.
     *
     * @param codigoAutotizarRechazar (String) código de la vacuna que se desea
     * autorizar o rechazar
     */
    public static void rechazarVacuna(String codigoAutotizarRechazar) {

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

    }

    /**
     * Devuelve un mensaje si el HashMap de VacAlmacen.verVacunasAutorizadas()
     * está vacío o devuleve las vacunas de ese HashMap una a una en formato
     * String si hay alguna.
     */
    public static void imprimirVacunasAutorizadas() {

        //Si el HashMap vacunasAutorizadas está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.verVacunasAutorizadas().isEmpty()) {
            System.out.println(Cadenas.noHayVacunasAutorizadas());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.verVacunasAutorizadas().keySet()) {
                System.out.println(VacAlmacen.verVacunasAutorizadas().get(key));
            }
        }
    }

    /**
     * Devuelve un mensaje si el HashMap de VacAlmacen.verVacunasRechazadas()
     * está vacío o devuleve las vacunas de ese HashMap una a una en formato
     * String si hay alguna.
     */
    public static void imprimirVacunasRechazdas() {

        //Si el HashMap vacunasRechazadas está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.verVacunasRechazadas().isEmpty()) {
            System.out.println(Cadenas.noHayVacunasRechazadas());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.verVacunasRechazadas().keySet()) {
                System.out.println(VacAlmacen.verVacunasRechazadas().get(key));
            }
        }
    }

    /**
     * Devuelve un mensaje si el HashMap de
     * VacAlmacen.verVacunasPendientesAutorizarRechazar() está vacío o devuleve
     * las vacunas de ese HashMap una a una en formato String si hay alguna.
     */
    public static void imprimirVacunasPendientesRechazarAutorizar() {

        //Si el HashMap vacunasPendientesAutorizarRechazar está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.verVacunasPendientesAutorizarRechazar().isEmpty()) {
            System.out.println(Cadenas.noHayVacunasPendientesDeRechazarOAutorizar());
        } else {
            //Si no lo está se extrae cada vacuna empleando los métodos keySet() y get(value) y se muestran por pantalla.
            for (String key : VacAlmacen.verVacunasPendientesAutorizarRechazar().keySet()) {
                System.out.println(VacAlmacen.verVacunasPendientesAutorizarRechazar().get(key));
            }
        }
    }

    /**
     * Devuelve un mensaje si el String de
     * VacAlmacen.verUltimaFaseInvestigadaVacunas() está vacío, o directamente
     * el propio String si hay algún dato en él.
     */
    public static void ultimaFaseSuperada() {

        //Si el String ultimaFaseInvestigadaVacuna está vacío, devuelve un mensaje indicándolo.
        if (VacAlmacen.verUltimaFaseInvestigadaVacunas().isEmpty()) {
            System.out.println(Cadenas.noHayVacunasAlmacenadasEnLaLista());
        } else {
            //Si no lo está, lo imprime directamente porque ya está en un formato adecuado.
            System.out.println(VacAlmacen.verUltimaFaseInvestigadaVacunas());
        }
    }

}
