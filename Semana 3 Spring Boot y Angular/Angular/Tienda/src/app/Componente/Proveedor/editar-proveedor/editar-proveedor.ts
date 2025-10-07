import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Proveedor } from '../../../Entidades/Proveedor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-proveedor',
  imports: [FormsModule],
  templateUrl: './editar-proveedor.html',
  styleUrl: './editar-proveedor.css'
})
export class EditarProveedor implements OnInit {

  constructor(private router: Router, private service: ServiceWS) { }
   proveedor: Proveedor = new Proveedor();

  ngOnInit(): void {
    this.buscarProveedor();
  }

   buscarProveedor() {
          const provString = localStorage.getItem('proveedor');
          if (provString) {
            this.proveedor = JSON.parse(provString);
          }
        
          this.service.buscarPRWS(this.proveedor.idProveedor).subscribe(data => {
            this.proveedor = data;
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
          editarProveedor() {
          this.service.editarPRWS(this.proveedor).subscribe(data => {
            Swal.fire({
              title: "EDITAR",
              icon: "success",
              text: "El proveedor: " + this.proveedor.nombre + " se edito correctamente",
              showConfirmButton: false,
              timer: 2100
            }).then(() => {
              this.router.navigate(['listarPR']);
            });
          });
        }

}
