import { Component, signal } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('VeterinariaApp');

  //constructor para inicializar el router
  constructor(private router: Router) { }

  //funciones para navegar a los componentes

  //para navegar a la pantalla principal
  paginaP() { this.router.navigate(['paginaP']) }

  // mascotas
  listarM() { this.router.navigate(['listarM']); }
  guardarM() { this.router.navigate(['guardarM']); }
  editarM() { this.router.navigate(['editarM']); }

  // responsables
  listarR() { this.router.navigate(['listarR']); }
  guardarR() { this.router.navigate(['guardarR']); }
  editarR() { this.router.navigate(['editarR']); }

  // clientes
  listarC() { this.router.navigate(['listarC']); }
  guardarC() { this.router.navigate(['guardarC']); }
  editarC() { this.router.navigate(['editarC']); }

  // veterinarias
  listarV() { this.router.navigate(['listarV']); }
  guardarV() { this.router.navigate(['guardarV']); }
  editarV() { this.router.navigate(['editarV']); }
}
