import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Padre } from '../../../Entidades/Padre';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-p',
  imports: [],
  templateUrl: './listar-p.html',
  styleUrl: './listar-p.css'
})
export class ListarP implements OnInit{

  constructor(private router : Router, private service : ServiceWS){}
 
 padre : Padre = new Padre();
 padres !: Padre[];


  ngOnInit(): void {
    this.listarPadre();
  }

  listarPadre(){
    this.service.listarPWS().subscribe(data =>{
      this.padres = data;
    })
  }

  editarButton(padre : Padre){
        localStorage.setItem('padre', JSON.stringify(padre));
        console.log(localStorage);
        this.router.navigate(["editarP"]);
      }
    
      
      //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
    eliminarButton(idPadre: number) {
  Swal.fire({
    title: "¿Está seguro de querer eliminarlo?",
    text: "Este movimiento no se puede revertir!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Sí, elimínalo!"
  }).then((result) => {
    if (result.isConfirmed) {
      this.service.eliminarPWS(idPadre).subscribe(() => {
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarPadre();
      });
    } else if (result.isDismissed) {
      Swal.fire("La eliminación fue cancelada", "", "info");
    }
  });
}

  

}
