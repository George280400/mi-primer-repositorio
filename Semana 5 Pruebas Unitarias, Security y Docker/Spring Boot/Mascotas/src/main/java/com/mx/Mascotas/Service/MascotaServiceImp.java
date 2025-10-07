package com.mx.Mascotas.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Mascotas.DTOs.ClienteDTO;
import com.mx.Mascotas.DTOs.MascotaResponse;
import com.mx.Mascotas.DTOs.ResponsableDTO;
import com.mx.Mascotas.Entity.Mascotas;
import com.mx.Mascotas.FeignClient.ClienteFeign;
import com.mx.Mascotas.FeignClient.ResponsableFeign;
import com.mx.Mascotas.Repository.IMascotasRepository;
@Service
public class MascotaServiceImp implements IMascotasService{
	
	
	@Autowired
	private IMascotasRepository dao;
	
	@Autowired
    private ClienteFeign clienteFC;

    @Autowired
    private ResponsableFeign responsableFC;

	@Override
	public void guardar(Mascotas mascotas) {
		
		dao.save(mascotas);
	}

	@Override
	public void editar(Mascotas mascotas) {
		
		dao.save(mascotas);
	}

	@Override
	public void eliminar(int idMascota) {
		
		dao.deleteById(idMascota);
	}

	@Override
	public Mascotas buscar(int idMascota) {
		
		return dao.findById(idMascota).orElse(null);
	}

	@Override
	public List<Mascotas> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	 public List<MascotaResponse> listarTodasMascotas() {

	        List<Mascotas> mascotas = dao.findAll();

	        return mascotas.stream().map(m -> {
	            MascotaResponse dto = new MascotaResponse();
	            dto.setIdMascota(m.getIdMascota());
	            dto.setNombre(m.getNombre());
	            dto.setRaza(m.getRaza());
	            dto.setEdad(m.getEdad());
	            dto.setRazonCita(m.getRazonCita());

	            try {
	                ClienteDTO cliente = clienteFC.buscar(m.getClienteId());
	                dto.setClienteId(cliente.getIdCliente());
	                dto.setNombreCliente(cliente.getNombre());
	            } catch (Exception e) {
	                dto.setClienteId(m.getClienteId());
	                dto.setNombreCliente("Cliente no encontrado");
	            }

	            try {
	                ResponsableDTO responsable = responsableFC.buscar(m.getResponsableId());
	                dto.setResponsableId(responsable.getIdResponsable());
	                dto.setNombreResponsable(responsable.getNombre());
	            } catch (Exception e) {
	                dto.setResponsableId(m.getResponsableId());
	                dto.setNombreResponsable("Responsable no encontrado");
	            }

	            return dto;
	        }).collect(Collectors.toList());
	    }

}
