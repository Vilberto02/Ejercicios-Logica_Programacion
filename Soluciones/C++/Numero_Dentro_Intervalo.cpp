/*
Dado dos valores X e Y que forman un intervalo cerrado, y un 
valor W, realice un programa para determinar si W está dentro
o fuera del intervalo.
*/
#include<iostream>
using namespace std;
int main(){
	int x=499, y=505, w;
	cout<<"Adivine si un numero esta dentro de un intervalo.";
	do{
		cout<<"\nIngrese el valor de W: "; cin>>w;
		if(w>x && w<y){
			cout<<"-> El numero "<<w<<" se encuentra dentro del intervalo <"<<x<<", "<<y<<">.";
		} else{
			cout<<"-> No se encuentra dentro del intervalo. :(";
		}
		cout<<endl;
	}while(!(w>x && w<y));
	return 0;
}
