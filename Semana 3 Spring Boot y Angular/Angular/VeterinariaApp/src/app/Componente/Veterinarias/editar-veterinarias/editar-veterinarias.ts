import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Veterinaria } from '../../../Entidades/Veterinaria';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-veterinarias',
  imports: [FormsModule],
  templateUrl: './editar-veterinarias.html',
  styleUrl: './editar-veterinarias.css'
})
export class EditarVeterinarias implements OnInit {

  constructor(private router: Router, private service: ServiceWS) { }

  veterinaria: Veterinaria = new Veterinaria();

  ngOnInit(): void {

    this.buscarVeterinaria();
  }

  buscarVeterinaria() {
    const vetString = localStorage.getItem('veterinaria');
    if (vetString) {
      this.veterinaria = JSON.parse(vetString);
    }

    this.service.buscarVWS(this.veterinaria.idVeterinaria).subscribe(data => {
      this.veterinaria = data;
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
  editarVeterinaria() {
    this.service.editarVWS(this.veterinaria).subscribe(
      data => {
        Swal.fire({
          title: "EDITAR",
          icon: "success",
          text: "La veterinaria: " + this.veterinaria.nombre + " se editó correctamente",
          showConfirmButton: false,
          timer: 2100
        }).then(() => {
          this.router.navigate(['listarV']);
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

}
