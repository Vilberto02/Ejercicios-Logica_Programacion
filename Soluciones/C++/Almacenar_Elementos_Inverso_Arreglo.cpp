#include<iostream>
using namespace std;
int main(){
	//Guardar en un orden inverso los elementos de un arreglo en otro arreglo.
	int arregloInicial[5], arregloInverso[5];
	
	for(int i=0; i<5; i++){
		cout<<"Arreglo["<<i+1<<"]: "; cin>>arregloInicial[i];
	}
	
	//Reordenamiento de los elementos del arreglo.
	for (int i=0; i<5;i++){
		arregloInverso[i] = arregloInicial[4-i];
	}
	
	//Se imprime el arreglo original
	cout<<"\n*** Arreglo original ***"<<endl;
	for(int i=0; i<5; i++){
		cout<<"Arreglo["<<i+1<<"]: "<<arregloInicial[i]<<endl;
	}
	
	cout<<endl;
	
	//Se imprime el arreglo inverso
	cout<<"\n*** Arreglo inverso ***"<<endl;
	for(int i=0; i<5; i++){
		cout<<"Arreglo["<<i+1<<"]: "<<arregloInverso[i]<<endl;
	}
	
	return 0;
}
