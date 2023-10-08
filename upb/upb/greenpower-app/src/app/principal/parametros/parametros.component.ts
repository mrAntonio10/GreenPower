import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {ViveroArduinoPlantaService} from "../../service/viveroArduinoPlantaService/viveroArduinoPlanta.service";
import {Usuario} from "../../model/usuario/usuario";
import {MatTableDataSource} from "@angular/material/table";
import {ViveroArduinoPlanta} from "../../model/viveroArduinoPlanta/viveroArduinoPlanta";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-parametros',
  templateUrl: './parametros.component.html',
  styleUrls: ['./parametros.component.css']
})
export class ParametrosComponent implements OnInit {
  constructor(private viveroArduinoPlantaService: ViveroArduinoPlantaService,
              private router: Router,) {
  }

  displayedColumns: string[] = ['id', 'idPlanta', 'IdArduino']; //Headers table
  vaps: ViveroArduinoPlanta[] = []; //lista de respuesta REST
  dataSource: any;

  // @ts-ignore
  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.obtenerVaps(1);
  }
  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }

  // @ts-ignore
  obtenerVaps(id: number): ViveroArduinoPlanta[] {
    this.viveroArduinoPlantaService.getVAPArduinoList(id).subscribe((data: any) => {
      console.log(data);
      this.vaps = data;
      this.dataSource = new MatTableDataSource<ViveroArduinoPlanta>(this.vaps);
      this.dataSource.paginator = this.paginator;
    });



  }
}
