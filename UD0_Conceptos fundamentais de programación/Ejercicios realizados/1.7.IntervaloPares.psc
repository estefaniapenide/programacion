Proceso ParImpar
	//Definir datos//
	//Pedir datos//
	//C�lculos//
	//Mostrar en pantalla el resultado//
	Definir num1,num2 Como Entero;
	Escribir "A continuaci�n te pediremos los extremos de un intervalo para devolverte la lista de n�meros pares dentro del mismo.";
	Escribir Sin Saltar "Extremo inferior (n�mero entero): ";
	Leer num1;
	Escribir Sin Saltar "Extremo superior (n�mero entero): ";
	Leer num2;
	Si num1<num2 Entonces
		Escribir Sin Saltar "Estos son los n�meros pares del intervalo [", num1, ", ", num2,"]: ";
		Mientras num1<=num2 Hacer
			Si num1%2=0 Entonces
				Escribir Sin Saltar num1, " ";
			SiNo
				num1=num1+1;
				Escribir Sin Saltar num1, " ";
			FinSi
			num1=num1+2;
		FinMientras
	SiNo
		Escribir "Los n�meros introducidos no son correctos. El extremo inferior debe ser m�s peque�o que el extremo superior.";
	FinSi
FinProceso