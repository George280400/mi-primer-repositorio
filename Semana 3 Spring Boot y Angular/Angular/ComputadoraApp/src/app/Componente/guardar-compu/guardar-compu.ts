import { Component } from '@angular/core';
import { Computadora } from '../../Entidad/Computadora';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-compu',
  imports: [FormsModule], //nos ayuda a la directiva ngModule
  templateUrl: './guardar-compu.html',
  styleUrl: './guardar-compu.css'
})
export class GuardarCompu {

  constructor(private router : Router, private service : ServiceWS){}

  compu : Computadora = new Computadora();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarC(){
    this.service.guardarCWS(this.compu).subscribe(data =>{
      
     Swal.fire({
      icon: "success",
      title: "GUARDAR",
      text: "El resgitro se guardo con exito",
      confirmButtonText : "OK"
    });
    this.router.navigate(['listarC']);
  }, error => {
    Swal.fire({
      icon: "error",
      title: "GUARDAR",
      text: "Ocurrio un error",
      confirmButtonText : "OK"
    });
  });
  }

}
