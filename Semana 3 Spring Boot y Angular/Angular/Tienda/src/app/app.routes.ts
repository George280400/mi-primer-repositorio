import { Routes } from '@angular/router';
import { ListarProductos } from './Componente/Producto/listar-productos/listar-productos';
import { EditarProductos } from './Componente/Producto/editar-productos/editar-productos';
import { GuardarProductos } from './Componente/Producto/guardar-productos/guardar-productos';
import { PaginaPrincipal } from './Componente/Main/pagina-principal/pagina-principal';
import { ListarCategoria } from './Componente/Categoria/listar-categoria/listar-categoria';
import { GuardarCategoria } from './Componente/Categoria/guardar-categoria/guardar-categoria';
import { EditarCategoria } from './Componente/Categoria/editar-categoria/editar-categoria';
import { ListarClientes } from './Componente/Clientes/listar-clientes/listar-clientes';
import { GuardarClientes } from './Componente/Clientes/guardar-clientes/guardar-clientes';
import { EditarClientes } from './Componente/Clientes/editar-clientes/editar-clientes';
import { ListarEmpleados } from './Componente/Empleados/listar-empleados/listar-empleados';
import { GuardarEmpleados } from './Componente/Empleados/guardar-empleados/guardar-empleados';
import { EditarEmpleados } from './Componente/Empleados/editar-empleados/editar-empleados';
import { ListarProveedor } from './Componente/Proveedor/listar-proveedor/listar-proveedor';
import { GuardarProveedor } from './Componente/Proveedor/guardar-proveedor/guardar-proveedor';
import { EditarProveedor } from './Componente/Proveedor/editar-proveedor/editar-proveedor';
import { ListarVentas } from './Componente/Ventas/listar-ventas/listar-ventas';
import { GuardarVentas } from './Componente/Ventas/guardar-ventas/guardar-ventas';
import { EditarVentas } from './Componente/Ventas/editar-ventas/editar-ventas';
export const routes: Routes = [

    //pagina principal
    {path: 'paginaP', component : PaginaPrincipal },


    //productos
    {path: 'listarP', component : ListarProductos},
    {path: 'guardarP', component : GuardarProductos},
    {path: 'editarP', component : EditarProductos },
    

    //categorias
    {path: 'listarC', component : ListarCategoria},
    {path: 'guardarC', component : GuardarCategoria},
    {path: 'editarC', component : EditarCategoria },

    //clientes
    {path: 'listarCl', component : ListarClientes},
    {path: 'guardarCl', component : GuardarClientes},
    {path: 'editarCl', component : EditarClientes },

    //empleados
    {path: 'listarE', component : ListarEmpleados},
    {path: 'guardarE', component : GuardarEmpleados},
    {path: 'editarE', component : EditarEmpleados},

    //proveedor
    {path: 'listarPR', component : ListarProveedor},
    {path: 'guardarPR', component : GuardarProveedor},
    {path: 'editarPR', component : EditarProveedor},

    //ventas
    {path: 'listarV', component : ListarVentas},
    {path: 'guardarV', component : GuardarVentas},
    {path: 'editarV', component : EditarVentas}
];
