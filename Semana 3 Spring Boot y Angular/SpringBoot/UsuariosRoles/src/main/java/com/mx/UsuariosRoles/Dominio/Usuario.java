package com.mx.UsuariosRoles.Dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table

public class Usuario {
	
	@Id
	private int idUsuario;
	@NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[A-Za-z]+$", message = "El nombre solo puede contener letras")
	private String nombre;
	@NotBlank(message = "El apellido paterno es obligatorio")
	@Pattern(regexp = "^[A-Za-z]+$", message = "El apellido paterno solo puede contener letras")
	private String app;
	@NotBlank(message = "El apellido materno es obligatorio")
    @Pattern(regexp = "^[A-Za-z]+$", message = "El apellido materno solo puede contener letras")
	private String apm;
	@NotBlank(message = "El sexo es obligatorio")
	private String sexo;
	private String correo;
	private Date fechaNacimiento;
	private Date fechaCreacion;
	@ManyToOne(fetch = FetchType.EAGER) //usuario tiene un unico rol
	@JoinColumn(name = "ROL_ID")
	private Rol rolId;
	
	 // metodo para ver si es mayor de edad
    public boolean esMayorDeEdad() {
        LocalDate nacimiento = fechaNacimiento.toLocalDate();
        return Period.between(nacimiento, LocalDate.now()).getYears() >= 18;
    }

    // metodo para generar el correo
    public void generarCorreo() {
        this.correo = this.nombre.toLowerCase() + "." + this.app.toLowerCase() + "@enucom.com.mx";
    }
	
	public Usuario() {
		
	}

	public Usuario(int idUsuario, String nombre, String app, String apm, String sexo, String correo,
			Date fechaNacimiento, Date fechaCreacion, Rol rolId) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.sexo = sexo;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.rolId = rolId;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Rol getRolId() {
		return rolId;
	}

	public void setRolId(Rol rolId) {
		this.rolId = rolId;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", sexo="
				+ sexo + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", fechaCreacion="
				+ fechaCreacion + ", rolId=" + rolId + "]";
	}
	
	

}
