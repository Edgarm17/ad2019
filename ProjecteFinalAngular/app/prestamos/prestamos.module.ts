import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrestamosComponent } from './prestamos.component';
import { PrestamosListComponent } from './prestamos-list/prestamos-list.component';
import { PrestamosListNameComponent } from './prestamos-list-name/prestamos-list-name.component';
import { PrestamosCreateComponent } from './prestamos-create/prestamos-create.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LibrosListNameComponent } from '../libros/libros-list-name/libros-list-name.component';
import { SociosListNameComponent } from '../socios/socios-list-name/socios-list-name.component';


@NgModule({
  declarations: [PrestamosComponent, PrestamosListComponent, PrestamosListNameComponent, PrestamosCreateComponent,LibrosListNameComponent,SociosListNameComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    PrestamosListComponent, PrestamosCreateComponent, PrestamosComponent, PrestamosListNameComponent
  ]
})
export class PrestamosModule { }
