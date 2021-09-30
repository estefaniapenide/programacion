Proceso ParImpar
	//Definir datos//
	//Pedir datos//
	//Cálculos//
	//Mostrar en pantalla el resultado//
	Definir num,cont Como Entero;
	cont=0;
	Repetir
	   Escribir Sin Saltar "Introduce un número: ";
	   Leer num;
	  cont=cont+1;
	Hasta que cont=2;
    Si num%2=0 Entonces
		Escribir "Número par: ", num;
	SiNo
		Escribir "Número impar: ", num;
	FinSi
FinProceso
