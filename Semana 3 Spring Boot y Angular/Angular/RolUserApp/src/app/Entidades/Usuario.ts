import { Rol } from "./Rol";

export class Usuario {
  idUsuario!: number;
  nombre!: String;
  app!: String;
  apm!: String;
  sexo!: String;
  correo!: String;
  fechaNacimiento!: Date;
  fechaCreacion!: Date;
  rolId!: Rol;
}
     