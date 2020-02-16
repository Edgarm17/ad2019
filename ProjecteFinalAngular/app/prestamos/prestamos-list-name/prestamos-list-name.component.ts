import { Component, OnInit } from '@angular/core';

import {PrestamosService} from '../prestamos.service';
import {Prestamo} from '../prestamo';

@Component({
  selector: 'app-prestamos-list-name',
  templateUrl: './prestamos-list-name.component.html',
  styleUrls: ['./prestamos-list-name.component.css']
})
export class PrestamosListNameComponent implements OnInit {

  listaPrestamos: Prestamo[] = [];
  nombre: string = '';
  prestamoSeleccionado: Prestamo = new Prestamo();
  haSeleccionado: boolean = false;


  constructor(private prestamoService: PrestamosService) { }

  ngOnInit(): void {
  }

  buscarPorNombre(){
    this.haSeleccionado = false;
    this.prestamoService.getPrestamoByFecha(this.nombre).subscribe(
      data => {
        this.listaPrestamos = data;
      }
    );
  }

  seleccionarPrestamo(prestamo: Prestamo){
    this.haSeleccionado = true;
    this.prestamoSeleccionado = prestamo;
  }
}


