import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Categoria } from '../../../Entidades/Categoria';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-categoria',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-categoria.html',
  styleUrl: './listar-categoria.css'
})
export class ListarCategoria implements OnInit{

  //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

//instanciar el objeto
categoria: Categoria = new Categoria();
categorias !: Categoria[];

  ngOnInit(): void {
    this.listarCategoria();
  }

   listarCategoria(){
      //susbribe se conecta con el flujo de datos e inicia la llamada http
      this.service.listarCWS().subscribe(data =>{
        this.categorias=data
        console.log('listado exitoso' +JSON.stringify(data));
      })
    }
  
     editarButton(categoria : Categoria){
          localStorage.setItem('categoria', JSON.stringify(categoria));
          console.log(localStorage);
          this.router.navigate(["editarC"]);
        }
      
        
        //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
      eliminarButton(idCategoria: number) {
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
        this.service.eliminarCWS(idCategoria).subscribe(() => {
          Swal.fire({
            title: "Eliminado!",
            text: "El registro ha sido eliminado.",
            icon: "success"
          });
          this.listarCategoria();
        });
      } else if (result.isDismissed) {
        Swal.fire("La eliminación fue cancelada", "", "info");
      }
    });
  }

  

}
