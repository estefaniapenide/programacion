
PractivaVacuna_EstefaniaPenideVersion7: Versión definitiva.

Consideraciones importantes:

Aunque el empleo del Map se hace por agilizar la búsqueda dada una clave (en este caso, el código) también he añadido búsqueda por nombre, farmaceutica,etc. Como no he 
implementado ninguna restricción que impida almacenar vacunas de una misma farmacéutica o con el mismo precio (no tendrá sentido no poder almacenar vacunas con precios iguales), 
estos métodos de búsqueda devuelven a su vez HashMaps (no como la búsqueda por código que devuelve una única vacuna). 
Estas opciones de búsqueda tenían sentido en versiones anteriores del proyecto donde empleaba ArrayList, pero se han adaptado a HashMap y empleado aquí también.

En un pricipio de había evitado tener que usar excepciones en la interfaz, pues se entiende que esta se podría implementar en otras muchas clases donde las restricciones de 
autoriar y rechazar de este determinado caso no sean aplicables. Al haberse añadido el criterio en clase de que una vacuna una vez ha sido autorizada o rechazada, esta acción 
no puede deshacerse y con el permiso que se dió de emplear excepciones en la interfaz, se ha aprovechado para hacer uso de las mismas también aquí.


Empleando la Clase Cadenas, he tratado de hacer que la aplicación esté disponible en inglés(no se ha prestado mucha atención a la traducción y no está bien escrita) y 
en castellano a elección del usuario. Aunque solicito en el main la lección de un idioma, si no lo hiciera, los métodos están implementados para imprimirse por 
defecto en castellano (la variable estática que se lo indica está inicializada a español).
No he conseguido que el mensaje de las excepciones salga en el idioma escogido por el usuario, por lo que todos los mensajes de las excepciones salen en ambos idiomas.

La organización del main en los métodos estáticos que se ven al final del código se ha hecho a última hora. La estructuración debería haberla realizado de otra manera, pero habría supesto,
además de cambiar la estructura de más de la mitad de los métodos de Cadenas para adaptarlos ciertos métodos que tienen la misma estructura y que devolverían variantes de un mismo mensaje,
cambiar gran parte de la estructura de de VacAlmacen o añadir una clase extra intermedia entre VacAlmacen y el main.
Se tendrá en cuenta para próximos proyectos.

Incoorporo un manual para del usuario en el propio proyecto que describe qué hace del menú. La que se muestra a continuación es una versión extendida del manual que aparece en el proyecto,
pero en esta versión se ha añadido una pequeña explicación también del código:

MANUAL(CON EXPLICACIÓN DEL CÓDIGO):

IDIOMAS
Al mismo iniciar el programa se accede a un menú para escoger el idioma. Se puede elegir entre español
e inglés. Si no se escoge ninguna de las opciones, introduciéndo cualquier número, el programa empleará
por defecto español. Si introduce cualquier otro caracter que no sea un número entero, el programa
devolverá un mensaje de error.
Todos los mesajes que se muestran por pantalla (salvo las excepciones) son llamados o desde la Clase Cadenas,
ControlData, VacunaAutorización, Vacuna o Manual. En todas ellas se ha definido una variable estática que está inicializada
a español. Y esta variable se consulta en todos los métodos para ver qué mensaje mostrar por pantalla (el que está en inglés
o el que está en español.)
Sin embargo, los mensajes de las excepciones salen por duplicado en ambos idiomas independientemente del escogido
por el usuario.

	Aplicacion.gestionIdioma(Scanner input) imprime el menú de idiomas y tiene el switch para elegir la lengua.

	Aplicacion.espanol()/Aplicacion.english() asignan el idioma a las variables estáticas de idioma de todas las clases.

	Aplicacion.controlIdioma() se encarga del controlar el tipo int del menú de idiomas, se ha hecho a parte para que devuelva el mensaje de error en los dos idiomas de forma simultánea,
	porque en este punto áun no se ha escogido el idioma.

1. LISTAR VACUNAS
Muestra todas las vacunas almacenadas, con su código, nombre, principio activo, farmacéutica y percio recomendado. También se indica
si han sido rechazadas, autorizadas o están pendientes de autorizar o rechazar.
En caso de que no se haya almacenado ninguna vacuna, se mostrará un mensaje indicando que la lista está vacía.

	VacAlamcen.listarVacunasAlmacen() añade las vacunas a un HashMap

	Aplicacion.imprimirListaVacunas() pasa a String las vacunas del HashMap de VacAlmacen.listarAlmacen()

2. BUSCAR VACUNAS
Se accede a un menú donde se pude elegir el criterio de búsqueda:
Por código: devuelve un único resultado, pues cada vacuna debe tener un código distinto para poder ser almacenada.
Por nombre, por principio activo, por farmacéutica o por precio recomendado: devuelve todas las vacunas con las que hay equivalencia
con el dato introducido.
El formato empleado para mostrar las vacunas es el mismo que en LISTAR VACUNAS.
En caso de no encontrarse coincidencia con ninguna de las vacunas almacenadas, se muestra un mensaje indicándolo.

	VacAlmacen.buscarVacunaCodigo(String codigo) devuelve la vacuna con el código indicado y si no se encuentra en el HashMap, devuelve una vacuna vacía.

	Aplicacion.imprimirBusquedaCodigo(String codigoBusqueda, Vacuna vacuna) si VacAlmacen.buscarVacunaCodigo(String codigo) ha devuelto una vacuna vacía, devuelve un mensaje indicando que la
	vacuna no está en la lista, de lo contrario, muestra la vacuna.

	VacAlmacen.buscarVacunaNombre(String nombre)/VacAlmacen.buscarVacunaPrincipioActivo(String principioActivo)/VacAlmacen.buscarVacunaFarmaceutica(String farmaceutica)/
	VacAlmacen.buscarVacunaPrecioRecomendado(double precioRecomendado) devuelven un HashMap con las vacunas cuyos valores de sus atributos coinciden con el solicitado. Si
	no hay coincidencia, devuelven un HashMap vacío.

	Aplicacion.imprimirBusquedaNombre(String nombre)/Aplicacion.imprimirBusquedaPrincipioActivo(String principioActivo)/Aplicacion.imprimirBusquedaFarmaceutica(String farmaceutica)/
	Aplicacion.imprimirBusquedaPrecioRecomendado(double precioRecomendado) devuelven un mensaje si sus HashMap de VacAlmacen correspondientes están vacíos o si hay vacunas, imprimen
	cada una de ellas.

3. AGREGAR VACUNAS
Para agregar una vacuna se pide primero el código que se le quiere asignar. Este debe ceñirse al siguiente formato:
	Comenzará por la letra V seguida de una vocal en mayúsculas.
	A continuación, tres o cuatro letras minúsculas.
	Finaliza, o con dos números del 4 al 7, o bien con el número 8.
Una vez escogido un código apropiado, se comprueba si ya hay o no una vacuna almacenada con ese mismo código.
Si no existe, se pedirán el resto de datos (nombre, principio activo, farmacéutica y precio recomendado) y se añadirá a la lista.
Si el código ya pertenece a otra vacuna, se le preguntará al usuario si desea reemplazar la vacuna ya existente. En caso afirmativo,
se pedirán el resto de datos de la vacuna nueva y esta reemplazará a la vacuna con el mismo código. En caso de no querer reemplazarla
se volverá al menú principal.

	VacAlmacen.agregarVacuna(String codigo, Vacuna vacuna) añade al HashMap una vacuna (valor) y su código (clave).

	Aplicacion.gestionAgregarVacunaConControlFormato(Scanner input, Vacuna vacuna) recoge el código pedido por pantalla a tarvés del parámetro 'Scanner input' y controla que este tenga
	el formato adecuado. De ser así busca por medio de esta clave si la vacuna ya está almacenada en la lista.

	Aplicacion.agregarOReemplazarVacuna(input, codigo, vacunaCodigo) se ejecuta a continuación dentro de Aplicacion.gestionAgregarVacunaConControlFormato(Scanner input, Vacuna vacuna),
	en caso de que la vacuna esté almacenada ya en la lista, pregunta si se desea reemplazar o no. Si se desea reemplazar, se piden los datos de la nueva vacuna y la reemplaza. 
	Si no se desea reemplazar se vuelve al menú principal. Si la vacuna aún no estaba almacenada, se piden el resto de datos de la vacuna y se añade a la lista.

	Aplicacion.vacunaNueva(Scanner input, String codigo) se ejecuta dentro de Aplicacion.agregarOReemplazarVacuna(input, codigo, vacunaCodigo) y es el método encargo de pedir los datos
	de la vacuna que se va a añadir a la lista/reemplazar otra vacuna y añadirla.

4. ELIMINAR VACUNAS
Para eliminar una vacuna se pide el código que se le quiere eliminar.
Si la vacuna está en la lista será eliminida y se mostrará un mensaje conforme se ha realizado la acción.
Si el código no coincide con ninguno de los de las lista, se mostrará un mensaje indicando que la vacuna no se encuentra
en la lista.

	VacAlmacen.eliminarVacuna(String codigo) elimina la vacuna del código que se le indica.

	Aplicacion.gestionEliminarVacuna(String codigoEliminar, Vacuna vacuna) funciona igual que Aplicacion.imprimirBusquedaCodigo(String codigoBusqueda, Vacuna vacuna), salvo que si
	encuentra la vacuna, se ejecuta VacAlmacen.VacAlmacen.eliminarVacuna(String codigo) y devolverá el mensaje por pantalla correspondiente.

5. INTRODUCIR RESULTADO FASES VACUNAS
Para indicar el resultado de la fase de una vacuna se pide el código que de la vacuna que se quiere modificar.
Si el código no coincide con ninguna de las vacunas almacenadas, se mostrará un mensaje por pantalla y se volverá al menú principal.
Si existe la vacuna en la lista, se accede a un menú donde elegir qué fase modificar.
Una vez escogida la fase, se indicará si la ha superado o no.
Se ha diseñado de forma que de cada vacuna se puede acceder a la modificación de cualquier fase, pero el usuario debe saber qué fases
le está permitido modificar y cúales no.
Si se intenta modificar una fase a la que previamente se le había asigando ya la opción de superada o de no superada, el programa no le dejará.
Así mismo, si se trata de modificar una fase sin que previamente se haya superado la anterior, esto tampoco será posible.
En caso de no poder llevarse a cabo la modificación solicitada se mostrará un mensaje por pantalla. También se mostrará un mensaje cuando la operación ha sido relalizada con éxito.
Para conocer el estado de las fases de una vacuna se puede comprobar en la opción 10 del menú.

	Aplicacion.gestionFases(Scanner input, String codigoCambioFases, Vacuna vacuna) busca si la vacuna que se deasea modificar está en la lista, si no lo está devuelve un mensaje,
	si lo está ejecuta Aplicacion.menuModificarFases(input, codigoCambioFases).

	Aplicacion.menuModificarFases(Scanner input, String codigoCambioFases) muestra y gestiona el menú con el que se accede a la modificación de la fase escogida.

	Aplicacion.public static void menuModificarFase1(Scanner input, String codigoCambioFases)/Aplicacion.public static void menuModificarFase2(Scanner input, String codigoCambioFases)/
	Aplicacion.public static void menuModificarFase3(Scanner input, String codigoCambioFases) gestiona el menú donde se escoge si se ha superado o no la fase correspondiente.

	Aplicacion.public static void modificarFase1(String codigoCambioFases, boolean estado)/Aplicacion.public static void modificarFase2(String codigoCambioFases, boolean estado)/
	Aplicacion.public static void modificarFase3(String codigoCambioFases, boolean estado) accecen a los métodos VacunaAutorizacion.setFase1Superada(boolean fase1Superada)/
	VacunaAutorizacion.setFase2Superada(boolean fase2Superada)/VacunaAutorizacion.setFase3Superada(boolean fase3Superada) y los modifican acorde a la opción escogida en el menú.
	Devuelven un mensaje confirmando la acción una vez ha sido realizada.

6. AUTORIZAR/RECHAZAR VACUNAS
Para autorizar o rechazar una vacuna se pide su código.
Si el código no coincide con ninguna de las vacunas almacenadas, se mostrará un mensaje por pantalla y se volverá al menú principal.
Si existe la vacuna en la lista, se accede a un menú donde elegir si se desea autorizar o rechazar la vacuna.
Al igual que con el caso de las fases, es responsabilidad del usuario conocer si puede autorizar o rechazar una vacuna.
Sólo está permitido autorizar las vacunas que hayan superado las tres fases. En caso de tratar de autorizar una vacuna que no cumpla
este criterio, saldrá un mensaje de advertencia y la vacuna no se registrará como autorizada.
Por el contrario, cualquier vacuna podrá ser rechazada.
En ambos casos, cuando sea posible realizar la acción solicitada, se mostrará un mensaje indicando que la vacuna ha sido autorizada o
rechazada según proceda.

	Se controla que la vacuna esté en la lista almacenada, por medio del método de VacAlmacen.buscarVacunaCodigo(String codigo) y se muestra un mensaje si no lo está.
	En caso de estarlo se accede al menú donde se elige si autorizar o rechazar la vacuna.

	Aplicacion.autorizarVacuna(String codigoAutotizarRechazar) ejecuta el método VacunaAutorizacion.autorizar(), si la vacuna ya hubiera sido autorizada o rechazada, saltaría
	una excepción y si la vacuna no hubiera superado las tres fases tampoco se autorizaría y saldría un mensaje indicandolo. En caso contrario también se imprime un mensaje 
	confirmando que la vacuna ha sido autorizada.

	Aplicacion.rechazarVacuna(String codigoAutotizarRechazar) ejecuta el método VacunaAutorizacion.rechazar(), si la vacuna ya hubiera sido autorizada o rechazada, saltaría
	una excepción. En caso contrario también se imprime un mensaje confirmando que la vacuna ha sido rechazada.

	

7. VER VACUNAS AUTORIZADAS
Muestra todas las vacunas que han sido autorizadas empleando el mismo fromato que en LISTAR VACUNAS.
Si no hay vacunas autorizadas se indica que la lista está vacía.

	VacAlmacen.verVacunasAutorizadas() devuelve un HashMap con todas las vacunas autorizadas y en caso de no haberlas, devuelve un HashMap vacío.

	Aplicacion.imprimirVacunasAutorizadas() devuelve un mensaje si el HashMap de VacAlmacen.verVacunasAutorizadas() está vacío o devuleve las vacunas de ese HashMap una a una
	en formato String si hay alguna.

8. VER VACUNAS RECHAZADAS
Muestra todas las vacunas que han sido rechazadas empleando el mismo fromato que en LISTAR VACUNAS.
Si no hay vacunas rechazadas se indica que la lista está vacía.

	VacAlmacen.verVacunasRechazadas() devuelve un HashMap con todas las vacunas rechazadas y en caso de no haberlas, devuelve un HashMap vacío.

	Aplicacion.imprimirVacunasRechazadas() devuelve un mensaje si el HashMap de VacAlmacen.verVacunasRechazadas() está vacío o devuleve las vacunas de ese HashMap una a una
	en formato String si hay alguna.

9. VER VACUNAS PENDIENTES DE RECHAZAR/AUTORIZAR
Muestra todas las vacunas que están pendientes de autorizar o rechazar empleando el mismo fromato que en LISTAR VACUNAS.
Si no hay vacunas pendientes de autorizar o rechazar se indica que la lista está vacía.

	VacAlmacen.verVacunasPendientesAutorizarRechazar() devuelve un HashMap con todas las vacunas pendientes de autorizar o rechazar y en caso de no haberlas, devuelve un HashMap vacío.

	Aplicacion.imprimirVacunasPendientesRechazarAutorizar() devuelve un mensaje si el HashMap de VacAlmacen.verVacunasPendientesAutorizarRechazar() está vacío o devuleve las vacunas de ese HashMap una a una
	en formato String si hay alguna.

10. VER ÚLTIMA FASE INVESTIAGADA DE CADA VACUNA
Muestra todas las vacunas con el mismo formato que en LISTAR VACUNAS, pero al final de cada una se muestra cúal es su última.
fase investigada y su resultado.
En caso de que aún no se haya investigado ninguna de sus fases, también se muestra por pantalla.
Si no hay vacunas almacenadas se indica que la lista está vacía.

	VacAlmacen.verUltimaFaseInvestigadaVacunas() devuelve un String con todas las vacunas de la lista más los datos de su última fase investigada.

	Aplicacion.ultimaFaseSuperada() devuelve un mensaje si el String de VacAlmacen.verUltimaFaseInvestigadaVacunas() está vacío, o directamente el propio String si hay algún dato
	en él.