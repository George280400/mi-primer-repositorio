import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Carros } from '../../Entidad/Carros';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-carros',
  imports: [FormsModule], //nos ayuda a la directiva ngModule
  templateUrl: './guardar-carros.html',
  styleUrl: './guardar-carros.css'
})
export class GuardarCarros {

  constructor(private router : Router, private service : ServiceWS){}

  carro : Carros = new Carros();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarC(){
    this.service.guardarCWS(this.carro).subscribe(data =>{
      
     Swal.fire({
      icon: "success",
      title: "GUARDAR",
      text: "El resgitro se guardo con exito",
      confirmButtonText : "OK"
    });
    this.router.navigate(['listarc']);
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
