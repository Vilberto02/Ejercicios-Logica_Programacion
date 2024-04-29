//Sumar dos matrices de orden n.
#include <iostream>
#define MX 3
#define MY 3
using namespace std;

int main (){
	int matriz1[MX][MY], matriz2[MX][MY], sumaM[MX][MY];
	cout<<"\tMatriz 1"<<endl;
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<"["<<i+1<<"]["<<j+1<<"]: "; cin>>matriz1[i][j];
		}
	}
	
	cout<<endl<<"\tMatriz 2"<<endl;
	for(int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<"["<<i+1<<"]["<<j+1<<"]: "; cin>>matriz2[i][j];
		}
	}
	
	cout<<endl<<"REPORTE DE MATRIZ 1"<<endl;
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<" "<<matriz1[i][j]<<"  ";
		}
		cout<<endl;
	}
	
	cout<<endl<<"REPORTE DE MATRIZ 2"<<endl;
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<" "<<matriz2[i][j]<<"  ";
		}
		cout<<endl;
	}
	
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			sumaM[i][j] = matriz1[i][j] + matriz2[i][j];
		}
	}
	
	cout<<endl<<"SUMA DE MATRIZ 1 Y MATRIZ 2"<<endl;
	for (int i=0; i<MX; i++){
		for (int j=0; j<MY; j++){
			cout<<" "<<sumaM[i][j]<<"  ";
		}
		cout<<endl;
	}
	
	return 0;
}
