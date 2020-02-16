import { Component, OnInit, ViewChild } from '@angular/core';
import { PrestamosListComponent } from './prestamos-list/prestamos-list.component';
import { PrestamosCreateComponent } from './prestamos-create/prestamos-create.component';
import { LibrosListNameComponent } from '../libros/libros-list-name/libros-list-name.component';
import { SociosListNameComponent } from '../socios/socios-list-name/socios-list-name.component';

@Component({
  selector: 'app-prestamos',
  templateUrl: './prestamos.component.html',
  styleUrls: ['./prestamos.component.css']
})
export class PrestamosComponent implements OnInit {

  

  @ViewChild(SociosListNameComponent, null) sociosListName: SociosListNameComponent;
  @ViewChild(LibrosListNameComponent, null) librosListName: LibrosListNameComponent;
  @ViewChild(PrestamosListComponent, null) prestamosList: PrestamosListComponent;
  @ViewChild(PrestamosCreateComponent, null) prestamosCreate: PrestamosCreateComponent; 

  constructor() { }

  ngOnInit() {
  }


  

  actualizarTabla(){
    this.prestamosList.reloadData();
  } 

  rellenarFormulario(id){
    this.prestamosCreate.rellenarFormularioActualizar(id);
  }  

}
