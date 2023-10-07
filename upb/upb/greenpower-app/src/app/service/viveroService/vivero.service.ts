import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vivero} from "../../model/vivero/vivero";

@Injectable({
  providedIn: 'root'
})
export class ViveroService {
  private baseUrl = "http://localhost:8084/api/vivero";

  constructor(private httpClient: HttpClient) {
  }

  getViveroList(): Observable<Vivero[]>{
    return this.httpClient.get<Vivero[]>(`${this.baseUrl}/findAll`)
  }
}
