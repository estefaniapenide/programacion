Proceso Factorial
	//Definir datos//
	//Pedir datos//
	//Cálculos//
	//Muestra en pantalla//
	Definir contador, num Como Entero;
	Definir resultado Como Real;
	Escribir "Introduce un número: ";
	Leer num;
	resultado=1;
	contador=2;
	Mientras contador<=num Hacer
		resultado=resultado*contador;
		contador=contador+1;
	FinMientras
	Escribir num, "! es igual a ", resultado;
FinProceso
