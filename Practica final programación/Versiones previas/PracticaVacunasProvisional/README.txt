Adjunto 3 versiones del mismo proyecto.

V1: PracticaVacuna_EstefaniaPenide
V3: PracticaVacuna_EstefaniaPenideV3
V4: PracticaVacuna_EstefaniaPenideV4

V1
Almaceno las vacunas en un ArrayList<Vacuna> ya que doy la opción de emplear métodos de búsqueda por cada uno de los atributos de la clase vacuna. Aquí ningún método
de búsqueda pervalecía sobre otro así que aunque el uso de un HashMap<Vacuna> facilitaría la búsqueda que se hace por un atributo concreto al que asignar como clave,
complicaría los otros métodos de búsqueda donde los atributos por los que se filtra el resultado no son clave.
Pueden almacenarse vacunas iguales.

V3
Exactemente igual que el V1 pero no permito que se almacenen vacunas iguales. Este control lo llevo a cabo en el main. Además, puesto que no se van a llegar a almacenar vacunas
iguales(mismo código), el métdodo de búsqueda por código en esta versión devuleve Vacuna en lugar de ArrayList<Vacuna>, ya que el resultado será único. El resto de métodos de búsqueda
siguen devolviendo ArrayList<Vacuna>.

V4
Empleo HashMap<String,Vacuna> para almacenar las vacunas. Como uno de los motivos por el que se emplea es para acelerar las búsqueda que se hace empleando el atributo que tiene por clave, 
la única búsqueda que se hace será por el código. Usando el código como clave también se resulve el problema de no admitir dos vacunas iguales. Ya que con HashMap si se introduce un
elemento con la misma clave que otro que ya está almacenado, prevalecerá el último añadido. Así, el único control que se lleva a cabo en el main, en lo que a esto respecta, se hace
perguntando al ususario, cuando esto ocurre, si decide almacenar la vacuna nueva y sustituir la vieja, o dejar la que ya estaba almacenada.
Por el momento la mayor parte de los métodos de VacAlmacen devuelven HashMap<String,Vacuna>, pero es probable que los acabe cambiando para que devulevan directamente Strings con las listas
de vacunas ya con un formato adecuado para la pressentación en lugar de gestionar la presentación y conversión a String en el main como estoy haciendo ahora.¿Debería hacerlo?
El almacen y todos los métodos por dentro seguirían trabjando con HashMap<String,Vacuna>, pero sus salidas serían directamente los Strings con la información ya presentable.
Además, en esta versión aún no he borrado las opciones de búsqueda por otros atributos, dejando los antiguos métodos comentados y las opciones del menú visibles aunque no llevan a nada.
Lo más seguro es que las acabe eliminando puesto que para esas búsquedas es más aparopiado el método de almacenamiento de las versiones anteriores.


Conclusión:

Además de los arreglos de la V4 ya comentados, me queda añadir los comentarios y quizás arreglar un poco mejor el código del main. Lo más seguro es que como tarea final acabe entregando
dos versiones:V3 y V4, ya que como en el enunciado no se especificaba, me gustaría dar la opción de las búsquedas por múltiples atributos, pero también entregar la de HashMap como se pidió 
en clase ya que tiene sentido cuando sólo las búsquedas se van a realizar sólo por el código.
