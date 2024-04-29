#include <iostream>
using namespace std;

// Prototipos
void cruzar_hombre(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos);
void cruzar_hombre_lobo(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos);
void cruzar_hombre_col(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos);
void cruzar_hombre_oveja(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos);

// Metodos/funciones
void cruzar_hombre(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos){
	if(o1_h == true){ // Hombre esta en la orilla 1, cruzara a la orilla 2
		if(!(o1_o && o1_l) && !(o1_o && o1_c)){ // Caso en el que si puede moverse solo
			//Se mueve a la orilla 2, por eso la orilla 1 es falsa ya que el hombre no esta en la orilla 1
			o1_h = false;
			o2_h = true;
			aciertos++;
			cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
		}else{
			cout << "Fallo" << endl;
		}
	}else{ // Hombre esta en la orilla 2
		if(!(o2_o && o2_l) && !(o2_o && o2_c)){ // Caso en el que si puede moverse solo
			//Se mueve a la orilla 1
			o2_h = false;
			o1_h = true;
			aciertos++;
			cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
		}else{
			cout << "Fallo" << endl;
		}
	}
}

void cruzar_hombre_lobo(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos){
	if(o1_h == true && o1_l == true){ // Hombre y lobo en la orilla 1
		if(!(o1_o && o1_c)){ // Caso en el que si puede moverse solo hombre y lobo
			//El hombre y el lobo se mueven a la orilla 2.
			o1_h = false; o1_l = false;
			//Estan en la orilla 2
			o2_h = true; o2_l = true;
			aciertos++;
			cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
		}else{
			cout << "Fallo" << endl;
		}
	}else if(o2_h == true && o2_l == true){ // Hombre y lobo en la orilla 2
		if((o2_o && o2_c)){ // Caso en el que si puede moverse con el lobo
			//Se mueven a la orilla 1
			o2_h = false; o2_l = false;
			//Estan en la orilla 1
			o1_h = true; o1_l = true;
			aciertos++;
			cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
		}else{
			cout << "Fallo" << endl;
		}
	}else{
		cout << "Fallo" << endl;
	}
}

void cruzar_hombre_col(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos){
	if(o1_h == true && o1_c == true){ // Hombre y col en la orilla 1
		if(!(o1_l && o1_o)){ // Caso en el que si puede moverse solo
			//Se meven a la orilla 2
			o1_h = false; o1_c = false;
			//Estan en la orilla 2
			o2_h = true; o2_c = true;
			aciertos++;
			cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
		}else{
			cout << "Fallo" << endl;
		}
	}else if(o2_h == true && o2_c == true){ // Hombre y col en la orilla 2
		if((o2_l && o2_o)){ // Caso en el que si puede moverse con la col
			//Se mueven a la orilla 1
			o2_h = false; o2_c = false;
			//Estan en la orilla 1
			o1_h = true; o1_c = true;
			aciertos++;
			cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
		}else{
			cout << "Fallo" << endl;
		}
	}else{
		cout << "Fallo" << endl;
	}
}

void cruzar_hombre_oveja(bool &o1_h, bool &o1_l, bool &o1_o, bool &o1_c, bool &o2_h, bool &o2_l, bool &o2_o, bool &o2_c, int &aciertos){
	if(o1_h == true && o1_o == true){ // Hombre y oveja en la orilla 1
		//Se mueven a la orilla 2
		o1_h = false; o1_o = false;
		//Estan en la orilla 2
		o2_h = true; o2_o = true;
		aciertos++;
		cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
	}else if(o2_h == true && o2_o == true){ // Hombre y oveja en la orilla 2
		//Se mueven a la orilla 1
		o2_h = false; o2_o = false;
		//Estan en la orilla 1
		o1_h = true; o1_o = true;
		aciertos++;
		cout << "Felicidades, tuviste " << aciertos << " aciertos" << endl;
	}else{
		cout << "Fallo" << endl;
	}
}

void menu(){
	bool o1_h, o1_l, o1_o, o1_c;
	bool o2_h, o2_l, o2_o, o2_c;
	int opcion;
	int aciertos;
	/*Estan en la orilla 1*/
	o1_h = true;
	o1_l = true;
	o1_o = true;
	o1_c = true;
	/*No hay nadie en la orilla 2*/
	o2_h = false;
	o2_l = false;
	o2_o = false;
	o2_c = false;
	
	aciertos = 0;
	
	do{
		system("CLS"); //Limpia pantalla
		cout<<"\tMENU\n";
		cout << "1. Cruzar al hombre solo" << endl;
		cout << "2. Cruzar al hombre y lobo" << endl;
		cout << "3. Cruzar al hombre y col" << endl;
		cout << "4. Cruzar al hombre y oveja" << endl;
		cout << "5. Salir" << endl;
		cout << "Opcion: "; cin >> opcion;
		switch(opcion){
			case 1:
				cruzar_hombre(o1_h, o1_l, o1_o, o1_c, o2_h, o2_l, o2_o, o2_c, aciertos);
				system("PAUSE"); //Presionar tecla
				break;
			case 2:
				cruzar_hombre_lobo(o1_h, o1_l, o1_o, o1_c, o2_h, o2_l, o2_o, o2_c, aciertos);
				system("PAUSE");
				break;
			case 3:
				cruzar_hombre_col(o1_h, o1_l, o1_o, o1_c, o2_h, o2_l, o2_o, o2_c, aciertos);
				system("PAUSE");
				break;
			case 4: 
				cruzar_hombre_oveja(o1_h, o1_l, o1_o, o1_c, o2_h, o2_l, o2_o, o2_c, aciertos);
				system("PAUSE");
				break;
			case 5: 
				cout<<"El programa termino"<<endl;
				system("PAUSE");
				break;
			default:
				cout << "Error! Opcion incorrecta" << endl;
				system("PAUSE");
				break;
		}
	}while(opcion != 5);
}
int main(){
	menu();
	return 0;
}
