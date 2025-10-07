import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rol } from '../Entidades/Rol';
import { Observable } from 'rxjs';
import { Usuario } from '../Entidades/Usuario';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {

  constructor(private http: HttpClient) { }

  //configuracion del url

  url = 'http://localhost:8002/api';

  listarRWS() {
    return this.http.get<Rol[]>(this.url + "/rol/listar");
  }

  guardarRWS(rol: any) {
    return this.http.post<String>(this.url + "/rol/guardar", rol, { responseType: "text" as "json" });
  }

  eliminarRWS(idRol: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/rol/eliminar?idRol=${idRol}`);
  }

  editarRWS(rol: any) {
    return this.http.put<String>(this.url + "/rol/editar", rol);
  }

  buscarRWS(idRol: number): Observable<Rol> {
    return this.http.get<Rol>(`${this.url}/rol/buscar/${idRol}`);
  }





  listarUWS() {
    return this.http.get<Usuario[]>(this.url + "/usuario/listar");
  }

  guardarUWS(usuario: Usuario) {
    return this.http.post<String>(this.url + "/usuario/guardar", usuario, { responseType: "text" as "json" });
  }

  eliminarUWS(idUsuario: number): Observable<string> {
  return this.http.delete(`${this.url}/usuario/eliminar?idUsuario=${idUsuario}`, { responseType: 'text' });
}


  editarUWS(usuario: any) {
  return this.http.put(this.url + "/usuario/editar", usuario, { responseType: 'text' });
}


  buscarUWS(idUsuario: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/usuario/buscar/${idUsuario}`);


  }
}