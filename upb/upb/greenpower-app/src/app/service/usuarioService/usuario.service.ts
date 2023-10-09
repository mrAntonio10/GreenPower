import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoginI, Usuario} from "../../model/usuario/usuario";
import {ResponseI} from "../../model/response/responseI";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private baseUrl = "http://localhost:8084/api/usuarios";

  constructor(private httpClient: HttpClient) {
  }

  getUsuarioList(id: number): Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(`${this.baseUrl}/`+id);
  }

  addNuevoUsuario(usuario: Usuario): Observable<Usuario>{
    return this.httpClient.post<Usuario>(`${this.baseUrl}`, usuario);
  }

  // @ts-ignore
  loginResponse(form: LoginI): Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/`+form.nombre+`/`+form.password);
  }

}
