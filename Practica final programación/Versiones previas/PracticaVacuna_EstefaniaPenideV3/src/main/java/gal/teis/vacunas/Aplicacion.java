/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import gal.teis.excepciones_controldata.ControlData;
import gal.teis.excepciones_controldata.ErrorFormatoCodigoException;
import gal.teis.excepciones_controldata.FaseAnteriorNoSuperadaException;
import gal.teis.excepciones_controldata.FaseYaInvestigadaException;
import gal.teis.excepciones_controldata.VacunaYaEvaluadaException;
import gal.teis.excepciones_controldata.VacunasIgualesException;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Inicializo una vacuna vacía que servirá para comprarla con los resultados devueltos por métodos de VacAlmacen.
        Vacuna vacuna = new Vacuna();

        Scanner input = new Scanner(System.in);

        int opcion;
        do {

            System.out.println("-------------------------------------------------");
            System.out.println("\tGESTIÓN DE LAS VACUNAS CONTRA EL COVID");
            System.out.println("");
            System.out.println("Introduzca el número de la acción a realizar:");
            System.out.println("");
            System.out.println("1. Listar todas las vacunas mostrando sus datos.");
            System.out.println("2. Buscar vacuna.");
            System.out.println("3. Agregar vacuna.");
            System.out.println("4. Eliminar vacuna.");
            System.out.println("5. Introducir resultado de las fases de la vacuna.");
            System.out.println("6. Autorizar/Rechazar vacuna.");
            System.out.println("7. Ver vacunas autorizadas.");
            System.out.println("8. Ver vacunas rechazadas.");
            System.out.println("9. Ver vacunas pendientes de autorizar/rechazar.");
            System.out.println("10. Ver la última fase de investigación de cada vacuna almacenada.");
            System.out.println("");
            System.out.println("0. Salir.");

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    System.out.println("VACUNAS ALMACENADAS:");

                    //Si el ArrayList<Vacuna> almacen está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.listarVacunasAlmacen().isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        //En caso contrario imprime cada una de las vacunas del almacén mediante un foreach.
                        for (Vacuna vac : VacAlmacen.listarVacunasAlmacen()) {
                            System.out.println(vac);
                        }
                    }
                    break;
                case 2:
                    int a;
                    //Menú para elegir el criterio de búsqueda
                    do {

                        System.out.println("-------------------------------------------------");
                        System.out.println("\tBUSCAR VACUNA");
                        System.out.println("");
                        System.out.println("Introduzca el número de la acción a realizar:");
                        System.out.println("");
                        System.out.println("1. Buscar por código.");
                        System.out.println("2. Buscar por nombre.");
                        System.out.println("3. Buscar por principio activo.");
                        System.out.println("4. Buscar por farmacética.");
                        System.out.println("5. Buscar por precio recomendado.");
                        System.out.println("");
                        System.out.println("0. Volver al menú principal.");

                        a = ControlData.leerInt(input);

                        switch (a) {
                            case 1:
                                System.out.println("BUSQUEDA POR CÓDIGO");

                                System.out.println("Introduzca el código de la vacuna que desea buscar:");
                                String codigo = ControlData.leerString(input);

                                //Si 'codigo' es igual a alguno de los del ArrayList<Vacuna> almacen, devuelve esa vacuna, 
                                //si no lo es, devuelve una vacuna vacía.
                                VacAlmacen.buscarVacunaCodigo(codigo);

                                //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                                if (VacAlmacen.buscarVacunaCodigo(codigo).equals(vacuna)) {
                                    //En este caso devuelve un mensaje diciendo que no ha encontrado la vacuna.
                                    System.out.println("La vacuna no se encuentra en la lista.");
                                } else {
                                    //En cualquier otro caso, devuelve la vacuna.
                                    System.out.println(VacAlmacen.buscarVacunaCodigo(codigo));
                                }
                                break;
                            case 2:
                                System.out.println("BUSQUEDA POR NOMBRE");

                                System.out.println("Introduzca el nombre de la vacuna que desea buscar:");
                                String nombre = ControlData.leerString(input);

                                //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
                                if (VacAlmacen.buscarVacunaNombre(nombre).isEmpty()) {
                                    System.out.println("La vacuna no se encuentra en la lista.");
                                } else {
                                    //Si no lo está, devuelve cada vacuna alamcenada en el con un foreach.
                                    for (Vacuna vac : VacAlmacen.buscarVacunaNombre(nombre)) {
                                        System.out.println(vac);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("BUSQUEDA POR PRINCIPIO ACTIVO");

                                System.out.println("Introduzca el principio activo de la vacuna que desea buscar:");
                                String principioActivo = ControlData.leerString(input);

                                //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
                                if (VacAlmacen.buscarVacunaPrincipioActivo(principioActivo).isEmpty()) {
                                    System.out.println("La vacuna no se encuentra en la lista.");
                                } else {
                                    //Si no lo está, devuelve cada vacuna alamcenada en el con un foreach.
                                    for (Vacuna vac : VacAlmacen.buscarVacunaPrincipioActivo(principioActivo)) {
                                        System.out.println(vac);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("BUSQUEDA POR FARMACEÚTICA");

                                System.out.println("Introduzca la farmaceútica de la vacuna que desea buscar:");
                                String famaceutica = ControlData.leerString(input);

                                //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
                                if (VacAlmacen.buscarVacunaFarmaceutica(famaceutica).isEmpty()) {
                                    System.out.println("La vacuna no se encuentra en la lista.");
                                } else {
                                    //Si no lo está, devuelve cada vacuna alamcenada en el con un foreach.
                                    for (Vacuna vac : VacAlmacen.buscarVacunaFarmaceutica(famaceutica)) {
                                        System.out.println(vac);
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("BUSQUEDA POR PRECIO RECOMENDADO");

                                System.out.println("Introduzca el precio recomendado de la vacuna que desea buscar:");
                                double precioRecomendado = ControlData.leerDouble(input);

                                //Si el ArrayList<Vacuna> resultadoBusqueda está vacío, devuelve un mensaje indicándolo.
                                if (VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado).isEmpty()) {
                                    System.out.println("La vacuna no se encuentra en la lista.");
                                } else {
                                    //Si no lo está, devuelve cada vacuna almacenada en él con un foreach.
                                    for (Vacuna vac : VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado)) {
                                        System.out.println(vac);
                                    }
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                break;

                        }
                    } while (a != 0);
                    break;
                case 3:
                    System.out.println("AGREGAR VACUNA");

                    //Se crea una vacuna provisional a la que asignarle el código que se introduzca por pantalla.
                    Vacuna vacunaCodigo = new Vacuna();

                    String codigo = "";
                    do {
                        System.out.println("Introduzca el código de la vacuna:");
                        codigo = ControlData.leerString(input);
                        try {
                            vacunaCodigo.setCodigo(codigo);
                            //Si el código no cumple los requistos de formato, salta la excepción, 
                            //quedándose vacunaCodigo con el String codigo como una cadena vacía.
                        } catch (ErrorFormatoCodigoException e) {
                            System.out.println(e.getMessage());
                        }
                        //Mientras vacunaCodigo tenga codigo como una cadena vacía, 
                        //será igual a vacuna creada al principio del main y se repetirá el bucle.
                    } while (vacunaCodigo.equals(vacuna));

                    //Solo se saldrá del bucle cuando el código tenga un formato apropiado.
                    //Se piden el resto de datos por pantalla
                    System.out.println("Introduzca el nombre de la vacuna:");
                    String nombre = ControlData.leerString(input);
                    System.out.println("Introduzca el principio activo de la vacuna:");
                    String principioActivo = ControlData.leerString(input);
                    System.out.println("Introduzca la farmacéutica de la vacuna:");
                    String farmaceutica = ControlData.leerString(input);
                    System.out.println("Introduzca el precio recomendado de la vacuna:");
                    double precioRecomendado = ControlData.leerDouble(input);

                    //Se crea la vacuna nueva con los datos introducidos, incluído el código.
                    Vacuna nuevaVacuna = new Vacuna(codigo, nombre, principioActivo, farmaceutica, precioRecomendado);

                    //Me aseguro de que en la variable alamcén de la clase VacAlmacen no se almacenen vacunas iguales, esto es, que tengan el
                    //el mismo código. Este control es necesario pues en el método buscarVacunaCodigo devuelve sólo una Vacuna (frente a los
                    //otros métodos de búsqueda que devuelven un ArrayList<Vacuna>).Para que este método funcione y pueda devolver sólo una vacuna
                    //sin producirse errores, arrojo una excepción cuando se introduzca una vacuna con un código que ya está
                    //en el alamcén y no permito que esta nueva vacuna se añada a la lista.
                    boolean comparador = false;
                    try {
                        for (Vacuna vac : VacAlmacen.listarVacunasAlmacen()) {
                            if (vac.equals(nuevaVacuna)) {
                                comparador = true;
                                throw new VacunasIgualesException();
                            } else {
                                comparador = false;
                            }
                        }
                    } catch (VacunasIgualesException e) {
                        System.out.println(e.getMessage());
                    }
                    if (!comparador) {
                        VacAlmacen.agregarVacuna(nuevaVacuna);
                    }

                    break;
                case 4:
                    System.out.println("ELIMINAR VACUNA");

                    System.out.println("Introduzca el código de la vacuna a eliminar:");
                    String codigoEliminar = ControlData.leerString(input);

                    //Si 'codigoEliminar' es igual a alguno de los del ArrayList<Vacuna> almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoEliminar);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoEliminar).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no ha encontrado la vacuna.
                        System.out.println("La vacuna que solicita eliminar no existe.");
                    } else {
                        //En cualquier otro caso, devuelve la vacuna.
                        VacAlmacen.eliminarVacuna(VacAlmacen.buscarVacunaCodigo(codigoEliminar));
                        System.out.println("Vacuna eliminada de la lista.");
                    }
                    break;
                case 5:
                    System.out.println("INTRODUCIR RESULTADO FASES");

                    System.out.println("Introduzca el código vacuna a modificar:");
                    String codigoCambioFases = ControlData.leerString(input);

                    //Si 'codigoCambioFases' es igual a alguno de los del ArrayList<Vacuna> almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoCambioFases);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoCambioFases).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no existe la vacuna en la lista.
                        System.out.println("La vacuna que desea modificar no existe.");
                    } else {
                        //En cualquier otro caso, la vacuna está en la lista y se le pueden aplicar cambios.
                        int b;
                        do {

                            System.out.println("\nIndique el número de la fase que desea modificar.\n");
                            System.out.println("1. Fase 1");
                            System.out.println("2. Fase 2");
                            System.out.println("3. Fase 3");
                            System.out.println("\n0. Volver al menú principal.");

                            b = ControlData.leerInt(input);

                            switch (b) {
                                case 1:

                                    System.out.println("\nIntroduzca la opción correspndiente a la Fase 1:\n");
                                    System.out.println("1. Superada");
                                    System.out.println("2. NO Superada");

                                    int c = ControlData.leerInt(input);

                                    switch (c) {
                                        case 1:
                                            //Si ya se ha evaluado como superada o no superada, salta una excepción.
                                            try {
                                            //Marca la fase de la vacuna como superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase1Superada(true);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println("Fase 1 superada.");
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
                                            System.out.println("Fase 1 NO superada.");
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                            break;
                                    }
                                    break;
                                case 2:

                                    System.out.println("\nIntroduzca la opción correspndiente a la Fase 2:\n");
                                    System.out.println("1. Superada");
                                    System.out.println("2. NO Superada");

                                    int d = ControlData.leerInt(input);

                                    switch (d) {
                                        case 1:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido evaluada, salta otra.
                                            try {

                                            //Marca la fase de la vacuna como superada.   
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(true);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println("Fase 2 superada.");

                                        } catch (FaseAnteriorNoSuperadaException e) {
                                            System.out.println(e.getMessage());
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        case 2:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido evaluada, salta otra.
                                            try {

                                            //Marca la fase de la vacuna como no superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(false);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println("Fase 2 NO superada.");

                                        } catch (FaseAnteriorNoSuperadaException e) {
                                            System.out.println(e.getMessage());
                                        } catch (FaseYaInvestigadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                            break;
                                    }
                                    break;
                                case 3:

                                    System.out.println("\nIntroduzca la opción correspndiente a la Fase 3:\n");
                                    System.out.println("1. Superada");
                                    System.out.println("2. NO Superada");

                                    int e = ControlData.leerInt(input);

                                    switch (e) {
                                        case 1:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido evaluada, salta otra.
                                            try {

                                            //Marca la fase de la vacuna como superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(true);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println("Fase 3 superada.");

                                        } catch (FaseAnteriorNoSuperadaException ex) {
                                            System.out.println(ex.getMessage());
                                        } catch (FaseYaInvestigadaException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                        case 2:
                                            //Si no tiene la fase anterior superada salta una excepción. Y si ya ha sido evaluada, salta otra.
                                            try {

                                            //Marca la fase de la vacuna como no superada.
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(false);
                                            //Muestra un mensaje que confirma la acción realizada.
                                            System.out.println("Fase 3 NO superada.");

                                        } catch (FaseAnteriorNoSuperadaException ex) {
                                            System.out.println(ex.getMessage());
                                        } catch (FaseYaInvestigadaException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                            break;
                                    }
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                default:
                                    System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                    break;
                            }
                        } while (b != 0);
                    }
                    break;
                case 6:
                    System.out.println("AUTORIZAR/RECHAZAR VACUNA");

                    System.out.println("Introduzca el código vacuna a autorizar o rechazar:");
                    String codigoAutotizarRechazar = ControlData.leerString(input);

                    //Si 'codigoAutotizarRechazar' es igual a alguno de los del ArrayList<Vacuna> almacen, devuelve esa vacuna, 
                    //si no lo es, devuelve una vacuna vacía.
                    VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar);

                    //Si ha devuelto una vacuna vacía, será igual a la vacuna vacía creada al principio del main.
                    if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).equals(vacuna)) {
                        //En este caso devuelve un mensaje diciendo que no existe la vacuna en la lista.
                        System.out.println("La vacuna que desea autorizar/rechazar no existe.");
                    } else {

                        //En cualquier otro caso la vacuna existe y se imprime el menú para autorizarla o rechazarla.
                        System.out.println("\nIndique la opción a llevar a cabo:");
                        System.out.println("1. Autorizar");
                        System.out.println("2. Rechazar");
                        System.out.println("Intruduzca cualquier número para salir sin seleccionar ninguna de las opciones.");

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
                                    System.out.println("Vacuna autorizada.");
                                } else {
                                    //Si no ha sido así será por no tener las tres fases superadas y se imprime un mensaje advirtiendo que no fue
                                    //posible autorizarla.
                                    System.out.println("No es posible autorizar la vacuna, ya que no ha superado las 3 fases.");
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
                                    System.out.println("Vacuna rechazada.");
                                }
                            } catch (VacunaYaEvaluadaException i) {
                                System.out.println(i.getMessage());
                            }
                            break;
                            default:
                                System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("VACUNAS AUTORIZADAS");

                    //Si el ArrayList<Vacuna> vacunasAutorizadas está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verVacunasAutorizadas().isEmpty()) {
                        System.out.println("No hay vacunas autorizadas.");
                    } else {
                        //Si no lo está, devuelve cada vacuna almacenada en él con un foreach.
                        for (Vacuna vac : VacAlmacen.verVacunasAutorizadas()) {
                            System.out.println(vac);
                        }
                    }
                    break;
                case 8:
                    System.out.println("VACUNAS RECHAZADAS");

                    //Si el ArrayList<Vacuna> vacunasRechazadas está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verVacunasRechazadas().isEmpty()) {
                        System.out.println("No hay vacunas rechazadas.");
                    } else {
                        //Si no lo está, devuelve cada vacuna almacenada en él con un foreach.
                        for (Vacuna vac : VacAlmacen.verVacunasRechazadas()) {
                            System.out.println(vac);
                        }
                    }
                    break;
                case 9:
                    System.out.println("VACUNAS PENDIENTES DE AUTORIZAR/RECHAZAR");

                    //Si el ArrayList<Vacuna> vacunasPendientesAutorizarRechazar está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verVacunasPendientesAutorizarRechazar().isEmpty()) {
                        System.out.println("No hay vacunas pendientes de autorizar o rechazar.");
                    } else {
                        //Si no lo está, devuelve cada vacuna almacenada en él con un foreach.
                        for (Vacuna vac : VacAlmacen.verVacunasPendientesAutorizarRechazar()) {
                            System.out.println(vac);
                        }
                    }
                    break;
                case 10:
                    System.out.println("ÚLTIMA FASE DE INVESTIGACIÓN");

                    //Si el String ultimaFaseInvestigadaVacuna está vacío, devuelve un mensaje indicándolo.
                    if (VacAlmacen.verUltimaFaseInvestigadaVacunas().isEmpty()) {
                        System.out.println("No hay vacunas almacenadas en la lista.");
                    } else {
                        //Si no lo está, lo imprime directamente porque ya está en un formato adecuado.
                        System.out.println(VacAlmacen.verUltimaFaseInvestigadaVacunas());
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                    break;
            }
        } while (opcion != 0);

        input.close();
    }
}
