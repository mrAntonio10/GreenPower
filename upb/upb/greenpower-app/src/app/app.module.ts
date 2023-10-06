import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BitacoraComponent } from './principal/bitacora/bitacora.component';
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { LogInComponent } from './principal/log-in/log-in.component';
import { RegistroComponent } from './principal/registro/registro.component';
import { ParametrosComponent } from './principal/parametros/parametros.component';
import { ActivacionActuadoresComponent } from './principal/activacion-actuadores/activacion-actuadores.component';
import {AppRoutingModule} from "./app-routing.module";
import {RouterOutlet} from "@angular/router";
import { AppComponent } from './app.component';
import { AdministracionComponent } from './principal/administracion/administracion.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
@NgModule({
  declarations: [
    BitacoraComponent,
    LogInComponent,
    RegistroComponent,
    ParametrosComponent,
    ActivacionActuadoresComponent,
    AppComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterOutlet,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
