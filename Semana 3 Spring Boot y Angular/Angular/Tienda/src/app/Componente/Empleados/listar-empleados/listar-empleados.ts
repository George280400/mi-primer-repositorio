import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-empleados',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './listar-empleados.html',
  styleUrl: './listar-empleados.css'
})
export class ListarEmpleados implements OnInit{
  //constructor para inyectar dependencias
constructor(private router : Router, private service : ServiceWS){}

//instanciar el objeto
empleado: Empleado = new Empleado();
empleados !: Empleado[];

  ngOnInit(): void {
    this.listarEmpleado();
  }
  
   listarEmpleado(){
              //susbribe se conecta con el flujo de datos e inicia la llamada http
              this.service.listarEWS().subscribe(data =>{
                this.empleados=data
                console.log('listado exitoso' +JSON.stringify(data));
              })
            }
          
             editarButton(empleado : Empleado){
                  localStorage.setItem('empleado', JSON.stringify(empleado));
                  console.log(localStorage);
                  this.router.navigate(["editarE"]);
                }
              
                
                //crear metodo que mande a modificar la informacion de la  base de datos consumiendo el controlador de editar
              eliminarButton(idEmpleado: number) {
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
                this.service.eliminarEWS(idEmpleado).subscribe(() => {
                  Swal.fire({
                    title: "Eliminado!",
                    text: "El registro ha sido eliminado.",
                    icon: "success"
                  });
                  this.listarEmpleado();
                });
              } else if (result.isDismissed) {
                Swal.fire("La eliminación fue cancelada", "", "info");
              }
            });
          }
}
