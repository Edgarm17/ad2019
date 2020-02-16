import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {LibrosService} from '../libros.service';
import {Libro} from '../libro';

@Component({
  selector: 'app-libros-list',
  templateUrl: './libros-list.component.html',
  styleUrls: ['./libros-list.component.css']
})
export class LibrosListComponent implements OnInit {

  listaLibros: Libro[];
  @Output() actualizarLibroSeleccionado = new EventEmitter();

  constructor(private libroService: LibrosService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void{
    this.libroService.getAllLibros().subscribe(
      data =>{
        this.listaLibros = data;
      }
    );
  }

  deleteLibro(isbn: number){
    this.libroService.deleteLibro(isbn).subscribe(
      data=>{
        this.reloadData();
      }
    );
  }

  updateLibro(isbn: number){
    this.actualizarLibroSeleccionado.emit(isbn);
  }

}
