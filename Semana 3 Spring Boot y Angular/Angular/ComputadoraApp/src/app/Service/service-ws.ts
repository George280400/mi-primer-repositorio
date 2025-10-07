import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Computadora } from '../Entidad/Computadora';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
//es el que se encargara de consumir los controladores del backend
export class ServiceWS {
  //inyeccion de dependencias del constructor
  constructor(private http : HttpClient){}

  //configuracion del url del webService
  url = 'http://localhost:8080/api/Compu';

  //declaracion de los metodos para consumir los controladores del backend
  listarCWS(){
    return this.http.get<Computadora[]>(this.url + "/listar");
  }

  guardarCWS(computadora: any){
    return this.http.post<String>(this.url + "/guardar", computadora);
  }
  
  editarCWS(computadora: any){
    return this.http.put<String>(this.url + "/editar", computadora);
  }

  buscarCWS(computadora : Computadora){
    return this.http.post<Computadora>(this.url + "/buscar", computadora);
  }

  eliminarCWS(computadora : Computadora): Observable<void>{

    return this.http.delete<void>(`${this.url}/eliminar`
, {body : computadora})
    
  }
}
