import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-pagina-principal',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './pagina-principal.html',
  styleUrl: './pagina-principal.css'
})
export class PaginaPrincipal {

  //constructor para inicializar el router
  constructor(private router : Router){}

  listarP(){
    this.router.navigate(['listarP'])
  }

}
