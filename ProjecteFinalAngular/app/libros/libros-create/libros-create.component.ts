import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {LibrosService} from '../libros.service';
import {Libro} from '../libro';

@Component({
  selector: 'app-libros-create',
  templateUrl: './libros-create.component.html',
  styleUrls: ['./libros-create.component.css']
})
export class LibrosCreateComponent implements OnInit {

  libro: Libro = new Libro();
  actualizar: boolean = false;
  idLibro: number;

  @Output() libroNuevo = new EventEmitter();

  constructor(private libroService: LibrosService) { }

  ngOnInit():void {
  }

  newLibro():void{
    this.actualizar = false;
    this.libro = new Libro();
  }

  saveLibro(){
    this.libroService.createLibro(this.libro).subscribe(
      data =>{
        this.newLibro();
        this.libroNuevo.emit();
      }
    );
  }

  updateLibro(){
    this.libroService.updateLibro(this.libro,this.idLibro).subscribe(
      data =>{
        this.libro = data;
        this.libroNuevo.emit();
      }
    );
  }

  rellenarFormularioActualizar(id: number){
    this.actualizar = true;
    this.idLibro = id;
    this.libroService.getLibroById(id).subscribe(
      data=>{
        this.libro = data;
      }
    );
  }

}
