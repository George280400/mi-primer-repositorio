import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Producto } from '../../../Entidades/Producto';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-productos',
  imports: [FormsModule],
  templateUrl: './guardar-productos.html',
  styleUrl: './guardar-productos.css'
})
export class GuardarProductos {

  constructor(private router : Router, private service : ServiceWS){}

  producto : Producto = new Producto();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarP(){
    this.service.guardarPWS(this.producto).subscribe(data =>{
      
     Swal.fire({
      icon: "success",
      title: "GUARDAR",
      text: JSON.stringify(data),
      confirmButtonText : "OK"
    });
    this.router.navigate(['listarP']);
  }, error => {
    Swal.fire({
      icon: "error",
      title: "GUARDAR",
      text: JSON.stringify(error),
      confirmButtonText : "OK"
    });
  });
  }

}
