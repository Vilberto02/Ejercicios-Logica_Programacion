/*
Cree un algoritmo que tome como entrada la hora exacta 
(hora, minutos, segundo y AM/PM) e indique el numero de segundos
transcurridos durante ese dia.
*/

#include<iostream>
using namespace std;
string convertidorAMPM(string palabra);
int calcularSegundos(int h, int m, int s, string sistemaHorario);
int main(){
	int hora, minutos, segundos, cantidadSegundos = 0;
	string sistemaHorario = "";
	cout<<"Ingrese la hora: "; cin>>hora;
	cout<<"Ingrese los minutos: "; cin>>minutos;
	cout<<"Ingrese los segundos: "; cin>>segundos;
	cout<<"Ingrese si fue am o pm: "; cin>>sistemaHorario;
	sistemaHorario = convertidorAMPM(sistemaHorario);
	int segundosTranscurridos = calcularSegundos(hora, minutos, segundos, sistemaHorario);
	if(segundosTranscurridos != -1){
		cout<<"-> Cantidad de segundos transcurridos: "<<segundosTranscurridos<<" segundos"<<endl;	
	} else{
		cout<<"-> ERROR, los datos ingresados son incorrectos.";
	}
	return 0;
}

int calcularSegundos(int hora, int minutos, int segundos, string sistemaHorario){
	int cantidadSegundos = 0;
	if ((hora>=00 && hora<=12) && (minutos>=00 && minutos<60) && (segundos>=00 && segundos<60) && (sistemaHorario == "pm" || sistemaHorario == "am")){
		cout<<"Minuscula: "<<sistemaHorario<<endl;
		if(sistemaHorario == "am"){
			if(hora == 0){
				cantidadSegundos = cantidadSegundos + 3600*24;
			} else if(hora>=1 && hora<12){
				cantidadSegundos = cantidadSegundos + 3600*hora;
			}
		} else if(sistemaHorario == "pm"){
			if(hora == 12){
				cantidadSegundos = cantidadSegundos + 3600*hora;
			} else if(hora>=1 && hora<12) {
				cantidadSegundos = cantidadSegundos + 3600*(hora+12);		
			}
		}
		cantidadSegundos = cantidadSegundos + 60*minutos;
		cantidadSegundos = cantidadSegundos + segundos;
		return cantidadSegundos;
	} else{
		return -1;
	}
}

string convertidorAMPM (string palabra){
	string cadena = "";
	if(palabra == "AM" || palabra == "am"){
		cadena = "am";
	} else if(palabra == "PM" || palabra == "pm"){
		cadena = "pm";
	} 
	return cadena;
}
