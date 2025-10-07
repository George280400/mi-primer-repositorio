import { Component, NgModule, signal } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {

  protected readonly title = signal('Tienda');

  //constructor para inicializar el router
  constructor(private router: Router) { }

  //funciones para navegar a los componentes

  //para navegar a la pantalla principal
  paginaP() { this.router.navigate(['paginaP']) }

  // productos
  listarP() { this.router.navigate(['listarP']); }
  guardarP() { this.router.navigate(['guardarP']); }
  editarP() { this.router.navigate(['editarP']); }

  // categorías
  listarC() { this.router.navigate(['listarC']); }
  guardarC() { this.router.navigate(['guardarC']); }
  editarC() { this.router.navigate(['editarC']); }

  // clientes
  listarCl() { this.router.navigate(['listarCl']); }
  guardarCl() { this.router.navigate(['guardarCl']); }
  editarCl() { this.router.navigate(['editarCl']); }

  // empleados
  listarE() { this.router.navigate(['listarE']); }
  guardarE() { this.router.navigate(['guardarE']); }
  editarE() { this.router.navigate(['editarE']); }

  // proveedor
  listarPR() { this.router.navigate(['listarPR']); }
  guardarPR() { this.router.navigate(['guardarPR']); }
  editarPR() { this.router.navigate(['editarPR']); }

  // ventas
  listarV() { this.router.navigate(['listarV']); }
  guardarV() { this.router.navigate(['guardarV']); }
  editarV() { this.router.navigate(['editarV']); }
}
