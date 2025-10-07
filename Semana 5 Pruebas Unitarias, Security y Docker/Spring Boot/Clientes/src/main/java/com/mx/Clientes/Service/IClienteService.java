package com.mx.Clientes.Service;

import java.util.List;

import com.mx.Clientes.Entity.Cliente;

public interface IClienteService {
	
	public void guardar(Cliente cliente);
	public void editar(Cliente cliente);
	public void eliminar(int idCliente);
	public Cliente buscar(int idCliente);
	public List<Cliente> listar();

}
