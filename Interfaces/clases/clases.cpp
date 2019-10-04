#include <iostream>
using namespace std;

class Cuenta {
public:
    string titular;
    string numCuenta;
    float saldo;

public:
    void ingresar(float cantidad){
        saldo+=cantidad;
    }

    void reintegrar(float cantidad){
        if (saldo < cantidad || cantidad < 0) return false;
        {
            saldo = saldo -cantidad;
            return true;
        }
        
        
    }



};

void mostrar(Cuenta  cuentaAMostrar){ // mostrar cuenta por pantalla, como es mostrar y no modifico lo paso como copia

    cout << "Cuenta: " << cuentaAMostrar.numCuenta << " de " << cuentaAMostrar.titular << " con saldo = " << cuentaAMostrar.saldo << endl;

}

void ingresar(Cuenta * cuentaAIngresar, float ingreso){

    if (ingreso < 0)
    {
        return;
    }else
    {
        cuentaAIngresar->saldo+=ingreso;
    }
    
    
    
}

bool reintegrar(Cuenta * pCuenta, float cantidad){
    if (pCuenta->saldo < cantidad){
        return false;
    }else
    {
        pCuenta->saldo-=cantidad;
        return true;
    }
    
}

// fer funcio per a mostrar cuenta per pantalla mostrar();

// fer funcio per a ingressar diners ingresar();

// fer funcio per a reintegrar diners reintegro();

int main(int argc, char *argv[]) {

cout << "bienvenido al banco" <<endl;

    Cuenta * c;

    // (*c).algo = c->algo
    c = new Cuenta();
    c->titular = "pepe";
    (*c).numCuenta ="001001001";
    (*c).saldo = 10.04 ;

    mostrar(*c);
    c.reintegrar(500); // reintegrar (&una,500);
    mostrar(*c);
    if (c.reintegrar(2000))
    {
        mostrar(*c);
    }else
    {
        cout << "No hay suficiente saldo en cuenta" << endl;
    }
    
    



    /*Cuenta * b;
    b=c;
    (*c).titular = "jose";
    cout << "titular de b " << (*b).titular << endl;
    */
}
