Proceso ParImpar
	//Definir datos//
	//Pedir datos//
	//Cálculos//
	//Mostrar en pantalla el resultado//
	Definir num1,num2 Como Entero;
	Escribir "A continuación te pediremos los extremos de un intervalo para devolverte la lista de números pares dentro del mismo.";
	Escribir Sin Saltar "Extremo inferior (número entero): ";
	Leer num1;
	Escribir Sin Saltar "Extremo superior (número entero): ";
	Leer num2;
	Si num1<num2 Entonces
		Escribir Sin Saltar "Estos son los números pares del intervalo [", num1, ", ", num2,"]: ";
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
		Escribir "Los números introducidos no son correctos. El extremo inferior debe ser más pequeño que el extremo superior.";
	FinSi
FinProceso