import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-empleados',
  imports: [FormsModule],
  templateUrl: './editar-empleados.html',
  styleUrl: './editar-empleados.css'
})
export class EditarEmpleados implements OnInit{

  constructor(private router: Router, private service: ServiceWS) { }
   empleado: Empleado = new Empleado();



  ngOnInit(): void {
    this.buscarEmpleado();
  }

   buscarEmpleado() {
            const empString = localStorage.getItem('empleado');
            if (empString) {
              this.empleado = JSON.parse(empString);
            }
          
            this.service.buscarEWS(this.empleado.idEmpleado).subscribe(data => {
              this.empleado = data;
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
            editarEmpleado() {
            this.service.editarEWS(this.empleado).subscribe(data => {
              Swal.fire({
                title: "EDITAR",
                icon: "success",
                text: "El Empleado: " + this.empleado.nombre + " se edito correctamente",
                showConfirmButton: false,
                timer: 2100
              }).then(() => {
                this.router.navigate(['listarE']);
              });
            });
          }

}
