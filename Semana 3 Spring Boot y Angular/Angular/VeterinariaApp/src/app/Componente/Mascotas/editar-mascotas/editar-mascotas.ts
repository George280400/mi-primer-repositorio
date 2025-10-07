import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Mascota } from '../../../Entidades/Mascota';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { Cliente } from '../../../Entidades/Cliente';
import { Responsable } from '../../../Entidades/Responsable';

@Component({
  selector: 'app-editar-mascotas',
  imports: [FormsModule, CommonModule],
  templateUrl: './editar-mascotas.html',
  styleUrl: './editar-mascotas.css'
})
export class EditarMascotas implements OnInit {

  constructor(private router: Router, private service: ServiceWS) { }

  mascota: Mascota = new Mascota();

  ngOnInit(): void {

    this.buscarMascota();
    this.cargarClientes();
    this.cargarResponsables();
  }

  buscarMascota() {
    const mascString = localStorage.getItem('mascota');
    if (mascString) {
      this.mascota = JSON.parse(mascString);
    }

    this.service.buscarMWS(this.mascota.idMascota).subscribe(data => {
      this.mascota = data;
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
   editarMascota() {
    this.service.editarMWS(this.mascota).subscribe(
      data => {
        Swal.fire({
          title: "EDITAR",
          icon: "success",
          text: "La mascota: " + this.mascota.nombre + " se editó correctamente",
          showConfirmButton: false,
          timer: 2100
        }).then(() => {
          this.router.navigate(['listarM']);
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

  clientes: Cliente[] = [];
  responsables: Responsable[] = [];



  cargarClientes() {
    this.service.listarCWS().subscribe(data => this.clientes = data);
  }

  cargarResponsables() {
    this.service.listarRWS().subscribe(data => this.responsables = data);
  }

}
