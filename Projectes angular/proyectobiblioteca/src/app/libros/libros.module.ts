import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LibrosComponent } from './libros.component';
import { LibrosListComponent } from './libros-list/libros-list.component';
import { LibrosListNameComponent } from './libros-list-name/libros-list-name.component';
import { LibrosCreateComponent } from './libros-create/libros-create.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [LibrosComponent, LibrosListComponent, LibrosCreateComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    LibrosListComponent, LibrosCreateComponent, LibrosComponent
  ]
})
export class LibrosModule { }
