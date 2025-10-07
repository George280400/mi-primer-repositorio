import { Routes } from '@angular/router';
import { PaginaPrincipal } from './Componente/Main/pagina-principal/pagina-principal';
import { ListarMascotas } from './Componente/Mascotas/listar-mascotas/listar-mascotas';
import { GuardarMascotas } from './Componente/Mascotas/guardar-mascotas/guardar-mascotas';
import { EditarMascotas } from './Componente/Mascotas/editar-mascotas/editar-mascotas';
import { ListarResponsables } from './Componente/Responsables/listar-responsables/listar-responsables';
import { GuardarResponsables } from './Componente/Responsables/guardar-responsables/guardar-responsables';
import { EditarResponsables } from './Componente/Responsables/editar-responsables/editar-responsables';
import { ListarClientes } from './Componente/Clientes/listar-clientes/listar-clientes';
import { GuardarClientes } from './Componente/Clientes/guardar-clientes/guardar-clientes';
import { EditarClientes } from './Componente/Clientes/editar-clientes/editar-clientes';
import { ListarVeterinarias } from './Componente/Veterinarias/listar-veterinarias/listar-veterinarias';
import { GuardarVeterinarias } from './Componente/Veterinarias/guardar-veterinarias/guardar-veterinarias';
import { EditarVeterinarias } from './Componente/Veterinarias/editar-veterinarias/editar-veterinarias';

export const routes: Routes = [

     //pagina principal
    {path: 'paginaP', component : PaginaPrincipal },


    //mascotas
    {path: 'listarM', component : ListarMascotas},
    {path: 'guardarM', component : GuardarMascotas},
    {path: 'editarM', component : EditarMascotas },
    

    //responsables
    {path: 'listarR', component : ListarResponsables},
    {path: 'guardarR', component : GuardarResponsables},
    {path: 'editarR', component : EditarResponsables },

    //clientes
    {path: 'listarC', component : ListarClientes},
    {path: 'guardarC', component : GuardarClientes},
    {path: 'editarC', component : EditarClientes },

    //veterinarias
    {path: 'listarV', component : ListarVeterinarias},
    {path: 'guardarV', component : GuardarVeterinarias},
    {path: 'editarV', component : EditarVeterinarias},



];
