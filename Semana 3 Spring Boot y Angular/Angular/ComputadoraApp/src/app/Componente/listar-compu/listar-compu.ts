import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Computadora } from '../../Entidad/Computadora';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-compu',
  imports: [],
  templateUrl: './listar-compu.html',
  styleUrl: './listar-compu.css'
})
//ngOninit es uno de los lifecycle hooks(ganchos del ciclo de vida) de los mas importantes en angular
//ngOnInit es un metodo que se ejecuta imediatamente despues de que el componente se inicializa y sus propiedades vinculadas
//se revisan por primera vez
export class ListarCompu implements OnInit{

//agregar un costructor de la clase para inyectar dependecias
constructor(private router : Router, private service : ServiceWS){}
  //instanciar el objeto
  compu : Computadora = new Computadora();
  compus !: Computadora[];


  ngOnInit(): void {

    this.listarCompu();
    
  }

  listarCompu(){
    //subscribe se conecta con el flujo de datos e inica la llamada http
    this.service.listarCWS().subscribe(data =>{
      this.compus=data
      console.log('listado exitoso' + JSON.stringify(data));
    })
  }

  editarButton(compu : Computadora){
    localStorage.setItem('compu', JSON.stringify(compu));
    console.log(localStorage);
    this.router.navigate(["editarC"]);
  }

  
  //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
eliminarButton(compu : Computadora){
    Swal.fire({
        title: "Esta seguro de querer eliminarlo?",
        text: "Este movimiento no se puede revertir!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Si, eliminalo!"
    }).then((result) => {
        if (result.isConfirmed) {
            this.service.eliminarCWS(compu).subscribe(dat=>{
                Swal.fire({
                    title: "Deleted!",
                    text: "Your file has been deleted.",
                    icon: "success"
                });
                this.listarCompu();
            });
        }else if(result.isDismissed){
            Swal.fire("La eliminacion fue cancelada", "info");
        }
    });
}
}
