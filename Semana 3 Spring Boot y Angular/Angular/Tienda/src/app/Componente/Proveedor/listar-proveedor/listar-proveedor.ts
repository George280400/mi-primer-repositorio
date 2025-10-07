import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Proveedor } from '../../../Entidades/Proveedor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-proveedor',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-proveedor.html',
  styleUrl: './listar-proveedor.css'
})
export class ListarProveedor implements OnInit{

  //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

//instanciar el objeto
proveedor: Proveedor = new Proveedor();
proveedores !: Proveedor[];
  ngOnInit(): void {
    this.listarProveedor();
  }

   listarProveedor(){
            //susbribe se conecta con el flujo de datos e inicia la llamada http
            this.service.listarPRWS().subscribe(data =>{
              this.proveedores=data
              console.log('listado exitoso' +JSON.stringify(data));
            })
          }
        
           editarButton(proveedor : Proveedor){
                localStorage.setItem('proveedor', JSON.stringify(proveedor));
                console.log(localStorage);
                this.router.navigate(["editarPR"]);
              }
            
              
              //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
            eliminarButton(idProveedor: number) {
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
              this.service.eliminarPRWS(idProveedor).subscribe(() => {
                Swal.fire({
                  title: "Eliminado!",
                  text: "El registro ha sido eliminado.",
                  icon: "success"
                });
                this.listarProveedor();
              });
            } else if (result.isDismissed) {
              Swal.fire("La eliminación fue cancelada", "", "info");
            }
          });
        }
  

}
