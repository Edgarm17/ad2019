import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LibrosModule } from './libros/libros.module';
import { SociosModule } from './socios/socios.module';
import { PrestamosModule} from './prestamos/prestamos.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LibrosModule,
    SociosModule,
    PrestamosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
