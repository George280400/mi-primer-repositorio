import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-empleados',
  imports: [FormsModule],
  templateUrl: './guardar-empleados.html',
  styleUrl: './guardar-empleados.css'
})
export class GuardarEmpleados {

  constructor(private router : Router, private service : ServiceWS){}

  empleado : Empleado = new Empleado();

  //crear el metodo para la funcion de guardar en la base de datos
          guardarE(){
            this.service.guardarEWS(this.empleado).subscribe(data =>{
              
             Swal.fire({
              icon: "success",
              title: "GUARDAR",
              text: JSON.stringify(data),
              confirmButtonText : "OK"
            });
            this.router.navigate(['listarE']);
          }, error => {
            Swal.fire({
              icon: "error",
              title: "GUARDAR",
              text: JSON.stringify(error),
              confirmButtonText : "OK"
            });
          });
          }

}
