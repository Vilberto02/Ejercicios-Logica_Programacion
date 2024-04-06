/*
Enunciado: Escribir un programa que pida al usuario un numero entero positivo y
muestre por pantalla todos los numeros impares desde el 1 hasta ese numero.
*/
#include<iostream>
using namespace std;
int main(){
	int num;
	cout<<"Ingrese un numero positivo: "; cin>>num;
	if(num>=0){
		for(int i=1; i<num; i++){
			if(i%2!=0 || i==1){
				cout<<i<<" ";
			}
		}
	}else{
		cout<<"No es un numero entero positivo";
	}
	cout<<endl;
	return 0;
}
