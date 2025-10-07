import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Carros } from '../../Entidad/Carros';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-carros',
  imports: [FormsModule],
  templateUrl: './editar-carros.html',
  styleUrl: './editar-carros.css'
})
export class EditarCarros implements OnInit {

  constructor(private router: Router, private service: ServiceWS) { }

  carro: Carros = new Carros();

  ngOnInit(): void {
    this.buscarCarro();
  }

  buscarCarro() {
    const carroString = localStorage.getItem('carro');
    if (carroString) {
      console.log(JSON.parse(carroString));
      this.carro = JSON.parse(carroString);
    }

    this.service.buscarCWS(this.carro).subscribe(data => {
      this.carro = data;
      Swal.fire({
        title: "EDITAR",
        icon: "success",
        text: "Informacion cargada",
        showConfirmButton: false,
        timer: 2000
      });
    },
      error => {
        Swal.fire({
          icon: 'error',
          title: "EDITAR",
          text: "Ocurrio un error",
          confirmButtonText: "OK"
        });
      });
  }

  //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
  editarCarro() {
  this.service.editarCWS(this.carro).subscribe(data => {
    Swal.fire({
      title: "EDITAR",
      icon: "success",
      text: "El Carro: " + this.carro.marca + " se edito correctamente",
      showConfirmButton: false,
      timer: 2100
    }).then(() => {
      this.router.navigate(['listarC']);
    });
  });
}
  
}
