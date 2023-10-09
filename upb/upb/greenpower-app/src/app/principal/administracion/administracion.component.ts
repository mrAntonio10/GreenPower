import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {DataSource} from "@angular/cdk/collections";
import {Arduino} from "../../model/arduino/arduino";
import {MatPaginator} from "@angular/material/paginator";
import {Usuario} from "../../model/usuario/usuario";
import {UsuarioService} from "../../service/usuarioService/usuario.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrls: ['./administracion.component.css']
})
export class AdministracionComponent implements OnInit {
  displayedColumns: string[] = ['id', 'nombre', 'nombreCompleto', 'Estado',]; //Headers table
  usuarios: Usuario[] = []; //lista de respuesta REST
  dataSource: any;
  // @ts-ignore
  @ViewChild(MatPaginator) paginator: MatPaginator;
  // @ts-ignore
  form: FormGroup;

  // constructor(private router: Router) {
  // }
  constructor(private usuarioService: UsuarioService,
              private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.obtenerUsuarios(1);


    // @ts-ignore
    this.form = new FormGroup({
      rol: new FormControl([Validators.required]),
      nombre:new FormControl('', [Validators.required]),
      password:new FormControl('', [Validators.required]),
      nombreCompleto: new FormControl('', [Validators.required]),
    });
  }
  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }

  saveNewUsuario(){
    this.usuarioService.addNuevoUsuario(this.form.value).subscribe(data => {
      console.log(data)
    });
  }
  // @ts-ignore
  obtenerUsuarios(id: number): Usuario[] {
    this.usuarioService.getUsuarioList(id).subscribe((data: any) => {
      console.log(data);
      this.usuarios = data;
      this.dataSource = new MatTableDataSource<Usuario>(this.usuarios);
      this.dataSource.paginator = this.paginator;
    });
  }
}
