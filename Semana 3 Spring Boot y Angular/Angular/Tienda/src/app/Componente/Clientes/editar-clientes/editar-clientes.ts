import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Cliente } from '../../../Entidades/Cliente';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-clientes',
  imports: [FormsModule],
  templateUrl: './editar-clientes.html',
  styleUrl: './editar-clientes.css'
})
export class EditarClientes implements OnInit{
  constructor(private router: Router, private service: ServiceWS) { }
   cliente: Cliente = new Cliente();

  ngOnInit(): void {
    this.buscarCliente();
  }

  buscarCliente() {
      const cliString = localStorage.getItem('cliente');
      if (cliString) {
        this.cliente = JSON.parse(cliString);
      }
    
      this.service.buscarCLWS(this.cliente.idCliente).subscribe(data => {
        this.cliente = data;
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
      editarCliente() {
      this.service.editarCLWS(this.cliente).subscribe(data => {
        Swal.fire({
          title: "EDITAR",
          icon: "success",
          text: "El Cliente: " + this.cliente.nombre + " se edito correctamente",
          showConfirmButton: false,
          timer: 2100
        }).then(() => {
          this.router.navigate(['listarCl']);
        });
      });
    }

}
