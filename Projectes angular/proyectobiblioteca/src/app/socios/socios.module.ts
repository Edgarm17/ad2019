import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SociosComponent } from './socios.component';
import { SociosListComponent } from './socios-list/socios-list.component';
import { SociosListNameComponent } from './socios-list-name/socios-list-name.component';
import { SociosCreateComponent } from './socios-create/socios-create.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [SociosComponent, SociosListComponent, SociosCreateComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    SociosListComponent, SociosCreateComponent, SociosComponent
  ]
})
export class SociosModule { }
