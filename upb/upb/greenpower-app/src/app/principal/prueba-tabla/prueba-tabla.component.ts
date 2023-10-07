import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {Arduino} from "../../model/arduino/arduino";
import {ArduinoService} from "../../service/arduinoService/arduino.service";
import {HttpClient} from "@angular/common/http";
@Component({
  selector: 'app-prueba-tabla',
  templateUrl: './prueba-tabla.component.html',
  styleUrls: ['./prueba-tabla.component.css'],
})
export class PruebaTablaComponent implements OnInit {
  constructor(private arduinoService: ArduinoService,
              ) {}

  displayedColumns: string[] = ['id', 'nombre', 'sensor_actuador']; //Headers table
  arduinos: Arduino[] = []; //lista de respuesta REST
  // dataSource = new MatTableDataSource<Arduino>(this.arduinos);  //data
  dataSource: any;

  // @ts-ignore
  @ViewChild(MatPaginator) paginator: MatPaginator;



  ngOnInit() {
   this.obtenerArduinos();
  }
  // @ts-ignore
  obtenerArduinos(): Arduino[]{
    this.arduinoService.getArduinos().subscribe((data: any) => {  //consumir servicio
      console.log(data);
      this.arduinos = data;
      this.dataSource = new MatTableDataSource<Arduino>(this.arduinos);
      this.dataSource.paginator = this.paginator;
    });
  }

  // @ts-ignore
  obtenerArduinosId(id: number): Arduino[]{
    this.arduinoService.getArduinoById(id).subscribe((data: any) => {  //consumir servicio
      console.log(data);
      this.arduinos = data;
      this.dataSource = new MatTableDataSource<Arduino>(this.arduinos);
      this.dataSource .paginator = this.paginator;
    });
  }
}







