/*
Separar un numero en sus cifras individuales.
*/
#include<iostream>
using namespace std;
int main(){
	int numero, i=0;
	int cifras[3];
	cout<<"Ingrese un numero de 4 digitos: "; cin>>numero;
	while(numero>0){
		cifras[i] = numero%10;
		numero = numero/10;
		i++;
	}
	cout<<"Numeros: ";
	for(int i=3; i>=0; i--){
		cout<<cifras[i]<<" ";
	}
	return 0;
}
