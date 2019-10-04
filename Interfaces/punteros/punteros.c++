#include <stdio.h>
#include <iostream>

using namespace std;

bool esPositivo(int i){
	
	return i >= 0;
	
}

//FER POSITIVA UNA VARIABLE NEGATIVA PASSANT COM A PARAMETRE POSICIO DE MEMORIA

void hazPositivo(int *dir){

	int aux = *dir;
	
	if(! esPositivo(aux)){
		
		*dir = -aux;
	}
	
	
}

int main (int argc, char *argv[] ) {
   	int i = 8;
   
   	int *p;
   
   	p = &i;
   
   
   
   	cout << "i vale (i = 8) = " << i << endl;
   	
   	
   	*p = -20;
   	
   	
   	if (esPositivo(i))
   		cout << " i es positivo, nada que tocar " << endl;
   	else
   		hazPositivo(p);
   		
   		
   		
   	
   	
   	
   	cout << "i vale (*p = 20) = " << i << endl;
   	
   	
   	
	cout << "i esta en la posicion " << p << " de ram " << endl;
}

