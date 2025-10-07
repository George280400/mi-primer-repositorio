import { Component, OnInit } from '@angular/core';

import { ServiceWS } from '../../../Service/service-ws';
import { Producto } from '../../../Entidades/Producto';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-productos',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-productos.html',
  styleUrl: './listar-productos.css'
})
export class ListarProductos implements OnInit{

//constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

//instanciar el objeto
producto: Producto = new Producto();
productos !: Producto[];


  ngOnInit(): void {

    this.listarProducto();
    
  }

  listarProducto(){
    //susbribe se conecta con el flujo de datos e inicia la llamada http
    this.service.listarPWS().subscribe(data =>{
      this.productos=data
      console.log('listado exitoso' +JSON.stringify(data));
    })
  }

   editarButton(producto : Producto){
        localStorage.setItem('producto', JSON.stringify(producto));
        console.log(localStorage);
        this.router.navigate(["editarP"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(codigoBarras: number) {
  Swal.fire({
    title: "¿Está seguro de querer eliminarlo?",
    text: "Este movimiento no se puede revertir!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Sí, elimínalo!"
  }).then((result) => {
    if (result.isConfirmed) {
      this.service.eliminarPWS(codigoBarras).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarProducto();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}



}
