import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule} from "@angular/router";
import {LogInComponent} from "./principal/log-in/log-in.component";
import {RegistroComponent} from "./principal/registro/registro.component";
import {MenuPrincipalComponent} from "./principal/menu-principal/menu-principal.component";
import {PrincipalComponent} from "./principal/principal/principal.component";

//Rutas de navegacion
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: MenuPrincipalComponent},
  { path: 'registro', component: RegistroComponent},
  { path: 'logIng', component: LogInComponent}
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ]
})
export class AppRoutingModule { }
