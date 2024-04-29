//Suma dos matrices de orden n usando funciones.
#include <iostream>
#include <string> //Control + click en la libreria.
#define MX 2
#define MY 2
using namespace std;

void ingresarMatriz(int matriz[MX][MY]);
void sumarMatrices(int matriz1[MX][MY], int matriz2[MX][MY], int matriz3[MX][MY]);
void mostrarMatriz(int matriz[MX][MY]);

int main (){
	int matriz1[MX][MY], matriz2[MX][MY], matriz3[MX][MY];
	cout<<"\tMatriz 1"<<endl;
	ingresarMatriz(matriz1);
	
	cout<<endl<<"\tMatriz 2"<<endl;
	ingresarMatriz(matriz2);
	
	cout<<endl<<"REPORTE DE LA MATRIZ 1"<<endl;
	mostrarMatriz(matriz1);
	
	cout<<endl<<"REPORTE DE LA MATRIZ 2"<<endl;
	mostrarMatriz(matriz2);
	
	sumarMatrices(matriz1, matriz2, matriz3);
	
	cout<<endl<<"SUMA DE MATRICES"<<endl;
	mostrarMatriz(matriz3);
	
	return 0;
}

void ingresarMatriz(int matriz[MX][MY]){
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<"Ingresa un numero ["<<i+1<<"]["<<j+1<<"]: "; cin>>matriz[i][j];
		}
	}
}

void sumarMatrices(int matriz1[MX][MY], int matriz2[MX][MY], int matriz3[MX][MY]){
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
		}
	}
}

void mostrarMatriz(int matriz[MX][MY]){
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<" "<<matriz[i][j]<<"  ";
		}
		cout<<endl;
	}
}
