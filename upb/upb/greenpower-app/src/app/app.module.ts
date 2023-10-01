import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BitacoraComponent } from './principal/bitacora/bitacora.component';
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { LogInComponent } from './principal/log-in/log-in.component';
import { RegistroComponent } from './principal/registro/registro.component';
import { MenuPrincipalComponent } from './principal/menu-principal/menu-principal.component';
import { ParametrosComponent } from './principal/parametros/parametros.component';
import { ActivacionActuadoresComponent } from './principal/activacion-actuadores/activacion-actuadores.component';
@NgModule({
  declarations: [
    AppComponent,
    BitacoraComponent,
    LogInComponent,
    RegistroComponent,
    MenuPrincipalComponent,
    ParametrosComponent,
    ActivacionActuadoresComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [BitacoraComponent]
})
export class AppModule { }
