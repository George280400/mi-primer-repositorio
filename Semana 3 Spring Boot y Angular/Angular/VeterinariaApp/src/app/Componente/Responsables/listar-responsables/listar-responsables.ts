import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Responsable } from '../../../Entidades/Responsable';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-responsables',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-responsables.html',
  styleUrl: './listar-responsables.css'
})
export class ListarResponsables implements OnInit{

  //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

responsable: Responsable = new Responsable();
responsables !: Responsable[];


  ngOnInit(): void {
    this.listarResponsables();
  }

   listarResponsables(){
    //susbribe se conecta con el flujo de datos e inicia la llamada http
    this.service.listarRWS().subscribe(data =>{
      this.responsables=data
      console.log('listado exitoso' +JSON.stringify(data));
    })
  }

   editarButton(responsable : Responsable){
        localStorage.setItem('responsable', JSON.stringify(responsable));
        console.log(localStorage);
        this.router.navigate(["editarR"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(idResponsable: number) {
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
      this.service.eliminarRWS(idResponsable).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarResponsables();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}

}
