import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Responsable } from '../../../Entidades/Responsable';
import Swal from 'sweetalert2';
import { Veterinaria } from '../../../Entidades/Veterinaria';

@Component({
  selector: 'app-guardar-responsables',
  imports: [FormsModule, CommonModule],
  templateUrl: './guardar-responsables.html',
  styleUrl: './guardar-responsables.css'
})
export class GuardarResponsables {

  constructor(private router: Router, private service: ServiceWS) { }

  responsable: Responsable = new Responsable();

  //crear el metodo para la funcion de guardar en la base de datos
 guardarR() {
     this.service.guardarRWS(this.responsable).subscribe({
       next: (res: any) => {
         Swal.fire({
           icon: "success",
           title: "GUARDAR",
           text: res, 
           confirmButtonText: "OK"
         });
         this.router.navigate(['listarR']);
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

  veterinaria: Veterinaria[] = [];


  ngOnInit(): void {
    this.cargarVeterinaria();

  }

  cargarVeterinaria() {
    this.service.listarVWS().subscribe(data => this.veterinaria = data);
  }



}
