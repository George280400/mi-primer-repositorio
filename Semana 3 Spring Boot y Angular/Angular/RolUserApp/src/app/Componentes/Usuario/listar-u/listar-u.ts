import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Usuario } from '../../../Entidades/Usuario';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listar-u',
  imports: [FormsModule],
  templateUrl: './listar-u.html',
  styleUrl: './listar-u.css'
})
export class ListarU implements OnInit{

  constructor(private router : Router, private service : ServiceWS){}

usuario : Usuario =new Usuario();
usuarios !: Usuario[];

  ngOnInit(): void {

    this.listarUsuario();
    
  }

  listarUsuario(){
    this.service.listarUWS().subscribe(data=>{
      this.usuarios= data ;
    })
  }

 editarButton(usuario : Usuario){
         localStorage.setItem('usuario', JSON.stringify(usuario));
         console.log(localStorage);
         this.router.navigate(["editarU"]);
       }
     
       
       //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
     eliminarButton(idUsuario: number) {
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
       this.service.eliminarUWS(idUsuario).subscribe(() => {
         Swal.fire({
           title: "Eliminado!",
           text: "El registro ha sido eliminado.",
           icon: "success"
         });
         this.listarUsuario();
       });
     } else if (result.isDismissed) {
       Swal.fire("La eliminación fue cancelada", "", "info");
     }
   });
 }

}
