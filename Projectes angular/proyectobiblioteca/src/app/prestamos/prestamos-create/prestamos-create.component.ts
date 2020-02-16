import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {PrestamosService} from '../prestamos.service';
import {Prestamo} from '../prestamo';

@Component({
  selector: 'app-prestamos-create',
  templateUrl: './prestamos-create.component.html',
  styleUrls: ['./prestamos-create.component.css']
})
export class PrestamosCreateComponent implements OnInit {

  prestamo: Prestamo = new Prestamo();
  actualizar: boolean = false;
  idPrestamo: string;
  

  @Output() prestamoNuevo = new EventEmitter();

  constructor(private prestamoService: PrestamosService) { }

  ngOnInit():void {
  }

  newPrestamo():void{
    this.actualizar = false;
    this.prestamo = new Prestamo();
  }

  insertarSocio(event){
    this.prestamo.socio = event.socio.numsocio;
  }

  insertarLibro(event){
    console.log(event)
    this.prestamo.libro = event.libro.isbn;
  }

  savePrestamo(){
    this.prestamoService.createPrestamo(this.prestamo).subscribe(
      data =>{
        this.newPrestamo();
        this.prestamoNuevo.emit();
      }
    );
  }

  updatePrestamo(){
    this.prestamoService.updatePrestamo(this.prestamo,this.idPrestamo).subscribe(
      data =>{
        this.prestamo = data;
        this.prestamoNuevo.emit();
      }
    );
  }

  rellenarFormularioActualizar(id: string){
    this.actualizar = true;
    this.idPrestamo = id;
    this.prestamoService.getPrestamoById(id).subscribe(
      data=>{
        this.prestamo = data;
      }
    );
  }

}
