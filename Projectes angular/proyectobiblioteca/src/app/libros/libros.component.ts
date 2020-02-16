import { Component, OnInit, ViewChild } from '@angular/core';
import { LibrosListComponent } from './libros-list/libros-list.component';
import { LibrosCreateComponent } from './libros-create/libros-create.component';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.css']
})
export class LibrosComponent implements OnInit {

  @ViewChild(LibrosListComponent, null) librosList: LibrosListComponent;
  @ViewChild(LibrosCreateComponent, null) librosCreate: LibrosCreateComponent; 

  constructor() { }

  ngOnInit() {
  }

  

  actualizarTabla(){
    this.librosList.reloadData();
  } 

  rellenarFormulario(id){
    this.librosCreate.rellenarFormularioActualizar(id);
  }  

}
