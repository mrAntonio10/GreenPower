import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vivero} from "../../model/vivero/vivero";
import {observableToBeFn} from "rxjs/internal/testing/TestScheduler";

@Injectable({
  providedIn: 'root'
})
export class ViveroService {
  private baseUrl = "http://localhost:8084/api/viveros";

  constructor(private httpClient: HttpClient) {
  }

  getViveroList(): Observable<Vivero[]>{
    return this.httpClient.get<Vivero[]>(`${this.baseUrl}`)
  }
  getViveroId(id: number): Observable<Vivero>{
    return  this.httpClient.get<Vivero>(`${this.baseUrl}`+id)
  }
}
