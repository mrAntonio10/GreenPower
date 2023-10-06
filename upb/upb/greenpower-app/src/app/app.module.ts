import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BitacoraComponent } from './principal/bitacora/bitacora.component';
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { LogInComponent } from './principal/log-in/log-in.component';
import { RegistroComponent } from './principal/registro/registro.component';
import { MenuPrincipalComponent } from './principal/menu-principal/menu-principal.component';
import { ParametrosComponent } from './principal/parametros/parametros.component';
import { ActivacionActuadoresComponent } from './principal/activacion-actuadores/activacion-actuadores.component';
import {AppRoutingModule} from "./app-routing.module";
import {RouterOutlet} from "@angular/router";
import { PrincipalComponent } from './principal/principal/principal.component';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
@NgModule({
  declarations: [
    BitacoraComponent,
    LogInComponent,
    RegistroComponent,
    MenuPrincipalComponent,
    ParametrosComponent,
    ActivacionActuadoresComponent,
    PrincipalComponent,
    AppComponent,

  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterOutlet,
    BrowserAnimationsModule,
    MatTableModule,
    MatInputModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
