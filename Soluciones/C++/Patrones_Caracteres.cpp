/*
n=5
12345
2   4
3   3
4   2
54321
*/
#include <iostream>
using namespace std;
int main(){
	int n;
	cout << "n: "; cin >> n;
	for(int i=1; i<=n; i++){
		if(i==1){
			for(int j=1; j<=n; j++){
				cout << j; //Se imprime de manera horizontal (inicio)
			}
		}else if(i==n){
			for(int j=n; j>=1; j--){
				cout << j; //Se imprime de manera horizontal (final)
			}
		}else{
			for(int j=1; j<=n; j++){
				if(j==1){
					cout << i;
				}else if(j==n){
					cout << n-i+1;
				}else{
					cout << " ";
				}
			}
		}
		cout << endl;
	}
	return 0;
}
