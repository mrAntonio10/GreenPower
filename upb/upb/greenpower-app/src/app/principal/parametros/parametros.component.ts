import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {ViveroArduinoPlantaService} from "../../service/viveroArduinoPlantaService/viveroArduinoPlanta.service";
import {MatTableDataSource} from "@angular/material/table";
import {ViveroArduinoPlanta} from "../../model/viveroArduinoPlanta/viveroArduinoPlanta";
import {MatPaginator} from "@angular/material/paginator";
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidatorFn,
  Validators, ɵFormGroupRawValue,
  ɵGetProperty,
  ɵTypedOrUntyped
} from "@angular/forms";
import {HttpHeaders} from "@angular/common/http";
import {ArduinoService} from "../../service/arduinoService/arduino.service";

@Component({
  selector: 'app-parametros',
  templateUrl: './parametros.component.html',
  styleUrls: ['./parametros.component.css']
})
export class ParametrosComponent implements OnInit {
  constructor(private viveroArduinoPlantaService: ViveroArduinoPlantaService,
              private router: Router,
              private arduinoService: ArduinoService) {
  }

  displayedColumns: string[] = ['id', 'idPlanta', 'IdArduino']; //Headers table
  vaps: ViveroArduinoPlanta[] = []; //lista de respuesta REST
  dataSource: any;
  // @ts-ignore
  formHumedad: FormGroup;
  // @ts-ignore
  formTemperatura: FormGroup;
  // @ts-ignore
  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.obtenerVaps(1);
    this.formHumedad = new FormGroup({
      id: new FormControl(3), //pin 0
      parametro: new FormControl(0, [Validators.required]),
      parametroMin: new FormControl([Validators.required]),
      // pin: new FormControl(),
    });
    this.formTemperatura = new FormGroup({
      id: new FormControl(2), //pin 2
      parametro: new FormControl(0, [Validators.required]),
      parametroMin: new FormControl([Validators.required]),
      // pin: new FormControl(),
    });
  }
  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }

  updateArduinoHumedad(){
    console.log(this.formHumedad.value)
    this.arduinoService.updateArduino(this.formHumedad.value).subscribe(data => {
      const options = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        }),
        withCredentials: false  // Set this to false to disable sending credentials
      };

    });
  }

  updateArduinoTemperatura(){
    console.log(this.formTemperatura.value)
    this.arduinoService.updateArduino(this.formTemperatura.value).subscribe(data => {
      const options = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        }),
        withCredentials: false  // Set this to false to disable sending credentials
      };

    });
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
