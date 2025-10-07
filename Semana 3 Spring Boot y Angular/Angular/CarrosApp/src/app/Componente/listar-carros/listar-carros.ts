import { Component, OnInit } from '@angular/core';
import { ServiceWS } from '../../Service/service-ws';
import { Router } from '@angular/router';
import { Carros } from '../../Entidad/Carros';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-carros',
  imports: [],
  templateUrl: './listar-carros.html',
  styleUrl: './listar-carros.css'
})

//ngOninit es uno de los lifecycle hooks(ganchos del ciclo de vida) de los mas importantes en angular
//ngOnInit es un metodo que se ejecuta imediatamente despues de que el componente se inicializa y sus propiedades vinculadas
//se revisan por primera vez
export class ListarCarros implements OnInit {

  //agregar un costructor de la clase para inyectar dependecias
  constructor(private router: Router, private service: ServiceWS) { }
  //instanciar el objeto
  carro: Carros = new Carros();
  carros !: Carros[];


  ngOnInit(): void {
    this.listarCarros();
  }

  listarCarros(){
    //subscribe se conecta con el flujo de datos e inica la llamada http
    this.service.listarCWS().subscribe(data =>{
      this.carros=data
      console.log('listado exitoso' + JSON.stringify(data));
    })
  }

  editarButton(carro : Carros){
      localStorage.setItem('carro', JSON.stringify(carro));
      console.log(localStorage);
      this.router.navigate(["editarC"]);
    }
  
    
    //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
  eliminarButton(carro : Carros){
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
              this.service.eliminarCWS(carro).subscribe(dat=>{
                  Swal.fire({
                      title: "Deleted!",
                      text: "Your file has been deleted.",
                      icon: "success"
                  });
                  this.listarCarros();
              });
          }else if(result.isDismissed){
              Swal.fire("La eliminacion fue cancelada", "info");
          }
      });
  }

}
