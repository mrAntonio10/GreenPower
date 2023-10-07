import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Arduino} from "../../model/arduino/arduino";

@Injectable({
  providedIn: 'root'
})
export class ArduinoService {
  private baseUrl = "http://localhost:8084/api/arduino";

  constructor(private httpClient: HttpClient) {
  }

  getArduino(): Observable<Arduino[]>{
    return this.httpClient.get<Arduino[]>(`${this.baseUrl}/findAll`)
  }
}
