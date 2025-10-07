import { Component } from '@angular/core';
import { ServiceWS } from '../../Service/service-ws';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cajero',
  imports: [CommonModule,FormsModule],
  templateUrl: './cajero.html',
  styleUrl: './cajero.css'
})
export class Cajero {

  monto: number = 0;  //monto a retirar
  resultado: any = null; //guarda el desglose del retiro
  errorMsg: string = ''; //para guardar mensaje de error


 // Inyecta el servicio para llamar al backend
  constructor(private service: ServiceWS) {}
//metodo para retirar
  retirar() {
    this.errorMsg = '';  //se limpia el error anterior
    this.resultado = null; // se limpia el resultado anterior

    //se manda a llamar al servicio retirar
    this.service.retirar(this.monto).subscribe({
      next: (res) => {
        //se guarda ek desglose
        this.resultado = res;
      },
      error: (err) => {
        this.errorMsg = err.error?.error || err.error || 'Error en el retiro';
      }
    });
  }

}
