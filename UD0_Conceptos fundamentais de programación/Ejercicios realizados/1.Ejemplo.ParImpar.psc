Proceso ParImpar
	//Definir datos//
	//Pedir datos//
	//C�lculos//
	//Mostrar en pantalla el resultado//
	Definir num,cont Como Entero;
	cont=0;
	Repetir
	   Escribir Sin Saltar "Introduce un n�mero: ";
	   Leer num;
	  cont=cont+1;
	Hasta que cont=2;
    Si num%2=0 Entonces
		Escribir "N�mero par: ", num;
	SiNo
		Escribir "N�mero impar: ", num;
	FinSi
FinProceso
