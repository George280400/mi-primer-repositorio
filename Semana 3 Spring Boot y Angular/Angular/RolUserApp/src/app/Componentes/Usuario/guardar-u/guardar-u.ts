import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Usuario } from '../../../Entidades/Usuario';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-guardar-u',
  imports: [FormsModule],
  templateUrl: './guardar-u.html',
  styleUrl: './guardar-u.css'
})
export class GuardarU {

    constructor(private router: Router, private service: ServiceWS) { }
  //variable indefinida para que pueda tomar el valor del idpadre
  identificador: number | undefined;

  usuario: Usuario = new Usuario();

  guardarUsuario() {
  if (this.identificador !== undefined) {
    if (!this.usuario.rolId) {
      this.usuario.rolId = new Rol();
    }
    this.usuario.rolId.idRol = this.identificador;
  }

  this.service.guardarUWS(this.usuario).subscribe({
    next: (data) => {
      Swal.fire({
        icon: "success",
        title: "GUARDAR",
        text: "Usuario guardado correctamente ",
        showConfirmButton: false,
        timer: 2100
      });
      this.router.navigate(['listarU']);
    },
    error: (err) => {
      Swal.fire({
        icon: "error",
        title: "Error",
        text: err.error, 
        confirmButtonText: "Aceptar"
      });
    }
  });
}


}
