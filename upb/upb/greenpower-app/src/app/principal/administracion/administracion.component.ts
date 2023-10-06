import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrls: ['./administracion.component.css']
})
export class AdministracionComponent {
  constructor(private router: Router) {
  }
  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }
}
