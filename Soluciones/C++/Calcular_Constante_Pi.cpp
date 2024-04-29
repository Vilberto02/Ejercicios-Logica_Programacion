/*
La constante pi (3.141592...) es muy utilizada en matematicas.
Un metodo sencillo de calcular su valor:
Pi = (4/1)-(4/3)+(4/5)-(4/7)+(4/9)-(4/11)+...
Escribir un programa que efectue este calculo con un numero de terminos
especificados por el usuario.
*/
//Accion CalcularConstantePi
#include <iostream>
#include <cmath>
using namespace std;
int main (){
	int numero;
	double pi = 0;
	cout<<"Ingrese un valor entero: "; cin>>numero;
	if (numero>0){
		for (int i = 0; i<numero; i++){
			pi = pi + 4*(pow(-1, i)/(2*i+1));
		}
		cout<<"-> Pi: "<<pi<<endl;	
	} else {
		cout<<"Error! Numero invalido"<<endl;
	}
	
	
	return 0;
}
