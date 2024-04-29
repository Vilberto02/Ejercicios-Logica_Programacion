#include<iostream>
int main (){
    int numero;
    float suma = 0;
    float number[4], adicion[4];
    for (int i = 0; i<5; i++){
        printf("Ingrese el valor de un numero [%d]: ", i + 1);
        scanf("%f", &number[i]);
        adicion[i] = number[i];
        suma = suma + number[i];
    }
    printf("-> Sumatoria: %.2f\n", suma);
    for (int j = 0; j<5; j++){
        if (j != 4){
            printf("%.2f - ", adicion[j]);
        } else {
            printf("%.2f", adicion[j]);
        }
    }
    return 0;
}