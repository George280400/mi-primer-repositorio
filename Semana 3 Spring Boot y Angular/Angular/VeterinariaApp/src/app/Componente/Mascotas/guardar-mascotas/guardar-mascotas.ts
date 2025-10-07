import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Mascota } from '../../../Entidades/Mascota';
import Swal from 'sweetalert2';
import { Cliente } from '../../../Entidades/Cliente';
import { Responsable } from '../../../Entidades/Responsable';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-guardar-mascotas',
  imports: [FormsModule, CommonModule],
  templateUrl: './guardar-mascotas.html',
  styleUrl: './guardar-mascotas.css'
})
export class GuardarMascotas {

  constructor(private router: Router, private service: ServiceWS) { }

  mascota: Mascota = new Mascota();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarM() {
        this.service.guardarMWS(this.mascota).subscribe({
          next: (res: any) => {
            Swal.fire({
              icon: "success",
              title: "GUARDAR",
              text: res, 
              confirmButtonText: "OK"
            });
            this.router.navigate(['listarM']);
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

  clientes: Cliente[] = [];
  responsables: Responsable[] = [];

  ngOnInit(): void {
    this.cargarClientes();
    this.cargarResponsables();
  }

  cargarClientes() {
    this.service.listarCWS().subscribe(data => this.clientes = data);
  }

  cargarResponsables() {
    this.service.listarRWS().subscribe(data => this.responsables = data);
  }

}
