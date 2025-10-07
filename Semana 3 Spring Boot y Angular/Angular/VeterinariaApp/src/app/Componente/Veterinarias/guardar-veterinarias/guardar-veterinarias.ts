import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ServiceWS } from '../../../Service/service-ws';
import { Veterinaria } from '../../../Entidades/Veterinaria';

@Component({
  selector: 'app-guardar-veterinarias',
  imports: [FormsModule],
  templateUrl: './guardar-veterinarias.html',
  styleUrl: './guardar-veterinarias.css'
})
export class GuardarVeterinarias {

  constructor(private router: Router, private service: ServiceWS) { }

  veterinaria: Veterinaria = new Veterinaria();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarV() {
      this.service.guardarVWS(this.veterinaria).subscribe({
        next: (res: any) => {
          Swal.fire({
            icon: "success",
            title: "GUARDAR",
            text: res, 
            confirmButtonText: "OK"
          });
          this.router.navigate(['listarV']);
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
