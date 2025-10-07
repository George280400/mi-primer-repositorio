// declaración de la clase Mascota
export class Mascota {
    idMascota!: number;
    nombre!: string;
    raza!: string;
    edad!: number;
    razonCita!: string;

    clienteId!: number;
    nombreCliente?: string;

    responsableId!: number;
    nombreResponsable?: string;
}