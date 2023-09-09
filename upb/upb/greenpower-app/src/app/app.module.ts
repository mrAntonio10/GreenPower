import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BitacoraComponent } from './principal/bitacora/bitacora.component';

@NgModule({
  declarations: [
    AppComponent,
    BitacoraComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [BitacoraComponent]
})
export class AppModule { }
