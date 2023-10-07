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

  getPlantaList(): Observable<Planta[]>{
    return this.httpClient.get<Planta[]>(`${this.baseUrl}`)
  }
  getPlantaId(id :number):Observable<Planta>{
    return this.httpClient.get<Planta>(`${this.baseUrl}`+id)
  }
}
