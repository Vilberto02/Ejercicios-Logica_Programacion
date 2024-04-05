/*
Enunciado: Un numero de 4 cifras es feliz si los dos primeros digitos
son mayores que los dos ultimos digitos. Por ejemplo, 5613 es feliz
porque 56 es mayor a 13. Un numero de 4 cifras es creciente si cada
digito es mayor al anterior. Por ejemplo, 1569 es creciente 
1 < 5 < 6 < 9 (9>6>5>1). Todo numero que es feliz y creciente se dice que es un
numero muy feliz. Todo numero que no es feliz ni creciente de dice
que es infeliz. Haga un programa que tome como entrada un numero
de 4 digitos e imprima el tipo de numero encontrado, segun la
clasificacion descrita.
*/

#include<iostream>
using namespace std;
int main(){
	int numero, i=0, cifras[4], primero, segundo;
	bool feliz = false, creciente = false;
	cout<<"Ingrese un numero de 4 cifras: "; cin>>numero;
	if(numero>=1000 && numero<=9999){
		//Separar los numeros
		while(numero>0){
			cifras[i] = numero%10;
			numero = numero/10;
			i++;
		}
		//Unir numeros
		primero = cifras[3]*10 + cifras[2];
		segundo = cifras[1]*10 + cifras[0];
		cout<<"Primero: "<<primero<<endl;
		cout<<"Segundo: "<<segundo<<endl;
		//Determinando si son felices
		if(primero > segundo){
			feliz = true;
		} else{
			feliz = false;
		}
		cout<<"Feliz: "<<boolalpha<<feliz<<endl;
		//Determinando si es creciente
		if(cifras[0]>cifras[1] && cifras[1]>cifras[2] && cifras[2]>cifras[3]){
			creciente = true;
		} else{
			creciente = false;
		}
		cout<<"Creciente: "<<boolalpha<<creciente<<endl;
		//Determinando la categoria del numero
		if(feliz && creciente){
			cout<<"-> El numero es muy feliz.";
		} else{
			cout<<"-> El numero es infeliz";
		}
		cout<<endl<<endl;
	} else{
		cout<<"ERROR, el numero ingresado no contiene 4 cifras.";
	}
	
	return 0;
}
