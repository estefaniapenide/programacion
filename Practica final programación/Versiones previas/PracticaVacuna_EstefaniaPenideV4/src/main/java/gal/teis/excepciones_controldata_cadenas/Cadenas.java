/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata_cadenas;

/**
 * Contiene los métodos con la mayoría de los Strings que sesacarán por pantalla
 * a partir de Aplicación.
 *
 * @author Estefania
 */
public class Cadenas {

    /**
     * Devuelve un String del menú principal con las opciones a elegir de todas
     * las acciones que se peuden hacer con el programa.
     *
     * @return menú principal
     */
    public static String menuGestionVacunas() {
        return "-------------------------------------------------\n"
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
                + "0. Salir.";
    }

    /**
     * Devuelve un String del título de la opción del menú que se le indica.
     *
     * @param opcion
     * @return titulo
     */
    public static String titulo(int opcion) {
        String titulo;
        switch (opcion) {
            case 1:
                titulo = "VACUNAS ALMACENADAS:";
                break;
            case 2:
                titulo = "BUSQUEDA POR CÓDIGO";
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
            default:
                titulo = "Título no encontardo";
                break;
        }
        return titulo;
    }

    /**
     * Devuelve el String a completar "Introduzca el código de la vacuna ..."
     *
     * @param completaFrase
     * @return "Introduzca el código de la vacuna ..."
     */
    public static String introduzcaElCodigoDeLaVacuna(String completaFrase) {
        return "Introduzca el código de la vacuna " + completaFrase;
    }

    /**
     * Devuelve el String a completar "Introduzca ... de la vacuna."
     *
     * @param completar
     * @return "Introduzca ... de la vacuna."
     */
    public static String introduzca______DeLaVacuna(String completar) {
        return "Introduzca " + completar + " de la vacuna:";
    }

    /**
     * Se le indica el número de fases que tiene que superar y devuelve un
     * String con un menú con las opciones de las fases a modificar.
     *
     * @param numeroFases
     * @return menú para modificar las fases
     */
    public static String menuModificarFases(int numeroFases) {
        String menu = "\nIndique el número de la fase que desea modificar:\n\n";
        for (int i = 0; i < numeroFases; i++) {
            menu = menu + (i + 1) + ".Fase " + (i + 1) + "\n";
        }
        menu = menu + "\n0.Volver al menú principal.";
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
        return "\nIntroduzca la opción correspndiente a la Fase " + numeroFase + "\n"
                + "1. Superada\n"
                + "2. NO Superada";
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
        if (superada) {
            resultado = "Fase " + numeroFase + " superada.";
        } else if (!superada) {
            resultado = "Fase " + numeroFase + " NO superada.";
        }
        return resultado;
    }

    /**
     * Devuelve un String con las opciones para autorizar o rechazar.
     *
     * @return menú autorizar/rechazar
     */
    public static String menuAutorizarRechazar() {
        return "\nIndique la opción a llevar a cabo:\n\n"
                + "1. Autorizar\n"
                + "2. Rechazar\n\n"
                + "Intruduzca cualquier número para salir sin seleccionar ninguna de las opciones.";
    }

    /**
     * Devuelve un String con el mensaje "No ha seleccionado ninguna de las
     * opciones".
     *
     * @return "No ha seleccionado ninguna de las opciones."
     */
    public static String mensajeSwitchDefault() {
        return "No ha seleccionado ninguna de las opciones.";
    }

    /**
     * Devuelve el String a completar "No hay vacunas ...".
     *
     * @param completarFrase
     * @return "No hay vacunas ...".
     */
    public static String noHayVacunas(String completarFrase) {
        return "No hay vacunas " + completarFrase;

    }

    /**
     * Devuelve el String a completar "Vacuna ...".
     *
     * @param completarFrase
     * @return "Vacuna ..."
     */
    public static String vacuna(String completarFrase) {
        return "Vacuna " + completarFrase;
    }

    /**
     * Devuelve el String a completar "La vacuna que desea ... no existe.".
     *
     * @param completar
     * @return "La vacuna que desea ... no existe."
     */
    public static String laVacunaqueDesea______noExiste(String completar) {
        return "La vacuna que desea " + completar + " no existe.";
    }

}
