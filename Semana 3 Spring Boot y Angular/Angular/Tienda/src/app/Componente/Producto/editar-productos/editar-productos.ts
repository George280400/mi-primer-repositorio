import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ServiceWS } from '../../../Service/service-ws';
import { Producto } from '../../../Entidades/Producto';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-productos',
  imports: [FormsModule],
  templateUrl: './editar-productos.html',
  styleUrl: './editar-productos.css'
})
export class EditarProductos implements OnInit{

constructor(private router: Router, private service: ServiceWS) { }

  producto: Producto = new Producto();

  ngOnInit(): void {
    
    this.buscarProducto();
  }

   buscarProducto() {
  const prodString = localStorage.getItem('producto');
  if (prodString) {
    this.producto = JSON.parse(prodString);
  }

  this.service.buscarPWS(this.producto.codigoBarras).subscribe(data => {
    this.producto = data;
    Swal.fire({
      title: "EDITAR",
      icon: "success",
      text: "Informacion cargada",
      showConfirmButton: false,
      timer: 2000
    });
  }, error => {
    Swal.fire({
      icon: 'error',
      title: "EDITAR",
      text: "Ocurrio un error",
      confirmButtonText: "OK"
    });
  });
}

  //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
  editarProducto() {
  this.service.editarPWS(this.producto).subscribe(data => {
    Swal.fire({
      title: "EDITAR",
      icon: "success",
      text: "El Producto: " + this.producto.nombre + " se edito correctamente",
      showConfirmButton: false,
      timer: 2100
    }).then(() => {
      this.router.navigate(['listarP']);
    });
  });
}

  

}
