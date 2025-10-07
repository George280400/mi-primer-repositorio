import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { ServiceWS } from '../../../Service/service-ws';
import { Cliente } from '../../../Entidades/Cliente';

@Component({
  selector: 'app-listar-clientes',
  imports: [RouterLink],
  templateUrl: './listar-clientes.html',
  styleUrl: './listar-clientes.css'
})
export class ListarClientes implements OnInit {

  //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

cliente: Cliente = new Cliente();
clientes !: Cliente[];


  ngOnInit(): void {
    this.listarClientes();
  }

   listarClientes(){
    //susbribe se conecta con el flujo de datos e inicia la llamada http
    this.service.listarCWS().subscribe(data =>{
      this.clientes=data
      console.log('listado exitoso' +JSON.stringify(data));
    })
  }

   editarButton(cliente : Cliente){
        localStorage.setItem('cliente', JSON.stringify(cliente));
        console.log(localStorage);
        this.router.navigate(["editarC"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(idCliente: number) {
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
      this.service.eliminarCWS(idCliente).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarClientes();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}


}
