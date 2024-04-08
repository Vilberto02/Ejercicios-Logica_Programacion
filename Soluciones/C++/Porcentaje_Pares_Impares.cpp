/*
Enunciado: Dada una secuencia de numeros terminada en cero, elaborar un algoritmo
para calcular el porcentaje y la suma de los numeros impares, el porcentaje y la suma
de los numeros pares,  y la suma de todos los numeros, y cuantos numeros fueron ingresados.
*/
#include<iostream>
using namespace std;
int main(){
	int numero, sumaPares = 0, sumaImpares = 0, contadorPares = 0, contadorImpares = 0;
	float porcentajePares, porcentajeImpares;
	bool control = true;
	
	cout<<"Ingrese un secuencia de numeros (Termina en 0)."<<endl;
	while(control){
		cout<<"Numero: "; cin>>numero;
		if(numero!=0){
			control = true;
			if(numero%2==0){
				sumaPares = sumaPares + numero;
				contadorPares++;
			} else{
				sumaImpares = sumaImpares + numero;
				contadorImpares++;
			}
			numero = 0;
		}else{
			control = false;
		}
	}
	porcentajePares = contadorPares*100.0/(contadorPares + contadorImpares);
	porcentajeImpares = contadorImpares*100.0/(contadorPares + contadorImpares);
	
	cout<<"Porcentaje de numeros pares: "<<porcentajePares<<" %"<<endl;
	cout<<"Suma de numeros pares: "<<sumaPares<<endl;
	cout<<"Porcentaje de numeros impares: "<<porcentajeImpares<<" %"<<endl;
	cout<<"Suma de numeros impares: "<<sumaImpares<<endl;
	cout<<"Suma total: "<<(sumaPares + sumaImpares)<<endl;
	cout<<"Numero ingresados: "<<(contadorPares + contadorImpares)<<endl;
	
	return 0;
}
