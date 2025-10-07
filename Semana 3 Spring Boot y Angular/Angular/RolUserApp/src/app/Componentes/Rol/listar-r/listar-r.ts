import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-r',
  imports: [],
  templateUrl: './listar-r.html',
  styleUrl: './listar-r.css'
})
export class ListarR implements OnInit{

  constructor(private router : Router, private service : ServiceWS){}
 
 rol : Rol = new Rol();
 roles !: Rol[];


  ngOnInit(): void {
    this.listarRol();
  }

  listarRol(){
    this.service.listarRWS().subscribe(data =>{
      this.roles = data;
    })
  }

  editarButton(rol : Rol){
        localStorage.setItem('rol', JSON.stringify(rol));
        console.log(localStorage);
        this.router.navigate(["editarR"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(idRol: number) {
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
      this.service.eliminarRWS(idRol).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarRol();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}

}
