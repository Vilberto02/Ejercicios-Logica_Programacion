/*
Enunciado: Realice un programa que imprima "Capicua" si un numero
de entrada de 4 digitos es capicua, o "No lo es" en caso contrario.
Un numero es capicua si se escribe igual al derecho y al rev�s.
Por ejemplo, 1551 es un numero capicua.
*/
#include<iostream>
using namespace std;
int main(){
	int numero, contador;
	int cifras[4], i, cifrasInverso[4];
	bool control = true;
	while(control){
		i = 0;
		contador = 0;
		cout<<"Ingrese un numero de 4 digitos: "; cin>>numero;
		if (numero < 1000  || numero > 9999){
			control = false;
		}
		while(numero>0){
			cifras[i] = numero%10;
			numero = numero/10;
			i++;
		}
		for(int j=0; j<4; j++){
			cifrasInverso[j] = cifras[3-j];
		}
		
		for(int m=0; m<4; m++){
			if (cifras[m] == cifrasInverso[m]){
				contador++;
			} else{
				break;
			}
		}
		
		if(contador == 4){
			cout<<"-> Es un numero capicua."<<endl;
		} else{
			cout<<"-> No es un numero capicua."<<endl;
		}  
		cout<<endl;
	}
	cout<<"ERROR, ingreso un numero incorrecto."<<endl;
	return 0;
}
