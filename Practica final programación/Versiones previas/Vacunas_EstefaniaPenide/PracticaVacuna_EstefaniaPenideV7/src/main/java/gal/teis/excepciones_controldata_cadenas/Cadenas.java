/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata_cadenas;

/**
 * Contiene los métodos con los Strings que sesacarán por pantalla a partir de
 * Aplicación.
 *
 * @author Estefania
 */
public class Cadenas {

    //En los métodos que devuelven un String susceptible de sacarse por pantalla, según el valor de esta variable (por el monento "esp" o "eng"), se
    //devuelven las cadenas en un idioma u otro(español o inglés).
    //Por defecto, en caso de que no se llamara a esta varaibale en el main(en este proyecto no se ha hecho así, sino que se pregunta antes
    //en el main), la inicializo a español.
    public static String idioma = "esp";

    /**
     * Devuelve un String con el menú para elegir el idioma de la aplicación.
     *
     * @return menú para escoger idioma
     */
    public static String menuIdioma() {
        return "-------------------------------------------------\n"
                + "Escoja un idioma/Choose a language:\n"
                + "1.Español\n"
                + "2.English";
    }

    /**
     * Devuelve un String del menú principal con las opciones a elegir de todas
     * las acciones que se peuden hacer con el programa.
     *
     * @return menú principal
     */
    public static String menuGestionVacunas() {
        String menu = "";

        if (idioma.equals("esp")) {

            menu = "-------------------------------------------------\n"
                    + "\tGESTIÓN DE LAS VACUNAS CONTRA EL COVID\n\n"
                    + "Introduzca el número de la acción a realizar:\n\n"
                    + "1. Listar todas las vacunas mostrando sus datos.\n"
                    + "2. Buscar vacuna.\n"
                    + "3. Agregar vacuna.\n"
                    + "4. Eliminar vacuna.\n"
                    + "5. Introducir resultado de las fases de la vacuna.\n"
                    + "6. Autorizar/Rechazar vacuna.\n"
                    + "7. Ver vacunas autorizadas.\n"
                    + "8. Ver vacunas rechazadas.\n"
                    + "9. Ver vacunas pendientes de autorizar/rechazar.\n"
                    + "10. Ver la última fase de investigación de cada vacuna almacenada.\n\n"
                    + "11. Manual para el usuario.\n\n"
                    + "0. Salir.";

        } else if (idioma.equals("eng")) {

            menu = "-------------------------------------------------\n"
                    + "\tMANAGEMENT OF VACCINES AGAINST COVID \n\n"
                    + "Enter the number of the action to perform: \n\n"
                    + "1. List all vaccines showing their data. \n"
                    + "2. Search for vaccine. \n"
                    + "3. Add vaccine. \n"
                    + "4. Delete vaccine. \n"
                    + "5. Enter result of vaccine phases. \n"
                    + "6. Authorize / Reject vaccine. \n"
                    + "7. Seehow authorized vaccines. \n"
                    + "8. See rejected vaccines. \n"
                    + "9. See vaccines pending to authorize / reject. \n"
                    + "10. See latest research phase for each stored vaccine. \n\n"
                    + "11. User's manual.\n\n"
                    + "0. Exit.";
        }
        return menu;
    }

    /**
     * Devuelve un String del título de la opción del menú que se le indica.
     *
     * @param opcion
     * @return titulo
     */
    public static String titulo(int opcion) {
        String titulo = "";

        if (idioma.equals("esp")) {

            switch (opcion) {
                case 1:
                    titulo = "VACUNAS ALMACENADAS:";
                    break;
                case 2:
                    titulo = "";
                    break;
                case 3:
                    titulo = "AGREGAR VACUNA";
                    break;
                case 4:
                    titulo = "ELIMINAR VACUNA";
                    break;
                case 5:
                    titulo = "INTRODUCIR RESULTADO FASES";
                    break;
                case 6:
                    titulo = "AUTORIZAR/RECHAZAR VACUNA";
                    break;
                case 7:
                    titulo = "VACUNAS AUTORIZADAS";
                    break;
                case 8:
                    titulo = "VACUNAS RECHAZADAS";
                    break;
                case 9:
                    titulo = "VACUNAS PENDIENTES DE AUTORIZAR/RECHAZAR";
                    break;
                case 10:
                    titulo = "ÚLTIMA FASE DE INVESTIGACIÓN";
                    break;
                case 11:
                    titulo = "MANUAL DEL USUARIO";
                    break;
                default:
                    titulo = "Título no encontardo";
                    break;
            }

        } else if (idioma.equals("eng")) {

            switch (opcion) {
                case 1:
                    titulo = "STORED VACCINES:";
                    break;
                case 2:
                    titulo = "";
                    break;
                case 3:
                    titulo = "ADD VACCINE";
                    break;
                case 4:
                    titulo = "DELETE VACCINE";
                    break;
                case 5:
                    titulo = "ENTER RESULT PHASES";
                    break;
                case 6:
                    titulo = "AUTHORIZE / REJECT VACCINE";
                    break;
                case 7:
                    titulo = "AUTHORIZED VACCINES";
                    break;
                case 8:
                    titulo = "REJECTED VACCINES";
                    break;
                case 9:
                    titulo = "PENDING VACCINES TO AUTHORIZE / REJECT";
                    break;
                case 10:
                    titulo = "LAST RESEARCHED PHASE";
                    break;
                case 11:
                    titulo = "USER'S MANUAL";
                    break;
                default:
                    titulo = "Title not found";
                    ;
                    break;
            }
        }
        return titulo;
    }

    /**
     * Devuelve un String del menú de búsqueda con las opciones a elegir de
     * todas las búsquedas que se peuden hacer con el programa.
     *
     * @return menú de búsqueda
     */
    public static String menuBusquedaVacunas() {
        String menu = "";

        if (idioma.equals("esp")) {

            menu = "-------------------------------------------------\n"
                    + "\tBUSCAR VACUNA\n\n"
                    + "Introduzca el número de la acción a realizar:\n\n"
                    + "1. Buscar por código.\n"
                    + "2. Buscar por nombre.\n"
                    + "3. Buscar por principio activo.\n"
                    + "4. Buscar por farmacéutica.\n"
                    + "5. Buscar por precio recomendado.\n\n"
                    + "0. Volver al menú principal.";

        } else if (idioma.equals("eng")) {

            menu = "-------------------------------------------------\n"
                    + "\tVACCINE SEARCH\n\n"
                    + "Enter the number of the action to perform:\n\n"
                    + "1. Search by code.\n"
                    + "2. Search by name.\n"
                    + "3. Search by active substance.\n"
                    + "4. Search by pharmaceutical company.\n"
                    + "5. Search by recommended price.\n \n"
                    + "0. Back to the main menu.";
        }
        return menu;
    }

    /**
     * Devuelve un String del título de la opción del menú de búsqueda que se le
     * indica.
     *
     * @param opcion
     * @return titulo tipo de búsqueda
     */
    public static String tituloBusqueda(int opcion) {
        String titulo = "";

        if (idioma.equals("esp")) {

            switch (opcion) {
                case 1:
                    titulo = "BÚSQUEDA POR CÓDIGO";
                    break;
                case 2:
                    titulo = "BÚSQUEDA POR NOMBRE";
                    break;
                case 3:
                    titulo = "BÚSQUEDA POR PRINCIPIO ACTIVO";
                    break;
                case 4:
                    titulo = "BÚSQUEDA POR FARMACÉUTICA";
                    break;
                case 5:
                    titulo = "BÚSQUEDA POR PRECIO RECOMENDADO";
                    break;
                default:
                    titulo = "Título no encontardo";
                    break;
            }

        } else if (idioma.equals("eng")) {

            switch (opcion) {
                case 1:
                    titulo = "SEARCH BY CODE";
                    break;
                case 2:
                    titulo = "SEARCH BY NAME";
                    break;
                case 3:
                    titulo = "SEARCH BY ACTIVE SUBSTANCE";
                    break;
                case 4:
                    titulo = "SEARCH BY PHARMACEUTICAL COMPANY";
                    break;
                case 5:
                    titulo = "SEARCH BY RECOMMENDED PRICE";
                    break;
                default:
                    titulo = "Title not found";
                    break;
            }
        }
        return titulo;
    }

    /**
     * Devuelve un String con el mensaje "La vacuna no se encunetra en la
     * lista";
     *
     * @return "La vacuna no se encunetra en la lista";
     */
    public static String laVacunaNoSeEncuentraEnLaLista() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "La vacuna no se encunetra en la lista.";

        } else if (idioma.equals("eng")) {
            mensaje = "The vaccine is not on the list. ";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el código de la vacuna: "
     *
     * @return "Introduzca el código de la vacuna: "
     */
    public static String introduzcaElCodigoDeLaVacuna() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el código de la vacuna: ";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter vaccine code: ";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el código de la vacuna: "
     *
     * @return "Introduzca el código de la vacuna: "
     */
    public static String introduzcaElNombreDeLaVacuna() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el nombre de la vacuna:";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter vaccine's name: ";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el principio activo de la
     * vacuna:"
     *
     * @return "Introduzca el principio activo de la vacuna:"
     */
    public static String introduzcaElPrincipioActivoDeLaVacuna() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el principio activo de la vacuna:";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter vaccine's active substance: ";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca la farmacéutica de la
     * vacuna:"
     *
     * @return "Introduzca la farmacéutica de la vacuna:"
     */
    public static String introduzcaLaFarmaceuticaDeLaVacuna() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca la farmacéutica de la vacuna:";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter vaccine's pharmaceutical company: ";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el precio recomendado de la
     * vacuna:"
     *
     * @return "Introduzca el precio recomendado de la vacuna:"
     */
    public static String introduzcaElPrecioRecomendadoDeLaVacuna() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el precio recomendado de la vacuna:";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter vaccine's recommended price: ";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introzuca el código de la vacuna que
     * desea buscar: "
     *
     * @return"Introzuca el código de la vacuna que desea buscar: "
     */
    public static String introduzcaElCodigoDeLaVacunaQueDeseaBuscar() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introzuca el código de la vacuna que desea buscar: ";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter vaccine code to search for:";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el código de la vacuna que
     * desea eliminar: "
     *
     * @return "Introduzca el código de la vacuna que desea eliminar: "
     */
    public static String introduzcaElCodigoDeLaVacunaQueDeseaEliminar() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el código de la vacuna que desea eliminar: ";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter the code of the vaccine you want to delete:";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el código de la vacuna a
     * modificar: "
     *
     * @return "Introduzca el código de la vacuna a modificar: "
     */
    public static String introduzcaElCodigoDeLaVacunaAModificar() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el código de la vacuna a modificar: ";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter the code of the vaccine to be modified:";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Introduzca el código de la vacuna a
     * autorizar o rechazar: "
     *
     * @return "Introduzca el código de la vacuna a autorizar o rechazar: "
     */
    public static String introduzcaElCodigoDeLaVacunaAAutorizarORechazar() {

        String mensaje = "";

        if (idioma.equals("esp")) {
            mensaje = "Introduzca el código de la vacuna a autorizar o rechazar: ";

        } else if (idioma.equals("eng")) {
            mensaje = "Enter the code of the vaccine to authorize or reject:";
        }
        return mensaje;
    }

    /**
     * Se le indica el número de fases que tiene que superar y devuelve un
     * String con un menú con las opciones de las fases a modificar.
     *
     * @param numeroFases
     * @return menú para modificar las fases
     */
    public static String menuModificarFases(int numeroFases) {

        String menu = "";

        if (idioma.equals("esp")) {

            menu = "-------------------------------------------------\n"
                    + "\nIndique el número de la fase que desea modificar:\n\n";
            for (int i = 0; i < numeroFases; i++) {
                menu = menu + (i + 1) + ".Fase " + (i + 1) + "\n";
            }
            menu = menu + "\n0.Volver al menú principal.";

        } else if (idioma.equals("eng")) {

            menu = "-------------------------------------------------\n"
                    + "\nIndicate the number of the phase to be modified\n\n";
            for (int i = 0; i < numeroFases; i++) {
                menu = menu + (i + 1) + ".Phase " + (i + 1) + "\n";
            }
            menu = menu + "\n0.Back to main menu.";
        }
        return menu;
    }

    /**
     * Devuelve un String del menú para elegir entre las opciones de las fases
     * 'Superada' y 'NO superada'.
     *
     * @param numeroFase
     * @return menú superada/no superada
     */
    public static String menuSuperadaNoSuperada(int numeroFase) {

        String menu = "";

        if (idioma.equals("esp")) {

            menu = "-------------------------------------------------\n"
                    + "\nIntroduzca la opción correspondiente a la Fase " + numeroFase + "\n"
                    + "1. Superada\n"
                    + "2. NO Superada";

        } else if (idioma.equals("eng")) {

            menu = "-------------------------------------------------\n"
                    + "\nEnter the option corresponding to Phase " + numeroFase + "\n"
                    + "1. Passed\n"
                    + "2. NOT passed";
        }
        return menu;
    }

    /**
     * Mediante el int numeroFase se indica a qué fase nos queremos referir y
     * con el boolean superada se indica si lo está o no.
     *
     * @param numeroFase
     * @param superada
     * @return String indicando el estado de la fase
     */
    public static String resultadoFase(int numeroFase, boolean superada) {

        String resultado = "";

        if (idioma.equals("esp")) {

            if (superada) {
                resultado = "Fase " + numeroFase + " superada.";
            } else if (!superada) {
                resultado = "Fase " + numeroFase + " NO superada.";
            }

        } else if (idioma.equals("eng")) {

            if (superada) {
                resultado = "Phase " + numeroFase + " passed.";
            } else if (!superada) {
                resultado = "Phase " + numeroFase + " NOT passed.";
            }
        }
        return resultado;
    }

    /**
     * Devuelve un String con las opciones para autorizar o rechazar.
     *
     * @return menú autorizar/rechazar
     */
    public static String menuAutorizarRechazar() {

        String menu = "";

        if (idioma.equals("esp")) {

            menu = "-------------------------------------------------\n"
                    + "\nIndique la opción a llevar a cabo:\n\n"
                    + "1. Autorizar\n"
                    + "2. Rechazar\n\n"
                    + "Intruduzca cualquier otro número para salir sin seleccionar ninguna de las opciones.";

        } else if (idioma.equals("eng")) {

            menu = "-------------------------------------------------\n"
                    + "\nChoose an option: \n\n"
                    + "1. Authorize \n"
                    + "2. Reject \n\n"
                    + "Enter any other number to exit without selecting any of the options.";
        }
        return menu;
    }

    /**
     * Devuelve un String con el mensaje "No ha seleccionado ninguna de las
     * opciones".
     *
     * @return "No ha seleccionado ninguna de las opciones."
     */
    public static String mensajeSwitchDefault() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "ERROR. No ha seleccionado ninguna de las opciones.";

        } else if (idioma.equals("eng")) {

            mensaje = "ERROR. You have not selected any of the options.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "No hay vacunas almacenadas en la
     * lista."
     *
     * @return "No hay vacunas almacenadas en la lista."
     */
    public static String noHayVacunasAlmacenadasEnLaLista() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "No hay vacunas almacenadas en la lista.";

        } else if (idioma.equals("eng")) {

            mensaje = "There are no stored vaccines on the list.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "No hay vacunas autorizadas."
     *
     * @return "No hay vacunas autorizadas."
     */
    public static String noHayVacunasAutorizadas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "No hay vacunas autorizadas.";

        } else if (idioma.equals("eng")) {

            mensaje = "There are no authorized vaccines.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "No hay vacunas rechazadas."
     *
     * @return "No hay vacunas rechazadas."
     */
    public static String noHayVacunasRechazadas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "No hay vacunas rechazadas.";

        } else if (idioma.equals("eng")) {

            mensaje = "There are no rejected vaccines.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "No hay vacunas pendientes de rechazar
     * o autorizar."
     *
     * @return "No hay vacunas pendientes de rechazar o autorizar."
     */
    public static String noHayVacunasPendientesDeRechazarOAutorizar() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "No hay vacunas pendientes de rechazar o autorizar.";

        } else if (idioma.equals("eng")) {

            mensaje = "There are no vaccines pending to reject or authorize.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Vacuna no encontrada."
     *
     * @return "Vacuna no encontrada."
     */
    public static String vacunaNoEncontrada() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Vacuna no encontrada.";

        } else if (idioma.equals("eng")) {

            mensaje = "Vaccine not found.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Vacuna reemplazada."
     *
     * @return "Vacuna no reemplazada."
     */
    public static String vacunaReemplazada() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Vacuna reemplazada.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine has been replaced.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Vacuna eliminada."
     *
     * @return "Vacuna eliminada."
     */
    public static String vacunaEliminada() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Vacuna eliminada.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine has been deleted.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Vacuna autorizada."
     *
     * @return "Vacuna autorizada."
     */
    public static String vacunaAutorizada() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Vacuna autorizada.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine has been authorized.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Vacuna rechazada."
     *
     * @return "Vacuna rechazada."
     */
    public static String vacunaRechazada() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Vacuna rechazada.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine has been rejected.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "La vacuna que desea modificar no
     * existe."
     *
     * @return "La vacuna que desea modificar no existe."
     */
    public static String laVacunaqueDeseaModificarnoExiste() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "La vacuna que desea modificar no existe.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine you want to modify does not exist.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "La vacuna que desea eliminar no
     * existe."
     *
     * @return "La vacuna que desea eliminar no existe."
     */
    public static String laVacunaqueDeseaEliminarnoExiste() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "La vacuna que desea eliminar no existe.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine you want to delete does not exist.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "La vacuna que desea autorizar/rechazar
     * no existe."
     *
     * @return "La vacuna que desea autorizar/rechazar no existe."
     */
    public static String laVacunaqueDeseaAutorizarORechazarnoExiste() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "La vacuna que desea autorizar/rechazar no existe.";

        } else if (idioma.equals("eng")) {

            mensaje = "The vaccine you want to authorize/reject does not exist.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con un mensaje advirtiendo que se pretende almacenar
     * una vacuna con un código que ya pertenece a otra.
     *
     * @return "Los códigos de las vacunas son únicos.En la lista ya hay una
     * vacuna con el mismo código."
     */
    public static String yaHayUnaVacunaConElMismoCodigo() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Los códigos de las vacunas son únicos.\n"
                    + "En la lista ya hay una vacuna con el mismo código.";

        } else if (idioma.equals("eng")) {

            mensaje = "Vaccine codes are unique.\n"
                    + "In the list there is already a vaccine with the same code.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "¿Desea reemplazarla?y/n"
     *
     * @return "¿Desea reemplazarla?y/n"
     */
    public static String deseaReemplazarla() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "¿Desea reemplazarla?y/n";

        } else if (idioma.equals("eng")) {

            mensaje = "Do you want to replace it?y/n";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "No se han producido modificaciones en
     * la lista."
     *
     * @return "No se han producido modificaciones en la lista."
     */
    public static String noSeHanProdicidoModificacionesEnLaLista() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "No se han producido modificaciones en la lista.";

        } else if (idioma.equals("eng")) {

            mensaje = "The list has not been modified.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Volviendo al menú principal..."
     *
     * @return "Volviendo al menú principal..."
     */
    public static String volviendoAlMenuPrincipal() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Volviendo al menú principal...";

        } else if (idioma.equals("eng")) {

            mensaje = "Returning to main menu...";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "No ha superado las 3 fases. La vacuna
     * no puede ser autorizada."
     *
     * @return "No ha superado las 3 fases. La vacuna no puede ser autorizada.";
     */
    public static String noEsPosibleAutorizarLaVacuna() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "No ha superado las 3 fases. La vacuna no puede ser autorizada.";

        } else if (idioma.equals("eng")) {

            mensaje = "It has not passed all 3 phases. The vaccine can not be authorized.";
        }
        return mensaje;
    }

    /**
     * Devuelve un String con el mensaje "Programa finalizado"
     *
     * @return "Programa finalizado"
     */
    public static String programaFinalizado() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "Programa finalizado";

        } else if (idioma.equals("eng")) {

            mensaje = "";
        }
        return mensaje;
    }

}
