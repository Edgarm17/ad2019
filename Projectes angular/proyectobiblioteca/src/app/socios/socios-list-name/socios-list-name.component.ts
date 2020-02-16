import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {SociosService} from '../socios.service';
import {Socio} from '../socio';

@Component({
  selector: 'app-socios-list-name',
  templateUrl: './socios-list-name.component.html',
  styleUrls: ['./socios-list-name.component.css']
})
export class SociosListNameComponent implements OnInit {

  listaSocios: Socio[] = [];
  nombre: string = '';
  socioSeleccionado: Socio = new Socio();
  haSeleccionado: boolean = false;

  @Output() socioABuscar = new EventEmitter();

  constructor(private socioService: SociosService) { }

  ngOnInit(): void {
  }

  buscarPorNombre(){
    this.haSeleccionado = false;
    this.socioService.getSocioByName(this.nombre).subscribe(
      data => {
        this.listaSocios = data;
      }
    );
  }

  seleccionarSocio(event,socio: Socio){
    this.haSeleccionado = true;
    this.socioSeleccionado = socio;

    this.socioABuscar.emit({
      socio:socio
    })
  }
}


