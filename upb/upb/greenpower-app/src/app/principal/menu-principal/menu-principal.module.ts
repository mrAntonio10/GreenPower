import {NgModule} from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "../../app-routing.module";
import {RouterOutlet} from "@angular/router";
import {MenuPrincipalComponent} from "./menu-principal.component";

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterOutlet,
    ReactiveFormsModule,


],
  exports: [],
  declarations: [MenuPrincipalComponent],
  providers: [],
})
export class MenuPrincipalModule {
}
