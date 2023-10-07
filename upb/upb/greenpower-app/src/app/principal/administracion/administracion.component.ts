import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {DataSource} from "@angular/cdk/collections";
import {Arduino} from "../../model/arduino/arduino";
import {MatPaginator} from "@angular/material/paginator";
import {Usuario} from "../../model/usuario/usuario";
import {UsuarioService} from "../../service/usuarioService/usuario.service";

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrls: ['./administracion.component.css']
})
export class AdministracionComponent implements OnInit {


  // constructor(private router: Router) {
  // }
  constructor(private usuarioService: UsuarioService,) {
  }

  displayedColumns: string[] = ['id', 'nombre', 'Rol', 'Estado', 'IdVivero']; //Headers table
  usuarios: Usuario[] = []; //lista de respuesta REST
  dataSource = new MatTableDataSource<Usuario>(this.usuarios);  //data
  // @ts-ignore
  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.obtenerUsuarios();
    this.dataSource.paginator = this.paginator;
  }

  // @ts-ignore
  obtenerUsuarios(): Usuario[] {
    this.usuarioService.getUsuarioList().subscribe((data: any) => {
      console.log(data);
      this.usuarios = data;
    });

    // navegar(ruta : string) {
    //   this.router.navigate(['/'+ruta]);
    // }
  }
}
