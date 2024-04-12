/*
Escribir un programa que solicite el ingreso de una cantidad
indeterminada de numeros mayores a 1, finalizando cuando se
reciba un cero. Imprimir la cantidad de numeros primos
ingresados.
*/
#include<iostream>
using namespace std;
int main(){
	int numero, contador, contadorTotal = 0;
	bool control=true;
	while(control){
		cout<<"Ingrese un numero: "; cin>>numero;
		if (numero>1){
			control = true;
			contador = 0;
			for(int i=1; i<=numero; i++){
				if(numero%i == 0){
					contador++;
				}
			}
			if (contador == 2){
				contadorTotal++;
			}
		}else if (numero==0){
			control = false;
		} else{
			cout<<"ERROR, el numero debe ser mayor a 1."<<endl;
		}
	}
	cout<<"-> Cantidad de numero de primos: "<<contadorTotal<<endl;
	return 0;
}
