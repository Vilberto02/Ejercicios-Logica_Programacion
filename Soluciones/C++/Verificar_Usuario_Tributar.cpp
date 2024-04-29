/*
Enunciado: Para tributar un determinado impuesto se debe ser mayor de
16 anios y tener unos ingresos iguales o superiores a 500$ mensuales.
Escribir un programa que pregunte al usuario su edad y sus ingresos
mensuales y muestre por pantalla si el usuario tiene que atributar o no.
*/
#include<iostream>
using namespace std;

int main(){
	int edad;
	float ingresosMensuales;
	bool control;
	cout<<"Determinar si una persona puede tributar"<<endl;
	do{
		cout<<"Ingrese su edad: "; cin>>edad,
		cout<<"Ingrese sus ingresos mensuales: "; cin>>ingresosMensuales;
		control = edad>16 && ingresosMensuales>=500;
		if(control){
			cout<<"Aceptado.";
		} else{
			cout<<"Rechazado. Usted no cumple con las condiciones.";
		}
		cout<<endl<<endl;
	}while(!control);
	return 0;
}
