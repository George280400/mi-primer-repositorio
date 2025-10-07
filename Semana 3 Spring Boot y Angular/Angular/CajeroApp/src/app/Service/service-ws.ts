import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {

  //inyeccion de dependencias del constructor
  constructor(private http: HttpClient) { }

  //configuracion del url del webService
  Url = 'http://localhost:8080/api/cajero';

  retirar(monto: number): Observable<any> {
    return this.http.post<any>(`${this.Url}/retirar/${monto}`, {});
  }
  
}
