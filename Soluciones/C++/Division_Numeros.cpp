/*
Enunciado: Escribir un programa que pida al usuario
dos numeros y muestre por pantalla su division. Si
el divisor es cero, el programa debe mostrar un 
mensaje de error.
*/
#include<iostream>
using namespace std;

int main(){
	float a, b;
	float division = 0.0;
	cout<<"Division de dos numeros\n";
	do{
		cout<<"Ingrese el dividendo: "; cin>>a;
		cout<<"Ingrese el divisor: "; cin>>b;
		if (b != 0){
			division = a/b;
			cout<<"-> Division: "<<division<<endl;
		} else{
			cout<<"-> ERROR, no se puede dividir sobre cero."<<endl;
		}
		cout<<endl;	
	}while(b!=0);
	return 0;
}
