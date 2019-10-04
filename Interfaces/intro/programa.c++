#include <stdio.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

void infoVector(int vector[10]){
	
	
	for(int i = 0; i<10; i++){
		
		
		cout <<  vector[i] << "  ";
	
	}
	
	cout << "\n" << endl;

}

float calcularMedia(int vector[10]){

	float media;
	
	media = 0;

	for(int i = 0; i<10; i++){
		
		
		media += vector[i];
	
	}

	media = media/10;
	
	return media;

}

int calcularPosMax(int vector[10]){

	int max ;
	max = 0;
	
	for(int i = 1; i<10; i++){
	
		if(vector[i]>vector[max]){
			max = i;
		}
		
	}
	
	return max;

}

int calcularPosMin(int vector[10]){

	int min ;
	min = vector[0];
	
	int posMin = 0;
	
	for(int i = 0; i<10; i++){
	
		if(vector[i]<min){
			posMin = i;
		}
		
	}
	
	return posMin;

}


void intercambioMaxMin(int vector[10]){
	int aux;
	
	aux = vector[calcularPosMax(vector)];
	vector[calcularPosMax(vector)] = vector[calcularPosMin(vector)];	
	vector[calcularPosMin(vector)] = aux;	
	
}

void intercambio(int vector[10], int num1, int num2){
	int aux;
	
	aux = vector[num1];
	vector[num1] = vector[num2];
	vector[num2] = aux;
	
	
}

void elementosRepetidos(int vector[0]){
	bool repetidos = false;

	for(int i=0;i<10;i++){
		for(int j=0;j<10;j++){
		
			
			if(vector[i] == vector[j] && i!=j){
				repetidos = true;
			}
		} 
	}
	
	if(repetidos){
		cout << "Hay repetidos" << endl;
	}else{
		cout << "No hay repetidos" << endl;
	}
}






int main(int argc, char *argv[]){
	



	

	/* inicialización*/
	
	int numeros[10];

	for(int i = 0; i<10; i++){
		
		int num = random() %10;

		numeros[i] = num;
		
	
	}

	/* mostrar el valor dels elements del vector*/


	
	
	//MOSTRAR LA MEDIA DE LOS ELEMENTOS;
	
	cout << "La media es: " << calcularMedia(numeros) << endl;
	
	//MOSTRAR EL MAX DE UN VECTOR
	
	cout << "La posicion del máximo es: " << calcularPosMax(numeros) << endl;
	
	cout << "INTERCAMBIO DE MAXIMO Y MINIMO" << endl;
	infoVector(numeros);
	intercambioMaxMin(numeros);
	infoVector(numeros);
	
	
	cout << "----------\n" << endl;
	cout << "INTERCAMBIO DE CUALQUIER POSICIÓN DEL ARREGLO" << endl;
	
	infoVector(numeros);
	intercambio(numeros,3,4);
	infoVector(numeros);
	
	int vec[10];
	
	for(int i = 0; i<10; i++){
		vec[i]=i;
		
	}
	
	cout << "Vector sin rep: ";
	elementosRepetidos(vec);
	cout << "Vector con rep: ";
	elementosRepetidos(numeros);
	
	
	
	
	
	
	
	
	
	
/*	
	cout << "Introduce un número:";
	cin >> a;
	
	cout << "El número es " << a << endl;	

	if (a>10){
		cout << "El número es mayor que 10" << endl;
	}else if(a==10){
		cout << "El número es igual a 10" << endl;
	}else{
		cout << "El número es menor que 10" << endl;
	}

	int cont = 1;

	while(cont<=10){
		cout << a << "*" << cont << " = " << a*cont << endl;
		cont++;
	}

    //	for (int i = 0; i++<10; cout << "" << i << "x" << a <<"="<<i*a<<endl);


*/
	
	
	

}
