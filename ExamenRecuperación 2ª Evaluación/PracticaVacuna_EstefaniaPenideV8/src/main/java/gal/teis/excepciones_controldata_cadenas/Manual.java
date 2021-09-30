/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones_controldata_cadenas;

/**
 * Métodos con la descripción del funcionamiento de cada apartado del menú.
 *
 * @author a20estefaniapc
 */
public class Manual {

    public static String idioma = "esp";
    
    /**
     * Instrucciones para la elección del idioma.
     * @return 
     */
    public static String Idioma() {
        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\nIDIOMAS\n"
                    + "Al mismo iniciar el programa se accede a un menú para escoger el idioma. Se puede elegir entre español\n"
                    + "e inglés. Si no se escoge ninguna de las opciones, introduciéndo cualquier número, el programa empleará\n"
                    + "por defecto español. Si introduce cualquier otro caracter que no sea un número entero, el programa\n"
                    + "devolverá un mensaje de error.\n"
                    + "Todos los mesajes que se muestran por pantalla(salvo las excepciones) son llamados o desde la Clase Cadenas,\n"
                    + "ControlData, VacunaAutorización, Vacuna o Manual. En todas ellas se ha definido una variable estática que está inicializada\n"
                    + "a español. Y esta variable se consulta en todos los métodos para ver qué mensaje mostrar por pantalla (el que está en inglés\n"
                    + "o el que está en español.)\n"
                    + "Sin embargo, los mensajes de las excepciones salen por duplicado en ambos idiomas independientemente del escogido\n"
                    + "por el usuario.";

        } else if (idioma.equals("eng")) {

            mensaje = "\nLANGUAGES\n"
                    + "At the begining, you get accessed a menu to choose the language. You can choose between Spanish\n"
                    + "or English. If none of the options is chosen, by entering any number, the program will use\n"
                    + "by default Spanish. If you enter any other character that is not an integer, the program\n"
                    + "will return an error message.\n"
                    + "All the messages that are shown on the screen (except for the exceptions) are called or from Class Cadenas,\n"
                    + "ControlData, VacunaAutorizacion, Vacuna or Manual. In all of them a static variable has been defined that is initialized\n"
                    + "to Spanish. And this variable is consulted in all the methods to see which message must be displayed on the screen (the one in English\n"
                    + "or the one in Spanish.)\n"
                    + "However, the exception messages come out in duplicate in both languages ​​regardless of the one chosen\n"
                    + "by the user.";
        }
        return mensaje;
    }
    
    /**
     * Instrucciones funcionamiento opción del menú 1. LISTAR VACUNAS.
     * @return 
     */
    public static String listarVacunas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n1. LISTAR VACUNAS\n"
                    + "Muestra todas las vacunas almacenadas, con su código, nombre, principio activo, farmacéutica y percio recomendado. También se indica\n"
                    + "si han sido rechazadas, autorizadas o están pendientes de autorizar o rechazar.\n"
                    + "En caso de que no se haya almacenado ninguna vacuna, se mostrará un mensaje indicando que la lista está vacía.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n1. LIST VACCINES\n"
                    + "Shows all stored vaccines, with their code, name, active substance, pharmaceutical company and recommended price.\n"
                    + "Whether they have been rejected, authorized or are pending to authorize or reject.\n"
                    + "In case no vaccine has been stored, a message will be displayed indicating that the list is empty.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 2. BUSCAR VACUNAS.
     * @return 
     */
    public static String buscarVacunas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n2. BUSCAR VACUNAS\n"
                    + "Se accede a un menú donde se pude elegir el criterio de búsqueda:\n"
                    + "Por código: devuelve un únici resultado, pues cada vacuna debe tener un código distinto para poder ser almacenada.\n"
                    + "Por nombre, por principio activo, por farmacéutica o por precio recomendado: devuelve todas las vacunas con las que hay equivalencia\n"
                    + "con el dato introducido.\n"
                    + "El formato empleado para mostrar las vacunas es el mismo que en LISTAR VACUNAS.\n"
                    + "En caso de no encontrarse coincidencia con ninguna de las vacunas almacenadas, se muestra un mensaje indicándolo.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n2. SEARCH VACCINES\n"
                    + "You accessed to a menu where you can choose the search criteria:\n"
                    + "By code: since each vaccine must have a different code to be stored,it returns a single result.\n"
                    + "By name, by active substance, by pharmaceutical company or by recommended price: returns all vaccines whicht match\n"
                    + "the data entered.\n"
                    + "The format used to display the vaccines is the same as in LIST VACCINES.\n"
                    + "If no match is found with any of the stored vaccines, a message is displayed indicating it.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 3. AGREGAR VACUNAS.
     * @return 
     */
    public static String agregarVacunas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n3. AGREGAR VACUNAS\n"
                    + "Para agregar una vacuna se pide primero el código que se le quiere asignar. Este debe ceñirse al siguiente formato:\n"
                    + "\tComenzará por la letra V seguida de una vocal en mayúsculas.\n"
                    + "\tA continuación, tres o cuatro letras minúsculas.\n"
                    + "\tFinaliza, o con dos números del 4 al 7, o bien con el número 8.\n"
                    + "Una vez escogido un código apropiado, se comprueba si ya hay o no una vacuna almacenada con ese mismo código.\n"
                    + "Si no existe, se pedirán el resto de datos (nombre, principio activo, farmacéutica y precio recomendado) y se añadirá a la lista.\n"
                    + "Si el código ya pertenece a otra vacuna, se le preguntará al usuario si desea reemplazar la vacuna ya existente. En caso afirmativo\n"
                    + "se pedirán el resto de datos de la vacuna nueva y esta reemplazará a la vacuna con el mismo código. En caso de no querer reemplazarla\n"
                    + "se volverá al menú principal.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n3. ADD VACCINES\n"
                    + "In order to add a vaccine, first the program asks for the code you want to assign to it. This must adhere to the following format:\n"
                    + "\tStart with the letter V followed by an uppercase vowel.\n"
                    + "\tThen three or four lowercase letters.\n"
                    + "\tEnd, either with two numbers from 4 to 7, or with the number 8.\n"
                    + "Once an appropriate code has been chosen, it is checked whether or not there is already a vaccine stored with that same code.\n"
                    + "If it does not exist, the rest of the information (name, active ingredient, pharmaceutical and recommended price) will be requested "
                    + "and the vaccine will be added to the list.\n"
                    + "If the code already belongs to another vaccine, the user will be asked if they want to replace the existing vaccine. If so\n"
                    + "the rest of the data of the new vaccine will be requested and this will replace the vaccine with the same code. In case you do not want to replace it\n"
                    + "you will return to the main menu.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 4. ELIMINAR VACUNAS.
     * @return 
     */
    public static String eliminarVacunas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n4. ELIMINAR VACUNAS\n"
                    + "Para eliminar una vacuna se pide el código que se le quiere eliminar.\n"
                    + "Si la vacuna está en la lista será eliminida y se mostrará un mensaje conforme se ha realizado la acción.\n"
                    + "Si el código no coincide con ninguno de los de las lista, se mostrará un mensaje indicando que la vacuna no se encuentra\n"
                    + "en la lista.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n4. DELETE VACCINES\n"
                    + "In order to delete a vaccine, the vaccine code you want to delete is requested.\n"
                    + "If the vaccine is in the list, it will be eliminated and a message will be displayed as the action has been carried out.\n"
                    + "If the code does not match any of the ones on the list, a message will be displayed indicating that the vaccine cannot be found\n"
                    + "on the list.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 5. INTRODUCIR RESULTADO FASES VACUNAS.
     * @return 
     */
    public static String resultadoFases() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n5. INTRODUCIR RESULTADO FASES VACUNAS\n"
                    + "Para indicar el resultado de la fase de una vacuna se pide el código de la vacuna que se quiere modificar.\n"
                    + "Si el código no coincide con ninguna de las vacunas almacenadas, se mostrará un mensaje por pantalla y se volverá al menú principal.\n"
                    + "Si existe la vacuna en la lista, se accede a un menú donde elegir qué fase modificar.\n"
                    + "Una vez escogida la fase, se indicará si la ha superado o no.\n"
                    + "Se ha diseñado de forma que de cada vacuna se puede acceder a la modificación de cualquier fase, pero el usuario debe saber qué fases\n"
                    + "le está permitido modificar y cúales no.\n"
                    + "Si se intenta modificar una fase a la que previamente se le había asigando ya la opción de superada o de no superada, el programa no le dejará.\n"
                    + "Así mismo, si se trata de modificar una fase sin que previamente se haya superado la anterior, esto tampoco será posible.\n"
                    + "En caso de no poder llevarse a cabo la modificación solicitada se mostrará un mensaje por pantalla. También se mostrará un mensaje cuando la operación ha sido relalizada con éxito.\n"
                    + "Para conocer el estado de las fases de una vacuna se puede comprobar en la opción 10 del menú.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n5. ENTER VACCINE PHASE RESULT\n"
                    + "In order to indicate the result of a vaccine phase, the vacinne code for the vaccine to be modified is requested.\n"
                    + "If the code does not match any of the stored vaccines, a message will be displayed on the screen and you will return to the main menu.\n"
                    + "If the vaccine exists on the list, you will access a menu where you can choose which phase to modify.\n"
                    + "Once the phase has been chosen, it will be indicated if it has passed or not.\n"
                    + "It has been designed in such a way that the modification of any phase can be accessed for each vaccine, but the user must know which phases\n"
                    + "are allowed to modify and which ones are not.\n"
                    + "If you try to modify a phase that had previously been assigned the option of passed or not passed, the program will not let you.\n"
                    + "Likewise, if you try to modify a phase without previously having passed the previous one, this will not be possible either.\n"
                    + "You can check the status of the phases of a vaccine in option 10 of the menu.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 6. AUTORIZAR/RECHAZAR VACUNAS.
     * @return 
     */
    public static String autorizarRechazar() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n6. AUTORIZAR/RECHAZAR VACUNAS\n"
                    + "Para autorizar o rechazar una vacuna se pide su código.\n"
                    + "Si el código no coincide con ninguna de las vacunas almacenadas, se mostrará un mensaje por pantalla y se volverá al menú principal.\n"
                    + "Si existe la vacuna en la lista, se accede a un menú donde elegir si se desea autorizar o rechazar la vacuna.\n"
                    + "Al igual que con el caso de las fases, es responsabilidad del usuario conocer si puede autorizar o rechazar una vacuna.\n"
                    + "Sólo está permitido autorizar las vacunas que hayan superado las tres fases. En caso de tratar de autorizar una vacuna que no cumpla\n"
                    + "este criterio, saldrá un mensaje de advertencia y la vacuna no se registrará como autorizada.\n"
                    + "Por el contrario, cualquier vacuna podrá ser rechazada.\n"
                    + "En ambos casos, cuando sea posible realizar la acción solicitada, se mostrará un mensaje indicando que la vacuna ha sido autorizada o\n"
                    + "rechazada según proceda.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n6. AUTHORIZE/REJECT VACCINES \n"
                    + "In order to authorize or reject a vaccine, its code is requested.\n"
                    + "If the code does not match any of the stored vaccines, a message will be displayed on the screen and you will return to the main menu.\n"
                    + "If the vaccine exists on the list, you will access to a menu where you can choose whether to authorize or reject the vaccine.\n"
                    + "As in the case of phases, it is the user's responsibility to know whether they can authorize or reject a vaccine.\n"
                    + "It is only allowed to authorize vaccines that have passed the three phases. In case of trying to authorize a vaccine that does not comply\n"
                    + "this criterion, a warning message will appear and the vaccine will not be registered as authorized.\n"
                    + "On the contrary, any vaccine can be rejected.\n"
                    + "In both cases, when it is possible to perform the requested action, a message will be displayed indicating that the vaccine has been authorized or\n"
                    + "rejected as appropriate.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 7. VER VACUNAS AUTORIZADAS.
     * @return 
     */
    public static String verAutorizadas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n7. VER VACUNAS AUTORIZADAS\n"
                    + "Muestra todas las vacunas que han sido autorizadas empleando el mismo fromato que en LISTAR VACUNAS.\n"
                    + "Si no hay vacunas autorizadas se indica que la lista está vacía.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n7. SEE AUTHORIZED VACCINES\n"
                    + "Shows all vaccines that have been authorized using the same format as on LIST VACCINES.\n"
                    + "If there are no authorized vaccines, the list is empty.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 8. VER VACUNAS RECHAZADAS.
     * @return 
     */
    public static String verRechazadas() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n8. VER VACUNAS RECHAZADAS\n"
                    + "Muestra todas las vacunas que han sido rechazadas empleando el mismo fromato que en LISTAR VACUNAS.\n"
                    + "Si no hay vacunas rechazadas se indica que la lista está vacía.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n8. SEE REJECTED VACCINES\n"
                    + "Shows all vaccines that have been rejected using the same format as on LIST VACCINES.\n"
                    + "If there are no rejected vaccines, the list is empty.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 9. VER VACUNAS PENDIENTES DE RECHAZAR/AUTORIZAR.
     * @return 
     */
    public static String verPendientesRechazarAutorizar() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n9. VER VACUNAS PENDIENTES DE RECHAZAR/AUTORIZAR\n"
                    + "Muestra todas las vacunas que están pendientes de autorizar o rechazar empleando el mismo fromato que en LISTAR VACUNAS.\n"
                    + "Si no hay vacunas pendientes de autorizar o rechazar se indica que la lista está vacía.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n9. SEE VACCINES PENDING TO REJECT/AUTHORIZE\n"
                    + "Shows all vaccines  that are pending to be authorized or rejected using the same format as on LIST VACCINES.\n"
                    + "If there are no rejected vaccines, the list is empty.";
        }
        return mensaje;

    }
    
    /**
     * Instrucciones funcionamiento opción del menú 10. VER ÚLTIMA FASE INVESTIAGADA DE CADA VACUNA.
     * @return 
     */
    public static String verUltimaFaseInvestigada() {

        String mensaje = "";

        if (idioma.equals("esp")) {

            mensaje = "\n10. VER ÚLTIMA FASE INVESTIAGADA DE CADA VACUNA\n"
                    + "Muestra todas las vacunas con el mismo formato que en LISTAR VACUNAS, pero al final de cada una se muestra cúal es su última\n"
                    + "fase investigada y su resultado.\n"
                    + "En caso de que aún no se haya investigado ninguna de sus fases, también se muestra por pantalla.\n"
                    + "Si no hay vacunas almacenadas se indica que la lista está vacía.";

        } else if (idioma.equals("eng")) {

            mensaje = "\n10. SEE LAST INVESTIGATED PHASE OF EACH VACCINE\n"
                     + "Shows all vaccines with the same format as on LIST VACCINES, but at the end of each one it shows which is its last\n"
                     + "phase investigated and its result.\n"
                     + "In case none of its phases have been investigated yet, it is also displayed on the screen.\n"
                     + "If there are no vaccines stored,the program indicates that the list is empty."; 
        }
        return mensaje;

    }

}
