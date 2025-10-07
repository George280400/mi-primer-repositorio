package com.mx.Empleados.Service;

import java.util.List;


import com.mx.Empleados.Entity.Empleado;

public interface IEmpleadoService {
	
	public void guardar(Empleado empleado);
	public void editar(Empleado empleado);
	public Empleado buscar(int idEmpleado);
	public void eliminar(int idEmpleado);
	public List<Empleado> listar();

}
