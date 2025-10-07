import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-guardar-r',
  imports: [FormsModule],
  templateUrl: './guardar-r.html',
  styleUrl: './guardar-r.css'
})
export class GuardarR {

    constructor(private router : Router, private service : ServiceWS){}

  rol : Rol = new Rol();

  guardarR(){
    this.service.guardarRWS(this.rol).subscribe(data =>{
      
     Swal.fire({
      icon: "success",
      title: "GUARDAR",
      text: JSON.stringify(data),
      confirmButtonText : "OK"
    });
    this.router.navigate(['listarR']);
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
