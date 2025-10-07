import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('CajeroApp');

  //constructor para inicializar el router
  constructor(private router : Router){}

  //funcion para navegar a los componentes

  guardarR(){
    this.router.navigate(['guardarR'])
  }
}
