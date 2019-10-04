#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#define BORRAPANTALLA(X) for (int i=0; i<X; i++, cout << endl);

using namespace std;

char * nombres[]={"juan","perico","andres","ramona","luci","pepi","mari","vengano","fulano","sotano"};

class Cuenta {
public:
    string titular;
    int numCuenta;
    float saldo;

    Cuenta(int numCuenta,float saldoInicial, string titular){
	this->numCuenta = numCuenta;
	saldo = saldoInicial;
	this->titular = titular;
    }
 
    Cuenta(){}

    bool  reintegrar(float cantidad){
	  if (cantidad > saldo) return false;
	  saldo -= cantidad;
	  return true;
	}
    void ingresar(float cantidad) { saldo += cantidad; }
private:
    float interes;
};

void mostrar(Cuenta cuentaMostrar){
    cout << "La cuenta " << cuentaMostrar.numCuenta 
	<< " de " << cuentaMostrar.titular
        << " tiene " << cuentaMostrar.saldo
	<<" euros " <<endl;
}

void inicializarCuentas(  Cuenta  cuentas[10]){
   for (int i=0; i<5; i++) 
    cuentas[i] = Cuenta(100+i,i*1000,nombres[i]);

//	cuentas[i] = new Cuenta(100+i,i*1000,nombres[i]);
}

Cuenta * seleccionarCuenta(Cuenta  cts[]) {
 
	cout << "méteme el numero de cuenta. Machote!" <<endl;
	int numCuenta ;
	cin >> numCuenta;
/****** COMPLETAR
	BUSCAR LA CUENTA 

***************/

    for (int i = 0; i < 10; i++){
        if (cts[i].numCuenta == numCuenta)
        {
            return &(cts[i]);
        }
        
    }


return NULL;  //EXPLICA ESTO: El return NULL se utiliza para devolver una cuenta vacia en caso de no encontrar la cuenta
	
}

int main (int argc, char *argv[] ) {

    Cuenta * cuentaSeleccionada;

    Cuenta  cuentas[10];

    inicializarCuentas(cuentas);
    cuentaSeleccionada = seleccionarCuenta(cuentas);

    if (cuentaSeleccionada != NULL) {mostrar(*cuentaSeleccionada);
    }else{
        cout << "No se ha encontrado la cuenta" << endl;
    }
    
    


}