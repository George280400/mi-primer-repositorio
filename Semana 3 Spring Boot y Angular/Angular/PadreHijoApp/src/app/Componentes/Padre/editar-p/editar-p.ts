import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Padre } from '../../../Entidades/Padre';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-p',
  imports: [FormsModule],
  templateUrl: './editar-p.html',
  styleUrl: './editar-p.css'
})
export class EditarP implements OnInit{
  
constructor(private router: Router, private service: ServiceWS) { }

  padre: Padre = new Padre();

  ngOnInit(): void {

  this.buscarPadre();
    
  }

   buscarPadre() {
  const padreString = localStorage.getItem('padre');
  if (padreString) {
    this.padre = JSON.parse(padreString);
  }

  this.service.buscarPWS(this.padre.idPadre).subscribe(data => {
    this.padre = data;
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
  editarPadre() {
  this.service.editarPWS(this.padre).subscribe(data => {
    Swal.fire({
      title: "EDITAR",
      icon: "success",
      text: "El Padre: " + this.padre.nombre + " se edito correctamente",
      showConfirmButton: false,
      timer: 2100
    }).then(() => {
      this.router.navigate(['listarP']);
    });
  });
}

}
