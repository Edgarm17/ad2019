#include <stdio.h>
#include <iostream>


using namespace std;

int * maximo(int *dir1, int *dir2){
	int num1 = *dir1;
	int num2 = *dir2;
	
	if(num1>num2){
		
		return dir1;
	}else{
		
		return dir2;
	}
}

int main (int argc, char *argv[] ) {

	int a = 10;
   	int b = 5;

   	cout << " a vale " << a <<endl;
   	cout << " b vale " << b << endl;

   	

   	*(maximo(&a, &b))=0;

   	

   	cout << " a vale " << a <<endl;
   	cout << " b vale " << b << endl;
	
 
}


