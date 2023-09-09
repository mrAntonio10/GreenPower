import {Component, OnInit} from '@angular/core';
import {Bitacora} from "../../model/bitacora/bitacora";
import {BitacoraService} from "../../service/bitacoraService/bitacora.service";

@Component({
  selector: 'app-root',
  templateUrl: './bitacora.component.html',
  styleUrls: ['./bitacora.component.css']
})
export class BitacoraComponent implements OnInit{
  constructor(private bitacoraService: BitacoraService) {
  }

  // @ts-ignore
  bitacoras: Bitacora[];
  title = "Bitacora";

  ngOnInit(): void {
    this.getBitacoras();
  }

  private getBitacoras(){
    this.bitacoraService.getBitacoraList().subscribe(data =>{
      this.bitacoras = data;
      console.log(data);
    })
  }
}
