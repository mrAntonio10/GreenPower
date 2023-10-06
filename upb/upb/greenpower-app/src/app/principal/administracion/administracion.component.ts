import { Component, ViewChild  } from '@angular/core';
import {Router} from "@angular/router";
import { MatTable } from '@angular/material/table';

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrls: ['./administracion.component.css']
})
export class AdministracionComponent {
  constructor(private router: Router) {
  }
  @ViewChild(MatTable) tabla1!: MatTable<any>;
  columnas: string[] = ['codigo', 'descripcion', 'precio', 'borrar'];
  datos: any[] = [

  ]
  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }
}
