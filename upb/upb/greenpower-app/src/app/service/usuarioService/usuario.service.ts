import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Usuario} from "../../model/usuario/usuario";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private baseUrl = "http://localhost:8084/api/usuario";

  constructor(private httpClient: HttpClient) {
  }

  getUsuarioList(): Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(`${this.baseUrl}/findAll`)
  }
}
