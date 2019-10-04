#include <stdio.h>
#include <iostream>  // cin, cout

using namespace std;

void incrementar(int * num){
    (*num)++;

}

void incrementarRef (int & num){
    num++;
}

int & max(int & num1, int & num2){
    
    

    if (num1<num2)
    {
        
        return num2;
    }else
    {
        return num1;
    }
    
    
}

int * max1 ( int * uno, int * dos){
    if (*uno > *dos)
    {
        return uno;
    }else
    {
        return dos;
    }
    
    
}

int main (int argc, char *argv[]){

    /*
    int a = 0;

    cout << "a vale " << a << " antes de incrementar" << endl;

    //DECLARACIO DE UNA REFERENCIA
    int &b = a;

    incrementar(&b);

    cout << "a vale " << a << " despues de incrementar b" << endl;

    int * p;

    p = &b;

    b = 9;

    cout << "a vale " << a << " despues de cambiar b" << endl;

    *(p) = 111;

    cout << "b vale " << b << " despues de cambiar p" << endl;
    cout << "a vale " << a << " despues de cambiar p" << endl;

    incrementarRef(b);

    cout << "b vale " << b << " despues de incrementar por referencia" << endl;

    */

   //POR REFERENCIA


    int a = 5;
    int b = 9;


    int &resultado = max( a,b ); //

    resultado++;

    cout << "devuelto vale " << b << endl;



}