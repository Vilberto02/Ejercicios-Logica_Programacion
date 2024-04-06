/*
Enunciado: Escribir un programa que pida al usuario un numero entero positivo y
muestre por pantalla si es un numero primo o no.
*/
#include<iostream>
using namespace std;
int main(){
	int num, contador=0;
	cout<<"Ingrese un numero entero positivo: "; cin>>num;
	if (num>0){
		for(int i=1; i<=num; i++){
			if(num%i==0){
				contador++;
			}
		}
		if(contador==2){
			cout<<"Es numero primo";
		} else{
			cout<<"No es un numero primo";
		}
	} else{
		cout<<"ERROR, el numero ingresado no es un numero entero positivo.";
	}
	cout<<endl;
	return 0;
}
