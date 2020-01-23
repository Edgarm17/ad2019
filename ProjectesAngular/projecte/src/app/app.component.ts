import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  nombre:string = 'Edgar';
  edad:number = 16;
  numeros:number[] =  [2,4,6];

  contador:number = 1;

  direccion() : string{
    //this.nombre;
    return 'Calle';
  }

  incrementar(){
    this.contador++;
  }

  decrementar(){
    this.contador--;
  }
}
