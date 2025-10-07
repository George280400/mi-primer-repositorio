package com.mx.UsuariosRoles.Service;

import java.util.List;

import com.mx.UsuariosRoles.Dominio.Usuario;

public interface IUsuarioService {
	
	public void guardar(Usuario usuario);
	public void editar(Usuario usuario);
	public void eliminar(int idUsuario);
	public Usuario buscar(int idUsuario);
	public List<Usuario> listar();
	boolean existeUsuario(String nombre, String app);

}
