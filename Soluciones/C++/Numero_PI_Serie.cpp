/*
Enunciado: Escriba un programa que calcule el valor aproximado
de pi usando la serie: 
pi = 4 - (4/3) + (4/5) - (4/7) + (4/9) ...+- (4/n)
*/
#include<iostream>
using namespace std;
int main(){
	int limite;
	float suma = 4;
	cout<<"Ingrese un numero entero positivo mayor a 0 para estimar el valor de PI: "; cin>>limite;
	// -> 4/((2*n)+1)
	if(limite>0){
		for(int i=1; i<=limite; i++){
			if(i%2!=0){
				suma = suma - (4.0/((2.0*i)+1));
			}else{
				suma = suma + (4.0/((2.0*i)+1));
			}
		}
		cout<<"-> PI: "<<suma;
	} else{
		cout<<"No es un numero entero positivo.";
	}
	cout<<endl;
	return 0;
}
