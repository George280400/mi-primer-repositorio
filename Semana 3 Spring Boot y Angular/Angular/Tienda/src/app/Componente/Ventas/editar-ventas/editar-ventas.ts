import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Venta } from '../../../Entidades/Venta';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-ventas',
  imports: [FormsModule],
  templateUrl: './editar-ventas.html',
  styleUrl: './editar-ventas.css'
})
export class EditarVentas implements OnInit{
  
  constructor(private router: Router, private service: ServiceWS) { }
   venta: Venta = new Venta();

  ngOnInit(): void {
    this.buscarVenta();
  }

   buscarVenta() {
        const venString = localStorage.getItem('venta');
        if (venString) {
          this.venta = JSON.parse(venString);
        }
      
        this.service.buscarVWS(this.venta.idVenta).subscribe(data => {
          this.venta = data;
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
        editarVenta() {
        this.service.editarVWS(this.venta).subscribe(data => {
          Swal.fire({
            title: "EDITAR",
            icon: "success",
            text: "La Venta: " + this.venta.idVenta + " se edito correctamente",
            showConfirmButton: false,
            timer: 2100
          }).then(() => {
            this.router.navigate(['listarV']);
          });
        });
      }

}
