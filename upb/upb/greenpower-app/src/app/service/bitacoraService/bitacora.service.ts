import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bitacora} from "../../model/bitacora/bitacora";

@Injectable({
  providedIn: 'root'
})
export class BitacoraService {
  private baseUrl = "http://localhost:8084/api/bitacoras";

  constructor(private httpClient: HttpClient) {
  }

  getBitacoraList(): Observable<Bitacora[]>{
      return this.httpClient.get<Bitacora[]>(`${this.baseUrl}/findAll`)
  }
}
