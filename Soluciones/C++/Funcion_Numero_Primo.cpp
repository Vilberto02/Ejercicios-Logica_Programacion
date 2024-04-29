#include <iostream>
//Prototipo de funciones
void entrada(int &number);
void numeroPrimo(int numero);
int numeroPrimo2(int numero);
//Programa principal
int main (){
    int number;
    entrada(number);
    if (number<=0){
        printf("Error! No existe el numero primo de un negativo");
    }else {
        numeroPrimo(number);
        if (numeroPrimo2(number) == 2){
            printf("\n-> Es primo");
        }
    }
    return 0;
}

/*DECLARACION DE FUNCIONES*/
//Funcion que solicita datos al usuario.
void entrada(int &number){
    printf("Ingrese un numero entero positivo: ");
    scanf("%d", &number);
}
//Funcion que calcula un numero primo y lo imprime en pantalla
void numeroPrimo (int numero){
    int contador = 0;
    for (int i = 1; i<=numero; i++){
        if (numero%i==0){
            contador = contador + 1;
        }
    }
    if (contador == 2){
        printf("Es primo");
    }
}
//Funcion que calcula un numero primo y devuelve un contador.
int numeroPrimo2 (int numero){
    int contador = 0;
    for (int i = 1; i<=numero; i++){
        if (numero%i==0){
            contador = contador + 1;
        }
    }
    return contador;
}