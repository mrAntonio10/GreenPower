import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-activacion-actuadores',
  templateUrl: './activacion-actuadores.component.html',
  styleUrls: ['./activacion-actuadores.component.css']
})
export class ActivacionActuadoresComponent {
  constructor(private router: Router) {
  }

  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }
}
