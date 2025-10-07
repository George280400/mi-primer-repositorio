import { Cliente } from "./Cliente";

// declaración de la clase Venta
export class Venta {
    idVenta!: number;
    fecha!: string;        // se puede manejar como string o Date
    clienteId!: number;
    total!: number;
    metodoPago!: string;
    empleadoId!: number;
    codigoBarras!: number;
}
