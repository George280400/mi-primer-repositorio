import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Categoria } from '../../../Entidades/Categoria';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-categoria',
  imports: [FormsModule],
  templateUrl: './guardar-categoria.html',
  styleUrl: './guardar-categoria.css'
})
export class GuardarCategoria {

  constructor(private router : Router, private service : ServiceWS){}

  categoria : Categoria = new Categoria();

  //crear el metodo para la funcion de guardar en la base de datos
  guardarC(){
    this.service.guardarCWS(this.categoria).subscribe(data =>{
      
     Swal.fire({
      icon: "success",
      title: "GUARDAR",
      text: JSON.stringify(data),
      confirmButtonText : "OK"
    });
    this.router.navigate(['listarC']);
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
