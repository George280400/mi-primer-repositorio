import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Proveedor } from '../../../Entidades/Proveedor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-proveedor',
  imports: [FormsModule],
  templateUrl: './guardar-proveedor.html',
  styleUrl: './guardar-proveedor.css'
})
export class GuardarProveedor {

    constructor(private router : Router, private service : ServiceWS){}

  proveedor : Proveedor = new Proveedor();

   //crear el metodo para la funcion de guardar en la base de datos
        guardarPR(){
          this.service.guardarPRWS(this.proveedor).subscribe(data =>{
            
           Swal.fire({
            icon: "success",
            title: "GUARDAR",
            text: JSON.stringify(data),
            confirmButtonText : "OK"
          });
          this.router.navigate(['listarPR']);
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
