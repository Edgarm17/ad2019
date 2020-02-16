import { Component, OnInit,Output, EventEmitter } from '@angular/core';

import {LibrosService} from '../libros.service';
import {Libro} from '../libro';

@Component({
  selector: 'app-libros-list-name',
  templateUrl: './libros-list-name.component.html',
  styleUrls: ['./libros-list-name.component.css']
})
export class LibrosListNameComponent implements OnInit {

  listaLibros: Libro[] = [];
  nombre: string = '';
  libroSeleccionado: Libro = new Libro();
  haSeleccionado: boolean = false;

  @Output() libroABuscar = new EventEmitter();

  constructor(private libroService: LibrosService) { }

  ngOnInit(): void {
  }

  buscarPorNombre(){
    this.haSeleccionado = false;
    this.libroService.getLibroByName(this.nombre).subscribe(
      data => {
        this.listaLibros = data;
      }
    );
  }

  seleccionarLibro(event, libro: Libro){
    this.haSeleccionado = true;
    this.libroSeleccionado = libro;

    this.libroABuscar.emit({
      libro: libro
    })
  }
}


