/*
Enunciado: Desarrolle un programa que reciba como entrada un numero entre
1 y 12 e imprima el nombre del mes correspondiente. Tome en cuenta
posibles valores erróneos en la entrada.
*/
#include<iostream>
using namespace std;

int main(){
	int numeroMes;
	string nombreMes;
	do{
		nombreMes = "";
		cout<<"Ingrese un numero entre 1 y 12: "; cin>>numeroMes;
		switch(numeroMes){
			case 1:
				nombreMes = "Enero";
				break;
			case 2:
				nombreMes = "Febrero";
				break;
			case 3:
				nombreMes = "Marzo";
				break;
			case 4:
				nombreMes = "Abril";
				break;
			case 5:
				nombreMes = "Mayo";
				break;
			case 6:
				nombreMes = "Junio";
				break;
			case 7:
				nombreMes = "Julio";
				break;
			case 8:
				nombreMes = "Agosto";
				break;
			case 9:
				nombreMes = "Setiembre";
				break;
			case 10:
				nombreMes = "Octubre";
				break;
			case 11:
				nombreMes = "Noviembre";
				break;
			case 12:
				nombreMes = "Diciembre";
				break;
			default:
				nombreMes = "Invalido";
				break;
		}
		
		if (nombreMes != "Invalido"){
			cout<<"-> Mes: "<<nombreMes;
		} else{
			cout<<"-> ERROR, no existe dicho mes.";
		}
		cout<<endl<<endl;
	}while(nombreMes != "Invalido");
	return 0;
}
