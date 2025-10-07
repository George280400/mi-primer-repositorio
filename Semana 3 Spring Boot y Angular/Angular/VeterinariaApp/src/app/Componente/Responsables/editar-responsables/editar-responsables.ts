import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Responsable } from '../../../Entidades/Responsable';
import { Veterinaria } from '../../../Entidades/Veterinaria';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-responsables',
  imports: [FormsModule, CommonModule],
  templateUrl: './editar-responsables.html',
  styleUrl: './editar-responsables.css'
})
export class EditarResponsables implements OnInit {

  constructor(private router: Router, private service: ServiceWS) { }

  responsable: Responsable = new Responsable();

  ngOnInit(): void {

    this.buscarResponsable();
    this.cargarVeterinarias();
  }

  buscarResponsable() {
    const respString = localStorage.getItem('responsable');
    if (respString) {
      this.responsable = JSON.parse(respString);
    }

    this.service.buscarRWS(this.responsable.idResponsable).subscribe(data => {
      this.responsable = data;
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
  editarResponsable() {
    this.service.editarRWS(this.responsable).subscribe(
      data => {
        Swal.fire({
          title: "EDITAR",
          icon: "success",
          text: "El responsable: " + this.responsable.nombre + " se editó correctamente",
          showConfirmButton: false,
          timer: 2100
        }).then(() => {
          this.router.navigate(['listarR']);
        });
      },
      error => {
        Swal.fire({
          title: "EDITAR",
          icon: "error",
          text: error.error, 
          confirmButtonText: "OK"
        });
      }
    );
  }

  veterinarias: Veterinaria[] = [];

  cargarVeterinarias() {
    this.service.listarVWS().subscribe(data => this.veterinarias = data);
  }


}
