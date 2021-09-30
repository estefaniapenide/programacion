/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.practicavacuna_estefaniapenidev4;

import gal.teis.excepciones_y_controltipos.ControlData;
import gal.teis.excepciones_y_controltipos.ErrorFormatoCodigoException;
import gal.teis.excepciones_y_controltipos.FaseAnteriorNoSuperadaException;
import gal.teis.excepciones_y_controltipos.VacunaYaEvaluadaException;
import gal.teis.excepciones_y_controltipos.VacunasIgualesException;
import java.time.LocalDate;
import java.util.ArrayList;
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
                    if (VacAlmacen.listarVacunasAlmacen().isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        Collection<Vacuna> collection = VacAlmacen.listarVacunasAlmacen().values();
                        Iterator<Vacuna> it = collection.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                    }
                    break;
                case 2:
                    int a;
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
                                VacAlmacen.buscarVacunaCodigo(codigo);
                                if (VacAlmacen.buscarVacunaCodigo(codigo).getCodigo().equals("")) {
                                    System.out.println("La vacuna no se encuentra en la lista.");
                                } else {
                                    System.out.println(VacAlmacen.buscarVacunaCodigo(codigo));
                                }
                                break;
                            case 2:
//                                System.out.println("BUSQUEDA POR NOMBRE");
//                                System.out.println("Introduzca el nombre de la vacuna que desea buscar:");
//                                String nombre = ControlData.leerString(input);
//                                if (VacAlmacen.buscarVacunaNombre(nombre).isEmpty()) {
//                                    System.out.println("La vacuna no se encuentra en la lista.");
//                                } else {
//                                    for (Vacuna vac : VacAlmacen.buscarVacunaNombre(nombre)) {
//                                        System.out.println(vac);
//                                    }
//                                }
                                break;
                            case 3:
//                                System.out.println("BUSQUEDA POR PRINCIPIO ACTIVO");
//                                System.out.println("Introduzca el principio activo de la vacuna que desea buscar:");
//                                String principioActivo = ControlData.leerString(input);
//                                if (VacAlmacen.buscarVacunaPrincipioActivo(principioActivo).isEmpty()) {
//                                    System.out.println("La vacuna no se encuentra en la lista.");
//                                } else {
//                                    for (Vacuna vac : VacAlmacen.buscarVacunaPrincipioActivo(principioActivo)) {
//                                        System.out.println(vac);
//                                    }
//                                }
                                break;
                            case 4:
//                                System.out.println("BUSQUEDA POR FARMACEÚTICA");
//                                System.out.println("Introduzca la farmaceútica de la vacuna que desea buscar:");
//                                String famaceutica = ControlData.leerString(input);
//                                if (VacAlmacen.buscarVacunaFarmaceutica(famaceutica).isEmpty()) {
//                                    System.out.println("La vacuna no se encuentra en la lista.");
//                                } else {
//                                    for (Vacuna vac : VacAlmacen.buscarVacunaFarmaceutica(famaceutica)) {
//                                        System.out.println(vac);
//                                    }
//                                }
                                break;
                            case 5:
//                                System.out.println("BUSQUEDA POR PRECIO RECOMENDADO");
//                                System.out.println("Introduzca el precio recomendado de la vacuna que desea buscar:");
//                                double precioRecomendado = ControlData.leerDouble(input);
//                                if (VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado).isEmpty()) {
//                                    System.out.println("La vacuna no se encuentra en la lista.");
//                                } else {
//                                    for (Vacuna vac : VacAlmacen.buscarVacunaPrecioRecomendado(precioRecomendado)) {
//                                        System.out.println(vac);
//                                    }
//                                }
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

                    vacuna = new Vacuna();
                    String codigo = "";
                    do {
                        System.out.println("Introduzca el código de la vacuna:");
                        codigo = ControlData.leerString(input);
                        try {
                            vacuna.setCodigo(codigo);
                        } catch (ErrorFormatoCodigoException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (vacuna.getCodigo().equals(""));
                    System.out.println("Introduzca el nombre de la vacuna:");
                    String nombre = ControlData.leerString(input);
                    System.out.println("Introduzca el principio activo de la vacuna:");
                    String principioActivo = ControlData.leerString(input);
                    System.out.println("Introduzca la farmacéutica de la vacuna:");
                    String farmaceutica = ControlData.leerString(input);
                    System.out.println("Introduzca el precio recomendado de la vacuna:");
                    double precioRecomendado = ControlData.leerDouble(input);

                    vacuna = new Vacuna(codigo, nombre, principioActivo, farmaceutica, precioRecomendado);

                    VacAlmacen.buscarVacunaCodigo(codigo);
                    if (VacAlmacen.buscarVacunaCodigo(codigo).equals(vacuna)) {
                        System.out.println("Los códigos de las vacunas son únicos.\n"
                                + "En la lista ya hay una vacuna con el mismo código.");
                        char respuesta;
                        do {
                            System.out.println("¿Desea reemplazarla?s/n");
                            respuesta = ControlData.leerChar(input);
                            switch (respuesta) {
                                case 's':
                                    VacAlmacen.agregarVacuna(codigo, vacuna);
                                    System.out.println("Vacuna reemplazada.");
                                    break;
                                case 'n':
                                    System.out.println("No se han producido modificaciones en la lista.");
                                    break;
                                default:
                                    System.out.println("El caracter introducido no se corresponde con ninguna de las opciones.");
                                    break;
                            }
                        } while (!(respuesta == 's' || respuesta == 'n'));
                    } else {
                        VacAlmacen.agregarVacuna(codigo, vacuna);
                    }

                    break;
                case 4:
                    System.out.println("ELIMINAR VACUNA");
                    System.out.println("Introduzca el código de la vacuna a eliminar:");
                    String codigoEliminar = ControlData.leerString(input);
                    VacAlmacen.buscarVacunaCodigo(codigoEliminar);
                    if (VacAlmacen.buscarVacunaCodigo(codigoEliminar).getCodigo().equals("")) {
                        System.out.println("La vacuna que solicita eliminar no existe.");
                    } else {
                        VacAlmacen.eliminarVacuna(codigoEliminar);
                        System.out.println("Vacuna eliminada de la lista.");
                    }
                    break;
                case 5:
                    System.out.println("INTRODUCIR RESULTADO FASES");
                    System.out.println("Introduzca el código vacuna a modificar:");
                    String codigoCambioFases = ControlData.leerString(input);
                    VacAlmacen.buscarVacunaCodigo(codigoCambioFases);
                    if (VacAlmacen.buscarVacunaCodigo(codigoCambioFases).getCodigo().equals("")) {
                        System.out.println("La vacuna que desea modificar no existe.");
                    } else {
                        int b;
                        do {
                            System.out.println("Indique el número de la fase que desea modificar.");
                            System.out.println("1. Fase 1");
                            System.out.println("2. Fase 2");
                            System.out.println("3. Fase 3");
                            System.out.println("0. Volver al menú principal.");
                            b = ControlData.leerInt(input);
                            switch (b) {
                                case 1:
                                    System.out.println("Introduzca la opción correspndiente a la Fase 1");
                                    System.out.println("1. Superada");
                                    System.out.println("2. NO Superada");
                                    int c = ControlData.leerInt(input);
                                    switch (c) {
                                        case 1:
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase1Superada(true);
                                            System.out.println("Fase 1 superada.");
                                            break;
                                        case 2:
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase1Superada(false);
                                            System.out.println("Fase 1 NO superada.");
                                            break;
                                        default:
                                            System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                            break;
                                    }
                                    break;
                                case 2:
                                    System.out.println("Introduzca la opción correspndiente a la Fase 2");
                                    System.out.println("1. Superada");
                                    System.out.println("2. NO Superada");
                                    int d = ControlData.leerInt(input);
                                    switch (d) {
                                        case 1:
                                            try {
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(true);
                                            System.out.println("Fase 2 superada.");
                                        } catch (FaseAnteriorNoSuperadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        case 2:
                                            try {
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase2Superada(false);
                                            System.out.println("Fase 2 NO superada.");
                                        } catch (FaseAnteriorNoSuperadaException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                        default:
                                            System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.println("Introduzca la opción correspndiente a la Fase 3");
                                    System.out.println("1. Superada");
                                    System.out.println("2. NO Superada");
                                    int e = ControlData.leerInt(input);
                                    switch (e) {
                                        case 1:
                                            try {
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(true);
                                            System.out.println("Fase 3 superada.");
                                        } catch (FaseAnteriorNoSuperadaException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                        case 2:
                                            try {
                                            VacAlmacen.buscarVacunaCodigo(codigoCambioFases).setFase3Superada(false);
                                            System.out.println("Fase 3 NO superada.");
                                        } catch (FaseAnteriorNoSuperadaException ex) {
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
                    VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar);
                    if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).getCodigo().equals("")) {
                        System.out.println("La vacuna que desea autorizar/rechazar no existe.");
                    } else {
                        System.out.println("Indique la opción a llevar a cabo:");
                        System.out.println("1. Autorizar");
                        System.out.println("2. Rechazar");
                        int e = ControlData.leerInt(input);
                        switch (e) {
                            case 1:
                                try {
                                VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).autorizar();
                                if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).comprobacionVacunaAutorizada()) {
                                    System.out.println("Vacuna autorizada.");
                                } else {
                                    System.out.println("No es posible autorizar la vacuna, ya que no ha superado las 3 fases.");
                                }
                            } catch (VacunaYaEvaluadaException i) {
                                System.out.println(i.getMessage());
                            }
                            break;
                            case 2:
                                try {
                                VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).rechazar();
                                if (VacAlmacen.buscarVacunaCodigo(codigoAutotizarRechazar).comprobacionVacunaRechazada()) {
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
                    if (VacAlmacen.verVacunasAutorizadas().isEmpty()) {
                        System.out.println("No hay vacunas autorizadas.");
                    } else {
                        for (String key : VacAlmacen.verVacunasAutorizadas().keySet()) {
                            System.out.println(VacAlmacen.verVacunasAutorizadas().get(key));
                        }
                    }
                    break;
                case 8:
                    System.out.println("VACUNAS RECHAZADAS");
                    if (VacAlmacen.verVacunasRechazadas().isEmpty()) {
                        System.out.println("No hay vacunas rechazadas.");
                    } else {
                        for (String key : VacAlmacen.verVacunasRechazadas().keySet()) {
                            System.out.println(VacAlmacen.verVacunasRechazadas().get(key));
                        }
                    }
                    break;
                case 9:
                    System.out.println("VACUNAS PENDIENTES DE AUTORIZAR/RECHAZAR");
                    if (VacAlmacen.verVacunasPendientesAutorizarRechazar().isEmpty()) {
                        System.out.println("No hay vacunas pendientes de autorizar o rechazar.");
                    } else {
                        for (String key : VacAlmacen.verVacunasPendientesAutorizarRechazar().keySet()) {
                            System.out.println(VacAlmacen.verVacunasPendientesAutorizarRechazar().get(key));
                        }
                    }
                    break;
                case 10:
                    System.out.println("ÚLTIMA FASE DE INVESTIGACIÓN");
                    if (VacAlmacen.verUltimaFaseInvestigadaVacunas().isEmpty()) {
                        System.out.println("No hay vacunas almacenadas en la lista.");
                    } else {
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
