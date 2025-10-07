import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Categoria } from '../../../Entidades/Categoria';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-categoria',
  imports: [FormsModule],
  templateUrl: './editar-categoria.html',
  styleUrl: './editar-categoria.css'
})
export class EditarCategoria implements OnInit{
  constructor(private router: Router, private service: ServiceWS) { }

  categoria: Categoria = new Categoria();
  ngOnInit(): void {
    this.buscarCategoria();
  }

   buscarCategoria() {
    const catString = localStorage.getItem('categoria');
    if (catString) {
      this.categoria = JSON.parse(catString);
    }
  
    this.service.buscarCWS(this.categoria.idCategoria).subscribe(data => {
      this.categoria = data;
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
    editarCategoria() {
    this.service.editarCWS(this.categoria).subscribe(data => {
      Swal.fire({
        title: "EDITAR",
        icon: "success",
        text: "La Categoria: " + this.categoria.nombre + " se edito correctamente",
        showConfirmButton: false,
        timer: 2100
      }).then(() => {
        this.router.navigate(['listarC']);
      });
    });
  }

}
