#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
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


void menu(void){
	BORRAPANTALLA(40);
	cout << "        1 - Elegir Cuenta " << endl;
	cout << "        2 - Ingresar " << endl;
	cout << "        3 - Reintegrar " << endl;
	cout << "        4 - Ver saldo " << endl;
	cout << "        5 - Seleccionar la cuenta con más saldo " << endl;
	cout << "        6 - mostrar Todas las cuentas "<< endl;
	cout << "        7 - Crear una cuenta nueva " << endl;
	cout << "        8 - Eliminar cuenta" << endl;
	cout << "        q - Salir a MSDOS " << endl;

	cout << " Pulsa una opción "<< endl;
	BORRAPANTALLA(10);
}
/*
void inicializarCuentas(  Cuenta  cuentas[10]){
   for (int i=0; i<5; i++) 
    cuentas[i] = Cuenta(100+i,i*1000,nombres[i]);

//	cuentas[i] = new Cuenta(100+i,i*1000,nombres[i]);
}
*/
void inicializarCuentas(  Cuenta * cuentas[10]){
	
	for (int i = 0; i < 10; i++)
	{
		cuentas[i]=NULL;
	}
	

   for (int i=0; i<5; i++) {
	Cuenta * temporal=new Cuenta(100+i,i*1000,nombres[i]);
	cuentas[i] = temporal;
	}
}



void crearCuenta(Cuenta * cuentas[10]){
	cout << "introduce el titular" ;
	string tit;
	cin >> tit;
	cout << endl;

	cout << "introduce el numero de cuenta" ;
	int numCuenta;
	cin >> numCuenta;
	cout << endl;


	for (int i=0; i<10; i++)
		if (cuentas[i]==NULL)  { 
			cuentas[i] = new Cuenta(numCuenta,0.5,tit);
			break;
		}

}




void mostrar(Cuenta * cuentaMostrar){
    cout << "La cuenta " << cuentaMostrar->numCuenta 
	<< " de " << cuentaMostrar->titular
        << " tiene " << cuentaMostrar->saldo
	<<" euros " <<endl;
}

void mostrarCuentas(Cuenta * todas[]){

/****** COMPLETAR
	MOSTRAR TODAS LAS CUENTAS QUE TIENEN TITULAR

***************/

	for (int i = 0; i < 10; i++)
	
	{
		if (todas[i]!=NULL)
		{
			mostrar(todas[i]);
		}
		
		
	}
	
}

void ingresar(Cuenta & c) {
	float cantidad;
	cout << "Dame la cantidad a ingresar en la cuent "<< c.numCuenta << endl;
	cin >> cantidad;
	c.ingresar(cantidad);	
}

bool reintegrar(Cuenta * c) {
	float cantidad;
	cout << " Introduce la cantidad a reintegrar:" << endl;
	cin >> cantidad;
	bool resultado =  c->reintegrar(cantidad);
	return resultado;
}

void mostrarSaldo(Cuenta c) {

}

Cuenta * seleccionarCuenta(Cuenta * cts[]) {
 
	cout << "méteme el numero de cuenta. Machote!" <<endl;
	int numCuenta ;
	cin >> numCuenta;
/****** COMPLETAR
	BUSCAR LA CUENTA 

***************/

    for (int i = 0; i < 10; i++){
        if ((cts[i]!=NULL) && (cts[i]->numCuenta == numCuenta) )
        {
            return cts[i];
        }
        
    }


return NULL;  //EXPLICA ESTO: El return NULL se utiliza para devolver una cuenta vacia en caso de no encontrar la cuenta
	
}


void eliminarCuenta(Cuenta ** cuentas, Cuenta * cuentaBorrar){

	for (int i = 0; i < 10; i++)
	{
		if (cuentas[i]!=NULL && cuentas[i]->numCuenta == cuentaBorrar->numCuenta)
		{
			cuentaBorrar = cuentas[i];
		}
		
	}
	


}

Cuenta *  seleccionarConMasSaldo(Cuenta * cts[]){

	

	Cuenta * masSaldo = cts[0];

	for (int i = 0; masSaldo == NULL && i<10; i++, masSaldo = cts[i]);
	

	

	for (int i = 0; i < 10 && masSaldo ; i++){
		if ((cts[i]!=NULL) && (cts[i]->saldo>masSaldo->saldo)){
			masSaldo = cts[i];
		}
		
		
	}
	
	return masSaldo;
	
}


int main (int argc, char *argv[] ) {

//  Cuenta  * cuentas[10];
	vector<Cuenta> cuentas;
	

 // for (int i=0; i < 10; i++) cuentas[i]=NULL;  // EXPLÍCATE ESTO

  Cuenta * cuentaSeleccionada;

  cuentaSeleccionada =  NULL;

  inicializarCuentas(cuentas);
  //mostrarCuentas(cuentas);

  char opcion;
  while ( true ) {
   menu();
   cin >> opcion;
   switch (opcion) {
	case '1': // opción uno es la de seleccionar una cuenta
	        cuentaSeleccionada = seleccionarCuenta(cuentas);
		break;

	case '2': if (cuentaSeleccionada != NULL)
			ingresar( *cuentaSeleccionada ); break;
	case '3': if ((cuentaSeleccionada!=NULL)&&( !reintegrar(cuentaSeleccionada))) 
			cout << "Error sacando pasta" << endl;
		  break;
	case '4': if (cuentaSeleccionada!=NULL ) mostrar(cuentaSeleccionada); break;
	case '5': 
			cuentaSeleccionada = seleccionarConMasSaldo(cuentas);
			cout << "Cuenta con mas saldo seleccionada. Cuenta: ";
			mostrar(cuentaSeleccionada);
		break;
	case '6': mostrarCuentas(cuentas); break;
	case '7': crearCuenta(cuentas);break;
	case '8': eliminarCuenta(cuentas,cuentaSeleccionada);
		  cuentaSeleccionada = NULL; break;
        case 'q': exit(0);
  };// switch
  cout << "Pulse una tecla y enter para seguir" << endl;
  cin >> opcion ;
 }//while
} // main

