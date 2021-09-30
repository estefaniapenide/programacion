Proceso ClasificacionNumeros
	//Definir datos//
	//Pedir datos//
	//Cálculos//
	//Mostrar en pantalla el resultado//
	Definir num Como Real;
	Definir cont1,cont2,cont3 Como Entero;
	cont1=0;
	cont2=0;
	cont3=0;
	Escribir "A continuación te pediremos hasta 8 números reales y de esa lista se te indicará cuántos son menores que cero, cuántos igual a cero y cuántos mayores que cero."
	Repetir 
	Escribir Sin Saltar "Introduce un número real: ";
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
	Escribir cont1, " números son igual a cero, ", cont2, " números son menores que cero, ", cont3, " números son mayores que cero.";
FinProceso
	