
#include <stdio.h>
#include <iostream>

using namespace std;
void mostrar(int numsPasados[10]) {
    for (int i=0; i<10 ; i++ )
      cout  << numsPasados[i]
        << " "  ;
    cout << endl;

}

int * maximo (int *vector, int * ultimo){
	
	int * puntMax = vector;
	
	while (vector <= ultimo){
		
		if(*vector > *puntMax){
			puntMax = vector;
			cout << *vector << "Es max" << endl;
		}else{
			cout << *vector << "No max" << endl;
		}
		
		vector++;
	}
	
	
	
	
	
	return puntMax;
}

int main (int argc, char *argv[] ) {

    int numeros[10] ;

    /* inicialización */
    for ( int i=0; i< 10 ; i++ ) {
       int numero =  random() % 10 ;
       numeros[ i ] = numero ;
    }

    mostrar(numeros);
    
    int * ultimo = &(numeros[9]);

    int * max = maximo (numeros,ultimo) ;
    *max = 0;
     

    mostrar(numeros);
}
