import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { sha512 } from 'js-sha512';

@Component({
  selector: 'app-sha',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './sha.html',
  styleUrls: ['./sha.css']
})
export class Sha {
  operacion = '';
  importe = '';
  cliente = '';

  constructor(private http: HttpClient) {}

  enviar() {
    const sha = sha512(this.operacion + this.importe + this.cliente);
    const request = { operacion: this.operacion, importe: this.importe, cliente: this.cliente, sha };

    this.http.post('http://localhost:8080/api1/procesar', request)
      .subscribe({
        next: (res) => alert('Transacción exitosa: ' + JSON.stringify(res)),
        error: (err) => alert('Error: ' + err.error)
      });
  }
}
