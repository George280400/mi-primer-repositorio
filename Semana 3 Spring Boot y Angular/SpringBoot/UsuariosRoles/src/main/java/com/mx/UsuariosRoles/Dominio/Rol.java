package com.mx.UsuariosRoles.Dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table

public class Rol {
	
	@Id
	private int idRol;
	private String privilegio;
	@OneToMany(mappedBy = "rolId", cascade = CascadeType.ALL) //un rol puede tenr muchos usuarios
	List<Usuario> list = new ArrayList<>();
	
	public Rol() {
		
	}

	public Rol(int idRol, String privilegio) {
		super();
		this.idRol = idRol;
		this.privilegio = privilegio;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", privilegio=" + privilegio + "]";
	}
	
	

}
