import { Component, OnInit, ViewChild } from '@angular/core';
import { SociosListComponent } from './socios-list/socios-list.component';
import { SociosCreateComponent } from './socios-create/socios-create.component';

@Component({
  selector: 'app-socios',
  templateUrl: './socios.component.html',
  styleUrls: ['./socios.component.css']
})
export class SociosComponent implements OnInit {

  @ViewChild(SociosListComponent, null) sociosList: SociosListComponent;
  @ViewChild(SociosCreateComponent, null) sociosCreate: SociosCreateComponent; 

  constructor() { }

  ngOnInit() {
  }

  

  actualizarTabla(){
    this.sociosList.reloadData();
  } 

  rellenarFormulario(id){
    this.sociosCreate.rellenarFormularioActualizar(id);
  }  

}
