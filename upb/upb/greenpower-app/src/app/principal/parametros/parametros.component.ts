import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-parametros',
  templateUrl: './parametros.component.html',
  styleUrls: ['./parametros.component.css']
})
export class ParametrosComponent {
  constructor(private router: Router) {
  }

  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }

}
