import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Padre } from '../Entidades/Padre';
import { Hijo } from '../Entidades/Hijo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {

  constructor(private http : HttpClient){}

  //configuracion del url

  url = 'http://localhost:8001/api';

  listarPWS(){
    return this.http.get<Padre[]>(this.url + "/padre/listar");
  }

  guardarPWS(padre: any){
    return this.http.post<String>(this.url + "/padre/guardar", padre, {responseType : "text" as "json"});
  }

  eliminarPWS(idPadre: number): Observable<void> {
  return this.http.delete<void>(`${this.url}/padre/eliminar?idPadre=${idPadre}`);
}

editarPWS(padre: any){
    return this.http.put<String>(this.url + "/padre/editar", padre);
  }

  buscarPWS(idPadre: number) : Observable<Padre> {
  return this.http.get<Padre>(`${this.url}/padre/buscar/${idPadre}`);
}




  listarHWS(){
    return this.http.get<Hijo[]>(this.url + "/hijo/listar");
  }

  guardarHWS(hijo: Hijo){
    return this.http.post<String>(this.url + "/hijo/guardar", hijo, {responseType : "text" as "json"});
  }

   eliminarHWS(idHijo: number): Observable<void> {
  return this.http.delete<void>(`${this.url}/hijo/eliminar?idHijo=${idHijo}`);
}
  
}
