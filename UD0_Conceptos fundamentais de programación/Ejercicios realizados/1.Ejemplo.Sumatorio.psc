Proceso Sumatorio
	//Definir datos//
	//Pedir datos//
	//Cálculos//
	//Muestra en pantalla//
	Definir contador, num Como Entero;
	Definir resutado Como Real;
	Escribir "Introduce un número: ";
	Leer num;
	resultado=0;
	contador=1;
	Mientras contador<=num Hacer
		resultado=resultado+contador;
		contador=contador+1;
	FinMientras
	Escribir "El resultado es igual a ", resultado;
FinProceso
