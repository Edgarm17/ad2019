import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {SociosService} from '../socios.service';
import {Socio} from '../socio';

@Component({
  selector: 'app-socios-create',
  templateUrl: './socios-create.component.html',
  styleUrls: ['./socios-create.component.css']
})
export class SociosCreateComponent implements OnInit {

  socio: Socio = new Socio();
  actualizar: boolean = false;
  idSocio: number;

  @Output() socioNuevo = new EventEmitter();

  constructor(private socioService: SociosService) { }

  ngOnInit():void {
  }

  newSocio():void{
    this.actualizar = false;
    this.socio = new Socio();
  }

  saveSocio(){
    this.socioService.createSocio(this.socio).subscribe(
      data =>{
        this.newSocio();
        this.socioNuevo.emit();
      }
    );
  }

  updateSocio(){
    this.socioService.updateSocio(this.socio,this.idSocio).subscribe(
      data =>{
        this.socio = data;
        this.socioNuevo.emit();
      }
    );
  }

  rellenarFormularioActualizar(id: number){
    this.actualizar = true;
    this.idSocio = id;
    this.socioService.getSocioById(id).subscribe(
      data=>{
        this.socio = data;
      }
    );
  }

}
