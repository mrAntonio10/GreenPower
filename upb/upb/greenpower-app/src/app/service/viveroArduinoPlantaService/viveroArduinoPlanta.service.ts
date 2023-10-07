import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ViveroArduinoPlanta} from "../../model/viveroArduinoPlanta/viveroArduinoPlanta";

@Injectable({
  providedIn: 'root'
})
export class ViveroArduinoPlantaService {
  private baseUrl = "http://localhost:8084/api/viveroArduinoPlanta";

  constructor(private httpClient: HttpClient) {
  }

  getViveroArduinoPlantaList(): Observable<ViveroArduinoPlanta[]>{
    return this.httpClient.get<ViveroArduinoPlanta[]>(`${this.baseUrl}/findAll`)
  }
}
