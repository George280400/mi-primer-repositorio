package com.mx.Empleados.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Empleados.Entity.Empleado;
import com.mx.Empleados.Repository.IEmpleadoDao;
@Service
public class EmpleadoServiceImp implements IEmpleadoService{
@Autowired

private IEmpleadoDao dao;
	@Override
	public void guardar(Empleado empleado) {
		
		dao.save(empleado);
	}

	@Override
	public void editar(Empleado empleado) {
		dao.save(empleado);
		
	}

	@Override
	public Empleado buscar(int idEmpleado) {
		return dao.findById(idEmpleado).orElse(null);
	}

	@Override
	public void eliminar(int idEmpleado) {
		dao.deleteById(idEmpleado);
		
	}

	@Override
	public List<Empleado> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	public boolean existeEmpleado(String nombre, String apellido) {
		return dao.existsByNombreIgnoreCaseAndApellidoIgnoreCase(nombre, apellido);
	}
	
	public boolean existeTelefono(Long telefono) {
			return dao.existsByTelefono(telefono);
	}

}
