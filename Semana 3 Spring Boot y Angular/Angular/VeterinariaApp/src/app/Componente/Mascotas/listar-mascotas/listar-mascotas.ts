import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Mascota } from '../../../Entidades/Mascota';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-mascotas',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-mascotas.html',
  styleUrl: './listar-mascotas.css'
})
export class ListarMascotas implements OnInit {
//constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

mascota: Mascota = new Mascota();
mascotas !: Mascota[];


  ngOnInit(): void {
    this.listarMascotas();
  }

   listarMascotas(){
    //susbribe se conecta con el flujo de datos e inicia la llamada http
    this.service.listarMWS().subscribe(data =>{
      this.mascotas=data
      console.log('listado exitoso' +JSON.stringify(data));
    })
  }

   editarButton(mascota : Mascota){
        localStorage.setItem('mascota', JSON.stringify(mascota));
        console.log(localStorage);
        this.router.navigate(["editarM"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(idMascota: number) {
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
      this.service.eliminarMWS(idMascota).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarMascotas();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}

}
