package com.mx.UsuariosRoles.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.UsuariosRoles.Dao.IUsuarioDao;
import com.mx.UsuariosRoles.Dominio.Usuario;


@Service
public class UsuarioServiceImp implements IUsuarioService{
	
	@Autowired
	private IUsuarioDao dao;

	@Override
	public void guardar(Usuario usuario) {
	    // Validar si ya existe el idusuario
	    if (dao.existsById(usuario.getIdUsuario())) {
	        throw new RuntimeException("El ID de usuario ya existe");
	    }

	    // validar duplicados por nombre y apellido paterno
	    if (existeUsuario(usuario.getNombre(), usuario.getApp())) {
	        throw new RuntimeException("El usuario ya está registrado");
	    }

	    // validar si es mayor de edad
	    if (!usuario.esMayorDeEdad()) {
	        throw new RuntimeException("El usuario debe ser mayor de 18 años");
	    }

	    // generar correo de forma automatica
	    usuario.generarCorreo();

	    dao.save(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
        if (!usuario.esMayorDeEdad()) {
            throw new RuntimeException("El usuario debe ser mayor de 18 años");
        }
        usuario.generarCorreo();
        dao.save(usuario);
    }

	@Override
	public void eliminar(int idUsuario) {
		
		dao.deleteById(idUsuario);
	}

	@Override
	public Usuario buscar(int idUsuario) {
		
		return dao.findById(idUsuario).orElse(null);
	}

	@Override
	public List<Usuario> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idUsuario"));
	}

	@Override
	public boolean existeUsuario(String nombre, String app) {
		
		return dao.existsByNombreAndApp(nombre, app);
	}

}
