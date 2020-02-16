import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {SociosService} from '../socios.service';
import {Socio} from '../socio';

@Component({
  selector: 'app-socios-list',
  templateUrl: './socios-list.component.html',
  styleUrls: ['./socios-list.component.css']
})
export class SociosListComponent implements OnInit {

  listaSocios: Socio[];
  @Output() actualizarSocioSeleccionado = new EventEmitter();

  constructor(private socioService: SociosService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void{
    this.socioService.getAllSocios().subscribe(
      data =>{
        this.listaSocios = data;
      }
    );
  }

  deleteSocio(numsocio: number){
    this.socioService.deleteSocio(numsocio).subscribe(
      data=>{
        this.reloadData();
      }
    );
  }

  updateSocio(numsocio: number){
    this.actualizarSocioSeleccionado.emit(numsocio);
  }

}
