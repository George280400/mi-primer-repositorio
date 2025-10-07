import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-r',
  imports: [FormsModule],
  templateUrl: './editar-r.html',
  styleUrl: './editar-r.css'
})
export class EditarR implements OnInit {

constructor(private router: Router, private service: ServiceWS) { }

  rol: Rol = new Rol();

  ngOnInit(): void {
    this.buscarRol();
  }

  buscarRol() {
  const rolString = localStorage.getItem('rol');
  if (rolString) {
    this.rol = JSON.parse(rolString);
  }

  this.service.buscarRWS(this.rol.idRol).subscribe(data => {
    this.rol = data;
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
  editarRol() {
  this.service.editarRWS(this.rol).subscribe(data => {
    Swal.fire({
      title: "EDITAR",
      icon: "success",
      text: "El Rol: " + this.rol.privilegio + " se edito correctamente",
      showConfirmButton: false,
      timer: 2100
    }).then(() => {
      this.router.navigate(['listarR']);
    });
  });
}

}
