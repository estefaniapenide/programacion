Proceso ClasificacionNumeros
	//Definir datos//
	//Pedir datos//
	//C�lculos//
	//Mostrar en pantalla el resultado//
	Definir num Como Real;
	Definir cont1,cont2,cont3 Como Entero;
	cont1=0;
	cont2=0;
	cont3=0;
	Escribir "A continuaci�n te pediremos hasta 8 n�meros reales y de esa lista se te indicar� cu�ntos son menores que cero, cu�ntos igual a cero y cu�ntos mayores que cero."
	Repetir 
	Escribir Sin Saltar "Introduce un n�mero real: ";
	Leer num;
	Si num=0 Entonces
		cont1=cont1+1;
	SiNo
		Si num<0 Entonces
			cont2=cont2+1;
		SiNo 
			Si num>0 Entonces
				cont3=cont3+1;
			FinSi
		FinSi
	FinSi
	suma=cont1+cont2+cont3
	Hasta que suma=8;
	Escribir cont1, " n�meros son igual a cero, ", cont2, " n�meros son menores que cero, ", cont3, " n�meros son mayores que cero.";
FinProceso
	