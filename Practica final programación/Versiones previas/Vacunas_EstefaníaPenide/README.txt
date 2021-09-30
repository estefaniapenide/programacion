
PractivaVacuna_EstefaniaPenideV6: Versión definitiva.


Aunque el empleo del Map se hace por agilizar la búsqueda dada una clave, en este caso, el código, también he añadido búsqueda por nombre, farmaceutica,etc. Como no he 
implementado ninguna restricción que impida almacenar vacunas con el mismo precio o de una misma farmacéutica(no tendrá sentido), estos métodos de búsqueda devuelven a su 
vez HashMaps (no como la búsqueda por código que devuelve una única vacuna). 
Estas opciones de búsqueda tennían sentido en versiones anteriores del proyecto donde empleaba ArrayList.

Empleando la Clase Cadenas, he tratado de hacer que la aplicación esté disponible en inglés(seguramente hay fallos de traducción) y en castellano a elección del usuario. Aunque solicito 
en el main el idioma(y hay que escoger uno), si no lo hiciera, los métodos están implementados para imprimirse por defecto en castellano (la variable estática que se lo indica está 
inicializada a español).
No he conseguido que el mensaje de las excepciones salga en el idioma escogido por el usuario, por lo que todos los mensajes de las excepciones salen en ambos idiomas.