/*
Escribir una funcion que calcule al area de un circulo
y otra que calcule el columen de un cilindro usando 
la primera funcion
*/
#include<iostream>
#include<cmath>
#define PI 3.141592
using namespace std;
float areaCirculo(float r);
float volumenCilindro(float h, float r);
int main(){
	float radio, altura;
	cout<<"Ingrese el radio del circulo: "; cin>>radio;
	cout<<"Ingrese la altura del cilindro: "; cin>>altura;
	if(radio>0 && altura>0){
		cout<<"-> Area del circulo: "<<areaCirculo(radio)<<endl;
		cout<<"-> Volumen del cilindro: "<<volumenCilindro(altura, radio)<<endl;
	}else{
		cout<<"-> ERROR, el radio y la altura del cilindro deben de numeros positivos";
	}
	return 0;
}

float areaCirculo(float r){
	float area;
	area = pow(r,2)*PI;
	return area;
}

float volumenCilindro(float h, float r){
	float volumen;
	volumen = areaCirculo(r)*h;
	return volumen;
}


