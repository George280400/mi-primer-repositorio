package com.mx.Empleados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empleados.Entity.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Integer>{

	boolean existsByNombreIgnoreCaseAndApellidoIgnoreCase(String nombre, String apellido);
	
	public boolean existsByTelefono(Long telefono);
}
