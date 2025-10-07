import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Cliente } from '../../../Entidades/Cliente';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-clientes',
  imports: [FormsModule],
  templateUrl: './guardar-clientes.html',
  styleUrl: './guardar-clientes.css'
})
export class GuardarClientes {

   constructor(private router : Router, private service : ServiceWS){}

  cliente : Cliente = new Cliente();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarC() {
    this.service.guardarCWS(this.cliente).subscribe({
      next: (res: any) => {
        Swal.fire({
          icon: "success",
          title: "GUARDAR",
          text: res, 
          confirmButtonText: "OK"
        });
        this.router.navigate(['listarC']);
      },
      error: (err: any) => {
        Swal.fire({
          icon: "error",
          title: "ERROR",
          text: err.error, 
          confirmButtonText: "OK"
        });
      }
    });
  }

}
