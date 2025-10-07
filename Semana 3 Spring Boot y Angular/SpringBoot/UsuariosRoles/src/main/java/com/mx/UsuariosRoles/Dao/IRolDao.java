package com.mx.UsuariosRoles.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.UsuariosRoles.Dominio.Rol;



public interface IRolDao extends JpaRepository<Rol, Integer>{

}
