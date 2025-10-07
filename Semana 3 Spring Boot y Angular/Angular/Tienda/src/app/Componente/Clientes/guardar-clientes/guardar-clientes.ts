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
    guardarCl(){
      this.service.guardarCLWS(this.cliente).subscribe(data =>{
        
       Swal.fire({
        icon: "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        confirmButtonText : "OK"
      });
      this.router.navigate(['listarCl']);
    }, error => {
      Swal.fire({
        icon: "error",
        title: "GUARDAR",
        text: JSON.stringify(error),
        confirmButtonText : "OK"
      });
    });
    }

}
