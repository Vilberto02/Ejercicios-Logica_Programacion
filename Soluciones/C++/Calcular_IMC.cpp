/*
Enunciado: El IMC resulta de la division de la masa de un individuo (en kg)
entre el cuadrado de la estatura (en m). El indice de masa corporal es un
indicador del peso de una persona en relación con su altura.
Clasificación del IMC de acuerdo con la OMS de la ONU:
a) Menor a 16: Criterio de ingreso.
b) 16 a 16.9: Infrapeso.
c) 17 a 18.4: bajo peso.
d) 18.5 a 24.9: peso normal.
e) 25 a 29.9: sobrepeso.
f) 30 a 34.9: obesidad premórbida.
g) 40 a 45: obesidad mórbida.
h) mayor a 45: obesidad hipermórbida.
Escriba un programa que dado el peso de una persona en libras 
(1 lb = 0.453592 kg) y su altura en centimetros, calcule su IMC e indique
como salida el peso en kilogramos, el valor de IMC de la persona y la
categoria en la cual fue clasificado.
*/
#include<iostream>
#include<cmath>
#define LIBRAS 0.453595
using namespace std;

int main(){
	float pesoLib, estaturaCm, pesoKg, estaturaM, imc;
	string categoria = "";
	cout<<"Ingrese su peso en libres: "; cin>>pesoLib;
	cout<<"Ingrese su estatura en centimetros: "; cin>>estaturaCm;
	
	pesoKg = pesoLib*LIBRAS;
	estaturaM = estaturaCm/100.0;
	
	imc = pesoKg/pow(estaturaM,2);
	
	if(imc<16){
		categoria = "Criterio de ingreso";
	} else if(imc>16 && imc<=16.9){
		categoria = "Infrapeso";
	} else if(imc>=17 && imc<=18.4){
		categoria = "Bajo peso";
	} else if(imc>=18.5 && imc<=24.9){
		categoria = "Peso normal";
	} else if(imc>=25 && imc<=29.9){
		categoria = "Sobrepeso";
	} else if(imc>=30 && imc<=34.9){
		categoria = "Obesidad premorbida";
	} else if(imc>=40 && imc<=45){
		categoria = "Obesidad morbida";
	} else if(imc>45){
		categoria = "Obesidad hipermorbida";
	}
	
	cout<<"IMC: "<<imc<<endl;
	cout<<"Peso: "<<pesoKg<<" Kg"<<endl;
	cout<<"Estatura: "<<estaturaM<<" m"<<endl;
	cout<<"Categoria: "<<categoria<<" ("<<imc<<")"<<endl;
	
	return 0;
}
