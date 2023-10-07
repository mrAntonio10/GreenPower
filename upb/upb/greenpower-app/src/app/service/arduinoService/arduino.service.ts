import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Arduino} from "../../model/arduino/arduino";

@Injectable({
  providedIn: 'root'
})
export class ArduinoService {
  private baseUrl = "http://localhost:8084/api/arduinos";

  constructor(private httpClient: HttpClient) {
  }

  getArduinos(): Observable<Arduino[]>{
    return this.httpClient.get<Arduino[]>(`${this.baseUrl}`)
  }

  getArduinoById(id: number): Observable<Arduino[]>{
    return this.httpClient.get<Arduino[]>(`${this.baseUrl}/`+id)
  }
}
