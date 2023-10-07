import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Planta} from "../../model/planta/planta";

@Injectable({
  providedIn: 'root'
})
export class PlantaService {
  private baseUrl = "http://localhost:8084/api/plantas";

  constructor(private httpClient: HttpClient) {
  }

  getPlantasList(): Observable<Planta[]>{
    return this.httpClient.get<Planta[]>(`${this.baseUrl}`)
  }

  getPlantaById(id: number): Observable<Planta[]>{
    return this.httpClient.get<Planta[]>(`${this.baseUrl}/`+id)
  }
}
