import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Cliente } from '../../../Entidades/Cliente';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-clientes',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-clientes.html',
  styleUrl: './listar-clientes.css'
})
export class ListarClientes implements OnInit{

  //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

//instanciar el objeto
cliente: Cliente = new Cliente();
clientes !: Cliente[];

  ngOnInit(): void {
    this.listarCliente();
  }

   listarCliente(){
        //susbribe se conecta con el flujo de datos e inicia la llamada http
        this.service.listarCLWS().subscribe(data =>{
          this.clientes=data
          console.log('listado exitoso' +JSON.stringify(data));
        })
      }
    
       editarButton(cliente : Cliente){
            localStorage.setItem('cliente', JSON.stringify(cliente));
            console.log(localStorage);
            this.router.navigate(["editarCl"]);
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
          this.service.eliminarCLWS(idCliente).subscribe(() => {
            Swal.fire({
              title: "Eliminado!",
              text: "El registro ha sido eliminado.",
              icon: "success"
            });
            this.listarCliente();
          });
        } else if (result.isDismissed) {
          Swal.fire("La eliminación fue cancelada", "", "info");
        }
      });
    }

}
