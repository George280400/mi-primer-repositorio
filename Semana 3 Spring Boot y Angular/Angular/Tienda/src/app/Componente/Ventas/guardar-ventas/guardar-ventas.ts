import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Venta } from '../../../Entidades/Venta';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-ventas',
  imports: [FormsModule],
  templateUrl: './guardar-ventas.html',
  styleUrl: './guardar-ventas.css'
})
export class GuardarVentas {

  constructor(private router : Router, private service : ServiceWS){}

  venta : Venta = new Venta();

  //crear el metodo para la funcion de guardar en la base de datos
      guardarV(){
        this.service.guardarVWS(this.venta).subscribe(data =>{
          
         Swal.fire({
          icon: "success",
          title: "GUARDAR",
          text: JSON.stringify(data),
          confirmButtonText : "OK"
        });
        this.router.navigate(['listarV']);
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
