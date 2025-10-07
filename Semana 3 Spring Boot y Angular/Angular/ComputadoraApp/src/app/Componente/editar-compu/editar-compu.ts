import { Component, OnInit } from '@angular/core';
import { Computadora } from '../../Entidad/Computadora';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-compu',
  imports: [FormsModule],
  templateUrl: './editar-compu.html',
  styleUrl: './editar-compu.css'
})
export class EditarCompu implements OnInit{

  constructor(private router : Router, private service : ServiceWS){}

  compu : Computadora = new Computadora();

  
ngOnInit(): void {
  this.buscarCompu();
}

buscarCompu(){
    const compuString = localStorage.getItem('compu');
    if(compuString){
        console.log(JSON.parse(compuString));
        this.compu = JSON.parse(compuString);
    }

    this.service.buscarCWS(this.compu).subscribe(data =>{
        this.compu = data;
        Swal.fire({
            title : "EDITAR",
            icon : "success",
            text : "Informacion cargada",
            showConfirmButton : false,
            timer : 2000
        });
    },
    error=>{
        Swal.fire({
            icon : 'error',
            title : "EDITAR",
            text : "Ocurrio un error",
            confirmButtonText : "OK"
        });
    });
}

//crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
editarCompu(){
    this.service.editarCWS(this.compu).subscribe(data=>{
        Swal.fire({
            title : "EDITAR",
            icon : "success",
            text : "La computadora: " + this.compu.marca + " se edito correctamente",
            showConfirmButton : false,
            timer : 2100
        });
    });
    this.router.navigate(['listarC']);
}

  

}
