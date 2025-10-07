package com.mx.UsuariosRoles.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.UsuariosRoles.Dominio.Usuario;


public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

	boolean existsByNombreAndApp(String nombre, String app);
}
