import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Venta } from '../../../Entidades/Venta';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-ventas',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-ventas.html',
  styleUrl: './listar-ventas.css'
})
export class ListarVentas implements OnInit{
//constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

//instanciar el objeto
venta: Venta = new Venta();
ventas !: Venta[];

  ngOnInit(): void {
    this.listarVenta();
  }

  listarVenta(){
          //susbribe se conecta con el flujo de datos e inicia la llamada http
          this.service.listarVWS().subscribe(data =>{
            this.ventas=data
            console.log('listado exitoso' +JSON.stringify(data));
          })
        }
      
         editarButton(venta : Venta){
              localStorage.setItem('venta', JSON.stringify(venta));
              console.log(localStorage);
              this.router.navigate(["editarV"]);
            }
          
            
            //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
          eliminarButton(idVenta: number) {
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
            this.service.eliminarVWS(idVenta).subscribe(() => {
              Swal.fire({
                title: "Eliminado!",
                text: "El registro ha sido eliminado.",
                icon: "success"
              });
              this.listarVenta();
            });
          } else if (result.isDismissed) {
            Swal.fire("La eliminación fue cancelada", "", "info");
          }
        });
      }

}
