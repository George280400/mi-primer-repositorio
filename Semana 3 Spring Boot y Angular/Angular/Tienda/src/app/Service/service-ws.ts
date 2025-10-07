import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../Entidades/Producto';
import { Observable } from 'rxjs';
import { Categoria } from '../Entidades/Categoria';
import { Cliente } from '../Entidades/Cliente';
import { Empleado } from '../Entidades/Empleado';
import { Proveedor } from '../Entidades/Proveedor';
import { Venta } from '../Entidades/Venta';

@Injectable({
  providedIn: 'root'
})
//se encargta de consumir los controllers
export class ServiceWS {

  //inyeccion de dependencias del constructor
  constructor(private http: HttpClient) { }

  //configuracion del web service

  url = 'http://localhost:9000';

  //servicios de productos

  listarPWS() {
    return this.http.get<Producto[]>(this.url + "/P");
  }

  guardarPWS(producto: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/P`, producto, { headers: headers, responseType: 'text' });
  }

  eliminarPWS(codigoBarras: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/P/${codigoBarras}`, { responseType: "text" as "json" });
  }

  editarPWS(producto: any) {
    return this.http.put<String>(this.url + "/P", producto, { responseType: "text" as "json" });
  }

  buscarPWS(codigoBarras: number): Observable<Producto> {
    return this.http.get<Producto>(`${this.url}/P/${codigoBarras}`);
  }

  // Servicios de categorias
  listarCWS() {
    return this.http.get<Categoria[]>(this.url + "/C");
  }

  guardarCWS(categoria: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/C`, categoria, { headers: headers, responseType: 'text' });
  }

  eliminarCWS(idCategoria: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/C/${idCategoria}`, { responseType: "text" as "json" });
  }

  editarCWS(categoria: any) {
    return this.http.put<String>(this.url + "/C", categoria, { responseType: "text" as "json" });
  }

  buscarCWS(idCategoria: number): Observable<Categoria> {
    return this.http.get<Categoria>(`${this.url}/C/${idCategoria}`);
  }

  // Servicios de Clientes
  listarCLWS() {
    return this.http.get<Cliente[]>(this.url + "/Client");
  }

  guardarCLWS(cliente: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/Client`, cliente, { headers: headers, responseType: 'text' });
  }

  eliminarCLWS(idCliente: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/Client/${idCliente}`, { responseType: "text" as "json" });
  }

  editarCLWS(cliente: any) {
    return this.http.put<String>(this.url + "/Client", cliente, { responseType: "text" as "json" });
  }

  buscarCLWS(idCliente: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.url}/Client/${idCliente}`);
  }

  // Servicios de Empleados
  listarEWS() {
    return this.http.get<Empleado[]>(this.url + "/E");
  }

  guardarEWS(empleado: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/E`, empleado, { headers: headers, responseType: 'text' });
  }

  eliminarEWS(idEmpleado: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/E/${idEmpleado}`, { responseType: "text" as "json" });
  }

  editarEWS(empleado: any) {
    return this.http.put<String>(this.url + "/E", empleado, { responseType: "text" as "json" });
  }

  buscarEWS(idEmpleado: number): Observable<Empleado> {
    return this.http.get<Empleado>(`${this.url}/E/${idEmpleado}`);
  }

  // Servicios de Proveedor
  listarPRWS() {
    return this.http.get<Proveedor[]>(this.url + "/Proveedor");
  }

  guardarPRWS(proveedor: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/Proveedor`, proveedor, { headers: headers, responseType: 'text' });
  }

  eliminarPRWS(idProveedor: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/Proveedor/${idProveedor}`, { responseType: "text" as "json" });
  }

  editarPRWS(proveedor: any) {
    return this.http.put<String>(this.url + "/Proveedor", proveedor, { responseType: "text" as "json" });
  }

  buscarPRWS(idProveedor: number): Observable<Proveedor> {
    return this.http.get<Proveedor>(`${this.url}/Proveedor/${idProveedor}`);
  }

  // Servicios de ventas
  listarVWS() {
    return this.http.get<Venta[]>(this.url + "/V");
  }

  guardarVWS(venta: any): Observable<String> {
    const headers = new HttpHeaders
      ({ 'content-Type': 'application/json' });

    return this.http.post(`${this.url}/V`, venta, { headers: headers, responseType: 'text' });
  }

  eliminarVWS(idVenta: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/V/${idVenta}`, { responseType: "text" as "json" });
  }

  editarVWS(venta: any) {
    return this.http.put<String>(this.url + "/V", venta, { responseType: "text" as "json" });
  }

  buscarVWS(idVenta: number): Observable<Venta> {
    return this.http.get<Venta>(`${this.url}/V/${idVenta}`);
  }



}
