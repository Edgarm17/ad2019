import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {PrestamosService} from '../prestamos.service';
import {Prestamo} from '../prestamo';

@Component({
  selector: 'app-prestamos-list',
  templateUrl: './prestamos-list.component.html',
  styleUrls: ['./prestamos-list.component.css']
})
export class PrestamosListComponent implements OnInit {

  listaPrestamos: Prestamo[];
  @Output() actualizarPrestamoSeleccionado = new EventEmitter();

  constructor(private prestamoService: PrestamosService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void{
    this.prestamoService.getAllPrestamos().subscribe(
      data =>{
        this.listaPrestamos = data;
      }
    );
  }

  deletePrestamo(fprestamo: string){
    this.prestamoService.deletePrestamo(fprestamo).subscribe(
      data=>{
        this.reloadData();
      }
    );
  }

  updatePrestamo(fprestamo: string){
    this.actualizarPrestamoSeleccionado.emit(fprestamo);
  }

}
