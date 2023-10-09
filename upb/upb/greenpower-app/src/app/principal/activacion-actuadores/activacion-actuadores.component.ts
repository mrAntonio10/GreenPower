import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-activacion-actuadores',
  templateUrl: './activacion-actuadores.component.html',
  styleUrls: ['./activacion-actuadores.component.css']
})
export class ActivacionActuadoresComponent implements OnInit {
  // @ts-ignore
  formHumedad: FormGroup;
  // formTemperatura: FormGroup;
  constructor(private router: Router) {
  }

  ngOnInit() {
    // this.formHumedad = new FormGroup({
    //   rol: new FormControl([Validators.required]),
    //   nombre:new FormControl('', [Validators.required]),
    //   password:new FormControl('', [Validators.required]),
    //   nombreCompleto: new FormControl('', [Validators.required]),
    //   estado: new FormControl(false),
    //   vivero: new FormControl({ id: 1 }),
    // });
  }
  navegar(ruta : string) {
    this.router.navigate(['/'+ruta]);
  }
}
