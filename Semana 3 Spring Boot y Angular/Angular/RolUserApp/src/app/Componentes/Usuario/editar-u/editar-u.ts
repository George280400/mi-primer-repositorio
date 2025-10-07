import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Usuario } from '../../../Entidades/Usuario';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { Rol } from '../../../Entidades/Rol';

@Component({
  selector: 'app-editar-u',
  imports: [FormsModule],
  templateUrl: './editar-u.html',
  styleUrl: './editar-u.css'
})
export class EditarU implements OnInit{
  //variable indefinida para que pueda tomar el valor del idpadre
  identificador: number | undefined;

  constructor(private router: Router, private service: ServiceWS) { }

  usuario: Usuario = new Usuario();

  ngOnInit(): void {

    this.buscarUsuario();
    
  }

  buscarUsuario() {
    const usuarioString = localStorage.getItem('usuario');
    if (usuarioString) {
      this.usuario = JSON.parse(usuarioString);
    }
  
    this.service.buscarUWS(this.usuario.idUsuario).subscribe(data => {
      this.usuario = data;
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
   editarUsuario() {
  this.service.editarUWS(this.usuario).subscribe({
    next: (data) => {
      Swal.fire({
        title: "EDITAR",
        icon: "success",
        text: "El Usuario: " + this.usuario.nombre + " se editó correctamente",
        showConfirmButton: false,
        timer: 2100
      }).then(() => {
        this.router.navigate(['listarU']);
      });
    },
    error: (err) => {
      Swal.fire({
        title: "ERROR",
        icon: "error",
        text: err.error || "Ocurrió un error al editar el usuario",
        confirmButtonText: "Aceptar"
      });
    }
  });
}


}
