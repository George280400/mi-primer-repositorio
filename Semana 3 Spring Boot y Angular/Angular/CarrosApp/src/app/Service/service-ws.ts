import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Carros } from '../Entidad/Carros';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
// es el que se encargara de consumir los controllers
export class ServiceWS {

  //inyeccion de dependencias del constructor
  constructor(private http : HttpClient){}

  //configuracion del web service

  url = 'http://localhost:8081/api/Carros';

  //declaracion de los metodos para consumir los controller del backend

  listarCWS(){
    return this.http.get<Carros[]>(this.url + "/listar");
  }

  guardarCWS(carro: any){
    return this.http.post<String>(this.url + "/guardar", carro);
  }
  
  editarCWS(carro: any){
    return this.http.put<String>(this.url + "/editar", carro);
  }

  buscarCWS(carro : Carros){
    return this.http.post<Carros>(this.url + "/buscar", carro);
  }

  eliminarCWS(carro : Carros): Observable<void>{

    return this.http.delete<void>(`${this.url}/eliminar`
, {body : carro})
    
  }
  
}
