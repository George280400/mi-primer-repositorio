import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Veterinaria } from '../../../Entidades/Veterinaria';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-veterinarias',
  imports: [RouterLink],
  templateUrl: './listar-veterinarias.html',
  styleUrl: './listar-veterinarias.css'
})
export class ListarVeterinarias implements OnInit {

   //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

veterinaria: Veterinaria = new Veterinaria();
veterinarias !: Veterinaria[];


  ngOnInit(): void {
    this.listarVeterinarias();
  }

   listarVeterinarias(){
    //susbribe se conecta con el flujo de datos e inicia la llamada http
    this.service.listarVWS().subscribe(data =>{
      this.veterinarias=data
      console.log('listado exitoso' +JSON.stringify(data));
    })
  }

   editarButton(veterinaria : Veterinaria){
        localStorage.setItem('veterinaria', JSON.stringify(veterinaria));
        console.log(localStorage);
        this.router.navigate(["editarV"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(idVeterinaria: number) {
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
      this.service.eliminarVWS(idVeterinaria).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarVeterinarias();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}

}
