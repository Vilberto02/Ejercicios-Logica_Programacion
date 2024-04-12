/*
Leer numeros enteros positivos de teclado, hasta que el usuario ingrese
numero cero e informar cual fue el mayor y el menor numero ingresado.
*/
#include<iostream>
using namespace std;

int main(){
	int numero, numeroMayor, numeroMenor;
	bool control=true;
	while(control){
		cout<<"Ingrese un numero entero positivo: "; cin>>numero;
		if (numero>0){
			control = true;
			for(int i=1; i<=numero;i++){
				if(numero>numeroMayor){
					numeroMayor = numero;
				}
				if(numero<numeroMenor){
					numeroMenor = numero;
				}
			}
		} else{
			control = false;
		}
	}
	cout<<"\n-> Numero mayor: "<<numeroMayor<<endl;
	cout<<"-> Numero menor: "<<numeroMenor;
	return 0;
}
