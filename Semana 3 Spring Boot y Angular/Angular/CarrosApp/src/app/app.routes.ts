import { Routes } from '@angular/router';
import { ListarCarros } from './Componente/listar-carros/listar-carros';
import { GuardarCarros } from './Componente/guardar-carros/guardar-carros';
import { EditarCarros } from './Componente/editar-carros/editar-carros';

export const routes: Routes = [
    {path: 'listarC', component : ListarCarros},
    {path: 'guardarC', component : GuardarCarros},
    {path: 'editarC', component : EditarCarros}
];
