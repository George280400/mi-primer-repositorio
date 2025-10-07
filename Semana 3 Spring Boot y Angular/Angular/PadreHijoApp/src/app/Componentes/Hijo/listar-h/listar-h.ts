import { Component, OnInit } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { Router } from '@angular/router';
import { Hijo } from '../../../Entidades/Hijo';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-h',
  imports: [],
  templateUrl: './listar-h.html',
  styleUrl: './listar-h.css'
})
export class ListarH implements OnInit{

  constructor(private router : Router, private service : ServiceWS){}

hijo : Hijo =new Hijo();
hijos !: Hijo[];

  ngOnInit(): void {
    this.listarhijo();
  }

  listarhijo(){
    this.service.listarHWS().subscribe(data=>{
      this.hijos = data ;
    })
  }

 editarButton(hijo : Hijo){
         localStorage.setItem('hijo', JSON.stringify(hijo));
         console.log(localStorage);
         this.router.navigate(["editarH"]);
       }
     
       
       //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
     eliminarButton(idHijo: number) {
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
       this.service.eliminarHWS(idHijo).subscribe(() => {
         Swal.fire({
           title: "Eliminado!",
           text: "El registro ha sido eliminado.",
           icon: "success"
         });
         this.listarhijo();
       });
     } else if (result.isDismissed) {
       Swal.fire("La eliminación fue cancelada", "", "info");
     }
   });
 }

}
