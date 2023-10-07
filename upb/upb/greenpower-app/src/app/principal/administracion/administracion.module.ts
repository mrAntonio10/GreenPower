import {NgModule} from '@angular/core';
import {AdministracionComponent} from './administracion.component';
import {BrowserModule} from "@angular/platform-browser";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "../../app-routing.module";
import {RouterOutlet} from "@angular/router";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";

@NgModule({
    imports: [
        BrowserModule,
        CommonModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule,
        RouterOutlet,
        ReactiveFormsModule,
        MatTableModule,
        MatPaginatorModule,

    ],
  exports: [],
  declarations: [AdministracionComponent],
  providers: [],
})
export class AdministracionModule {
}
