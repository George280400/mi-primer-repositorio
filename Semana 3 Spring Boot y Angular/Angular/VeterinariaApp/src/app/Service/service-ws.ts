import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mascota } from '../Entidades/Mascota';
import { Responsable } from '../Entidades/Responsable';
import { Cliente } from '../Entidades/Cliente';
import { Veterinaria } from '../Entidades/Veterinaria';

@Injectable({
  providedIn: 'root'
})
//se encargta de consumir los controllers
export class ServiceWS {

   //inyeccion de dependencias del constructor
  constructor(private http: HttpClient) { }

  //configuracion del web service

  url = 'http://localhost:9000';

  //servicios de mascotas

  listarMWS() {
    return this.http.get<Mascota[]>(this.url + "/M/mascotasFull");
  }

  guardarMWS(mascota: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/M`, mascota, { headers: headers, responseType: 'text' });
  }

  eliminarMWS(idMascota: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/M/${idMascota}`, { responseType: "text" as "json" });
  }

  editarMWS(mascota: any) {
    return this.http.put<String>(this.url + "/M", mascota, { responseType: "text" as "json" });
  }

  buscarMWS(idMascota: number): Observable<Mascota> {
    return this.http.get<Mascota>(`${this.url}/M/${idMascota}`);
  }

  // Servicios de responsables
  listarRWS() {
    return this.http.get<Responsable[]>(this.url + "/R/responsablesFull");
  }

  guardarRWS(responsable: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/R`, responsable, { headers: headers, responseType: 'text' });
  }

  eliminarRWS(idResponsable: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/R/${idResponsable}`, { responseType: "text" as "json" });
  }

  editarRWS(responsable: any) {
    return this.http.put<String>(this.url + "/R", responsable, { responseType: "text" as "json" });
  }

  buscarRWS(idResponsable: number): Observable<Responsable> {
    return this.http.get<Responsable>(`${this.url}/R/${idResponsable}`);
  }

  // Servicios de Clientes
  listarCWS() {
    return this.http.get<Cliente[]>(this.url + "/C");
  }

  guardarCWS(cliente: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/C`, cliente, { headers: headers, responseType: 'text' });
  }

  eliminarCWS(idCliente: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/C/${idCliente}`, { responseType: "text" as "json" });
  }

  editarCWS(cliente: any) {
    return this.http.put<String>(this.url + "/C", cliente, { responseType: "text" as "json" });
  }

  buscarCWS(idCliente: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.url}/C/${idCliente}`);
  }

  // Servicios de Veterinarias
  listarVWS() {
    return this.http.get<Veterinaria[]>(this.url + "/V");
  }

  guardarVWS(veterinaria: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/V`, veterinaria, { headers: headers, responseType: 'text' });
  }

  eliminarVWS(idVeterinaria: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/V/${idVeterinaria}`, { responseType: "text" as "json" });
  }

  editarVWS(veterinaria: any) {
    return this.http.put<String>(this.url + "/V", veterinaria, { responseType: "text" as "json" });
  }

  buscarVWS(idVeterinaria: number): Observable<Veterinaria> {
    return this.http.get<Veterinaria>(`${this.url}/V/${idVeterinaria}`);
  }
  
}
