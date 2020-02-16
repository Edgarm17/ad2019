import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LibrosComponent } from './libros/libros.component';
import { LibrosListNameComponent } from './libros/libros-list-name/libros-list-name.component';

import { SociosComponent } from './socios/socios.component';
import { SociosListNameComponent } from './socios/socios-list-name/socios-list-name.component';
import { PrestamosComponent } from './prestamos/prestamos.component';
import { PrestamosListNameComponent } from './prestamos/prestamos-list-name/prestamos-list-name.component';


const routes: Routes = [
  { path:'libros' , component: LibrosComponent},
  { path:'librospornombre', component: LibrosListNameComponent},
  { path:'socios' , component: SociosComponent },
  { path:'sociospornombre', component: SociosListNameComponent },
  { path:'prestamos', component: PrestamosComponent },
  { path:'prestamosporfecha', component: PrestamosListNameComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
